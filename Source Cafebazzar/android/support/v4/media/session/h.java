package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;

final class h implements Creator {
    h() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CustomAction(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CustomAction[i];
    }
}
