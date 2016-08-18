package com.farsitel.bazaar.activity;

import android.widget.ImageView;
import com.farsitel.bazaar.util.ad;

final class ah implements ad {
    final /* synthetic */ ImageView a;
    final /* synthetic */ u b;

    ah(u uVar, ImageView imageView) {
        this.b = uVar;
        this.a = imageView;
    }

    public final void a() {
        this.a.setVisibility(0);
    }

    public final void b() {
        this.a.setVisibility(8);
    }
}
