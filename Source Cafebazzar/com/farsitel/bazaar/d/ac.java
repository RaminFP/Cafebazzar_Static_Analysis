package com.farsitel.bazaar.d;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.a.p;

final class ac implements OnClickListener {
    final /* synthetic */ p a;
    final /* synthetic */ ab b;

    ac(ab abVar, p pVar) {
        this.b = abVar;
        this.a = pVar;
    }

    public final void onClick(View view) {
        if (((String) view.getTag(2131165861)) != null) {
            PopupMenu popupMenu = new PopupMenu(this.b.getActivity(), view);
            popupMenu.inflate(2131689472);
            popupMenu.setOnMenuItemClickListener(new ad(this, view));
            popupMenu.show();
        }
    }
}
