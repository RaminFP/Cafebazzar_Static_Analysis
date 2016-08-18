package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator {
    g() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PlaybackStateCompat[i];
    }
}
