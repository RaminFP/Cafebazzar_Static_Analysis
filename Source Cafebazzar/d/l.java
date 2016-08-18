package d;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class l implements ab {
    private final i a;
    private final Deflater b;
    private boolean c;

    public l(ab abVar, Deflater deflater) {
        this(r.a(abVar), deflater);
    }

    private l(i iVar, Deflater deflater) {
        if (iVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = iVar;
            this.b = deflater;
        }
    }

    @IgnoreJRERequirement
    private void a(boolean z) {
        f b = this.a.b();
        while (true) {
            z e = b.e(1);
            int deflate = z ? this.b.deflate(e.a, e.c, 2048 - e.c, 2) : this.b.deflate(e.a, e.c, 2048 - e.c);
            if (deflate > 0) {
                e.c += deflate;
                b.b += (long) deflate;
                this.a.s();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (e.b == e.c) {
            b.a = e.a();
            aa.a(e);
        }
    }

    public final void a_(f fVar, long j) {
        af.a(fVar.b, 0, j);
        while (j > 0) {
            z zVar = fVar.a;
            int min = (int) Math.min(j, (long) (zVar.c - zVar.b));
            this.b.setInput(zVar.a, zVar.b, min);
            a(false);
            fVar.b -= (long) min;
            zVar.b += min;
            if (zVar.b == zVar.c) {
                fVar.a = zVar.a();
                aa.a(zVar);
            }
            j -= (long) min;
        }
    }

    public final void close() {
        Throwable th;
        if (!this.c) {
            Throwable th2 = null;
            try {
                this.b.finish();
                a(false);
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.b.end();
                th3 = th2;
            } catch (Throwable th4) {
                th3 = th4;
                if (th2 != null) {
                    th3 = th2;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th22) {
                if (th3 == null) {
                    th3 = th22;
                }
            }
            this.c = true;
            if (th3 != null) {
                af.a(th3);
            }
        }
    }

    public final void flush() {
        a(true);
        this.a.flush();
    }

    public final ad j_() {
        return this.a.j_();
    }

    public final String toString() {
        return "DeflaterSink(" + this.a + ")";
    }
}
