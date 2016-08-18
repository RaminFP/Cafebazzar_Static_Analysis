package com.a.a.c;

import b.a.a.a.a.b.j;
import b.a.a.a.f;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class by {
    static final Map a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final FilenameFilter b = new bz();
    private static final short[] c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object d = new Object();
    private final at e;
    private Thread f;

    public by(at atVar) {
        if (atVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.e = atVar;
    }

    final List a() {
        f.a().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.d) {
            File[] listFiles = h.f().j().listFiles(b);
        }
        List linkedList = new LinkedList();
        for (File file : listFiles) {
            f.a().a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add(new cc(file));
        }
        if (linkedList.isEmpty()) {
            f.a().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    public final void a(float f) {
        synchronized (this) {
            if (this.f == null) {
                this.f = new Thread(new ca(this, f), "Crashlytics Report Uploader");
                this.f.start();
            }
        }
    }

    final boolean a(bx bxVar) {
        boolean z;
        synchronized (this.d) {
            try {
                boolean a = this.e.a(new as(new j().a(h.f().p), bxVar));
                f.a().c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + bxVar.b());
                if (a) {
                    bxVar.a();
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable e) {
                f.a().c("CrashlyticsCore", "Error occurred sending report " + bxVar, e);
                z = false;
            }
        }
        return z;
    }
}
