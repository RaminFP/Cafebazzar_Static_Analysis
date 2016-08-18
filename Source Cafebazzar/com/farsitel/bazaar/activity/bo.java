package com.farsitel.bazaar.activity;

import android.app.Activity;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.h.b.an;
import com.farsitel.bazaar.h.d;

final class bo extends o {
    final /* synthetic */ String a;
    final /* synthetic */ JoinActivity b;

    bo(JoinActivity joinActivity, Activity activity, String str, int i, int i2, int i3, boolean z, String str2) {
        this.b = joinActivity;
        this.a = str2;
        super(activity, str, 2131165801, 0, 2131165463, true);
    }

    public final void a() {
        this.e.dismiss();
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "join_dialog";
        cVar.e = "sign_in_with_google";
        a.a(cVar.b("accept", Boolean.valueOf(true)));
        this.b.b = true;
        this.b.l.show();
        this.b.f.a();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "join_dialog";
        cVar.e = "sign_in_with_google";
        a.a(cVar.b("accept", Boolean.valueOf(false)));
        this.b.l.show();
        d.INSTANCE.a(new bq(this.b, (byte) 0), new an(), JoinActivity.a.a.getLanguage(), this.a);
    }
}
