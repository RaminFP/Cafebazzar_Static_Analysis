package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class ad extends i implements SubMenu {
    public i l;
    private m m;

    public ad(Context context, i iVar, m mVar) {
        super(context);
        this.l = iVar;
        this.m = mVar;
    }

    public final String a() {
        int itemId = this.m != null ? this.m.getItemId() : 0;
        return itemId == 0 ? null : super.a() + ":" + itemId;
    }

    public final void a(j jVar) {
        this.l.a(jVar);
    }

    final boolean a(i iVar, MenuItem menuItem) {
        return super.a(iVar, menuItem) || this.l.a(iVar, menuItem);
    }

    public final boolean a(m mVar) {
        return this.l.a(mVar);
    }

    public final boolean b() {
        return this.l.b();
    }

    public final boolean b(m mVar) {
        return this.l.b(mVar);
    }

    public final boolean c() {
        return this.l.c();
    }

    public final MenuItem getItem() {
        return this.m;
    }

    public final i k() {
        return this.l;
    }

    public final SubMenu setHeaderIcon(int i) {
        super.a(a.getDrawable(this.a, i));
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(int i) {
        super.a(this.a.getResources().getString(i));
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        super.a(0, null, 0, null, view);
        return this;
    }

    public final SubMenu setIcon(int i) {
        this.m.setIcon(i);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.m.setIcon(drawable);
        return this;
    }

    public final void setQwertyMode(boolean z) {
        this.l.setQwertyMode(z);
    }
}
