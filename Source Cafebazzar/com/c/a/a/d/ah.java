package com.c.a.a.d;

import com.c.a.a.m;
import java.io.IOException;
import java.util.List;

final class ah extends m {
    final /* synthetic */ int b;
    final /* synthetic */ List c;
    final /* synthetic */ boolean d;
    final /* synthetic */ ac e;

    ah(ac acVar, String str, Object[] objArr, int i, List list, boolean z) {
        this.e = acVar;
        this.b = i;
        this.c = list;
        this.d = z;
        super(str, objArr);
    }

    public final void a() {
        this.e.v.b();
        try {
            this.e.i.a(this.b, a.CANCEL);
            synchronized (this.e) {
                this.e.y.remove(Integer.valueOf(this.b));
            }
        } catch (IOException e) {
        }
    }
}
