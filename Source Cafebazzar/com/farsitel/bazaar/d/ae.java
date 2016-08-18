package com.farsitel.bazaar.d;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.farsitel.bazaar.database.e;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;

final class ae extends v {
    final /* synthetic */ ProgressDialog a;
    final /* synthetic */ String b;
    final /* synthetic */ ad c;

    ae(ad adVar, ProgressDialog progressDialog, String str) {
        this.c = adVar;
        this.a = progressDialog;
        this.b = str;
    }

    public final void a(c cVar) {
        this.a.dismiss();
        Toast.makeText(this.c.b.b.getActivity(), 2131165586, 1).show();
    }

    public final /* synthetic */ void a(Object obj) {
        Boolean bool = (Boolean) obj;
        this.a.dismiss();
        if (bool.booleanValue()) {
            Toast.makeText(this.c.b.b.getActivity(), 2131165586, 1).show();
        } else {
            Toast.makeText(this.c.b.b.getActivity(), 2131165310, 1).show();
            e.a().b(this.b);
        }
        this.c.b.a.e();
    }
}
