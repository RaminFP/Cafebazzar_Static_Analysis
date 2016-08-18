package com.farsitel.bazaar.d;

import android.widget.Toast;
import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;

final class i implements n {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "add_phone";
        a.a(cVar.b("action", "changed"));
        Toast.makeText(this.a.getActivity(), 2131165539, 0).show();
        this.a.b();
    }

    public final void b() {
        a a = a.a();
        c cVar = new c();
        cVar.c = "account_settings_frag";
        cVar.e = "add_phone";
        a.a(cVar.b("action", "failed"));
    }
}
