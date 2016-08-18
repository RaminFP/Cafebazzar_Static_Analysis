package com.c.a;

import d.e;
import d.k;
import java.io.UnsupportedEncodingException;

public final class w {
    public static String a(String str, String str2) {
        try {
            return "Basic " + e.a(k.a((str + ":" + str2).getBytes("ISO-8859-1")).c);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
