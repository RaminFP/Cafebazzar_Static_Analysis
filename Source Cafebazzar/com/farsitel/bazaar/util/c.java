package com.farsitel.bazaar.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import java.util.List;

public final class c {
    @TargetApi(16)
    public static void a(Activity activity, Intent intent, int i, View view) {
        try {
            if (VERSION.SDK_INT <= 16 || view == null) {
                a(intent);
                activity.startActivityForResult(intent, i);
                return;
            }
            ActivityOptions makeScaleUpAnimation = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
            a(intent);
            activity.startActivityForResult(intent, i, makeScaleUpAnimation.toBundle());
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(BazaarApplication.c(), 2131165703, 0).show();
        }
    }

    public static void a(Context context, Intent intent) {
        a(intent);
        context.startActivity(intent);
    }

    @TargetApi(16)
    public static void a(Context context, Intent intent, View view) {
        intent.putExtra("bazaar_activity_finish_enter_anim", 0);
        intent.putExtra("bazaar_activity_finish_exit_anim", 2130968621);
        try {
            if (VERSION.SDK_INT <= 16 || view == null) {
                a(intent);
                context.startActivity(intent);
                return;
            }
            ActivityOptions makeScaleUpAnimation = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
            a(intent);
            context.startActivity(intent, makeScaleUpAnimation.toBundle());
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(BazaarApplication.c(), 2131165703, 0).show();
        }
    }

    public static void a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = BazaarApplication.c().getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(BazaarApplication.c().getPackageName())) {
                    intent.setPackage(BazaarApplication.c().getPackageName());
                    return;
                }
            }
        }
    }
}
