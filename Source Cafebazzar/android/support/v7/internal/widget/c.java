package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

final class c {
    final /* synthetic */ AbsSpinnerCompat a;
    private final SparseArray b = new SparseArray();

    c(AbsSpinnerCompat absSpinnerCompat) {
        this.a = absSpinnerCompat;
    }

    final View a(int i) {
        View view = (View) this.b.get(i);
        if (view != null) {
            this.b.delete(i);
        }
        return view;
    }

    final void a() {
        SparseArray sparseArray = this.b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null) {
                this.a.removeDetachedView(view, true);
            }
        }
        sparseArray.clear();
    }

    public final void a(int i, View view) {
        this.b.put(i, view);
    }
}
