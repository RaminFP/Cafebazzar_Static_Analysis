package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import java.util.HashSet;
import java.util.Set;

public final class f implements Creator {
    static void a(ImageEntity imageEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = imageEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, imageEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, imageEntity.c, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ImageEntity(hashSet, i, str);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ImageEntity[i];
    }
}
