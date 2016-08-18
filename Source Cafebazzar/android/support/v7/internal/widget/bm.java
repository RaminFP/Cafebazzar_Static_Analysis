package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.a;
import android.view.View;
import android.view.View.OnClickListener;

final class bm implements OnClickListener {
    final a a = new a(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.b);
    final /* synthetic */ bl b;

    bm(bl blVar) {
        this.b = blVar;
    }

    public final void onClick(View view) {
        if (this.b.c != null && this.b.d) {
            this.b.c.onMenuItemSelected(0, this.a);
        }
    }
}
