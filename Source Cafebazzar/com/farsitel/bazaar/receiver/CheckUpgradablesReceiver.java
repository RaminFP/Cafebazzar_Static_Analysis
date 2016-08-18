package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.farsitel.bazaar.service.CheckUpgradablesService;

public class CheckUpgradablesReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("com.farsitel.bazaar.CHECK_UPGRADABLES".equals(intent.getAction())) {
            Intent intent2 = new Intent(context, CheckUpgradablesService.class);
            intent2.putExtra("force_check_upgradables", false);
            context.startService(intent2);
        }
    }
}
