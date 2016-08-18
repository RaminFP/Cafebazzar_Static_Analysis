package com.farsitel.bazaar.util;

import android.app.Activity;
import android.content.Intent;
import com.farsitel.bazaar.activity.HomeActivity;
import com.farsitel.bazaar.activity.a;
import com.farsitel.bazaar.b.o;

final class l extends o {
    final /* synthetic */ Activity a;

    l(Activity activity, int i, int i2, int i3, int i4, boolean z, Activity activity2) {
        this.a = activity2;
        super(activity, 2131165287, 2131165482, 0, 0, false);
    }

    public final void a() {
        Intent intent = new Intent(this.a, HomeActivity.class);
        intent.setData(a.a("com.farsitel.bazaar", "show_update_bazaar_if_expired"));
        this.a.startActivity(intent);
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
    }
}
