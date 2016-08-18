package com.a.a.c;

import android.content.Context;
import b.a.a.a.a.b.l;
import b.a.a.a.a.f.a;
import b.a.a.a.f;
import java.io.File;
import java.util.Set;

final class bb {
    private static final bc a = new bc();
    private final Context b;
    private final a c;
    private ba d;

    public bb(Context context, a aVar) {
        this(context, aVar, null);
    }

    public bb(Context context, a aVar, String str) {
        this.b = context;
        this.c = aVar;
        this.d = a;
        a(str);
    }

    private File c() {
        File file = new File(this.c.a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final b a() {
        return this.d.a();
    }

    public final void a(String str) {
        this.d.b();
        this.d = a;
        if (str != null) {
            if (l.a(this.b, "com.crashlytics.CollectCustomLogs", true)) {
                this.d = new bv(new File(c(), "crashlytics-userlog-" + str + ".temp"), 65536);
                return;
            }
            f.a().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
        }
    }

    public final void a(Set set) {
        File[] listFiles = c().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                Object name = file.getName();
                int lastIndexOf = name.lastIndexOf(".temp");
                if (lastIndexOf != -1) {
                    name = name.substring(20, lastIndexOf);
                }
                if (!set.contains(name)) {
                    file.delete();
                }
            }
        }
    }

    public final void b() {
        this.d.c();
    }
}
