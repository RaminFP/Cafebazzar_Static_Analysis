package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class i implements Creator {
    static void a(PlusSession plusSession, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.a(parcel, 1, plusSession.b, false);
        c.b(parcel, 1000, plusSession.a);
        c.a(parcel, 2, plusSession.c, false);
        c.a(parcel, 3, plusSession.d, false);
        c.a(parcel, 4, plusSession.e, false);
        c.a(parcel, 5, plusSession.f, false);
        c.a(parcel, 6, plusSession.g, false);
        c.a(parcel, 7, plusSession.h, false);
        c.a(parcel, 8, plusSession.i, false);
        c.a(parcel, 9, plusSession.j, i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        PlusCommonExtras plusCommonExtras = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = a.k(parcel, readInt);
                    break;
                case 2:
                    strArr = a.q(parcel, readInt);
                    break;
                case 3:
                    strArr2 = a.q(parcel, readInt);
                    break;
                case 4:
                    strArr3 = a.q(parcel, readInt);
                    break;
                case 5:
                    str2 = a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = a.k(parcel, readInt);
                    break;
                case 7:
                    str4 = a.k(parcel, readInt);
                    break;
                case 8:
                    str5 = a.k(parcel, readInt);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) a.a(parcel, readInt, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = a.d(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new PlusSession(i, str, strArr, strArr2, strArr3, str2, str3, str4, str5, plusCommonExtras);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlusSession[i];
    }
}
