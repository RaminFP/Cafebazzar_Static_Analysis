package com.farsitel.bazaar.b;

import android.app.Activity;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.aj;

public final class z extends o {
    public z(Activity activity, String str, String str2, String str3, long j) {
        super(activity, activity.getString(2131165803, new Object[]{str3, str2, aj.a(j)}), 2131165317, 0, 2131165323, false);
        a(new aa(this));
        af afVar = af.INSTANCE;
        a(true, af.b(str).a().a());
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
