package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator CREATOR = new g();
    final int a;
    final long b;
    final String c;
    final int d;
    final int e;
    final String f;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.a = i;
        this.b = j;
        this.c = (String) av.a((Object) str);
        this.d = i2;
        this.e = i3;
        this.f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof AccountChangeEvent)) {
                return false;
            }
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.a != accountChangeEvent.a || this.b != accountChangeEvent.b || !at.a(this.c, accountChangeEvent.c) || this.d != accountChangeEvent.d || this.e != accountChangeEvent.e) {
                return false;
            }
            if (!at.a(this.f, accountChangeEvent.f)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), this.f});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.d) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.c + ", changeType = " + str + ", changeData = " + this.f + ", eventIndex = " + this.e + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
