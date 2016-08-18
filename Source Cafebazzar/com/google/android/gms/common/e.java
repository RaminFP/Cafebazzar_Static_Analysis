package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class e extends Handler {
    private final Context a;

    e(Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.a);
                if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.a);
                    return;
                }
                return;
            default:
                Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                return;
        }
    }
}
