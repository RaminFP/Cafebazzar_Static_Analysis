package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public final class j implements OnClickListener {
    private final Activity a;
    private final Fragment b;
    private final Intent c;
    private final int d;

    public j(Activity activity, Intent intent, int i) {
        this.a = activity;
        this.b = null;
        this.c = intent;
        this.d = i;
    }

    public j(Fragment fragment, Intent intent, int i) {
        this.a = null;
        this.b = fragment;
        this.c = intent;
        this.d = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.c != null && this.b != null) {
                this.b.startActivityForResult(this.c, this.d);
            } else if (this.c != null) {
                this.a.startActivityForResult(this.c, this.d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
