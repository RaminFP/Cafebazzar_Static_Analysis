package com.google.android.gms.a;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.f.a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public final class x implements bf {
    final ba a;
    final ba b;
    Bundle c;
    ConnectionResult d = null;
    ConnectionResult e = null;
    final Lock f;
    private final Context g;
    private final ar h;
    private final Looper i;
    private final Map j = new a();
    private final Set k = Collections.newSetFromMap(new WeakHashMap());
    private final c l;
    private final AtomicInteger m = new AtomicInteger(0);
    private int n = 0;

    public x(Context context, ar arVar, Lock lock, Looper looper, b bVar, Map map, h hVar, Map map2, com.google.android.gms.common.api.b bVar2, ArrayList arrayList) {
        this.g = context;
        this.h = arVar;
        this.f = lock;
        this.i = looper;
        Map aVar = new a();
        Map aVar2 = new a();
        for (d dVar : map.keySet()) {
            c cVar = (c) map.get(dVar);
            if (cVar.c()) {
                aVar.put(dVar, cVar);
            } else {
                aVar2.put(dVar, cVar);
            }
        }
        this.l = null;
        if (aVar.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        Map aVar3 = new a();
        Map aVar4 = new a();
        for (com.google.android.gms.common.api.a aVar5 : map2.keySet()) {
            d b = aVar5.b();
            if (aVar.containsKey(b)) {
                aVar3.put(aVar5, map2.get(aVar5));
            } else if (aVar2.containsKey(b)) {
                aVar4.put(aVar5, map2.get(aVar5));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (aVar3.containsKey(wVar.a)) {
                arrayList2.add(wVar);
            } else if (aVar4.containsKey(wVar.a)) {
                arrayList3.add(wVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.a = new ba(context2, this.h, lock, looper, bVar, aVar2, null, aVar4, null, arrayList3, new y(this));
        Context context3 = context;
        this.b = new ba(context3, this.h, lock, looper, bVar, aVar, hVar, aVar3, bVar2, arrayList2, new z(this));
        for (d dVar2 : aVar2.keySet()) {
            this.j.put(dVar2, this.a);
        }
        for (d dVar22 : aVar.keySet()) {
            this.j.put(dVar22, this.b);
        }
    }

    static /* synthetic */ void a(x xVar) {
        if (b(xVar.d)) {
            if (b(xVar.e) || xVar.e()) {
                switch (xVar.n) {
                    case 1:
                        break;
                    case 2:
                        xVar.h.a(xVar.c);
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                        break;
                }
                xVar.d();
                xVar.n = 0;
            } else if (xVar.e == null) {
            } else {
                if (xVar.n == 1) {
                    xVar.d();
                    return;
                }
                xVar.a(xVar.e);
                xVar.a.b();
            }
        } else if (xVar.d != null && b(xVar.e)) {
            xVar.b.b();
            xVar.a(xVar.d);
        } else if (xVar.d != null && xVar.e != null) {
            ConnectionResult connectionResult = xVar.d;
            if (xVar.b.l < xVar.a.l) {
                connectionResult = xVar.e;
            }
            xVar.a(connectionResult);
        }
    }

    static /* synthetic */ void a(x xVar, ba baVar, int i) {
        if (xVar.m.getAndIncrement() % 2 == 1) {
            xVar.h.a(i);
        }
        baVar.a(i);
        xVar.e = null;
        xVar.d = null;
    }

    private void a(ConnectionResult connectionResult) {
        switch (this.n) {
            case 1:
                break;
            case 2:
                this.h.a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        d();
        this.n = 0;
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.b();
    }

    private void d() {
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.k.clear();
    }

    private boolean e() {
        return this.e != null && this.e.c == 4;
    }

    public final t a(t tVar) {
        d dVar = tVar.a;
        av.b(this.j.containsKey(dVar), "GoogleApiClient is not configured to use the API required for this call.");
        if (!((ba) this.j.get(dVar)).equals(this.b)) {
            return this.a.a(tVar);
        }
        if (!e()) {
            return this.b.a(tVar);
        }
        tVar.a(new Status(4, null, this.l == null ? null : PendingIntent.getActivity(this.g, System.identityHashCode(this.h), this.l.d(), 134217728)));
        return tVar;
    }

    public final void a() {
        this.n = 2;
        this.e = null;
        this.d = null;
        this.a.a();
        this.b.a();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.b.a(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("unauthClient").println(":");
        this.a.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final void b() {
        this.e = null;
        this.d = null;
        this.n = 0;
        this.a.b();
        this.b.b();
        d();
    }

    public final boolean c() {
        boolean z = true;
        this.f.lock();
        try {
            if (!(this.a.c() && (this.b.c() || e() || this.n == 1))) {
                z = false;
            }
            this.f.unlock();
            return z;
        } catch (Throwable th) {
            this.f.unlock();
        }
    }
}
