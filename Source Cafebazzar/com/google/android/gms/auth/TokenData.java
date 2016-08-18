package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final j CREATOR = new j();
    final int a;
    final String b;
    final Long c;
    final boolean d;
    final boolean e;
    final List f;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List list) {
        this.a = i;
        this.b = av.a(str);
        this.c = l;
        this.d = z;
        this.e = z2;
        this.f = list;
    }

    public static TokenData a(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TokenData) {
            TokenData tokenData = (TokenData) obj;
            if (TextUtils.equals(this.b, tokenData.b) && at.a(this.c, tokenData.c) && this.d == tokenData.d && this.e == tokenData.e && at.a(this.f, tokenData.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.f});
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel);
    }
}
