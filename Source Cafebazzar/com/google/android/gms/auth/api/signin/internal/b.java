package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b implements Creator {
    static void a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, signInConfiguration.a);
        c.a(parcel, 2, signInConfiguration.b, false);
        c.a(parcel, 3, signInConfiguration.c, false);
        c.a(parcel, 4, signInConfiguration.d, i, false);
        c.a(parcel, 5, signInConfiguration.e, i, false);
        c.a(parcel, 6, signInConfiguration.f, i, false);
        c.a(parcel, 7, signInConfiguration.g, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        String str2 = null;
        EmailSignInOptions emailSignInOptions = null;
        GoogleSignInOptions googleSignInOptions = null;
        FacebookSignInOptions facebookSignInOptions = null;
        String str3 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    emailSignInOptions = (EmailSignInOptions) a.a(parcel, readInt, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) a.a(parcel, readInt, GoogleSignInOptions.CREATOR);
                    break;
                case 6:
                    facebookSignInOptions = (FacebookSignInOptions) a.a(parcel, readInt, FacebookSignInOptions.CREATOR);
                    break;
                case 7:
                    str3 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new SignInConfiguration(i, str, str2, emailSignInOptions, googleSignInOptions, facebookSignInOptions, str3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
