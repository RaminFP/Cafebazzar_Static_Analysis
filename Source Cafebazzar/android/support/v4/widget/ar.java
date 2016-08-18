package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ar implements Creator {
    ar() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
