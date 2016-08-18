package d;

import java.io.IOException;

final class c implements ac {
    final /* synthetic */ ac a;
    final /* synthetic */ a b;

    c(a aVar, ac acVar) {
        this.b = aVar;
        this.a = acVar;
    }

    public final long a(f fVar, long j) {
        this.b.k_();
        try {
            long a = this.a.a(fVar, j);
            this.b.a(true);
            return a;
        } catch (IOException e) {
            throw this.b.a(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void close() {
        try {
            this.a.close();
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
        return "AsyncTimeout.source(" + this.a + ")";
    }
}
