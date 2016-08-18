package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Arrays;

final class z {
    private final String a;
    private final ComponentName b;

    public z(ComponentName componentName) {
        this.a = null;
        this.b = (ComponentName) av.a((Object) componentName);
    }

    public z(String str) {
        this.a = av.a(str);
        this.b = null;
    }

    public final Intent a() {
        return this.a != null ? new Intent(this.a).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) : new Intent().setComponent(this.b);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof z)) {
                return false;
            }
            z zVar = (z) obj;
            if (!at.a(this.a, zVar.a)) {
                return false;
            }
            if (!at.a(this.b, zVar.b)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return this.a == null ? this.b.flattenToString() : this.a;
    }
}
