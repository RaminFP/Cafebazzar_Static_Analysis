package d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class p implements ac {
    private int a = 0;
    private final j b;
    private final Inflater c;
    private final q d;
    private final CRC32 e = new CRC32();

    public p(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = r.a(acVar);
        this.d = new q(this.b, this.c);
    }

    private void a(f fVar, long j, long j2) {
        z zVar = fVar.a;
        while (j >= ((long) (zVar.c - zVar.b))) {
            j -= (long) (zVar.c - zVar.b);
            zVar = zVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) zVar.b) + j);
            int min = (int) Math.min((long) (zVar.c - i), j2);
            this.e.update(zVar.a, i, min);
            j2 -= (long) min;
            zVar = zVar.f;
            j = 0;
        }
    }

    private static void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                long a;
                this.b.a(10);
                byte b = this.b.b().b(3);
                Object obj = ((b >> 1) & 1) == 1 ? 1 : null;
                if (obj != null) {
                    a(this.b.b(), 0, 10);
                }
                a("ID1ID2", 8075, this.b.h());
                this.b.f(8);
                if (((b >> 2) & 1) == 1) {
                    this.b.a(2);
                    if (obj != null) {
                        a(this.b.b(), 0, 2);
                    }
                    short j2 = this.b.b().j();
                    this.b.a((long) j2);
                    if (obj != null) {
                        a(this.b.b(), 0, (long) j2);
                    }
                    this.b.f((long) j2);
                }
                if (((b >> 3) & 1) == 1) {
                    a = this.b.a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        a(this.b.b(), 0, 1 + a);
                    }
                    this.b.f(1 + a);
                }
                if (((b >> 4) & 1) == 1) {
                    a = this.b.a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        a(this.b.b(), 0, 1 + a);
                    }
                    this.b.f(1 + a);
                }
                if (obj != null) {
                    a("FHCRC", this.b.j(), (short) ((int) this.e.getValue()));
                    this.e.reset();
                }
                this.a = 1;
            }
            if (this.a == 1) {
                long j3 = fVar.b;
                long a2 = this.d.a(fVar, j);
                if (a2 != -1) {
                    a(fVar, j3, a2);
                    return a2;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                a("CRC", this.b.k(), (int) this.e.getValue());
                a("ISIZE", this.b.k(), this.c.getTotalOut());
                this.a = 3;
                if (!this.b.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final void close() {
        this.d.close();
    }

    public final ad j_() {
        return this.b.j_();
    }
}
