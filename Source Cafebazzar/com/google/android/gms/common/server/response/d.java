package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d implements Creator {
    static void a(FieldMappingDictionary fieldMappingDictionary, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, fieldMappingDictionary.a);
        List arrayList = new ArrayList();
        for (String str : fieldMappingDictionary.b.keySet()) {
            arrayList.add(new Entry(str, (Map) fieldMappingDictionary.b.get(str)));
        }
        c.b(parcel, 2, arrayList, false);
        c.a(parcel, 3, fieldMappingDictionary.c, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
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
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
