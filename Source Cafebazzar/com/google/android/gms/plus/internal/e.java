package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.a;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.f;

public abstract class e extends Binder implements d {
    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new f(iBinder) : (d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        FavaDiagnosticsEntity favaDiagnosticsEntity = null;
        String a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                SafeParcelResponse a2;
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                if (parcel.readInt() != 0) {
                    f fVar = SafeParcelResponse.CREATOR;
                    a2 = f.a(parcel);
                } else {
                    a2 = null;
                }
                a(a2);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder asBinder;
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                ag a3 = a(b.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                if (a3 != null) {
                    asBinder = a3.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 17:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                c(b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                b(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a(b.a(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 40:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                d(b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a = c();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 42:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                boolean d = d();
                parcel2.writeNoException();
                parcel2.writeInt(d ? 1 : 0);
                return true;
            case 43:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a = e();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 44:
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                e(b.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 45:
                SafeParcelResponse a4;
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                a a5 = b.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    f fVar2 = SafeParcelResponse.CREATOR;
                    a4 = f.a(parcel);
                }
                a(a5, a4);
                parcel2.writeNoException();
                return true;
            case 46:
                FavaDiagnosticsEntity a6;
                parcel.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    a aVar = FavaDiagnosticsEntity.CREATOR;
                    a6 = a.a(parcel);
                } else {
                    a6 = null;
                }
                if (parcel.readInt() != 0) {
                    a aVar2 = FavaDiagnosticsEntity.CREATOR;
                    favaDiagnosticsEntity = a.a(parcel);
                }
                a(readString, a6, favaDiagnosticsEntity);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.plus.internal.IPlusService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
