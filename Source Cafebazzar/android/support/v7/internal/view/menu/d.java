package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.bp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class d implements x {
    private y mCallback;
    public Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    public i mMenu;
    private int mMenuLayoutRes;
    public z mMenuView;
    public Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public d(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    protected void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    public abstract void bindItemView(m mVar, aa aaVar);

    public boolean collapseItemActionView(i iVar, m mVar) {
        return false;
    }

    public aa createItemView(ViewGroup viewGroup) {
        return (aa) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public boolean expandItemActionView(i iVar, m mVar) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public y getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(m mVar, View view, ViewGroup viewGroup) {
        aa createItemView = view instanceof aa ? (aa) view : createItemView(viewGroup);
        bindItemView(mVar, createItemView);
        return (View) createItemView;
    }

    public z getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (z) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context context, i iVar) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMenu = iVar;
    }

    public void onCloseMenu(i iVar, boolean z) {
        if (this.mCallback != null) {
            this.mCallback.onCloseMenu(iVar, z);
        }
    }

    public boolean onSubMenuSelected(ad adVar) {
        return this.mCallback != null ? this.mCallback.onOpenSubMenu(adVar) : false;
    }

    public void setCallback(y yVar) {
        this.mCallback = yVar;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public boolean shouldIncludeItem(int i, m mVar) {
        return true;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            int i;
            if (this.mMenu != null) {
                this.mMenu.i();
                ArrayList h = this.mMenu.h();
                int size = h.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    m mVar = (m) h.get(i2);
                    if (shouldIncludeItem(i, mVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        m itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View itemView = getItemView(mVar, childAt, viewGroup);
                        if (mVar != itemData) {
                            itemView.setPressed(false);
                            bp.w(itemView);
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i)) {
                    i++;
                }
            }
        }
    }
}
