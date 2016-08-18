package com.google.android.gms.common.internal;

import java.util.Iterator;

public final class as {
    private final String a;

    public as(String str) {
        this.a = str;
    }

    private static CharSequence a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.a);
                stringBuilder.append(a(it.next()));
            }
        }
        return stringBuilder;
    }
}
