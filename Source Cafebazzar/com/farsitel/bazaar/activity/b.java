package com.farsitel.bazaar.activity;

import android.net.Uri;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.f;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.RetryView;
import java.util.Map;

final class b implements com.farsitel.bazaar.f.a.b {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.B.setVisibility(0);
        this.a.A.setVisibility(8);
    }

    public final void a(int i, Map map) {
        this.a.B.setVisibility(8);
        if (i < 10000 || i > 10012) {
            Uri parse = Uri.parse(this.a.getArguments().getString("app_slug"));
            String queryParameter = parse.getQueryParameter("id");
            String queryParameter2 = queryParameter == null ? parse.getQueryParameter("app") : queryParameter;
            this.a.A.setVisibility(0);
            this.a.A.setText((CharSequence) map.get("general"));
            BazaarApplication.c().d();
            i.a("/AppInfo/Error/" + queryParameter2 + "/");
            return;
        }
        this.a.z.setVisibility(0);
        RetryView h = this.a.z;
        map.get("general");
        h.a(i, new c(this), this.a);
    }

    public final void b() {
        this.a.B.setVisibility(8);
        this.a.e = this.a.d.c;
        this.a.f = new f(this.a.getActivity(), this.a.e.g(), (long) this.a.e.b(), this.a.e.a(), this.a.e.h(), this.a.e.i(), this.a.c);
        a.f(this.a);
        if ("android.intent.action.RUN".equals(this.a.getArguments().getString("intent_action"))) {
            this.a.e.k();
        }
        a.g(this.a);
    }
}
