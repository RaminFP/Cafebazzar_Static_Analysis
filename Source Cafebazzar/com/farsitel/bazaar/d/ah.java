package com.farsitel.bazaar.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.b.a;
import com.farsitel.bazaar.b.e;

final class ah implements OnClickListener {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public final void onClick(View view) {
        if (this.a.a) {
            new a(this.a.getActivity()).e.show();
        } else {
            new e(this.a.getActivity()).e.show();
        }
        this.a.getFragmentManager().popBackStack();
    }
}
