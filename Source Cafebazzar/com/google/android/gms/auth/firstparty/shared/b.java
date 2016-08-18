package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b implements Creator {
    static void a(FACLData fACLData, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, fACLData.a);
        c.a(parcel, 2, fACLData.b, i, false);
        c.a(parcel, 3, fACLData.c, false);
        c.a(parcel, 4, fACLData.d);
        c.a(parcel, 5, fACLData.e, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        FACLConfig fACLConfig = null;
        int a = a.a(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    fACLConfig = (FACLConfig) a.a(parcel, readInt, FACLConfig.CREATOR);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                case 5:
                    str2 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new FACLData(i, fACLConfig, str, z, str2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FACLData[i];
    }
}
