package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class r implements OnClickListener {
    final /* synthetic */ a a;

    r(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "change_password";
        a.a(cVar.b("action", "start"));
        this.a.a = 2;
        this.a.b();
    }
}
