package com.farsitel.bazaar.b;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.a.an;
import com.farsitel.bazaar.g;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ag;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.widget.BazaarViewFlipper;

public final class ar extends m implements OnItemClickListener {
    public Handler a = new Handler();
    private final BazaarApplication b = BazaarApplication.c();
    private BazaarViewFlipper c;
    private EditText d;
    private ListView h;
    private String[] i;
    private char j;
    private String k;

    public ar(Activity activity, String str) {
        super(activity, 2131165576);
        this.k = str;
        View inflate = LayoutInflater.from(activity).inflate(2130903102, null);
        this.i = activity.getResources().getStringArray(2131230733);
        this.c = (BazaarViewFlipper) inflate.findViewById(2131624260);
        Animation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(400);
        Animation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation2.setDuration(400);
        this.c.setInAnimation(translateAnimation);
        this.c.setOutAnimation(translateAnimation2);
        ListAdapter anVar = new an(activity);
        this.h = (ListView) inflate.findViewById(2131624261);
        this.h.setAdapter(anVar);
        this.h.setSelector(g.selector);
        this.h.setOnItemClickListener(this);
        this.d = (EditText) inflate.findViewById(2131624262);
        this.b.d();
        i.a("/ReportApp");
        a(inflate);
        a(2131165661, new as(this, activity));
        c(2131165323, new at(this));
        a a = a.a();
        c cVar = new c();
        cVar.f = "user";
        cVar.c = "report_dialog";
        cVar = cVar.a("pn", this.k);
        cVar.e = "dialog_visit";
        a.a(cVar.b("-", "-"));
    }

    static /* synthetic */ void c(ar arVar) {
        String obj = arVar.d.getText() != null ? arVar.d.getText().toString() : "";
        if (d.INSTANCE.b(new ag(), j.a().b, arVar.k, Character.valueOf(arVar.j), obj)) {
            Toast.makeText(arVar.f, 2131165578, 1).show();
            arVar.e.dismiss();
            return;
        }
        Toast.makeText(arVar.f, 2131165701, 0).show();
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.j = this.i[i].charAt(0);
        if (this.j == 'O') {
            this.d.setHint(2131165582);
        }
        this.c.showNext();
    }
}
