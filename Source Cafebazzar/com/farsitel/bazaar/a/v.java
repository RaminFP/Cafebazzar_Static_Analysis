package com.farsitel.bazaar.a;

import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.e;
import java.util.Collection;
import java.util.Collections;

final class v implements Runnable {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final void run() {
        a aVar = this.a.i;
        String string = this.a.c.getString(2131165424);
        af afVar = af.INSTANCE;
        Collection a = af.a(false);
        Collections.sort(a, new e());
        aVar.a(string, a);
        if (this.a.f != null) {
            this.a.a.post(new w(this));
        }
    }
}
