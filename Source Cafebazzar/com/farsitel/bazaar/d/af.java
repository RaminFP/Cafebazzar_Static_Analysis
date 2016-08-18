package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.a.a.a.a;
import com.a.a.a.s;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.a.r;
import com.farsitel.bazaar.i;

public final class af extends w {
    public static af l() {
        return new af();
    }

    protected final h g() {
        return new r(getActivity(), LayoutInflater.from(getActivity()), this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.c().a(new s().b(getString(2131165313)).a("bought apps").c("Bought Apps page"));
    }

    public final void onResume() {
        super.onResume();
        BazaarApplication.c().d();
        i.a(("/NetApps/" + "bought").replace("?sm=", "/").replace("/?slug=", "/"));
        a(getString(2131165313));
    }
}
