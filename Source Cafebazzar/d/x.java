package d;

import java.io.EOFException;
import java.io.InputStream;

final class x implements j {
    public final f a;
    public final ac b;
    boolean c;

    public x(ac acVar) {
        this(acVar, new f());
    }

    private x(ac acVar, f fVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = fVar;
        this.b = acVar;
    }

    private boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.a.b < j) {
                if (this.b.a(this.a, 2048) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public final long a(byte b) {
        long j = 0;
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (0 >= this.a.b) {
            if (this.b.a(this.a, 2048) == -1) {
                return -1;
            }
        }
        do {
            j = this.a.a(b, j);
            if (j != -1) {
                return j;
            }
            j = this.a.b;
        } while (this.b.a(this.a, 2048) != -1);
        return -1;
    }

    public final long a(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.a(this.a, 2048) == -1) {
            return -1;
        } else {
            return this.a.a(fVar, Math.min(j, this.a.b));
        }
    }

    public final void a(long j) {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public final f b() {
        return this.a;
    }

    public final k c(long j) {
        a(j);
        return this.a.c(j);
    }

    public final void close() {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.r();
        }
    }

    public final boolean e() {
        if (!this.c) {
            return this.a.e() && this.b.a(this.a, 2048) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final byte[] e(long j) {
        a(j);
        return this.a.e(j);
    }

    public final InputStream f() {
        return new y(this);
    }

    public final void f(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.a(this.a, 2048) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.b);
            this.a.f(min);
            j -= min;
        }
    }

    public final byte g() {
        a(1);
        return this.a.g();
    }

    public final short h() {
        a(2);
        return this.a.h();
    }

    public final int i() {
        a(4);
        return this.a.i();
    }

    public final short j() {
        a(2);
        return af.a(this.a.h());
    }

    public final ad j_() {
        return this.b.j_();
    }

    public final int k() {
        a(4);
        return af.a(this.a.i());
    }

    public final long l() {
        a(1);
        int i = 0;
        while (b((long) (i + 1))) {
            byte b = this.a.b((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && !(i == 0 && b == (byte) 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.a.l();
            }
            i++;
        }
        return this.a.l();
    }

    public final long m() {
        a(1);
        for (int i = 0; b((long) (i + 1)); i++) {
            byte b = this.a.b((long) i);
            if ((b < (byte) 48 || b > (byte) 57) && ((b < (byte) 97 || b > (byte) 102) && (b < (byte) 65 || b > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.a.m();
            }
        }
        return this.a.m();
    }

    public final String p() {
        long a = a((byte) 10);
        if (a != -1) {
            return this.a.d(a);
        }
        f fVar = new f();
        this.a.a(fVar, 0, Math.min(32, this.a.b));
        throw new EOFException("\\n not found: size=" + this.a.b + " content=" + fVar.n().b() + "...");
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
