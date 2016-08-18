package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public final class d implements Creator {
    static void a(FacebookSignInOptions facebookSignInOptions, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, facebookSignInOptions.a);
        c.a(parcel, 2, facebookSignInOptions.b, i, false);
        c.a(parcel, 3, facebookSignInOptions.a(), false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = a.a(parcel);
        Intent intent = null;
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    intent = (Intent) a.a(parcel, readInt, Intent.CREATOR);
                    break;
                case 3:
                    arrayList = a.r(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new FacebookSignInOptions(i, intent, arrayList);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FacebookSignInOptions[i];
    }
}
