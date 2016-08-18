package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.a.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements a {
    private static final HashMap A;
    public static final a CREATOR = new a();
    final Set a;
    final int b;
    String c;
    AgeRangeEntity d;
    String e;
    String f;
    int g;
    CoverEntity h;
    String i;
    String j;
    int k;
    String l;
    ImageEntity m;
    boolean n;
    String o;
    NameEntity p;
    String q;
    int r;
    List s;
    List t;
    int u;
    int v;
    String w;
    String x;
    List y;
    boolean z;

    public final class AgeRangeEntity extends FastSafeParcelableJsonResponse {
        public static final b CREATOR = new b();
        private static final HashMap e;
        final Set a;
        final int b;
        int c;
        int d;

        static {
            HashMap hashMap = new HashMap();
            e = hashMap;
            hashMap.put("max", Field.a("max", 2));
            e.put("min", Field.a("min", 3));
        }

        public AgeRangeEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        AgeRangeEntity(Set set, int i, int i2, int i3) {
            this.a = set;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        public final /* synthetic */ Map a() {
            return e;
        }

        protected final boolean a(Field field) {
            return this.a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(Field field) {
            switch (field.f()) {
                case 2:
                    return Integer.valueOf(this.c);
                case 3:
                    return Integer.valueOf(this.d);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (Field field : e.values()) {
                if (a(field)) {
                    if (!ageRangeEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(ageRangeEntity.b(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : e.values()) {
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
            b.a(this, parcel);
        }
    }

    public final class CoverEntity extends FastSafeParcelableJsonResponse {
        public static final c CREATOR = new c();
        private static final HashMap f;
        final Set a;
        final int b;
        CoverInfoEntity c;
        CoverPhotoEntity d;
        int e;

        public final class CoverInfoEntity extends FastSafeParcelableJsonResponse {
            public static final d CREATOR = new d();
            private static final HashMap e;
            final Set a;
            final int b;
            int c;
            int d;

            static {
                HashMap hashMap = new HashMap();
                e = hashMap;
                hashMap.put("leftImageOffset", Field.a("leftImageOffset", 2));
                e.put("topImageOffset", Field.a("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.b = 1;
                this.a = new HashSet();
            }

            CoverInfoEntity(Set set, int i, int i2, int i3) {
                this.a = set;
                this.b = i;
                this.c = i2;
                this.d = i3;
            }

            public final /* synthetic */ Map a() {
                return e;
            }

            protected final boolean a(Field field) {
                return this.a.contains(Integer.valueOf(field.f()));
            }

            protected final Object b(Field field) {
                switch (field.f()) {
                    case 2:
                        return Integer.valueOf(this.c);
                    case 3:
                        return Integer.valueOf(this.d);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
                }
            }

            public final int describeContents() {
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (Field field : e.values()) {
                    if (a(field)) {
                        if (!coverInfoEntity.a(field)) {
                            return false;
                        }
                        if (!b(field).equals(coverInfoEntity.b(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            public final int hashCode() {
                int i = 0;
                for (Field field : e.values()) {
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
                d.a(this, parcel);
            }
        }

        public final class CoverPhotoEntity extends FastSafeParcelableJsonResponse {
            public static final e CREATOR = new e();
            private static final HashMap f;
            final Set a;
            final int b;
            int c;
            String d;
            int e;

            static {
                HashMap hashMap = new HashMap();
                f = hashMap;
                hashMap.put("height", Field.a("height", 2));
                f.put("url", Field.d("url", 3));
                f.put("width", Field.a("width", 4));
            }

            public CoverPhotoEntity() {
                this.b = 1;
                this.a = new HashSet();
            }

            CoverPhotoEntity(Set set, int i, int i2, String str, int i3) {
                this.a = set;
                this.b = i;
                this.c = i2;
                this.d = str;
                this.e = i3;
            }

            public final /* synthetic */ Map a() {
                return f;
            }

            protected final boolean a(Field field) {
                return this.a.contains(Integer.valueOf(field.f()));
            }

            protected final Object b(Field field) {
                switch (field.f()) {
                    case 2:
                        return Integer.valueOf(this.c);
                    case 3:
                        return this.d;
                    case 4:
                        return Integer.valueOf(this.e);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
                }
            }

            public final int describeContents() {
                return 0;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (Field field : f.values()) {
                    if (a(field)) {
                        if (!coverPhotoEntity.a(field)) {
                            return false;
                        }
                        if (!b(field).equals(coverPhotoEntity.b(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            public final int hashCode() {
                int i = 0;
                for (Field field : f.values()) {
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
                e.a(this, parcel);
            }
        }

        static {
            HashMap hashMap = new HashMap();
            f = hashMap;
            hashMap.put("coverInfo", Field.a("coverInfo", 2, CoverInfoEntity.class));
            f.put("coverPhoto", Field.a("coverPhoto", 3, CoverPhotoEntity.class));
            f.put("layout", Field.a("layout", 4, new StringToIntConverter().a("banner", 0), false));
        }

        public CoverEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        CoverEntity(Set set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.a = set;
            this.b = i;
            this.c = coverInfoEntity;
            this.d = coverPhotoEntity;
            this.e = i2;
        }

        public final /* synthetic */ Map a() {
            return f;
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
                    return Integer.valueOf(this.e);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (Field field : f.values()) {
                if (a(field)) {
                    if (!coverEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(coverEntity.b(field))) {
                        return false;
                    }
                } else if (coverEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : f.values()) {
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
            c.a(this, parcel, i);
        }
    }

    public final class ImageEntity extends FastSafeParcelableJsonResponse {
        public static final f CREATOR = new f();
        private static final HashMap d;
        final Set a;
        final int b;
        String c;

        static {
            HashMap hashMap = new HashMap();
            d = hashMap;
            hashMap.put("url", Field.d("url", 2));
        }

        public ImageEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        ImageEntity(Set set, int i, String str) {
            this.a = set;
            this.b = i;
            this.c = str;
        }

        public final /* synthetic */ Map a() {
            return d;
        }

        protected final boolean a(Field field) {
            return this.a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(Field field) {
            switch (field.f()) {
                case 2:
                    return this.c;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (Field field : d.values()) {
                if (a(field)) {
                    if (!imageEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(imageEntity.b(field))) {
                        return false;
                    }
                } else if (imageEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : d.values()) {
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
            f.a(this, parcel);
        }
    }

    public final class NameEntity extends FastSafeParcelableJsonResponse {
        public static final g CREATOR = new g();
        private static final HashMap i;
        final Set a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;

        static {
            HashMap hashMap = new HashMap();
            i = hashMap;
            hashMap.put("familyName", Field.d("familyName", 2));
            i.put("formatted", Field.d("formatted", 3));
            i.put("givenName", Field.d("givenName", 4));
            i.put("honorificPrefix", Field.d("honorificPrefix", 5));
            i.put("honorificSuffix", Field.d("honorificSuffix", 6));
            i.put("middleName", Field.d("middleName", 7));
        }

        public NameEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        NameEntity(Set set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = set;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
        }

        public final /* synthetic */ Map a() {
            return i;
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
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (Field field : i.values()) {
                if (a(field)) {
                    if (!nameEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(nameEntity.b(field))) {
                        return false;
                    }
                } else if (nameEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : i.values()) {
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
            g.a(this, parcel);
        }
    }

    public final class OrganizationsEntity extends FastSafeParcelableJsonResponse {
        public static final h CREATOR = new h();
        private static final HashMap l;
        final Set a;
        final int b;
        String c;
        String d;
        String e;
        String f;
        String g;
        boolean h;
        String i;
        String j;
        int k;

        static {
            HashMap hashMap = new HashMap();
            l = hashMap;
            hashMap.put("department", Field.d("department", 2));
            l.put("description", Field.d("description", 3));
            l.put("endDate", Field.d("endDate", 4));
            l.put("location", Field.d("location", 5));
            l.put("name", Field.d("name", 6));
            l.put("primary", Field.c("primary", 7));
            l.put("startDate", Field.d("startDate", 8));
            l.put("title", Field.d("title", 9));
            l.put("type", Field.a("type", 10, new StringToIntConverter().a("work", 0).a("school", 1), false));
        }

        public OrganizationsEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        OrganizationsEntity(Set set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.a = set;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = z;
            this.i = str6;
            this.j = str7;
            this.k = i2;
        }

        public final /* synthetic */ Map a() {
            return l;
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
                    return Boolean.valueOf(this.h);
                case 8:
                    return this.i;
                case 9:
                    return this.j;
                case 10:
                    return Integer.valueOf(this.k);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (Field field : l.values()) {
                if (a(field)) {
                    if (!organizationsEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(organizationsEntity.b(field))) {
                        return false;
                    }
                } else if (organizationsEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : l.values()) {
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
            h.a(this, parcel);
        }
    }

    public final class PlacesLivedEntity extends FastSafeParcelableJsonResponse {
        public static final i CREATOR = new i();
        private static final HashMap e;
        final Set a;
        final int b;
        boolean c;
        String d;

        static {
            HashMap hashMap = new HashMap();
            e = hashMap;
            hashMap.put("primary", Field.c("primary", 2));
            e.put("value", Field.d("value", 3));
        }

        public PlacesLivedEntity() {
            this.b = 1;
            this.a = new HashSet();
        }

        PlacesLivedEntity(Set set, int i, boolean z, String str) {
            this.a = set;
            this.b = i;
            this.c = z;
            this.d = str;
        }

        public final /* synthetic */ Map a() {
            return e;
        }

        protected final boolean a(Field field) {
            return this.a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(Field field) {
            switch (field.f()) {
                case 2:
                    return Boolean.valueOf(this.c);
                case 3:
                    return this.d;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (Field field : e.values()) {
                if (a(field)) {
                    if (!placesLivedEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(placesLivedEntity.b(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : e.values()) {
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
            i.a(this, parcel);
        }
    }

    public final class UrlsEntity extends FastSafeParcelableJsonResponse {
        public static final j CREATOR = new j();
        private static final HashMap f;
        final Set a;
        final int b;
        String c;
        int d;
        String e;
        private final int g;

        static {
            HashMap hashMap = new HashMap();
            f = hashMap;
            hashMap.put("label", Field.d("label", 5));
            f.put("type", Field.a("type", 6, new StringToIntConverter().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
            f.put("value", Field.d("value", 4));
        }

        public UrlsEntity() {
            this.g = 4;
            this.b = 1;
            this.a = new HashSet();
        }

        UrlsEntity(Set set, int i, String str, int i2, String str2) {
            this.g = 4;
            this.a = set;
            this.b = i;
            this.c = str;
            this.d = i2;
            this.e = str2;
        }

        @Deprecated
        public static int d() {
            return 4;
        }

        public final /* synthetic */ Map a() {
            return f;
        }

        protected final boolean a(Field field) {
            return this.a.contains(Integer.valueOf(field.f()));
        }

        protected final Object b(Field field) {
            switch (field.f()) {
                case 4:
                    return this.e;
                case 5:
                    return this.c;
                case 6:
                    return Integer.valueOf(this.d);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (Field field : f.values()) {
                if (a(field)) {
                    if (!urlsEntity.a(field)) {
                        return false;
                    }
                    if (!b(field).equals(urlsEntity.b(field))) {
                        return false;
                    }
                } else if (urlsEntity.a(field)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            for (Field field : f.values()) {
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
            j.a(this, parcel);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        A = hashMap;
        hashMap.put("aboutMe", Field.d("aboutMe", 2));
        A.put("ageRange", Field.a("ageRange", 3, AgeRangeEntity.class));
        A.put("birthday", Field.d("birthday", 4));
        A.put("braggingRights", Field.d("braggingRights", 5));
        A.put("circledByCount", Field.a("circledByCount", 6));
        A.put("cover", Field.a("cover", 7, CoverEntity.class));
        A.put("currentLocation", Field.d("currentLocation", 8));
        A.put("displayName", Field.d("displayName", 9));
        A.put("gender", Field.a("gender", 12, new StringToIntConverter().a("male", 0).a("female", 1).a("other", 2), false));
        A.put("id", Field.d("id", 14));
        A.put("image", Field.a("image", 15, ImageEntity.class));
        A.put("isPlusUser", Field.c("isPlusUser", 16));
        A.put("language", Field.d("language", 18));
        A.put("name", Field.a("name", 19, NameEntity.class));
        A.put("nickname", Field.d("nickname", 20));
        A.put("objectType", Field.a("objectType", 21, new StringToIntConverter().a("person", 0).a("page", 1), false));
        A.put("organizations", Field.b("organizations", 22, OrganizationsEntity.class));
        A.put("placesLived", Field.b("placesLived", 23, PlacesLivedEntity.class));
        A.put("plusOneCount", Field.a("plusOneCount", 24));
        A.put("relationshipStatus", Field.a("relationshipStatus", 25, new StringToIntConverter().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
        A.put("tagline", Field.d("tagline", 26));
        A.put("url", Field.d("url", 27));
        A.put("urls", Field.b("urls", 28, UrlsEntity.class));
        A.put("verified", Field.c("verified", 29));
    }

    public PersonEntity() {
        this.b = 1;
        this.a = new HashSet();
    }

    PersonEntity(Set set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List list, List list2, int i5, int i6, String str9, String str10, List list3, boolean z2) {
        this.a = set;
        this.b = i;
        this.c = str;
        this.d = ageRangeEntity;
        this.e = str2;
        this.f = str3;
        this.g = i2;
        this.h = coverEntity;
        this.i = str4;
        this.j = str5;
        this.k = i3;
        this.l = str6;
        this.m = imageEntity;
        this.n = z;
        this.o = str7;
        this.p = nameEntity;
        this.q = str8;
        this.r = i4;
        this.s = list;
        this.t = list2;
        this.u = i5;
        this.v = i6;
        this.w = str9;
        this.x = str10;
        this.y = list3;
        this.z = z2;
    }

    public static PersonEntity a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity a = a.a(obtain);
        obtain.recycle();
        return a;
    }

    public final /* synthetic */ Map a() {
        return A;
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
                return Integer.valueOf(this.g);
            case 7:
                return this.h;
            case 8:
                return this.i;
            case 9:
                return this.j;
            case 12:
                return Integer.valueOf(this.k);
            case 14:
                return this.l;
            case 15:
                return this.m;
            case 16:
                return Boolean.valueOf(this.n);
            case 18:
                return this.o;
            case 19:
                return this.p;
            case 20:
                return this.q;
            case 21:
                return Integer.valueOf(this.r);
            case 22:
                return this.s;
            case 23:
                return this.t;
            case 24:
                return Integer.valueOf(this.u);
            case 25:
                return Integer.valueOf(this.v);
            case 26:
                return this.w;
            case 27:
                return this.x;
            case 28:
                return this.y;
            case 29:
                return Boolean.valueOf(this.z);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (Field field : A.values()) {
            if (a(field)) {
                if (!personEntity.a(field)) {
                    return false;
                }
                if (!b(field).equals(personEntity.b(field))) {
                    return false;
                }
            } else if (personEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Field field : A.values()) {
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
