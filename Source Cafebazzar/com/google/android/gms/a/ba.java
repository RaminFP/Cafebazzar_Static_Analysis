package com.google.android.gms.a;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class ba implements bf {
    final Lock a;
    final Condition b;
    final Context c;
    final b d;
    final bc e;
    final Map f;
    final Map g = new HashMap();
    final h h;
    final Map i;
    final com.google.android.gms.common.api.b j;
    volatile az k;
    int l;
    final ar m;
    final bg n;
    private ConnectionResult o = null;

    public ba(Context context, ar arVar, Lock lock, Looper looper, b bVar, Map map, h hVar, Map map2, com.google.android.gms.common.api.b bVar2, ArrayList arrayList, bg bgVar) {
        this.c = context;
        this.a = lock;
        this.d = bVar;
        this.f = map;
        this.h = hVar;
        this.i = map2;
        this.j = bVar2;
        this.m = arVar;
        this.n = bgVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((w) it.next()).b = this;
        }
        this.e = new bc(this, looper);
        this.b = lock.newCondition();
        this.k = new aq(this);
    }

    public final t a(t tVar) {
        return this.k.a(tVar);
    }

    public final void a() {
        this.k.c();
    }

    public final void a(int i) {
        this.a.lock();
        try {
            this.k.a(i);
        } finally {
            this.a.unlock();
        }
    }

    final void a(bb bbVar) {
        this.e.sendMessage(this.e.obtainMessage(1, bbVar));
    }

    final void a(ConnectionResult connectionResult) {
        this.a.lock();
        try {
            this.o = connectionResult;
            this.k = new aq(this);
            this.k.a();
            this.b.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (a aVar : this.i.keySet()) {
            printWriter.append(str).append(aVar.c).println(":");
            ((c) this.f.get(aVar.b())).a(str2, printWriter);
        }
    }

    public final void b() {
        this.g.clear();
        this.k.b();
    }

    public final boolean c() {
        return this.k instanceof aa;
    }
}
