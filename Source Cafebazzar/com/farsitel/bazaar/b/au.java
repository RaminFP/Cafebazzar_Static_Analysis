package com.farsitel.bazaar.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.ah;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.i;

public final class au extends m {
    private final BazaarApplication a = BazaarApplication.c();
    private EditText b;
    private ScrollView c;

    public au(Activity activity) {
        super(activity, 2131165584);
        View inflate = LayoutInflater.from(this.f).inflate(2130903103, null);
        this.b = (EditText) inflate.findViewById(2131624264);
        this.b.setOnEditorActionListener(new av(this));
        this.c = (ScrollView) inflate.findViewById(2131624263);
        this.a.d();
        i.a("/RequestApp");
        a(inflate);
        a(2131165661, new aw(this));
        c(2131165323, new ax(this));
    }

    static /* synthetic */ void a(au auVar) {
        if (auVar.b.getText().toString().equals("")) {
            Toast.makeText(auVar.f, 2131165540, 1).show();
            return;
        }
        if (d.INSTANCE.b(new ah(), j.a().b, r0)) {
            Toast.makeText(auVar.f, 2131165585, 1).show();
            auVar.e.dismiss();
            return;
        }
        Toast.makeText(auVar.f, 2131165701, 0).show();
    }
}
