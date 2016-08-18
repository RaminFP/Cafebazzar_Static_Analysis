package com.farsitel.bazaar;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class e extends Binder implements d {
    public e() {
        attachInterface(this, "com.farsitel.bazaar.IUpdateCheckService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.farsitel.bazaar.IUpdateCheckService");
                long a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeLong(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.farsitel.bazaar.IUpdateCheckService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
