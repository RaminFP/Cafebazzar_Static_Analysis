package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public final class b implements Creator {
    static void a(Field field, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, field.a);
        c.b(parcel, 2, field.a());
        c.a(parcel, 3, field.b());
        c.b(parcel, 4, field.c());
        c.a(parcel, 5, field.d());
        c.a(parcel, 6, field.e(), false);
        c.b(parcel, 7, field.f());
        c.a(parcel, 8, field.h(), false);
        c.a(parcel, 9, field.k == null ? null : ConverterWrapper.a(field.k), i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int a = a.a(parcel);
        String str2 = null;
        ConverterWrapper converterWrapper = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    i2 = a.d(parcel, readInt);
                    break;
                case 3:
                    z = a.c(parcel, readInt);
                    break;
                case 4:
                    i3 = a.d(parcel, readInt);
                    break;
                case 5:
                    z2 = a.c(parcel, readInt);
                    break;
                case 6:
                    str = a.k(parcel, readInt);
                    break;
                case 7:
                    i4 = a.d(parcel, readInt);
                    break;
                case 8:
                    str2 = a.k(parcel, readInt);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) a.a(parcel, readInt, ConverterWrapper.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new Field(i, i2, z, i3, z2, str, i4, str2, converterWrapper);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Field[i];
    }
}
