package com.a.a.a;

import java.util.Map;

final class ak {
    public final an a;
    public final long b;
    public final am c;
    public final Map d;
    public final String e;
    public final Map f;
    public final String g;
    public final Map h;
    private String i;

    private ak(an anVar, long j, am amVar, Map map, String str, Map map2, String str2, Map map3) {
        this.a = anVar;
        this.b = j;
        this.c = amVar;
        this.d = map;
        this.e = str;
        this.f = map2;
        this.g = str2;
        this.h = map3;
    }

    public final String toString() {
        if (this.i == null) {
            this.i = "[" + getClass().getSimpleName() + ": timestamp=" + this.b + ", type=" + this.c + ", details=" + this.d + ", customType=" + this.e + ", customAttributes=" + this.f + ", predefinedType=" + this.g + ", predefinedAttributes=" + this.h + ", metadata=[" + this.a + "]]";
        }
        return this.i;
    }
}
