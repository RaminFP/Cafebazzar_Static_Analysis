package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.b.ab;
import com.farsitel.bazaar.b.m;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class n implements OnClickListener {
    final /* synthetic */ a a;

    n(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "change_nickname";
        a.a(cVar.b("action", "show_dialog"));
        m abVar = new ab(this.a.getActivity());
        abVar.g = new o(this);
        abVar.e.show();
    }
}
