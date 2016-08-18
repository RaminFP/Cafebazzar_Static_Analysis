package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatExtras;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.a.bx;
import com.google.android.gms.a.cb;
import com.google.android.gms.a.ce;
import com.google.android.gms.b;
import com.google.android.gms.c;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.j;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzov();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzaee = false;
    public static boolean zzaef = false;
    private static int zzaeg = -1;
    private static String zzaeh = null;
    private static Integer zzaei = null;
    static final AtomicBoolean zzaej = new AtomicBoolean();
    private static final AtomicBoolean zzaek = new AtomicBoolean();
    private static final Object zzqf = new Object();

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return zza(i, activity, null, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return b.a().a(context, i, i2, null);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.a(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if (g.a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(c.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName())) {
            zzak(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            lz.a();
            if (!bx.a(context)) {
                try {
                    if (lz.a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), gd.a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (lz.a(packageInfo, lz.a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), gd.a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (lz.a(packageInfo, gd.a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (bx.a(packageInfo.versionCode) < bx.a(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Dialog zza = zza(i, activity, fragment, i2, onCancelListener);
        if (zza == null) {
            return false;
        }
        zza(activity, onCancelListener, GMS_ERROR_DIALOG, zza);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (bx.a(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zzf(context, i)) {
            zzal(context);
        } else {
            zza(i, context);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        CharSequence charSequence = null;
        if (i == 0) {
            return null;
        }
        AlertDialog.Builder builder;
        String zzam;
        Resources resources;
        CharSequence string;
        Intent a;
        OnClickListener jVar;
        CharSequence string2;
        Resources resources2;
        if (bx.a((Context) activity) && i == 2) {
            i = 42;
        }
        if (ce.a(14)) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
                if (builder == null) {
                    builder = new AlertDialog.Builder(activity);
                }
                zzam = zzam(activity);
                resources = activity.getResources();
                switch (i) {
                    case 1:
                        if (!cb.a(resources)) {
                            string = resources.getString(c.common_google_play_services_install_text_tablet, new Object[]{zzam});
                            break;
                        }
                        string = resources.getString(c.common_google_play_services_install_text_phone, new Object[]{zzam});
                        break;
                    case 2:
                        string = resources.getString(c.common_google_play_services_update_text, new Object[]{zzam});
                        break;
                    case 3:
                        string = resources.getString(c.common_google_play_services_enable_text, new Object[]{zzam});
                        break;
                    case 5:
                        string = resources.getString(c.common_google_play_services_invalid_account_text);
                        break;
                    case 7:
                        string = resources.getString(c.common_google_play_services_network_error_text);
                        break;
                    case 9:
                        string = resources.getString(c.common_google_play_services_unsupported_text, new Object[]{zzam});
                        break;
                    case 16:
                        string = resources.getString(c.common_google_play_services_api_unavailable_text, new Object[]{zzam});
                        break;
                    case 17:
                        string = resources.getString(c.common_google_play_services_sign_in_failed_text);
                        break;
                    case 18:
                        string = resources.getString(c.common_google_play_services_updating_text, new Object[]{zzam});
                        break;
                    case 42:
                        string = resources.getString(c.common_android_wear_update_text, new Object[]{zzam});
                        break;
                    default:
                        string = resources.getString(c.common_google_play_services_unknown_issue);
                        break;
                }
                builder.setMessage(string);
                if (onCancelListener != null) {
                    builder.setOnCancelListener(onCancelListener);
                }
                a = b.a().a(activity, i, "d");
                jVar = fragment != null ? new j(activity, a, i2) : new j(fragment, a, i2);
                resources = activity.getResources();
                switch (i) {
                    case 1:
                        string2 = resources.getString(c.common_google_play_services_install_button);
                        break;
                    case 2:
                    case 42:
                        string2 = resources.getString(c.common_google_play_services_update_button);
                        break;
                    case 3:
                        string2 = resources.getString(c.common_google_play_services_enable_button);
                        break;
                    default:
                        string2 = resources.getString(17039370);
                        break;
                }
                if (string2 != null) {
                    builder.setPositiveButton(string2, jVar);
                }
                resources2 = activity.getResources();
                switch (i) {
                    case 1:
                        charSequence = resources2.getString(c.common_google_play_services_install_title);
                        break;
                    case 2:
                        charSequence = resources2.getString(c.common_google_play_services_update_title);
                        break;
                    case 3:
                        charSequence = resources2.getString(c.common_google_play_services_enable_title);
                        break;
                    case 4:
                    case 6:
                        break;
                    case 5:
                        Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                        charSequence = resources2.getString(c.common_google_play_services_invalid_account_title);
                        break;
                    case 7:
                        Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                        charSequence = resources2.getString(c.common_google_play_services_network_error_title);
                        break;
                    case 8:
                        Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                        break;
                    case 9:
                        Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                        charSequence = resources2.getString(c.common_google_play_services_unsupported_title);
                        break;
                    case 10:
                        Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                        break;
                    case 11:
                        Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                        break;
                    case 16:
                        Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                        break;
                    case 17:
                        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                        charSequence = resources2.getString(c.common_google_play_services_sign_in_failed_title);
                        break;
                    case 18:
                        charSequence = resources2.getString(c.common_google_play_services_updating_title);
                        break;
                    case 42:
                        charSequence = resources2.getString(c.common_android_wear_update_title);
                        break;
                    default:
                        Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                        break;
                }
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                return builder.create();
            }
        }
        builder = null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        zzam = zzam(activity);
        resources = activity.getResources();
        switch (i) {
            case 1:
                if (!cb.a(resources)) {
                    string = resources.getString(c.common_google_play_services_install_text_phone, new Object[]{zzam});
                    break;
                }
                string = resources.getString(c.common_google_play_services_install_text_tablet, new Object[]{zzam});
                break;
            case 2:
                string = resources.getString(c.common_google_play_services_update_text, new Object[]{zzam});
                break;
            case 3:
                string = resources.getString(c.common_google_play_services_enable_text, new Object[]{zzam});
                break;
            case 5:
                string = resources.getString(c.common_google_play_services_invalid_account_text);
                break;
            case 7:
                string = resources.getString(c.common_google_play_services_network_error_text);
                break;
            case 9:
                string = resources.getString(c.common_google_play_services_unsupported_text, new Object[]{zzam});
                break;
            case 16:
                string = resources.getString(c.common_google_play_services_api_unavailable_text, new Object[]{zzam});
                break;
            case 17:
                string = resources.getString(c.common_google_play_services_sign_in_failed_text);
                break;
            case 18:
                string = resources.getString(c.common_google_play_services_updating_text, new Object[]{zzam});
                break;
            case 42:
                string = resources.getString(c.common_android_wear_update_text, new Object[]{zzam});
                break;
            default:
                string = resources.getString(c.common_google_play_services_unknown_issue);
                break;
        }
        builder.setMessage(string);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        a = b.a().a(activity, i, "d");
        if (fragment != null) {
        }
        resources = activity.getResources();
        switch (i) {
            case 1:
                string2 = resources.getString(c.common_google_play_services_install_button);
                break;
            case 2:
            case 42:
                string2 = resources.getString(c.common_google_play_services_update_button);
                break;
            case 3:
                string2 = resources.getString(c.common_google_play_services_enable_button);
                break;
            default:
                string2 = resources.getString(17039370);
                break;
        }
        if (string2 != null) {
            builder.setPositiveButton(string2, jVar);
        }
        resources2 = activity.getResources();
        switch (i) {
            case 1:
                charSequence = resources2.getString(c.common_google_play_services_install_title);
                break;
            case 2:
                charSequence = resources2.getString(c.common_google_play_services_update_title);
                break;
            case 3:
                charSequence = resources2.getString(c.common_google_play_services_enable_title);
                break;
            case 4:
            case 6:
                break;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                charSequence = resources2.getString(c.common_google_play_services_invalid_account_title);
                break;
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                charSequence = resources2.getString(c.common_google_play_services_network_error_title);
                break;
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                break;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                charSequence = resources2.getString(c.common_google_play_services_unsupported_title);
                break;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                break;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                break;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                charSequence = resources2.getString(c.common_google_play_services_sign_in_failed_title);
                break;
            case 18:
                charSequence = resources2.getString(c.common_google_play_services_updating_title);
                break;
            case 42:
                charSequence = resources2.getString(c.common_android_wear_update_title);
                break;
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                break;
        }
        if (charSequence != null) {
            builder.setTitle(charSequence);
        }
        return builder.create();
    }

    private static void zza(int i, Context context) {
        zza(i, context, null);
    }

    private static void zza(int i, Context context, String str) {
        CharSequence string;
        Notification build;
        int i2;
        String str2 = null;
        Resources resources = context.getResources();
        String zzam = zzam(context);
        Resources resources2 = context.getResources();
        switch (i) {
            case 1:
                str2 = resources2.getString(c.common_google_play_services_install_title);
                break;
            case 2:
                str2 = resources2.getString(c.common_google_play_services_update_title);
                break;
            case 3:
                str2 = resources2.getString(c.common_google_play_services_enable_title);
                break;
            case 4:
            case 6:
                break;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                str2 = resources2.getString(c.common_google_play_services_invalid_account_title);
                break;
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                str2 = resources2.getString(c.common_google_play_services_network_error_title);
                break;
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                break;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                str2 = resources2.getString(c.common_google_play_services_unsupported_title);
                break;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                break;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                break;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                str2 = resources2.getString(c.common_google_play_services_sign_in_failed_title);
                break;
            case 18:
                str2 = resources2.getString(c.common_google_play_services_updating_title);
                break;
            case 42:
                str2 = resources2.getString(c.common_android_wear_update_title);
                break;
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                break;
        }
        if (str2 == null) {
            CharSequence string2 = resources.getString(c.common_google_play_services_notification_ticker);
        } else {
            Object obj = str2;
        }
        Resources resources3 = context.getResources();
        switch (i) {
            case 1:
                if (!cb.a(resources3)) {
                    string = resources3.getString(c.common_google_play_services_install_text_phone, new Object[]{zzam});
                    break;
                }
                string = resources3.getString(c.common_google_play_services_install_text_tablet, new Object[]{zzam});
                break;
            case 2:
                string = resources3.getString(c.common_google_play_services_update_text, new Object[]{zzam});
                break;
            case 3:
                string = resources3.getString(c.common_google_play_services_enable_text, new Object[]{zzam});
                break;
            case 5:
                string = resources3.getString(c.common_google_play_services_invalid_account_text);
                break;
            case 7:
                string = resources3.getString(c.common_google_play_services_network_error_text);
                break;
            case 9:
                string = resources3.getString(c.common_google_play_services_unsupported_text, new Object[]{zzam});
                break;
            case 16:
                string = resources3.getString(c.common_google_play_services_api_unavailable_text, new Object[]{zzam});
                break;
            case 17:
                string = resources3.getString(c.common_google_play_services_sign_in_failed_text);
                break;
            case 18:
                string = resources3.getString(c.common_google_play_services_updating_text, new Object[]{zzam});
                break;
            case 42:
                string = resources3.getString(c.common_android_wear_notification_needs_update_text, new Object[]{zzam});
                break;
            default:
                string = resources3.getString(c.common_google_play_services_unknown_issue);
                break;
        }
        PendingIntent a = b.a().a(context, i, 0, "n");
        if (bx.a(context)) {
            av.a(ce.a(16));
            build = new Notification.Builder(context).setSmallIcon(b.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(string2 + " " + string)).addAction(b.common_full_open_on_phone, resources.getString(c.common_open_on_phone), a).build();
        } else {
            CharSequence string3 = resources.getString(c.common_google_play_services_notification_ticker);
            if (ce.a(11)) {
                Notification build2;
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(string2).setContentText(string).setContentIntent(a).setTicker(string3).setAutoCancel(true);
                if (ce.a(20)) {
                    autoCancel.setLocalOnly(true);
                }
                if (ce.a(16)) {
                    autoCancel.setStyle(new BigTextStyle().bigText(string));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                build = build2;
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string3).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(a).setContentTitle(string2).setContentText(string).build();
            }
        }
        if (zzbw(i)) {
            zzaej.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    public static void zza(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        if (activity instanceof FragmentActivity) {
            f.a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (ce.a(11)) {
            a.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    @Deprecated
    public static void zzac(Context context) {
        b.a();
        int a = b.a(context);
        if (a != 0) {
            Intent a2 = b.a().a(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new c(a);
            }
            throw new d(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static void zzaj(Context context) {
        if (!zzaej.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzak(Context context) {
        if (!zzaek.get()) {
            Integer num;
            synchronized (zzqf) {
                if (zzaeh == null) {
                    zzaeh = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                        if (bundle != null) {
                            zzaei = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            zzaei = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!zzaeh.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzaeh + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = zzaei;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + num + ".  You must have the following declaration within the <application> element: " + "    <meta-data android:name=\"com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }

    private static void zzal(Context context) {
        Handler eVar = new e(context);
        eVar.sendMessageDelayed(eVar.obtainMessage(1), 120000);
    }

    public static String zzam(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @Deprecated
    public static int zzan(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    public static boolean zzao(Context context) {
        return ce.a(21) && context.getPackageManager().hasSystemFeature("cn.google");
    }

    public static boolean zzap(Context context) {
        if (ce.a(18)) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzb(Context context, int i, String str) {
        boolean z;
        if (ce.a(19)) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                z = true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (!(str == null || packagesForUid == null)) {
            for (Object equals : packagesForUid) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        z = false;
        return z;
    }

    public static boolean zzb(PackageManager packageManager) {
        boolean z = false;
        synchronized (zzqf) {
            if (zzaeg == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
                    lz.a();
                    if (lz.a(packageInfo, j.b[1]) != null) {
                        zzaeg = 1;
                    } else {
                        zzaeg = 0;
                    }
                } catch (NameNotFoundException e) {
                    zzaeg = 0;
                }
            }
            if (zzaeg != 0) {
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return lz.a().a(packageManager, str);
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return b.a().a(null, i, null);
    }

    private static boolean zzbw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzow();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 18 ? true : i == 1 ? zzh(context, GOOGLE_PLAY_SERVICES_PACKAGE) : false;
    }

    public static boolean zze(Context context, int i) {
        return zzb(context, i, GOOGLE_PLAY_SERVICES_PACKAGE) && zzb(context.getPackageManager(), GOOGLE_PLAY_SERVICES_PACKAGE);
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return i == 9 ? zzh(context, GOOGLE_PLAY_STORE_PACKAGE) : false;
    }

    static boolean zzh(Context context, String str) {
        if (ce.a(21)) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzap(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, FragmentTransaction.TRANSIT_EXIT_MASK).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int zzov() {
        return 8298000;
    }

    public static boolean zzow() {
        return zzaee ? zzaef : "user".equals(Build.TYPE);
    }
}
