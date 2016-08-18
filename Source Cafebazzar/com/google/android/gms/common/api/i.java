package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.f.a;
import android.view.View;
import com.google.android.gms.a.ar;
import com.google.android.gms.a.bi;
import com.google.android.gms.a.bj;
import com.google.android.gms.a.cu;
import com.google.android.gms.a.da;
import com.google.android.gms.a.w;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class i {
    public final Set a = new HashSet();
    public final Set b = new HashSet();
    public final Map c = new a();
    FragmentActivity d;
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    private Account g;
    private int h;
    private View i;
    private String j;
    private String k;
    private final Map l = new a();
    private final Context m;
    private int n = -1;
    private l o;
    private Looper p;
    private b q = b.a();
    private b r = cu.c;
    private da s;

    public i(Context context) {
        this.m = context;
        this.p = context.getMainLooper();
        this.j = context.getPackageName();
        this.k = context.getClass().getName();
    }

    public final h a() {
        if (this.c.containsKey(cu.g)) {
            av.a(this.s == null, (Object) "SignIn.API can't be used in conjunction with requestServerAuthCode.");
            this.s = (da) this.c.get(cu.g);
        }
        return new h(this.g, this.a, this.l, this.h, this.i, this.j, this.k, this.s != null ? this.s : da.a);
    }

    void a(bi biVar, h hVar) {
        int i = this.n;
        l lVar = this.o;
        av.a((Object) hVar, (Object) "GoogleApiClient instance cannot be null");
        av.a(biVar.c.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        biVar.c.put(i, new bj(biVar, i, hVar, lVar));
        if (biVar.a && !biVar.b) {
            hVar.a();
        }
    }

    public final h b() {
        av.b(!this.c.isEmpty(), "must call addApi() to add at least one API");
        h a = a();
        Map map = a.d;
        a aVar = new a();
        Map aVar2 = new a();
        ArrayList arrayList = new ArrayList();
        for (a aVar3 : this.c.keySet()) {
            Object dVar;
            Object obj = this.c.get(aVar3);
            int i = 0;
            if (map.get(aVar3) != null) {
                i = ((com.google.android.gms.common.internal.i) map.get(aVar3)).b ? 1 : 2;
            }
            aVar.put(aVar3, Integer.valueOf(i));
            k wVar = new w(aVar3, i);
            arrayList.add(wVar);
            if ((aVar3.b != null ? 1 : null) != null) {
                av.a(aVar3.a != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
                f fVar = aVar3.a;
                dVar = new d(this.m, this.p, fVar.b(), wVar, wVar, a, fVar.a());
            } else {
                dVar = aVar3.a().a(this.m, this.p, a, obj, wVar, wVar);
            }
            aVar2.put(aVar3.b(), dVar);
        }
        h arVar = new ar(this.m, new ReentrantLock(), this.p, a, this.q, this.r, aVar, this.e, this.f, aVar2, this.n, ar.a(aVar2.values(), true), arrayList);
        synchronized (h.a) {
            h.a.add(arVar);
        }
        if (this.n >= 0) {
            bi a2 = bi.a(this.d);
            if (a2 == null) {
                new Handler(this.m.getMainLooper()).post(new j(this, arVar));
            } else {
                a(a2, arVar);
            }
        }
        return arVar;
    }
}
