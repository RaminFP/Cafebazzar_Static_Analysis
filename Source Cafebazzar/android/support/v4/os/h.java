package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h implements Creator {
    h() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResultReceiver(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResultReceiver[i];
    }
}
