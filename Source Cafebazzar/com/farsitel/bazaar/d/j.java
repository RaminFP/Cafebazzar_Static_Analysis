package com.farsitel.bazaar.d;

import android.content.Intent;
import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import ir.cafebazaar.pardakht.AuthenticateActivity;

final class j implements n {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "redeem";
        a.a(cVar.b("action", "success"));
        Intent intent = new Intent(this.a.getActivity(), AuthenticateActivity.class);
        intent.putExtra("request_type", "redeeem_only");
        this.a.startActivity(intent);
        this.a.c();
    }

    public final void b() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "redeem";
        a.a(cVar.b("action", "failed"));
    }
}
