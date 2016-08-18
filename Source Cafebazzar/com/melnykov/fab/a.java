package com.melnykov.fab;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

final class a extends ViewOutlineProvider {
    final /* synthetic */ FloatingActionButton a;

    a(FloatingActionButton floatingActionButton) {
        this.a = floatingActionButton;
    }

    public final void getOutline(View view, Outline outline) {
        int a = this.a.c(this.a.f == 0 ? d.fab_size_normal : d.fab_size_mini);
        outline.setOval(0, 0, a, a);
    }
}
