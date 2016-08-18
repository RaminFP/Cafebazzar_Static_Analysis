package com.c.a.a.d;

import com.c.a.a.m;
import d.f;
import java.io.IOException;

final class ai extends m {
    final /* synthetic */ int b;
    final /* synthetic */ f c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ ac f;

    ai(ac acVar, String str, Object[] objArr, int i, f fVar, int i2, boolean z) {
        this.f = acVar;
        this.b = i;
        this.c = fVar;
        this.d = i2;
        this.e = z;
        super(str, objArr);
    }

    public final void a() {
        try {
            this.f.v.a(this.c, this.d);
            this.f.i.a(this.b, a.CANCEL);
            synchronized (this.f) {
                this.f.y.remove(Integer.valueOf(this.b));
            }
        } catch (IOException e) {
        }
    }
}
