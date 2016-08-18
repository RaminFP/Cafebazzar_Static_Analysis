package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public final class b implements Creator {
    static void a(MomentEntity momentEntity, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        Set set = momentEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, momentEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, momentEntity.c, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, momentEntity.d, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, momentEntity.e, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.a(parcel, 6, momentEntity.f, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            c.a(parcel, 7, momentEntity.g, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ItemScopeEntity itemScopeEntity = null;
        int a = a.a(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            ItemScopeEntity itemScopeEntity3;
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    itemScopeEntity3 = (ItemScopeEntity) a.a(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity = itemScopeEntity3;
                    break;
                case 5:
                    str2 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    itemScopeEntity3 = (ItemScopeEntity) a.a(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case 7:
                    str3 = a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new MomentEntity(hashSet, i, str, itemScopeEntity, str2, itemScopeEntity2, str3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MomentEntity[i];
    }
}
