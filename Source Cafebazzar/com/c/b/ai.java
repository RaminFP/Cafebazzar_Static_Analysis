package com.c.b;

import android.content.Context;
import android.net.Uri;
import com.c.a.ag;
import com.c.a.am;
import com.c.a.ap;
import com.c.a.ar;
import com.c.a.c;
import com.c.a.j;
import com.c.a.k;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class ai implements v {
    private final ag a;

    public ai(Context context) {
        this(bj.b(context));
    }

    private ai(ag agVar) {
        this.a = agVar;
    }

    private ai(File file) {
        this(file, bj.a(file));
    }

    private ai(File file, long j) {
        ag agVar = new ag();
        agVar.a(15000, TimeUnit.MILLISECONDS);
        agVar.b(20000, TimeUnit.MILLISECONDS);
        agVar.c(20000, TimeUnit.MILLISECONDS);
        this(agVar);
        try {
            this.a.a(new c(file, j));
        } catch (IOException e) {
        }
    }

    public final w a(Uri uri, int i) {
        j jVar = null;
        if (i != 0) {
            if (af.c(i)) {
                jVar = j.b;
            } else {
                k kVar = new k();
                if (!af.a(i)) {
                    kVar.a();
                }
                if (!af.b(i)) {
                    kVar.b();
                }
                jVar = kVar.c();
            }
        }
        am a = new am().a(uri.toString());
        if (jVar != null) {
            a.a(jVar);
        }
        ap a2 = this.a.a(a.a()).a();
        int a3 = a2.a();
        if (a3 >= 300) {
            a2.c().close();
            throw new x(a3 + " " + a2.b(), i, a3);
        }
        boolean z = a2.e() != null;
        ar c = a2.c();
        return new w(c.c(), z, c.a());
    }
}
