package com.farsitel.bazaar.a;

import android.app.Activity;
import android.view.LayoutInflater;
import com.farsitel.bazaar.database.e;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;

public final class p extends h {
    public p(Activity activity, LayoutInflater layoutInflater, b bVar) {
        super(activity, layoutInflater, false, bVar, false, "bookmark");
        this.i = new a("bookmarked");
    }

    public final void a() {
        this.f.a();
        this.i.a(this.c.getString(2131165311), e.a().c());
        notifyDataSetChanged();
        c();
        if (this.f != null) {
            this.f.b();
        }
    }
}
