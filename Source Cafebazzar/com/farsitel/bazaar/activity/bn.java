package com.farsitel.bazaar.activity;

import android.app.Activity;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.h.b.ao;
import com.farsitel.bazaar.h.d;

final class bn extends o {
    final /* synthetic */ String a;
    final /* synthetic */ JoinActivity b;

    bn(JoinActivity joinActivity, Activity activity, String str, int i, int i2, int i3, boolean z, String str2) {
        this.b = joinActivity;
        this.a = str2;
        super(activity, str, 2131165801, 0, 2131165463, true);
    }

    public final void a() {
        this.e.dismiss();
        this.b.g.setVisibility(8);
        this.b.l.show();
        d.INSTANCE.a(new bq(this.b, (byte) 0), new ao(), JoinActivity.a.a.getLanguage(), this.a);
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
