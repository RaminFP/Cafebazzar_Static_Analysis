package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.g.f;
import com.farsitel.bazaar.h.b.q;
import com.farsitel.bazaar.h.d;

public final class z extends h {
    public z(Activity activity, LayoutInflater layoutInflater, String str, f[] fVarArr, b bVar, boolean z, int i, String str2, boolean z2, String str3) {
        super(activity, layoutInflater, false, bVar, z, i, str2, z2, str3);
        this.i = new a(str);
        this.i.a(fVarArr);
        this.g = fVarArr.length;
        if (str.equals("offline") || fVarArr.length < 24) {
            c();
        }
    }

    public final void a() {
        if (!d()) {
            this.f.a();
            d.INSTANCE.a(f(), new q(), BazaarApplication.c().a.getLanguage(), this.i.a, Integer.valueOf(this.g));
        }
    }
}
