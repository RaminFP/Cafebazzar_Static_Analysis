package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator CREATOR = new i();
    final int a;
    final List b;

    AccountChangeEventsResponse(int i, List list) {
        this.a = i;
        this.b = (List) av.a((Object) list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        i.a(this, parcel);
    }
}
