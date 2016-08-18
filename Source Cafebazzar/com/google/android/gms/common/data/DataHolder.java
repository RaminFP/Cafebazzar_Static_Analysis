package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DataHolder implements SafeParcelable {
    public static final d CREATOR = new d();
    private static final b l = new a(new String[0], null);
    final int a;
    final String[] b;
    Bundle c;
    final CursorWindow[] d;
    final int e;
    final Bundle f;
    int[] g;
    int h;
    boolean i = false;
    private Object j;
    private boolean k = true;

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    private boolean b() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    private void c() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                for (CursorWindow close : this.d) {
                    close.close();
                }
            }
        }
    }

    public final void a() {
        int i;
        int i2 = 0;
        this.c = new Bundle();
        for (i = 0; i < this.b.length; i++) {
            this.c.putInt(this.b[i], i);
        }
        this.g = new int[this.d.length];
        for (i = 0; i < this.d.length; i++) {
            this.g[i] = i2;
            i2 += this.d[i].getNumRows() - (i2 - this.d[i].getStartPosition());
        }
        this.h = i2;
    }

    public final int describeContents() {
        return 0;
    }

    protected final void finalize() {
        try {
            if (this.k && this.d.length > 0 && !b()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.j == null ? "internal object: " + toString() : this.j.toString()) + ")");
                c();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
