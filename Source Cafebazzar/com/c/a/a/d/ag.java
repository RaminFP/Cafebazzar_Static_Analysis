package com.c.a.a.d;

import com.c.a.a.m;
import java.io.IOException;
import java.util.List;

final class ag extends m {
    final /* synthetic */ int b;
    final /* synthetic */ List c;
    final /* synthetic */ ac d;

    ag(ac acVar, String str, Object[] objArr, int i, List list) {
        this.d = acVar;
        this.b = i;
        this.c = list;
        super(str, objArr);
    }

    public final void a() {
        this.d.v.a();
        try {
            this.d.i.a(this.b, a.CANCEL);
            synchronized (this.d) {
                this.d.y.remove(Integer.valueOf(this.b));
            }
        } catch (IOException e) {
        }
    }
}
