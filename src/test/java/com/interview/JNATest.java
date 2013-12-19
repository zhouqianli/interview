package com.interview;


import com.sun.jna.platform.win32.Advapi32Util;
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

    public void addAndRemoveKey() throws Exception {
        Advapi32Util.registryCreateKey(
                WinReg.HKEY_CURRENT_USER, STARTUP,
                CHINESE);
        Advapi32Util.registrySetIntValue(
                WinReg.HKEY_CURRENT_USER, STARTUP + "\\" + CHINESE,
                INT_VALUE, BORN);
        int year = getIntValueByKey(CHINESE);
        Assert.assertEquals(year, BORN);
        Advapi32Util.registryDeleteKey(
                WinReg.HKEY_CURRENT_USER, STARTUP,
                CHINESE);
        Assert.assertFalse(isKeyExist(STARTUP + "\\" + CHINESE));
    }

    public void addAndRemoveValue() throws Exception {
        Advapi32Util.registrySetStringValue(
                WinReg.HKEY_CURRENT_USER, STARTUP, CHINESE,
                String.valueOf(BORN));
        String year = getStringValueByKey(CHINESE);
        Assert.assertEquals(year, String.valueOf(BORN));
        Advapi32Util.registryDeleteValue(
                WinReg.HKEY_CURRENT_USER, STARTUP,
                CHINESE);
        Assert.assertFalse(isValueExist(STARTUP , CHINESE));
    }

    private boolean isKeyExist(String key) {
        return Advapi32Util.registryKeyExists(WinReg.HKEY_CURRENT_USER,
                key);
    }

    private boolean isValueExist(String key, String value) {
        return Advapi32Util.registryValueExists(WinReg.HKEY_CURRENT_USER,
                key, value);
    }

    private int getIntValueByKey(String CHINESE) {
        return Advapi32Util.registryGetIntValue(
                WinReg.HKEY_CURRENT_USER,
                STARTUP + "\\" + CHINESE,
                INT_VALUE);
    }

    private String getStringValueByKey(String CHINESE) {
        return Advapi32Util.registryGetStringValue(
                WinReg.HKEY_CURRENT_USER,
                STARTUP,
                CHINESE);
    }
}
