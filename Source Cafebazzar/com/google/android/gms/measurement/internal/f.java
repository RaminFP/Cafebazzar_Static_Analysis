package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class f implements Creator {
    public static UserAttributeParcel a(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        Long l = null;
        String str2 = null;
        String str3 = null;
        Float f = null;
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
                    j = a.e(parcel, readInt);
                    break;
                case 4:
                    l = a.f(parcel, readInt);
                    break;
                case 5:
                    int a2 = a.a(parcel, readInt);
                    if (a2 != 0) {
                        a.a(parcel, a2, 4);
                        f = Float.valueOf(parcel.readFloat());
                        break;
                    }
                    f = null;
                    break;
                case 6:
                    str2 = a.k(parcel, readInt);
                    break;
                case 7:
                    str3 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new UserAttributeParcel(i, str, j, l, f, str2, str3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(UserAttributeParcel userAttributeParcel, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, userAttributeParcel.a);
        c.a(parcel, 2, userAttributeParcel.b, false);
        c.a(parcel, 3, userAttributeParcel.c);
        c.a(parcel, 4, userAttributeParcel.d, false);
        Float f = userAttributeParcel.e;
        if (f != null) {
            c.a(parcel, 5, 4);
            parcel.writeFloat(f.floatValue());
        }
        c.a(parcel, 6, userAttributeParcel.f, false);
        c.a(parcel, 7, userAttributeParcel.g, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new UserAttributeParcel[i];
    }
}
