package com.keboda.eomsback.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * flux系密码修改工具,得到加密字符串手动覆盖数据库
 */
public class FluxPwdUtils {

    private final static String username = "JX2302304";

    private final static String password = "123456789";

    private final static String passwordSalt = "ST1693902153464SR125120095072037007";

    public static String MD5Signature() throws Exception{

        String token = passwordSalt+"userPassword"+changeToAa(username) + "~" + password+passwordSalt;

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(token.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        String stmp;

        for (byte aByte : bytes) {
            stmp = Integer.toHexString(aByte & 255);
            if (stmp.length() == 1) {
                hexString.append("0").append(stmp);
            } else {
                hexString.append(stmp);
            }
        }

        return hexString.toString().toUpperCase();
    }

    public static String changeToAa(String strValue) {
        String newStrValue = null;
        if (strValue != null) {
            char[] strValueChars = strValue.toCharArray();
            char[] newStrValueChars = new char[strValueChars.length];
            int i = 0;
            int diffVal = 32;
            int countTmp = 0;
            for(int j = strValueChars.length - 1; j >= 0; --j) {
                char charTmp = strValueChars[j];
                if (charTmp >= 'A' && charTmp <= 'Z') {
                    charTmp = (char)(charTmp + diffVal);
                }
                if (charTmp >= 'a' && charTmp <= 'z') {
                    ++countTmp;
                    if (countTmp % 2 == 1) {
                        charTmp = (char)(charTmp - diffVal);
                    }
                }
                newStrValueChars[i] = charTmp;
                ++i;
            }
            newStrValue = new String(newStrValueChars);
        }
        return newStrValue;
    }
}
