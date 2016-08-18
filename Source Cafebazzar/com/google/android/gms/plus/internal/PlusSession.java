package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlusSession implements SafeParcelable {
    public static final i CREATOR = new i();
    final int a;
    final String b;
    final String[] c;
    final String[] d;
    final String[] e;
    final String f;
    final String g;
    final String h;
    final String i;
    final PlusCommonExtras j;

    PlusSession(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.a = i;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = plusCommonExtras;
    }

    public PlusSession(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.a = 1;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str2;
        this.g = str3;
        this.h = null;
        this.i = null;
        this.j = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlusSession) {
            PlusSession plusSession = (PlusSession) obj;
            if (this.a == plusSession.a && at.a(this.b, plusSession.b) && Arrays.equals(this.c, plusSession.c) && Arrays.equals(this.d, plusSession.d) && Arrays.equals(this.e, plusSession.e) && at.a(this.f, plusSession.f) && at.a(this.g, plusSession.g) && at.a(this.h, plusSession.h) && at.a(this.i, plusSession.i) && at.a(this.j, plusSession.j)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j});
    }

    public String toString() {
        return at.a(this).a("versionCode", Integer.valueOf(this.a)).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("extra", this.j.toString()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel, i);
    }
}
