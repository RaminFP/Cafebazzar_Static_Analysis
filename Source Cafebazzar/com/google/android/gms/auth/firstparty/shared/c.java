package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public final class c implements Creator {
    static void a(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, scopeDetail.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, scopeDetail.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, scopeDetail.c, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, scopeDetail.d, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, scopeDetail.e, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, scopeDetail.f, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, scopeDetail.g, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, scopeDetail.h, i, false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        List arrayList = new ArrayList();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        FACLData fACLData = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    str3 = a.k(parcel, readInt);
                    break;
                case 5:
                    str4 = a.k(parcel, readInt);
                    break;
                case 6:
                    str5 = a.k(parcel, readInt);
                    break;
                case 7:
                    arrayList = a.r(parcel, readInt);
                    break;
                case 8:
                    fACLData = (FACLData) a.a(parcel, readInt, FACLData.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ScopeDetail(i, str, str2, str3, str4, str5, arrayList, fACLData);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
