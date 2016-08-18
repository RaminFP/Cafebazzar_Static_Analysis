package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class g implements ClassLoaderCreator {
    private final f a;

    public g(f fVar) {
        this.a = fVar;
    }

    public final Object createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public final Object[] newArray(int i) {
        return this.a.a(i);
    }
}
