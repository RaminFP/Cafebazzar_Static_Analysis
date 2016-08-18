package android.support.v7.internal.widget;

import android.support.v7.e.a;
import android.view.View;
import android.view.View.OnClickListener;

final class g implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ ActionBarContextView b;

    g(ActionBarContextView actionBarContextView, a aVar) {
        this.b = actionBarContextView;
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.c();
    }
}
