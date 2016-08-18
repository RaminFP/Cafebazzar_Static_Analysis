package com.farsitel.bazaar.activity;

import android.widget.Toast;
import com.farsitel.bazaar.f.a.b;
import ir.cafebazaar.pardakht.aa;
import java.util.Map;

final class bi implements b {
    final /* synthetic */ HomeActivity a;

    bi(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        this.a.d.dismiss();
        Toast.makeText(this.a.getApplicationContext(), (CharSequence) map.get("general"), 1).show();
    }

    public final void b() {
        if (!this.a.isFinishing()) {
            this.a.d.dismiss();
            HomeActivity.d(this.a);
            aa.INSTANCE.a();
        }
    }
}
