package com.c.b;

import android.content.Context;
import java.io.InputStream;

class o extends az {
    final Context a;

    o(Context context) {
        this.a = context;
    }

    public boolean a(aw awVar) {
        return "content".equals(awVar.d.getScheme());
    }

    public ba b(aw awVar) {
        return new ba(c(awVar), ap.DISK);
    }

    final InputStream c(aw awVar) {
        return this.a.getContentResolver().openInputStream(awVar.d);
    }
}
