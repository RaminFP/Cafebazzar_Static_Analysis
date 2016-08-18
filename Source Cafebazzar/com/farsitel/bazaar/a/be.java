package com.farsitel.bazaar.a;

import android.app.Activity;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.g.h;

final class be extends o {
    private static BazaarApplication a = BazaarApplication.c();

    public be(Activity activity, h hVar) {
        String str = hVar.c;
        String str2 = hVar.g;
        Object[] objArr = new Object[]{str, str2};
        Activity activity2 = activity;
        super(activity2, String.format(a.getString(2131165671), objArr), 2131165801, 0, 2131165323, false);
    }

    public final void a() {
        d();
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        e();
        this.e.dismiss();
    }
}
