package d;

import java.io.IOException;

final class b implements ab {
    final /* synthetic */ ab a;
    final /* synthetic */ a b;

    b(a aVar, ab abVar) {
        this.b = aVar;
        this.a = abVar;
    }

    public final void a_(f fVar, long j) {
        this.b.k_();
        try {
            this.a.a_(fVar, j);
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.a(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void close() {
        this.b.k_();
        try {
            this.a.close();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.a(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void flush() {
        this.b.k_();
        try {
            this.a.flush();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.a(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final ad j_() {
        return this.b;
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.a + ")";
    }
}
