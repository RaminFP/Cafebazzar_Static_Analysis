package android.support.v7.internal.view.menu;

import android.support.v7.e.c;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

final class q extends FrameLayout implements c {
    final CollapsibleActionView a;

    q(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView) view;
        addView(view);
    }

    public final void onActionViewCollapsed() {
        this.a.onActionViewCollapsed();
    }

    public final void onActionViewExpanded() {
        this.a.onActionViewExpanded();
    }
}
