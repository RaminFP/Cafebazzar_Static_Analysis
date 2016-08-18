package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.e.a;
import android.support.v7.internal.view.menu.ab;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
public final class d extends ActionMode {
    final Context a;
    final a b;

    public d(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public final void finish() {
        this.b.c();
    }

    public final View getCustomView() {
        return this.b.i();
    }

    public final Menu getMenu() {
        return ab.a(this.a, (android.support.v4.d.a.a) this.b.b());
    }

    public final MenuInflater getMenuInflater() {
        return this.b.a();
    }

    public final CharSequence getSubtitle() {
        return this.b.g();
    }

    public final Object getTag() {
        return this.b.b;
    }

    public final CharSequence getTitle() {
        return this.b.f();
    }

    public final boolean getTitleOptionalHint() {
        return this.b.c;
    }

    public final void invalidate() {
        this.b.d();
    }

    public final boolean isTitleOptional() {
        return this.b.h();
    }

    public final void setCustomView(View view) {
        this.b.a(view);
    }

    public final void setSubtitle(int i) {
        this.b.b(i);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public final void setTag(Object obj) {
        this.b.b = obj;
    }

    public final void setTitle(int i) {
        this.b.a(i);
    }

    public final void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public final void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }
}
