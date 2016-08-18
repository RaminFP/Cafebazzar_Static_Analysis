package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class c implements Creator {
    static void a(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, signInButtonConfig.a);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 2, signInButtonConfig.b);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 3, signInButtonConfig.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, signInButtonConfig.d, i, false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int a = a.a(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.d(parcel, readInt);
                    break;
                case 2:
                    i2 = a.d(parcel, readInt);
                    break;
                case 3:
                    i = a.d(parcel, readInt);
                    break;
                case 4:
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == a) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new b("Overread allowed size end=" + a, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
