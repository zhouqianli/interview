package com.interview;


import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinReg;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by QianLi on 12/18/13.
 */
@Test
public class JNATest {
    static final String STARTUP = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
    static final int BORN = 1989;
    static final String INT_VALUE = "IntValue";
    static final String CHINESE = "张金晶出生";

    public void addAndRemoveStartupKey() throws Exception {
        Advapi32Util.registryCreateKey(
                WinReg.HKEY_CURRENT_USER, STARTUP,
                CHINESE);
        Advapi32Util.registrySetIntValue(
                WinReg.HKEY_CURRENT_USER, STARTUP + "\\" + CHINESE,
                INT_VALUE, BORN);
        int year = getValueByKey(CHINESE);
        Assert.assertEquals(year, BORN);
        Advapi32Util.registryDeleteKey(
                WinReg.HKEY_CURRENT_USER, STARTUP,
                CHINESE);
        try {
            getValueByKey(CHINESE);
        } catch (Win32Exception e) {
            Assert.assertEquals("The system cannot find the file specified.", e.getMessage());
        }

    }

    private int getValueByKey(String CHINESE) {
        return Advapi32Util.registryGetIntValue(
                WinReg.HKEY_CURRENT_USER,
                STARTUP + "\\" + CHINESE,
                INT_VALUE);
    }
}
