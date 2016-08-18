package com.c.a.a.d;

import d.j;
import d.k;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

final class aa implements b {
    private final j a;
    private final boolean b;
    private final s c = new s(this.a);

    aa(j jVar, boolean z) {
        this.a = jVar;
        this.b = z;
    }

    private static IOException a(String str, Object... objArr) {
        throw new IOException(String.format(str, objArr));
    }

    private void a(c cVar, int i, int i2) {
        boolean z = false;
        int i3 = this.a.i();
        if (i2 != (i3 * 8) + 4) {
            throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        y yVar = new y();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.a.i();
            yVar.a(16777215 & i5, (i5 & -16777216) >>> 24, this.a.i());
        }
        if ((i & 1) != 0) {
            z = true;
        }
        cVar.a(z, yVar);
    }

    public final void a() {
    }

    public final boolean a(c cVar) {
        boolean z = false;
        try {
            int i = this.a.i();
            int i2 = this.a.i();
            int i3 = (-16777216 & i2) >>> 24;
            int i4 = 16777215 & i2;
            if ((Integer.MIN_VALUE & i) != 0) {
                int i5 = (2147418112 & i) >>> 16;
                if (i5 != 3) {
                    throw new ProtocolException("version != 3: " + i5);
                }
                switch (65535 & i) {
                    case 1:
                        i5 = this.a.i();
                        this.a.i();
                        this.a.h();
                        List a = this.c.a(i4 - 10);
                        boolean z2 = (i3 & 1) != 0;
                        if ((i3 & 2) != 0) {
                            z = true;
                        }
                        cVar.a(z, z2, i5 & Integer.MAX_VALUE, a, f.SPDY_SYN_STREAM);
                        return true;
                    case 2:
                        cVar.a(false, (i3 & 1) != 0, this.a.i() & Integer.MAX_VALUE, this.c.a(i4 - 4), f.SPDY_REPLY);
                        return true;
                    case 3:
                        if (i4 != 8) {
                            throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i4));
                        }
                        i5 = this.a.i();
                        a a2 = a.a(this.a.i());
                        if (a2 == null) {
                            throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i));
                        }
                        cVar.a(i5 & Integer.MAX_VALUE, a2);
                        return true;
                    case 4:
                        a(cVar, i3, i4);
                        return true;
                    case 6:
                        if (i4 != 4) {
                            throw a("TYPE_PING length: %d != 4", Integer.valueOf(i4));
                        }
                        i = this.a.i();
                        cVar.a(this.b == ((i & 1) == 1), i, 0);
                        return true;
                    case 7:
                        if (i4 != 8) {
                            throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i4));
                        }
                        i5 = this.a.i();
                        if (a.c(this.a.i()) == null) {
                            throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(this.a.i()));
                        }
                        cVar.a(i5 & Integer.MAX_VALUE, k.b);
                        return true;
                    case 8:
                        cVar.a(false, false, this.a.i() & Integer.MAX_VALUE, this.c.a(i4 - 4), f.SPDY_HEADERS);
                        return true;
                    case 9:
                        if (i4 != 8) {
                            throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i4));
                        }
                        i5 = this.a.i();
                        long i6 = (long) (this.a.i() & Integer.MAX_VALUE);
                        if (i6 == 0) {
                            throw a("windowSizeIncrement was 0", Long.valueOf(i6));
                        }
                        cVar.a(i5 & Integer.MAX_VALUE, i6);
                        return true;
                    default:
                        this.a.f((long) i4);
                        return true;
                }
            }
            if ((i3 & 1) != 0) {
                z = true;
            }
            cVar.a(z, i & Integer.MAX_VALUE, this.a, i4);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public final void close() {
        this.c.b.close();
    }
}
