package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class p extends n {
    final ActionProvider a;
    final /* synthetic */ o b;

    public p(o oVar, Context context, ActionProvider actionProvider) {
        this.b = oVar;
        super(context);
        this.a = actionProvider;
    }

    public boolean hasSubMenu() {
        return this.a.hasSubMenu();
    }

    public View onCreateActionView() {
        return this.a.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return this.a.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        this.a.onPrepareSubMenu(this.b.a(subMenu));
    }
}
