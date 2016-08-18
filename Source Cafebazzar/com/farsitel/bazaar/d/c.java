package com.farsitel.bazaar.d;

import com.farsitel.bazaar.util.g;

final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.a.getActivity() != null) {
            g.c(this.a.a.getActivity(), this.a.a.c, 0.0f);
            this.a.a.c.setVisibility(8);
        }
    }
}
