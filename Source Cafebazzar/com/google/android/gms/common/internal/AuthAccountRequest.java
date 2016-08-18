package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

public class AuthAccountRequest implements SafeParcelable {
    public static final Creator CREATOR = new f();
    final int a;
    final IBinder b;
    final Scope[] c;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr) {
        this.a = i;
        this.b = iBinder;
        this.c = scopeArr;
    }

    public AuthAccountRequest(ad adVar, Set set) {
        this(1, adVar.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
