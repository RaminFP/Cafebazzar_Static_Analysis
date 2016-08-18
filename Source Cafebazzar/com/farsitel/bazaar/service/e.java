package com.farsitel.bazaar.service;

import com.farsitel.bazaar.database.g;
import java.util.ArrayList;

final class e implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ d b;

    e(d dVar, ArrayList arrayList) {
        this.b = dVar;
        this.a = arrayList;
    }

    public final void run() {
        if (g.a().a(this.a)) {
            this.b.a.b.post(new f(this));
        }
    }
}
