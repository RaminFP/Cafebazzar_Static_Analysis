package com.c.a.a.d;

import d.i;
import d.k;
import java.io.IOException;
import java.util.logging.Logger;

public final class j implements as {
    private static final Logger a = Logger.getLogger(l.class.getName());
    private static final k b = k.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    static /* synthetic */ int a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    static /* synthetic */ void a(i iVar, int i) {
        iVar.h((i >>> 16) & 255);
        iVar.h((i >>> 8) & 255);
        iVar.h(i & 255);
    }

    static /* synthetic */ IllegalArgumentException b(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException c(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    public final b a(d.j jVar, boolean z) {
        return new m(jVar, 4096, z);
    }

    public final d a(i iVar, boolean z) {
        return new n(iVar, z);
    }
}
