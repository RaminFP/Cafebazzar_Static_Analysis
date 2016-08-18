package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class q {
    private final r a;

    public q(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    private q(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.a = new u(context, onGestureListener, null);
        } else {
            this.a = new s(context, onGestureListener, null);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }
}
