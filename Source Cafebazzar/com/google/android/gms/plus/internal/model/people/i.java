package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import java.util.HashSet;
import java.util.Set;

public final class i implements Creator {
    static void a(PlacesLivedEntity placesLivedEntity, Parcel parcel) {
        int a = c.a(parcel, 20293);
        Set set = placesLivedEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, placesLivedEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, placesLivedEntity.c);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, placesLivedEntity.d, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = a.c(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new PlacesLivedEntity(hashSet, i, z, str);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlacesLivedEntity[i];
    }
}
