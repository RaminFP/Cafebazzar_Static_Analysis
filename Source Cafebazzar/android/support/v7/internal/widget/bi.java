package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.b.a;
import android.support.v7.a.b;
import android.support.v7.a.f;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class bi {
    public static final boolean a = (VERSION.SDK_INT < 21);
    private static final Mode b = Mode.SRC_IN;
    private static final WeakHashMap c = new WeakHashMap();
    private static final bj d = new bj(6);
    private static final int[] e = new int[]{f.abc_textfield_search_default_mtrl_alpha, f.abc_textfield_default_mtrl_alpha, f.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f = new int[]{f.abc_ic_ab_back_mtrl_am_alpha, f.abc_ic_go_search_api_mtrl_alpha, f.abc_ic_search_api_mtrl_alpha, f.abc_ic_commit_search_api_mtrl_alpha, f.abc_ic_clear_mtrl_alpha, f.abc_ic_menu_share_mtrl_alpha, f.abc_ic_menu_copy_mtrl_am_alpha, f.abc_ic_menu_cut_mtrl_alpha, f.abc_ic_menu_selectall_mtrl_alpha, f.abc_ic_menu_paste_mtrl_am_alpha, f.abc_ic_menu_moreoverflow_mtrl_alpha, f.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] g = new int[]{f.abc_textfield_activated_mtrl_alpha, f.abc_textfield_search_activated_mtrl_alpha, f.abc_cab_background_top_mtrl_alpha, f.abc_text_cursor_mtrl_alpha};
    private static final int[] h = new int[]{f.abc_popup_background_mtrl_mult, f.abc_cab_background_internal_bg, f.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] i = new int[]{f.abc_edit_text_material, f.abc_tab_indicator_material, f.abc_textfield_search_material, f.abc_spinner_mtrl_am_alpha, f.abc_spinner_textfield_background_material, f.abc_ratingbar_full_material, f.abc_switch_track_mtrl_alpha, f.abc_switch_thumb_material, f.abc_btn_default_mtrl_shape, f.abc_btn_borderless_material};
    private static final int[] j = new int[]{f.abc_btn_check_material, f.abc_btn_radio_material};
    private final WeakReference k;
    private SparseArray l;
    private ColorStateList m;

    private bi(Context context) {
        this.k = new WeakReference(context);
    }

    public static Drawable a(Context context, int i) {
        boolean z = a(f, i) || a(e, i) || a(g, i) || a(i, i) || a(h, i) || a(j, i) || i == f.abc_cab_background_top_material;
        return z ? a(context).a(i, false) : a.getDrawable(context, i);
    }

    public static bi a(Context context) {
        bi biVar = (bi) c.get(context);
        if (biVar != null) {
            return biVar;
        }
        biVar = new bi(context);
        c.put(context, biVar);
        return biVar;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (mode == null) {
            mode = b;
        }
        ColorFilter colorFilter = (PorterDuffColorFilter) d.a((Object) Integer.valueOf(bj.a(i, mode)));
        if (colorFilter == null) {
            ColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) d.a(Integer.valueOf(bj.a(i, mode)), porterDuffColorFilter);
            colorFilter = porterDuffColorFilter;
        }
        drawable.setColorFilter(colorFilter);
    }

    public static void a(View view, bh bhVar) {
        Drawable background = view.getBackground();
        if (bhVar.d) {
            a(background, bhVar.a.getColorForState(view.getDrawableState(), bhVar.a.getDefaultColor()), bhVar.c ? bhVar.b : null);
        } else {
            background.clearColorFilter();
        }
        if (VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList a(int i) {
        Context context = (Context) this.k.get();
        if (context == null) {
            return null;
        }
        ColorStateList colorStateList = this.l != null ? (ColorStateList) this.l.get(i) : null;
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[] iArr;
        int c;
        int[] iArr2;
        int a;
        int[] iArr3;
        int a2;
        if (i == f.abc_edit_text_material) {
            iArr = be.a;
            c = be.c(context, b.colorControlNormal);
            iArr2 = be.g;
            a = be.a(context, b.colorControlNormal);
            iArr3 = be.h;
            a2 = be.a(context, b.colorControlActivated);
            colorStateList2 = new ColorStateList(new int[][]{iArr, iArr2, iArr3}, new int[]{c, a, a2});
        } else if (i == f.abc_switch_track_mtrl_alpha) {
            iArr = be.a;
            c = be.a(context, 16842800, 0.1f);
            iArr2 = be.e;
            a = be.a(context, b.colorControlActivated, 0.3f);
            iArr3 = be.h;
            a2 = be.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(new int[][]{iArr, iArr2, iArr3}, new int[]{c, a, a2});
        } else if (i == f.abc_switch_thumb_material) {
            int[][] iArr4 = new int[3][];
            int[] iArr5 = new int[3];
            ColorStateList b = be.b(context, b.colorSwitchThumbNormal);
            if (b == null || !b.isStateful()) {
                iArr4[0] = be.a;
                iArr5[0] = be.c(context, b.colorSwitchThumbNormal);
                iArr4[1] = be.e;
                iArr5[1] = be.a(context, b.colorControlActivated);
                iArr4[2] = be.h;
                iArr5[2] = be.a(context, b.colorSwitchThumbNormal);
            } else {
                iArr4[0] = be.a;
                iArr5[0] = b.getColorForState(iArr4[0], 0);
                iArr4[1] = be.e;
                iArr5[1] = be.a(context, b.colorControlActivated);
                iArr4[2] = be.h;
                iArr5[2] = b.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr4, iArr5);
        } else if (i == f.abc_btn_default_mtrl_shape || i == f.abc_btn_borderless_material) {
            r1 = be.a(context, b.colorButtonNormal);
            c = be.a(context, b.colorControlHighlight);
            iArr2 = be.a;
            a = be.c(context, b.colorButtonNormal);
            iArr3 = be.d;
            a2 = android.support.v4.c.a.a(c, r1);
            int[] iArr6 = be.b;
            c = android.support.v4.c.a.a(c, r1);
            colorStateList2 = new ColorStateList(new int[][]{iArr2, iArr3, iArr6, be.h}, new int[]{a, a2, c, r1});
        } else if (i == f.abc_spinner_mtrl_am_alpha || i == f.abc_spinner_textfield_background_material) {
            iArr = be.a;
            c = be.c(context, b.colorControlNormal);
            iArr2 = be.g;
            a = be.a(context, b.colorControlNormal);
            iArr3 = be.h;
            a2 = be.a(context, b.colorControlActivated);
            colorStateList2 = new ColorStateList(new int[][]{iArr, iArr2, iArr3}, new int[]{c, a, a2});
        } else if (a(f, i)) {
            colorStateList2 = be.b(context, b.colorControlNormal);
        } else if (a(i, i)) {
            if (this.m == null) {
                r1 = be.a(context, b.colorControlNormal);
                c = be.a(context, b.colorControlActivated);
                iArr2 = be.a;
                int c2 = be.c(context, b.colorControlNormal);
                this.m = new ColorStateList(new int[][]{iArr2, be.b, be.c, be.d, be.e, be.f, be.h}, new int[]{c2, c, c, c, c, c, r1});
            }
            colorStateList2 = this.m;
        } else if (a(j, i)) {
            iArr = be.a;
            c = be.c(context, b.colorControlNormal);
            iArr2 = be.e;
            a = be.a(context, b.colorControlActivated);
            iArr3 = be.h;
            a2 = be.a(context, b.colorControlNormal);
            colorStateList2 = new ColorStateList(new int[][]{iArr, iArr2, iArr3}, new int[]{c, a, a2});
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 == null) {
            return colorStateList2;
        }
        if (this.l == null) {
            this.l = new SparseArray();
        }
        this.l.append(i, colorStateList2);
        return colorStateList2;
    }

    public final Drawable a(int i, boolean z) {
        Mode mode = null;
        Context context = (Context) this.k.get();
        if (context == null) {
            return null;
        }
        Drawable drawable = a.getDrawable(context, i);
        if (drawable != null) {
            if (VERSION.SDK_INT >= 8) {
                drawable = drawable.mutate();
            }
            ColorStateList a = a(i);
            if (a != null) {
                drawable = android.support.v4.c.a.a.c(drawable);
                android.support.v4.c.a.a.a(drawable, a);
                if (i == f.abc_switch_thumb_material) {
                    mode = Mode.MULTIPLY;
                }
                if (mode != null) {
                    android.support.v4.c.a.a.a(drawable, mode);
                }
            } else if (i == f.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{a(f.abc_cab_background_internal_bg, false), a(f.abc_cab_background_top_mtrl_alpha, false)});
            } else if (!a(i, drawable) && z) {
                drawable = null;
            }
        }
        return drawable;
    }

    public final boolean a(int i, Drawable drawable) {
        Mode mode = null;
        Context context = (Context) this.k.get();
        if (context == null) {
            return false;
        }
        int i2;
        int i3;
        Object obj;
        if (a(e, i)) {
            i2 = b.colorControlNormal;
            i3 = -1;
            obj = 1;
        } else if (a(g, i)) {
            i2 = b.colorControlActivated;
            i3 = -1;
            r4 = 1;
        } else if (a(h, i)) {
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
            r4 = 1;
        } else if (i == f.abc_list_divider_mtrl_alpha) {
            i3 = Math.round(40.8f);
            i2 = 16842800;
            r4 = 1;
        } else {
            obj = null;
            i2 = 0;
            i3 = -1;
        }
        if (obj == null) {
            return false;
        }
        a(drawable, be.a(context, i2), mode);
        if (i3 != -1) {
            drawable.setAlpha(i3);
        }
        return true;
    }
}
