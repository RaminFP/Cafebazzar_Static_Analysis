package com.b.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class ah {
    static ah a;
    final Context b;
    final Handler c = new Handler(Looper.getMainLooper());
    private final Handler d;

    private ah(Context context) {
        this.b = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("BackgroundHandler");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
    }

    public static void a(Context context) {
        synchronized (ah.class) {
            try {
                if (a == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("Context cannot be null");
                    }
                    a = new ah(context);
                }
            } catch (Throwable th) {
                Class cls = ah.class;
            }
        }
    }
}
