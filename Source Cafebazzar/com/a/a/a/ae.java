package com.a.a.a;

import java.util.Set;

final class ae implements w {
    static final Set b = new af();
    final int a;

    public ae(int i) {
        this.a = i;
    }

    public final boolean a(ak akVar) {
        boolean z = b.contains(akVar.c) && akVar.a.g == null;
        return z && (Math.abs(akVar.a.c.hashCode() % this.a) != 0);
    }
}
