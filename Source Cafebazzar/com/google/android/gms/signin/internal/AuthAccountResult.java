package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements r, SafeParcelable {
    public static final Creator CREATOR = new a();
    final int a;
    int b;
    Intent c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, null);
    }

    public final Status a() {
        return this.b == 0 ? Status.a : Status.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
