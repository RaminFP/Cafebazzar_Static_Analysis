package com.farsitel.bazaar.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.a.a.a.a;
import com.a.a.a.s;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.h;
import com.farsitel.bazaar.a.p;
import com.farsitel.bazaar.a.q;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.i;

public final class ab extends w {
    private boolean d = false;

    public static ab l() {
        return new ab();
    }

    public final int d() {
        return g.ic_bookmark_off;
    }

    public final String e() {
        return getString(2131165479);
    }

    protected final h g() {
        h pVar = new p(getActivity(), LayoutInflater.from(getActivity()), this);
        setHasOptionsMenu(true);
        pVar.j = new ac(this, pVar);
        return pVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.c().a(new s().b(getString(2131165311)).a("bookmarks").c("Bookmarked Apps page"));
    }

    public final void onPause() {
        super.onPause();
        this.d = true;
    }

    public final void onResume() {
        super.onResume();
        a(getString(2131165311));
        p pVar = (p) this.b;
        if (this.d) {
            if (pVar != null) {
                pVar.e();
            }
        } else if (pVar != null) {
            new q(pVar).c();
            com.farsitel.bazaar.util.a.a(true);
            BazaarApplication.c().d();
            i.a("/NetApps/bookmarked".replace("?sm=", "/").replace("/?slug=", "/"));
        }
    }
}
