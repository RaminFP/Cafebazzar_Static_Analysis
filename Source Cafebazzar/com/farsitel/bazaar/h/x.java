package com.farsitel.bazaar.h;

import android.widget.Toast;
import com.android.a.t;
import com.android.a.y;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.ErrorDialogActivity;
import com.farsitel.bazaar.f.k;

final class x implements t {
    private final int a;
    private final k b;

    public x(int i, k kVar) {
        this.a = i;
        this.b = kVar;
    }

    public final void a(y yVar) {
        if (yVar instanceof com.android.a.x) {
            Toast.makeText(BazaarApplication.c(), 2131165332, 0).show();
        } else if (yVar instanceof h) {
            ErrorDialogActivity.a(2131165389);
        }
        v.a(yVar instanceof c ? (c) yVar : new c(), this.a);
    }
}
