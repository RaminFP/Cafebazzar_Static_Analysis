package com.farsitel.bazaar.b;

import android.app.Activity;
import com.farsitel.bazaar.util.aj;

public final class k extends o {
    public k(Activity activity, String str, long j) {
        super(activity, activity.getString(2131165802, new Object[]{str, aj.a(j)}), 2131165317, 0, 2131165323, true);
        a(new l(this));
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
