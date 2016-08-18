package com.a.a.a;

import b.a.a.a.a.b.a;
import b.a.a.a.a.b.ag;
import b.a.a.a.a.d.h;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.a.e.m;
import b.a.a.a.f;
import b.a.a.a.p;
import java.io.File;
import java.util.List;

final class ah extends a implements h {
    private final String c;

    public ah(p pVar, String str, String str2, m mVar, String str3) {
        super(pVar, str, str2, mVar, d.b);
        this.c = str3;
    }

    public final boolean a(List list) {
        e a = a().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.b.a()).a("X-CRASHLYTICS-API-KEY", this.c);
        int i = 0;
        for (File file : list) {
            a.a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        f.a().a("Answers", "Sending " + list.size() + " analytics files to " + this.a);
        int b = a.b();
        f.a().a("Answers", "Response code for analytics file send is " + b);
        return ag.a(b) == 0;
    }
}
