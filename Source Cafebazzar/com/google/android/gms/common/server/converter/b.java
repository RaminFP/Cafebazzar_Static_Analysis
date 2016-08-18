package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;
import java.util.List;

public final class b implements Creator {
    static void a(StringToIntConverter stringToIntConverter, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, stringToIntConverter.a);
        List arrayList = new ArrayList();
        for (String str : stringToIntConverter.b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) stringToIntConverter.b.get(str)).intValue()));
        }
        c.b(parcel, 2, arrayList, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    arrayList = a.c(parcel, readInt, Entry.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
