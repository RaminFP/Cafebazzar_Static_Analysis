package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

final class bf implements ActivityLifecycleCallbacks {
    final /* synthetic */ bc a;

    private bf(bc bcVar) {
        this.a = bcVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.a.l().g.a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    CharSequence queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            this.a.l().f.a("Activity created with referrer", queryParameter);
                            if (!TextUtils.isEmpty(queryParameter)) {
                                this.a.a("auto", "_ldl", queryParameter);
                                return;
                            }
                            return;
                        }
                        this.a.l().f.a("Activity created with data 'referrer' param without gclid");
                    }
                }
            }
        } catch (Throwable th) {
            this.a.l().a.a("Throwable caught in onActivityCreated", th);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
