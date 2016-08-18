package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ao;
import android.support.v4.view.as;
import android.support.v4.view.ay;
import android.support.v4.view.bp;
import android.support.v4.view.v;
import android.support.v7.a.l;
import android.support.v7.app.b;
import android.support.v7.e.c;
import android.support.v7.internal.view.f;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.x;
import android.support.v7.internal.view.menu.y;
import android.support.v7.internal.view.menu.z;
import android.support.v7.internal.widget.aj;
import android.support.v7.internal.widget.aq;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.internal.widget.bl;
import android.support.v7.internal.widget.bq;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private y mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final aq mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private j mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList mTempViews;
    private final bi mTintManager;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private bl mWrapper;

    class ExpandedActionViewMenuPresenter implements x {
        m mCurrentExpandedItem;
        i mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(i iVar, m mVar) {
            if (Toolbar.this.mExpandedActionView instanceof c) {
                ((c) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.setChildVisibilityForExpandedActionView(false);
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            mVar.e(false);
            return true;
        }

        public boolean expandItemActionView(i iVar, m mVar) {
            Toolbar.this.ensureCollapseButtonView();
            if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = mVar.getActionView();
            this.mCurrentExpandedItem = mVar;
            if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
                android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.setChildVisibilityForExpandedActionView(true);
            Toolbar.this.requestLayout();
            mVar.e(true);
            if (Toolbar.this.mExpandedActionView instanceof c) {
                ((c) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public z getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, i iVar) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.b(this.mCurrentExpandedItem);
            }
            this.mMenu = iVar;
        }

        public void onCloseMenu(i iVar, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(ad adVar) {
            return false;
        }

        public void setCallback(y yVar) {
        }

        public void updateMenuView(boolean z) {
            Object obj = null;
            if (this.mCurrentExpandedItem != null) {
                if (this.mMenu != null) {
                    int size = this.mMenu.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }
    }

    public class LayoutParams extends b {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        public LayoutParams(b bVar) {
            super(bVar);
            this.mViewType = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((b) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        void copyMarginsFromCompat(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new Creator() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.b.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentInsets = new aq();
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new android.support.v7.widget.ActionMenuView.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return Toolbar.this.mOnMenuItemClickListener != null ? Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem) : false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        bk a = bk.a(getContext(), attributeSet, l.Toolbar, i, 0);
        this.mTitleTextAppearance = a.e(l.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a.e(l.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a.a.getInteger(l.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = 48;
        int b = a.b(l.Toolbar_titleMargins, 0);
        this.mTitleMarginBottom = b;
        this.mTitleMarginTop = b;
        this.mTitleMarginEnd = b;
        this.mTitleMarginStart = b;
        b = a.b(l.Toolbar_titleMarginStart, -1);
        if (b >= 0) {
            this.mTitleMarginStart = b;
        }
        b = a.b(l.Toolbar_titleMarginEnd, -1);
        if (b >= 0) {
            this.mTitleMarginEnd = b;
        }
        b = a.b(l.Toolbar_titleMarginTop, -1);
        if (b >= 0) {
            this.mTitleMarginTop = b;
        }
        b = a.b(l.Toolbar_titleMarginBottom, -1);
        if (b >= 0) {
            this.mTitleMarginBottom = b;
        }
        this.mMaxButtonHeight = a.c(l.Toolbar_maxButtonHeight, -1);
        b = a.b(l.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b2 = a.b(l.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.mContentInsets.b(a.c(l.Toolbar_contentInsetLeft, 0), a.c(l.Toolbar_contentInsetRight, 0));
        if (!(b == Integer.MIN_VALUE && b2 == Integer.MIN_VALUE)) {
            this.mContentInsets.a(b, b2);
        }
        this.mCollapseIcon = a.a(l.Toolbar_collapseIcon);
        this.mCollapseDescription = a.c(l.Toolbar_collapseContentDescription);
        CharSequence c = a.c(l.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.c(l.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a.e(l.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(l.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.c(l.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a.a.recycle();
        this.mTintManager = a.a();
    }

    private void addCustomViewsWithGravity(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (bp.h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = v.a(i, bp.h(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams.gravity) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private void addSystemView(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = generateLayoutParams(layoutParams);
        }
        layoutParams.mViewType = 1;
        addView(view, layoutParams);
    }

    private void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new ImageButton(getContext(), null, android.support.v7.a.b.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            i iVar = (i) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            iVar.a(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new ImageButton(getContext(), null, android.support.v7.a.b.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i) {
        int h = bp.h(this);
        int a = v.a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (getChildVerticalGravity(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.mGravity & 112;
        }
    }

    private int getHorizontalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return ao.b(marginLayoutParams) + ao.a(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new f(getContext());
    }

    private int getVerticalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private int getViewListMeasuredWidth(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i;
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = (View) list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i3 = layoutParams.leftMargin - i3;
            i4 = layoutParams.rightMargin - i4;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, i4);
            i = Math.max(0, -i3);
            i3 = Math.max(0, -i4);
            i5++;
            i6 = ((view.getMeasuredWidth() + max) + max2) + i6;
            i4 = i3;
            i3 = i;
        }
        return i6;
    }

    private static boolean isCustomView(View view) {
        return ((LayoutParams) view.getLayoutParams()).mViewType == 0;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private void setChildVisibilityForExpandedActionView(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                childAt.setVisibility(z ? 8 : 0);
            }
        }
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void updateChildVisibilityForExpandedActionView(View view) {
        if (((LayoutParams) view.getLayoutParams()).mViewType != 2 && view != this.mMenuView) {
            view.setVisibility(this.mExpandedActionView != null ? 8 : 0);
        }
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        m mVar = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (mVar != null) {
            mVar.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof b ? new LayoutParams((b) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getContentInsetEnd() {
        aq aqVar = this.mContentInsets;
        return aqVar.g ? aqVar.a : aqVar.b;
    }

    public int getContentInsetLeft() {
        return this.mContentInsets.a;
    }

    public int getContentInsetRight() {
        return this.mContentInsets.b;
    }

    public int getContentInsetStart() {
        aq aqVar = this.mContentInsets;
        return aqVar.g ? aqVar.b : aqVar.a;
    }

    public Drawable getLogo() {
        return this.mLogoView != null ? this.mLogoView.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public aj getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new bl(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout = this.mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (a == 10 || a == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = bp.h(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int q = bp.q(this);
        if (!shouldLayout(this.mNavButtonView)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = layoutChildRight(this.mNavButtonView, i8, iArr, q);
            i5 = paddingLeft;
        } else {
            i5 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, q);
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            if (obj != null) {
                i8 = layoutChildRight(this.mCollapseButtonView, i8, iArr, q);
            } else {
                i5 = layoutChildLeft(this.mCollapseButtonView, i5, iArr, q);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            if (obj != null) {
                i5 = layoutChildLeft(this.mMenuView, i5, iArr, q);
            } else {
                i8 = layoutChildRight(this.mMenuView, i8, iArr, q);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (shouldLayout(this.mExpandedActionView)) {
            if (obj != null) {
                i8 = layoutChildRight(this.mExpandedActionView, i8, iArr, q);
            } else {
                i5 = layoutChildLeft(this.mExpandedActionView, i5, iArr, q);
            }
        }
        if (!shouldLayout(this.mLogoView)) {
            i6 = i5;
            i7 = i8;
        } else if (obj != null) {
            i6 = i5;
            i7 = layoutChildRight(this.mLogoView, i8, iArr, q);
        } else {
            i6 = layoutChildLeft(this.mLogoView, i5, iArr, q);
            i7 = i8;
        }
        boolean shouldLayout = shouldLayout(this.mTitleTextView);
        boolean shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        i5 = 0;
        if (shouldLayout) {
            LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.mTitleTextView.getMeasuredHeight())) + 0;
        }
        if (shouldLayout2) {
            layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.mSubtitleTextView.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (shouldLayout || shouldLayout2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (shouldLayout ? this.mTitleTextView : this.mSubtitleTextView).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView).getLayoutParams();
            Object obj2 = ((!shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.mGravity & 112) {
                case 48:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.mTitleMarginTop;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.mTitleMarginBottom) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.mTitleMarginTop) {
                        i8 = layoutParams.topMargin + this.mTitleMarginTop;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < layoutParams.bottomMargin + this.mTitleMarginBottom ? Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.mTitleMarginBottom) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.mTitleMarginStart : 0) - iArr[1];
                i5 = i7 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (shouldLayout) {
                    layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    measuredWidth = i5 - this.mTitleTextView.getMeasuredWidth();
                    i7 = this.mTitleTextView.getMeasuredHeight() + paddingTop2;
                    this.mTitleTextView.layout(measuredWidth, paddingTop2, i5, i7);
                    paddingTop2 = i7 + layoutParams.bottomMargin;
                    measuredWidth -= this.mTitleMarginEnd;
                } else {
                    measuredWidth = i5;
                }
                if (shouldLayout2) {
                    layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    i7 = layoutParams.topMargin + paddingTop2;
                    this.mSubtitleTextView.layout(i5 - this.mSubtitleTextView.getMeasuredWidth(), i7, i5, this.mSubtitleTextView.getMeasuredHeight() + i7);
                    i7 = this.mTitleMarginEnd;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5 - i7;
                } else {
                    i8 = i5;
                }
                i7 = obj2 != null ? Math.min(measuredWidth, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.mTitleMarginStart : 0) - iArr[0];
                i6 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (shouldLayout) {
                    layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    i5 = this.mTitleTextView.getMeasuredWidth() + i6;
                    measuredWidth = this.mTitleTextView.getMeasuredHeight() + paddingTop2;
                    this.mTitleTextView.layout(i6, paddingTop2, i5, measuredWidth);
                    measuredWidth = layoutParams.bottomMargin + measuredWidth;
                    i5 += this.mTitleMarginEnd;
                } else {
                    i5 = i6;
                    measuredWidth = paddingTop2;
                }
                if (shouldLayout2) {
                    layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    measuredWidth += layoutParams.topMargin;
                    paddingTop2 = this.mSubtitleTextView.getMeasuredWidth() + i6;
                    this.mSubtitleTextView.layout(i6, measuredWidth, paddingTop2, this.mSubtitleTextView.getMeasuredHeight() + measuredWidth);
                    measuredWidth = this.mTitleMarginEnd;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth + paddingTop2;
                } else {
                    i8 = i6;
                }
                if (obj2 != null) {
                    i6 = Math.max(i5, i8);
                }
            }
        }
        addCustomViewsWithGravity(this.mTempViews, 3);
        int size = this.mTempViews.size();
        i5 = i6;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = layoutChildLeft((View) this.mTempViews.get(measuredWidth), i5, iArr, q);
        }
        addCustomViewsWithGravity(this.mTempViews, 5);
        i6 = this.mTempViews.size();
        for (measuredWidth = 0; measuredWidth < i6; measuredWidth++) {
            i7 = layoutChildRight((View) this.mTempViews.get(measuredWidth), i7, iArr, q);
        }
        addCustomViewsWithGravity(this.mTempViews, 1);
        measuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i7) {
            i8 -= measuredWidth - i7;
        }
        paddingLeft = this.mTempViews.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            i8 = layoutChildLeft((View) this.mTempViews.get(measuredWidth), i5, iArr, q);
            measuredWidth++;
            i5 = i8;
        }
        this.mTempViews.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredWidth;
        int max;
        int a;
        int i5;
        int[] iArr = this.mTempMargins;
        if (bq.a(this)) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            measuredWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            max = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            a = bq.a(0, bp.k(this.mNavButtonView));
            i5 = measuredWidth;
        } else {
            max = 0;
            a = 0;
            i5 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            max = Math.max(max, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            a = bq.a(a, bp.k(this.mCollapseButtonView));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = Math.max(contentInsetStart, i5) + 0;
        iArr[i3] = Math.max(0, contentInsetStart - i5);
        i5 = 0;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max2, i2, 0, this.mMaxButtonHeight);
            i5 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            max = Math.max(max, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            a = bq.a(a, bp.k(this.mMenuView));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i5);
        iArr[i4] = Math.max(0, contentInsetStart - i5);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            max = Math.max(max, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            a = bq.a(a, bp.k(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            max = Math.max(max, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            a = bq.a(a, bp.k(this.mLogoView));
        }
        i4 = getChildCount();
        i3 = 0;
        int i6 = max;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                max2 += measureChildCollapseMargins(childAt, i, max2, i2, 0, iArr);
                measuredWidth = Math.max(i6, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i5 = bq.a(a, bp.k(childAt));
                contentInsetStart = measuredWidth;
            } else {
                i5 = a;
                contentInsetStart = i6;
            }
            i3++;
            i6 = contentInsetStart;
            a = i5;
        }
        i5 = 0;
        contentInsetStart = 0;
        max = this.mTitleMarginTop + this.mTitleMarginBottom;
        measuredWidth = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, max2 + measuredWidth, i2, max, iArr);
            i5 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            contentInsetStart = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            a = bq.a(a, bp.k(this.mTitleTextView));
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i5 = Math.max(i5, measureChildCollapseMargins(this.mSubtitleTextView, i, max2 + measuredWidth, i2, max + contentInsetStart, iArr));
            contentInsetStart += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            a = bq.a(a, bp.k(this.mSubtitleTextView));
        }
        contentInsetStart = Math.max(i6, contentInsetStart);
        measuredWidth = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        measuredWidth = bp.a(Math.max((i5 + max2) + (measuredWidth + paddingRight), getSuggestedMinimumWidth()), i, -16777216 & a);
        i5 = bp.a(Math.max((paddingTop + paddingBottom) + contentInsetStart, getSuggestedMinimumHeight()), i2, a << 16);
        if (shouldCollapse()) {
            i5 = 0;
        }
        setMeasuredDimension(measuredWidth, i5);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Menu peekMenu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
        if (!(savedState.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || peekMenu == null)) {
            MenuItem findItem = peekMenu.findItem(savedState.expandedMenuItemId);
            if (findItem != null) {
                as.b(findItem);
            }
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        aq aqVar = this.mContentInsets;
        if (i != 1) {
            z = false;
        }
        if (z != aqVar.g) {
            aqVar.g = z;
            if (!aqVar.h) {
                aqVar.a = aqVar.e;
                aqVar.b = aqVar.f;
            } else if (z) {
                aqVar.a = aqVar.d != Integer.MIN_VALUE ? aqVar.d : aqVar.e;
                aqVar.b = aqVar.c != Integer.MIN_VALUE ? aqVar.c : aqVar.f;
            } else {
                aqVar.a = aqVar.c != Integer.MIN_VALUE ? aqVar.c : aqVar.e;
                aqVar.b = aqVar.d != Integer.MIN_VALUE ? aqVar.d : aqVar.f;
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ay.a(motionEvent);
        if (a == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (a == 1 || a == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.mContentInsets.b(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mContentInsets.a(i, i2);
    }

    public void setLogo(int i) {
        setLogo(this.mTintManager.a(i, false));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (this.mLogoView.getParent() == null) {
                addSystemView(this.mLogoView);
                updateChildVisibilityForExpandedActionView(this.mLogoView);
            }
        } else if (!(this.mLogoView == null || this.mLogoView.getParent() == null)) {
            removeView(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public void setMenu(i iVar, ActionMenuPresenter actionMenuPresenter) {
        if (iVar != null || this.mMenuView != null) {
            ensureMenuView();
            i peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != iVar) {
                if (peekMenu != null) {
                    peekMenu.b(this.mOuterActionMenuPresenter);
                    peekMenu.b(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (iVar != null) {
                    iVar.a((x) actionMenuPresenter, this.mPopupContext);
                    iVar.a(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }

    public void setMenuCallbacks(y yVar, j jVar) {
        this.mActionMenuPresenterCallback = yVar;
        this.mMenuBuilderCallback = jVar;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.mTintManager.a(i, false));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (this.mNavButtonView.getParent() == null) {
                addSystemView(this.mNavButtonView);
                updateChildVisibilityForExpandedActionView(this.mNavButtonView);
            }
        } else if (!(this.mNavButtonView == null || this.mNavButtonView.getParent() == null)) {
            removeView(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new TextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (this.mSubtitleTextView.getParent() == null) {
                addSystemView(this.mSubtitleTextView);
                updateChildVisibilityForExpandedActionView(this.mSubtitleTextView);
            }
        } else if (!(this.mSubtitleTextView == null || this.mSubtitleTextView.getParent() == null)) {
            removeView(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.mSubtitleTextColor = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new TextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (this.mTitleTextView.getParent() == null) {
                addSystemView(this.mTitleTextView);
                updateChildVisibilityForExpandedActionView(this.mTitleTextView);
            }
        } else if (!(this.mTitleTextView == null || this.mTitleTextView.getParent() == null)) {
            removeView(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(i);
        }
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }
}
