package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class r implements Creator {
    public static EventParcel a(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
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
                    eventParams = (EventParams) a.a(parcel, readInt, EventParams.CREATOR);
                    break;
                case 4:
                    str2 = a.k(parcel, readInt);
                    break;
                case 5:
                    j = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new EventParcel(i, str, eventParams, str2, j);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, eventParcel.a);
        c.a(parcel, 2, eventParcel.b, false);
        c.a(parcel, 3, eventParcel.c, i, false);
        c.a(parcel, 4, eventParcel.d, false);
        c.a(parcel, 5, eventParcel.e);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new EventParcel[i];
    }
}
