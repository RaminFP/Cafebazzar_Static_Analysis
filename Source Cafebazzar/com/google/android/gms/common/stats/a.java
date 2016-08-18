package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator {
    static void a(ConnectionEvent connectionEvent, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, connectionEvent.a);
        c.a(parcel, 2, connectionEvent.b);
        c.a(parcel, 4, connectionEvent.d, false);
        c.a(parcel, 5, connectionEvent.e, false);
        c.a(parcel, 6, connectionEvent.f, false);
        c.a(parcel, 7, connectionEvent.g, false);
        c.a(parcel, 8, connectionEvent.h, false);
        c.a(parcel, 10, connectionEvent.j);
        c.a(parcel, 11, connectionEvent.k);
        c.b(parcel, 12, connectionEvent.c);
        c.a(parcel, 13, connectionEvent.i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
