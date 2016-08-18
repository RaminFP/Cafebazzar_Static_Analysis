package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator CREATOR = new h();
    final boolean a = false;
    final Handler b = null;
    a c;

    ResultReceiver(Parcel parcel) {
        this.c = b.a(parcel.readStrongBinder());
    }

    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new i(this);
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
