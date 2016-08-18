package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.v4.view.bp;
import android.support.v7.a.g;
import android.support.v7.e.a;
import android.support.v7.e.b;
import android.support.v7.internal.view.c;
import android.support.v7.internal.view.e;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window.Callback;
import android.widget.PopupWindow;

final class u extends r {
    final /* synthetic */ t b;

    u(t tVar, Callback callback) {
        this.b = tVar;
        super(tVar, callback);
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (!this.b.n) {
            return super.onWindowStartingActionMode(callback);
        }
        Object eVar = new e(this.b.a, callback);
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.b;
        if (appCompatDelegateImplV7.o != null) {
            appCompatDelegateImplV7.o.c();
        }
        b aaVar = new aa(appCompatDelegateImplV7, eVar);
        a e = appCompatDelegateImplV7.e();
        if (e != null) {
            appCompatDelegateImplV7.o = e.a(aaVar);
        }
        if (appCompatDelegateImplV7.o == null) {
            if (appCompatDelegateImplV7.o != null) {
                appCompatDelegateImplV7.o.c();
            }
            b aaVar2 = new aa(appCompatDelegateImplV7, aaVar);
            if (appCompatDelegateImplV7.p == null) {
                if (appCompatDelegateImplV7.j) {
                    Context bVar;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = appCompatDelegateImplV7.a.getTheme();
                    theme.resolveAttribute(android.support.v7.a.b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = appCompatDelegateImplV7.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        bVar = new android.support.v7.internal.view.b(appCompatDelegateImplV7.a, 0);
                        bVar.getTheme().setTo(newTheme);
                    } else {
                        bVar = appCompatDelegateImplV7.a;
                    }
                    appCompatDelegateImplV7.p = new ActionBarContextView(bVar);
                    appCompatDelegateImplV7.q = new PopupWindow(bVar, null, android.support.v7.a.b.actionModePopupWindowStyle);
                    appCompatDelegateImplV7.q.setContentView(appCompatDelegateImplV7.p);
                    appCompatDelegateImplV7.q.setWidth(-1);
                    bVar.getTheme().resolveAttribute(android.support.v7.a.b.actionBarSize, typedValue, true);
                    appCompatDelegateImplV7.p.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, bVar.getResources().getDisplayMetrics()));
                    appCompatDelegateImplV7.q.setHeight(-2);
                    appCompatDelegateImplV7.r = new y(appCompatDelegateImplV7);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImplV7.s.findViewById(g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(appCompatDelegateImplV7.f()));
                        appCompatDelegateImplV7.p = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (appCompatDelegateImplV7.p != null) {
                appCompatDelegateImplV7.p.c();
                a cVar = new c(appCompatDelegateImplV7.p.getContext(), appCompatDelegateImplV7.p, aaVar2, appCompatDelegateImplV7.q == null);
                if (aaVar.a(cVar, cVar.b())) {
                    cVar.d();
                    appCompatDelegateImplV7.p.a(cVar);
                    appCompatDelegateImplV7.p.setVisibility(0);
                    appCompatDelegateImplV7.o = cVar;
                    if (appCompatDelegateImplV7.q != null) {
                        appCompatDelegateImplV7.b.getDecorView().post(appCompatDelegateImplV7.r);
                    }
                    appCompatDelegateImplV7.p.sendAccessibilityEvent(32);
                    if (appCompatDelegateImplV7.p.getParent() != null) {
                        bp.u((View) appCompatDelegateImplV7.p.getParent());
                    }
                } else {
                    appCompatDelegateImplV7.o = null;
                }
            }
            appCompatDelegateImplV7.o = appCompatDelegateImplV7.o;
        }
        a aVar = appCompatDelegateImplV7.o;
        return aVar != null ? eVar.b(aVar) : null;
    }
}
