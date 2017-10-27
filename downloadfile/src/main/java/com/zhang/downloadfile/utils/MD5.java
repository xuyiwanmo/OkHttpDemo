package com.zhang.downloadfile.utils;

import android.text.TextUtils;

import java.security.MessageDigest;

/**
 * Created by 德医互联 on 2017/10/26.
 */

public class MD5 {
    public static String generateCode(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(url.getBytes());
            byte[] cipher = md5.digest();

            for (byte b : cipher) {
                String hexStr = Integer.toHexString(b & 0xff);
                buffer.append(hexStr.length() == 1 ? "0" + hexStr : hexStr);
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return buffer.toString();

    }

}
