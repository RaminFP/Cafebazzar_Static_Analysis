package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b implements Creator {
    static void a(PlayLoggerContext playLoggerContext, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, playLoggerContext.a);
        c.a(parcel, 2, playLoggerContext.b, false);
        c.b(parcel, 3, playLoggerContext.c);
        c.b(parcel, 4, playLoggerContext.d);
        c.a(parcel, 5, playLoggerContext.e, false);
        c.a(parcel, 6, playLoggerContext.f, false);
        c.a(parcel, 7, playLoggerContext.g);
        c.a(parcel, 8, playLoggerContext.h, false);
        c.a(parcel, 9, playLoggerContext.i);
        c.b(parcel, 10, playLoggerContext.j);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int a = a.a(parcel);
        boolean z2 = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
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
                    i2 = a.d(parcel, readInt);
                    break;
                case 4:
                    i3 = a.d(parcel, readInt);
                    break;
                case 5:
                    str2 = a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = a.k(parcel, readInt);
                    break;
                case 7:
                    z2 = a.c(parcel, readInt);
                    break;
                case 8:
                    str4 = a.k(parcel, readInt);
                    break;
                case 9:
                    z = a.c(parcel, readInt);
                    break;
                case 10:
                    i4 = a.d(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new PlayLoggerContext(i, str, i2, i3, str2, str3, z2, str4, z, i4);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
