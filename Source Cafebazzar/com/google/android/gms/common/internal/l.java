package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.b;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class l implements c, w {
    public static final String[] e = new String[]{"service_esmobile", "service_googleme"};
    public final Context a;
    public final h b;
    final Handler c;
    protected AtomicInteger d;
    private final Looper f;
    private final x g;
    private final b h;
    private final Object i;
    private am j;
    private o k;
    private IInterface l;
    private final ArrayList m;
    private q n;
    private int o;
    private final Set p;
    private final Account q;
    private final k r;
    private final com.google.android.gms.common.api.l s;
    private final int t;

    public l(Context context, Looper looper, int i, h hVar, k kVar, com.google.android.gms.common.api.l lVar) {
        this(context, looper, x.a(context), b.a(), i, hVar, (k) av.a((Object) kVar), (com.google.android.gms.common.api.l) av.a((Object) lVar));
    }

    private l(Context context, Looper looper, x xVar, b bVar, int i, h hVar, k kVar, com.google.android.gms.common.api.l lVar) {
        this.i = new Object();
        this.m = new ArrayList();
        this.o = 1;
        this.d = new AtomicInteger(0);
        this.a = (Context) av.a((Object) context, (Object) "Context must not be null");
        this.f = (Looper) av.a((Object) looper, (Object) "Looper must not be null");
        this.g = (x) av.a((Object) xVar, (Object) "Supervisor must not be null");
        this.h = (b) av.a((Object) bVar, (Object) "API availability must not be null");
        this.c = new n(this, looper);
        this.t = i;
        this.b = (h) av.a((Object) hVar);
        this.q = hVar.a;
        this.p = a(hVar.c);
        this.r = kVar;
        this.s = lVar;
    }

    private Set a(Set set) {
        if (set != null) {
            for (Scope contains : set) {
                if (!set.contains(contains)) {
                    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                }
            }
        }
        return set;
    }

    private void a(int i) {
        this.c.sendMessage(this.c.obtainMessage(4, this.d.get(), 1));
    }

    private void a(int i, IInterface iInterface) {
        boolean z = false;
        if ((i == 3) == (iInterface != null)) {
            z = true;
        }
        av.b(z);
        synchronized (this.i) {
            this.o = i;
            this.l = iInterface;
            switch (i) {
                case 1:
                    if (this.n != null) {
                        this.g.b(f(), this.n, p());
                        this.n = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.n != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + f());
                        this.g.b(f(), this.n, p());
                        this.d.incrementAndGet();
                    }
                    this.n = new q(this, this.d.get());
                    if (!this.g.a(f(), this.n, p())) {
                        Log.e("GmsClient", "unable to connect to service: " + f());
                        this.c.sendMessage(this.c.obtainMessage(3, this.d.get(), 9));
                        break;
                    }
                    break;
            }
        }
    }

    private boolean a(int i, int i2, IInterface iInterface) {
        synchronized (this.i) {
            if (this.o != i) {
                return false;
            }
            a(i2, iInterface);
            return true;
        }
    }

    protected static void h() {
    }

    protected static void i_() {
    }

    private String p() {
        return this.b.f;
    }

    public abstract IInterface a(IBinder iBinder);

    public final void a() {
        this.d.incrementAndGet();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                ((o) this.m.get(i)).d();
            }
            this.m.clear();
        }
        a(1, null);
    }

    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.c.sendMessage(this.c.obtainMessage(1, i2, -1, new s(this, i, iBinder, bundle)));
    }

    public final void a(o oVar) {
        this.k = (o) av.a((Object) oVar, (Object) "Connection progress callbacks cannot be null.");
        a(2, null);
    }

    public final void a(ad adVar) {
        try {
            this.j.a(new p(this, this.d.get()), new ValidateAccountRequest(adVar, (Scope[]) this.p.toArray(new Scope[this.p.size()]), this.a.getPackageName(), o()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            a(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public final void a(ad adVar, Set set) {
        try {
            Bundle l = l();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.t);
            getServiceRequest.d = this.a.getPackageName();
            getServiceRequest.g = l;
            if (set != null) {
                getServiceRequest.f = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (c()) {
                getServiceRequest.h = this.q != null ? this.q : new Account("<<default account>>", "com.google");
                if (adVar != null) {
                    getServiceRequest.e = adVar.asBinder();
                }
            }
            this.j.a(new p(this, this.d.get()), getServiceRequest);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            a(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        synchronized (this.i) {
            int i = this.o;
            IInterface iInterface = this.l;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(g()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.i) {
            z = this.o == 3;
        }
        return z;
    }

    public boolean c() {
        return false;
    }

    public final Intent d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final IBinder e() {
        return this.j == null ? null : this.j.asBinder();
    }

    public abstract String f();

    public abstract String g();

    public final void j() {
        int a = b.a(this.a);
        if (a != 0) {
            a(1, null);
            this.k = new r(this);
            this.c.sendMessage(this.c.obtainMessage(3, this.d.get(), a));
            return;
        }
        a(new r(this));
    }

    public final boolean k() {
        boolean z;
        synchronized (this.i) {
            z = this.o == 2;
        }
        return z;
    }

    public Bundle l() {
        return new Bundle();
    }

    public final void m() {
        if (!b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final IInterface n() {
        IInterface iInterface;
        synchronized (this.i) {
            if (this.o == 4) {
                throw new DeadObjectException();
            }
            m();
            av.a(this.l != null, (Object) "Client is connected but service is null");
            iInterface = this.l;
        }
        return iInterface;
    }

    public Bundle o() {
        return null;
    }
}
