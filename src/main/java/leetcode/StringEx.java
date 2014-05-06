package leetcode;

/**
 * @author zhouzh on 5/6/2014.
 *         http://leetcode.com/category/string
 */
public class StringEx {
    /**
     * Write C code to implement the strstr (Search for a substring) function. Do not use any system library such as strlen.
     * The strstr function locates a specified substring within a source string.
     * Strstr returns a pointer to the first occurrence of the substring in the source.
     * If the substring is not found, strstr returns a null pointer.
     * 在Java中必须使用length成员来获取数组长度。String的内部维护了一个value就是一个char数组
     *
     * @return an index of first substring location, -1 for not found
     * @see <a>http://leetcode.com/2010/10/implement-strstr-to-find-substring-in.html</a>
     */
    public static int strstr(char[] source, char[] target) {
        final int NOT_FOUND = -1;
        if (source == null || source.length == 0 || target == null || target.length == 0)
            return NOT_FOUND;
        for (int i = 0; i < source.length - target.length + 1; i++) {
            int temp = i;
            for (int j = 0; source[temp] == target[j] && j < target.length; j++, temp++)
                if (j + 1 == target.length)
                    return i;
        }
        return NOT_FOUND;
    }

}
