package com.google.android.gms.a;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public final class ar extends h implements bg {
    final Looper a;
    final Queue b = new LinkedList();
    aw c;
    final Map d;
    Set e = new HashSet();
    final com.google.android.gms.common.internal.h f;
    final Map g;
    final b h;
    final Set i = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final Lock j;
    private final v k;
    private bf l = null;
    private final int m;
    private final Context n;
    private volatile boolean o;
    private long p = 120000;
    private long q = 5000;
    private final au r;
    private final com.google.android.gms.common.b s;
    private final Set t = Collections.newSetFromMap(new WeakHashMap());
    private t u;
    private final ArrayList v;
    private Integer w = null;
    private final ax x = new as(this);
    private final w y = new at(this);

    public ar(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.h hVar, com.google.android.gms.common.b bVar, b bVar2, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.n = context;
        this.j = lock;
        this.k = new v(looper, this.y);
        this.a = looper;
        this.r = new au(this, looper);
        this.s = bVar;
        this.m = i;
        if (this.m >= 0) {
            this.w = Integer.valueOf(i2);
        }
        this.g = map;
        this.d = map2;
        this.v = arrayList;
        for (Object obj : list) {
            v vVar = this.k;
            av.a(obj);
            synchronized (vVar.i) {
                if (vVar.b.contains(obj)) {
                    Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + obj + " is already registered");
                } else {
                    vVar.b.add(obj);
                }
            }
            if (vVar.a.b()) {
                vVar.h.sendMessage(vVar.h.obtainMessage(1, obj));
            }
        }
        for (l a : list2) {
            this.k.a(a);
        }
        this.f = hVar;
        this.h = bVar2;
    }

    public static int a(Iterable iterable, boolean z) {
        int i = 0;
        for (c c : iterable) {
            i = c.c() ? 1 : i;
        }
        return i != 0 ? 1 : 3;
    }

    static /* synthetic */ void a(ar arVar) {
        arVar.j.lock();
        try {
            if (arVar.o) {
                arVar.h();
            }
            arVar.j.unlock();
        } catch (Throwable th) {
            arVar.j.unlock();
        }
    }

    private static void a(ay ayVar, t tVar, IBinder iBinder) {
        if (ayVar.a()) {
            ayVar.a(new av(ayVar, tVar, iBinder, (byte) 0));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            ayVar.a(null);
            ayVar.b();
            ayVar.e().intValue();
            tVar.a();
        } else {
            ax avVar = new av(ayVar, tVar, iBinder, (byte) 0);
            ayVar.a(avVar);
            try {
                iBinder.linkToDeath(avVar, 0);
            } catch (RemoteException e) {
                ayVar.b();
                ayVar.e().intValue();
                tVar.a();
            }
        }
    }

    private void b(int i) {
        if (this.w == null) {
            this.w = Integer.valueOf(i);
        } else if (this.w.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + c(i) + ". Mode was already set to " + c(this.w.intValue()));
        }
        if (this.l == null) {
            Object obj = null;
            for (c c : this.d.values()) {
                obj = c.c() ? 1 : obj;
            }
            switch (this.w.intValue()) {
                case 1:
                    if (obj == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    }
                    break;
                case 2:
                    if (obj != null) {
                        this.l = new x(this.n, this, this.j, this.a, this.s, this.d, this.f, this.g, this.h, this.v);
                        return;
                    }
                    break;
            }
            this.l = new ba(this.n, this, this.j, this.a, this.s, this.d, this.f, this.g, this.h, this.v, this);
        }
    }

    static /* synthetic */ void b(ar arVar) {
        arVar.j.lock();
        try {
            if (arVar.f()) {
                arVar.h();
            }
            arVar.j.unlock();
        } catch (Throwable th) {
            arVar.j.unlock();
        }
    }

    private static String c(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void h() {
        this.k.e = true;
        this.l.a();
    }

    public final t a(t tVar) {
        av.b(tVar.a != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.j.lock();
        try {
            if (this.l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.o) {
                this.b.add(tVar);
                while (!this.b.isEmpty()) {
                    ay ayVar = (ay) this.b.remove();
                    a(ayVar);
                    ayVar.a(Status.c);
                }
            } else {
                tVar = this.l.a(tVar);
                this.j.unlock();
            }
            return tVar;
        } finally {
            this.j.unlock();
        }
    }

    public final c a(d dVar) {
        Object obj = (c) this.d.get(dVar);
        av.a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final void a() {
        boolean z = false;
        this.j.lock();
        try {
            if (this.m >= 0) {
                av.a(this.w != null, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.w == null) {
                this.w = Integer.valueOf(a(this.d.values(), false));
            } else if (this.w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            int intValue = this.w.intValue();
            this.j.lock();
            if (intValue == 3 || intValue == 1 || intValue == 2) {
                z = true;
            }
            av.b(z, "Illegal sign-in mode: " + intValue);
            b(intValue);
            h();
        } catch (Throwable th) {
        } finally {
            this.j.unlock();
        }
        this.j.unlock();
    }

    public final void a(int i) {
        if (i == 1 && !this.o) {
            this.o = true;
            if (this.c == null) {
                this.c = (aw) be.a(this.n.getApplicationContext(), new aw(this), this.s);
            }
            this.r.sendMessageDelayed(this.r.obtainMessage(1), this.p);
            this.r.sendMessageDelayed(this.r.obtainMessage(2), this.q);
        }
        for (ay b : this.i) {
            b.b(new Status(8, "The connection to Google Play services was lost"));
        }
        v vVar = this.k;
        av.a(Looper.myLooper() == vVar.h.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        vVar.h.removeMessages(1);
        synchronized (vVar.i) {
            vVar.g = true;
            ArrayList arrayList = new ArrayList(vVar.b);
            int i2 = vVar.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (vVar.e && vVar.f.get() == i2) {
                    if (vVar.b.contains(kVar)) {
                        kVar.a(i);
                    }
                }
            }
            vVar.c.clear();
            vVar.g = false;
        }
        this.k.a();
        if (i == 2) {
            h();
        }
    }

    public final void a(Bundle bundle) {
        boolean z = true;
        while (!this.b.isEmpty()) {
            a((t) this.b.remove());
        }
        v vVar = this.k;
        av.a(Looper.myLooper() == vVar.h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (vVar.i) {
            av.a(!vVar.g);
            vVar.h.removeMessages(1);
            vVar.g = true;
            if (vVar.c.size() != 0) {
                z = false;
            }
            av.a(z);
            ArrayList arrayList = new ArrayList(vVar.b);
            int i = vVar.f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (vVar.e && vVar.a.b() && vVar.f.get() == i) {
                    if (!vVar.c.contains(kVar)) {
                        kVar.a(bundle);
                    }
                }
            }
            vVar.c.clear();
            vVar.g = false;
        }
    }

    final void a(ay ayVar) {
        this.i.add(ayVar);
        ayVar.a(this.x);
    }

    public final void a(ConnectionResult connectionResult) {
        if (!com.google.android.gms.common.b.a(this.n, connectionResult.c)) {
            f();
        }
        if (!this.o) {
            v vVar = this.k;
            av.a(Looper.myLooper() == vVar.h.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
            vVar.h.removeMessages(1);
            synchronized (vVar.i) {
                ArrayList arrayList = new ArrayList(vVar.d);
                int i = vVar.f.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    if (!vVar.e || vVar.f.get() != i) {
                        break;
                    } else if (vVar.d.contains(lVar)) {
                        lVar.a(connectionResult);
                    }
                }
            }
            this.k.a();
        }
    }

    public final void a(l lVar) {
        this.k.a(lVar);
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.n);
        printWriter.append(str).append("mResuming=").print(this.o);
        printWriter.append(" mWorkQueue.size()=").print(this.b.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.i.size());
        if (this.l != null) {
            this.l.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean a(a aVar) {
        return this.d.containsKey(aVar.b());
    }

    public final void b() {
        this.j.lock();
        try {
            for (ay ayVar : this.i) {
                ayVar.a(null);
                if (ayVar.e() == null) {
                    ayVar.b();
                } else {
                    ayVar.d();
                    a(ayVar, this.u, a(ayVar.c()).e());
                }
            }
            this.i.clear();
            for (bh bhVar : this.t) {
                bhVar.a = null;
            }
            this.t.clear();
            if (this.l == null) {
                e();
                return;
            }
            f();
            this.l.b();
            this.k.a();
            this.j.unlock();
        } finally {
            this.j.unlock();
        }
    }

    public final void b(l lVar) {
        v vVar = this.k;
        av.a((Object) lVar);
        synchronized (vVar.i) {
            if (!vVar.d.remove(lVar)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + lVar + " not found");
            }
        }
    }

    public final boolean b(a aVar) {
        c cVar = (c) this.d.get(aVar.b());
        return cVar != null && cVar.b();
    }

    public final boolean c() {
        return this.l != null && this.l.c();
    }

    final void e() {
        for (ay ayVar : this.b) {
            ayVar.a(null);
            ayVar.b();
        }
        this.b.clear();
    }

    final boolean f() {
        if (!this.o) {
            return false;
        }
        this.o = false;
        this.r.removeMessages(2);
        this.r.removeMessages(1);
        if (this.c != null) {
            this.c.b();
            this.c = null;
        }
        return true;
    }

    final String g() {
        Writer stringWriter = new StringWriter();
        a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
