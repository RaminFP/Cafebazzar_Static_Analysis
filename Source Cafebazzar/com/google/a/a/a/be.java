package com.google.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

final class be implements o {
    private final String a;
    private final HttpClient b;
    private final Context c;
    private ap d;
    private URL e;

    be(HttpClient httpClient, Context context) {
        this(httpClient, ap.a(context), context);
    }

    private be(HttpClient httpClient, ap apVar, Context context) {
        this.c = context.getApplicationContext();
        this.a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", "3.0", VERSION.RELEASE, bi.a(Locale.getDefault()), Build.MODEL, Build.ID});
        this.b = httpClient;
        this.d = apVar;
    }

    private URL a(aq aqVar) {
        if (this.e != null) {
            return this.e;
        }
        try {
            return new URL("http:".equals(aqVar.d) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            as.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    private HttpEntityEnclosingRequest a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            as.d("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                as.d("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.a);
        return basicHttpEntityEnclosingRequest;
    }

    private static void a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                as.c("Error Writing hit to log...");
            }
        }
        as.c(stringBuffer.toString());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.List r15) {
        /*
        r14 = this;
        r2 = 0;
        r0 = r15.size();
        r1 = 40;
        r4 = java.lang.Math.min(r0, r1);
        r1 = 1;
        r0 = 0;
        r3 = r0;
    L_0x000e:
        if (r3 >= r4) goto L_0x013d;
    L_0x0010:
        r0 = r15.get(r3);
        r0 = (com.google.a.a.a.aq) r0;
        r5 = r14.a(r0);
        if (r5 != 0) goto L_0x0043;
    L_0x001c:
        r5 = com.google.a.a.a.as.a();
        if (r5 == 0) goto L_0x003d;
    L_0x0022:
        r5 = new java.lang.StringBuilder;
        r6 = "No destination: discarding hit: ";
        r5.<init>(r6);
        r0 = r0.a;
        r0 = r5.append(r0);
        r0 = r0.toString();
        com.google.a.a.a.as.d(r0);
    L_0x0036:
        r0 = r2 + 1;
    L_0x0038:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r0;
        goto L_0x000e;
    L_0x003d:
        r0 = "No destination: discarding hit.";
        com.google.a.a.a.as.d(r0);
        goto L_0x0036;
    L_0x0043:
        r6 = new org.apache.http.HttpHost;
        r7 = r5.getHost();
        r8 = r5.getPort();
        r9 = r5.getProtocol();
        r6.<init>(r7, r8, r9);
        r5 = r5.getPath();
        r7 = r0.a;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x006b;
    L_0x0060:
        r0 = "";
    L_0x0062:
        r5 = r14.a(r0, r5);
        if (r5 != 0) goto L_0x00a3;
    L_0x0068:
        r0 = r2 + 1;
        goto L_0x0038;
    L_0x006b:
        r8 = java.lang.System.currentTimeMillis();
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r10 = r0.a;
        r7.append(r10);
        r10 = r0.c;
        r12 = 0;
        r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r10 <= 0) goto L_0x0093;
    L_0x0081:
        r10 = r0.c;
        r8 = r8 - r10;
        r10 = 0;
        r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r10 < 0) goto L_0x0093;
    L_0x008a:
        r10 = "&qt=";
        r10 = r7.append(r10);
        r10.append(r8);
    L_0x0093:
        r8 = "&z=";
        r8 = r7.append(r8);
        r10 = r0.b;
        r8.append(r10);
        r0 = r7.toString();
        goto L_0x0062;
    L_0x00a3:
        r7 = "Host";
        r8 = r6.toHostString();
        r5.addHeader(r7, r8);
        r7 = com.google.a.a.a.as.a();
        if (r7 == 0) goto L_0x00b5;
    L_0x00b2:
        a(r5);
    L_0x00b5:
        r0 = r0.length();
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        if (r0 <= r7) goto L_0x00c6;
    L_0x00bd:
        r0 = "Hit too long (> 8192 bytes)--not sent";
        com.google.a.a.a.as.d(r0);
    L_0x00c2:
        r0 = r2 + 1;
        goto L_0x0038;
    L_0x00c6:
        r0 = r14.d;
        r0 = r0.b();
        if (r0 == 0) goto L_0x00d4;
    L_0x00ce:
        r0 = "Dry run enabled. Hit not actually sent.";
        com.google.a.a.a.as.b(r0);
        goto L_0x00c2;
    L_0x00d4:
        if (r1 == 0) goto L_0x00dc;
    L_0x00d6:
        r0 = r14.c;	 Catch:{ ClientProtocolException -> 0x013f, IOException -> 0x0119 }
        com.google.a.a.a.w.a(r0);	 Catch:{ ClientProtocolException -> 0x013f, IOException -> 0x0119 }
        r1 = 0;
    L_0x00dc:
        r0 = r14.b;	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r0 = r0.execute(r6, r5);	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r5 = r0.getStatusLine();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r5 = r5.getStatusCode();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r6 = r0.getEntity();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        if (r6 == 0) goto L_0x00f3;
    L_0x00f0:
        r6.consumeContent();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
    L_0x00f3:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r6) goto L_0x00c2;
    L_0x00f7:
        r5 = new java.lang.StringBuilder;	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r6 = "Bad response: ";
        r5.<init>(r6);	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r0 = r0.getStatusLine();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r0 = r0.getStatusCode();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r0 = r5.append(r0);	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        r0 = r0.toString();	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        com.google.a.a.a.as.d(r0);	 Catch:{ ClientProtocolException -> 0x0112, IOException -> 0x0119 }
        goto L_0x00c2;
    L_0x0112:
        r0 = move-exception;
    L_0x0113:
        r0 = "ClientProtocolException sending hit; discarding hit...";
        com.google.a.a.a.as.d(r0);
        goto L_0x00c2;
    L_0x0119:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r3 = "Exception sending hit: ";
        r1.<init>(r3);
        r3 = r0.getClass();
        r3 = r3.getSimpleName();
        r1 = r1.append(r3);
        r1 = r1.toString();
        com.google.a.a.a.as.d(r1);
        r0 = r0.getMessage();
        com.google.a.a.a.as.d(r0);
        r0 = r2;
    L_0x013c:
        return r0;
    L_0x013d:
        r0 = r2;
        goto L_0x013c;
    L_0x013f:
        r0 = move-exception;
        goto L_0x0113;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.be.a(java.util.List):int");
    }

    public final void a(String str) {
        try {
            this.e = new URL(str);
        } catch (MalformedURLException e) {
            this.e = null;
        }
    }

    public final boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        as.c("...no network connectivity");
        return false;
    }
}
