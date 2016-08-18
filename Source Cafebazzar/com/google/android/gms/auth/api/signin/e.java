package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.List;

public final class e implements Creator {
    static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, googleSignInAccount.b);
        c.a(parcel, 2, googleSignInAccount.c, false);
        c.a(parcel, 3, googleSignInAccount.d, false);
        c.a(parcel, 4, googleSignInAccount.e, false);
        c.a(parcel, 5, googleSignInAccount.f, false);
        c.a(parcel, 6, googleSignInAccount.g, i, false);
        c.a(parcel, 7, googleSignInAccount.h, false);
        c.a(parcel, 8, googleSignInAccount.i);
        c.a(parcel, 9, googleSignInAccount.j, false);
        c.b(parcel, 10, googleSignInAccount.k, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int a = a.a(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        List list = null;
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
                    str3 = a.k(parcel, readInt);
                    break;
                case 5:
                    str4 = a.k(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = a.k(parcel, readInt);
                    break;
                case 8:
                    j = a.e(parcel, readInt);
                    break;
                case 9:
                    str6 = a.k(parcel, readInt);
                    break;
                case 10:
                    list = a.c(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
