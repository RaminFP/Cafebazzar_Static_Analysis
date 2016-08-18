package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final a CREATOR = new a();
    public final int a;
    public final long b;
    public final long c;
    public final String d;
    public final byte[] e;
    public final Bundle f;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = bArr;
        this.f = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.d).append(",");
        stringBuilder.append("eventTime=").append(this.b).append(",");
        stringBuilder.append("eventUptime=").append(this.c).append(",");
        if (!(this.f == null || this.f.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.f.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.f.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
