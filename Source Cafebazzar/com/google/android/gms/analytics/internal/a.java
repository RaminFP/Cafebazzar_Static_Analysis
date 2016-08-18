package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator {
    a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Command(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Command[i];
    }
}
