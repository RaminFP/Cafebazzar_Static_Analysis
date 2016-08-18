package com.a.a.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class p implements OnClickListener {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.b.a(true);
        dialogInterface.dismiss();
    }
}
