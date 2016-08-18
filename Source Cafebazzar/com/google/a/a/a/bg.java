package com.google.a.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bg {
    private final String a;
    private final bh b;
    private final Map c;
    private long d;
    private long e;
    private final j f;
    private final bb g;
    private final i h;

    bg(String str, String str2, bh bhVar) {
        this(str, str2, bhVar, j.a(), bb.a(), i.a());
    }

    private bg(String str, String str2, bh bhVar, j jVar, bb bbVar, i iVar) {
        this.c = new HashMap();
        this.d = 120000;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        }
        this.a = str;
        this.b = bhVar;
        this.c.put("&tid", str2);
        this.c.put("useSecure", "1");
        this.f = jVar;
        this.g = bbVar;
        this.h = iVar;
    }

    private boolean a() {
        boolean z;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.d < 120000) {
                long j = currentTimeMillis - this.e;
                if (j > 0) {
                    this.d = Math.min(120000, j + this.d);
                }
            }
            this.e = currentTimeMillis;
            if (this.d >= 2000) {
                this.d -= 2000;
                z = true;
            } else {
                as.d("Excessive tracking detected.  Tracking call ignored.");
                z = false;
            }
        }
        return z;
    }

    public final void a(String str, String str2) {
        an.a().a(ao.SET);
        if (str2 == null) {
            this.c.remove(str);
        } else {
            this.c.put(str, str2);
        }
    }

    public void a(Map map) {
        an.a().a(ao.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.c);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            as.d(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            as.d(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (str.equals("transaction") || str.equals("item") || a()) {
            this.b.a(hashMap);
        } else {
            as.d("Too many hits sent too quickly, rate limiting invoked.");
        }
    }
}
