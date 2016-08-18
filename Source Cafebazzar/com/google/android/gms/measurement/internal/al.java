package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.internal.av;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public final class al extends ba {
    ao a;
    ao b;
    final Object c = new Object();
    final Semaphore d = new Semaphore(2);
    volatile boolean e;
    private final BlockingQueue f = new LinkedBlockingQueue();
    private final BlockingQueue g = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler j = new an(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler k = new an(this, "Thread death: Uncaught exception on network thread");

    al(ap apVar) {
        super(apVar);
    }

    protected final void a() {
    }

    public final void a(Runnable runnable) {
        u();
        av.a((Object) runnable);
        am amVar = new am(this, runnable, "Task exception on worker thread");
        synchronized (this.c) {
            this.f.add(amVar);
            if (this.a == null) {
                this.a = new ao(this, "Measurement Worker", this.f);
                this.a.setUncaughtExceptionHandler(this.j);
                this.a.start();
            } else {
                this.a.a();
            }
        }
    }

    public final void b(Runnable runnable) {
        u();
        av.a((Object) runnable);
        am amVar = new am(this, runnable, "Task exception on network thread");
        synchronized (this.c) {
            this.g.add(amVar);
            if (this.b == null) {
                this.b = new ao(this, "Measurement Network", this.g);
                this.b.setUncaughtExceptionHandler(this.k);
                this.b.start();
            } else {
                this.b.a();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final void d() {
        if (Thread.currentThread() != this.b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void e() {
        if (Thread.currentThread() != this.a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ x f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ bg g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ bz h() {
        return super.h();
    }

    public final /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ g j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ al k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ z l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ ai m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ i n() {
        return super.n();
    }
}
