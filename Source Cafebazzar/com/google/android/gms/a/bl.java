package com.google.android.gms.a;

import android.app.Dialog;

final class bl extends be {
    final /* synthetic */ Dialog b;
    final /* synthetic */ bk c;

    bl(bk bkVar, Dialog dialog) {
        this.c = bkVar;
        this.b = dialog;
    }

    protected final void a() {
        this.c.a.b();
        this.b.dismiss();
    }
}
