package com.farsitel.bazaar.c.a;

import android.os.Handler;
import android.widget.Toast;
import com.congenialmobile.util.d;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.g.a.i;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.af;
import com.farsitel.bazaar.util.h;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.q;
import com.farsitel.bazaar.util.t;
import com.usf.research.AppPatcherActivity;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public final class a implements h {
    private static Handler k = new Handler();
    public final String a;
    public final String b;
    public boolean c;
    public String d;
    public final int e;
    public String f;
    public BigInteger g;
    public long h;
    public int i;
    public boolean j = false;
    private g l;
    private String m;
    private String n;
    private BigInteger o;
    private long p;
    private boolean q = false;
    private Thread r = new b(this);

    public a(String str, String str2, boolean z, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = i;
    }

    public a(String str, String str2, boolean z, String str3, int i, String str4, String str5, BigInteger bigInteger, long j, String str6, BigInteger bigInteger2, long j2) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = i;
        this.m = str4;
        this.f = str5;
        this.g = bigInteger;
        this.h = j;
        this.n = str6;
        this.o = bigInteger2;
        this.p = j2;
    }

    private static boolean a(File file) {
        return file.exists() && file.canRead();
    }

    private static boolean a(File file, long j, BigInteger bigInteger) {
        if (!a(file) || file.length() != j) {
            return false;
        }
        try {
            if (new BigInteger(1, d.a(file, new byte[16384])).equals(bigInteger)) {
                return true;
            }
            file.delete();
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(File file, BigInteger bigInteger) {
        try {
            return new BigInteger(1, d.a(file, new byte[16384])).equals(bigInteger);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str) {
        return a(b(str));
    }

    public static File b(String str) {
        return new File(i.a(str));
    }

    public void a() {
        boolean z = true;
        if (!this.j) {
            if (t.a(this.h)) {
                File file;
                String str;
                BigInteger bigInteger;
                long j;
                if (this.n == null || this.o == null || this.p <= 0 || !com.farsitel.bazaar.util.d.a()) {
                    file = new File(i.a(this.a));
                    str = this.f;
                    bigInteger = this.g;
                    j = this.h;
                    z = false;
                } else {
                    this.q = true;
                    file = new File(new File(t.b(), this.a + ".df.apk").getAbsolutePath());
                    str = this.n;
                    bigInteger = this.o;
                    j = this.p;
                }
                this.l = new g(g(), file, str, bigInteger, j, z, this);
                if (a(file, j, bigInteger)) {
                    a(3);
                    return;
                } else {
                    this.l.start();
                    return;
                }
            }
            Toast.makeText(BazaarApplication.c(), 2131165471, 0).show();
            a(5);
        }
    }

    public void a(int i) {
        boolean z = true;
        if (this.l == null || !this.l.isInterrupted()) {
            int i2;
            if (!(this.i == i || i == 14)) {
                Object hostAddress;
                boolean z2 = g.a().b(this.a) != null;
                com.farsitel.bazaar.g.a a = com.farsitel.bazaar.g.a.a();
                c cVar = new c();
                cVar.f = "system";
                cVar.c = "downloads";
                cVar = cVar.a("pn", this.a).a("referer", this.d);
                cVar.e = "download";
                cVar = cVar.b("updating", Boolean.valueOf(z2)).b("state", f.c(i)).b("last_state", f.c(com.farsitel.bazaar.c.b.a.a().a(this.a))).b("city", h.INSTANCE.b()).b("bazaar_version", Integer.valueOf(k.b())).b("total_size", Long.valueOf(this.h)).b("diff_size", Long.valueOf(this.p)).b("cdn", g()).b("is_free", Boolean.valueOf(this.c)).b("network_type", q.g()).b("network_operator", q.a()).b("downloaded_bytes", Long.valueOf(this.l != null ? this.l.b : -1)).b("cilent_ip_addr", q.a(true));
                if (this.l != null) {
                    g gVar = this.l;
                    hostAddress = gVar.d != null ? gVar.d.getHostAddress() : "";
                } else {
                    hostAddress = "";
                }
                a.a(cVar.b("server_ip_addr", hostAddress));
            }
            if (i == 3 && this.q) {
                AppDownloadService.a(this.a, e(), e(), 14);
                com.farsitel.bazaar.c.b.a.a().a(this.a, 14);
                File file = new File(i.a(this.a));
                for (int i3 = 0; i3 < 3; i3++) {
                    AppPatcherActivity appPatcherActivity = new AppPatcherActivity();
                    af afVar = af.INSTANCE;
                    if (appPatcherActivity.a(af.e(this.a), file, this.l.a) && a(file, this.g)) {
                        break;
                    }
                    BazaarApplication.c().d();
                    com.farsitel.bazaar.i.a("/Landa/HashPatch/FailRetry");
                    file.delete();
                }
                z = false;
                if (z) {
                    BazaarApplication.c().d();
                    com.farsitel.bazaar.i.a("/Landa/HashPatch/Success");
                } else {
                    BazaarApplication.c().d();
                    com.farsitel.bazaar.i.a("/Landa/HashPatch/Fail");
                    i2 = 9;
                    if (this.i != i2) {
                        com.farsitel.bazaar.c.b.a.a().a(this.a, i2);
                    }
                    AppDownloadService.a(this.a, this.l != null ? 0 : this.l.b, e(), i2);
                    switch (i2) {
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            c();
                            break;
                    }
                    this.i = i2;
                }
            }
            i2 = i;
            if (this.i != i2) {
                com.farsitel.bazaar.c.b.a.a().a(this.a, i2);
            }
            if (this.l != null) {
            }
            AppDownloadService.a(this.a, this.l != null ? 0 : this.l.b, e(), i2);
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 11:
                case 12:
                    c();
                    break;
            }
            this.i = i2;
        }
    }

    public final void b() {
        a(11);
    }

    public final void b(int i) {
        a(i);
    }

    public final void c() {
        this.j = true;
        this.r.interrupt();
        if (this.l != null) {
            this.l.interrupt();
        }
    }

    public final void c(String str) {
        k.post(new d(this, str));
    }

    public final long d() {
        return this.l == null ? 0 : this.l.b;
    }

    public final long e() {
        return (this.p == 0 || !this.q) ? this.h : this.p;
    }

    public final void f() {
        this.r.start();
    }

    public final String g() {
        String string = j.a().a.getString("user_download_cdnprefix", null);
        return (string == null || string.isEmpty()) ? this.m : string;
    }
}
