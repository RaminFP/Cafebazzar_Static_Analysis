package com.farsitel.bazaar.d;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnClickListener;
import com.farsitel.bazaar.a.bg;

final class bz implements OnClickListener {
    final /* synthetic */ bg a;
    final /* synthetic */ bw b;

    bz(bw bwVar, bg bgVar) {
        this.b = bwVar;
        this.a = bgVar;
    }

    public final void onClick(View view) {
        int i = Boolean.valueOf(view.getTag(2131165860).toString()).booleanValue() ? 2131165350 : 2131165362;
        String str = (String) view.getTag(2131165861);
        if (str != null) {
            boolean z = !this.b.getActivity().getPackageName().equals(str);
            PopupMenu popupMenu = new PopupMenu(this.b.getActivity(), view);
            popupMenu.inflate(2131689473);
            popupMenu.getMenu().findItem(2131624435).setTitle(i).setEnabled(z);
            popupMenu.setOnMenuItemClickListener(new ca(this, view));
            popupMenu.show();
        }
    }
}
