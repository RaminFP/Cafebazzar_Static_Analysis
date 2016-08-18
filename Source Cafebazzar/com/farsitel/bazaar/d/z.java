package com.farsitel.bazaar.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.widget.RetryView;

final class z extends BroadcastReceiver {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.getView() != null) {
            RetryView retryView = (RetryView) this.a.getView().findViewById(2131624207);
            if (retryView != null) {
                retryView.a();
            }
        }
    }
}
