package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator CREATOR = new c();
    final int a;
    final boolean b;
    final List c;

    CheckServerAuthResult(int i, boolean z, List list) {
        this.a = i;
        this.b = z;
        this.c = list;
    }

    public CheckServerAuthResult(boolean z, Set set) {
        this(1, z, set == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(set)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
