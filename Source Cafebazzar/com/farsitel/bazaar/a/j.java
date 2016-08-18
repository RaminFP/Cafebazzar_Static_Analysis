package com.farsitel.bazaar.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.database.b;
import com.farsitel.bazaar.f.f;
import com.farsitel.bazaar.g.a.k;
import com.farsitel.bazaar.service.AppDownloadService;

final class j implements OnClickListener {
    final /* synthetic */ h a;
    private final k b;
    private final k c;
    private final int d;

    public j(h hVar, k kVar, k kVar2, int i) {
        this.a = hVar;
        this.b = kVar;
        this.c = kVar2;
        this.d = i;
        this.b.d.setOnClickListener(this);
    }

    public final void onClick(View view) {
        b.a();
        switch (b.a(this.c.a)) {
            case 0:
            case 1:
                String a = this.a.x;
                if (!TextUtils.isEmpty(this.a.m)) {
                    a = a + "|" + this.a.m;
                }
                this.a.n = new f(this.a.p, this.c.a, this.c.g, this.c.g == 0, this.c.b, this.c.d, !TextUtils.isEmpty(this.c.n) ? a + "|" + this.c.n : a + "|" + this.d);
                this.a.n.a(view);
                return;
            case 2:
                try {
                    Intent launchIntentForPackage = BazaarApplication.c().getPackageManager().getLaunchIntentForPackage(this.c.a);
                    launchIntentForPackage.addFlags(268435456);
                    BazaarApplication.c().startActivity(launchIntentForPackage);
                    return;
                } catch (Exception e) {
                    return;
                }
            case 3:
            case 4:
                AppDownloadService.a(this.c.a);
                return;
            default:
                return;
        }
    }
}
