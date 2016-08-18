package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;

final class ab extends DataSetObserver {
    final /* synthetic */ aa a;
    private Parcelable b = null;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public final void onChanged() {
        this.a.v = true;
        this.a.B = this.a.A;
        this.a.A = this.a.getAdapter().getCount();
        if (!this.a.getAdapter().hasStableIds() || this.b == null || this.a.B != 0 || this.a.A <= 0) {
            aa aaVar = this.a;
            if (aaVar.getChildCount() > 0) {
                aaVar.o = true;
                aaVar.n = (long) aaVar.q;
                View childAt;
                if (aaVar.y >= 0) {
                    childAt = aaVar.getChildAt(aaVar.y - aaVar.j);
                    aaVar.m = aaVar.x;
                    aaVar.l = aaVar.w;
                    if (childAt != null) {
                        aaVar.k = childAt.getTop();
                    }
                    aaVar.p = 0;
                } else {
                    childAt = aaVar.getChildAt(0);
                    Adapter adapter = aaVar.getAdapter();
                    if (aaVar.j < 0 || aaVar.j >= adapter.getCount()) {
                        aaVar.m = -1;
                    } else {
                        aaVar.m = adapter.getItemId(aaVar.j);
                    }
                    aaVar.l = aaVar.j;
                    if (childAt != null) {
                        aaVar.k = childAt.getTop();
                    }
                    aaVar.p = 1;
                }
            }
        } else {
            this.a.onRestoreInstanceState(this.b);
            this.b = null;
        }
        this.a.b();
        this.a.requestLayout();
    }

    public final void onInvalidated() {
        this.a.v = true;
        if (this.a.getAdapter().hasStableIds()) {
            this.b = this.a.onSaveInstanceState();
        }
        this.a.B = this.a.A;
        this.a.A = 0;
        this.a.y = -1;
        this.a.z = Long.MIN_VALUE;
        this.a.w = -1;
        this.a.x = Long.MIN_VALUE;
        this.a.o = false;
        this.a.b();
        this.a.requestLayout();
    }
}
