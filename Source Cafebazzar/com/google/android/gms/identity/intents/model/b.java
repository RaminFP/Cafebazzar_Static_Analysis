package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b implements Creator {
    static void a(UserAddress userAddress, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, userAddress.a);
        c.a(parcel, 2, userAddress.b, false);
        c.a(parcel, 3, userAddress.c, false);
        c.a(parcel, 4, userAddress.d, false);
        c.a(parcel, 5, userAddress.e, false);
        c.a(parcel, 6, userAddress.f, false);
        c.a(parcel, 7, userAddress.g, false);
        c.a(parcel, 8, userAddress.h, false);
        c.a(parcel, 9, userAddress.i, false);
        c.a(parcel, 10, userAddress.j, false);
        c.a(parcel, 11, userAddress.k, false);
        c.a(parcel, 12, userAddress.l, false);
        c.a(parcel, 13, userAddress.m, false);
        c.a(parcel, 14, userAddress.n);
        c.a(parcel, 15, userAddress.o, false);
        c.a(parcel, 16, userAddress.p, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    str3 = a.k(parcel, readInt);
                    break;
                case 5:
                    str4 = a.k(parcel, readInt);
                    break;
                case 6:
                    str5 = a.k(parcel, readInt);
                    break;
                case 7:
                    str6 = a.k(parcel, readInt);
                    break;
                case 8:
                    str7 = a.k(parcel, readInt);
                    break;
                case 9:
                    str8 = a.k(parcel, readInt);
                    break;
                case 10:
                    str9 = a.k(parcel, readInt);
                    break;
                case 11:
                    str10 = a.k(parcel, readInt);
                    break;
                case 12:
                    str11 = a.k(parcel, readInt);
                    break;
                case 13:
                    str12 = a.k(parcel, readInt);
                    break;
                case 14:
                    z = a.c(parcel, readInt);
                    break;
                case 15:
                    str13 = a.k(parcel, readInt);
                    break;
                case 16:
                    str14 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new UserAddress[i];
    }
}
