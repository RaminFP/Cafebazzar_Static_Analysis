package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;

public class FacebookSignInOptions implements SafeParcelable {
    public static final Creator CREATOR = new d();
    final int a;
    Intent b;
    private final ArrayList c;

    public FacebookSignInOptions() {
        this(1, null, new ArrayList());
    }

    FacebookSignInOptions(int i, Intent intent, ArrayList arrayList) {
        this.a = i;
        this.b = intent;
        this.c = arrayList;
    }

    public final ArrayList a() {
        return new ArrayList(this.c);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            FacebookSignInOptions facebookSignInOptions = (FacebookSignInOptions) obj;
            return this.c.size() == facebookSignInOptions.a().size() && this.c.containsAll(facebookSignInOptions.a());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        Collections.sort(this.c);
        return this.c.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
