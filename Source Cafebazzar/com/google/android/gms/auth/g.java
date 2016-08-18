package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class g implements Creator {
    static void a(AccountChangeEvent accountChangeEvent, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, accountChangeEvent.a);
        c.a(parcel, 2, accountChangeEvent.b);
        c.a(parcel, 3, accountChangeEvent.c, false);
        c.b(parcel, 4, accountChangeEvent.d);
        c.b(parcel, 5, accountChangeEvent.e);
        c.a(parcel, 6, accountChangeEvent.f, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int a = a.a(parcel);
        long j = 0;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    j = a.e(parcel, readInt);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    i2 = a.d(parcel, readInt);
                    break;
                case 5:
                    i3 = a.d(parcel, readInt);
                    break;
                case 6:
                    str2 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AccountChangeEvent(i, j, str, i2, i3, str2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
