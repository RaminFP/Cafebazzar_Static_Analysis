package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import java.util.HashSet;
import java.util.Set;

public final class g implements Creator {
    static void a(NameEntity nameEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = nameEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, nameEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, nameEntity.c, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, nameEntity.d, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, nameEntity.e, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, nameEntity.f, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.a(parcel, 6, nameEntity.g, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            c.a(parcel, 7, nameEntity.h, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                case 3:
                    str2 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str3 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str5 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str6 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new NameEntity(hashSet, i, str, str2, str3, str4, str5, str6);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new NameEntity[i];
    }
}
