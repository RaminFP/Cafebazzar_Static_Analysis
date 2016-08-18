package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse {
    public static final b CREATOR = new b();
    private static final HashMap h;
    final Set a;
    final int b;
    String c;
    ItemScopeEntity d;
    String e;
    ItemScopeEntity f;
    String g;

    static {
        HashMap hashMap = new HashMap();
        h = hashMap;
        hashMap.put("id", Field.d("id", 2));
        h.put("result", Field.a("result", 4, ItemScopeEntity.class));
        h.put("startDate", Field.d("startDate", 5));
        h.put("target", Field.a("target", 6, ItemScopeEntity.class));
        h.put("type", Field.d("type", 7));
    }

    public MomentEntity() {
        this.b = 1;
        this.a = new HashSet();
    }

    MomentEntity(Set set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.a = set;
        this.b = i;
        this.c = str;
        this.d = itemScopeEntity;
        this.e = str2;
        this.f = itemScopeEntity2;
        this.g = str3;
    }

    public final /* synthetic */ Map a() {
        return h;
    }

    protected final boolean a(Field field) {
        return this.a.contains(Integer.valueOf(field.f()));
    }

    protected final Object b(Field field) {
        switch (field.f()) {
            case 2:
                return this.c;
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
            case 7:
                return this.g;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.f());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : h.values()) {
            if (a(field)) {
                if (!momentEntity.a(field)) {
                    return false;
                }
                if (!b(field).equals(momentEntity.b(field))) {
                    return false;
                }
            } else if (momentEntity.a(field)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Field field : h.values()) {
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
        b.a(this, parcel, i);
    }
}
