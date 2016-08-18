package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

final class e implements Creator {
    e() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Token[i];
    }
}
