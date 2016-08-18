package android.support.v7.internal.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class au implements OnClickListener {
    final /* synthetic */ ar a;

    private au(ar arVar) {
        this.a = arVar;
    }

    public final void onClick(View view) {
        int childCount = this.a.e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.e.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
