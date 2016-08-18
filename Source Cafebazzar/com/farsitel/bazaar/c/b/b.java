package com.farsitel.bazaar.c.b;

import com.farsitel.bazaar.g.a.i;
import java.util.Comparator;

final class b implements Comparator {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((i) obj2).f() - ((i) obj).f();
    }
}
