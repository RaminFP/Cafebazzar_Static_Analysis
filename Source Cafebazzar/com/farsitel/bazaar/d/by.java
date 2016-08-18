package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.b.bo;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class by implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ bw b;

    by(bw bwVar, int i) {
        this.b = bwVar;
        this.a = i;
    }

    public final void onClick(View view) {
        a a = a.a();
        c cVar = new c();
        cVar.c = "upgradable_apps_frag";
        cVar.e = "update_all";
        a.a(cVar.b("action", "open_dialog"));
        new bo(this.b.getActivity(), this.a).e.show();
    }
}
