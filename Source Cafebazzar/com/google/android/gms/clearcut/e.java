package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public final class e implements Creator {
    public static LogEventParcelable a(Parcel parcel) {
        int a = a.a(parcel);
        byte[] bArr = null;
        PlayLoggerContext playLoggerContext = null;
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) a.a(parcel, readInt, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArr = a.n(parcel, readInt);
                    break;
                case 4:
                    iArr = a.o(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    static void a(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, logEventParcelable.a);
        c.a(parcel, 2, logEventParcelable.b, i, false);
        c.a(parcel, 3, logEventParcelable.c, false);
        int[] iArr = logEventParcelable.d;
        if (iArr != null) {
            int a2 = c.a(parcel, 4);
            parcel.writeIntArray(iArr);
            c.b(parcel, a2);
        }
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
