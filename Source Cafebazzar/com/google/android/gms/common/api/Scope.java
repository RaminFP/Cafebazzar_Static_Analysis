package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
    public static final Creator CREATOR = new u();
    final int a;
    public final String b;

    Scope(int i, String str) {
        av.a(str, (Object) "scopeUri must not be null or empty");
        this.a = i;
        this.b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.b.equals(((Scope) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel);
    }
}
