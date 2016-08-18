package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class f implements Creator {
    static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, authAccountRequest.a);
        c.a(parcel, 2, authAccountRequest.b, false);
        c.a(parcel, 3, authAccountRequest.c, i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Scope[] scopeArr = null;
        int a = a.a(parcel);
        int i = 0;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new AuthAccountRequest(i, iBinder, scopeArr);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
