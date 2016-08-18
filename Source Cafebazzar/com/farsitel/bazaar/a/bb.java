package com.farsitel.bazaar.a;

import android.app.ProgressDialog;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.n;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.e;
import com.farsitel.bazaar.h.d;

final class bb implements n {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public final void a() {
        this.a.c.e = new ProgressDialog(this.a.c.c.getActivity());
        this.a.c.e.setMessage(this.a.c.c.getActivity().getString(2131165546));
        this.a.c.e.setCancelable(false);
        this.a.c.e.show();
        d.INSTANCE.a(new bd(this.a.c, this.a.b, (byte) 0), new e(), j.a().b, BazaarApplication.c().a.getLanguage(), this.a.a.a, this.a.a.f);
    }

    public final void b() {
    }
}
