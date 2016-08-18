package com.google.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ap extends bh {
    private static ap h;
    boolean a;
    volatile Boolean b;
    at c;
    private h d;
    private Context e;
    private bg f;
    private final Map g;

    private ap(Context context) {
        this(context, aj.a(context));
    }

    private ap(Context context, h hVar) {
        this.b = Boolean.valueOf(false);
        this.g = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.e = context.getApplicationContext();
        this.d = hVar;
        i.a(this.e);
        bb.a(this.e);
        j.a(this.e);
        this.c = new m();
    }

    static ap a() {
        ap apVar;
        synchronized (ap.class) {
            try {
                apVar = h;
            } catch (Throwable th) {
                Class cls = ap.class;
            }
        }
        return apVar;
    }

    public static ap a(Context context) {
        ap apVar;
        synchronized (ap.class) {
            try {
                if (h == null) {
                    h = new ap(context);
                }
                apVar = h;
            } catch (Throwable th) {
                Class cls = ap.class;
            }
        }
        return apVar;
    }

    public final bg a(String str, String str2) {
        bg bgVar;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Tracker name cannot be empty");
            }
            bgVar = (bg) this.g.get(str);
            if (bgVar == null) {
                bgVar = new bg(str, str2, this);
                this.g.put(str, bgVar);
                if (this.f == null) {
                    this.f = bgVar;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                bgVar.a("&tid", str2);
            }
            an.a().a(ao.GET_TRACKER);
        }
        return bgVar;
    }

    final void a(Map map) {
        synchronized (this) {
            bi.a(map, "&ul", bi.a(Locale.getDefault()));
            bi.a(map, "&sr", bb.a().a("&sr"));
            map.put("&_u", an.a().c());
            an.a().b();
            this.d.a(map);
        }
    }

    public final boolean b() {
        an.a().a(ao.GET_DRY_RUN);
        return this.a;
    }
}
