package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class v extends Binder implements u {
    public v() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public static u a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new w(iBinder) : (u) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AppMetadata appMetadata = null;
        r rVar;
        h hVar;
        h hVar2;
        switch (i) {
            case 1:
                EventParcel a;
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    rVar = EventParcel.CREATOR;
                    a = r.a(parcel);
                } else {
                    a = null;
                }
                if (parcel.readInt() != 0) {
                    hVar = AppMetadata.CREATOR;
                    appMetadata = h.a(parcel);
                }
                a(a, appMetadata);
                parcel2.writeNoException();
                return true;
            case 2:
                UserAttributeParcel a2;
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    f fVar = UserAttributeParcel.CREATOR;
                    a2 = f.a(parcel);
                } else {
                    a2 = null;
                }
                if (parcel.readInt() != 0) {
                    hVar = AppMetadata.CREATOR;
                    appMetadata = h.a(parcel);
                }
                a(a2, appMetadata);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    hVar2 = AppMetadata.CREATOR;
                    appMetadata = h.a(parcel);
                }
                a(appMetadata);
                parcel2.writeNoException();
                return true;
            case 5:
                EventParcel a3;
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    rVar = EventParcel.CREATOR;
                    a3 = r.a(parcel);
                }
                a(a3, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0) {
                    hVar2 = AppMetadata.CREATOR;
                    appMetadata = h.a(parcel);
                }
                b(appMetadata);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
