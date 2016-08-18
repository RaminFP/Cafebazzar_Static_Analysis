package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import java.util.HashSet;
import java.util.Set;

public final class d implements Creator {
    static void a(CoverInfoEntity coverInfoEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = coverInfoEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, coverInfoEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.b(parcel, 2, coverInfoEntity.c);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.b(parcel, 3, coverInfoEntity.d);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new CoverInfoEntity(hashSet, i3, i2, i);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CoverInfoEntity[i];
    }
}
