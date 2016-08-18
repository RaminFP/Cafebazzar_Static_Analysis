package com.google.android.gms.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class ac implements az {
    final ba a;
    final Lock b;
    final Context c;
    cz d;
    boolean e;
    boolean f;
    ad g;
    boolean h;
    boolean i;
    private final b j;
    private ConnectionResult k;
    private int l;
    private int m = 0;
    private boolean n = false;
    private int o;
    private final Bundle p = new Bundle();
    private final Set q = new HashSet();
    private int r;
    private final h s;
    private final Map t;
    private final com.google.android.gms.common.api.b u;
    private ArrayList v = new ArrayList();

    public ac(ba baVar, h hVar, Map map, b bVar, com.google.android.gms.common.api.b bVar2, Lock lock, Context context) {
        this.a = baVar;
        this.s = hVar;
        this.t = map;
        this.j = bVar;
        this.u = bVar2;
        this.b = lock;
        this.c = context;
    }

    private void a(boolean z) {
        if (this.d != null) {
            if (this.d.b() && z) {
                this.d.h_();
            }
            this.d.a();
            this.g = null;
        }
    }

    private static String c(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void j() {
        ba baVar = this.a;
        baVar.a.lock();
        try {
            baVar.m.f();
            baVar.k = new aa(baVar);
            baVar.k.a();
            baVar.b.signalAll();
            bd.a().execute(new ad(this));
            if (this.d != null) {
                if (this.h) {
                    this.d.a(this.g, this.i);
                }
                a(false);
            }
            for (d dVar : this.a.g.keySet()) {
                ((c) this.a.f.get(dVar)).a();
            }
            this.a.n.a(this.p.isEmpty() ? null : this.p);
            if (this.n) {
                this.n = false;
                b();
            }
        } finally {
            baVar.a.unlock();
        }
    }

    private void k() {
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.v.clear();
    }

    public final t a(t tVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void a() {
        this.a.g.clear();
        this.n = false;
        this.e = false;
        this.k = null;
        this.m = 0;
        this.r = 2;
        this.f = false;
        this.h = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (a aVar : this.t.keySet()) {
            c cVar = (c) this.a.f.get(aVar.b());
            int intValue = ((Integer) this.t.get(aVar)).intValue();
            int i2 = aVar.a().a() == 1 ? 1 : 0;
            if (cVar.c()) {
                this.e = true;
                if (intValue < this.r) {
                    this.r = intValue;
                }
                if (intValue != 0) {
                    this.q.add(aVar.b());
                }
            }
            hashMap.put(cVar, new aj(this, aVar, intValue));
            i = i2 | i;
        }
        if (i != 0) {
            this.e = false;
        }
        if (this.e) {
            this.s.h = Integer.valueOf(System.identityHashCode(this.a.m));
            k anVar = new an();
            this.d = (cz) this.u.a(this.c, this.a.m.a, this.s, this.s.g, anVar, anVar);
        }
        this.o = this.a.f.size();
        this.v.add(bd.a().submit(new ak(this, hashMap)));
    }

    public final void a(int i) {
        b(new ConnectionResult(8, null));
    }

    public final void a(Bundle bundle) {
        if (b(3)) {
            if (bundle != null) {
                this.p.putAll(bundle);
            }
            if (d()) {
                j();
            }
        }
    }

    public final void a(ConnectionResult connectionResult, a aVar, int i) {
        if (b(3)) {
            b(connectionResult, aVar, i);
            if (d()) {
                j();
            }
        }
    }

    boolean a(ConnectionResult connectionResult) {
        return this.r != 2 ? this.r == 1 && !connectionResult.a() : true;
    }

    public final void b() {
        Iterator it = this.a.m.b.iterator();
        while (it.hasNext()) {
            ((ay) it.next()).b();
            it.remove();
        }
        if (this.k != null || this.a.m.b.isEmpty()) {
            k();
            a(true);
            this.a.a(null);
            return;
        }
        this.n = true;
    }

    void b(ConnectionResult connectionResult) {
        k();
        a(!connectionResult.a());
        this.a.a(connectionResult);
        if (!this.n) {
            this.a.n.a(connectionResult);
        }
        this.n = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void b(com.google.android.gms.common.ConnectionResult r7, com.google.android.gms.common.api.a r8, int r9) {
        /*
        r6 = this;
        r5 = 0;
        r1 = 0;
        r0 = 1;
        r2 = 2;
        if (r9 == r2) goto L_0x0027;
    L_0x0006:
        r2 = r8.a();
        r3 = r2.a();
        if (r9 != r0) goto L_0x0019;
    L_0x0010:
        r2 = r7.a();
        if (r2 == 0) goto L_0x0033;
    L_0x0016:
        r2 = r0;
    L_0x0017:
        if (r2 == 0) goto L_0x0041;
    L_0x0019:
        r2 = r6.k;
        if (r2 == 0) goto L_0x0021;
    L_0x001d:
        r2 = r6.l;
        if (r3 >= r2) goto L_0x0041;
    L_0x0021:
        if (r0 == 0) goto L_0x0027;
    L_0x0023:
        r6.k = r7;
        r6.l = r3;
    L_0x0027:
        r0 = r6.a;
        r0 = r0.g;
        r1 = r8.b();
        r0.put(r1, r7);
        return;
    L_0x0033:
        r2 = r6.j;
        r4 = r7.c;
        r2 = r2.a(r5, r4, r5);
        if (r2 == 0) goto L_0x003f;
    L_0x003d:
        r2 = r0;
        goto L_0x0017;
    L_0x003f:
        r2 = r1;
        goto L_0x0017;
    L_0x0041:
        r0 = r1;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.ac.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, int):void");
    }

    boolean b(int i) {
        if (this.m == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.a.m.g());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + c(this.m) + " but received callback for step " + c(i), new Exception());
        b(new ConnectionResult(8, null));
        return false;
    }

    public final void c() {
        this.n = false;
    }

    boolean d() {
        this.o--;
        if (this.o > 0) {
            return false;
        }
        if (this.o < 0) {
            Log.i("GoogleApiClientConnecting", this.a.m.g());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            b(new ConnectionResult(8, null));
            return false;
        } else if (this.k == null) {
            return true;
        } else {
            this.a.l = this.l;
            b(this.k);
            return false;
        }
    }

    void e() {
        if (this.o == 0) {
            if (!this.e) {
                g();
            } else if (this.f) {
                ArrayList arrayList = new ArrayList();
                this.m = 1;
                this.o = this.a.f.size();
                for (d dVar : this.a.f.keySet()) {
                    if (!this.a.g.containsKey(dVar)) {
                        arrayList.add(this.a.f.get(dVar));
                    } else if (d()) {
                        f();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.v.add(bd.a().submit(new ao(this, arrayList)));
                }
            }
        }
    }

    void f() {
        this.m = 2;
        this.a.m.e = i();
        this.v.add(bd.a().submit(new ai()));
    }

    void g() {
        ArrayList arrayList = new ArrayList();
        this.m = 3;
        this.o = this.a.f.size();
        for (d dVar : this.a.f.keySet()) {
            if (!this.a.g.containsKey(dVar)) {
                arrayList.add(this.a.f.get(dVar));
            } else if (d()) {
                j();
            }
        }
        if (!arrayList.isEmpty()) {
            this.v.add(bd.a().submit(new am(this, arrayList)));
        }
    }

    void h() {
        this.e = false;
        this.a.m.e = Collections.emptySet();
        for (d dVar : this.q) {
            if (!this.a.g.containsKey(dVar)) {
                this.a.g.put(dVar, new ConnectionResult(17, null));
            }
        }
    }

    Set i() {
        if (this.s == null) {
            return Collections.emptySet();
        }
        Set hashSet = new HashSet(this.s.b);
        Map map = this.s.d;
        for (a aVar : map.keySet()) {
            if (!this.a.g.containsKey(aVar.b())) {
                hashSet.addAll(((i) map.get(aVar)).a);
            }
        }
        return hashSet;
    }
}
