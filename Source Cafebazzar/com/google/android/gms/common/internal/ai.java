package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

final class ai implements ag {
    private IBinder a;

    ai(IBinder iBinder) {
        this.a = iBinder;
    }

    public final void a() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
            this.a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
