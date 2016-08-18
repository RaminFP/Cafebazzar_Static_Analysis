package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator {
    f() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelableVolumeInfo[i];
    }
}
