package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.g.f;
import com.farsitel.bazaar.h.b.u;
import com.farsitel.bazaar.h.d;

public final class ay extends h {
    private String a;

    public ay(Activity activity, LayoutInflater layoutInflater, String str, b bVar, f[] fVarArr, String str2, String str3) {
        super(activity, layoutInflater, false, bVar, false, str2);
        this.a = str;
        this.i = new a("search");
        this.i.a(fVarArr);
        this.m = str3;
        this.g = fVarArr.length;
        if (fVarArr.length < 24) {
            c();
        }
    }

    public final void a() {
        this.f.a();
        String str = "search|" + this.a + "|" + this.m;
        d.INSTANCE.a(f(), str, new u(), this.e, this.a.toLowerCase(), Integer.valueOf(this.g));
    }
}
