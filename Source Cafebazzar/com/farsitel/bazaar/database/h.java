package com.farsitel.bazaar.database;

import com.farsitel.bazaar.g.d;
import java.util.Comparator;

final class h implements Comparator {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        d dVar = (d) obj;
        d dVar2 = (d) obj2;
        if (dVar.e && !dVar2.e) {
            return -1;
        }
        if (!dVar.e) {
            boolean z = dVar2.e;
        }
        return 1;
    }
}
