package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;
import com.farsitel.bazaar.util.aw;

public final class bg extends h {
    public bg(Activity activity, LayoutInflater layoutInflater, b bVar) {
        super(activity, layoutInflater, false, bVar, false, "upgradable_apps");
        this.i = new a("upgradable");
    }

    public final void a() {
        if (!d()) {
            this.i.a(this.c.getString(2131165722), g.a().a(true));
            c();
            notifyDataSetChanged();
            this.f.b();
            aw.b();
        }
    }
}
