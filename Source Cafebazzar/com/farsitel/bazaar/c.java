package com.farsitel.bazaar;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class c extends Binder implements b {
    public c() {
        attachInterface(this, "com.farsitel.bazaar.ILoginCheckService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.farsitel.bazaar.ILoginCheckService");
                boolean a = a();
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString("com.farsitel.bazaar.ILoginCheckService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
