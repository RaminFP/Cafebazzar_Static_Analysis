package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransitionCompat21.EpicenterView;
import android.support.v4.app.FragmentTransitionCompat21.ViewRetriever;
import android.support.v4.f.a;
import android.support.v4.f.e;
import android.support.v4.f.h;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = (VERSION.SDK_INT >= 21 ? true : SUPPORTS_TRANSITIONS);
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    Op mHead;
    int mIndex = -1;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList mSharedElementSourceNames;
    ArrayList mSharedElementTargetNames;
    Op mTail;
    int mTransition;
    int mTransitionStyle;

    final class Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        Op next;
        int popEnterAnim;
        int popExitAnim;
        Op prev;
        ArrayList removed;

        Op() {
        }
    }

    public class TransitionState {
        public EpicenterView enteringEpicenterView = new EpicenterView();
        public ArrayList hiddenFragmentViews = new ArrayList();
        public a nameOverrides = new a();
        public View nonExistentView;
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    private TransitionState beginTransition(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        int i = 0;
        ensureFragmentsAreInitialized(sparseArray2);
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(this.mManager.mHost.getContext());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = configureTransitions(sparseArray.keyAt(i2), transitionState, z, sparseArray, sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && configureTransitions(i4, transitionState, z, sparseArray, sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : transitionState;
    }

    private void calculateFragments(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.mManager.mContainer.onHasView()) {
            for (Op op = this.mHead; op != null; op = op.next) {
                switch (op.cmd) {
                    case 1:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2:
                        Fragment fragment = op.fragment;
                        if (this.mManager.mAdded != null) {
                            int i = 0;
                            Fragment fragment2 = fragment;
                            while (i < this.mManager.mAdded.size()) {
                                fragment = (Fragment) this.mManager.mAdded.get(i);
                                if (fragment2 != null && fragment.mContainerId != fragment2.mContainerId) {
                                    fragment = fragment2;
                                } else if (fragment == fragment2) {
                                    sparseArray2.remove(fragment.mContainerId);
                                    fragment = null;
                                } else {
                                    setFirstOut(sparseArray, sparseArray2, fragment);
                                    fragment = fragment2;
                                }
                                i++;
                                fragment2 = fragment;
                            }
                        }
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 3:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void callSharedElementEnd(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, a aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    private static Object captureExitingViews(Object obj, Fragment fragment, ArrayList arrayList, a aVar, View view) {
        return obj != null ? FragmentTransitionCompat21.captureExitingViews(obj, fragment.getView(), arrayList, aVar, view) : obj;
    }

    private boolean configureTransitions(int i, TransitionState transitionState, boolean z, SparseArray sparseArray, SparseArray sparseArray2) {
        View view = (ViewGroup) this.mManager.mContainer.onFindViewById(i);
        if (view == null) {
            return SUPPORTS_TRANSITIONS;
        }
        Map map;
        Object obj;
        ArrayList arrayList;
        Object captureExitingViews;
        View view2;
        ViewRetriever anonymousClass1;
        ArrayList arrayList2;
        Map aVar;
        boolean z2;
        Object mergeTransitions;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object enterTransition = getEnterTransition(fragment, z);
        Object sharedElementTransition = getSharedElementTransition(fragment, fragment2, z);
        Object exitTransition = getExitTransition(fragment2, z);
        a aVar2 = null;
        ArrayList arrayList3 = new ArrayList();
        if (sharedElementTransition != null) {
            a remapSharedElements = remapSharedElements(transitionState, fragment2, z);
            if (remapSharedElements.isEmpty()) {
                map = null;
                obj = null;
                if (enterTransition != null && obj == null && exitTransition == null) {
                    return SUPPORTS_TRANSITIONS;
                }
                arrayList = new ArrayList();
                captureExitingViews = captureExitingViews(exitTransition, fragment2, arrayList, map, transitionState.nonExistentView);
                if (!(this.mSharedElementTargetNames == null || map == null)) {
                    view2 = (View) map.get(this.mSharedElementTargetNames.get(0));
                    if (view2 != null) {
                        if (captureExitingViews != null) {
                            FragmentTransitionCompat21.setEpicenter(captureExitingViews, view2);
                        }
                        if (obj != null) {
                            FragmentTransitionCompat21.setEpicenter(obj, view2);
                        }
                    }
                }
                anonymousClass1 = new ViewRetriever() {
                    public View getView() {
                        return fragment.getView();
                    }
                };
                arrayList2 = new ArrayList();
                aVar = new a();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
                }
                mergeTransitions = FragmentTransitionCompat21.mergeTransitions(enterTransition, captureExitingViews, obj, z2);
                if (mergeTransitions != null) {
                    FragmentTransitionCompat21.addTransitionTargets(enterTransition, obj, view, anonymousClass1, transitionState.nonExistentView, transitionState.enteringEpicenterView, transitionState.nameOverrides, arrayList2, map, aVar, arrayList3);
                    excludeHiddenFragmentsAfterEnter(view, transitionState, i, mergeTransitions);
                    FragmentTransitionCompat21.excludeTarget(mergeTransitions, transitionState.nonExistentView, true);
                    excludeHiddenFragments(transitionState, i, mergeTransitions);
                    FragmentTransitionCompat21.beginDelayedTransition(view, mergeTransitions);
                    FragmentTransitionCompat21.cleanupTransitions(view, transitionState.nonExistentView, enterTransition, arrayList2, captureExitingViews, arrayList, obj, arrayList3, mergeTransitions, transitionState.hiddenFragmentViews, aVar);
                }
                return mergeTransitions == null ? true : SUPPORTS_TRANSITIONS;
            } else {
                SharedElementCallback sharedElementCallback = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onSharedElementStart(new ArrayList(remapSharedElements.keySet()), new ArrayList(remapSharedElements.values()), null);
                }
                prepareSharedElementTransition(transitionState, view, sharedElementTransition, fragment, fragment2, z, arrayList3);
                aVar2 = remapSharedElements;
            }
        }
        obj = sharedElementTransition;
        Object obj2 = aVar2;
        if (enterTransition != null) {
        }
        arrayList = new ArrayList();
        captureExitingViews = captureExitingViews(exitTransition, fragment2, arrayList, map, transitionState.nonExistentView);
        view2 = (View) map.get(this.mSharedElementTargetNames.get(0));
        if (view2 != null) {
            if (captureExitingViews != null) {
                FragmentTransitionCompat21.setEpicenter(captureExitingViews, view2);
            }
            if (obj != null) {
                FragmentTransitionCompat21.setEpicenter(obj, view2);
            }
        }
        anonymousClass1 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        aVar = new a();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        mergeTransitions = FragmentTransitionCompat21.mergeTransitions(enterTransition, captureExitingViews, obj, z2);
        if (mergeTransitions != null) {
            FragmentTransitionCompat21.addTransitionTargets(enterTransition, obj, view, anonymousClass1, transitionState.nonExistentView, transitionState.enteringEpicenterView, transitionState.nameOverrides, arrayList2, map, aVar, arrayList3);
            excludeHiddenFragmentsAfterEnter(view, transitionState, i, mergeTransitions);
            FragmentTransitionCompat21.excludeTarget(mergeTransitions, transitionState.nonExistentView, true);
            excludeHiddenFragments(transitionState, i, mergeTransitions);
            FragmentTransitionCompat21.beginDelayedTransition(view, mergeTransitions);
            FragmentTransitionCompat21.cleanupTransitions(view, transitionState.nonExistentView, enterTransition, arrayList2, captureExitingViews, arrayList, obj, arrayList3, mergeTransitions, transitionState.hiddenFragmentViews, aVar);
        }
        if (mergeTransitions == null) {
        }
    }

    private void doAddOp(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        Op op = new Op();
        op.cmd = i2;
        op.fragment = fragment;
        addOp(op);
    }

    private void ensureFragmentsAreInitialized(SparseArray sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) sparseArray.valueAt(i);
            if (fragment.mState <= 0) {
                this.mManager.makeActive(fragment);
                this.mManager.moveToState(fragment, 1, 0, 0, SUPPORTS_TRANSITIONS);
            }
        }
    }

    private void excludeHiddenFragments(TransitionState transitionState, int i, Object obj) {
        if (this.mManager.mAdded != null) {
            for (int i2 = 0; i2 < this.mManager.mAdded.size(); i2++) {
                Fragment fragment = (Fragment) this.mManager.mAdded.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.mView, SUPPORTS_TRANSITIONS);
                        transitionState.hiddenFragmentViews.remove(fragment.mView);
                    } else if (!transitionState.hiddenFragmentViews.contains(fragment.mView)) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.mView, true);
                        transitionState.hiddenFragmentViews.add(fragment.mView);
                    }
                }
            }
        }
    }

    private void excludeHiddenFragmentsAfterEnter(View view, TransitionState transitionState, int i, Object obj) {
        final View view2 = view;
        final TransitionState transitionState2 = transitionState;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.excludeHiddenFragments(transitionState2, i2, obj2);
                return true;
            }
        });
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapSharedElementTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private a mapEnteringSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        Map aVar = new a();
        View view = fragment.getView();
        if (view == null || this.mSharedElementSourceNames == null) {
            return aVar;
        }
        FragmentTransitionCompat21.findNamedViews(aVar, view);
        if (z) {
            return remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
        }
        h.a(aVar, this.mSharedElementTargetNames);
        return aVar;
    }

    private a mapSharedElementsIn(TransitionState transitionState, boolean z, Fragment fragment) {
        a mapEnteringSharedElements = mapEnteringSharedElements(transitionState, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            }
            setBackNameOverrides(transitionState, mapEnteringSharedElements, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            }
            setNameOverrides(transitionState, mapEnteringSharedElements, true);
        }
        return mapEnteringSharedElements;
    }

    private void prepareSharedElementTransition(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList arrayList2 = arrayList;
        final TransitionState transitionState2 = transitionState;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 != null) {
                    FragmentTransitionCompat21.removeTargets(obj2, arrayList2);
                    arrayList2.clear();
                    a access$000 = BackStackRecord.this.mapSharedElementsIn(transitionState2, z2, fragment3);
                    FragmentTransitionCompat21.setSharedElementTargets(obj2, transitionState2.nonExistentView, access$000, arrayList2);
                    BackStackRecord.this.setEpicenterIn(access$000, transitionState2);
                    BackStackRecord.this.callSharedElementEnd(transitionState2, fragment3, fragment4, z2, access$000);
                }
                return true;
            }
        });
    }

    private static a remapNames(ArrayList arrayList, ArrayList arrayList2, a aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        a aVar2 = new a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private a remapSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        a aVar = new a();
        if (this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(aVar, fragment.getView());
            if (z) {
                h.a((Map) aVar, this.mSharedElementTargetNames);
            } else {
                aVar = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            setBackNameOverrides(transitionState, aVar, SUPPORTS_TRANSITIONS);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            setNameOverrides(transitionState, aVar, (boolean) SUPPORTS_TRANSITIONS);
        }
        return aVar;
    }

    private void setBackNameOverrides(TransitionState transitionState, a aVar, boolean z) {
        int size = this.mSharedElementTargetNames == null ? 0 : this.mSharedElementTargetNames.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.mSharedElementSourceNames.get(i);
            View view = (View) aVar.get((String) this.mSharedElementTargetNames.get(i));
            if (view != null) {
                String transitionName = FragmentTransitionCompat21.getTransitionName(view);
                if (z) {
                    setNameOverride(transitionState.nameOverrides, str, transitionName);
                } else {
                    setNameOverride(transitionState.nameOverrides, transitionName, str);
                }
            }
        }
    }

    private void setEpicenterIn(a aVar, TransitionState transitionState) {
        if (this.mSharedElementTargetNames != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(this.mSharedElementTargetNames.get(0));
            if (view != null) {
                transitionState.enteringEpicenterView.epicenter = view;
            }
        }
    }

    private static void setFirstOut(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void setLastIn(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
        }
    }

    private static void setNameOverride(a aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.c(i))) {
                    aVar.a(i, (Object) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private void setNameOverrides(TransitionState transitionState, a aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.b(i);
            String transitionName = FragmentTransitionCompat21.getTransitionName((View) aVar.c(i));
            if (z) {
                setNameOverride(transitionState.nameOverrides, str, transitionName);
            } else {
                setNameOverride(transitionState.nameOverrides, transitionName, str);
            }
        }
    }

    private static void setNameOverrides(TransitionState transitionState, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                setNameOverride(transitionState.nameOverrides, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    public final FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    public final FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    public final FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    final void addOp(Op op) {
        if (this.mHead == null) {
            this.mTail = op;
            this.mHead = op;
        } else {
            op.prev = this.mTail;
            this.mTail.next = op;
            this.mTail = op;
        }
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
        this.mNumOp++;
    }

    public final FragmentTransaction addSharedElement(View view, String str) {
        if (SUPPORTS_TRANSITIONS) {
            String transitionName = FragmentTransitionCompat21.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList();
                this.mSharedElementTargetNames = new ArrayList();
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    public final FragmentTransaction addToBackStack(String str) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public final FragmentTransaction attach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    final void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v(TAG, "Bump nesting in " + this + " by " + i);
            }
            for (Op op = this.mHead; op != null; op = op.next) {
                Fragment fragment;
                if (op.fragment != null) {
                    fragment = op.fragment;
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v(TAG, "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
                if (op.removed != null) {
                    for (int size = op.removed.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) op.removed.get(size);
                        fragment.mBackStackNesting += i;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v(TAG, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public final void calculateBackFragments(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.mManager.mContainer.onHasView()) {
            for (Op op = this.mTail; op != null; op = op.prev) {
                switch (op.cmd) {
                    case 1:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2:
                        if (op.removed != null) {
                            for (int size = op.removed.size() - 1; size >= 0; size--) {
                                setLastIn(sparseArray, sparseArray2, (Fragment) op.removed.get(size));
                            }
                        }
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 3:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final int commit() {
        return commitInternal(SUPPORTS_TRANSITIONS);
    }

    public final int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    final int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
            dump("  ", null, new PrintWriter(new e(TAG)), null);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    public final FragmentTransaction detach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public final FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = SUPPORTS_TRANSITIONS;
        return this;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    public final void dump(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            Op op = this.mHead;
            int i = 0;
            while (op != null) {
                String str3;
                switch (op.cmd) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + op.cmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(op.fragment);
                if (z) {
                    if (!(op.enterAnim == 0 && op.exitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.exitAnim));
                    }
                    if (!(op.popEnterAnim == 0 && op.popExitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.popExitAnim));
                    }
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i2 = 0; i2 < op.removed.size(); i2++) {
                        printWriter.print(str2);
                        if (op.removed.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.removed.get(i2));
                    }
                }
                i++;
                op = op.next;
            }
        }
    }

    public final CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    public final int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public final CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    public final int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public final int getId() {
        return this.mIndex;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getTransition() {
        return this.mTransition;
    }

    public final int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    public final FragmentTransaction hide(Fragment fragment) {
        Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public final boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public final boolean isEmpty() {
        return this.mNumOp == 0 ? true : SUPPORTS_TRANSITIONS;
    }

    public final TransitionState popFromBackStack(boolean z, TransitionState transitionState, SparseArray sparseArray, SparseArray sparseArray2) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "popFromBackStack: " + this);
            dump("  ", null, new PrintWriter(new e(TAG)), null);
        }
        if (SUPPORTS_TRANSITIONS) {
            if (transitionState == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    transitionState = beginTransition(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                setNameOverrides(transitionState, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
        }
        bumpBackStackNesting(-1);
        int i = transitionState != null ? 0 : this.mTransitionStyle;
        int i2 = transitionState != null ? 0 : this.mTransition;
        Op op = this.mTail;
        while (op != null) {
            int i3 = transitionState != null ? 0 : op.popEnterAnim;
            int i4 = transitionState != null ? 0 : op.popExitAnim;
            Fragment fragment;
            Fragment fragment2;
            switch (op.cmd) {
                case 1:
                    fragment = op.fragment;
                    fragment.mNextAnim = i4;
                    this.mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 2:
                    fragment = op.fragment;
                    if (fragment != null) {
                        fragment.mNextAnim = i4;
                        this.mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                    }
                    if (op.removed == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < op.removed.size(); i5++) {
                        fragment2 = (Fragment) op.removed.get(i5);
                        fragment2.mNextAnim = i3;
                        this.mManager.addFragment(fragment2, SUPPORTS_TRANSITIONS);
                    }
                    break;
                case 3:
                    fragment2 = op.fragment;
                    fragment2.mNextAnim = i3;
                    this.mManager.addFragment(fragment2, SUPPORTS_TRANSITIONS);
                    break;
                case 4:
                    fragment2 = op.fragment;
                    fragment2.mNextAnim = i3;
                    this.mManager.showFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 5:
                    fragment = op.fragment;
                    fragment.mNextAnim = i4;
                    this.mManager.hideFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 6:
                    fragment2 = op.fragment;
                    fragment2.mNextAnim = i3;
                    this.mManager.attachFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 7:
                    fragment2 = op.fragment;
                    fragment2.mNextAnim = i3;
                    this.mManager.detachFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            }
            op = op.prev;
        }
        if (z) {
            this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(i2), i, true);
            transitionState = null;
        }
        if (this.mIndex >= 0) {
            this.mManager.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return transitionState;
    }

    public final FragmentTransaction remove(Fragment fragment) {
        Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public final FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    public final FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    public final void run() {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        if (!this.mAddToBackStack || this.mIndex >= 0) {
            TransitionState beginTransition;
            bumpBackStackNesting(1);
            if (SUPPORTS_TRANSITIONS) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                calculateFragments(sparseArray, sparseArray2);
                beginTransition = beginTransition(sparseArray, sparseArray2, SUPPORTS_TRANSITIONS);
            } else {
                beginTransition = null;
            }
            int i = beginTransition != null ? 0 : this.mTransitionStyle;
            int i2 = beginTransition != null ? 0 : this.mTransition;
            Op op = this.mHead;
            while (op != null) {
                int i3 = beginTransition != null ? 0 : op.enterAnim;
                int i4 = beginTransition != null ? 0 : op.exitAnim;
                Fragment fragment;
                switch (op.cmd) {
                    case 1:
                        fragment = op.fragment;
                        fragment.mNextAnim = i3;
                        this.mManager.addFragment(fragment, SUPPORTS_TRANSITIONS);
                        break;
                    case 2:
                        Fragment fragment2 = op.fragment;
                        int i5 = fragment2.mContainerId;
                        if (this.mManager.mAdded != null) {
                            int size = this.mManager.mAdded.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.mManager.mAdded.get(size);
                                if (FragmentManagerImpl.DEBUG) {
                                    Log.v(TAG, "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.mContainerId == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        op.fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (op.removed == null) {
                                            op.removed = new ArrayList();
                                        }
                                        op.removed.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.mAddToBackStack) {
                                            fragment.mBackStackNesting++;
                                            if (FragmentManagerImpl.DEBUG) {
                                                Log.v(TAG, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                                            }
                                        }
                                        this.mManager.removeFragment(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.mManager.addFragment(fragment2, SUPPORTS_TRANSITIONS);
                        break;
                    case 3:
                        fragment = op.fragment;
                        fragment.mNextAnim = i4;
                        this.mManager.removeFragment(fragment, i2, i);
                        break;
                    case 4:
                        fragment = op.fragment;
                        fragment.mNextAnim = i4;
                        this.mManager.hideFragment(fragment, i2, i);
                        break;
                    case 5:
                        fragment = op.fragment;
                        fragment.mNextAnim = i3;
                        this.mManager.showFragment(fragment, i2, i);
                        break;
                    case 6:
                        fragment = op.fragment;
                        fragment.mNextAnim = i4;
                        this.mManager.detachFragment(fragment, i2, i);
                        break;
                    case 7:
                        fragment = op.fragment;
                        fragment.mNextAnim = i3;
                        this.mManager.attachFragment(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
                op = op.next;
            }
            this.mManager.moveToState(this.mManager.mCurState, i2, i, true);
            if (this.mAddToBackStack) {
                this.mManager.addBackStackState(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public final FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public final FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    public final FragmentTransaction setBreadCrumbTitle(int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public final FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public final FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public final FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    public final FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    public final FragmentTransaction setTransitionStyle(int i) {
        this.mTransitionStyle = i;
        return this;
    }

    public final FragmentTransaction show(Fragment fragment) {
        Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
