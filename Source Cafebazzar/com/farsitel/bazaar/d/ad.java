package com.farsitel.bazaar.d;

import android.app.ProgressDialog;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.h.d;

final class ad implements OnMenuItemClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ ac b;

    ad(ac acVar, View view) {
        this.b = acVar;
        this.a = view;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624434:
                String str = (String) this.a.getTag(2131165861);
                if (str != null) {
                    ProgressDialog progressDialog = new ProgressDialog(this.b.b.getActivity());
                    progressDialog.setMessage(this.b.b.getString(2131165546));
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    d.INSTANCE.a(new ae(this, progressDialog, str), new com.farsitel.bazaar.h.b.d(), j.a().b, str, Boolean.valueOf(false));
                }
                return true;
            default:
                return false;
        }
    }
}
