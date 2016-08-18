package android.support.v4.widget;

import android.database.DataSetObserver;

final class f extends DataSetObserver {
    final /* synthetic */ d a;

    private f(d dVar) {
        this.a = dVar;
    }

    public final void onChanged() {
        this.a.mDataValid = true;
        this.a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.a.mDataValid = false;
        this.a.notifyDataSetInvalidated();
    }
}
