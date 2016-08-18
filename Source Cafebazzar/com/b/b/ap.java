package com.b.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class ap implements LocationListener {
    final /* synthetic */ ao a;

    public ap(ao aoVar) {
        this.a = aoVar;
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            this.a.b = location;
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
