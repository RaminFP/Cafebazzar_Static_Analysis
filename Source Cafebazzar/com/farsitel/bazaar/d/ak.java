package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.a.a.a.a;
import com.a.a.a.s;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.a.u;
import com.farsitel.bazaar.i;

public final class ak extends w {
    public static ak l() {
        return new ak();
    }

    protected final h g() {
        return new u(getActivity(), LayoutInflater.from(getActivity()), this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.c().a(new s().b(getString(2131165424)).a("installed apps").c("Installed Apps page"));
    }

    public final void onResume() {
        super.onResume();
        a(getString(2131165424));
        BazaarApplication.c().d();
        i.a(("/NetApps/" + "installed").replace("?sm=", "/").replace("/?slug=", "/"));
    }
}
