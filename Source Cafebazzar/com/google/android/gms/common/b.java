package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.c;
import com.google.android.gms.common.internal.ac;

public final class b {
    public static final int a = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final b b = new b();

    b() {
    }

    public static int a(Context context) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        return GooglePlayServicesUtil.zzd(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public static Dialog a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String zzam = GooglePlayServicesUtil.zzam(activity);
        builder.setMessage(activity.getResources().getString(c.common_google_play_services_updating_text, new Object[]{zzam}));
        builder.setTitle(c.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public static b a() {
        return b;
    }

    public static boolean a(int i) {
        return GooglePlayServicesUtil.isUserRecoverableError(i);
    }

    public static boolean a(Context context, int i) {
        return GooglePlayServicesUtil.zzd(context, i);
    }

    public static boolean a(Context context, String str) {
        return GooglePlayServicesUtil.zzh(context, str);
    }

    private static String b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(a);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public static void b(Context context) {
        GooglePlayServicesUtil.zzaj(context);
    }

    public final PendingIntent a(Context context, int i, int i2, String str) {
        Intent a = a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public final Intent a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return ac.a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, b(context, str));
            case 3:
                return ac.a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            case 42:
                return ac.a();
            default:
                return null;
        }
    }
}
