package com.farsitel.bazaar.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.congenialmobile.util.e;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.f.a.b;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ad;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import java.util.Map;

public final class an extends m implements b {
    private TextView a;
    private EditText b;
    private ProgressDialog c = new ProgressDialog(this.f);

    public an(Activity activity) {
        super(activity, 2131165562);
        View inflate = LayoutInflater.from(this.f).inflate(2130903101, null);
        TextView textView = (TextView) inflate.findViewById(2131624259);
        textView.setText(Html.fromHtml(this.f.getString(2131165565)));
        Linkify.addLinks(textView, 15);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.a = (TextView) inflate.findViewById(2131624042);
        this.c.setMessage(this.f.getString(2131165546));
        this.c.setCancelable(false);
        this.b = (EditText) inflate.findViewById(2131624258);
        this.b.setOnEditorActionListener(new ao(this));
        a(inflate);
        a(2131165661, new ap(this));
        c(2131165323, new aq(this));
    }

    static /* synthetic */ void a(an anVar) {
        String a = e.a(anVar.b.getText().toString().trim().replaceAll("\\s", ""));
        anVar.a.setVisibility(8);
        if (a.length() < 6) {
            anVar.a(anVar.f.getString(2131165738));
            return;
        }
        anVar.c.show();
        if (j.a().b != null) {
            com.farsitel.bazaar.h.a.j jVar = new com.farsitel.bazaar.h.a.j(a);
            jVar.c = anVar;
            anVar.a();
            d.INSTANCE.a(jVar.d, new ad(), jVar.b, j.a().d(), BazaarApplication.c().a.getLanguage(), Boolean.valueOf(true));
            BazaarApplication.c().d();
            i.a("/Account/Redeem");
            return;
        }
        anVar.a(anVar.f.getString(2131165437));
    }

    private void a(String str) {
        this.a.setText(str);
        this.a.setVisibility(0);
    }

    public final void a() {
    }

    public final void a(int i, Map map) {
        e();
        if (this.c.isShowing()) {
            this.c.dismiss();
        }
        a((String) map.get("general"));
    }

    public final void b() {
        if (this.c.isShowing()) {
            this.c.dismiss();
        }
        Toast.makeText(BazaarApplication.c(), this.f.getString(2131165567), 1).show();
        d();
        this.e.dismiss();
    }
}
