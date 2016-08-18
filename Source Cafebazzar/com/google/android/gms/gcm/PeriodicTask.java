package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator CREATOR = new f();
    protected long a;
    protected long b;

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.a = -1;
        this.b = -1;
        this.a = parcel.readLong();
        this.b = Math.min(parcel.readLong(), this.a);
    }

    public String toString() {
        return super.toString() + " period=" + this.a + " flex=" + this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
