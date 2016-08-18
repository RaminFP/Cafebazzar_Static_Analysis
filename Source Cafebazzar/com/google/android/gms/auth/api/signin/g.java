package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public final class g implements Creator {
    static void a(SignInAccount signInAccount, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, signInAccount.a);
        c.a(parcel, 2, signInAccount.b, false);
        c.a(parcel, 3, signInAccount.c, false);
        c.a(parcel, 4, signInAccount.d, false);
        c.a(parcel, 5, signInAccount.e, false);
        c.a(parcel, 6, signInAccount.f, i, false);
        c.a(parcel, 7, signInAccount.g, i, false);
        c.a(parcel, 8, signInAccount.h, false);
        c.a(parcel, 9, signInAccount.i, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        String str2 = "";
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Uri uri = null;
        GoogleSignInAccount googleSignInAccount = null;
        String str6 = null;
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
                    str3 = a.k(parcel, readInt);
                    break;
                case 4:
                    str4 = a.k(parcel, readInt);
                    break;
                case 5:
                    str5 = a.k(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) a.a(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = a.k(parcel, readInt);
                    break;
                case 9:
                    str6 = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new SignInAccount(i, str, str3, str4, str5, uri, googleSignInAccount, str2, str6);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
