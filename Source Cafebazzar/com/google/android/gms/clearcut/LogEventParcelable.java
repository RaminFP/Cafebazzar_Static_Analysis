package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.a.dt;
import com.google.android.gms.common.internal.as;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final e CREATOR = new e();
    public final int a;
    public PlayLoggerContext b;
    public byte[] c;
    public int[] d;
    public final dt e = null;
    public final c f = null;
    public final c g = null;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.a = i;
        this.b = playLoggerContext;
        this.c = bArr;
        this.d = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof LogEventParcelable)) {
                return false;
            }
            LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
            if (this.a != logEventParcelable.a || !at.a(this.b, logEventParcelable.b) || !Arrays.equals(this.c, logEventParcelable.c) || !Arrays.equals(this.d, logEventParcelable.d) || !at.a(this.e, logEventParcelable.e) || !at.a(this.f, logEventParcelable.f)) {
                return false;
            }
            if (!at.a(this.g, logEventParcelable.g)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c, this.d, this.e, this.f, this.g});
    }

    public String toString() {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append(this.c == null ? null : new String(this.c));
        stringBuilder.append(", ");
        if (this.d != null) {
            str = new as(", ").a(new StringBuilder(), Arrays.asList(new int[][]{this.d})).toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append(this.g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
