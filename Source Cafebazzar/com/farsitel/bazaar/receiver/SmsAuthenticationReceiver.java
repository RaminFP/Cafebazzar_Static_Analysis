package com.farsitel.bazaar.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.farsitel.bazaar.activity.SmsAuthenticationActivity;
import com.farsitel.bazaar.g.j;
import java.util.regex.PatternSyntaxException;

public class SmsAuthenticationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        j a = j.a();
        String[] split = a.a.getString("user_panel_sms_numbers", null) == null ? new String[0] : a.a.getString("user_panel_sms_numbers", null).split(",");
        a = j.a();
        String[] split2 = a.a.getString("user_sms_patterns", null) == null ? new String[0] : a.a.getString("user_sms_patterns", null).split("//");
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            for (int i = 0; i < smsMessageArr.length; i++) {
                smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                for (String equals : split) {
                    if (equals.equals(smsMessageArr[i].getOriginatingAddress())) {
                        int i2 = 0;
                        while (i2 < split2.length) {
                            try {
                                if (smsMessageArr[i].getMessageBody().matches(split2[i2])) {
                                    Intent a2 = SmsAuthenticationActivity.a(context, smsMessageArr[i].getMessageBody().substring(smsMessageArr[i].getMessageBody().indexOf(": ") + 2, smsMessageArr[i].getMessageBody().indexOf("\n")));
                                    a2.addFlags(268435456);
                                    context.startActivity(a2);
                                    break;
                                }
                                i2++;
                            } catch (PatternSyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
