package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.av;

public final class d {
    private static volatile d d;
    private final String a;
    private final Status b;
    private final boolean c;

    private d(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        String resourcePackageName = resources.getResourcePackageName(c.common_google_play_services_unknown_issue);
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resourcePackageName);
        if (identifier != 0 && resources.getInteger(identifier) == 0) {
            z = false;
        }
        this.c = z;
        int identifier2 = resources.getIdentifier("google_app_id", "string", resourcePackageName);
        if (identifier2 == 0) {
            if (this.c) {
                this.b = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else {
                this.b = Status.a;
            }
            this.a = null;
            return;
        }
        String string = resources.getString(identifier2);
        if (TextUtils.isEmpty(string)) {
            if (this.c) {
                this.b = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string + "'.");
            } else {
                this.b = Status.a;
            }
            this.a = null;
            return;
        }
        this.a = string;
        this.b = Status.a;
    }

    public static Status a(Context context) {
        av.a((Object) context, (Object) "Context must not be null.");
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null) {
                        d = new d(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        Class cls = d.class;
                    }
                }
            }
        }
        return d.b;
    }

    public static String a() {
        if (d == null) {
            synchronized (d.class) {
                try {
                    Object obj = d;
                    if (obj == null) {
                        throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
                    }
                } finally {
                    Class cls = d.class;
                }
            }
        }
        d dVar = d;
        if (dVar.b.b()) {
            return dVar.a;
        }
        throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + dVar.b + "'.");
    }

    public static boolean b() {
        if (d == null) {
            synchronized (d.class) {
                try {
                    Object obj = d;
                    if (obj == null) {
                        throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
                    }
                } finally {
                    Class cls = d.class;
                }
            }
        }
        d dVar = d;
        if (dVar.b.b()) {
            return dVar.c;
        }
        throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + dVar.b + "'.");
    }
}
