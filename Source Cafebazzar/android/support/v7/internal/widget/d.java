package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator {
    d() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
