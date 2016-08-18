package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.a.bm;
import com.google.android.gms.a.by;
import com.google.android.gms.a.cf;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Object a = new Object();
    private static b b;
    private static Integer h;
    private final List c;
    private final List d;
    private final List e;
    private final List f;
    private f g;
    private f i;

    private b() {
        if (b() == e.b) {
            this.c = Collections.EMPTY_LIST;
            this.d = Collections.EMPTY_LIST;
            this.e = Collections.EMPTY_LIST;
            this.f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) d.b.c();
        this.c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) d.c.c();
        this.d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) d.d.c();
        this.e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) d.e.c();
        this.f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.g = new f(1024, ((Long) d.f.c()).longValue());
        this.i = new f(1024, ((Long) d.f.c()).longValue());
    }

    public static b a() {
        synchronized (a) {
            if (b == null) {
                b = new b();
            }
        }
        return b;
    }

    public static String a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static int b() {
        if (h == null) {
            try {
                Object obj = (g.a && bm.b() && bm.a() == Process.myUid()) ? 1 : null;
                h = Integer.valueOf(obj != null ? ((Integer) d.a.c()).intValue() : e.b);
            } catch (SecurityException e) {
                h = Integer.valueOf(e.b);
            }
        }
        return h.intValue();
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, a(serviceConnection), null, null, 1);
    }

    public void a(Context context, String str, String str2, Intent intent, int i) {
        Object obj = !g.a ? null : b() == e.b ? null : 1;
        if (obj != null && this.g != null) {
            String str3;
            String str4;
            String a;
            if (i != 4 && i != 1) {
                ServiceInfo serviceInfo;
                List queryIntentServices = context.getPackageManager().queryIntentServices(intent, NotificationCompat.FLAG_HIGH_PRIORITY);
                if (queryIntentServices == null || queryIntentServices.size() == 0) {
                    Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), cf.a(3, 20)}));
                    serviceInfo = null;
                } else {
                    if (queryIntentServices.size() > 1) {
                        Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), cf.a(3, 20)}));
                        Iterator it = queryIntentServices.iterator();
                        if (it.hasNext()) {
                            Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                            serviceInfo = null;
                        }
                    }
                    serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                }
                if (serviceInfo == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str3 = serviceInfo.processName;
                str4 = serviceInfo.name;
                a = cf.a(context, Binder.getCallingPid());
                obj = (this.c.contains(a) || this.d.contains(str2) || this.e.contains(str3) || this.f.contains(str4) || (str3.equals(a) && (b() & e.g) != 0)) ? null : 1;
                if (obj != null) {
                    this.g.a(str);
                } else {
                    return;
                }
            } else if (this.g.b(str)) {
                str3 = null;
                str4 = null;
                a = null;
            } else {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str5 = null;
            if (!((b() & e.f) == 0 || i == 13)) {
                str5 = cf.a(3, 5);
            }
            long j = 0;
            if ((b() & e.h) != 0) {
                j = Debug.getNativeHeapAllocatedSize();
            }
            Parcelable connectionEvent = (i == 1 || i == 4 || i == 14) ? new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str5, str, SystemClock.elapsedRealtime(), j) : new ConnectionEvent(currentTimeMillis, i, a, str2, str3, str4, str5, str, SystemClock.elapsedRealtime(), j);
            context.startService(new Intent().setComponent(e.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
        }
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean a = (component == null || (g.a && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(component.getPackageName()))) ? false : by.a(context, component.getPackageName());
        if (a) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }
}
