package android.support.v7.internal.widget;

import android.database.DataSetObserver;

final class x extends DataSetObserver {
    final /* synthetic */ ActivityChooserView a;

    x(ActivityChooserView activityChooserView) {
        this.a = activityChooserView;
    }

    public final void onChanged() {
        super.onChanged();
        ActivityChooserView.c(this.a);
    }
}
