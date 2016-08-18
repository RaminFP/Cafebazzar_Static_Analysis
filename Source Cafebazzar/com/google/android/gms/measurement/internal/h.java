package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class h implements Creator {
    public static AppMetadata a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int a = a.a(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j2 = 0;
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
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    str3 = a.k(parcel, readInt);
                    break;
                case 5:
                    str4 = a.k(parcel, readInt);
                    break;
                case 6:
                    j = a.e(parcel, readInt);
                    break;
                case 7:
                    j2 = a.e(parcel, readInt);
                    break;
                case 8:
                    str5 = a.k(parcel, readInt);
                    break;
                case 9:
                    z = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(AppMetadata appMetadata, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, appMetadata.a);
        c.a(parcel, 2, appMetadata.b, false);
        c.a(parcel, 3, appMetadata.c, false);
        c.a(parcel, 4, appMetadata.d, false);
        c.a(parcel, 5, appMetadata.e, false);
        c.a(parcel, 6, appMetadata.f);
        c.a(parcel, 7, appMetadata.g);
        c.a(parcel, 8, appMetadata.h, false);
        c.a(parcel, 9, appMetadata.i);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AppMetadata[i];
    }
}
