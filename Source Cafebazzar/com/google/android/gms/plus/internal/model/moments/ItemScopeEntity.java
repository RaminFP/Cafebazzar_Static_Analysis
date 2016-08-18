package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse {
    public static final a CREATOR = new a();
    private static final HashMap ae;
    String A;
    String B;
    String C;
    ItemScopeEntity D;
    String E;
    String F;
    String G;
    String H;
    ItemScopeEntity I;
    double J;
    ItemScopeEntity K;
    double L;
    String M;
    ItemScopeEntity N;
    List O;
    String P;
    String Q;
    String R;
    String S;
    ItemScopeEntity T;
    String U;
    String V;
    String W;
    ItemScopeEntity X;
    String Y;
    String Z;
    final Set a;
    String aa;
    String ab;
    String ac;
    String ad;
    final int b;
    ItemScopeEntity c;
    List d;
    ItemScopeEntity e;
    String f;
    String g;
    String h;
    List i;
    int j;
    List k;
    ItemScopeEntity l;
    List m;
    String n;
    String o;
    ItemScopeEntity p;
    String q;
    String r;
    String s;
    List t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;

    static {
        HashMap hashMap = new HashMap();
        ae = hashMap;
        hashMap.put("about", Field.a("about", 2, ItemScopeEntity.class));
        ae.put("additionalName", Field.e("additionalName", 3));
        ae.put("address", Field.a("address", 4, ItemScopeEntity.class));
        ae.put("addressCountry", Field.d("addressCountry", 5));
        ae.put("addressLocality", Field.d("addressLocality", 6));
        ae.put("addressRegion", Field.d("addressRegion", 7));
        ae.put("associated_media", Field.b("associated_media", 8, ItemScopeEntity.class));
        ae.put("attendeeCount", Field.a("attendeeCount", 9));
        ae.put("attendees", Field.b("attendees", 10, ItemScopeEntity.class));
        ae.put("audio", Field.a("audio", 11, ItemScopeEntity.class));
        ae.put("author", Field.b("author", 12, ItemScopeEntity.class));
        ae.put("bestRating", Field.d("bestRating", 13));
        ae.put("birthDate", Field.d("birthDate", 14));
        ae.put("byArtist", Field.a("byArtist", 15, ItemScopeEntity.class));
        ae.put("caption", Field.d("caption", 16));
        ae.put("contentSize", Field.d("contentSize", 17));
        ae.put("contentUrl", Field.d("contentUrl", 18));
        ae.put("contributor", Field.b("contributor", 19, ItemScopeEntity.class));
        ae.put("dateCreated", Field.d("dateCreated", 20));
        ae.put("dateModified", Field.d("dateModified", 21));
        ae.put("datePublished", Field.d("datePublished", 22));
        ae.put("description", Field.d("description", 23));
        ae.put("duration", Field.d("duration", 24));
        ae.put("embedUrl", Field.d("embedUrl", 25));
        ae.put("endDate", Field.d("endDate", 26));
        ae.put("familyName", Field.d("familyName", 27));
        ae.put("gender", Field.d("gender", 28));
        ae.put("geo", Field.a("geo", 29, ItemScopeEntity.class));
        ae.put("givenName", Field.d("givenName", 30));
        ae.put("height", Field.d("height", 31));
        ae.put("id", Field.d("id", 32));
        ae.put("image", Field.d("image", 33));
        ae.put("inAlbum", Field.a("inAlbum", 34, ItemScopeEntity.class));
        ae.put("latitude", Field.b("latitude", 36));
        ae.put("location", Field.a("location", 37, ItemScopeEntity.class));
        ae.put("longitude", Field.b("longitude", 38));
        ae.put("name", Field.d("name", 39));
        ae.put("partOfTVSeries", Field.a("partOfTVSeries", 40, ItemScopeEntity.class));
        ae.put("performers", Field.b("performers", 41, ItemScopeEntity.class));
        ae.put("playerType", Field.d("playerType", 42));
        ae.put("postOfficeBoxNumber", Field.d("postOfficeBoxNumber", 43));
        ae.put("postalCode", Field.d("postalCode", 44));
        ae.put("ratingValue", Field.d("ratingValue", 45));
        ae.put("reviewRating", Field.a("reviewRating", 46, ItemScopeEntity.class));
        ae.put("startDate", Field.d("startDate", 47));
        ae.put("streetAddress", Field.d("streetAddress", 48));
        ae.put("text", Field.d("text", 49));
        ae.put("thumbnail", Field.a("thumbnail", 50, ItemScopeEntity.class));
        ae.put("thumbnailUrl", Field.d("thumbnailUrl", 51));
        ae.put("tickerSymbol", Field.d("tickerSymbol", 52));
        ae.put("type", Field.d("type", 53));
        ae.put("url", Field.d("url", 54));
        ae.put("width", Field.d("width", 55));
        ae.put("worstRating", Field.d("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.b = 1;
        this.a = new HashSet();
    }

    ItemScopeEntity(Set set, int i, ItemScopeEntity itemScopeEntity, List list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List list2, int i2, List list3, ItemScopeEntity itemScopeEntity3, List list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.a = set;
        this.b = i;
        this.c = itemScopeEntity;
        this.d = list;
        this.e = itemScopeEntity2;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = list2;
        this.j = i2;
        this.k = list3;
        this.l = itemScopeEntity3;
        this.m = list4;
        this.n = str4;
        this.o = str5;
        this.p = itemScopeEntity4;
        this.q = str6;
        this.r = str7;
        this.s = str8;
        this.t = list5;
        this.u = str9;
        this.v = str10;
        this.w = str11;
        this.x = str12;
        this.y = str13;
        this.z = str14;
        this.A = str15;
        this.B = str16;
        this.C = str17;
        this.D = itemScopeEntity5;
        this.E = str18;
        this.F = str19;
        this.G = str20;
        this.H = str21;
        this.I = itemScopeEntity6;
        this.J = d;
        this.K = itemScopeEntity7;
        this.L = d2;
        this.M = str22;
        this.N = itemScopeEntity8;
        this.O = list6;
        this.P = str23;
        this.Q = str24;
        this.R = str25;
        this.S = str26;
        this.T = itemScopeEntity9;
        this.U = str27;
        this.V = str28;
        this.W = str29;
        this.X = itemScopeEntity10;
        this.Y = str30;
        this.Z = str31;
        this.aa = str32;
        this.ab = str33;
        this.ac = str34;
        this.ad = str35;
    }

    public final /* synthetic */ Map a() {
        return ae;
    }

    protected final boolean a(Field field) {
        return this.a.contains(Integer.valueOf(field.f()));
    }

    protected final Object b(Field field) {
        switch (field.f()) {
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return Integer.valueOf(this.j);
            case 10:
                return this.k;
            case 11:
                return this.l;
            case 12:
                return this.m;
            case 13:
                return this.n;
            case 14:
                return this.o;
            case 15:
                return this.p;
            case 16:
                return this.q;
            case 17:
                return this.r;
            case 18:
                return this.s;
            case 19:
                return this.t;
            case 20:
                return this.u;
            case 21:
                return this.v;
            case 22:
                return this.w;
            case 23:
                return this.x;
            case 24:
                return this.y;
            case 25:
                return this.z;
            case 26:
                return this.A;
            case 27:
                return this.B;
            case 28:
                return this.C;
            case 29:
                return this.D;
            case 30:
                return this.E;
            case 31:
                return this.F;
            case 32:
                return this.G;
            case 33:
                return this.H;
            case 34:
                return this.I;
            case 36:
                return Double.valueOf(this.J);
            case 37:
                return this.K;
            case 38:
                return Double.valueOf(this.L);
            case 39:
                return this.M;
            case 40:
                return this.N;
            case 41:
                return this.O;
            case 42:
                return this.P;
            case 43:
                return this.Q;
            case 44:
                return this.R;
            case 45:
                return this.S;
            case 46:
                return this.T;
            case 47:
                return this.U;
            case 48:
                return this.V;
            case 49:
                return this.W;
            case 50:
                return this.X;
            case 51:
                return this.Y;
            case 52:
                return this.Z;
            case 53:
                return this.aa;
            case 54:
                return this.ab;
            case 55:
                return this.ac;
            case 56:
                return this.ad;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : ae.values()) {
            if (a(field)) {
                if (!itemScopeEntity.a(field)) {
                    return false;
                }
                if (!b(field).equals(itemScopeEntity.b(field))) {
                    return false;
                }
            } else if (itemScopeEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Field field : ae.values()) {
            int hashCode;
            if (a(field)) {
                hashCode = b(field).hashCode() + (i + field.f());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
