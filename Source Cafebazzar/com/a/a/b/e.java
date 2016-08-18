package com.a.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import b.a.a.a.a.a.b;
import b.a.a.a.a.b.ah;
import b.a.a.a.a.b.s;
import b.a.a.a.a.b.x;
import b.a.a.a.a.b.y;
import b.a.a.a.a.f.d;
import b.a.a.a.a.g.r;
import b.a.a.a.a.g.v;
import b.a.a.a.f;
import b.a.a.a.p;
import java.util.HashMap;
import java.util.Map;

public final class e extends p implements s {
    private final b a = new b();
    private final j b = new j();
    private l c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.a.a.b.f a(android.content.Context r9) {
        /*
        r2 = 0;
        r0 = r9.getAssets();	 Catch:{ Exception -> 0x0082, all -> 0x00c7 }
        r1 = "crashlytics-build.properties";
        r3 = r0.open(r1);	 Catch:{ Exception -> 0x0082, all -> 0x00c7 }
        if (r3 == 0) goto L_0x00c3;
    L_0x000d:
        r0 = new java.util.Properties;	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r0.<init>();	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r0.load(r3);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r1 = new com.a.a.b.f;	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r4 = "version_code";
        r4 = r0.getProperty(r4);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r5 = "version_name";
        r5 = r0.getProperty(r5);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r6 = "build_id";
        r6 = r0.getProperty(r6);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r7 = "package_name";
        r0 = r0.getProperty(r7);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r1.<init>(r4, r5, r6, r0);	 Catch:{ Exception -> 0x00b8, all -> 0x00a3 }
        r0 = b.a.a.a.f.a();	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r2 = "Beta";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4.<init>();	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = r1.d;	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = " build properties: ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = r1.b;	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = " (";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = r1.a;	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = ") - ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r5 = r1.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r0.a(r2, r4);	 Catch:{ Exception -> 0x00bd, all -> 0x00a3 }
        r0 = r1;
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r3.close();	 Catch:{ IOException -> 0x0075 }
    L_0x0074:
        return r0;
    L_0x0075:
        r1 = move-exception;
        r2 = b.a.a.a.f.a();
        r3 = "Beta";
        r4 = "Error closing Beta build properties asset";
        r2.c(r3, r4, r1);
        goto L_0x0074;
    L_0x0082:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0085:
        r3 = b.a.a.a.f.a();	 Catch:{ all -> 0x00c5 }
        r4 = "Beta";
        r5 = "Error reading Beta build properties";
        r3.c(r4, r5, r1);	 Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x0074;
    L_0x0092:
        r2.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x0074;
    L_0x0096:
        r1 = move-exception;
        r2 = b.a.a.a.f.a();
        r3 = "Beta";
        r4 = "Error closing Beta build properties asset";
        r2.c(r3, r4, r1);
        goto L_0x0074;
    L_0x00a3:
        r0 = move-exception;
        r2 = r3;
    L_0x00a5:
        if (r2 == 0) goto L_0x00aa;
    L_0x00a7:
        r2.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00aa:
        throw r0;
    L_0x00ab:
        r1 = move-exception;
        r2 = b.a.a.a.f.a();
        r3 = "Beta";
        r4 = "Error closing Beta build properties asset";
        r2.c(r3, r4, r1);
        goto L_0x00aa;
    L_0x00b8:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x0085;
    L_0x00bd:
        r0 = move-exception;
        r2 = r3;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0085;
    L_0x00c3:
        r0 = r2;
        goto L_0x006f;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x00c7:
        r0 = move-exception;
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.e.a(android.content.Context):com.a.a.b.f");
    }

    private String a(Context context, String str) {
        boolean equals = VERSION.SDK_INT < 11 ? str == null : "io.crash.air".equals(str);
        if (equals) {
            f.a().a("Beta", "App was possibly installed by Beta. Getting device token");
            try {
                String str2 = (String) this.a.a(context, this.b);
                if ("".equals(str2)) {
                    str2 = null;
                }
                return str2;
            } catch (Throwable e) {
                f.a().c("Beta", "Failed to load the Beta device token", e);
                return null;
            }
        }
        f.a().a("Beta", "App was not installed by Beta. Skipping device token");
        return null;
    }

    public final String a() {
        return "1.1.4.92";
    }

    @TargetApi(14)
    protected final boolean a_() {
        this.p.getApplicationContext();
        this.c = VERSION.SDK_INT >= 14 ? new b(this.n.d, this.n.c) : new k();
        return true;
    }

    public final String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public final Map c() {
        CharSequence a = a(this.p, this.r.d());
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(y.FONT_TOKEN, a);
        }
        return hashMap;
    }

    protected final /* synthetic */ Object e() {
        boolean z = false;
        f.a().a("Beta", "Beta kit initializing...");
        Context context = this.p;
        x xVar = this.r;
        if (TextUtils.isEmpty(a(context, xVar.d()))) {
            f.a().a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        f.a().a("Beta", "Beta device token is present, checking for app updates.");
        v a = r.a.a();
        b.a.a.a.a.g.f fVar = a != null ? a.f : null;
        f a2 = a(context);
        if (!(fVar == null || TextUtils.isEmpty(fVar.a) || a2 == null)) {
            z = true;
        }
        if (z) {
            this.c.a(context, this, xVar, fVar, a2, new d(this), new ah(), new b.a.a.a.a.e.b(f.a()));
        }
        return Boolean.valueOf(true);
    }
}
