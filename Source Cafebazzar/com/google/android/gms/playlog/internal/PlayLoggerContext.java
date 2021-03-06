package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlayLoggerContext implements SafeParcelable {
    public static final b CREATOR = new b();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final int j;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.h = str4;
        this.i = z2;
        this.j = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PlayLoggerContext)) {
                return false;
            }
            PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
            if (this.a != playLoggerContext.a || !this.b.equals(playLoggerContext.b) || this.c != playLoggerContext.c || this.d != playLoggerContext.d || !at.a(this.h, playLoggerContext.h) || !at.a(this.e, playLoggerContext.e) || !at.a(this.f, playLoggerContext.f) || this.g != playLoggerContext.g || this.i != playLoggerContext.i) {
                return false;
            }
            if (this.j != playLoggerContext.j) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d), this.h, this.e, this.f, Boolean.valueOf(this.g), Boolean.valueOf(this.i), Integer.valueOf(this.j)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.a).append(',');
        stringBuilder.append("package=").append(this.b).append(',');
        stringBuilder.append("packageVersionCode=").append(this.c).append(',');
        stringBuilder.append("logSource=").append(this.d).append(',');
        stringBuilder.append("logSourceName=").append(this.h).append(',');
        stringBuilder.append("uploadAccount=").append(this.e).append(',');
        stringBuilder.append("loggingId=").append(this.f).append(',');
        stringBuilder.append("logAndroidId=").append(this.g).append(',');
        stringBuilder.append("isAnonymous=").append(this.i).append(',');
        stringBuilder.append("qosTier=").append(this.j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
