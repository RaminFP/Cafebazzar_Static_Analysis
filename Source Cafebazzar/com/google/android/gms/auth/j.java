package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.List;

public final class j implements Creator {
    static void a(TokenData tokenData, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, tokenData.a);
        c.a(parcel, 2, tokenData.b, false);
        c.a(parcel, 3, tokenData.c, false);
        c.a(parcel, 4, tokenData.d);
        c.a(parcel, 5, tokenData.e);
        c.a(parcel, 6, tokenData.f, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int a = a.a(parcel);
        Long l = null;
        List list = null;
        boolean z2 = false;
        int i = 0;
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
                    l = a.f(parcel, readInt);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                case 5:
                    z2 = a.c(parcel, readInt);
                    break;
                case 6:
                    list = a.r(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new TokenData(i, str, l, z, z2, list);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }
}
