package com.a.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class aw extends BroadcastReceiver {
    final /* synthetic */ av a;

    aw(av avVar) {
        this.a = avVar;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.e = true;
    }
}
