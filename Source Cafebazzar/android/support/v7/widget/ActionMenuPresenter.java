package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.c.a.a;
import android.support.v4.view.ch;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v7.a.b;
import android.support.v7.a.h;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.aa;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.internal.view.menu.c;
import android.support.v7.internal.view.menu.d;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.v;
import android.support.v7.internal.view.menu.y;
import android.support.v7.internal.view.menu.z;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class ActionMenuPresenter extends d implements o {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    class ActionButtonSubmenu extends v {
        private ad mSubMenu;
        final /* synthetic */ ActionMenuPresenter this$0;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, ad adVar) {
            boolean z = false;
            this.this$0 = actionMenuPresenter;
            super(context, adVar, null, false, b.actionOverflowMenuStyle);
            this.mSubMenu = adVar;
            if (!((m) adVar.getItem()).f()) {
                setAnchorView(actionMenuPresenter.mOverflowButton == null ? (View) actionMenuPresenter.mMenuView : actionMenuPresenter.mOverflowButton);
            }
            setCallback(actionMenuPresenter.mPopupPresenterCallback);
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            setForceShowIcon(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.this$0.mActionButtonPopup = null;
            this.this$0.mOpenSubMenuId = 0;
        }
    }

    class ActionMenuPopupCallback extends c {
        private ActionMenuPopupCallback() {
        }

        public ListPopupWindow getPopup() {
            return ActionMenuPresenter.this.mActionButtonPopup != null ? ActionMenuPresenter.this.mActionButtonPopup.getPopup() : null;
        }
    }

    class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            i access$800 = ActionMenuPresenter.this.mMenu;
            if (access$800.b != null) {
                access$800.b.onMenuModeChange(access$800);
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    class OverflowMenuButton extends TintImageView implements ActionMenuChildView {
        private final float[] mTempPts = new float[2];

        public OverflowMenuButton(Context context) {
            super(context, null, b.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ListPopupWindow getPopup() {
                    return ActionMenuPresenter.this.mOverflowPopup == null ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup();
                }

                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public boolean onForwardingStopped() {
                    if (ActionMenuPresenter.this.mPostedOpenRunnable != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    class OverflowPopup extends v {
        public OverflowPopup(Context context, i iVar, View view, boolean z) {
            super(context, iVar, view, z, b.actionOverflowMenuStyle);
            setGravity(8388613);
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter.this.mMenu.close();
            ActionMenuPresenter.this.mOverflowPopup = null;
        }
    }

    class PopupPresenterCallback implements y {
        private PopupPresenterCallback() {
        }

        public void onCloseMenu(i iVar, boolean z) {
            if (iVar instanceof ad) {
                ((ad) iVar).l.a(false);
            }
            y callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(iVar, z);
            }
        }

        public boolean onOpenSubMenu(i iVar) {
            if (iVar == null) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((ad) iVar).getItem().getItemId();
            y callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(iVar) : false;
        }
    }

    class SavedState implements Parcelable {
        public static final Creator CREATOR = new Creator() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.i.abc_action_menu_layout, android.support.v7.a.i.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuItem) {
        View view;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            view = null;
        } else {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (i < childCount) {
                view = viewGroup.getChildAt(i);
                if (!(view instanceof aa) || ((aa) view).getItemData() != menuItem) {
                    i++;
                }
            }
            return null;
        }
        return view;
    }

    public void bindItemView(m mVar, aa aaVar) {
        aaVar.a(mVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.mOverflowButton ? false : super.filterLeftoverView(viewGroup, i);
    }

    public boolean flagActionItems() {
        int i;
        int i2;
        ArrayList h = this.mMenu.h();
        int size = h.size();
        int i3 = this.mMaxItems;
        int i4 = this.mActionItemWidthLimit;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            m mVar = (m) h.get(i7);
            if (mVar.h()) {
                i5++;
            } else if (mVar.g()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.mExpandedActionViewsExclusive && mVar.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.mReserveOverflow && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (this.mStrictWidthLimit) {
            i2 = i4 / this.mMinCellSize;
            i6 = ((i4 % this.mMinCellSize) / i2) + this.mMinCellSize;
            i = i2;
        } else {
            i6 = 0;
            i = 0;
        }
        i5 = 0;
        int i9 = 0;
        i2 = i;
        while (i9 < size) {
            mVar = (m) h.get(i9);
            if (mVar.h()) {
                View itemView = getItemView(mVar, this.mScrapActionButtonView, viewGroup);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    i2 -= ActionMenuView.measureChildForCells(itemView, i6, i2, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i3 = itemView.getMeasuredWidth();
                if (i5 == 0) {
                    i5 = i3;
                }
                i7 = mVar.getGroupId();
                if (i7 != 0) {
                    sparseBooleanArray.put(i7, true);
                }
                mVar.d(true);
                i = i4 - i3;
                i3 = i2;
                i2 = i;
                i = i8;
            } else if (mVar.g()) {
                boolean z;
                int groupId = mVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i8 > 0 || z2) && i4 > 0 && (!this.mStrictWidthLimit || i2 > 0);
                if (z3) {
                    View itemView2 = getItemView(mVar, this.mScrapActionButtonView, viewGroup);
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = itemView2;
                    }
                    boolean z4;
                    if (this.mStrictWidthLimit) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i6, i2, makeMeasureSpec, 0);
                        i7 = i2 - measureChildForCells;
                        if (measureChildForCells == 0) {
                            i2 = 0;
                            i3 = i7;
                        } else {
                            z4 = z3;
                            i3 = i7;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i3 = i2;
                        z4 = z5;
                    }
                    i7 = itemView2.getMeasuredWidth();
                    i4 -= i7;
                    if (i5 == 0) {
                        i5 = i7;
                    }
                    int i10;
                    if (this.mStrictWidthLimit) {
                        z = i2 & (i4 >= 0 ? 1 : 0);
                        i7 = i5;
                        i10 = i4;
                        i4 = i3;
                        i3 = i10;
                    } else {
                        z = i2 & (i4 + i5 > 0 ? 1 : 0);
                        i7 = i5;
                        i10 = i4;
                        i4 = i3;
                        i3 = i10;
                    }
                } else {
                    z = z3;
                    i7 = i5;
                    i3 = i4;
                    i4 = i2;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i2 = i8;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i8;
                    for (i8 = 0; i8 < i9; i8++) {
                        m mVar2 = (m) h.get(i8);
                        if (mVar2.getGroupId() == groupId) {
                            if (mVar2.f()) {
                                i5++;
                            }
                            mVar2.d(false);
                        }
                    }
                    i2 = i5;
                } else {
                    i2 = i8;
                }
                if (z) {
                    i2--;
                }
                mVar.d(z);
                i = i2;
                i5 = i7;
                i2 = i3;
                i3 = i4;
            } else {
                mVar.d(false);
                i = i8;
                i3 = i2;
                i2 = i4;
            }
            i9++;
            i4 = i2;
            i8 = i;
            i2 = i3;
        }
        return true;
    }

    public View getItemView(m mVar, View view, ViewGroup viewGroup) {
        View actionView = mVar.getActionView();
        if (actionView == null || mVar.i()) {
            actionView = super.getItemView(mVar, view, viewGroup);
        }
        actionView.setVisibility(mVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public z getMenuView(ViewGroup viewGroup) {
        z menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable == null || this.mMenuView == null) {
            v vVar = this.mOverflowPopup;
            if (vVar == null) {
                return false;
            }
            vVar.dismiss();
            return true;
        }
        ((View) this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean hideSubMenus() {
        if (this.mActionButtonPopup == null) {
            return false;
        }
        this.mActionButtonPopup.dismiss();
        return true;
    }

    public void initForMenu(Context context, i iVar) {
        boolean z = true;
        super.initForMenu(context, iVar);
        Resources resources = context.getResources();
        android.support.v7.internal.view.a a = android.support.v7.internal.view.a.a(context);
        if (!this.mReserveOverflowSet) {
            if (VERSION.SDK_INT < 19 && ch.b(ViewConfiguration.get(a.a))) {
                z = false;
            }
            this.mReserveOverflow = z;
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = a.a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = a.a.getResources().getInteger(h.abc_max_action_buttons);
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (56.0f * resources.getDisplayMetrics().density);
        this.mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(i iVar, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(iVar, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = this.mContext.getResources().getInteger(h.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.b(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.openSubMenuId > 0) {
            MenuItem findItem = this.mMenu.findItem(savedState.openSubMenuId);
            if (findItem != null) {
                onSubMenuSelected((ad) findItem.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public boolean onSubMenuSelected(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        ad adVar2 = adVar;
        while (adVar2.l != this.mMenu) {
            adVar2 = (ad) adVar2.l;
        }
        View findViewForItem = findViewForItem(adVar2.getItem());
        if (findViewForItem == null) {
            if (this.mOverflowButton == null) {
                return false;
            }
            findViewForItem = this.mOverflowButton;
        }
        this.mOpenSubMenuId = adVar.getItem().getItemId();
        this.mActionButtonPopup = new ActionButtonSubmenu(this, this.mContext, adVar);
        this.mActionButtonPopup.setAnchorView(findViewForItem);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(adVar);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else {
            this.mMenu.a(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, m mVar) {
        return mVar.f();
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.mPostedOpenRunnable != null || this.mMenu.j().isEmpty()) {
            return false;
        }
        this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        ((View) this.mMenuView).post(this.mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2 = 0;
        ((View) this.mMenuView).getParent();
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            i iVar = this.mMenu;
            iVar.i();
            ArrayList arrayList = iVar.d;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                n nVar = ((m) arrayList.get(i)).d;
                if (nVar != null) {
                    nVar.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList j = this.mMenu != null ? this.mMenu.j() : null;
        if (this.mReserveOverflow && j != null) {
            i = j.size();
            if (i != 1) {
                i2 = i > 0 ? 1 : 0;
            } else if (!((m) j.get(0)).isActionViewExpanded()) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup) this.mMenuView).removeView(this.mOverflowButton);
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
