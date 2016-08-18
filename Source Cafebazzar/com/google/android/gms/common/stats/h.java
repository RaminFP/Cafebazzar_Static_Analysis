package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.List;

public final class h implements Creator {
    static void a(WakeLockEvent wakeLockEvent, Parcel parcel) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, wakeLockEvent.a);
        c.a(parcel, 2, wakeLockEvent.b);
        c.a(parcel, 4, wakeLockEvent.d, false);
        c.b(parcel, 5, wakeLockEvent.e);
        c.a(parcel, 6, wakeLockEvent.f, false);
        c.a(parcel, 8, wakeLockEvent.h);
        c.a(parcel, 10, wakeLockEvent.j, false);
        c.b(parcel, 11, wakeLockEvent.c);
        c.a(parcel, 12, wakeLockEvent.g, false);
        c.a(parcel, 13, wakeLockEvent.k, false);
        c.b(parcel, 14, wakeLockEvent.i);
        float f = wakeLockEvent.l;
        c.a(parcel, 15, 4);
        parcel.writeFloat(f);
        c.a(parcel, 16, wakeLockEvent.m);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    j = a.e(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                case 5:
                    i3 = a.d(parcel, readInt);
                    break;
                case 6:
                    list = a.r(parcel, readInt);
                    break;
                case 8:
                    j2 = a.e(parcel, readInt);
                    break;
                case 10:
                    str3 = a.k(parcel, readInt);
                    break;
                case 11:
                    i2 = a.d(parcel, readInt);
                    break;
                case 12:
                    str2 = a.k(parcel, readInt);
                    break;
                case 13:
                    str4 = a.k(parcel, readInt);
                    break;
                case 14:
                    i4 = a.d(parcel, readInt);
                    break;
                case 15:
                    f = a.h(parcel, readInt);
                    break;
                case 16:
                    j3 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
