package com.farsitel.bazaar.f;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.activity.JoinActivity;
import com.farsitel.bazaar.c.b.a;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.as;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.service.AppDownloadService;
import com.farsitel.bazaar.util.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    static final BazaarApplication a = BazaarApplication.c();
    final String b;
    final String c;
    final long d;
    Activity e;
    private final String f;
    private final boolean g;
    private final long h;
    private h i;
    private ProgressDialog j;
    private a k = new a(this.b, this.g, this.f + "|" + com.farsitel.bazaar.c.a.f.c(a.a().a(this.b)), new g(this));
    private i l;

    public f(Activity activity, String str, long j, boolean z, String str2, long j2, String str3) {
        this.e = activity;
        this.b = str;
        this.d = j;
        this.g = z;
        this.c = str2;
        this.h = j2;
        this.f = str3;
        this.j = new ProgressDialog(activity);
        this.j.setMessage(activity.getString(2131165546));
        this.j.setCancelable(false);
    }

    public final void a(int i, int i2, Intent intent) {
        int i3 = 1;
        switch (i) {
            case 40001:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
                    this.i = new h(stringExtra, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
                    h hVar = this.i;
                    if (hVar.a == null || hVar.b == null) {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        try {
                            if (new JSONObject(stringExtra).optString("productId").equals(this.b)) {
                                Toast.makeText(this.e, 2131165518, 0).show();
                                this.j.show();
                                v vVar = this.k;
                                h hVar2 = this.i;
                                d.INSTANCE.a(vVar, vVar.b, new as(), j.a().b, hVar2.a, hVar2.b, vVar.a, Integer.valueOf(VERSION.SDK_INT));
                                this.i = null;
                                return;
                            }
                            return;
                        } catch (JSONException e) {
                            this.i = null;
                            Toast.makeText(this.e, 2131165519, 0).show();
                            return;
                        }
                    }
                    return;
                }
                Toast.makeText(this.e, 2131165519, 0).show();
                return;
            case 40003:
                if (i2 == -1) {
                    a(null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(View view) {
        if (!this.g && !j.a().n()) {
            Intent intent = new Intent(this.e, JoinActivity.class);
            intent.putExtra("extra_referer", "app-purchase");
            intent.putExtra("android.intent.extra.TITLE", String.format(this.e.getApplicationContext().getString(2131165319), new Object[]{this.c}));
            c.a(this.e, intent, 40003, view);
        } else if (this.g) {
            AppDownloadService.a(this.b, this.c, this.g, this.f);
        } else if (this.i == null) {
            this.j.show();
            this.k.a();
        }
    }
}
