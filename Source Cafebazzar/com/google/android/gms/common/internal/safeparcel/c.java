package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class c {
    public static int a(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i, double d) {
        a(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void a(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void a(Parcel parcel, int i, long j) {
        a(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a = a(parcel, i);
            parcel.writeBundle(bundle);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a = a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            b(parcel, a);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            a(parcel, i, 8);
            parcel.writeLong(l.longValue());
        }
    }

    public static void a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int a = a(parcel, i);
            parcel.writeString(str);
            b(parcel, a);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int a = a(parcel, i);
            parcel.writeStringList(list);
            b(parcel, a);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, int i, boolean z) {
        a(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a = a(parcel, i);
            parcel.writeByteArray(bArr);
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr != null) {
            int a = a(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, i2);
                }
            }
            b(parcel, a);
        }
    }

    public static void a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a = a(parcel, i);
            parcel.writeStringArray(strArr);
            b(parcel, a);
        }
    }

    private static void a(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void b(Parcel parcel, int i, int i2) {
        a(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void b(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int a = a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, 0);
                }
            }
            b(parcel, a);
        } else if (z) {
            a(parcel, i, 0);
        }
    }
}
