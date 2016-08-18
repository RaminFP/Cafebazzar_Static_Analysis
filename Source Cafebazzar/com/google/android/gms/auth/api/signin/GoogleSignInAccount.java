package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.a.bz;
import com.google.android.gms.a.ca;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator CREATOR = new e();
    public static bz a = ca.c();
    private static Comparator l = new a();
    final int b;
    String c;
    String d;
    String e;
    String f;
    Uri g;
    String h;
    long i;
    String j;
    List k;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j;
        this.j = str6;
        this.k = list;
    }

    public static GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Object hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString("email", null);
        String optString5 = jSONObject.optString("displayName", null);
        Long valueOf = Long.valueOf(parseLong);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(2, optString2, optString3, optString4, optString5, parse, null, (valueOf == null ? Long.valueOf(a.a() / 1000) : valueOf).longValue(), av.a(jSONObject.getString("obfuscatedIdentifier")), new ArrayList((Collection) av.a(hashSet)));
        googleSignInAccount.h = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.c != null) {
                jSONObject.put("id", this.c);
            }
            if (this.d != null) {
                jSONObject.put("tokenId", this.d);
            }
            if (this.e != null) {
                jSONObject.put("email", this.e);
            }
            if (this.f != null) {
                jSONObject.put("displayName", this.f);
            }
            if (this.g != null) {
                jSONObject.put("photoUrl", this.g.toString());
            }
            if (this.h != null) {
                jSONObject.put("serverAuthCode", this.h);
            }
            jSONObject.put("expirationTime", this.i);
            jSONObject.put("obfuscatedIdentifier", this.j);
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.k, l);
            for (Scope scope : this.k) {
                jSONArray.put(scope.b);
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).a().toString().equals(a().toString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
