package com.farsitel.bazaar.h;

import com.android.a.o;
import com.android.a.r;
import com.farsitel.bazaar.f.k;
import com.farsitel.bazaar.util.q;

final class e implements Runnable {
    private k a;
    private final Object[] b;
    private final String c;
    private final int d;
    private final Object e;
    private final r f;

    public e(k kVar, Object[] objArr, String str, int i, Object obj, r rVar) {
        this.a = kVar;
        this.b = objArr;
        this.c = str;
        this.d = i;
        this.e = obj;
        this.f = rVar;
    }

    public final void run() {
        o wVar = new w(new u(this.a, this.b, this.c), this.d);
        Object a = ab.a(wVar.m);
        if (a != null) {
            wVar.a(a);
        } else if (q.e()) {
            if (this.e != null) {
                wVar.l = this.e;
            }
            this.f.a(wVar);
        } else {
            c cVar = new c(10002, 2131165466);
            if (this.d != 0) {
                v.a(cVar, this.d);
            }
        }
    }
}
