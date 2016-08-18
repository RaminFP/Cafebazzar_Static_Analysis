package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

final class a implements Creator {
    a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MediaItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaItem[i];
    }
}
