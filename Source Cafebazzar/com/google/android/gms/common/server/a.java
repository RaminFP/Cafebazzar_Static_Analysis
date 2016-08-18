package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator {
    public static FavaDiagnosticsEntity a(Parcel parcel) {
        int i = 0;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new FavaDiagnosticsEntity(i2, str, i);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, favaDiagnosticsEntity.a);
        c.a(parcel, 2, favaDiagnosticsEntity.b, false);
        c.b(parcel, 3, favaDiagnosticsEntity.c);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FavaDiagnosticsEntity[i];
    }
}
