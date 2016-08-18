package com.b.b;

import android.content.Context;
import java.io.File;
import java.util.Map;

public class c {
    private static final String b = c.class.getSimpleName();
    boolean a;
    private final d c;
    private final File d;
    private String e;

    public c() {
        this(ah.a.b);
    }

    private c(Context context) {
        this.c = new d();
        this.d = context.getFileStreamPath(".flurryinstallreceiver.");
        ba.a(3, b, "Referrer file name if it exists:  " + this.d);
    }

    public final Map a(boolean z) {
        Map a;
        synchronized (this) {
            if (!this.a) {
                this.a = true;
                ba.a(4, b, "Loading referrer info from file: " + this.d.getAbsolutePath());
                String b = aw.b(this.d);
                ba.a(b, "Referrer file contents: " + b);
                if (b != null) {
                    this.e = b;
                }
            }
            a = d.a(this.e);
        }
        return a;
    }
}
