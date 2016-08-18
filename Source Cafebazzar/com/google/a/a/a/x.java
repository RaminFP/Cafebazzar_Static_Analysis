package com.google.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public final class x extends bc {
    private static final Object a = new Object();
    private static x o;
    private Context b;
    private f c;
    private volatile h d;
    private int e = 1800;
    private boolean f = true;
    private boolean g;
    private String h;
    private boolean i = true;
    private boolean j = true;
    private g k = new y(this);
    private Handler l;
    private w m;
    private boolean n = false;

    private x() {
    }

    public static x a() {
        if (o == null) {
            o = new x();
        }
        return o;
    }

    @Deprecated
    public final void a(int i) {
        synchronized (this) {
            if (this.l == null) {
                as.c("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
                this.e = i;
            } else {
                an.a().a(ao.SET_DISPATCH_PERIOD);
                if (!this.n && this.i && this.e > 0) {
                    this.l.removeMessages(1, a);
                }
                this.e = i;
                if (i > 0 && !this.n && this.i) {
                    this.l.sendMessageDelayed(this.l.obtainMessage(1, a), (long) (i * 1000));
                }
            }
        }
    }

    final void a(Context context, h hVar) {
        synchronized (this) {
            if (this.b == null) {
                this.b = context.getApplicationContext();
                if (this.d == null) {
                    this.d = hVar;
                    if (this.f) {
                        c();
                        this.f = false;
                    }
                    if (this.g) {
                        if (this.d == null) {
                            as.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
                            this.g = true;
                        } else {
                            an.a().a(ao.SET_FORCE_LOCAL_DISPATCH);
                            this.d.b();
                        }
                        this.g = false;
                    }
                }
            }
        }
    }

    final void a(boolean z) {
        synchronized (this) {
            a(this.n, z);
        }
    }

    final void a(boolean z, boolean z2) {
        synchronized (this) {
            if (!(this.n == z && this.i == z2)) {
                if (z || !z2) {
                    if (this.e > 0) {
                        this.l.removeMessages(1, a);
                    }
                }
                if (!z && z2 && this.e > 0) {
                    this.l.sendMessageDelayed(this.l.obtainMessage(1, a), (long) (this.e * 1000));
                }
                StringBuilder stringBuilder = new StringBuilder("PowerSaveMode ");
                String str = (z || !z2) ? "initiated." : "terminated.";
                as.c(stringBuilder.append(str).toString());
                this.n = z;
                this.i = z2;
            }
        }
    }

    final f b() {
        f fVar;
        synchronized (this) {
            if (this.c == null) {
                if (this.b == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
                this.c = new ay(this.k, this.b);
                if (this.h != null) {
                    this.c.b().a(this.h);
                    this.h = null;
                }
            }
            if (this.l == null) {
                this.l = new Handler(this.b.getMainLooper(), new z(this));
                if (this.e > 0) {
                    this.l.sendMessageDelayed(this.l.obtainMessage(1, a), (long) (this.e * 1000));
                }
            }
            if (this.m == null && this.j) {
                this.m = new w(this);
                BroadcastReceiver broadcastReceiver = this.m;
                Context context = this.b;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(broadcastReceiver, intentFilter);
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.google.analytics.RADIO_POWERED");
                intentFilter.addCategory(context.getPackageName());
                context.registerReceiver(broadcastReceiver, intentFilter);
            }
            fVar = this.c;
        }
        return fVar;
    }

    @Deprecated
    public final void c() {
        synchronized (this) {
            if (this.d == null) {
                as.c("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.f = true;
            } else {
                an.a().a(ao.DISPATCH);
                this.d.a();
            }
        }
    }

    final void d() {
        synchronized (this) {
            if (!this.n && this.i && this.e > 0) {
                this.l.removeMessages(1, a);
                this.l.sendMessage(this.l.obtainMessage(1, a));
            }
        }
    }
}
