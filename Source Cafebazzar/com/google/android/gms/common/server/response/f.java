package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class f implements Creator {
    public static SafeParcelResponse a(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int a = a.a(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    parcel2 = a.s(parcel, readInt);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) a.a(parcel, readInt, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        Parcelable parcelable;
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, safeParcelResponse.a);
        Parcel d = safeParcelResponse.d();
        if (d != null) {
            int a2 = c.a(parcel, 2);
            parcel.appendFrom(d, 0, d.dataSize());
            c.b(parcel, a2);
        }
        switch (safeParcelResponse.b) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = safeParcelResponse.c;
                break;
            case 2:
                parcelable = safeParcelResponse.c;
                break;
            default:
                throw new IllegalStateException("Invalid creation type: " + safeParcelResponse.b);
        }
        c.a(parcel, 3, parcelable, i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
