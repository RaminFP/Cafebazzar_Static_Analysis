package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class s extends m {
    public final IBinder e;
    final /* synthetic */ l f;

    public s(l lVar, int i, IBinder iBinder, Bundle bundle) {
        this.f = lVar;
        super(lVar, i, bundle);
        this.e = iBinder;
    }

    protected final void a(ConnectionResult connectionResult) {
        if (this.f.s != null) {
            this.f.s.a(connectionResult);
        }
        l.i_();
    }

    protected final boolean a() {
        try {
            String interfaceDescriptor = this.e.getInterfaceDescriptor();
            if (this.f.g().equals(interfaceDescriptor)) {
                IInterface a = this.f.a(this.e);
                if (a == null || !this.f.a(2, 3, a)) {
                    return false;
                }
                l lVar = this.f;
                if (this.f.r != null) {
                    this.f.r.a(null);
                }
                return true;
            }
            Log.e("GmsClient", "service descriptor mismatch: " + this.f.g() + " vs. " + interfaceDescriptor);
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
