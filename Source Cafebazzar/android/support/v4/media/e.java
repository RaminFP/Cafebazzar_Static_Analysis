package android.support.v4.media;

import android.media.MediaDescription;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator {
    e() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaDescriptionCompat[i];
    }
}
