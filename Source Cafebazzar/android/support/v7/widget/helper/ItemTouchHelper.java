package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.a.a;
import android.support.v4.a.b;
import android.support.v4.a.d;
import android.support.v4.a.l;
import android.support.v4.view.ay;
import android.support.v4.view.bl;
import android.support.v4.view.bp;
import android.support.v4.view.q;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends ItemDecoration implements OnChildAttachStateChangeListener {
    private static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    private static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    private static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    int mActionState = 0;
    int mActivePointerId = -1;
    Callback mCallback;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    private q mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final OnItemTouchListener mOnItemTouchListener = new OnItemTouchListener() {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.a(motionEvent);
            int a = ay.a(motionEvent);
            if (a == 0) {
                ItemTouchHelper.this.mActivePointerId = ay.b(motionEvent, 0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                if (ItemTouchHelper.this.mSelected == null) {
                    RecoverAnimation access$600 = ItemTouchHelper.this.findAnimation(motionEvent);
                    if (access$600 != null) {
                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.mInitialTouchX -= access$600.mX;
                        itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.mInitialTouchY -= access$600.mY;
                        ItemTouchHelper.this.endRecoverAnimation(access$600.mViewHolder, true);
                        if (ItemTouchHelper.this.mPendingCleanup.remove(access$600.mViewHolder.itemView)) {
                            ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, access$600.mViewHolder);
                        }
                        ItemTouchHelper.this.select(access$600.mViewHolder, access$600.mActionState);
                        ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, 0);
                    }
                }
            } else if (a == 3 || a == 1) {
                ItemTouchHelper.this.mActivePointerId = -1;
                ItemTouchHelper.this.select(null, 0);
            } else if (ItemTouchHelper.this.mActivePointerId != -1) {
                int a2 = ay.a(motionEvent, ItemTouchHelper.this.mActivePointerId);
                if (a2 >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(a, motionEvent, a2);
                }
            }
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.mSelected != null ? true : ItemTouchHelper.DEBUG;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select(null, 0);
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int i = 0;
            ItemTouchHelper.this.mGestureDetector.a(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int a = ay.a(motionEvent);
                int a2 = ay.a(motionEvent, ItemTouchHelper.this.mActivePointerId);
                if (a2 >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(a, motionEvent, a2);
                }
                ViewHolder viewHolder = ItemTouchHelper.this.mSelected;
                if (viewHolder != null) {
                    switch (a) {
                        case 1:
                            break;
                        case 2:
                            if (a2 >= 0) {
                                ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, a2);
                                ItemTouchHelper.this.moveIfNecessary(viewHolder);
                                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                                ItemTouchHelper.this.mScrollRunnable.run();
                                ItemTouchHelper.this.mRecyclerView.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (ItemTouchHelper.this.mVelocityTracker != null) {
                                ItemTouchHelper.this.mVelocityTracker.clear();
                                break;
                            }
                            break;
                        case 6:
                            a = ay.b(motionEvent);
                            if (ay.b(motionEvent, a) == ItemTouchHelper.this.mActivePointerId) {
                                if (a == 0) {
                                    i = 1;
                                }
                                ItemTouchHelper.this.mActivePointerId = ay.b(motionEvent, i);
                                ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, a);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    ItemTouchHelper.this.select(null, 0);
                    ItemTouchHelper.this.mActivePointerId = -1;
                }
            }
        }
    };
    private View mOverdrawChild = null;
    private int mOverdrawChildPosition = -1;
    final List mPendingCleanup = new ArrayList();
    List mRecoverAnimations = new ArrayList();
    private RecyclerView mRecyclerView;
    private final Runnable mScrollRunnable = new Runnable() {
        public void run() {
            if (ItemTouchHelper.this.mSelected != null && ItemTouchHelper.this.scrollIfNecessary()) {
                if (ItemTouchHelper.this.mSelected != null) {
                    ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
                }
                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                bp.a(ItemTouchHelper.this.mRecyclerView, (Runnable) this);
            }
        }
    };
    ViewHolder mSelected = null;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    private VelocityTracker mVelocityTracker;

    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    class RecoverAnimation implements b {
        final int mActionState;
        private final int mAnimationType;
        private boolean mEnded = ItemTouchHelper.DEBUG;
        private float mFraction;
        public boolean mIsPendingCleanup;
        boolean mOverridden = ItemTouchHelper.DEBUG;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final l mValueAnimator;
        final ViewHolder mViewHolder;
        float mX;
        float mY;

        public RecoverAnimation(ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            this.mValueAnimator = a.a();
            this.mValueAnimator.a(new d(ItemTouchHelper.this) {
                public void onAnimationUpdate(l lVar) {
                    RecoverAnimation.this.setFraction(lVar.d());
                }
            });
            this.mValueAnimator.a(viewHolder.itemView);
            this.mValueAnimator.a((b) this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.c();
        }

        public void onAnimationCancel(l lVar) {
            setFraction(1.0f);
        }

        public void onAnimationEnd(l lVar) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void onAnimationRepeat(l lVar) {
        }

        public void onAnimationStart(l lVar) {
        }

        public void setDuration(long j) {
            this.mValueAnimator.a(j);
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(ItemTouchHelper.DEBUG);
            this.mValueAnimator.a();
        }

        public void update() {
            if (this.mStartDx == this.mTargetX) {
                this.mX = bp.n(this.mViewHolder.itemView);
            } else {
                this.mX = this.mStartDx + (this.mFraction * (this.mTargetX - this.mStartDx));
            }
            if (this.mStartDy == this.mTargetY) {
                this.mY = bp.o(this.mViewHolder.itemView);
            } else {
                this.mY = this.mStartDy + (this.mFraction * (this.mTargetY - this.mStartDy));
            }
        }
    }

    public abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() {
            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        };
        private static final ItemTouchUIUtil sUICallback;
        private int mCachedMaxScrollSpeed = -1;

        static {
            if (VERSION.SDK_INT >= 21) {
                sUICallback = new Lollipop();
            } else if (VERSION.SDK_INT >= 11) {
                sUICallback = new Honeycomb();
            } else {
                sUICallback = new Gingerbread();
            }
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            return i2 == 0 ? i4 | (i3 << 2) : (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & ABS_HORIZONTAL_DIR_FLAGS) << 2);
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return sUICallback;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(android.support.v7.c.b.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        private boolean hasDragFlag(RecyclerView recyclerView, ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0 ? true : ItemTouchHelper.DEBUG;
        }

        private boolean hasSwipeFlag(RecyclerView recyclerView, ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_SWIPE_MASK) != 0 ? true : ItemTouchHelper.DEBUG;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i << 3);
        }

        public static int makeMovementFlags(int i, int i2) {
            return (makeFlag(0, i2 | i) | makeFlag(1, i2)) | makeFlag(2, i);
        }

        private void onDraw(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i2);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, ItemTouchHelper.DEBUG);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                i2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
        }

        private void onDrawOver(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List list, int i, float f, float f2) {
            int i2;
            int size = list.size();
            for (i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, ItemTouchHelper.DEBUG);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                i2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(i2);
            }
            Object obj = null;
            int i3 = size - 1;
            while (i3 >= 0) {
                Object obj2;
                recoverAnimation = (RecoverAnimation) list.get(i3);
                if (!recoverAnimation.mEnded || recoverAnimation.mIsPendingCleanup) {
                    obj2 = !recoverAnimation.mEnded ? 1 : obj;
                } else {
                    list.remove(i3);
                    obj2 = obj;
                }
                i3--;
                obj = obj2;
            }
            if (obj != null) {
                recyclerView.invalidate();
            }
        }

        public boolean canDropOver(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2) {
            return true;
        }

        public ViewHolder chooseDropTarget(ViewHolder viewHolder, List list, int i, int i2) {
            int width = viewHolder.itemView.getWidth();
            int height = viewHolder.itemView.getHeight();
            ViewHolder viewHolder2 = null;
            int i3 = -1;
            int left = i - viewHolder.itemView.getLeft();
            int top = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int right;
                int i5;
                ViewHolder viewHolder3 = (ViewHolder) list.get(i4);
                if (left > 0) {
                    right = viewHolder3.itemView.getRight() - (i + width);
                    if (right < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            viewHolder2 = viewHolder3;
                            if (left < 0) {
                                i3 = viewHolder3.itemView.getLeft() - i;
                                if (i3 > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > right) {
                                        viewHolder2 = viewHolder3;
                                        if (top < 0) {
                                            right = viewHolder3.itemView.getTop() - i2;
                                            if (right > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop()) {
                                                right = Math.abs(right);
                                                if (right > i3) {
                                                    viewHolder2 = viewHolder3;
                                                    if (top > 0) {
                                                        i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                                                        if (i3 < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > right) {
                                                                i5 = i3;
                                                                i4++;
                                                                i3 = i5;
                                                                viewHolder2 = viewHolder3;
                                                            }
                                                        }
                                                    }
                                                    viewHolder3 = viewHolder2;
                                                    i5 = right;
                                                    i4++;
                                                    i3 = i5;
                                                    viewHolder2 = viewHolder3;
                                                }
                                            }
                                        }
                                        right = i3;
                                        if (top > 0) {
                                            i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                                            i3 = Math.abs(i3);
                                            if (i3 > right) {
                                                i5 = i3;
                                                i4++;
                                                i3 = i5;
                                                viewHolder2 = viewHolder3;
                                            }
                                        }
                                        viewHolder3 = viewHolder2;
                                        i5 = right;
                                        i4++;
                                        i3 = i5;
                                        viewHolder2 = viewHolder3;
                                    }
                                }
                            }
                            i3 = right;
                            if (top < 0) {
                                right = viewHolder3.itemView.getTop() - i2;
                                right = Math.abs(right);
                                if (right > i3) {
                                    viewHolder2 = viewHolder3;
                                    if (top > 0) {
                                        i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                                        i3 = Math.abs(i3);
                                        if (i3 > right) {
                                            i5 = i3;
                                            i4++;
                                            i3 = i5;
                                            viewHolder2 = viewHolder3;
                                        }
                                    }
                                    viewHolder3 = viewHolder2;
                                    i5 = right;
                                    i4++;
                                    i3 = i5;
                                    viewHolder2 = viewHolder3;
                                }
                            }
                            right = i3;
                            if (top > 0) {
                                i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                                i3 = Math.abs(i3);
                                if (i3 > right) {
                                    i5 = i3;
                                    i4++;
                                    i3 = i5;
                                    viewHolder2 = viewHolder3;
                                }
                            }
                            viewHolder3 = viewHolder2;
                            i5 = right;
                            i4++;
                            i3 = i5;
                            viewHolder2 = viewHolder3;
                        }
                    }
                }
                right = i3;
                if (left < 0) {
                    i3 = viewHolder3.itemView.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > right) {
                        viewHolder2 = viewHolder3;
                        if (top < 0) {
                            right = viewHolder3.itemView.getTop() - i2;
                            right = Math.abs(right);
                            if (right > i3) {
                                viewHolder2 = viewHolder3;
                                if (top > 0) {
                                    i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                                    i3 = Math.abs(i3);
                                    if (i3 > right) {
                                        i5 = i3;
                                        i4++;
                                        i3 = i5;
                                        viewHolder2 = viewHolder3;
                                    }
                                }
                                viewHolder3 = viewHolder2;
                                i5 = right;
                                i4++;
                                i3 = i5;
                                viewHolder2 = viewHolder3;
                            }
                        }
                        right = i3;
                        if (top > 0) {
                            i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                            i3 = Math.abs(i3);
                            if (i3 > right) {
                                i5 = i3;
                                i4++;
                                i3 = i5;
                                viewHolder2 = viewHolder3;
                            }
                        }
                        viewHolder3 = viewHolder2;
                        i5 = right;
                        i4++;
                        i3 = i5;
                        viewHolder2 = viewHolder3;
                    }
                }
                i3 = right;
                if (top < 0) {
                    right = viewHolder3.itemView.getTop() - i2;
                    right = Math.abs(right);
                    if (right > i3) {
                        viewHolder2 = viewHolder3;
                        if (top > 0) {
                            i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                            i3 = Math.abs(i3);
                            if (i3 > right) {
                                i5 = i3;
                                i4++;
                                i3 = i5;
                                viewHolder2 = viewHolder3;
                            }
                        }
                        viewHolder3 = viewHolder2;
                        i5 = right;
                        i4++;
                        i3 = i5;
                        viewHolder2 = viewHolder3;
                    }
                }
                right = i3;
                if (top > 0) {
                    i3 = viewHolder3.itemView.getBottom() - (i2 + height);
                    i3 = Math.abs(i3);
                    if (i3 > right) {
                        i5 = i3;
                        i4++;
                        i3 = i5;
                        viewHolder2 = viewHolder3;
                    }
                }
                viewHolder3 = viewHolder2;
                i5 = right;
                i4++;
                i3 = i5;
                viewHolder2 = viewHolder3;
            }
            return viewHolder2;
        }

        public void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
            sUICallback.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3 = i & RELATIVE_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            return i2 == 0 ? i4 | (i3 >> 2) : (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & RELATIVE_DIR_FLAGS) >> 2);
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), bp.h(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200 : 250 : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int maxDragScroll = (int) (((float) (getMaxDragScroll(recyclerView) * ((int) Math.signum((float) i2)))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (sDragScrollInterpolator.getInterpolation(f) * ((float) maxDragScroll));
            return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public abstract boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2);

        public void onMoved(RecyclerView recyclerView, ViewHolder viewHolder, int i, ViewHolder viewHolder2, int i2, int i3, int i4) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                sUICallback.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(ViewHolder viewHolder, int i);
    }

    class ItemTouchHelperGestureListener extends SimpleOnGestureListener {
        private ItemTouchHelperGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View access$2400 = ItemTouchHelper.this.findChildView(motionEvent);
            if (access$2400 != null) {
                ViewHolder childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(access$2400);
                if (childViewHolder != null && ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, childViewHolder) && ay.b(motionEvent, 0) == ItemTouchHelper.this.mActivePointerId) {
                    int a = ay.a(motionEvent, ItemTouchHelper.this.mActivePointerId);
                    float c = ay.c(motionEvent, a);
                    float d = ay.d(motionEvent, a);
                    ItemTouchHelper.this.mInitialTouchX = c;
                    ItemTouchHelper.this.mInitialTouchY = d;
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    ItemTouchHelper.this.mDy = 0.0f;
                    itemTouchHelper.mDx = 0.0f;
                    if (ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    public abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public int getDragDirs(RecyclerView recyclerView, ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }
    }

    public ItemTouchHelper(Callback callback) {
        this.mCallback = callback;
    }

    private void addChildDrawingOrderCallback() {
        if (VERSION.SDK_INT < 21) {
            if (this.mChildDrawingOrderCallback == null) {
                this.mChildDrawingOrderCallback = new ChildDrawingOrderCallback() {
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.mOverdrawChild == null) {
                            return i2;
                        }
                        int access$2300 = ItemTouchHelper.this.mOverdrawChildPosition;
                        if (access$2300 == -1) {
                            access$2300 = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
                            ItemTouchHelper.this.mOverdrawChildPosition = access$2300;
                        }
                        return i2 == i + -1 ? access$2300 : i2 >= access$2300 ? i2 + 1 : i2;
                    }
                };
            }
            this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
        }
    }

    private int checkHorizontalSwipe(ViewHolder viewHolder, int i) {
        int i2 = 4;
        if ((i & 12) != 0) {
            float abs;
            int i3 = this.mDx > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId >= 0) {
                this.mVelocityTracker.computeCurrentVelocity(PIXELS_PER_SECOND, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float a = bl.a(this.mVelocityTracker, this.mActivePointerId);
                float b = bl.b(this.mVelocityTracker, this.mActivePointerId);
                if (a > 0.0f) {
                    i2 = 8;
                }
                abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            abs = (float) this.mRecyclerView.getWidth();
            float swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDx) > abs * swipeThreshold) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkSelectForSwipe(int r11, android.view.MotionEvent r12, int r13) {
        /*
        r10 = this;
        r3 = 2;
        r0 = 1;
        r1 = 0;
        r9 = 0;
        r2 = r10.mSelected;
        if (r2 != 0) goto L_0x0016;
    L_0x0008:
        if (r11 != r3) goto L_0x0016;
    L_0x000a:
        r2 = r10.mActionState;
        if (r2 == r3) goto L_0x0016;
    L_0x000e:
        r2 = r10.mCallback;
        r2 = r2.isItemViewSwipeEnabled();
        if (r2 != 0) goto L_0x0018;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        return r0;
    L_0x0018:
        r2 = r10.mRecyclerView;
        r2 = r2.getScrollState();
        if (r2 == r0) goto L_0x0016;
    L_0x0020:
        r2 = r10.findSwipedView(r12);
        if (r2 == 0) goto L_0x0016;
    L_0x0026:
        r3 = r10.mCallback;
        r4 = r10.mRecyclerView;
        r3 = r3.getAbsoluteMovementFlags(r4, r2);
        r3 = r3 >> 8;
        r3 = r3 & 255;
        if (r3 == 0) goto L_0x0016;
    L_0x0034:
        r4 = android.support.v4.view.ay.c(r12, r13);
        r5 = android.support.v4.view.ay.d(r12, r13);
        r6 = r10.mInitialTouchX;
        r4 = r4 - r6;
        r6 = r10.mInitialTouchY;
        r5 = r5 - r6;
        r6 = java.lang.Math.abs(r4);
        r7 = java.lang.Math.abs(r5);
        r8 = r10.mSlop;
        r8 = (float) r8;
        r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r8 >= 0) goto L_0x0058;
    L_0x0051:
        r8 = r10.mSlop;
        r8 = (float) r8;
        r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r8 < 0) goto L_0x0016;
    L_0x0058:
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 <= 0) goto L_0x007a;
    L_0x005c:
        r5 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r5 >= 0) goto L_0x0064;
    L_0x0060:
        r5 = r3 & 4;
        if (r5 == 0) goto L_0x0016;
    L_0x0064:
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r4 <= 0) goto L_0x006c;
    L_0x0068:
        r3 = r3 & 8;
        if (r3 == 0) goto L_0x0016;
    L_0x006c:
        r10.mDy = r9;
        r10.mDx = r9;
        r1 = android.support.v4.view.ay.b(r12, r1);
        r10.mActivePointerId = r1;
        r10.select(r2, r0);
        goto L_0x0017;
    L_0x007a:
        r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r4 >= 0) goto L_0x0082;
    L_0x007e:
        r4 = r3 & 1;
        if (r4 == 0) goto L_0x0016;
    L_0x0082:
        r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r4 <= 0) goto L_0x006c;
    L_0x0086:
        r3 = r3 & 2;
        if (r3 != 0) goto L_0x006c;
    L_0x008a:
        r0 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.checkSelectForSwipe(int, android.view.MotionEvent, int):boolean");
    }

    private int checkVerticalSwipe(ViewHolder viewHolder, int i) {
        int i2 = 1;
        if ((i & 3) != 0) {
            float abs;
            int i3 = this.mDy > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId >= 0) {
                this.mVelocityTracker.computeCurrentVelocity(PIXELS_PER_SECOND, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float a = bl.a(this.mVelocityTracker, this.mActivePointerId);
                float b = bl.b(this.mVelocityTracker, this.mActivePointerId);
                if (b > 0.0f) {
                    i2 = 2;
                }
                abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            abs = (float) this.mRecyclerView.getHeight();
            float swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDy) > abs * swipeThreshold) {
                return i3;
            }
        }
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, ((RecoverAnimation) this.mRecoverAnimations.get(0)).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
    }

    private int endRecoverAnimation(ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
    }

    private RecoverAnimation findAnimation(MotionEvent motionEvent) {
        RecoverAnimation recoverAnimation;
        if (this.mRecoverAnimations.isEmpty()) {
            recoverAnimation = null;
        } else {
            View findChildView = findChildView(motionEvent);
            int size = this.mRecoverAnimations.size() - 1;
            while (size >= 0) {
                recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
                if (recoverAnimation.mViewHolder.itemView != findChildView) {
                    size--;
                }
            }
            return null;
        }
        return recoverAnimation;
    }

    private View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mSelected != null) {
            View view = this.mSelected.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    private List findSwapTargets(ViewHolder viewHolder) {
        if (this.mSwapTargets == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            this.mSwapTargets.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int width = (viewHolder.itemView.getWidth() + round) + (boundingBoxMargin * 2);
        int height = (viewHolder.itemView.getHeight() + round2) + (boundingBoxMargin * 2);
        int i = (round + width) / 2;
        int i2 = (round2 + height) / 2;
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i - ((childAt.getLeft() + childAt.getRight()) / 2));
                    boundingBoxMargin = Math.abs(i2 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int i4 = (abs * abs) + (boundingBoxMargin * boundingBoxMargin);
                    int size = this.mSwapTargets.size();
                    int i5 = 0;
                    abs = 0;
                    while (i5 < size && i4 > ((Integer) this.mDistances.get(i5)).intValue()) {
                        i5++;
                        abs++;
                    }
                    this.mSwapTargets.add(abs, childViewHolder);
                    this.mDistances.add(abs, Integer.valueOf(i4));
                }
            }
        }
        return this.mSwapTargets;
    }

    private ViewHolder findSwipedView(MotionEvent motionEvent) {
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mActivePointerId != -1) {
            int a = ay.a(motionEvent, this.mActivePointerId);
            float c = ay.c(motionEvent, a);
            float f = this.mInitialTouchX;
            float d = ay.d(motionEvent, a);
            float f2 = this.mInitialTouchY;
            c = Math.abs(c - f);
            d = Math.abs(d - f2);
            if ((c >= ((float) this.mSlop) || d >= ((float) this.mSlop)) && ((c <= d || !layoutManager.canScrollHorizontally()) && (d <= c || !layoutManager.canScrollVertically()))) {
                View findChildView = findChildView(motionEvent);
                if (findChildView != null) {
                    return this.mRecyclerView.getChildViewHolder(findChildView);
                }
            }
        }
        return null;
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = bp.n(this.mSelected.itemView);
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = bp.o(this.mSelected.itemView);
        }
    }

    private boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!((RecoverAnimation) this.mRecoverAnimations.get(i)).mEnded) {
                return true;
            }
        }
        return DEBUG;
    }

    private static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        return (f < f3 || f > ((float) view.getWidth()) + f3 || f2 < f4 || f2 > ((float) view.getHeight()) + f4) ? DEBUG : true;
    }

    private void initGestureDetector() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new q(this.mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
        }
    }

    private void moveIfNecessary(ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i = (int) (this.mSelectedStartX + this.mDx);
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= moveThreshold * ((float) viewHolder.itemView.getWidth())) {
                List findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() != 0) {
                    ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i, i2);
                    if (chooseDropTarget == null) {
                        this.mSwapTargets.clear();
                        this.mDistances.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                        this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    private void obtainVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() {
            public void run() {
                if (ItemTouchHelper.this.mRecyclerView != null && ItemTouchHelper.this.mRecyclerView.isAttachedToWindow() && !recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAdapterPosition() != -1) {
                    ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                        ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                    } else {
                        ItemTouchHelper.this.mRecyclerView.post(this);
                    }
                }
            }
        });
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean scrollIfNecessary() {
        /*
        r14 = this;
        r12 = -9223372036854775808;
        r0 = 0;
        r5 = 0;
        r1 = r14.mSelected;
        if (r1 != 0) goto L_0x000b;
    L_0x0008:
        r14.mDragScrollStartTimeInMs = r12;
    L_0x000a:
        return r0;
    L_0x000b:
        r10 = java.lang.System.currentTimeMillis();
        r2 = r14.mDragScrollStartTimeInMs;
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x00bb;
    L_0x0015:
        r6 = 0;
    L_0x0017:
        r1 = r14.mRecyclerView;
        r1 = r1.getLayoutManager();
        r2 = r14.mTmpRect;
        if (r2 != 0) goto L_0x0028;
    L_0x0021:
        r2 = new android.graphics.Rect;
        r2.<init>();
        r14.mTmpRect = r2;
    L_0x0028:
        r2 = r14.mSelected;
        r2 = r2.itemView;
        r3 = r14.mTmpRect;
        r1.calculateItemDecorationsForChild(r2, r3);
        r2 = r1.canScrollHorizontally();
        if (r2 == 0) goto L_0x00e6;
    L_0x0037:
        r2 = r14.mSelectedStartX;
        r3 = r14.mDx;
        r2 = r2 + r3;
        r2 = (int) r2;
        r3 = r14.mTmpRect;
        r3 = r3.left;
        r3 = r2 - r3;
        r4 = r14.mRecyclerView;
        r4 = r4.getPaddingLeft();
        r4 = r3 - r4;
        r3 = r14.mDx;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 >= 0) goto L_0x00c1;
    L_0x0051:
        if (r4 >= 0) goto L_0x00c1;
    L_0x0053:
        r1 = r1.canScrollVertically();
        if (r1 == 0) goto L_0x010e;
    L_0x0059:
        r1 = r14.mSelectedStartY;
        r2 = r14.mDy;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r14.mTmpRect;
        r2 = r2.top;
        r2 = r1 - r2;
        r3 = r14.mRecyclerView;
        r3 = r3.getPaddingTop();
        r8 = r2 - r3;
        r2 = r14.mDy;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x00e9;
    L_0x0073:
        if (r8 >= 0) goto L_0x00e9;
    L_0x0075:
        if (r4 == 0) goto L_0x0117;
    L_0x0077:
        r1 = r14.mCallback;
        r2 = r14.mRecyclerView;
        r3 = r14.mSelected;
        r3 = r3.itemView;
        r3 = r3.getWidth();
        r5 = r14.mRecyclerView;
        r5 = r5.getWidth();
        r4 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6);
        r9 = r4;
    L_0x008e:
        if (r8 == 0) goto L_0x0115;
    L_0x0090:
        r1 = r14.mCallback;
        r2 = r14.mRecyclerView;
        r3 = r14.mSelected;
        r3 = r3.itemView;
        r3 = r3.getHeight();
        r4 = r14.mRecyclerView;
        r5 = r4.getHeight();
        r4 = r8;
        r1 = r1.interpolateOutOfBoundsScroll(r2, r3, r4, r5, r6);
    L_0x00a7:
        if (r9 != 0) goto L_0x00ab;
    L_0x00a9:
        if (r1 == 0) goto L_0x0111;
    L_0x00ab:
        r2 = r14.mDragScrollStartTimeInMs;
        r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x00b3;
    L_0x00b1:
        r14.mDragScrollStartTimeInMs = r10;
    L_0x00b3:
        r0 = r14.mRecyclerView;
        r0.scrollBy(r9, r1);
        r0 = 1;
        goto L_0x000a;
    L_0x00bb:
        r2 = r14.mDragScrollStartTimeInMs;
        r6 = r10 - r2;
        goto L_0x0017;
    L_0x00c1:
        r3 = r14.mDx;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x00e6;
    L_0x00c7:
        r3 = r14.mSelected;
        r3 = r3.itemView;
        r3 = r3.getWidth();
        r2 = r2 + r3;
        r3 = r14.mTmpRect;
        r3 = r3.right;
        r2 = r2 + r3;
        r3 = r14.mRecyclerView;
        r3 = r3.getWidth();
        r4 = r14.mRecyclerView;
        r4 = r4.getPaddingRight();
        r3 = r3 - r4;
        r4 = r2 - r3;
        if (r4 > 0) goto L_0x0053;
    L_0x00e6:
        r4 = r0;
        goto L_0x0053;
    L_0x00e9:
        r2 = r14.mDy;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x010e;
    L_0x00ef:
        r2 = r14.mSelected;
        r2 = r2.itemView;
        r2 = r2.getHeight();
        r1 = r1 + r2;
        r2 = r14.mTmpRect;
        r2 = r2.bottom;
        r1 = r1 + r2;
        r2 = r14.mRecyclerView;
        r2 = r2.getHeight();
        r3 = r14.mRecyclerView;
        r3 = r3.getPaddingBottom();
        r2 = r2 - r3;
        r8 = r1 - r2;
        if (r8 > 0) goto L_0x0075;
    L_0x010e:
        r8 = r0;
        goto L_0x0075;
    L_0x0111:
        r14.mDragScrollStartTimeInMs = r12;
        goto L_0x000a;
    L_0x0115:
        r1 = r8;
        goto L_0x00a7;
    L_0x0117:
        r9 = r4;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.scrollIfNecessary():boolean");
    }

    private void select(ViewHolder viewHolder, int i) {
        if (viewHolder != this.mSelected || i != this.mActionState) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            int i2 = this.mActionState;
            endRecoverAnimation(viewHolder, true);
            this.mActionState = i;
            if (i == 2) {
                this.mOverdrawChild = viewHolder.itemView;
                addChildDrawingOrderCallback();
            }
            Object obj = null;
            Object obj2 = null;
            if (this.mSelected != null) {
                ViewHolder viewHolder2 = this.mSelected;
                if (viewHolder2.itemView.getParent() != null) {
                    float f;
                    float signum;
                    final int swipeIfNecessary = i2 == 2 ? 0 : swipeIfNecessary(viewHolder2);
                    releaseVelocityTracker();
                    switch (swipeIfNecessary) {
                        case 1:
                        case 2:
                            f = 0.0f;
                            signum = Math.signum(this.mDy) * ((float) this.mRecyclerView.getHeight());
                            break;
                        case 4:
                        case 8:
                        case 16:
                        case 32:
                            signum = 0.0f;
                            f = Math.signum(this.mDx) * ((float) this.mRecyclerView.getWidth());
                            break;
                        default:
                            f = 0.0f;
                            signum = 0.0f;
                            break;
                    }
                    int i3 = i2 == 2 ? 8 : swipeIfNecessary > 0 ? 2 : 4;
                    getSelectedDxDy(this.mTmpPosition);
                    float f2 = this.mTmpPosition[0];
                    float f3 = this.mTmpPosition[1];
                    final ViewHolder viewHolder3 = viewHolder2;
                    RecoverAnimation anonymousClass3 = new RecoverAnimation(viewHolder2, i3, i2, f2, f3, f, signum) {
                        public void onAnimationEnd(l lVar) {
                            super.onAnimationEnd(lVar);
                            if (!this.mOverridden) {
                                if (swipeIfNecessary <= 0) {
                                    ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, viewHolder3);
                                } else {
                                    ItemTouchHelper.this.mPendingCleanup.add(viewHolder3.itemView);
                                    this.mIsPendingCleanup = true;
                                    if (swipeIfNecessary > 0) {
                                        ItemTouchHelper.this.postDispatchSwipe(this, swipeIfNecessary);
                                    }
                                }
                                if (ItemTouchHelper.this.mOverdrawChild == viewHolder3.itemView) {
                                    ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(viewHolder3.itemView);
                                }
                            }
                        }
                    };
                    anonymousClass3.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i3, f - f2, signum - f3));
                    this.mRecoverAnimations.add(anonymousClass3);
                    anonymousClass3.start();
                    obj2 = 1;
                } else {
                    removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                    this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                }
                this.mSelected = null;
                obj = obj2;
            }
            if (viewHolder != null) {
                this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & ((1 << ((i * 8) + 8)) - 1)) >> (this.mActionState << 3);
                this.mSelectedStartX = (float) viewHolder.itemView.getLeft();
                this.mSelectedStartY = (float) viewHolder.itemView.getTop();
                this.mSelected = viewHolder;
                if (i == 2) {
                    this.mSelected.itemView.performHapticFeedback(0);
                }
            }
            ViewParent parent = this.mRecyclerView.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.mSelected != null ? true : DEBUG);
            }
            if (obj == null) {
                this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
            }
            this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
            this.mRecyclerView.invalidate();
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        initGestureDetector();
    }

    private int swipeIfNecessary(ViewHolder viewHolder) {
        if (this.mActionState != 2) {
            int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
            int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, bp.h(this.mRecyclerView)) >> 8) & ACTION_MODE_IDLE_MASK;
            if (convertToAbsoluteDirection != 0) {
                int i = (movementFlags >> 8) & ACTION_MODE_IDLE_MASK;
                if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
                    movementFlags = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
                    if (movementFlags > 0) {
                        return (i & movementFlags) == 0 ? Callback.convertToRelativeDirection(movementFlags, bp.h(this.mRecyclerView)) : movementFlags;
                    } else {
                        movementFlags = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                        if (movementFlags > 0) {
                            return movementFlags;
                        }
                    }
                }
                movementFlags = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                if (movementFlags > 0) {
                    return movementFlags;
                }
                movementFlags = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
                if (movementFlags > 0) {
                    return (i & movementFlags) == 0 ? Callback.convertToRelativeDirection(movementFlags, bp.h(this.mRecyclerView)) : movementFlags;
                }
            }
        }
        return 0;
    }

    private void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float c = ay.c(motionEvent, i2);
        float d = ay.d(motionEvent, i2);
        this.mDx = c - this.mInitialTouchX;
        this.mDy = d - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.mSwipeEscapeVelocity = resources.getDimension(android.support.v7.c.b.item_touch_helper_swipe_escape_velocity);
                this.mMaxSwipeVelocity = resources.getDimension(android.support.v7.c.b.item_touch_helper_swipe_escape_max_velocity);
                setupCallbacks();
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.setEmpty();
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.mSelected == null || childViewHolder != this.mSelected) {
                endRecoverAnimation(childViewHolder, DEBUG);
                if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                    this.mCallback.clearView(this.mRecyclerView, childViewHolder);
                    return;
                }
                return;
            }
            select(null, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            f = this.mTmpPosition[0];
            f2 = this.mTmpPosition[1];
        } else {
            f = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2 = 0.0f;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            f = this.mTmpPosition[0];
            f2 = this.mTmpPosition[1];
        } else {
            f = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    public void startDrag(ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }
}
