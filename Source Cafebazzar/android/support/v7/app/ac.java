package android.support.v7.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ac implements Creator {
    ac() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return SavedState.a(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
