package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator {
    static void a(FACLConfig fACLConfig, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, fACLConfig.a);
        c.a(parcel, 2, fACLConfig.b);
        c.a(parcel, 3, fACLConfig.c, false);
        c.a(parcel, 4, fACLConfig.d);
        c.a(parcel, 5, fACLConfig.e);
        c.a(parcel, 6, fACLConfig.f);
        c.a(parcel, 7, fACLConfig.g);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 6:
                    z4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 7:
                    z5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new FACLConfig(i, z, str, z2, z3, z4, z5);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FACLConfig[i];
    }
}
