package com.c.b;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class bh implements v {
    static volatile Object a;
    private static final Object b = new Object();
    private static final ThreadLocal c = new bi();
    private final Context d;

    public bh(Context context) {
        this.d = context.getApplicationContext();
    }

    public final w a(Uri uri, int i) {
        if (VERSION.SDK_INT >= 14) {
            Context context = this.d;
            if (a == null) {
                try {
                    synchronized (b) {
                        if (a == null) {
                            File b = bj.b(context);
                            Object installed = HttpResponseCache.getInstalled();
                            if (installed == null) {
                                installed = HttpResponseCache.install(b, bj.a(b));
                            }
                            a = installed;
                        }
                    }
                } catch (IOException e) {
                }
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setUseCaches(true);
        if (i != 0) {
            String str;
            if (af.c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) c.get();
                stringBuilder.setLength(0);
                if (!af.a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!af.b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            httpURLConnection.setRequestProperty("Cache-Control", str);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 300) {
            httpURLConnection.disconnect();
            throw new x(responseCode + " " + httpURLConnection.getResponseMessage(), i, responseCode);
        }
        long headerFieldInt = (long) httpURLConnection.getHeaderFieldInt("Content-Length", -1);
        return new w(httpURLConnection.getInputStream(), bj.a(httpURLConnection.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }
}
