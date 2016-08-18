package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class a implements Iterator {
    Iterator a = this.b.b.keySet().iterator();
    final /* synthetic */ EventParams b;

    a(EventParams eventParams) {
        this.b = eventParams;
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
