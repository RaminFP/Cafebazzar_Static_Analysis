package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class e implements Creator {
    static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, validateAccountRequest.a);
        c.b(parcel, 2, validateAccountRequest.b);
        c.a(parcel, 3, validateAccountRequest.c, false);
        c.a(parcel, 4, validateAccountRequest.d, i, false);
        c.a(parcel, 5, validateAccountRequest.e, false);
        c.a(parcel, 6, validateAccountRequest.f, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int a = a.a(parcel);
        Scope[] scopeArr = null;
        Bundle bundle = null;
        String str = null;
        int i2 = 0;
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
                    iBinder = a.l(parcel, readInt);
                    break;
                case 4:
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                case 5:
                    bundle = a.m(parcel, readInt);
                    break;
                case 6:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new ValidateAccountRequest(i, i2, iBinder, scopeArr, bundle, str);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
