package com.c.a.a;

import com.c.a.as;
import java.util.LinkedHashSet;
import java.util.Set;

public final class u {
    private final Set a = new LinkedHashSet();

    public final void a(as asVar) {
        synchronized (this) {
            this.a.add(asVar);
        }
    }

    public final void b(as asVar) {
        synchronized (this) {
            this.a.remove(asVar);
        }
    }

    public final boolean c(as asVar) {
        boolean contains;
        synchronized (this) {
            contains = this.a.contains(asVar);
        }
        return contains;
    }
}
