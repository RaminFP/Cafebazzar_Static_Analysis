package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator CREATOR = new e();
    final int a;
    final int b;
    final IBinder c;
    final Scope[] d;
    final Bundle e;
    final String f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.a = i;
        this.b = i2;
        this.c = iBinder;
        this.d = scopeArr;
        this.e = bundle;
        this.f = str;
    }

    public ValidateAccountRequest(ad adVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, b.a, adVar == null ? null : adVar.asBinder(), scopeArr, bundle, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
