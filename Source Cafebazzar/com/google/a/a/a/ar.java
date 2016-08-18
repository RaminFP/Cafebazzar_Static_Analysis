package com.google.a.a.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class ar {
    static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }
}
