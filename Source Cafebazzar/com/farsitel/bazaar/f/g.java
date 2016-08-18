package com.farsitel.bazaar.f;

import android.widget.Toast;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.r;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.p;
import com.farsitel.bazaar.util.q;
import java.math.BigInteger;

final class g implements c {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void a() {
        this.a.l = new i(this.a);
        d.INSTANCE.a(this.a.l, new r(), f.a.a.getLanguage(), f.a.getPackageName(), this.a.b, j.a().d(), p.a(), Integer.valueOf(k.b()), Integer.valueOf(q.c()), Integer.valueOf(q.d()));
    }

    public final void a(String str, String str2, BigInteger bigInteger, long j, String str3, BigInteger bigInteger2, long j2) {
        this.a.j.dismiss();
        AppDownloadService.a(this.a.b, this.a.c, this.a.g, this.a.f, str, str2, bigInteger, j, str3, bigInteger2, j2);
    }

    public final void b() {
        this.a.j.dismiss();
        Toast.makeText(this.a.e, 2131165279, 1).show();
    }

    public final void c() {
        this.a.j.dismiss();
        AppDownloadService.a(this.a.b, 0, 0, 7);
    }

    public final void d() {
        this.a.j.dismiss();
        AppDownloadService.a(this.a.b, 0, 0, 4);
    }

    public final void e() {
        this.a.j.dismiss();
        AppDownloadService.a(this.a.b, 0, 0, 4);
    }
}
