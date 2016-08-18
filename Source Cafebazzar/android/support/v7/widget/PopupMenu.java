package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.b;
import android.support.v7.internal.view.f;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.v;
import android.support.v7.internal.view.menu.y;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu implements j, y {
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private OnTouchListener mDragListener;
    private i mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private v mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, b.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.mMenu = new i(context);
        this.mMenu.a((j) this);
        this.mAnchor = view;
        this.mPopup = new v(context, this.mMenu, view, false, i2, i3);
        this.mPopup.setGravity(i);
        this.mPopup.setCallback(this);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ForwardingListener(this.mAnchor) {
                public ListPopupWindow getPopup() {
                    return PopupMenu.this.mPopup.getPopup();
                }

                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new f(this.mContext);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void onCloseMenu(i iVar, boolean z) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss(this);
        }
    }

    public void onCloseSubMenu(ad adVar) {
    }

    public boolean onMenuItemSelected(i iVar, MenuItem menuItem) {
        return this.mMenuItemClickListener != null ? this.mMenuItemClickListener.onMenuItemClick(menuItem) : false;
    }

    public void onMenuModeChange(i iVar) {
    }

    public boolean onOpenSubMenu(i iVar) {
        if (iVar == null) {
            return false;
        }
        if (!iVar.hasVisibleItems()) {
            return true;
        }
        new v(this.mContext, iVar, this.mAnchor).show();
        return true;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
