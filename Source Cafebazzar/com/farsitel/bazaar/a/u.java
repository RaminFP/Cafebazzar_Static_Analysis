package com.farsitel.bazaar.a;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.b.a;

public final class u extends h {
    private Handler a;

    public u(Activity activity, LayoutInflater layoutInflater, b bVar) {
        super(activity, layoutInflater, true, bVar, false, "installed_apps");
        this.a = new Handler();
        this.i = new a("installed");
    }

    public final void a() {
        this.f.a();
        new Thread(new v(this)).start();
    }
}
