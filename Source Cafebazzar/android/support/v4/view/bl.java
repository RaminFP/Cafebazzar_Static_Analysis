package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class bl {
    static final bo a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new bn();
        } else {
            a = new bm();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
