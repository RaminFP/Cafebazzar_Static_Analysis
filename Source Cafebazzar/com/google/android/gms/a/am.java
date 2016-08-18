package com.google.android.gms.a;

import com.google.android.gms.common.api.c;
import java.util.ArrayList;
import java.util.Iterator;

final class am extends ap {
    final /* synthetic */ ac a;
    private final ArrayList c;

    public am(ac acVar, ArrayList arrayList) {
        this.a = acVar;
        super(acVar);
        this.c = arrayList;
    }

    public final void a() {
        if (this.a.a.m.e.isEmpty()) {
            this.a.a.m.e = this.a.i();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this.a.g, this.a.a.m.e);
        }
    }
}
