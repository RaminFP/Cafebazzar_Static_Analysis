package com.farsitel.bazaar.activity;

import android.view.View;
import android.widget.ImageView;
import com.farsitel.bazaar.util.ad;

final class cm implements ad {
    final /* synthetic */ View a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ cl c;

    cm(cl clVar, View view, ImageView imageView) {
        this.c = clVar;
        this.a = view;
        this.b = imageView;
    }

    public final void a() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
    }

    public final void b() {
        this.a.setVisibility(8);
    }
}
