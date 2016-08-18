package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a implements Creator {
    static void a(LogEvent logEvent, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, logEvent.a);
        c.a(parcel, 2, logEvent.b);
        c.a(parcel, 3, logEvent.d, false);
        c.a(parcel, 4, logEvent.e, false);
        c.a(parcel, 5, logEvent.f, false);
        c.a(parcel, 6, logEvent.c);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        String str = null;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i = 0;
        byte[] bArr = null;
        Bundle bundle = null;
        long j2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.d(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.a.m(parcel, readInt);
                    break;
                case 6:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new LogEvent(i, j, j2, str, bArr, bundle);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LogEvent[i];
    }
}
