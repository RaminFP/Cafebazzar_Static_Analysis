package d;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.OutputStream;

final class v implements i {
    public final f a;
    public final ab b;
    boolean c;

    public v(ab abVar) {
        this(abVar, new f());
    }

    private v(ab abVar, f fVar) {
        if (abVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = fVar;
        this.b = abVar;
    }

    public final long a(ac acVar) {
        if (acVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = acVar.a(this.a, 2048);
            if (a == -1) {
                return j;
            }
            j += a;
            s();
        }
    }

    public final void a_(f fVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(fVar, j);
        s();
    }

    public final f b() {
        return this.a;
    }

    public final i b(k kVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(kVar);
        return s();
    }

    public final i b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return s();
    }

    public final i b(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bArr);
        return s();
    }

    public final i c(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bArr, i, i2);
        return s();
    }

    public final OutputStream c() {
        return new w(this);
    }

    public final void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a_(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                af.a(th);
            }
        }
    }

    public final i d() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j = this.a.b;
        if (j > 0) {
            this.b.a_(this.a, j);
        }
        return this;
    }

    public final i f(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(i);
        return s();
    }

    public final void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a_(this.a, this.a.b);
        }
        this.b.flush();
    }

    public final i g(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(i);
        return s();
    }

    public final i h(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(i);
        return s();
    }

    public final i i(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(j);
        return s();
    }

    public final i j(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.g(j);
        return s();
    }

    public final ad j_() {
        return this.b.j_();
    }

    public final i s() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.a;
        long j = fVar.b;
        if (j == 0) {
            j = 0;
        } else {
            z zVar = fVar.a.g;
            if (zVar.c < ItemAnimator.FLAG_MOVED && zVar.e) {
                j -= (long) (zVar.c - zVar.b);
            }
        }
        if (j > 0) {
            this.b.a_(this.a, j);
        }
        return this;
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
