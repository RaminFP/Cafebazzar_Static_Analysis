package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class ay {
    static final bd a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new bc();
        } else if (VERSION.SDK_INT >= 9) {
            a = new bb();
        } else if (VERSION.SDK_INT >= 5) {
            a = new ba();
        } else {
            a = new az();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() >> 8) & 255;
    }

    public static int b(MotionEvent motionEvent, int i) {
        return a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return a.c(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent) {
        return a.a(motionEvent);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return a.d(motionEvent, i);
    }

    public static int d(MotionEvent motionEvent) {
        return a.b(motionEvent);
    }

    public static float e(MotionEvent motionEvent, int i) {
        return a.e(motionEvent, i);
    }
}
