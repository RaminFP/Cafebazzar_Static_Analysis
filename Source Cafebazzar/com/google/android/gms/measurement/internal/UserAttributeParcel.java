package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserAttributeParcel implements SafeParcelable {
    public static final f CREATOR = new f();
    public final int a;
    public final String b;
    public final long c;
    public final Long d;
    public final Float e;
    public final String f;
    public final String g;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = l;
        this.e = f;
        this.f = str2;
        this.g = str3;
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        av.a(str);
        this.a = 1;
        this.b = str;
        this.c = j;
        this.g = str2;
        if (obj == null) {
            this.d = null;
            this.e = null;
            this.f = null;
        } else if (obj instanceof Long) {
            this.d = (Long) obj;
            this.e = null;
            this.f = null;
        } else if (obj instanceof Float) {
            this.d = null;
            this.e = (Float) obj;
            this.f = null;
        } else if (obj instanceof String) {
            this.d = null;
            this.e = null;
            this.f = (String) obj;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object a() {
        return this.d != null ? this.d : this.e != null ? this.e : this.f != null ? this.f : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel);
    }
}
