package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.stats.b;
import java.util.HashMap;

final class y extends x implements Callback {
    private final HashMap a = new HashMap();
    private final Context b;
    private final Handler c;
    private final b d;
    private final long e;

    y(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), this);
        this.d = b.a();
        this.e = 5000;
    }

    private boolean a(z zVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        av.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            aa aaVar = (aa) this.a.get(zVar);
            if (aaVar != null) {
                this.c.removeMessages(0, aaVar);
                if (!aaVar.a(serviceConnection)) {
                    aaVar.a(serviceConnection, str);
                    switch (aaVar.c) {
                        case 1:
                            serviceConnection.onServiceConnected(aaVar.g, aaVar.e);
                            break;
                        case 2:
                            aaVar.a(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zVar);
            }
            aaVar = new aa(this, zVar);
            aaVar.a(serviceConnection, str);
            aaVar.a(str);
            this.a.put(zVar, aaVar);
            z = aaVar.d;
        }
        return z;
    }

    private void b(z zVar, ServiceConnection serviceConnection, String str) {
        av.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            aa aaVar = (aa) this.a.get(zVar);
            if (aaVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zVar);
            } else if (aaVar.a(serviceConnection)) {
                aaVar.h.d.a(aaVar.h.b, b.a(serviceConnection), null, null, 4);
                aaVar.b.remove(serviceConnection);
                if (aaVar.a()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, aaVar), this.e);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zVar);
            }
        }
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new z(componentName), serviceConnection, str);
    }

    public final boolean a(String str, ServiceConnection serviceConnection, String str2) {
        return a(new z(str), serviceConnection, str2);
    }

    public final void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        b(new z(componentName), serviceConnection, str);
    }

    public final void b(String str, ServiceConnection serviceConnection, String str2) {
        b(new z(str), serviceConnection, str2);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                aa aaVar = (aa) message.obj;
                synchronized (this.a) {
                    if (aaVar.a()) {
                        if (aaVar.d) {
                            aaVar.h.d.a(aaVar.h.b, aaVar.a);
                            aaVar.d = false;
                            aaVar.c = 2;
                        }
                        this.a.remove(aaVar.f);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
