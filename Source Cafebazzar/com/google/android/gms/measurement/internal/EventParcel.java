package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel implements SafeParcelable {
    public static final r CREATOR = new r();
    public final int a;
    public final String b;
    public final EventParams c;
    public final String d;
    public final long e;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.a = i;
        this.b = str;
        this.c = eventParams;
        this.d = str2;
        this.e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.a = 1;
        this.b = str;
        this.c = eventParams;
        this.d = str2;
        this.e = j;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "origin=" + this.d + ",name=" + this.b + ",params=" + this.c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        r.a(this, parcel, i);
    }
}
