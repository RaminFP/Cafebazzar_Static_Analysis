package com.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class bh extends BroadcastReceiver {
    private static bh e;
    boolean a;
    Boolean b;
    private List c = new LinkedList();
    private boolean d = false;

    public static bh a() {
        synchronized (bh.class) {
            try {
                if (e == null) {
                    e = new bh();
                }
                bh bhVar = e;
                return bhVar;
            } finally {
                Object obj = bh.class;
            }
        }
    }

    private boolean a(Context context) {
        if (!this.d || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void a(bg bgVar) {
        synchronized (this) {
            if (bgVar != null) {
                this.c.add(new WeakReference(bgVar));
            }
        }
    }

    public final void b() {
        synchronized (this) {
            Context context = ah.a.b;
            this.d = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
            this.a = a(context);
            if (this.d) {
                Context context2 = ah.a.b;
                this.a = a(context2);
                context2.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        boolean a = a(context);
        if (this.a != a) {
            this.a = a;
            for (WeakReference weakReference : new LinkedList(this.c)) {
                bg bgVar = (bg) weakReference.get();
                if (bgVar != null) {
                    bgVar.a(this.a);
                }
            }
        }
    }
}
