package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.stats.b;

public final class bm implements ServiceConnection, k, l {
    volatile boolean a;
    volatile y b;
    final /* synthetic */ bg c;

    protected bm(bg bgVar) {
        this.c = bgVar;
    }

    public final void a(int i) {
        av.b("MeasurementServiceConnection.onConnectionSuspended");
        this.c.l().f.a("Service connection suspended");
        this.c.k().a(new bq(this));
    }

    public final void a(Bundle bundle) {
        av.b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            this.a = false;
            try {
                u uVar = (u) this.b.n();
                this.b = null;
                this.c.k().a(new bp(this, uVar));
            } catch (DeadObjectException e) {
                this.b = null;
            } catch (IllegalStateException e2) {
                this.b = null;
            }
        }
    }

    public final void a(ConnectionResult connectionResult) {
        av.b("MeasurementServiceConnection.onConnectionFailed");
        this.c.l().b.a("Service connection failed", connectionResult);
        synchronized (this) {
            this.a = false;
            this.b = null;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        u uVar = null;
        av.b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            this.a = false;
            if (iBinder == null) {
                this.c.l().a.a("Service connected with null binder");
                return;
            }
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    uVar = v.a(iBinder);
                    this.c.l().g.a("Bound to IMeasurementService interface");
                } else {
                    this.c.l().a.a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException e) {
                this.c.l().a.a("Service connect failed to get IMeasurementService");
            }
            if (uVar == null) {
                try {
                    b.a().a(this.c.i(), this.c.a);
                } catch (IllegalArgumentException e2) {
                }
            } else {
                this.c.k().a(new bn(this, uVar));
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        av.b("MeasurementServiceConnection.onServiceDisconnected");
        this.c.l().f.a("Service disconnected");
        this.c.k().a(new bo(this, componentName));
    }
}
