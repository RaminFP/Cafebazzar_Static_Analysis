package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator CREATOR = new k();
    final int a;
    final int b;
    int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;

    public GetServiceRequest(int i) {
        this.a = 2;
        this.c = b.a;
        this.b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = b.a(ae.a(iBinder));
            }
            this.h = account2;
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        k.a(this, parcel, i);
    }
}
