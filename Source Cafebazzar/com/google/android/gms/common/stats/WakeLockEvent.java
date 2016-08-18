package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent extends g implements SafeParcelable {
    public static final Creator CREATOR = new h();
    final int a;
    final long b;
    int c;
    final String d;
    final int e;
    final List f;
    final String g;
    final long h;
    int i;
    final String j;
    final String k;
    final float l;
    final long m;
    private long n = -1;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.j = str3;
        this.e = i3;
        this.f = list;
        this.g = str2;
        this.h = j2;
        this.i = i4;
        this.k = str4;
        this.l = f;
        this.m = j3;
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return this.n;
    }

    public final String d() {
        return "\t" + this.d + "\t" + this.e + "\t" + (this.f == null ? "" : TextUtils.join(",", this.f)) + "\t" + this.i + "\t" + (this.j == null ? "" : this.j) + "\t" + (this.k == null ? "" : this.k) + "\t" + this.l;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel);
    }
}
