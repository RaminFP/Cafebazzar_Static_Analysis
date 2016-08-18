package ir.cafebazaar.pardakht;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;

public enum aa {
    INSTANCE;
    
    final Context b;
    final NotificationManager c;
    long d;
    SharedPreferences e;

    public final void a() {
        this.c.cancel(2323);
    }
}
