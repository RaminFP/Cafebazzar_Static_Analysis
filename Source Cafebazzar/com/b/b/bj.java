package com.b.b;

import java.io.Closeable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bj {
    private static final String a = bj.class.getSimpleName();

    public static String a(String str) {
        return str == null ? "" : str.length() > 255 ? str.substring(0, 255) : str;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes(), 0, str.length());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            ba.a(6, a, "Unsupported SHA1: " + e.getMessage());
            return null;
        }
    }
}
