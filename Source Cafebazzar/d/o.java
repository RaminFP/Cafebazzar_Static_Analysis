package d;

import java.util.concurrent.TimeUnit;

public final class o extends ad {
    public ad a;

    public o(ad adVar) {
        if (adVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = adVar;
    }

    public final ad a(long j) {
        return this.a.a(j);
    }

    public final ad a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    public final long c() {
        return this.a.c();
    }

    public final ad d() {
        return this.a.d();
    }

    public final void f() {
        this.a.f();
    }

    public final long m_() {
        return this.a.m_();
    }

    public final boolean n_() {
        return this.a.n_();
    }

    public final ad o_() {
        return this.a.o_();
    }
}
