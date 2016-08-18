package com.c.a.a.a;

import com.c.a.ak;
import java.net.URL;

public final class y {
    public static String a(ak akVar) {
        return akVar == ak.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
    }

    public static String a(URL url) {
        String file = url.getFile();
        return file == null ? "/" : !file.startsWith("/") ? "/" + file : file;
    }
}
