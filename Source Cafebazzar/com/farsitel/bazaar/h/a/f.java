package com.farsitel.bazaar.h.a;

import android.content.Intent;
import android.support.v4.b.j;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.h.v;

public abstract class f extends a {
    protected v b = new g(this);

    static /* synthetic */ void a(f fVar) {
        Intent intent = new Intent();
        intent.setAction("com.farsitel.bazaar.ON_REGISTER_FAIL");
        j.a(BazaarApplication.c()).a(intent);
    }
}
