package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.activity.ReviewActivity;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.q;

public class NetConnectivityReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (q.e()) {
            AppDownloadService.a();
            ReviewActivity.a();
        }
    }
}
