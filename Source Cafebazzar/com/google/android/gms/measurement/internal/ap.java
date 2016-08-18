package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.a.bz;
import com.google.android.gms.a.ca;
import com.google.android.gms.a.ck;
import com.google.android.gms.a.cl;
import com.google.android.gms.a.cm;
import com.google.android.gms.a.cn;
import com.google.android.gms.a.co;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ap {
    private static bb h;
    private static volatile ap i;
    final Context a;
    final i b = new i(this);
    final al c;
    final bz d = ca.c();
    final bg e;
    int f;
    int g;
    private final ai j;
    private final z k;
    private final a l;
    private final g m;
    private final j n;
    private final ac o;
    private final n p;
    private final bc q;
    private final x r;
    private final ag s;
    private final d t;
    private final boolean u;
    private Boolean v;
    private List w;

    ap(bb bbVar) {
        av.a((Object) bbVar);
        this.a = bbVar.a;
        ai aiVar = new ai(this);
        aiVar.v();
        this.j = aiVar;
        z zVar = new z(this);
        zVar.v();
        this.k = zVar;
        this.m = new g(this);
        n nVar = new n(this);
        nVar.v();
        this.p = nVar;
        x xVar = new x(this);
        xVar.v();
        this.r = xVar;
        j jVar = new j(this);
        jVar.v();
        this.n = jVar;
        ac acVar = new ac(this);
        acVar.v();
        this.o = acVar;
        bg b = bb.b(this);
        b.v();
        this.e = b;
        bc a = bb.a(this);
        a.v();
        this.q = a;
        d c = bb.c(this);
        c.v();
        this.t = c;
        this.s = new ag(this);
        this.l = new a(this);
        al alVar = new al(this);
        alVar.v();
        this.c = alVar;
        if (this.f != this.g) {
            e().a.a("Not all components initialized", Integer.valueOf(this.f), Integer.valueOf(this.g));
        }
        this.u = true;
        if (!i.B()) {
            if (!(this.a.getApplicationContext() instanceof Application)) {
                e().b.a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                bc m = m();
                if (m.i().getApplicationContext() instanceof Application) {
                    Application application = (Application) m.i().getApplicationContext();
                    if (m.a == null) {
                        m.a = new bf(m);
                    }
                    application.unregisterActivityLifecycleCallbacks(m.a);
                    application.registerActivityLifecycleCallbacks(m.a);
                    m.l().g.a("Registered activity lifecycle callback");
                }
            } else {
                e().f.a("Not tracking deep linking pre-ICS");
            }
        }
        this.c.a(new aq(this));
    }

    public static ap a(Context context) {
        av.a((Object) context);
        av.a(context.getApplicationContext());
        if (i == null) {
            synchronized (ap.class) {
                try {
                    if (i == null) {
                        i = new ap(h != null ? h : new bb(context));
                    }
                } catch (Throwable th) {
                    Class cls = ap.class;
                }
            }
        }
        return i;
    }

    static /* synthetic */ void a(ap apVar, int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        apVar.f().e();
        apVar.a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = apVar.w;
        apVar.w = null;
        if ((i == Callback.DEFAULT_DRAG_ANIMATION_DURATION || i == 204) && th == null) {
            apVar.d().c.a(apVar.d.a());
            apVar.d().d.a(0);
            apVar.l();
            apVar.e().g.a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            apVar.h().b();
            try {
                for (Long longValue : list) {
                    apVar.h().a(longValue.longValue());
                }
                apVar.h().o();
                if (apVar.i().b() && apVar.q()) {
                    apVar.k();
                } else {
                    apVar.l();
                }
            } finally {
                apVar.h().p();
            }
        } else {
            apVar.e().g.a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            apVar.d().d.a(apVar.d.a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                apVar.d().e.a(apVar.d.a());
            }
            apVar.l();
        }
    }

    private static void a(az azVar) {
        if (azVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    static void a(ba baVar) {
        if (baVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!baVar.t()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private bc m() {
        a(this.q);
        return this.q;
    }

    private n n() {
        a(this.p);
        return this.p;
    }

    private ag o() {
        if (this.s != null) {
            return this.s;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private d p() {
        a(this.t);
        return this.t;
    }

    private boolean q() {
        return !TextUtils.isEmpty(h().q());
    }

    final void a() {
        if (!this.u) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void a(AppMetadata appMetadata) {
        b bVar;
        f().e();
        a();
        av.a((Object) appMetadata);
        av.a(appMetadata.b);
        b b = h().b(appMetadata.b);
        String o = d().o();
        Object obj = null;
        if (b == null) {
            String str = appMetadata.b;
            d();
            bVar = new b(str, ai.p(), appMetadata.c, o, 0, 0, appMetadata.d, appMetadata.e, appMetadata.f, appMetadata.g, appMetadata.i);
            obj = 1;
            b = bVar;
        } else if (!o.equals(b.d)) {
            d();
            bVar = new b(b.a, ai.p(), b.c, o, b.e, b.f, b.g, b.h, b.i, b.j, b.k);
            int i = 1;
            b = bVar;
        }
        if (!(TextUtils.isEmpty(appMetadata.c) || (appMetadata.c.equals(b.c) && appMetadata.f == b.i))) {
            bVar = new b(b.a, b.b, appMetadata.c, b.d, b.e, b.f, b.g, b.h, appMetadata.f, b.j, b.k);
            obj = 1;
            b = bVar;
        }
        if (!(TextUtils.isEmpty(appMetadata.d) || (appMetadata.d.equals(b.g) && appMetadata.e.equals(b.h)))) {
            bVar = new b(b.a, b.b, b.c, b.d, b.e, b.f, appMetadata.d, appMetadata.e, b.i, b.j, b.k);
            obj = 1;
            b = bVar;
        }
        if (appMetadata.g != b.j) {
            bVar = new b(b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, appMetadata.g, b.k);
            obj = 1;
            b = bVar;
        }
        if (appMetadata.i != b.k) {
            b = new b(b.a, b.b, b.c, b.d, b.e, b.f, b.g, b.h, b.i, b.j, appMetadata.i);
            obj = 1;
        }
        if (obj != null) {
            h().a(b);
        }
    }

    final void a(EventParcel eventParcel, AppMetadata appMetadata) {
        f().e();
        a();
        av.a(appMetadata.b);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            e().g.a("Logging event", eventParcel);
            o oVar = new o(this, eventParcel.d, appMetadata.b, eventParcel.b, eventParcel.e, 0, eventParcel.c.a());
            h().b();
            try {
                p pVar;
                o oVar2;
                b bVar;
                int i;
                a(appMetadata);
                p a = h().a(appMetadata.b, oVar.b);
                if (a == null) {
                    pVar = new p(appMetadata.b, oVar.b, 1, 1, oVar.d);
                    oVar2 = oVar;
                } else {
                    oVar = new o(this, oVar.c, oVar.a, oVar.b, oVar.d, a.e, oVar.f);
                    pVar = new p(a.a, a.b, a.c + 1, a.d + 1, oVar.d);
                    oVar2 = oVar;
                }
                h().a(pVar);
                Object obj = new o[1];
                obj[0] = oVar2;
                av.a((Object) appMetadata);
                av.a(obj);
                f().e();
                cn cnVar = new cn();
                cnVar.a = Integer.valueOf(1);
                cnVar.i = "android";
                cnVar.o = appMetadata.b;
                cnVar.n = appMetadata.e;
                cnVar.p = appMetadata.d;
                cnVar.q = Long.valueOf(appMetadata.f);
                cnVar.y = appMetadata.c;
                cnVar.v = appMetadata.g == 0 ? null : Long.valueOf(appMetadata.g);
                Pair b = d().b();
                if (!(b.first == null || b.second == null)) {
                    cnVar.s = (String) b.first;
                    cnVar.t = (Boolean) b.second;
                }
                cnVar.k = n().b();
                cnVar.j = n().o();
                cnVar.m = Integer.valueOf((int) n().p());
                cnVar.l = n().q();
                cnVar.r = null;
                cnVar.d = null;
                cnVar.e = Long.valueOf(obj[0].d);
                cnVar.f = Long.valueOf(obj[0].d);
                b b2 = h().b(appMetadata.b);
                if (b2 == null) {
                    String str = appMetadata.b;
                    d();
                    bVar = new b(str, ai.p(), appMetadata.c, d().o(), 0, 0, appMetadata.d, appMetadata.e, appMetadata.f, appMetadata.g, appMetadata.i);
                } else {
                    bVar = b2;
                }
                Object e = e();
                long longValue = cnVar.f.longValue();
                av.a(e);
                long j = bVar.e + 1;
                if (j > 2147483647L) {
                    e.b.a("Bundle index overflow");
                    j = 0;
                }
                b2 = new b(bVar.a, bVar.b, bVar.c, bVar.d, j, longValue, bVar.g, bVar.h, bVar.i, bVar.j, bVar.k);
                h().a(b2);
                cnVar.u = b2.b;
                cnVar.w = Integer.valueOf((int) b2.e);
                cnVar.h = bVar.f == 0 ? null : Long.valueOf(bVar.f);
                cnVar.g = cnVar.h;
                List a2 = h().a(appMetadata.b);
                cnVar.c = new co[a2.size()];
                for (i = 0; i < a2.size(); i++) {
                    co coVar = new co();
                    cnVar.c[i] = coVar;
                    coVar.b = ((e) a2.get(i)).b;
                    coVar.a = Long.valueOf(((e) a2.get(i)).c);
                    g().a(coVar, ((e) a2.get(i)).d);
                }
                cnVar.b = new ck[1];
                for (i = 0; i <= 0; i++) {
                    ck ckVar = new ck();
                    cnVar.b[i] = ckVar;
                    ckVar.b = obj[i].b;
                    ckVar.c = Long.valueOf(obj[i].d);
                    ckVar.a = new cl[obj[i].f.b.size()];
                    Iterator it = obj[i].f.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        cl clVar = new cl();
                        ckVar.a[i2] = clVar;
                        clVar.a = str2;
                        g().a(clVar, obj[i].f.b.get(str2));
                        i2++;
                    }
                }
                cnVar.x = e().b();
                h().a(cnVar);
                h().o();
                e().f.a("Event logged", oVar2);
                l();
            } finally {
                h().p();
            }
        }
    }

    final void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        f().e();
        a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            g().a(userAttributeParcel.b);
            Object b = g().b(userAttributeParcel.b, userAttributeParcel.a());
            if (b != null) {
                e eVar = new e(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, b);
                e().f.a("Setting user attribute", eVar.b, b);
                h().b();
                try {
                    a(appMetadata);
                    h().a(eVar);
                    h().o();
                    e().f.a("User attribute set", eVar.b, eVar.d);
                } finally {
                    h().p();
                }
            }
        }
    }

    protected final boolean b() {
        boolean z = true;
        a();
        f().e();
        if (this.v == null) {
            boolean z2 = g().b("android.permission.INTERNET") && g().b("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.a(this.a) && AppMeasurementService.a(this.a);
            this.v = Boolean.valueOf(z2);
            if (this.v.booleanValue() && !i.B()) {
                if (TextUtils.isEmpty(j().b())) {
                    z = false;
                }
                this.v = Boolean.valueOf(z);
            }
        }
        return this.v.booleanValue();
    }

    protected final void c() {
        f().e();
        e().e.a("App measurement is starting up");
        e().f.a("Debug logging enabled");
        h().r();
        if (!b()) {
            if (!g().b("android.permission.INTERNET")) {
                e().a.a("App is missing INTERNET permission");
            }
            if (!g().b("android.permission.ACCESS_NETWORK_STATE")) {
                e().a.a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!AppMeasurementReceiver.a(this.a)) {
                e().a.a("AppMeasurementReceiver not registered/enabled");
            }
            if (!AppMeasurementService.a(this.a)) {
                e().a.a("AppMeasurementService not registered/enabled");
            }
            e().a.a("Uploading is not possible. App measurement disabled");
        } else if (!(i.B() || TextUtils.isEmpty(j().b()))) {
            m().b();
        }
        l();
    }

    public final ai d() {
        a(this.j);
        return this.j;
    }

    public final z e() {
        a(this.k);
        return this.k;
    }

    public final al f() {
        a(this.c);
        return this.c;
    }

    public final g g() {
        a(this.m);
        return this.m;
    }

    public final j h() {
        a(this.n);
        return this.n;
    }

    public final ac i() {
        a(this.o);
        return this.o;
    }

    public final x j() {
        a(this.r);
        return this.r;
    }

    public final void k() {
        boolean z = false;
        f().e();
        a();
        if (!i.B()) {
            Boolean q = d().q();
            if (q == null) {
                e().b.a("Upload data called on the client side before use of service was decided");
                return;
            } else if (q.booleanValue()) {
                e().a.a("Upload called in the client side when service should be used");
                return;
            }
        }
        f().e();
        if (this.w != null) {
            e().b.a("Uploading requested multiple times");
        } else if (i().b()) {
            long a = d().c.a();
            if (a != 0) {
                e().f.a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(this.d.a() - a)));
            }
            String q2 = h().q();
            if (!TextUtils.isEmpty(q2)) {
                List<Pair> a2 = h().a(q2, i.H(), i.I());
                if (!a2.isEmpty()) {
                    cn cnVar;
                    Object obj;
                    int i;
                    List subList;
                    for (Pair pair : a2) {
                        cnVar = (cn) pair.first;
                        if (!TextUtils.isEmpty(cnVar.s)) {
                            obj = cnVar.s;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        for (i = 0; i < a2.size(); i++) {
                            cnVar = (cn) ((Pair) a2.get(i)).first;
                            if (!TextUtils.isEmpty(cnVar.s) && !cnVar.s.equals(obj)) {
                                subList = a2.subList(0, i);
                                break;
                            }
                        }
                    }
                    cm cmVar = new cm();
                    cmVar.a = new cn[subList.size()];
                    Collection arrayList = new ArrayList(subList.size());
                    long a3 = this.d.a();
                    for (i = 0; i < cmVar.a.length; i++) {
                        cmVar.a[i] = (cn) ((Pair) subList.get(i)).first;
                        arrayList.add(((Pair) subList.get(i)).second);
                        cmVar.a[i].r = Long.valueOf(i.A());
                        cmVar.a[i].d = Long.valueOf(a3);
                        cmVar.a[i].z = Boolean.valueOf(i.B());
                    }
                    byte[] a4 = g().a(cmVar);
                    String J = i.J();
                    try {
                        URL url = new URL(J);
                        if (!arrayList.isEmpty()) {
                            z = true;
                        }
                        av.b(z);
                        if (this.w != null) {
                            e().a.a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList);
                        }
                        d().d.a(this.d.a());
                        i().a(url, a4, new ar(this));
                    } catch (MalformedURLException e) {
                        e().a.a("Failed to parse upload URL. Not uploading", J);
                    }
                }
            }
        } else {
            e().b.a("Network not connected, ignoring upload request");
            l();
        }
    }

    void l() {
        f().e();
        a();
        if (b() && q()) {
            long a = this.d.a();
            long N = i.N();
            long L = i.L();
            long a2 = d().c.a();
            long a3 = d().d.a();
            long a4 = h().a("select max(bundle_end_timestamp) from queue", null, 0);
            if (a4 == 0) {
                a = 0;
            } else {
                a4 = a - Math.abs(a4 - a);
                a = a4 + N;
                if (!g().a(a2, L)) {
                    a = a2 + L;
                }
                if (a3 != 0 && a3 >= a4) {
                    for (int i = 0; i < i.P(); i++) {
                        a += ((long) (1 << i)) * i.O();
                        if (a > a3) {
                            break;
                        }
                    }
                    a = 0;
                }
            }
            if (a == 0) {
                o().a();
                p().b();
                return;
            } else if (i().b()) {
                N = d().e.a();
                L = i.K();
                if (!g().a(N, L)) {
                    a = Math.max(a, N + L);
                }
                o().a();
                a -= this.d.a();
                if (a <= 0) {
                    p().a(1);
                    return;
                }
                e().g.a("Upload scheduled in approximately ms", Long.valueOf(a));
                p().a(a);
                return;
            } else {
                BroadcastReceiver o = o();
                o.b.a();
                o.b.f().e();
                if (!o.c) {
                    o.b().registerReceiver(o, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    o.d = o.b.i().b();
                    o.b.e().g.a("Registering connectivity change receiver. Network connected", Boolean.valueOf(o.d));
                    o.c = true;
                }
                p().b();
                return;
            }
        }
        o().a();
        p().b();
    }
}
