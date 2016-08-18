package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class p implements OnClickListener {
    final /* synthetic */ a a;

    p(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "logout";
        a.a(cVar.b("action", "show_dialog"));
        new u(this.a.getActivity()).e.show();
    }
}
