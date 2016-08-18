package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class au {
    private final List a;
    private final Object b;

    private au(Object obj) {
        this.b = av.a(obj);
        this.a = new ArrayList();
    }

    public final au a(String str, Object obj) {
        this.a.add(((String) av.a((Object) str)) + "=" + String.valueOf(obj));
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
