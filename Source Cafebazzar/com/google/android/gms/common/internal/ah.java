package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ah extends Binder implements ag {
    public static ag a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ag)) ? new ai(iBinder) : (ag) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
                a();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.ICancelToken");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
