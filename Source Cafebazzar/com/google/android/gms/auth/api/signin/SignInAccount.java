package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInAccount implements SafeParcelable {
    public static final Creator CREATOR = new g();
    final int a;
    String b;
    String c;
    String d;
    String e;
    Uri f;
    GoogleSignInAccount g;
    String h;
    String i;

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.a = i;
        this.d = av.a(str3, (Object) "Email cannot be empty.");
        this.e = str4;
        this.f = uri;
        this.b = str;
        this.c = str2;
        this.g = googleSignInAccount;
        this.h = av.a(str5);
        this.i = str6;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
