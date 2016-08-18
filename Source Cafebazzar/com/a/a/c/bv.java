package com.a.a.c;

import b.a.a.a.a.b.ab;
import b.a.a.a.a.b.l;
import b.a.a.a.f;
import java.io.File;

final class bv implements ba {
    private final File a;
    private final int b;
    private ab c;

    public bv(File file, int i) {
        this.a = file;
        this.b = i;
    }

    public final b a() {
        if (this.a.exists()) {
            if (this.c == null) {
                try {
                    this.c = new ab(this.a);
                } catch (Throwable e) {
                    f.a().c("CrashlyticsCore", "Could not open log file: " + this.a, e);
                }
            }
            if (this.c != null) {
                int[] iArr = new int[]{0};
                byte[] bArr = new byte[this.c.a()];
                try {
                    this.c.a(new bw(this, bArr, iArr));
                } catch (Throwable e2) {
                    f.a().c("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e2);
                }
                return b.a(bArr, 0, iArr[0]);
            }
        }
        return null;
    }

    public final void b() {
        l.a(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    public final void c() {
        b();
        this.a.delete();
    }
}
