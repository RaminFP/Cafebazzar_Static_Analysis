package com.viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j implements Creator {
    j() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
