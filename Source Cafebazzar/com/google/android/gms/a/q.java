package com.google.android.gms.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.e;

public abstract class q extends Binder implements p {
    public static p a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof p)) ? new r(iBinder) : (p) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        LogEventParcelable logEventParcelable = null;
        switch (i) {
            case 1:
                m mVar;
                parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    mVar = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new o(readStrongBinder) : (m) queryLocalInterface;
                }
                if (parcel.readInt() != 0) {
                    e eVar = LogEventParcelable.CREATOR;
                    logEventParcelable = e.a(parcel);
                }
                a(mVar, logEventParcelable);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
