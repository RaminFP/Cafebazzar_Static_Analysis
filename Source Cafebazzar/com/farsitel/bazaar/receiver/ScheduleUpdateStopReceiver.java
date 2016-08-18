package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.service.AppDownloadService;

public class ScheduleUpdateStopReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, AppDownloadService.class);
        intent2.setAction("com.farsitel.bazaar.PAUSE_ALL_DOWNLOADS");
        context.startService(intent2);
    }
}
