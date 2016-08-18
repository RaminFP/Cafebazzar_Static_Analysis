package com.farsitel.bazaar.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.a.a.a.a;
import com.a.a.a.aq;
import com.a.a.a.z;
import com.farsitel.bazaar.util.c;

final class p implements OnClickListener {
    final /* synthetic */ a a;

    p(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", this.a.getString(2131165641, this.a.e.h()));
        intent.putExtra("android.intent.extra.TEXT", this.a.getString(2131165640, this.a.e.h(), this.a.e.g()));
        intent.setFlags(268435456);
        c.a(this.a.getActivity(), Intent.createChooser(intent, this.a.getString(2131165352)), view);
        a c = a.c();
        z aqVar = new aq();
        aqVar.c.a("contentId", this.a.b);
        if (aqVar == null) {
            throw new NullPointerException("event must not be null");
        }
        if (c.a != null) {
            c.a.a(aqVar);
        }
        com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
        com.farsitel.bazaar.g.c cVar = new com.farsitel.bazaar.g.c();
        cVar.f = "user";
        cVar.c = "app_details";
        cVar = cVar.a("pn", this.a.b);
        cVar.e = "btn_click";
        a.a(cVar.b("which", "share"));
    }
}
