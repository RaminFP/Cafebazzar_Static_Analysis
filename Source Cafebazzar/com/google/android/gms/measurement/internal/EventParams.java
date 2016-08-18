package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable {
    public static final q CREATOR = new q();
    public final int a;
    final Bundle b;

    EventParams(int i, Bundle bundle) {
        this.a = i;
        this.b = bundle;
    }

    EventParams(Bundle bundle) {
        av.a((Object) bundle);
        this.b = bundle;
        this.a = 1;
    }

    public final Bundle a() {
        return new Bundle(this.b);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator iterator() {
        return new a(this);
    }

    public String toString() {
        return this.b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        q.a(this, parcel);
    }
}
