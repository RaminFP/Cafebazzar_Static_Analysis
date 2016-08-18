package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import java.util.HashSet;
import java.util.Set;

public final class e implements Creator {
    static void a(CoverPhotoEntity coverPhotoEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = coverPhotoEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, coverPhotoEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.b(parcel, 2, coverPhotoEntity.c);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, coverPhotoEntity.d, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.b(parcel, 4, coverPhotoEntity.e);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i3 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new CoverPhotoEntity(hashSet, i, i2, str, i3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CoverPhotoEntity[i];
    }
}
