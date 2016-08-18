package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.av;

public final class as extends v {
    private final ap a;
    private final boolean b = false;

    public as(ap apVar) {
        av.a((Object) apVar);
        this.a = apVar;
    }

    public as(ap apVar, boolean z) {
        av.a((Object) apVar);
        this.a = apVar;
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.e().a.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            int myUid = this.b ? Process.myUid() : Binder.getCallingUid();
            if (!GooglePlayServicesUtil.zzb(this.a.a, myUid, str) && !GooglePlayServicesUtil.zze(this.a.a, myUid)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        } catch (SecurityException e) {
            this.a.e().a.a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    public final void a(AppMetadata appMetadata) {
        av.a((Object) appMetadata);
        b(appMetadata.b);
        this.a.f().a(new ay(this, appMetadata));
    }

    public final void a(EventParcel eventParcel, AppMetadata appMetadata) {
        av.a((Object) eventParcel);
        av.a((Object) appMetadata);
        b(appMetadata.b);
        this.a.f().a(new au(this, appMetadata, eventParcel));
    }

    public final void a(EventParcel eventParcel, String str, String str2) {
        av.a((Object) eventParcel);
        av.a(str);
        b(str);
        this.a.f().a(new av(this, str2, eventParcel, str));
    }

    public final void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        av.a((Object) userAttributeParcel);
        av.a((Object) appMetadata);
        b(appMetadata.b);
        if (userAttributeParcel.a() == null) {
            this.a.f().a(new aw(this, appMetadata, userAttributeParcel));
        } else {
            this.a.f().a(new ax(this, appMetadata, userAttributeParcel));
        }
    }

    final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.a.d().b.a(split[1], longValue);
                    } else {
                        this.a.e().b.a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.a.e().b.a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public final void b(AppMetadata appMetadata) {
        av.a((Object) appMetadata);
        b(appMetadata.b);
        this.a.f().a(new at(this, appMetadata));
    }
}
