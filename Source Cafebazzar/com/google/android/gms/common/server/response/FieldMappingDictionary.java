package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final d CREATOR = new d();
    final int a;
    final HashMap b;
    final String c;
    private final ArrayList d = null;

    public class Entry implements SafeParcelable {
        public static final e CREATOR = new e();
        final int a;
        final String b;
        final ArrayList c;

        Entry(int i, String str, ArrayList arrayList) {
            this.a = i;
            this.b = str;
            this.c = arrayList;
        }

        Entry(String str, Map map) {
            this.a = 1;
            this.b = str;
            this.c = a(map);
        }

        private static ArrayList a(Map map) {
            if (map == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        final HashMap a() {
            HashMap hashMap = new HashMap();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.c.get(i);
                hashMap.put(fieldMapPair.b, fieldMapPair.c);
            }
            return hashMap;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            e.a(this, parcel);
        }
    }

    public class FieldMapPair implements SafeParcelable {
        public static final c CREATOR = new c();
        final int a;
        final String b;
        final Field c;

        FieldMapPair(int i, String str, Field field) {
            this.a = i;
            this.b = str;
            this.c = field;
        }

        FieldMapPair(String str, Field field) {
            this.a = 1;
            this.b = str;
            this.c = field;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            c.a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList arrayList, String str) {
        this.a = i;
        this.b = a(arrayList);
        this.c = (String) av.a((Object) str);
        a();
    }

    private static HashMap a(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.b, entry.a());
        }
        return hashMap;
    }

    private void a() {
        for (String str : this.b.keySet()) {
            Map map = (Map) this.b.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).j = this;
            }
        }
    }

    public final Map a(String str) {
        return (Map) this.b.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.b.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.b.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel);
    }
}
