package com.c.a.a.d;

import d.k;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

final class g {
    private static final e[] a = new e[]{new e(e.e, ""), new e(e.b, "GET"), new e(e.b, "POST"), new e(e.c, "/"), new e(e.c, "/index.html"), new e(e.d, "http"), new e(e.d, "https"), new e(e.a, "200"), new e(e.a, "204"), new e(e.a, "206"), new e(e.a, "304"), new e(e.a, "400"), new e(e.a, "404"), new e(e.a, "500"), new e("accept-charset", ""), new e("accept-encoding", "gzip, deflate"), new e("accept-language", ""), new e("accept-ranges", ""), new e("accept", ""), new e("access-control-allow-origin", ""), new e("age", ""), new e("allow", ""), new e("authorization", ""), new e("cache-control", ""), new e("content-disposition", ""), new e("content-encoding", ""), new e("content-language", ""), new e("content-length", ""), new e("content-location", ""), new e("content-range", ""), new e("content-type", ""), new e("cookie", ""), new e("date", ""), new e("etag", ""), new e("expect", ""), new e("expires", ""), new e("from", ""), new e("host", ""), new e("if-match", ""), new e("if-modified-since", ""), new e("if-none-match", ""), new e("if-range", ""), new e("if-unmodified-since", ""), new e("last-modified", ""), new e("link", ""), new e("location", ""), new e("max-forwards", ""), new e("proxy-authenticate", ""), new e("proxy-authorization", ""), new e("range", ""), new e("referer", ""), new e("refresh", ""), new e("retry-after", ""), new e("server", ""), new e("set-cookie", ""), new e("strict-transport-security", ""), new e("transfer-encoding", ""), new e("user-agent", ""), new e("vary", ""), new e("via", ""), new e("www-authenticate", "")};
    private static final Map b;

    static {
        int i = 0;
        Map linkedHashMap = new LinkedHashMap(a.length);
        while (i < a.length) {
            if (!linkedHashMap.containsKey(a[i].h)) {
                linkedHashMap.put(a[i].h, Integer.valueOf(i));
            }
            i++;
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    static /* synthetic */ k a(k kVar) {
        int i = 0;
        int length = kVar.c.length;
        while (i < length) {
            byte b = kVar.c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + kVar.a());
            }
        }
        return kVar;
    }
}
