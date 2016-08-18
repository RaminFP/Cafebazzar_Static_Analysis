package com.farsitel.bazaar.g.a;

import android.os.Bundle;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.f;

public final class b {
    final g a;
    final d[] b;
    public final f[] c;
    private String[] d;
    private String[] e;

    public b(a aVar) {
        int i = 0;
        this.a = aVar.z;
        this.b = aVar.y;
        String g = aVar.g();
        int i2 = aVar.c() ? 1 : 0;
        this.c = new f[(this.b.length + i2)];
        this.d = new String[this.b.length];
        this.e = new String[this.b.length];
        if (aVar.c()) {
            this.c[0] = this.a;
        }
        for (int i3 = 0; i3 < this.b.length; i3++) {
            this.d[i3] = this.b[i3].a;
            this.e[i3] = this.b[i3].b;
            this.c[i3 + i2] = this.b[i3];
        }
        String[] strArr = this.d;
        String[] strArr2 = this.e;
        if (BazaarApplication.c().b()) {
            f.a(strArr);
            f.a(strArr2);
        }
        while (i < this.b.length) {
            f fVar = this.b[i];
            i2 = BazaarApplication.c().b() ? (strArr2.length - i) - 1 : i;
            Bundle bundle = new Bundle();
            bundle.putInt("scrid", i2);
            bundle.putStringArray("scrarr", strArr);
            bundle.putStringArray("scrth", strArr2);
            bundle.putString("pkgName", g);
            fVar.c = bundle;
            i++;
        }
    }
}
