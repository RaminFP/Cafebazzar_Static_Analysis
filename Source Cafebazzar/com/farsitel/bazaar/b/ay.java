package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ai;
import com.farsitel.bazaar.h.b.aj;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.ax;
import java.util.Map;

public final class ay extends m implements b {
    private static final BazaarApplication a = BazaarApplication.c();
    private int b;
    private View c;
    private TextView d;
    private v h;

    public ay(Activity activity) {
        int i = (j.a().j() && j.a().i()) ? 2131165592 : j.a().i() ? 2131165593 : 2131165594;
        super(activity, i);
        this.b = -1;
        this.h = new az(this);
        View inflate = LayoutInflater.from(this.f).inflate(2130903104, null);
        this.d = (TextView) inflate.findViewById(2131624042);
        this.c = inflate.findViewById(2131624255);
        a.d();
        i.a("/ResetPassword");
        a(inflate);
        i = (j.a().j() && j.a().i()) ? 2131165538 : 2131165801;
        a(i, new ba(this));
        i = (j.a().j() && j.a().i()) ? 2131165360 : 0;
        b(i, new bb(this));
        c(2131165323, new bc(this));
    }

    static /* synthetic */ void a(ay ayVar, String str) {
        if (ax.b(str)) {
            ayVar.b = 1;
            ayVar.a();
            d.INSTANCE.a(ayVar.h, new aj(), a.a.getLanguage(), str);
            ayVar.d.setVisibility(8);
        } else if (ax.a(str)) {
            ayVar.b = 0;
            ayVar.a();
            d.INSTANCE.a(ayVar.h, new ai(), a.a.getLanguage(), str);
            ayVar.d.setVisibility(8);
        } else {
            ayVar.d.setText(2131165373);
            ayVar.d.setVisibility(0);
        }
    }

    public final void a() {
        this.c.setVisibility(0);
    }

    public final void a(int i, Map map) {
        this.c.setVisibility(8);
        this.d.setText((CharSequence) map.get("general"));
        if (map.containsKey("general") && this.d != null) {
            this.d.setText((CharSequence) map.get("general"));
            this.d.setVisibility(0);
        }
        if (i == 10000) {
            this.d.setText(this.f.getString(2131165452));
            this.d.setVisibility(0);
        }
    }

    public final void b() {
        this.c.setVisibility(8);
        switch (this.b) {
            case 0:
                Toast.makeText(this.f, 2131165508, 1).show();
                break;
            case 1:
                Toast.makeText(this.f, 2131165509, 1).show();
                break;
        }
        this.e.dismiss();
    }
}
