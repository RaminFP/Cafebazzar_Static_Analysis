package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator CREATOR = new a();
    final int a;
    List b;

    UserAddressRequest() {
        this.a = 1;
    }

    UserAddressRequest(int i, List list) {
        this.a = i;
        this.b = list;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
