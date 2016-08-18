package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.farsitel.bazaar.g.a;
import com.farsitel.bazaar.g.c;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.b.i;
import com.farsitel.bazaar.h.d;
import com.farsitel.bazaar.util.ax;

final class bv implements OnClickListener {
    final /* synthetic */ ArrayAdapter a;
    final /* synthetic */ bs b;

    bv(bs bsVar, ArrayAdapter arrayAdapter) {
        this.b = bsVar;
        this.a = arrayAdapter;
    }

    public final void onClick(View view) {
        if (this.b.d == null && !ax.a(this.b.e.getText().toString())) {
            Toast.makeText(this.b.getActivity(), 2131165764, 0).show();
        } else if (this.b.b.getText().toString().length() < 20 || this.b.b.getText().toString().length() > 1000) {
            Toast.makeText(this.b.getActivity(), 2131165542, 0).show();
        } else if (this.b.c.getSelectedItemPosition() == this.a.getCount()) {
            Toast.makeText(this.b.getActivity(), 2131165543, 0).show();
        } else {
            if (!(j.a().n() && j.a().i())) {
                this.b.d = this.b.e.getText().toString();
            }
            if (d.INSTANCE.b(new i(), bs.f(this.b))) {
                a a = a.a();
                c cVar = new c();
                cVar.c = "support";
                cVar.e = "send_message";
                a.a(cVar);
                Toast.makeText(this.b.getActivity(), 2131165386, 1).show();
                this.b.getActivity().onBackPressed();
                return;
            }
            Toast.makeText(this.b.getActivity(), 2131165701, 0).show();
        }
    }
}
