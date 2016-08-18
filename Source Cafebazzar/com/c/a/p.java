package com.c.a;

import com.c.a.a.v;

public final class p {
    public final String a;
    public final String b;

    public p(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && v.a(this.a, ((p) obj).a) && v.a(this.b, ((p) obj).b);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.b != null ? this.b.hashCode() : 0;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return ((hashCode + 899) * 31) + i;
    }

    public final String toString() {
        return this.a + " realm=\"" + this.b + "\"";
    }
}
