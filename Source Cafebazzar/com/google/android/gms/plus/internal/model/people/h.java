package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import java.util.HashSet;
import java.util.Set;

public final class h implements Creator {
    static void a(OrganizationsEntity organizationsEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = organizationsEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, organizationsEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, organizationsEntity.c, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, organizationsEntity.d, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, organizationsEntity.e, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, organizationsEntity.f, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.a(parcel, 6, organizationsEntity.g, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            c.a(parcel, 7, organizationsEntity.h);
        }
        if (set.contains(Integer.valueOf(8))) {
            c.a(parcel, 8, organizationsEntity.i, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            c.a(parcel, 9, organizationsEntity.j, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            c.b(parcel, 10, organizationsEntity.k);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i = 0;
        int i2 = 0;
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
                    z = a.c(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str6 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str7 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i2 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new OrganizationsEntity(hashSet, i, str, str2, str3, str4, str5, z, str6, str7, i2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new OrganizationsEntity[i];
    }
}
