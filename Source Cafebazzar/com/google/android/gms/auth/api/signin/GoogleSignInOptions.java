package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class GoogleSignInOptions implements SafeParcelable {
    public static final Creator CREATOR = new f();
    public static final Scope a = new Scope("profile");
    public static final Scope b = new Scope("email");
    public static final Scope c = new Scope("openid");
    public static final GoogleSignInOptions d;
    final int e;
    Account f;
    boolean g;
    final boolean h;
    final boolean i;
    String j;
    private final ArrayList k;

    static {
        b bVar = new b();
        bVar.a.add(c);
        bVar.a.add(a);
        d = new GoogleSignInOptions(bVar.a, bVar.f, bVar.d, bVar.b, bVar.c, bVar.e);
    }

    GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str) {
        this.e = i;
        this.k = arrayList;
        this.f = account;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = str;
    }

    private GoogleSignInOptions(Set set, Account account, boolean z, boolean z2, boolean z3, String str) {
        this(1, new ArrayList(set), account, z, z2, z3, str);
    }

    public final ArrayList a() {
        return new ArrayList(this.k);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.k.size() != googleSignInOptions.a().size() || !this.k.containsAll(googleSignInOptions.a())) {
                return false;
            }
            if (this.f == null) {
                if (googleSignInOptions.f != null) {
                    return false;
                }
            } else if (!this.f.equals(googleSignInOptions.f)) {
                return false;
            }
            if (TextUtils.isEmpty(this.j)) {
                if (!TextUtils.isEmpty(googleSignInOptions.j)) {
                    return false;
                }
            } else if (!this.j.equals(googleSignInOptions.j)) {
                return false;
            }
            return this.i == googleSignInOptions.i && this.g == googleSignInOptions.g && this.h == googleSignInOptions.h;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).b);
        }
        Collections.sort(arrayList);
        return new a().a(arrayList).a(this.f).a(this.j).a(this.i).a(this.g).a(this.h).b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
