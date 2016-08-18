package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator CREATOR = new h();
    private final int a;
    private final float b;

    private RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public final int describeContents() {
        return this.a;
    }

    public final String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
