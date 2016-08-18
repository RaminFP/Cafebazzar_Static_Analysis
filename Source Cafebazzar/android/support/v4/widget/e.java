package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

final class e extends ContentObserver {
    final /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.a.onContentChanged();
    }
}
