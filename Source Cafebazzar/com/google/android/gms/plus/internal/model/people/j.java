package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity;
import java.util.HashSet;
import java.util.Set;

public final class j implements Creator {
    static void a(UrlsEntity urlsEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = urlsEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, urlsEntity.b);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.b(parcel, 3, UrlsEntity.d());
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, urlsEntity.e, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, urlsEntity.c, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.b(parcel, 6, urlsEntity.d);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str2 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new UrlsEntity(hashSet, i, str, i2, str2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new UrlsEntity[i];
    }
}
