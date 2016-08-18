package android.support.v7.internal.widget;

import android.database.DataSetObserver;

final class u extends DataSetObserver {
    final /* synthetic */ ActivityChooserView a;

    u(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        this.a.b.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        super.onInvalidated();
        this.a.b.notifyDataSetInvalidated();
    }
}
