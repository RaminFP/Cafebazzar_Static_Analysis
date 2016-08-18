package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements Creator {
    static void a(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        Set set = itemScopeEntity.a;
        if (set.contains(Integer.valueOf(1))) {
            c.b(parcel, 1, itemScopeEntity.b);
        }
        if (set.contains(Integer.valueOf(2))) {
            c.a(parcel, 2, itemScopeEntity.c, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            c.a(parcel, 3, itemScopeEntity.d, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            c.a(parcel, 4, itemScopeEntity.e, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            c.a(parcel, 5, itemScopeEntity.f, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            c.a(parcel, 6, itemScopeEntity.g, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            c.a(parcel, 7, itemScopeEntity.h, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            c.b(parcel, 8, itemScopeEntity.i, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            c.b(parcel, 9, itemScopeEntity.j);
        }
        if (set.contains(Integer.valueOf(10))) {
            c.b(parcel, 10, itemScopeEntity.k, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            c.a(parcel, 11, itemScopeEntity.l, i, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            c.b(parcel, 12, itemScopeEntity.m, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            c.a(parcel, 13, itemScopeEntity.n, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            c.a(parcel, 14, itemScopeEntity.o, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            c.a(parcel, 15, itemScopeEntity.p, i, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            c.a(parcel, 17, itemScopeEntity.r, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            c.a(parcel, 16, itemScopeEntity.q, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            c.b(parcel, 19, itemScopeEntity.t, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            c.a(parcel, 18, itemScopeEntity.s, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            c.a(parcel, 21, itemScopeEntity.v, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            c.a(parcel, 20, itemScopeEntity.u, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            c.a(parcel, 23, itemScopeEntity.x, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            c.a(parcel, 22, itemScopeEntity.w, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            c.a(parcel, 25, itemScopeEntity.z, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            c.a(parcel, 24, itemScopeEntity.y, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            c.a(parcel, 27, itemScopeEntity.B, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            c.a(parcel, 26, itemScopeEntity.A, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            c.a(parcel, 29, itemScopeEntity.D, i, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            c.a(parcel, 28, itemScopeEntity.C, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            c.a(parcel, 31, itemScopeEntity.F, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            c.a(parcel, 30, itemScopeEntity.E, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            c.a(parcel, 34, itemScopeEntity.I, i, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            c.a(parcel, 32, itemScopeEntity.G, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            c.a(parcel, 33, itemScopeEntity.H, true);
        }
        if (set.contains(Integer.valueOf(38))) {
            c.a(parcel, 38, itemScopeEntity.L);
        }
        if (set.contains(Integer.valueOf(39))) {
            c.a(parcel, 39, itemScopeEntity.M, true);
        }
        if (set.contains(Integer.valueOf(36))) {
            c.a(parcel, 36, itemScopeEntity.J);
        }
        if (set.contains(Integer.valueOf(37))) {
            c.a(parcel, 37, itemScopeEntity.K, i, true);
        }
        if (set.contains(Integer.valueOf(42))) {
            c.a(parcel, 42, itemScopeEntity.P, true);
        }
        if (set.contains(Integer.valueOf(43))) {
            c.a(parcel, 43, itemScopeEntity.Q, true);
        }
        if (set.contains(Integer.valueOf(40))) {
            c.a(parcel, 40, itemScopeEntity.N, i, true);
        }
        if (set.contains(Integer.valueOf(41))) {
            c.b(parcel, 41, itemScopeEntity.O, true);
        }
        if (set.contains(Integer.valueOf(46))) {
            c.a(parcel, 46, itemScopeEntity.T, i, true);
        }
        if (set.contains(Integer.valueOf(47))) {
            c.a(parcel, 47, itemScopeEntity.U, true);
        }
        if (set.contains(Integer.valueOf(44))) {
            c.a(parcel, 44, itemScopeEntity.R, true);
        }
        if (set.contains(Integer.valueOf(45))) {
            c.a(parcel, 45, itemScopeEntity.S, true);
        }
        if (set.contains(Integer.valueOf(51))) {
            c.a(parcel, 51, itemScopeEntity.Y, true);
        }
        if (set.contains(Integer.valueOf(50))) {
            c.a(parcel, 50, itemScopeEntity.X, i, true);
        }
        if (set.contains(Integer.valueOf(49))) {
            c.a(parcel, 49, itemScopeEntity.W, true);
        }
        if (set.contains(Integer.valueOf(48))) {
            c.a(parcel, 48, itemScopeEntity.V, true);
        }
        if (set.contains(Integer.valueOf(55))) {
            c.a(parcel, 55, itemScopeEntity.ac, true);
        }
        if (set.contains(Integer.valueOf(54))) {
            c.a(parcel, 54, itemScopeEntity.ab, true);
        }
        if (set.contains(Integer.valueOf(53))) {
            c.a(parcel, 53, itemScopeEntity.aa, true);
        }
        if (set.contains(Integer.valueOf(52))) {
            c.a(parcel, 52, itemScopeEntity.Z, true);
        }
        if (set.contains(Integer.valueOf(56))) {
            c.a(parcel, 56, itemScopeEntity.ad, true);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        List list = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double d = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            ItemScopeEntity itemScopeEntity11;
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    itemScopeEntity = itemScopeEntity11;
                    break;
                case 3:
                    list = com.google.android.gms.common.internal.safeparcel.a.r(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity11;
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    itemScopeEntity3 = itemScopeEntity11;
                    break;
                case 12:
                    list4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    itemScopeEntity4 = itemScopeEntity11;
                    break;
                case 16:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    list5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    itemScopeEntity5 = itemScopeEntity11;
                    break;
                case 30:
                    str18 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case 31:
                    str19 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    itemScopeEntity6 = itemScopeEntity11;
                    break;
                case 36:
                    d = com.google.android.gms.common.internal.safeparcel.a.i(parcel, readInt);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    itemScopeEntity7 = itemScopeEntity11;
                    break;
                case 38:
                    d2 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, readInt);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    itemScopeEntity8 = itemScopeEntity11;
                    break;
                case 41:
                    list6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    itemScopeEntity9 = itemScopeEntity11;
                    break;
                case 47:
                    str27 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, (Creator) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    itemScopeEntity10 = itemScopeEntity11;
                    break;
                case 51:
                    str30 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ItemScopeEntity(hashSet, i, itemScopeEntity, list, itemScopeEntity2, str, str2, str3, list2, i2, list3, itemScopeEntity3, list4, str4, str5, itemScopeEntity4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity5, str18, str19, str20, str21, itemScopeEntity6, d, itemScopeEntity7, d2, str22, itemScopeEntity8, list6, str23, str24, str25, str26, itemScopeEntity9, str27, str28, str29, itemScopeEntity10, str30, str31, str32, str33, str34, str35);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
