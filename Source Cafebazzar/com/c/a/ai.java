package com.c.a;

import com.c.a.a.b.b;
import com.c.a.a.b.c;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class ai implements Cloneable, URLStreamHandlerFactory {
    private final ag a;

    public ai(ag agVar) {
        this.a = agVar;
    }

    public final HttpURLConnection a(URL url) {
        return a(url, this.a.c);
    }

    final HttpURLConnection a(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        ag a = this.a.a();
        a.c = proxy;
        if (protocol.equals("http")) {
            return new b(url, a);
        }
        if (protocol.equals("https")) {
            return new c(url, a);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public final /* synthetic */ Object clone() {
        return new ai(this.a.b());
    }

    public final URLStreamHandler createURLStreamHandler(String str) {
        return (str.equals("http") || str.equals("https")) ? new aj(this, str) : null;
    }
}
