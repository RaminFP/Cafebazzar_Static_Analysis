package com.google.android.gms.a;

import com.google.android.gms.common.api.c;
import java.util.ArrayList;
import java.util.Iterator;

final class ao extends ap {
    final /* synthetic */ ac a;
    private final ArrayList c;

    public ao(ac acVar, ArrayList arrayList) {
        this.a = acVar;
        super(acVar);
        this.c = arrayList;
    }

    public final void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this.a.g);
        }
    }
}
