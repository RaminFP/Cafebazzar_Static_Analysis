package b.a.a.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class c implements ActivityLifecycleCallbacks {
    final /* synthetic */ d a;
    final /* synthetic */ b b;

    c(b bVar, d dVar) {
        this.b = bVar;
        this.a = dVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.a.a(activity);
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        this.a.d(activity);
    }

    public final void onActivityResumed(Activity activity) {
        this.a.c(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        this.a.b(activity);
    }

    public final void onActivityStopped(Activity activity) {
        this.a.e(activity);
    }
}
