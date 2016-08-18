package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;

final class w implements u {
    private IBinder a;

    w(IBinder iBinder) {
        this.a = iBinder;
    }

    public final void a(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a(EventParcel eventParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a(EventParcel eventParcel, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                obtain.writeInt(1);
                eventParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                obtain.writeInt(1);
                userAttributeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }

    public final void b(AppMetadata appMetadata) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                obtain.writeInt(1);
                appMetadata.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
