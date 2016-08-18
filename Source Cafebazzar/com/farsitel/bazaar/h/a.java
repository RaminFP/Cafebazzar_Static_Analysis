package com.farsitel.bazaar.h;

import com.android.a.a.f;
import com.android.a.a.i;
import com.android.a.j;
import com.android.a.o;
import com.android.a.v;
import com.android.a.w;
import com.android.a.y;
import com.android.a.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class a implements j {
    protected static final boolean a = z.b;
    private static int d = 3000;
    private static int e = 4096;
    protected final f b;
    protected final com.android.a.a.a c;

    public a(f fVar) {
        this(fVar, new com.android.a.a.a(e));
    }

    private a(f fVar, com.android.a.a.a aVar) {
        this.b = fVar;
        this.c = aVar;
    }

    private static Map a(Header[] headerArr) {
        Map hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }

    private static void a(String str, o oVar, y yVar) {
        v vVar = oVar.j;
        int f = oVar.f();
        try {
            vVar.a(yVar);
            oVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(f)}));
        } catch (y e) {
            oVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(f)}));
            throw e;
        }
    }

    private byte[] a(HttpEntity httpEntity) {
        i iVar = new i(this.c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new w();
            }
            bArr = this.c.a(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                iVar.write(bArr, 0, read);
            }
            byte[] toByteArray = iVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                z.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a(bArr);
            iVar.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.android.a.m a(com.android.a.o r18) {
        /*
        r17 = this;
        r8 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r5 = 0;
        r6 = new java.util.HashMap;
        r6.<init>();
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r0 = r18;
        r4 = r0.k;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        if (r4 == 0) goto L_0x0039;
    L_0x0016:
        r7 = r4.b;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        if (r7 == 0) goto L_0x0021;
    L_0x001a:
        r7 = "If-None-Match";
        r10 = r4.b;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r2.put(r7, r10);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
    L_0x0021:
        r10 = r4.c;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r12 = 0;
        r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r7 <= 0) goto L_0x0039;
    L_0x0029:
        r7 = "If-Modified-Since";
        r10 = new java.util.Date;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r12 = r4.c;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r10.<init>(r12);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r4 = org.apache.http.impl.cookie.DateUtils.formatDate(r10);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r2.put(r7, r4);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
    L_0x0039:
        r0 = r17;
        r4 = r0.b;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r0 = r18;
        r4 = r4.a(r0, r2);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0139 }
        r7 = r4.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0191 }
        r10 = r7.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0191 }
        r2 = r4.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0191 }
        r6 = a(r2);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0191 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r10 != r2) goto L_0x006f;
    L_0x0057:
        r0 = r18;
        r2 = r0.k;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        if (r2 != 0) goto L_0x0068;
    L_0x005d:
        r2 = 0;
    L_0x005e:
        r3 = new com.android.a.m;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        r7 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r10 = 1;
        r3.<init>(r7, r2, r6, r10);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        r2 = r3;
    L_0x0067:
        return r2;
    L_0x0068:
        r0 = r18;
        r2 = r0.k;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        r2 = r2.a;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        goto L_0x005e;
    L_0x006f:
        r2 = r4.getEntity();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        if (r2 == 0) goto L_0x00e1;
    L_0x0075:
        r2 = r4.getEntity();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        r0 = r17;
        r2 = r0.a(r2);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
    L_0x007f:
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r12 = r12 - r8;
        com.farsitel.bazaar.util.q.a(r12);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3 = a;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        if (r3 != 0) goto L_0x0092;
    L_0x008b:
        r3 = d;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r14 = (long) r3;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x00c8;
    L_0x0092:
        if (r2 == 0) goto L_0x018d;
    L_0x0094:
        r3 = r2.length;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
    L_0x0099:
        r5 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
        r11 = 5;
        r11 = new java.lang.Object[r11];	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r14 = 0;
        r11[r14] = r18;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r14 = 1;
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r11[r14] = r12;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r12 = 2;
        r11[r12] = r3;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3 = 3;
        r7 = r7.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r11[r3] = r7;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3 = 4;
        r0 = r18;
        r7 = r0.j;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r7 = r7.b();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r11[r3] = r7;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        com.android.a.z.b(r5, r11);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
    L_0x00c8:
        r3 = 529; // 0x211 float:7.41E-43 double:2.614E-321;
        if (r10 != r3) goto L_0x00e5;
    L_0x00cc:
        r3 = new com.farsitel.bazaar.h.b;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        throw r3;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
    L_0x00d2:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.android.a.x;
        r3.<init>();
        r0 = r18;
        a(r2, r0, r3);
        goto L_0x0004;
    L_0x00e1:
        r2 = 0;
        r2 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x0196 }
        goto L_0x007f;
    L_0x00e5:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 < r3) goto L_0x00ed;
    L_0x00e9:
        r3 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r10 <= r3) goto L_0x00fa;
    L_0x00ed:
        r3 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        throw r3;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
    L_0x00f3:
        r2 = move-exception;
        r2 = new com.farsitel.bazaar.h.h;
        r2.<init>();
        throw r2;
    L_0x00fa:
        r3 = new com.android.a.m;	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r5 = 0;
        r3.<init>(r10, r2, r6, r5);	 Catch:{ SocketTimeoutException -> 0x00d2, SSLHandshakeException -> 0x00f3, ConnectTimeoutException -> 0x0103, b -> 0x0112, MalformedURLException -> 0x011f, IOException -> 0x019b }
        r2 = r3;
        goto L_0x0067;
    L_0x0103:
        r2 = move-exception;
        r2 = "connection";
        r3 = new com.android.a.x;
        r3.<init>();
        r0 = r18;
        a(r2, r0, r3);
        goto L_0x0004;
    L_0x0112:
        r2 = move-exception;
        r2.printStackTrace();
        r3 = "decryption";
        r0 = r18;
        a(r3, r0, r2);
        goto L_0x0004;
    L_0x011f:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r4 = new java.lang.StringBuilder;
        r5 = "Bad URL ";
        r4.<init>(r5);
        r0 = r18;
        r5 = r0.b;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4, r2);
        throw r3;
    L_0x0139:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
    L_0x013c:
        if (r3 == 0) goto L_0x017a;
    L_0x013e:
        r2 = r3.getStatusLine();
        r2 = r2.getStatusCode();
        r3 = "Unexpected response code %d for %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r10 = java.lang.Integer.valueOf(r2);
        r6[r7] = r10;
        r7 = 1;
        r0 = r18;
        r10 = r0.b;
        r6[r7] = r10;
        com.android.a.z.c(r3, r6);
        if (r4 == 0) goto L_0x0186;
    L_0x015e:
        r3 = new com.android.a.m;
        r6 = 0;
        r3.<init>(r2, r4, r5, r6);
        r4 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 == r4) goto L_0x016c;
    L_0x0168:
        r4 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r2 != r4) goto L_0x0180;
    L_0x016c:
        r2 = "auth";
        r4 = new com.android.a.a;
        r4.<init>(r3);
        r0 = r18;
        a(r2, r0, r4);
        goto L_0x0004;
    L_0x017a:
        r3 = new com.android.a.n;
        r3.<init>(r2);
        throw r3;
    L_0x0180:
        r2 = new com.android.a.w;
        r2.<init>(r3);
        throw r2;
    L_0x0186:
        r2 = new com.android.a.l;
        r3 = 0;
        r2.<init>(r3);
        throw r2;
    L_0x018d:
        r3 = "null";
        goto L_0x0099;
    L_0x0191:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x013c;
    L_0x0196:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x013c;
    L_0x019b:
        r3 = move-exception;
        r5 = r6;
        r16 = r4;
        r4 = r2;
        r2 = r3;
        r3 = r16;
        goto L_0x013c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.farsitel.bazaar.h.a.a(com.android.a.o):com.android.a.m");
    }
}
