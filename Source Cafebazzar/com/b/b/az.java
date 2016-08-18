package com.b.b;

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;

public final class az {
    private static SchemeRegistry a;

    static SchemeRegistry a() {
        SchemeRegistry schemeRegistry;
        synchronized (az.class) {
            try {
                if (a != null) {
                    schemeRegistry = a;
                } else {
                    schemeRegistry = new SchemeRegistry();
                    a = schemeRegistry;
                    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                    a.register(new Scheme("https", new ax(), 443));
                    schemeRegistry = a;
                }
            } catch (Throwable th) {
                Class cls = az.class;
            }
        }
        return schemeRegistry;
    }
}
