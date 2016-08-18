package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator {
    final f a;

    public e(f fVar) {
        this.a = fVar;
    }

    public final Object createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final Object[] newArray(int i) {
        return this.a.a(i);
    }
}
