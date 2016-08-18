package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.a.bw;
import com.google.android.gms.a.cc;
import com.google.android.gms.a.cd;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public class Field implements SafeParcelable {
        public static final b CREATOR = new b();
        final int a;
        protected final int b;
        protected final boolean c;
        protected final int d;
        protected final boolean e;
        protected final String f;
        protected final int g;
        protected final Class h;
        protected final String i;
        FieldMappingDictionary j;
        a k;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            a aVar = null;
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = i3;
            this.e = z2;
            this.f = str;
            this.g = i4;
            if (str2 == null) {
                this.h = null;
                this.i = null;
            } else {
                this.h = SafeParcelResponse.class;
                this.i = str2;
            }
            if (converterWrapper != null) {
                if (converterWrapper.b != null) {
                    aVar = converterWrapper.b;
                } else {
                    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
                }
            }
            this.k = aVar;
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, a aVar) {
            this.a = 1;
            this.b = i;
            this.c = z;
            this.d = i2;
            this.e = z2;
            this.f = str;
            this.g = i3;
            this.h = cls;
            if (cls == null) {
                this.i = null;
            } else {
                this.i = cls.getCanonicalName();
            }
            this.k = aVar;
        }

        public static Field a(String str, int i) {
            return new Field(0, false, 0, false, str, i, null, null);
        }

        public static Field a(String str, int i, a aVar, boolean z) {
            return new Field(7, false, 0, false, str, i, null, aVar);
        }

        public static Field a(String str, int i, Class cls) {
            return new Field(11, false, 11, false, str, i, cls, null);
        }

        public static Field b(String str, int i) {
            return new Field(4, false, 4, false, str, i, null, null);
        }

        public static Field b(String str, int i, Class cls) {
            return new Field(11, true, 11, true, str, i, cls, null);
        }

        public static Field c(String str, int i) {
            return new Field(6, false, 6, false, str, i, null, null);
        }

        public static Field d(String str, int i) {
            return new Field(7, false, 7, false, str, i, null, null);
        }

        public static Field e(String str, int i) {
            return new Field(7, true, 7, true, str, 3, null, null);
        }

        public final int a() {
            return this.b;
        }

        public final boolean b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final boolean d() {
            return this.e;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f;
        }

        public final int f() {
            return this.g;
        }

        public final Class g() {
            return this.h;
        }

        final String h() {
            return this.i == null ? null : this.i;
        }

        public final Map i() {
            av.a(this.i);
            av.a(this.j);
            return this.j.a(this.i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.a).append('\n');
            stringBuilder.append("                 typeIn=").append(this.b).append('\n');
            stringBuilder.append("            typeInArray=").append(this.c).append('\n');
            stringBuilder.append("                typeOut=").append(this.d).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.e).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.f).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.g).append('\n');
            stringBuilder.append("       concreteTypeName=").append(h()).append('\n');
            if (this.h != null) {
                stringBuilder.append("     concreteType.class=").append(this.h.getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.k == null ? "null" : this.k.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            b.a(this, parcel, i);
        }
    }

    protected static Object a(Field field, Object obj) {
        return field.k != null ? field.k.a(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.a() == 11) {
            stringBuilder.append(((FastJsonResponse) field.g().cast(obj)).toString());
        } else if (field.a() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(cc.a((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void a(StringBuilder stringBuilder, Field field, ArrayList arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map a();

    public boolean a(Field field) {
        if (field.c() != 11) {
            field.e();
            return c();
        } else if (field.d()) {
            field.e();
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        } else {
            field.e();
            throw new UnsupportedOperationException("Concrete types not supported");
        }
    }

    protected abstract Object b();

    public Object b(Field field) {
        String e = field.e();
        if (field.g() != null) {
            field.e();
            b();
            field.e();
            field.d();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(e.charAt(0)) + e.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        field.e();
        return b();
    }

    protected abstract boolean c();

    public String toString() {
        Map a = a();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : a.keySet()) {
            Field field = (Field) a.get(str);
            if (a(field)) {
                Object a2 = a(field, b(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (field.c()) {
                        case 8:
                            stringBuilder.append("\"").append(bw.a((byte[]) a2)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(bw.b((byte[]) a2)).append("\"");
                            break;
                        case 10:
                            cd.a(stringBuilder, (HashMap) a2);
                            break;
                        default:
                            if (!field.b()) {
                                a(stringBuilder, field, a2);
                                break;
                            }
                            a(stringBuilder, field, (ArrayList) a2);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
