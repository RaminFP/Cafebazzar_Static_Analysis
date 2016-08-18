package com.farsitel.bazaar.d;

import android.widget.Toast;
import com.farsitel.bazaar.util.ag;
import com.farsitel.bazaar.util.g;
import java.util.Map;

final class b implements com.farsitel.bazaar.f.a.b {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        if (this.a.A.isShowing()) {
            this.a.A.dismiss();
        }
        this.a.b((String) map.get("general"));
    }

    public final void b() {
        if (this.a.A.isShowing()) {
            this.a.A.dismiss();
            this.a.a = 0;
            this.a.b();
            Toast.makeText(this.a.getActivity(), this.a.getString(2131165507), 0).show();
            ag.a(this.a.getActivity(), this.a.getView().getWindowToken());
            this.a.c.setBackgroundResource(2131558472);
            this.a.c.setText(2131165507);
            g.a(this.a.getActivity(), this.a.c, 0.0f);
            this.a.c.setVisibility(0);
            this.a.B.postDelayed(new c(this), 3000);
        }
    }
}
