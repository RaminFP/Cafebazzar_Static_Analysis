package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator {
    d() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ResultReceiverWrapper(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ResultReceiverWrapper[i];
    }
}
