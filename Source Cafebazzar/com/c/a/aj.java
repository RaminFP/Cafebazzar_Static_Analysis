package com.c.a;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

final class aj extends URLStreamHandler {
    final /* synthetic */ String a;
    final /* synthetic */ ai b;

    aj(ai aiVar, String str) {
        this.b = aiVar;
        this.a = str;
    }

    protected final int getDefaultPort() {
        if (this.a.equals("http")) {
            return 80;
        }
        if (this.a.equals("https")) {
            return 443;
        }
        throw new AssertionError();
    }

    protected final URLConnection openConnection(URL url) {
        return this.b.a(url);
    }

    protected final URLConnection openConnection(URL url, Proxy proxy) {
        return this.b.a(url, proxy);
    }
}
