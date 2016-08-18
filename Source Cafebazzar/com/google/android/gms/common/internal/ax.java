package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ax implements Creator {
    static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, resolveAccountResponse.a);
        c.a(parcel, 2, resolveAccountResponse.b, false);
        c.a(parcel, 3, resolveAccountResponse.c, i, false);
        c.a(parcel, 4, resolveAccountResponse.d);
        c.a(parcel, 5, resolveAccountResponse.e);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int a = a.a(parcel);
        ConnectionResult connectionResult = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    iBinder = a.l(parcel, readInt);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) a.a(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                case 5:
                    z2 = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
