package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;

public final class c implements Creator {
    static void a(Entry entry, Parcel parcel) {
        int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, entry.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, entry.b, false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 3, entry.c);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int a = a.a(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    i = a.d(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new Entry(i2, str, i);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Entry[i];
    }
}
