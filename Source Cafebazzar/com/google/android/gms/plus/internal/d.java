package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import java.util.List;

public interface d extends IInterface {
    ag a(a aVar, int i, int i2, int i3, String str);

    String a();

    void a(SafeParcelResponse safeParcelResponse);

    void a(a aVar);

    void a(a aVar, int i, String str, Uri uri, String str2, String str3);

    void a(a aVar, Uri uri, Bundle bundle);

    void a(a aVar, SafeParcelResponse safeParcelResponse);

    void a(a aVar, String str);

    void a(a aVar, String str, String str2);

    void a(a aVar, List list);

    void a(String str);

    void a(String str, FavaDiagnosticsEntity favaDiagnosticsEntity, FavaDiagnosticsEntity favaDiagnosticsEntity2);

    void b();

    void b(a aVar);

    void b(a aVar, String str);

    String c();

    void c(a aVar, String str);

    void d(a aVar, String str);

    boolean d();

    String e();

    void e(a aVar, String str);
}
