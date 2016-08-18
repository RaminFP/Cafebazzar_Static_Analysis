package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.a.bz;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.av;
import com.google.android.gms.measurement.d;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public final class x extends ba {
    private static final X500Principal a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;

    x(ap apVar) {
        super(apVar);
    }

    private boolean o() {
        try {
            PackageInfo packageInfo = super.i().getPackageManager().getPackageInfo(super.i().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(a);
            }
        } catch (CertificateException e) {
            super.l().a.a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            super.l().a.a("Package name not found", e2);
        }
        return true;
    }

    final AppMetadata a(String str) {
        String str2 = this.b;
        String b = b();
        String str3 = this.c;
        String str4 = this.d;
        long A = i.A();
        u();
        return new AppMetadata(str2, b, str3, str4, A, this.f, str, super.m().r());
    }

    protected final void a() {
        long j;
        String str = "Unknown";
        String str2 = "Unknown";
        PackageManager packageManager = super.i().getPackageManager();
        String packageName = super.i().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if (GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE.equals(installerPackageName)) {
            installerPackageName = "";
        }
        String str3;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(super.i().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = str2;
                str2 = packageInfo.versionName;
            } else {
                str3 = str;
                str = str2;
                str2 = str3;
            }
        } catch (NameNotFoundException e) {
            super.l().a.a("Error retrieving package info: appName", str2);
            str3 = str;
            str = str2;
            str2 = str3;
        }
        this.b = packageName;
        this.d = installerPackageName;
        this.c = str2;
        this.e = str;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (!o()) {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(super.i().getPackageName(), 64);
                if (!(instance == null || packageInfo2.signatures == null || packageInfo2.signatures.length <= 0)) {
                    Object digest = instance.digest(packageInfo2.signatures[0].toByteArray());
                    av.a(digest);
                    av.a(digest.length > 0);
                    long j2 = 0;
                    int length = digest.length - 1;
                    j = 0;
                    while (length >= 0 && length >= digest.length - 8) {
                        j += (((long) digest[length]) & 255) << j2;
                        j2 += 8;
                        length--;
                    }
                    this.f = j;
                }
            }
            j = 0;
        } catch (NoSuchAlgorithmException e2) {
            super.l().a.a("Could not get MD5 instance", e2);
            j = 0;
        } catch (NameNotFoundException e3) {
            super.l().a.a("Package name not found", e3);
            j = 0;
        }
        this.f = j;
    }

    final String b() {
        u();
        if (i.B()) {
            return "";
        }
        if (this.g == null) {
            Status a = d.a(super.i());
            if (a == null || !a.b()) {
                this.g = "";
                super.l().a.a("getGoogleAppId failed with status", Integer.valueOf(a == null ? 0 : a.g));
                if (!(a == null || a.h == null)) {
                    super.l().f.a(a.h);
                }
            } else {
                try {
                    if (d.b()) {
                        String a2 = d.a();
                        if (TextUtils.isEmpty(a2)) {
                            a2 = "";
                        }
                        this.g = a2;
                    } else {
                        this.g = "";
                    }
                } catch (IllegalStateException e) {
                    this.g = "";
                    super.l().a.a("getGoogleAppId or isMeasurementEnabled failed with exception", e);
                }
            }
        }
        return this.g;
    }

    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    public final /* bridge */ /* synthetic */ x f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ bg g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ bz h() {
        return super.h();
    }

    public final /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ g j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ al k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ z l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ ai m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ i n() {
        return super.n();
    }
}
