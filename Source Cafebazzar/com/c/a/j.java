package com.c.a;

import com.c.a.a.a.e;
import java.util.concurrent.TimeUnit;

public final class j {
    public static final j a;
    public static final j b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    String l;
    private final int m;
    private final boolean n;

    static {
        k kVar = new k();
        kVar.a = true;
        a = kVar.c();
        k kVar2 = new k();
        kVar2.f = true;
        long toSeconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        kVar2.d = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
        b = kVar2.c();
    }

    private j(k kVar) {
        this.c = kVar.a;
        this.d = kVar.b;
        this.e = kVar.c;
        this.m = -1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = kVar.d;
        this.j = kVar.e;
        this.k = kVar.f;
        this.n = kVar.g;
    }

    private j(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.c = z;
        this.d = z2;
        this.e = i;
        this.m = i2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = i3;
        this.j = i4;
        this.k = z6;
        this.n = z7;
        this.l = str;
    }

    public static j a(z zVar) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int length = zVar.a.length / 2;
        String str = null;
        boolean z7 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (i < length) {
            int i6;
            String a = zVar.a(i);
            String b = zVar.b(i);
            if (a.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                i6 = i5;
                i5 = i4;
                i4 = i3;
                i3 = i2;
                i++;
                i2 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i6;
            }
            i6 = i5;
            i5 = i4;
            i4 = i3;
            i3 = i2;
            i2 = 0;
            while (i2 < b.length()) {
                String str2;
                int a2 = e.a(b, i2, "=,;");
                String trim = b.substring(i2, a2).trim();
                if (a2 == b.length() || b.charAt(a2) == ',' || b.charAt(a2) == ';') {
                    i2 = a2 + 1;
                    str2 = null;
                } else {
                    i2 = e.a(b, a2 + 1);
                    String trim2;
                    if (i2 >= b.length() || b.charAt(i2) != '\"') {
                        a2 = e.a(b, i2, ",;");
                        trim2 = b.substring(i2, a2).trim();
                        i2 = a2;
                        str2 = trim2;
                    } else {
                        i2++;
                        a2 = e.a(b, i2, "\"");
                        trim2 = b.substring(i2, a2);
                        i2 = a2 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i3 = e.b(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i4 = e.b(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i5 = e.b(str2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i6 = e.b(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z6 = true;
                }
            }
            i++;
            i2 = i3;
            i3 = i4;
            i4 = i5;
            i5 = i6;
        }
        return new j(z7, z, i2, i3, z2, z3, z4, i4, i5, z5, z6, obj == null ? null : str);
    }

    public final String toString() {
        String str = this.l;
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.c) {
                stringBuilder.append("no-cache, ");
            }
            if (this.d) {
                stringBuilder.append("no-store, ");
            }
            if (this.e != -1) {
                stringBuilder.append("max-age=").append(this.e).append(", ");
            }
            if (this.m != -1) {
                stringBuilder.append("s-maxage=").append(this.m).append(", ");
            }
            if (this.f) {
                stringBuilder.append("private, ");
            }
            if (this.g) {
                stringBuilder.append("public, ");
            }
            if (this.h) {
                stringBuilder.append("must-revalidate, ");
            }
            if (this.i != -1) {
                stringBuilder.append("max-stale=").append(this.i).append(", ");
            }
            if (this.j != -1) {
                stringBuilder.append("min-fresh=").append(this.j).append(", ");
            }
            if (this.k) {
                stringBuilder.append("only-if-cached, ");
            }
            if (this.n) {
                stringBuilder.append("no-transform, ");
            }
            if (stringBuilder.length() == 0) {
                str = "";
            } else {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                str = stringBuilder.toString();
            }
            this.l = str;
        }
        return str;
    }
}
