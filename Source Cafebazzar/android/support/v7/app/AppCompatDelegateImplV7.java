package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ae;
import android.support.v4.view.an;
import android.support.v4.view.bp;
import android.support.v4.view.ch;
import android.support.v7.a.d;
import android.support.v7.a.l;
import android.support.v7.internal.a.a;
import android.support.v7.internal.a.b;
import android.support.v7.internal.a.e;
import android.support.v7.internal.view.menu.g;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.support.v7.internal.widget.ai;
import android.support.v7.internal.widget.al;
import android.support.v7.internal.widget.bq;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7 extends q implements an, j {
    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private PanelFeatureState[] E;
    private PanelFeatureState F;
    private final Runnable G = new v(this);
    private boolean H;
    private Rect I;
    private Rect J;
    private a K;
    private ai n;
    android.support.v7.e.a o;
    ActionBarContextView p;
    PopupWindow q;
    Runnable r;
    ViewGroup s;
    boolean t;
    int u;
    private z v;
    private ad w;
    private boolean x;
    private ViewGroup y;
    private TextView z;

    final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        i j;
        g k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        class SavedState implements Parcelable {
            public static final Creator CREATOR = new ac();
            int a;
            boolean b;
            Bundle c;

            private SavedState() {
            }

            static /* synthetic */ SavedState a(Parcel parcel) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.b = z;
                if (savedState.b) {
                    savedState.c = parcel.readBundle();
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.a = i;
        }

        final void a(i iVar) {
            if (iVar != this.j) {
                if (this.j != null) {
                    this.j.b(this.k);
                }
                this.j = iVar;
                if (iVar != null && this.k != null) {
                    iVar.a(this.k);
                }
            }
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, o oVar) {
        super(context, window, oVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.o;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.m;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.a;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.b;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.a;
        r5 = r11.j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x0059:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x005f:
        r0 = r11.g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.q;
        if (r0 == 0) goto L_0x01e3;
    L_0x0067:
        r0 = r11.g;
        if (r0 != 0) goto L_0x0152;
    L_0x006b:
        r0 = r10.f();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.a.b.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0091;
    L_0x008c:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0091:
        r5 = android.support.v7.a.b.panelMenuListTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014b;
    L_0x009a:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x009f:
        r1 = new android.support.v7.internal.view.b;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.l = r1;
        r0 = android.support.v7.a.l.Theme;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.a.l.Theme_panelBackground;
        r1 = r0.getResourceId(r1, r3);
        r11.b = r1;
        r1 = android.support.v7.a.l.Theme_android_windowAnimationStyle;
        r1 = r0.getResourceId(r1, r3);
        r11.f = r1;
        r0.recycle();
        r0 = new android.support.v7.app.ab;
        r1 = r11.l;
        r0.<init>(r10, r1);
        r11.g = r0;
        r0 = 81;
        r11.c = r0;
        r0 = r11.g;
        if (r0 == 0) goto L_0x000c;
    L_0x00d7:
        r0 = r11.i;
        if (r0 == 0) goto L_0x0165;
    L_0x00db:
        r0 = r11.i;
        r11.h = r0;
        r0 = r9;
    L_0x00e0:
        if (r0 == 0) goto L_0x000c;
    L_0x00e2:
        r0 = r11.h;
        if (r0 == 0) goto L_0x01e0;
    L_0x00e6:
        r0 = r11.i;
        if (r0 == 0) goto L_0x01d1;
    L_0x00ea:
        r0 = r9;
    L_0x00eb:
        if (r0 == 0) goto L_0x000c;
    L_0x00ed:
        r0 = r11.h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01f6;
    L_0x00f5:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fb:
        r0 = r11.b;
        r4 = r11.g;
        r4.setBackgroundResource(r0);
        r0 = r11.h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0115;
    L_0x010a:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0115;
    L_0x010e:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.h;
        r0.removeView(r4);
    L_0x0115:
        r0 = r11.g;
        r4 = r11.h;
        r0.addView(r4, r1);
        r0 = r11.h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x0129;
    L_0x0124:
        r0 = r11.h;
        r0.requestFocus();
    L_0x0129:
        r1 = r2;
    L_0x012a:
        r11.n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.d;
        r4 = r11.e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.c;
        r0.gravity = r1;
        r1 = r11.f;
        r0.windowAnimations = r1;
        r1 = r11.g;
        r8.addView(r1, r0);
        r11.o = r9;
        goto L_0x000c;
    L_0x014b:
        r1 = android.support.v7.a.k.Theme_AppCompat_CompactMenu;
        r4.applyStyle(r1, r9);
        goto L_0x009f;
    L_0x0152:
        r0 = r11.q;
        if (r0 == 0) goto L_0x00d7;
    L_0x0156:
        r0 = r11.g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d7;
    L_0x015e:
        r0 = r11.g;
        r0.removeAllViews();
        goto L_0x00d7;
    L_0x0165:
        r0 = r11.j;
        if (r0 == 0) goto L_0x01ce;
    L_0x0169:
        r0 = r10.w;
        if (r0 != 0) goto L_0x0174;
    L_0x016d:
        r0 = new android.support.v7.app.ad;
        r0.<init>(r10);
        r10.w = r0;
    L_0x0174:
        r0 = r10.w;
        r1 = r11.j;
        if (r1 != 0) goto L_0x0186;
    L_0x017a:
        r0 = 0;
    L_0x017b:
        r0 = (android.view.View) r0;
        r11.h = r0;
        r0 = r11.h;
        if (r0 == 0) goto L_0x01ce;
    L_0x0183:
        r0 = r9;
        goto L_0x00e0;
    L_0x0186:
        r1 = r11.k;
        if (r1 != 0) goto L_0x01a0;
    L_0x018a:
        r1 = new android.support.v7.internal.view.menu.g;
        r4 = r11.l;
        r5 = android.support.v7.a.i.abc_list_menu_item_layout;
        r1.<init>(r4, r5);
        r11.k = r1;
        r1 = r11.k;
        r1.g = r0;
        r0 = r11.j;
        r1 = r11.k;
        r0.a(r1);
    L_0x01a0:
        r1 = r11.k;
        r0 = r11.g;
        r4 = r1.d;
        if (r4 != 0) goto L_0x01cb;
    L_0x01a8:
        r4 = r1.b;
        r5 = android.support.v7.a.i.abc_expanded_menu_layout;
        r0 = r4.inflate(r5, r0, r3);
        r0 = (android.support.v7.internal.view.menu.ExpandedMenuView) r0;
        r1.d = r0;
        r0 = r1.h;
        if (r0 != 0) goto L_0x01bf;
    L_0x01b8:
        r0 = new android.support.v7.internal.view.menu.h;
        r0.<init>(r1);
        r1.h = r0;
    L_0x01bf:
        r0 = r1.d;
        r4 = r1.h;
        r0.setAdapter(r4);
        r0 = r1.d;
        r0.setOnItemClickListener(r1);
    L_0x01cb:
        r0 = r1.d;
        goto L_0x017b;
    L_0x01ce:
        r0 = r3;
        goto L_0x00e0;
    L_0x01d1:
        r0 = r11.k;
        r0 = r0.a();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01e0;
    L_0x01dd:
        r0 = r9;
        goto L_0x00eb;
    L_0x01e0:
        r0 = r3;
        goto L_0x00eb;
    L_0x01e3:
        r0 = r11.i;
        if (r0 == 0) goto L_0x01f3;
    L_0x01e7:
        r0 = r11.i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01f3;
    L_0x01ef:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012a;
    L_0x01f3:
        r1 = r2;
        goto L_0x012a;
    L_0x01f6:
        r1 = r0;
        goto L_0x00fb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    static /* synthetic */ void a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState e = appCompatDelegateImplV7.e(i);
        if (e.j != null) {
            Bundle bundle = new Bundle();
            e.j.a(bundle);
            if (bundle.size() > 0) {
                e.s = bundle;
            }
            e.j.d();
            e.j.clear();
        }
        e.r = true;
        e.q = true;
        if ((i == 8 || i == 0) && appCompatDelegateImplV7.n != null) {
            e = appCompatDelegateImplV7.e(0);
            if (e != null) {
                e.m = false;
                appCompatDelegateImplV7.b(e, null);
            }
        }
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        return (!keyEvent.isSystem() && ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null)) ? panelFeatureState.j.performShortcut(i, keyEvent, 1) : false;
    }

    static /* synthetic */ int b(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.p == null || !(appCompatDelegateImplV7.p.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.p.getLayoutParams();
            if (appCompatDelegateImplV7.p.isShown()) {
                if (appCompatDelegateImplV7.I == null) {
                    appCompatDelegateImplV7.I = new Rect();
                    appCompatDelegateImplV7.J = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.I;
                Rect rect2 = appCompatDelegateImplV7.J;
                rect.set(0, i, 0, 0);
                bq.a(appCompatDelegateImplV7.s, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.A == null) {
                        appCompatDelegateImplV7.A = new View(appCompatDelegateImplV7.a);
                        appCompatDelegateImplV7.A.setBackgroundColor(appCompatDelegateImplV7.a.getResources().getColor(d.abc_input_method_navigation_guard));
                        appCompatDelegateImplV7.s.addView(appCompatDelegateImplV7.A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.A == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.i || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.p.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.A != null) {
            View view = appCompatDelegateImplV7.A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.m) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        if (!(this.F == null || this.F == panelFeatureState)) {
            a(this.F, false);
        }
        Callback callback = this.b.getCallback();
        if (callback != null) {
            panelFeatureState.i = callback.onCreatePanelView(panelFeatureState.a);
        }
        boolean z = panelFeatureState.a == 0 || panelFeatureState.a == 8;
        if (z && this.n != null) {
            this.n.f();
        }
        if (panelFeatureState.i == null && !(z && (this.f instanceof b))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null) {
                    Context bVar;
                    i iVar;
                    Context context = this.a;
                    if ((panelFeatureState.a == 0 || panelFeatureState.a == 8) && this.n != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.b.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.b.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.b.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            bVar = new android.support.v7.internal.view.b(context, 0);
                            bVar.getTheme().setTo(theme2);
                            iVar = new i(bVar);
                            iVar.a((j) this);
                            panelFeatureState.a(iVar);
                            if (panelFeatureState.j == null) {
                                return false;
                            }
                        }
                    }
                    bVar = context;
                    iVar = new i(bVar);
                    iVar.a((j) this);
                    panelFeatureState.a(iVar);
                    if (panelFeatureState.j == null) {
                        return false;
                    }
                }
                if (z && this.n != null) {
                    if (this.v == null) {
                        this.v = new z();
                    }
                    this.n.a(panelFeatureState.j, this.v);
                }
                panelFeatureState.j.d();
                if (callback.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.r = false;
                } else {
                    panelFeatureState.a(null);
                    if (!z || this.n == null) {
                        return false;
                    }
                    this.n.a(null, this.v);
                    return false;
                }
            }
            panelFeatureState.j.d();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.b(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                panelFeatureState.j.setQwertyMode(panelFeatureState.p);
                panelFeatureState.j.e();
            } else {
                if (z && this.n != null) {
                    this.n.a(null, this.v);
                }
                panelFeatureState.j.e();
                return false;
            }
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.F = panelFeatureState;
        return true;
    }

    private void f(int i) {
        this.u |= 1 << i;
        if (!this.t && this.y != null) {
            bp.a(this.y, this.G);
            this.t = true;
        }
    }

    private void g() {
        if (!this.x) {
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.k) {
                if (this.i) {
                    this.s = (ViewGroup) from.inflate(android.support.v7.a.i.abc_screen_simple_overlay_action_mode, null);
                } else {
                    this.s = (ViewGroup) from.inflate(android.support.v7.a.i.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    bp.a(this.s, new w(this));
                } else {
                    ((al) this.s).setOnFitSystemWindowsListener(new x(this));
                }
            } else if (this.j) {
                this.s = (ViewGroup) from.inflate(android.support.v7.a.i.abc_dialog_title_material, null);
                this.h = false;
                this.g = false;
            } else if (this.g) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(android.support.v7.a.b.actionBarTheme, typedValue, true);
                this.s = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.internal.view.b(this.a, typedValue.resourceId) : this.a).inflate(android.support.v7.a.i.abc_screen_toolbar, null);
                this.n = (ai) this.s.findViewById(android.support.v7.a.g.decor_content_parent);
                this.n.setWindowCallback(this.b.getCallback());
                if (this.h) {
                    this.n.a(9);
                }
                if (this.B) {
                    this.n.a(2);
                }
                if (this.C) {
                    this.n.a(5);
                }
            }
            if (this.s == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features");
            }
            if (this.n == null) {
                this.z = (TextView) this.s.findViewById(android.support.v7.a.g.title);
            }
            bq.b(this.s);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.s.findViewById(android.support.v7.a.g.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.b.setContentView(this.s);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            CharSequence title = this.c instanceof Activity ? ((Activity) this.c).getTitle() : this.l;
            if (!TextUtils.isEmpty(title)) {
                b(title);
            }
            contentFrameLayout.a.set(this.y.getPaddingLeft(), this.y.getPaddingTop(), this.y.getPaddingRight(), this.y.getPaddingBottom());
            if (bp.z(contentFrameLayout)) {
                contentFrameLayout.requestLayout();
            }
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(l.Theme);
            obtainStyledAttributes.getValue(l.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
            obtainStyledAttributes.getValue(l.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
            if (obtainStyledAttributes.hasValue(l.Theme_windowFixedWidthMajor)) {
                obtainStyledAttributes.getValue(l.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
            }
            if (obtainStyledAttributes.hasValue(l.Theme_windowFixedWidthMinor)) {
                obtainStyledAttributes.getValue(l.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
            }
            if (obtainStyledAttributes.hasValue(l.Theme_windowFixedHeightMajor)) {
                obtainStyledAttributes.getValue(l.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
            }
            if (obtainStyledAttributes.hasValue(l.Theme_windowFixedHeightMinor)) {
                obtainStyledAttributes.getValue(l.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
            }
            obtainStyledAttributes.recycle();
            contentFrameLayout.requestLayout();
            this.x = true;
            PanelFeatureState e = e(0);
            if (!this.m) {
                if (e == null || e.j == null) {
                    f(8);
                }
            }
        }
    }

    private void h() {
        if (this.x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.E;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public final void a() {
        a e = e();
        if (e != null) {
            e.b(false);
        }
    }

    public final void a(int i) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.s.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.E.length) {
                panelFeatureState = this.E[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if (panelFeatureState == null || panelFeatureState.o) {
            Callback callback = this.b.getCallback();
            if (callback != null) {
                callback.onPanelClosed(i, menu);
            }
        }
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        this.y = (ViewGroup) this.b.getDecorView();
        if ((this.c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.c) != null) {
            a aVar = this.f;
            if (aVar == null) {
                this.H = true;
            } else {
                aVar.a(true);
            }
        }
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.a == 0 && this.n != null && this.n.b()) {
            a(panelFeatureState.j);
            return;
        }
        boolean z2 = panelFeatureState.o;
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !z2 || panelFeatureState.g == null)) {
            windowManager.removeView(panelFeatureState.g);
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        if (z2 && z) {
            a(panelFeatureState.a, panelFeatureState, null);
        }
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.F == panelFeatureState) {
            this.F = null;
        }
    }

    void a(i iVar) {
        if (!this.D) {
            this.D = true;
            this.n.g();
            Callback callback = this.b.getCallback();
            if (!(callback == null || this.m)) {
                callback.onPanelClosed(8, iVar);
            }
            this.D = false;
        }
    }

    public final void a(View view) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.s.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public final void a(View view, LayoutParams layoutParams) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.s.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    final boolean a(int i, KeyEvent keyEvent) {
        a e = e();
        if (e != null && e.a(i, keyEvent)) {
            return true;
        }
        if (this.F == null || !a(this.F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.F == null) {
                PanelFeatureState e2 = e(0);
                b(e2, keyEvent);
                boolean a = a(e2, keyEvent.getKeyCode(), keyEvent, 1);
                e2.m = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.F == null) {
            return true;
        } else {
            this.F.n = true;
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean a(android.view.KeyEvent r6) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r3 = r6.getKeyCode();
        r0 = r6.getAction();
        if (r0 != 0) goto L_0x001e;
    L_0x000c:
        r0 = r1;
    L_0x000d:
        if (r0 == 0) goto L_0x003a;
    L_0x000f:
        switch(r3) {
            case 82: goto L_0x0020;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 >= r1) goto L_0x0038;
    L_0x0018:
        r0 = r5.a(r3, r6);
    L_0x001c:
        r1 = r0;
    L_0x001d:
        return r1;
    L_0x001e:
        r0 = r2;
        goto L_0x000d;
    L_0x0020:
        r0 = r6.getRepeatCount();
        if (r0 != 0) goto L_0x0036;
    L_0x0026:
        r0 = r5.e(r2);
        r4 = r0.o;
        if (r4 != 0) goto L_0x0036;
    L_0x002e:
        r0 = r5.b(r0, r6);
    L_0x0032:
        if (r0 == 0) goto L_0x0012;
    L_0x0034:
        r0 = r1;
        goto L_0x001c;
    L_0x0036:
        r0 = r2;
        goto L_0x0032;
    L_0x0038:
        r1 = r2;
        goto L_0x001d;
    L_0x003a:
        switch(r3) {
            case 4: goto L_0x00c0;
            case 82: goto L_0x003f;
            default: goto L_0x003d;
        };
    L_0x003d:
        r0 = r2;
        goto L_0x001c;
    L_0x003f:
        r0 = r5.o;
        if (r0 == 0) goto L_0x0047;
    L_0x0043:
        r0 = r2;
    L_0x0044:
        if (r0 == 0) goto L_0x003d;
    L_0x0046:
        goto L_0x001d;
    L_0x0047:
        r4 = r5.e(r2);
        r0 = r5.n;
        if (r0 == 0) goto L_0x0095;
    L_0x004f:
        r0 = r5.n;
        r0 = r0.a();
        if (r0 == 0) goto L_0x0095;
    L_0x0057:
        r0 = r5.a;
        r0 = android.view.ViewConfiguration.get(r0);
        r0 = android.support.v4.view.ch.b(r0);
        if (r0 != 0) goto L_0x0095;
    L_0x0063:
        r0 = r5.n;
        r0 = r0.b();
        if (r0 != 0) goto L_0x008e;
    L_0x006b:
        r0 = r5.m;
        if (r0 != 0) goto L_0x00ed;
    L_0x006f:
        r0 = r5.b(r4, r6);
        if (r0 == 0) goto L_0x00ed;
    L_0x0075:
        r0 = r5.n;
        r3 = r0.d();
    L_0x007b:
        if (r3 == 0) goto L_0x008c;
    L_0x007d:
        r0 = r5.a;
        r4 = "audio";
        r0 = r0.getSystemService(r4);
        r0 = (android.media.AudioManager) r0;
        if (r0 == 0) goto L_0x00b8;
    L_0x0089:
        r0.playSoundEffect(r2);
    L_0x008c:
        r0 = r3;
        goto L_0x0044;
    L_0x008e:
        r0 = r5.n;
        r3 = r0.e();
        goto L_0x007b;
    L_0x0095:
        r0 = r4.o;
        if (r0 != 0) goto L_0x009d;
    L_0x0099:
        r0 = r4.n;
        if (r0 == 0) goto L_0x00a3;
    L_0x009d:
        r3 = r4.o;
        r5.a(r4, r1);
        goto L_0x007b;
    L_0x00a3:
        r0 = r4.m;
        if (r0 == 0) goto L_0x00ed;
    L_0x00a7:
        r0 = r4.r;
        if (r0 == 0) goto L_0x00ef;
    L_0x00ab:
        r4.m = r2;
        r0 = r5.b(r4, r6);
    L_0x00b1:
        if (r0 == 0) goto L_0x00ed;
    L_0x00b3:
        r5.a(r4, r6);
        r3 = r1;
        goto L_0x007b;
    L_0x00b8:
        r0 = "AppCompatDelegate";
        r4 = "Couldn't get audio manager";
        android.util.Log.w(r0, r4);
        goto L_0x008c;
    L_0x00c0:
        r0 = r5.e(r2);
        if (r0 == 0) goto L_0x00cf;
    L_0x00c6:
        r3 = r0.o;
        if (r3 == 0) goto L_0x00cf;
    L_0x00ca:
        r5.a(r0, r1);
        goto L_0x001d;
    L_0x00cf:
        r0 = r5.o;
        if (r0 == 0) goto L_0x00dd;
    L_0x00d3:
        r0 = r5.o;
        r0.c();
        r0 = r1;
    L_0x00d9:
        if (r0 == 0) goto L_0x003d;
    L_0x00db:
        goto L_0x001d;
    L_0x00dd:
        r0 = r5.e();
        if (r0 == 0) goto L_0x00eb;
    L_0x00e3:
        r0 = r0.c();
        if (r0 == 0) goto L_0x00eb;
    L_0x00e9:
        r0 = r1;
        goto L_0x00d9;
    L_0x00eb:
        r0 = r2;
        goto L_0x00d9;
    L_0x00ed:
        r3 = r2;
        goto L_0x007b;
    L_0x00ef:
        r0 = r1;
        goto L_0x00b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.view.KeyEvent):boolean");
    }

    public final void b() {
        a e = e();
        if (e == null || !e.b()) {
            f(0);
        }
    }

    public final void b(View view, LayoutParams layoutParams) {
        g();
        ((ViewGroup) this.s.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    final void b(CharSequence charSequence) {
        if (this.n != null) {
            this.n.setWindowTitle(charSequence);
        } else if (this.f != null) {
            this.f.a(charSequence);
        } else if (this.z != null) {
            this.z.setText(charSequence);
        }
    }

    public final boolean b(int i) {
        switch (i) {
            case 1:
                h();
                this.k = true;
                return true;
            case 2:
                h();
                this.B = true;
                return true;
            case 5:
                h();
                this.C = true;
                return true;
            case 8:
                h();
                this.g = true;
                return true;
            case 9:
                h();
                this.h = true;
                return true;
            case 10:
                h();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(i);
        }
    }

    public final void c() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            ae.a(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    final boolean c(int i) {
        if (i == 8) {
            a e = e();
            if (e != null) {
                e.c(false);
            }
            return true;
        } else if (i != 0) {
            return false;
        } else {
            PanelFeatureState e2 = e(i);
            if (!e2.o) {
                return false;
            }
            a(e2, false);
            return false;
        }
    }

    public final a d() {
        g();
        a aVar = null;
        if (this.c instanceof Activity) {
            aVar = new e((Activity) this.c, this.h);
        } else if (this.c instanceof Dialog) {
            aVar = new e((Dialog) this.c);
        }
        if (aVar != null) {
            aVar.a(this.H);
        }
        return aVar;
    }

    final boolean d(int i) {
        if (i != 8) {
            return false;
        }
        a e = e();
        if (e == null) {
            return true;
        }
        e.c(true);
        return true;
    }

    PanelFeatureState e(int i) {
        Object obj = this.E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.E = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r6, java.lang.String r7, android.content.Context r8, android.util.AttributeSet r9) {
        /*
        r5 = this;
        r2 = 0;
        r1 = 1;
        r0 = r5.a(r6, r7, r8, r9);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 21;
        if (r0 >= r3) goto L_0x0053;
    L_0x000f:
        r0 = r1;
    L_0x0010:
        r3 = r5.K;
        if (r3 != 0) goto L_0x001b;
    L_0x0014:
        r3 = new android.support.v7.internal.a.a;
        r3.<init>();
        r5.K = r3;
    L_0x001b:
        if (r0 == 0) goto L_0x0055;
    L_0x001d:
        r3 = r5.x;
        if (r3 == 0) goto L_0x0055;
    L_0x0021:
        if (r6 == 0) goto L_0x0055;
    L_0x0023:
        r3 = r6.getId();
        r4 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;
        if (r3 == r4) goto L_0x0055;
    L_0x002c:
        r3 = android.support.v4.view.bp.A(r6);
        if (r3 != 0) goto L_0x0055;
    L_0x0032:
        r3 = r1;
    L_0x0033:
        r4 = r5.K;
        if (r3 == 0) goto L_0x0105;
    L_0x0037:
        if (r6 == 0) goto L_0x0105;
    L_0x0039:
        r3 = r6.getContext();
    L_0x003d:
        r3 = android.support.v7.internal.a.a.a(r3, r9, r0, r1);
        r0 = r7.hashCode();
        switch(r0) {
            case -1946472170: goto L_0x009c;
            case -1455429095: goto L_0x007e;
            case -1346021293: goto L_0x0092;
            case -938935918: goto L_0x00b1;
            case -339785223: goto L_0x0060;
            case 776382189: goto L_0x0074;
            case 1413872058: goto L_0x0088;
            case 1601505219: goto L_0x006a;
            case 1666676343: goto L_0x0057;
            case 2001146706: goto L_0x00a6;
            default: goto L_0x0048;
        };
    L_0x0048:
        r2 = -1;
    L_0x0049:
        switch(r2) {
            case 0: goto L_0x00bc;
            case 1: goto L_0x00c3;
            case 2: goto L_0x00ca;
            case 3: goto L_0x00d1;
            case 4: goto L_0x00d8;
            case 5: goto L_0x00df;
            case 6: goto L_0x00e6;
            case 7: goto L_0x00ed;
            case 8: goto L_0x00f4;
            case 9: goto L_0x00fb;
            default: goto L_0x004c;
        };
    L_0x004c:
        if (r8 == r3) goto L_0x0102;
    L_0x004e:
        r0 = r4.a(r3, r7, r9);
        goto L_0x0008;
    L_0x0053:
        r0 = r2;
        goto L_0x0010;
    L_0x0055:
        r3 = r2;
        goto L_0x0033;
    L_0x0057:
        r0 = "EditText";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x005f:
        goto L_0x0049;
    L_0x0060:
        r0 = "Spinner";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x0068:
        r2 = r1;
        goto L_0x0049;
    L_0x006a:
        r0 = "CheckBox";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x0072:
        r2 = 2;
        goto L_0x0049;
    L_0x0074:
        r0 = "RadioButton";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x007c:
        r2 = 3;
        goto L_0x0049;
    L_0x007e:
        r0 = "CheckedTextView";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x0086:
        r2 = 4;
        goto L_0x0049;
    L_0x0088:
        r0 = "AutoCompleteTextView";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x0090:
        r2 = 5;
        goto L_0x0049;
    L_0x0092:
        r0 = "MultiAutoCompleteTextView";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x009a:
        r2 = 6;
        goto L_0x0049;
    L_0x009c:
        r0 = "RatingBar";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x00a4:
        r2 = 7;
        goto L_0x0049;
    L_0x00a6:
        r0 = "Button";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x00ae:
        r2 = 8;
        goto L_0x0049;
    L_0x00b1:
        r0 = "TextView";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0048;
    L_0x00b9:
        r2 = 9;
        goto L_0x0049;
    L_0x00bc:
        r0 = new android.support.v7.widget.AppCompatEditText;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00c3:
        r0 = new android.support.v7.widget.AppCompatSpinner;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00ca:
        r0 = new android.support.v7.widget.AppCompatCheckBox;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00d1:
        r0 = new android.support.v7.widget.AppCompatRadioButton;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00d8:
        r0 = new android.support.v7.widget.AppCompatCheckedTextView;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00df:
        r0 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00e6:
        r0 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00ed:
        r0 = new android.support.v7.widget.AppCompatRatingBar;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00f4:
        r0 = new android.support.v7.widget.AppCompatButton;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x00fb:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r0.<init>(r3, r9);
        goto L_0x0008;
    L_0x0102:
        r0 = 0;
        goto L_0x0008;
    L_0x0105:
        r3 = r8;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public boolean onMenuItemSelected(i iVar, MenuItem menuItem) {
        Callback callback = this.b.getCallback();
        if (!(callback == null || this.m)) {
            PanelFeatureState a = a(iVar.k());
            if (a != null) {
                return callback.onMenuItemSelected(a.a, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(i iVar) {
        if (this.n == null || !this.n.a() || (ch.b(ViewConfiguration.get(this.a)) && !this.n.c())) {
            PanelFeatureState e = e(0);
            e.q = true;
            a(e, false);
            a(e, null);
            return;
        }
        Callback callback = this.b.getCallback();
        if (this.n.b()) {
            this.n.e();
            if (!this.m) {
                callback.onPanelClosed(8, e(0).j);
            }
        } else if (callback != null && !this.m) {
            if (this.t && (this.u & 1) != 0) {
                this.y.removeCallbacks(this.G);
                this.G.run();
            }
            PanelFeatureState e2 = e(0);
            if (e2.j != null && !e2.r && callback.onPreparePanel(0, e2.i, e2.j)) {
                callback.onMenuOpened(8, e2.j);
                this.n.d();
            }
        }
    }
}
