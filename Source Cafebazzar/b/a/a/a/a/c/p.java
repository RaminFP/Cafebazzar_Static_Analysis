package b.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class p extends a implements l, u, y {
    private final v a = new v();

    public int a() {
        return this.a.a();
    }

    public final void a(y yVar) {
        if (this.d != j.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        this.a.c(yVar);
    }

    public final void a(Throwable th) {
        this.a.a(th);
    }

    public final void a(ExecutorService executorService, Object... objArr) {
        super.a(new q(executorService, this), objArr);
    }

    public final void b(boolean z) {
        this.a.b(z);
    }

    public final Collection c() {
        return this.a.c();
    }

    public final /* synthetic */ void c(Object obj) {
        a((y) obj);
    }

    public int compareTo(Object obj) {
        return o.a(this, obj);
    }

    public final boolean d() {
        return this.a.d();
    }

    public final boolean e() {
        return this.a.e();
    }
}
