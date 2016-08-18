package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements Creator {
    public static PersonEntity a(Parcel parcel) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        ImageEntity imageEntity = null;
        boolean z = false;
        String str7 = null;
        NameEntity nameEntity = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    AgeRangeEntity ageRangeEntity2 = (AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, AgeRangeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    ageRangeEntity = ageRangeEntity2;
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    CoverEntity coverEntity2 = (CoverEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, CoverEntity.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    coverEntity = coverEntity2;
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    ImageEntity imageEntity2 = (ImageEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, ImageEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    imageEntity = imageEntity2;
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    NameEntity nameEntity2 = (NameEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) NameEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    nameEntity = nameEntity2;
                    break;
                case 20:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, OrganizationsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, PlacesLivedEntity.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, UrlsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new PersonEntity(hashSet, i, str, ageRangeEntity, str2, str3, i2, coverEntity, str4, str5, i3, str6, imageEntity, z, str7, nameEntity, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(PersonEntity personEntity, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        Set set = personEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, personEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, personEntity.c, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, personEntity.d, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, personEntity.e, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, personEntity.f, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.b(parcel, 6, personEntity.g);
        }
        if (set.contains(Integer.valueOf(7))) {
            c.a(parcel, 7, personEntity.h, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            c.a(parcel, 8, personEntity.i, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            c.a(parcel, 9, personEntity.j, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            c.b(parcel, 12, personEntity.k);
        }
        if (set.contains(Integer.valueOf(14))) {
            c.a(parcel, 14, personEntity.l, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            c.a(parcel, 15, personEntity.m, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            c.a(parcel, 16, personEntity.n);
        }
        if (set.contains(Integer.valueOf(19))) {
            c.a(parcel, 19, personEntity.p, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            c.a(parcel, 18, personEntity.o, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            c.b(parcel, 21, personEntity.r);
        }
        if (set.contains(Integer.valueOf(20))) {
            c.a(parcel, 20, personEntity.q, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            c.b(parcel, 23, personEntity.t, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            c.b(parcel, 22, personEntity.s, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            c.b(parcel, 25, personEntity.v);
        }
        if (set.contains(Integer.valueOf(24))) {
            c.b(parcel, 24, personEntity.u);
        }
        if (set.contains(Integer.valueOf(27))) {
            c.a(parcel, 27, personEntity.x, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            c.a(parcel, 26, personEntity.w, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            c.a(parcel, 29, personEntity.z);
        }
        if (set.contains(Integer.valueOf(28))) {
            c.b(parcel, 28, personEntity.y, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PersonEntity[i];
    }
}
