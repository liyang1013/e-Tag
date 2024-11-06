package com.keboda.eomsback.utils;

public class StringUtils {


    /**
     * 格式化字符串为boolean
     *
     * @param str {string}
     * @return
     */
    public static Boolean formatBoolean(String str) {

        return str != null && str.equalsIgnoreCase("y");
    }

    /**
     * 对比数组格式字符串内容是否一直
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return
     */
    public static Boolean contrastStringArr(String s1, String s2) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";

        String[] a = s1.split(",");
        String[] b = s2.split(",");

        if (a.length != b.length) return false;

        for (String reg : a) {
            if (!containsSubstring(b, reg)) return false;
        }
        return true;
    }

    public static boolean containsSubstring(String[] array, String substring) {
        for (String str : array) {
            if (str.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
