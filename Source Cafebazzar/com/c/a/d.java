package com.c.a;

import com.c.a.a.a.b;
import com.c.a.a.a.c;
import com.c.a.a.f;
import com.c.a.a.i;
import com.c.a.a.l;
import java.io.IOException;

final class d implements l {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final b a(ap apVar) {
        return this.a.a(apVar);
    }

    public final ap a(al alVar) {
        return this.a.a(alVar);
    }

    public final void a() {
        this.a.a();
    }

    public final void a(c cVar) {
        this.a.a(cVar);
    }

    public final void a(ap apVar, ap apVar2) {
        c cVar = this.a;
        i iVar = new i(apVar2);
        i a = ((g) apVar.g).a;
        try {
            f a2 = a.d.a(a.a, a.b);
            if (a2 != null) {
                iVar.a(a2);
                a2.a();
            }
        } catch (IOException e) {
            c.a(null);
        }
    }

    public final void b(al alVar) {
        this.a.b(alVar);
    }
}
