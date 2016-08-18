package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class c implements Creator {
    static void a(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, emailSignInOptions.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, emailSignInOptions.b, i, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, emailSignInOptions.c, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, emailSignInOptions.d, i, false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        String str = null;
        Uri uri = null;
        int i = 0;
        Uri uri2 = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    uri2 = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new EmailSignInOptions(i, uri, str, uri2);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new EmailSignInOptions[i];
    }
}
