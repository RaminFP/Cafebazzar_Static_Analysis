package com.a.a.c;

import b.a.a.a.a.b.a;
import b.a.a.a.a.b.ag;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.a.e.m;
import b.a.a.a.f;
import b.a.a.a.p;
import java.util.Map.Entry;

final class au extends a implements at {
    public au(p pVar, String str, String str2, m mVar) {
        super(pVar, str, str2, mVar, d.b);
    }

    public final boolean a(as asVar) {
        e a = a().a("X-CRASHLYTICS-API-KEY", asVar.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        h.f();
        a = a.a("X-CRASHLYTICS-API-CLIENT-VERSION", "2.3.8.97");
        e eVar = a;
        for (Entry entry : asVar.b.e().entrySet()) {
            eVar = eVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        bx bxVar = asVar.b;
        a = eVar.a("report[file]", bxVar.b(), "application/octet-stream", bxVar.d()).a("report[identifier]", null, bxVar.c());
        f.a().a("CrashlyticsCore", "Sending report to: " + this.a);
        int b = a.b();
        f.a().a("CrashlyticsCore", "Create report request ID: " + a.a("X-REQUEST-ID"));
        f.a().a("CrashlyticsCore", "Result was: " + b);
        return ag.a(b) == 0;
    }
}
