package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h implements Creator {
    h() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RatingCompat[i];
    }
}
