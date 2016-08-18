package com.a.a.c;

import b.a.a.a.f;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class cc implements bx {
    private final File a;
    private final Map b;

    public cc(File file) {
        this(file, Collections.emptyMap());
    }

    public cc(File file, Map map) {
        this.a = file;
        this.b = new HashMap(map);
        if (this.a.length() == 0) {
            this.b.putAll(by.a);
        }
    }

    public final boolean a() {
        f.a().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
        return this.a.delete();
    }

    public final String b() {
        return this.a.getName();
    }

    public final String c() {
        String b = b();
        return b.substring(0, b.lastIndexOf(46));
    }

    public final File d() {
        return this.a;
    }

    public final Map e() {
        return Collections.unmodifiableMap(this.b);
    }
}
