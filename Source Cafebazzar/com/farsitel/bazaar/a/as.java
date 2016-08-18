package com.farsitel.bazaar.a;

import android.app.Activity;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.b.o;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ak;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;

final class as extends o {
    final /* synthetic */ ao a;
    private final int b;

    public as(ao aoVar, Activity activity, int i) {
        this.a = aoVar;
        super(activity, 2131165804, 2131165801, 0, 2131165323, true);
        this.b = i;
    }

    public final void a() {
        if (d.INSTANCE.b(new ak(), j.a().b, Integer.valueOf(this.b))) {
            Toast.makeText(this.a.i, 2131165662, 0).show();
            BazaarApplication.c().d();
            i.a("/FlagComment/" + this.a.n);
        } else {
            Toast.makeText(this.a.i, 2131165701, 0).show();
        }
        this.e.dismiss();
    }

    public final void b() {
    }

    public final void c() {
        this.e.dismiss();
    }
}
