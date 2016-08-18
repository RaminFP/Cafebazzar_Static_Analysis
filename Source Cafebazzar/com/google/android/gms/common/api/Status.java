package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.at;
import com.google.android.gms.common.internal.au;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class Status implements r, SafeParcelable {
    public static final Creator CREATOR = new v();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    final int f;
    public final int g;
    public final String h;
    final PendingIntent i;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f = i;
        this.g = i2;
        this.h = str;
        this.i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final Status a() {
        return this;
    }

    public final boolean b() {
        return this.g <= 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            if (this.f == status.f && this.g == status.g && at.a(this.h, status.h) && at.a(this.i, status.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i});
    }

    public final String toString() {
        Object obj;
        au a = at.a(this);
        if (this.h == null) {
            int i = this.g;
            switch (i) {
                case -1:
                    obj = "SUCCESS_CACHE";
                    break;
                case 0:
                    obj = "SUCCESS";
                    break;
                case 1:
                    obj = "SERVICE_MISSING";
                    break;
                case 2:
                    obj = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    obj = "SERVICE_DISABLED";
                    break;
                case 4:
                    obj = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    obj = "INVALID_ACCOUNT";
                    break;
                case 6:
                    obj = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    obj = "NETWORK_ERROR";
                    break;
                case 8:
                    obj = "INTERNAL_ERROR";
                    break;
                case 9:
                    obj = "SERVICE_INVALID";
                    break;
                case 10:
                    obj = "DEVELOPER_ERROR";
                    break;
                case 11:
                    obj = "LICENSE_CHECK_FAILED";
                    break;
                case 13:
                    obj = "ERROR";
                    break;
                case 14:
                    obj = "INTERRUPTED";
                    break;
                case 15:
                    obj = "TIMEOUT";
                    break;
                case 16:
                    obj = "CANCELED";
                    break;
                case 17:
                    obj = "API_NOT_CONNECTED";
                    break;
                case 3000:
                    obj = "AUTH_API_INVALID_CREDENTIALS";
                    break;
                case 3001:
                    obj = "AUTH_API_ACCESS_FORBIDDEN";
                    break;
                case 3002:
                    obj = "AUTH_API_CLIENT_ERROR";
                    break;
                case 3003:
                    obj = "AUTH_API_SERVER_ERROR";
                    break;
                case 3004:
                    obj = "AUTH_TOKEN_ERROR";
                    break;
                case 3005:
                    obj = "AUTH_URL_RESOLUTION";
                    break;
                default:
                    obj = "unknown status code: " + i;
                    break;
            }
        }
        obj = this.h;
        return a.a("statusCode", obj).a("resolution", this.i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        v.a(this, parcel, i);
    }
}
