package com.interview.benchmarks;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;


/**
 * Created by zhouzh on 1/24/14.
 */
@Test
public class StringVsJSON {

    private final static int COUNT = 1000;

    private JsonFactory jsonFactory = new JsonFactory();

    private static final String inputString = "y7vX7jZhzQ-- 1390058421 http://www.yahoo.com/?ilc=1 tv.yahoo.com/blogs/tv-news/this-touching-tale-about-john-schneider-will-make-you-cry-212920676.html -- pageview";
    private static final String inputJson = "{\"sid\":\"y7vX7jZhzQ--\",\"timestamp\":\"1390058421\",\"url\":\"http://www.yahoo.com/?ilc=1 tv.yahoo.com/blogs/tv-news/this-touching-tale-about-john-schneider-will-make-you-cry-212920676.html\",\"source\":\"--\",\"action\":\"pageview\"}";

    @BeforeClass(alwaysRun = true)
    void setup() throws Exception {
    }

    @Test(invocationCount = COUNT)
    public void testFromJsonKeyValue() throws IOException {
        try (JsonParser jp = jsonFactory.createParser(inputJson)) {
            UserRecord user = new UserRecord();
            jp.nextToken();
            while (jp.nextToken() != JsonToken.END_OBJECT) {
                String fieldname = jp.getCurrentName();
                jp.nextToken();
                switch (fieldname) {
                    case "sid":
                        user.setSid(jp.getText());
                        break;
                    case "timestamp":
                        user.setTimestamp(jp.getText());
                        break;
                    case "url":
                        user.setUrl(jp.getText());
                        break;
                    case "source":
                        user.setSource(jp.getText());
                        break;
                    case "action":
                        user.setAction(jp.getText());
                        break;
                    default:
                        throw new IllegalStateException("Not found filed type: " + fieldname);
                }
            }
        }
    }


    @Test(invocationCount = COUNT)
    public void testFromStringSplit() {
        String[] list = inputString.split(" ");
        UserRecord user = new UserRecord();
        user.setSid(list[0]);
        user.setTimestamp(list[1]);
        user.setUrl(list[2]);
        user.setSource(list[3]);
        user.setAction(list[4]);
    }

    @Test(invocationCount = COUNT)
    public void testFromJsonFile() throws Exception {
        try (JsonParser jp = jsonFactory.createParser(new File("input_json.txt"))) {
            UserRecord user = new UserRecord();
            jp.nextToken();
            while (jp.nextToken() != JsonToken.START_OBJECT) {
                String fieldname = jp.getCurrentName();
                jp.nextToken();
                switch (fieldname) {
                    case "sid":
                        user.setSid(jp.getText());
                        break;
                    case "timestamp":
                        user.setTimestamp(jp.getText());
                        break;
                    case "url":
                        user.setUrl(jp.getText());
                        break;
                    case "source":
                        user.setSource(jp.getText());
                        break;
                    case "action":
                        user.setAction(jp.getText());
                        break;
                    default:
                        throw new IllegalStateException("Not found filed type: " + fieldname);
                }
            }
        }
    }

    @Test(invocationCount = COUNT)
    public void testFromTextFile() throws Exception {
        try (FileInputStream fstream = new FileInputStream("input.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] list = strLine.split(" ");
                UserRecord user = new UserRecord();
                user.setSid(list[0]);
                user.setTimestamp(list[1]);
                user.setUrl(list[2]);
                user.setSource(list[3]);
                user.setAction(list[4]);
            }

        }
    }


    public static class UserRecord {

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        private String sid;
        private String timestamp;
        private String url;
        private String source;
        private String action;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }

}
