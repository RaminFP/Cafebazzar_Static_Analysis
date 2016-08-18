package com.google.android.gms.a;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.b;
import java.util.Map;

final class ak extends ap {
    final /* synthetic */ ac a;
    private final Map c;

    public ak(ac acVar, Map map) {
        this.a = acVar;
        super(acVar);
        this.c = map;
    }

    public final void a() {
        int a = b.a(this.a.c);
        if (a != 0) {
            this.a.a.a(new al(this, this.a, new ConnectionResult(a, null)));
            return;
        }
        if (this.a.e) {
            this.a.d.i();
        }
        for (c cVar : this.c.keySet()) {
            cVar.a((o) this.c.get(cVar));
        }
    }
}
