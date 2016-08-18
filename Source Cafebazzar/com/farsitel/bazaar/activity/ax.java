package com.farsitel.bazaar.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.a.i;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.g.f;
import java.util.ArrayList;

public final class ax extends h {
    boolean a;
    boolean b;

    public ax(Activity activity, LayoutInflater layoutInflater, b bVar) {
        super(activity, layoutInflater, false, bVar, false, "downloads");
        this.a = false;
        this.b = false;
        this.i = new a("offline");
        a();
    }

    public final void a() {
        this.a = false;
        this.b = false;
        ArrayList c = com.farsitel.bazaar.c.b.a.a().c();
        f[] fVarArr = new k[c.size()];
        for (int i = 0; i < c.size(); i++) {
            i iVar = (i) c.get(i);
            if (com.farsitel.bazaar.c.a.f.a(iVar.f()) && !this.a) {
                this.a = true;
            } else if (!(com.farsitel.bazaar.c.a.f.a(iVar.f()) || this.b)) {
                this.b = true;
            }
            fVarArr[i] = new k(iVar.g(), iVar.h(), "", 0.0f, false, iVar.a() ? 0 : -1, "", "", true, 0, "", false, "", "downloads");
        }
        this.i.a(fVarArr);
    }

    public final void notifyDataSetChanged() {
        synchronized (this) {
            a();
            super.notifyDataSetChanged();
        }
    }
}
