package b.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class t extends FutureTask implements l, u, y {
    final Object b;

    public t(Runnable runnable, Object obj) {
        super(runnable, obj);
        this.b = a((Object) runnable);
    }

    public t(Callable callable) {
        super(callable);
        this.b = a((Object) callable);
    }

    private static l a(Object obj) {
        return v.a(obj) ? (l) obj : new v();
    }

    public final int a() {
        return ((u) b()).a();
    }

    public final void a(Throwable th) {
        ((y) ((u) b())).a(th);
    }

    public l b() {
        return (l) this.b;
    }

    public final void b(boolean z) {
        ((y) ((u) b())).b(z);
    }

    public final Collection c() {
        return ((l) ((u) b())).c();
    }

    public final /* synthetic */ void c(Object obj) {
        ((l) ((u) b())).c((y) obj);
    }

    public int compareTo(Object obj) {
        return ((u) b()).compareTo(obj);
    }

    public final boolean d() {
        return ((l) ((u) b())).d();
    }

    public final boolean e() {
        return ((y) ((u) b())).e();
    }
}
