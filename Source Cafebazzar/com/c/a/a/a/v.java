package com.c.a.a.a;

import java.util.Comparator;

final class v implements Comparator {
    v() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : String.CASE_INSENSITIVE_ORDER.compare(str, str2);
    }
}
