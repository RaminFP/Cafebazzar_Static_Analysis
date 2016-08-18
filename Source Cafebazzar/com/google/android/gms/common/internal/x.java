package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class x {
    private static final Object a = new Object();
    private static x b;

    public static x a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new y(context.getApplicationContext());
            }
        }
        return b;
    }

    public abstract boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void b(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void b(String str, ServiceConnection serviceConnection, String str2);
}
