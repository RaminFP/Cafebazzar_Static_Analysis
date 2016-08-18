package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator CREATOR = new l();
    final int a;
    final Account b;
    final Scope[] c;
    final String d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.a = i;
        this.b = account;
        this.c = scopeArr;
        this.d = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        l.a(this, parcel, i);
    }
}
