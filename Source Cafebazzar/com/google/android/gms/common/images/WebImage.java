package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class WebImage implements SafeParcelable {
    public static final Creator CREATOR = new h();
    final int a;
    final Uri b;
    final int c;
    final int d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.a = i;
        this.b = uri;
        this.c = i2;
        this.d = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || !(obj instanceof WebImage)) {
                return false;
            }
            WebImage webImage = (WebImage) obj;
            if (!at.a(this.b, webImage.b) || this.c != webImage.c) {
                return false;
            }
            if (this.d != webImage.d) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
