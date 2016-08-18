package d;

import java.io.OutputStream;

final class s implements ab {
    final /* synthetic */ ad a;
    final /* synthetic */ OutputStream b;

    s(ad adVar, OutputStream outputStream) {
        this.a = adVar;
        this.b = outputStream;
    }

    public final void a_(f fVar, long j) {
        af.a(fVar.b, 0, j);
        while (j > 0) {
            this.a.f();
            z zVar = fVar.a;
            int min = (int) Math.min(j, (long) (zVar.c - zVar.b));
            this.b.write(zVar.a, zVar.b, min);
            zVar.b += min;
            j -= (long) min;
            fVar.b -= (long) min;
            if (zVar.b == zVar.c) {
                fVar.a = zVar.a();
                aa.a(zVar);
            }
        }
    }

    public final void close() {
        this.b.close();
    }

    public final void flush() {
        this.b.flush();
    }

    public final ad j_() {
        return this.a;
    }

    public final String toString() {
        return "sink(" + this.b + ")";
    }
}
