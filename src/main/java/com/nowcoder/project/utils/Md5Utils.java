package com.nowcoder.project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Md5Utils {
    public static String next(String key){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(key.getBytes());
            return toHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String res = formatter.toString();
        formatter.close();

        return res;
    }
}
