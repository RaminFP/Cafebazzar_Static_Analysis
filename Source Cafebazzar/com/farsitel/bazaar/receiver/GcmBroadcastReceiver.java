package com.farsitel.bazaar.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.n;
import com.farsitel.bazaar.service.GcmIntentService;

public class GcmBroadcastReceiver extends n {
    public void onReceive(Context context, Intent intent) {
        n.a(context, intent.setComponent(new ComponentName(context.getPackageName(), GcmIntentService.class.getName())));
        setResultCode(-1);
    }
}
