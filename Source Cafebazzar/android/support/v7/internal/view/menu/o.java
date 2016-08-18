package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.d.a.b;
import android.support.v4.view.n;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
public class o extends e implements MenuItem {
    public Method e;

    o(Context context, b bVar) {
        super(context, bVar);
    }

    p a(ActionProvider actionProvider) {
        return new p(this, this.a, actionProvider);
    }

    public boolean collapseActionView() {
        return ((b) this.d).collapseActionView();
    }

    public boolean expandActionView() {
        return ((b) this.d).expandActionView();
    }

    public ActionProvider getActionProvider() {
        n a = ((b) this.d).a();
        return a instanceof p ? ((p) a).a : null;
    }

    public View getActionView() {
        View actionView = ((b) this.d).getActionView();
        return actionView instanceof q ? (View) ((q) actionView).a : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((b) this.d).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((b) this.d).getGroupId();
    }

    public Drawable getIcon() {
        return ((b) this.d).getIcon();
    }

    public Intent getIntent() {
        return ((b) this.d).getIntent();
    }

    public int getItemId() {
        return ((b) this.d).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((b) this.d).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((b) this.d).getNumericShortcut();
    }

    public int getOrder() {
        return ((b) this.d).getOrder();
    }

    public SubMenu getSubMenu() {
        return a(((b) this.d).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((b) this.d).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((b) this.d).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((b) this.d).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((b) this.d).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((b) this.d).isCheckable();
    }

    public boolean isChecked() {
        return ((b) this.d).isChecked();
    }

    public boolean isEnabled() {
        return ((b) this.d).isEnabled();
    }

    public boolean isVisible() {
        return ((b) this.d).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((b) this.d).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((b) this.d).setActionView(i);
        View actionView = ((b) this.d).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((b) this.d).setActionView(new q(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new q(view);
        }
        ((b) this.d).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((b) this.d).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((b) this.d).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((b) this.d).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((b) this.d).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((b) this.d).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((b) this.d).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((b) this.d).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((b) this.d).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((b) this.d).a(onActionExpandListener != null ? new r(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((b) this.d).setOnMenuItemClickListener(onMenuItemClickListener != null ? new s(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((b) this.d).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((b) this.d).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((b) this.d).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((b) this.d).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((b) this.d).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((b) this.d).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((b) this.d).setVisible(z);
    }
}
