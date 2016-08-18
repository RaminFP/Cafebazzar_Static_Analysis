package com.farsitel.bazaar.a;

import android.widget.Toast;
import com.farsitel.bazaar.g.h;
import com.farsitel.bazaar.h.c;
import com.farsitel.bazaar.h.v;

final class bd extends v {
    h a;
    final /* synthetic */ az b;

    private bd(az azVar, int i) {
        this.b = azVar;
        this.a = (h) azVar.a.get(i);
    }

    public final void a(c cVar) {
        this.b.e.dismiss();
    }

    public final /* synthetic */ void a(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            Toast.makeText(this.b.c.getActivity(), this.b.c.getActivity().getString(2131165672), 1).show();
            this.a.i = false;
            this.a.h = this.b.c.getActivity().getString(2131165673);
            this.b.notifyDataSetChanged();
        } else {
            Toast.makeText(this.b.c.getActivity(), this.b.c.getActivity().getString(2131165700), 1).show();
        }
        this.b.e.dismiss();
    }
}
