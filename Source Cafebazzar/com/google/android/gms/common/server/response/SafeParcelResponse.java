package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.a.bv;
import com.google.android.gms.a.bw;
import com.google.android.gms.a.cc;
import com.google.android.gms.a.cd;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final f CREATOR = new f();
    final int a;
    final int b = 2;
    final FieldMappingDictionary c;
    private final Parcel d;
    private final String e;
    private int f;
    private int g;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.a = i;
        this.d = (Parcel) av.a((Object) parcel);
        this.c = fieldMappingDictionary;
        if (this.c == null) {
            this.e = null;
        } else {
            this.e = this.c.c;
        }
        this.f = 2;
    }

    private static HashMap a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static void a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(cc.a(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(bw.a((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(bw.b((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                cd.a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder stringBuilder, Field field, Parcel parcel, int i) {
        boolean[] zArr = null;
        int i2 = 0;
        int length;
        if (field.d()) {
            stringBuilder.append("[");
            int dataPosition;
            switch (field.c()) {
                case 0:
                    int[] o = a.o(parcel, i);
                    length = o.length;
                    while (i2 < length) {
                        if (i2 != 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(Integer.toString(o[i2]));
                        i2++;
                    }
                    break;
                case 1:
                    Object[] objArr;
                    length = a.a(parcel, i);
                    dataPosition = parcel.dataPosition();
                    if (length != 0) {
                        int readInt = parcel.readInt();
                        objArr = new BigInteger[readInt];
                        while (i2 < readInt) {
                            objArr[i2] = new BigInteger(parcel.createByteArray());
                            i2++;
                        }
                        parcel.setDataPosition(length + dataPosition);
                    }
                    bv.a(stringBuilder, objArr);
                    break;
                case 2:
                    long[] createLongArray;
                    length = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (length != 0) {
                        createLongArray = parcel.createLongArray();
                        parcel.setDataPosition(length + i2);
                    }
                    bv.a(stringBuilder, createLongArray);
                    break;
                case 3:
                    float[] createFloatArray;
                    length = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (length != 0) {
                        createFloatArray = parcel.createFloatArray();
                        parcel.setDataPosition(length + i2);
                    }
                    bv.a(stringBuilder, createFloatArray);
                    break;
                case 4:
                    double[] createDoubleArray;
                    length = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (length != 0) {
                        createDoubleArray = parcel.createDoubleArray();
                        parcel.setDataPosition(length + i2);
                    }
                    bv.a(stringBuilder, createDoubleArray);
                    break;
                case 5:
                    bv.a(stringBuilder, a.p(parcel, i));
                    break;
                case 6:
                    length = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (length != 0) {
                        zArr = parcel.createBooleanArray();
                        parcel.setDataPosition(length + i2);
                    }
                    bv.a(stringBuilder, zArr);
                    break;
                case 7:
                    bv.a(stringBuilder, a.q(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] t = a.t(parcel, i);
                    dataPosition = t.length;
                    for (int i3 = 0; i3 < dataPosition; i3++) {
                        if (i3 > 0) {
                            stringBuilder.append(",");
                        }
                        t[i3].setDataPosition(0);
                        a(stringBuilder, field.i(), t[i3]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.c()) {
            case 0:
                stringBuilder.append(a.d(parcel, i));
                return;
            case 1:
                stringBuilder.append(a.g(parcel, i));
                return;
            case 2:
                stringBuilder.append(a.e(parcel, i));
                return;
            case 3:
                stringBuilder.append(a.h(parcel, i));
                return;
            case 4:
                stringBuilder.append(a.i(parcel, i));
                return;
            case 5:
                stringBuilder.append(a.j(parcel, i));
                return;
            case 6:
                stringBuilder.append(a.c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(cc.a(a.k(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(bw.a(a.n(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(bw.b(a.n(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle m = a.m(parcel, i);
                Set<String> keySet = m.keySet();
                keySet.size();
                stringBuilder.append("{");
                length = 1;
                for (String str : keySet) {
                    if (length == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(cc.a(m.getString(str))).append("\"");
                    length = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel s = a.s(parcel, i);
                s.setDataPosition(0);
                a(stringBuilder, field.i(), s);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.b()) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                a(stringBuilder, field.a(), arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        a(stringBuilder, field.a(), obj);
    }

    private void a(StringBuilder stringBuilder, Map map, Parcel parcel) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            Entry entry2;
            hashMap.put(Integer.valueOf(((Field) entry2.getValue()).f()), entry2);
        }
        stringBuilder.append('{');
        int a = a.a(parcel);
        Object obj = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            entry2 = (Entry) hashMap.get(Integer.valueOf(65535 & readInt));
            if (entry2 != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                Field field = (Field) entry2.getValue();
                stringBuilder.append("\"").append(str).append("\":");
                if ((field.k != null ? 1 : null) != null) {
                    switch (field.c()) {
                        case 0:
                            a(stringBuilder, field, FastJsonResponse.a(field, Integer.valueOf(a.d(parcel, readInt))));
                            break;
                        case 1:
                            a(stringBuilder, field, FastJsonResponse.a(field, a.g(parcel, readInt)));
                            break;
                        case 2:
                            a(stringBuilder, field, FastJsonResponse.a(field, Long.valueOf(a.e(parcel, readInt))));
                            break;
                        case 3:
                            a(stringBuilder, field, FastJsonResponse.a(field, Float.valueOf(a.h(parcel, readInt))));
                            break;
                        case 4:
                            a(stringBuilder, field, FastJsonResponse.a(field, Double.valueOf(a.i(parcel, readInt))));
                            break;
                        case 5:
                            a(stringBuilder, field, FastJsonResponse.a(field, a.j(parcel, readInt)));
                            break;
                        case 6:
                            a(stringBuilder, field, FastJsonResponse.a(field, Boolean.valueOf(a.c(parcel, readInt))));
                            break;
                        case 7:
                            a(stringBuilder, field, FastJsonResponse.a(field, a.k(parcel, readInt)));
                            break;
                        case 8:
                        case 9:
                            a(stringBuilder, field, FastJsonResponse.a(field, a.n(parcel, readInt)));
                            break;
                        case 10:
                            a(stringBuilder, field, FastJsonResponse.a(field, a(a.m(parcel, readInt))));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + field.c());
                    }
                }
                a(stringBuilder, field, parcel, readInt);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != a) {
            throw new b("Overread allowed size end=" + a, parcel);
        }
        stringBuilder.append('}');
    }

    public final Map a() {
        return this.c == null ? null : this.c.a(this.e);
    }

    protected final Object b() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected final boolean c() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel d() {
        switch (this.f) {
            case 0:
                this.g = c.a(this.d, 20293);
                break;
            case 1:
                break;
        }
        c.b(this.d, this.g);
        this.f = 2;
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        av.a(this.c, (Object) "Cannot convert to JSON on client side.");
        Parcel d = d();
        d.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        a(stringBuilder, this.c.a(this.e), d);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
