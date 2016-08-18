package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.p;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class u extends p implements VisibilityListener {
    p c;
    final /* synthetic */ t d;

    public u(t tVar, Context context, ActionProvider actionProvider) {
        this.d = tVar;
        super(tVar, context, actionProvider);
    }

    public final boolean isVisible() {
        return this.a.isVisible();
    }

    public final void onActionProviderVisibilityChanged(boolean z) {
        if (this.c != null) {
            this.c.a();
        }
    }

    public final View onCreateActionView(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public final boolean overridesItemVisibility() {
        return this.a.overridesItemVisibility();
    }

    public final void refreshVisibility() {
        this.a.refreshVisibility();
    }

    public final void setVisibilityListener(p pVar) {
        VisibilityListener visibilityListener;
        this.c = pVar;
        ActionProvider actionProvider = this.a;
        if (pVar == null) {
            visibilityListener = null;
        }
        actionProvider.setVisibilityListener(visibilityListener);
    }
}
