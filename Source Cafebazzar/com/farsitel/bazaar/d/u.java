package com.farsitel.bazaar.d;

import android.app.Activity;
import android.app.ProgressDialog;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

public final class u extends o {
    ProgressDialog a = new ProgressDialog(this.f);

    public u(Activity activity) {
        super(activity, 2131165349, 2131165801, 0, 2131165463);
        this.a.setMessage(activity.getString(2131165546));
        this.a.setCancelable(false);
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "logout";
        a.a(cVar.b("action", "request"));
        this.a.show();
        com.farsitel.bazaar.util.a.a(new v(this));
    }

    public final void b() {
    }

    public final void c() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "logout";
        a.a(cVar.b("action", "cancel"));
        this.e.dismiss();
    }
}
