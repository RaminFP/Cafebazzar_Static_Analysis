package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlusCommonExtras implements SafeParcelable {
    public static final h CREATOR = new h();
    final int a;
    String b;
    String c;

    public PlusCommonExtras() {
        this.a = 1;
        this.b = "";
        this.c = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlusCommonExtras) {
            PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
            if (this.a == plusCommonExtras.a && at.a(this.b, plusCommonExtras.b) && at.a(this.c, plusCommonExtras.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c});
    }

    public String toString() {
        return at.a(this).a("versionCode", Integer.valueOf(this.a)).a("Gpsrc", this.b).a("ClientCallingPackage", this.c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel);
    }
}
