package com.google.a.a.a;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class ah {
    final Map a;
    final long b;
    final String c;
    final List d;

    public ah(Map map, long j, String str, List list) {
        this.a = map;
        this.b = j;
        this.c = str;
        this.d = list;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PATH: ");
        stringBuilder.append(this.c);
        if (this.a != null) {
            stringBuilder.append("  PARAMS: ");
            for (Entry entry : this.a.entrySet()) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append(",  ");
            }
        }
        return stringBuilder.toString();
    }
}
