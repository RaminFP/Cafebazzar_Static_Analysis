package com.farsitel.bazaar.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class o extends BroadcastReceiver {
    final /* synthetic */ a a;

    o(a aVar) {
        this.a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.z != null) {
            this.a.z.a();
        }
    }
}
