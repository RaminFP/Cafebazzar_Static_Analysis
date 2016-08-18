package com.farsitel.bazaar.b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ap;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.h.v;
import com.farsitel.bazaar.i;
import java.util.Map;

public final class ab extends m implements b {
    private static final BazaarApplication a = BazaarApplication.c();
    private final SharedPreferences b = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
    private View c;
    private EditText d;
    private TextView h;
    private v i = new ac(this);

    public ab(Activity activity) {
        super(activity, 2131165460);
        View inflate = LayoutInflater.from(this.f).inflate(2130903100, null);
        this.d = (EditText) inflate.findViewById(2131624257);
        this.d.setOnEditorActionListener(new ad(this));
        CharSequence k = j.a().k();
        if (k != null) {
            this.d.setText(k);
        }
        this.h = (TextView) inflate.findViewById(2131624042);
        this.c = inflate.findViewById(2131624255);
        a.d();
        i.a("/Nickname");
        a(inflate);
        a(2131165661, new ae(this));
        c(2131165323, new af(this));
    }

    static /* synthetic */ void c(ab abVar) {
        abVar.a();
        d.INSTANCE.a(abVar.i, new ap(), j.a().b, abVar.d.getText().toString());
        abVar.h.setVisibility(8);
    }

    public final void a() {
        this.c.setVisibility(0);
    }

    public final void a(int i, Map map) {
        this.c.setVisibility(8);
        this.h.setVisibility(0);
        this.h.setText((CharSequence) map.get("general"));
    }

    public final void b() {
        this.c.setVisibility(8);
        j.a().s().e(this.d.getText().toString()).a();
        d();
        this.e.dismiss();
    }
}
