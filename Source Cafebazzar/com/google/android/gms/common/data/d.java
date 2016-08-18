package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class d implements Creator {
    public static DataHolder a(Parcel parcel) {
        int i = 0;
        String[] strArr = null;
        int a = a.a(parcel);
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strArr = a.q(parcel, readInt);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) a.b(parcel, readInt, CursorWindow.CREATOR);
                    break;
                case 3:
                    i2 = a.d(parcel, readInt);
                    break;
                case 4:
                    bundle = a.m(parcel, readInt);
                    break;
                case 1000:
                    i = a.d(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() != a) {
            throw new b("Overread allowed size end=" + a, parcel);
        }
        DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
        dataHolder.a();
        return dataHolder;
    }

    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.a(parcel, 1, dataHolder.b, false);
        c.b(parcel, 1000, dataHolder.a);
        c.a(parcel, 2, dataHolder.d, i, false);
        c.b(parcel, 3, dataHolder.e);
        c.a(parcel, 4, dataHolder.f, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
