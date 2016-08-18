package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class k implements Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, getServiceRequest.a);
        c.b(parcel, 2, getServiceRequest.b);
        c.b(parcel, 3, getServiceRequest.c);
        c.a(parcel, 4, getServiceRequest.d, false);
        c.a(parcel, 5, getServiceRequest.e, false);
        c.a(parcel, 6, getServiceRequest.f, i, false);
        c.a(parcel, 7, getServiceRequest.g, false);
        c.a(parcel, 8, getServiceRequest.h, i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int a = a.a(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        int i2 = 0;
        int i3 = 0;
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
                    i3 = a.d(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                case 5:
                    iBinder = a.l(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = a.m(parcel, readInt);
                    break;
                case 8:
                    account = (Account) a.a(parcel, readInt, Account.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
