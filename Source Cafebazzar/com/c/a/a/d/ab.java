package com.c.a.a.d;

import com.c.a.a.v;
import d.f;
import d.i;
import d.k;
import d.l;
import d.r;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

final class ab implements d {
    private final i a;
    private final f b = new f();
    private final i c;
    private final boolean d;
    private boolean e;

    ab(i iVar, boolean z) {
        this.a = iVar;
        this.d = z;
        Deflater deflater = new Deflater();
        deflater.setDictionary(z.a);
        this.c = r.a(new l(this.b, deflater));
    }

    private void a(List list) {
        if (this.b.b != 0) {
            throw new IllegalStateException();
        }
        this.c.f(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k kVar = ((e) list.get(i)).h;
            this.c.f(kVar.c.length);
            this.c.b(kVar);
            kVar = ((e) list.get(i)).i;
            this.c.f(kVar.c.length);
            this.c.b(kVar);
        }
        this.c.flush();
    }

    public final void a() {
        synchronized (this) {
        }
    }

    public final void a(int i, long j) {
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.a.f(-2147287031);
                this.a.f(8);
                this.a.f(i);
                this.a.f((int) j);
                this.a.flush();
            }
        }
    }

    public final void a(int i, a aVar) {
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            } else if (aVar.t == -1) {
                throw new IllegalArgumentException();
            } else {
                this.a.f(-2147287037);
                this.a.f(8);
                this.a.f(Integer.MAX_VALUE & i);
                this.a.f(aVar.t);
                this.a.flush();
            }
        }
    }

    public final void a(int i, a aVar, byte[] bArr) {
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            } else if (aVar.u == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.a.f(-2147287033);
                this.a.f(8);
                this.a.f(i);
                this.a.f(aVar.u);
                this.a.flush();
            }
        }
    }

    public final void a(y yVar) {
    }

    public final void a(boolean z, int i, int i2) {
        boolean z2 = true;
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            if (this.d == ((i & 1) == 1)) {
                z2 = false;
            }
            if (z != z2) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.a.f(-2147287034);
            this.a.f(4);
            this.a.f(i);
            this.a.flush();
        }
    }

    public final void a(boolean z, int i, f fVar, int i2) {
        synchronized (this) {
            int i3 = z ? 1 : 0;
            if (this.e) {
                throw new IOException("closed");
            } else if (((long) i2) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i2);
            } else {
                this.a.f(Integer.MAX_VALUE & i);
                this.a.f(((i3 & 255) << 24) | (16777215 & i2));
                if (i2 > 0) {
                    this.a.a_(fVar, (long) i2);
                }
            }
        }
    }

    public final void a(boolean z, boolean z2, int i, int i2, List list) {
        int i3 = 0;
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            a(list);
            int i4 = (int) (10 + this.b.b);
            int i5 = z ? 1 : 0;
            if (z2) {
                i3 = 2;
            }
            this.a.f(-2147287039);
            this.a.f((((i3 | i5) & 255) << 24) | (16777215 & i4));
            this.a.f(i & Integer.MAX_VALUE);
            this.a.f(i2 & Integer.MAX_VALUE);
            this.a.g(0);
            this.a.a(this.b);
            this.a.flush();
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            this.a.flush();
        }
    }

    public final void b(y yVar) {
        synchronized (this) {
            if (this.e) {
                throw new IOException("closed");
            }
            int bitCount = Integer.bitCount(yVar.a);
            this.a.f(-2147287036);
            this.a.f((((bitCount << 3) + 4) & 16777215) | 0);
            this.a.f(bitCount);
            for (bitCount = 0; bitCount <= 10; bitCount++) {
                if (yVar.a(bitCount)) {
                    this.a.f(((yVar.b(bitCount) & 255) << 24) | (bitCount & 16777215));
                    this.a.f(yVar.d[bitCount]);
                }
            }
            this.a.flush();
        }
    }

    public final int c() {
        return 16383;
    }

    public final void close() {
        synchronized (this) {
            this.e = true;
            v.a(this.a, this.c);
        }
    }
}
