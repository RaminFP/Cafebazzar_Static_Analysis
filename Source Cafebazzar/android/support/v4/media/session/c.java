package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;

final class c implements Creator {
    c() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new QueueItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new QueueItem[i];
    }
}
