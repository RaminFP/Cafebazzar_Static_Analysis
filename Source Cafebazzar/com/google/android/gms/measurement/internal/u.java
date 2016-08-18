package com.google.android.gms.measurement.internal;

import android.os.IInterface;

public interface u extends IInterface {
    void a(AppMetadata appMetadata);

    void a(EventParcel eventParcel, AppMetadata appMetadata);

    void a(EventParcel eventParcel, String str, String str2);

    void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata);

    void b(AppMetadata appMetadata);
}
