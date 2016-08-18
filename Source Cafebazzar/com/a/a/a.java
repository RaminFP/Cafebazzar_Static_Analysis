package com.a.a;

import b.a.a.a.f;
import b.a.a.a.p;
import b.a.a.a.q;
import com.a.a.b.e;
import com.a.a.c.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class a extends p implements q {
    public final com.a.a.a.a a;
    public final e b;
    public final h c;
    public final Collection d;

    public a() {
        this(new com.a.a.a.a(), new e(), new h());
    }

    private a(com.a.a.a.a aVar, e eVar, h hVar) {
        this.a = aVar;
        this.b = eVar;
        this.c = hVar;
        this.d = Collections.unmodifiableCollection(Arrays.asList(new p[]{aVar, eVar, hVar}));
    }

    public static void a(String str) {
        f();
        h hVar = d().c;
        if (!hVar.l) {
            hVar.d = h.b(str);
            hVar.c.a(hVar.d, hVar.f, hVar.e);
        }
    }

    public static void a(String str, int i) {
        f();
        d().c.a(str, Integer.toString(i));
    }

    public static void a(String str, String str2) {
        f();
        d().c.a(str, str2);
    }

    public static void a(String str, boolean z) {
        f();
        d().c.a(str, Boolean.toString(z));
    }

    public static void b(String str) {
        f();
        h hVar = d().c;
        if (!hVar.l) {
            hVar.e = h.b(str);
            hVar.c.a(hVar.d, hVar.f, hVar.e);
        }
    }

    public static a d() {
        return (a) f.a(a.class);
    }

    private static void f() {
        if (d() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    public final String a() {
        return "2.5.5.97";
    }

    public final String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public final Collection c() {
        return this.d;
    }

    protected final /* bridge */ /* synthetic */ Object e() {
        return null;
    }
}
