package com.a.a.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import b.a.a.a.a.f.c;
import b.a.a.a.a.f.d;

final class r implements OnClickListener {
    final /* synthetic */ o a;

    r(o oVar) {
        this.a = oVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c dVar = new d(this.a.e);
        dVar.a(dVar.b().putBoolean("always_send_reports_opt_in", true));
        this.a.b.a(true);
        dialogInterface.dismiss();
    }
}
