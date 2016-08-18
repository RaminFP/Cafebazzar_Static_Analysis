package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final b CREATOR = new b();
    final int a;
    FACLConfig b;
    String c;
    boolean d;
    String e;

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.a = i;
        this.b = fACLConfig;
        this.c = str;
        this.d = z;
        this.e = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
