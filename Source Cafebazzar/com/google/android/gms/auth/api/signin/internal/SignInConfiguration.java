package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator CREATOR = new b();
    final int a;
    final String b;
    String c;
    EmailSignInOptions d;
    GoogleSignInOptions e;
    FacebookSignInOptions f;
    String g;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, FacebookSignInOptions facebookSignInOptions, String str3) {
        this.a = i;
        this.b = av.a(str);
        this.c = str2;
        this.d = emailSignInOptions;
        this.e = googleSignInOptions;
        this.f = facebookSignInOptions;
        this.g = str3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.b.equals(signInConfiguration.b)) {
                return false;
            }
            if (TextUtils.isEmpty(this.c)) {
                if (!TextUtils.isEmpty(signInConfiguration.c)) {
                    return false;
                }
            } else if (!this.c.equals(signInConfiguration.c)) {
                return false;
            }
            if (TextUtils.isEmpty(this.g)) {
                if (!TextUtils.isEmpty(signInConfiguration.g)) {
                    return false;
                }
            } else if (!this.g.equals(signInConfiguration.g)) {
                return false;
            }
            if (this.d == null) {
                if (signInConfiguration.d != null) {
                    return false;
                }
            } else if (!this.d.equals(signInConfiguration.d)) {
                return false;
            }
            if (this.f == null) {
                if (signInConfiguration.f != null) {
                    return false;
                }
            } else if (!this.f.equals(signInConfiguration.f)) {
                return false;
            }
            if (this.e == null) {
                if (signInConfiguration.e != null) {
                    return false;
                }
            } else if (!this.e.equals(signInConfiguration.e)) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final int hashCode() {
        return new a().a(this.b).a(this.c).a(this.g).a(this.d).a(this.e).a(this.f).b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
