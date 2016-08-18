package com.c.a;

import com.c.a.a.a.b;
import com.c.a.a.f;
import com.c.a.a.v;
import d.ab;
import java.io.IOException;

final class e implements b {
    boolean a;
    final /* synthetic */ c b;
    private final f c;
    private ab d;
    private ab e;

    public e(c cVar, f fVar) {
        this.b = cVar;
        this.c = fVar;
        this.d = fVar.a(1);
        this.e = new f(this, this.d, cVar, fVar);
    }

    public final void a() {
        synchronized (this.b) {
            if (this.a) {
                return;
            }
            this.a = true;
            c cVar = this.b;
            cVar.c++;
            v.a(this.d);
            try {
                this.c.b();
            } catch (IOException e) {
            }
        }
    }

    public final ab b() {
        return this.e;
    }
}
