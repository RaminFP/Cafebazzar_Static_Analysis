package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public final class f implements Creator {
    static void a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = c.a(parcel, 20293);
        c.b(parcel, 1, googleSignInOptions.e);
        c.b(parcel, 2, googleSignInOptions.a(), false);
        c.a(parcel, 3, googleSignInOptions.f, i, false);
        c.a(parcel, 4, googleSignInOptions.g);
        c.a(parcel, 5, googleSignInOptions.h);
        c.a(parcel, 6, googleSignInOptions.i);
        c.a(parcel, 7, googleSignInOptions.j, false);
        c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int a = a.a(parcel);
        Account account = null;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.d(parcel, readInt);
                    break;
                case 2:
                    arrayList = a.c(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) a.a(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = a.c(parcel, readInt);
                    break;
                case 5:
                    z2 = a.c(parcel, readInt);
                    break;
                case 6:
                    z3 = a.c(parcel, readInt);
                    break;
                case 7:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
