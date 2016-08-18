package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.i;
import android.support.v7.app.d;
import android.support.v7.app.f;
import android.support.v7.app.h;
import android.support.v7.app.j;
import android.support.v7.app.l;
import android.support.v7.app.m;
import android.support.v7.app.n;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public final class g implements x, OnItemClickListener {
    Context a;
    public LayoutInflater b;
    i c;
    public ExpandedMenuView d;
    int e;
    int f;
    public y g;
    public h h;
    private int i;

    private g(int i, int i2) {
        this.f = i;
        this.e = 0;
    }

    public g(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public final ListAdapter a() {
        if (this.h == null) {
            this.h = new h(this);
        }
        return this.h;
    }

    public final boolean collapseItemActionView(i iVar, m mVar) {
        return false;
    }

    public final boolean expandItemActionView(i iVar, m mVar) {
        return false;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void initForMenu(Context context, i iVar) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(context, this.e);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = iVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public final void onCloseMenu(i iVar, boolean z) {
        if (this.g != null) {
            this.g.onCloseMenu(iVar, z);
        }
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.c.a(this.h.a(i), (x) this, 0);
    }

    public final boolean onSubMenuSelected(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        l lVar = new l(adVar);
        i iVar = lVar.a;
        n nVar = new n(iVar.a);
        lVar.c = new g(nVar.a.a, i.abc_list_menu_item_layout);
        lVar.c.g = lVar;
        lVar.a.a(lVar.c);
        nVar.a.t = lVar.c.a();
        nVar.a.u = lVar;
        View view = iVar.h;
        if (view != null) {
            nVar.a.g = view;
        } else {
            nVar.a.d = iVar.g;
            nVar.a.f = iVar.f;
        }
        nVar.a.r = lVar;
        m mVar = new m(nVar.a.a, nVar.b);
        f fVar = nVar.a;
        d a = mVar.a;
        if (fVar.g != null) {
            a.C = fVar.g;
        } else {
            if (fVar.f != null) {
                a.a(fVar.f);
            }
            if (fVar.d != null) {
                Drawable drawable = fVar.d;
                a.y = drawable;
                a.x = 0;
                if (a.z != null) {
                    if (drawable != null) {
                        a.z.setImageDrawable(drawable);
                    } else {
                        a.z.setVisibility(8);
                    }
                }
            }
            if (fVar.c != 0) {
                a.a(fVar.c);
            }
            if (fVar.e != 0) {
                int i = fVar.e;
                TypedValue typedValue = new TypedValue();
                a.a.getTheme().resolveAttribute(i, typedValue, true);
                a.a(typedValue.resourceId);
            }
        }
        if (fVar.h != null) {
            CharSequence charSequence = fVar.h;
            a.e = charSequence;
            if (a.B != null) {
                a.B.setText(charSequence);
            }
        }
        if (fVar.i != null) {
            a.a(-1, fVar.i, fVar.j, null);
        }
        if (fVar.k != null) {
            a.a(-2, fVar.k, fVar.l, null);
        }
        if (fVar.m != null) {
            a.a(-3, fVar.m, fVar.n, null);
        }
        if (!(fVar.s == null && fVar.H == null && fVar.t == null)) {
            ListAdapter gVar;
            ListView listView = (ListView) fVar.b.inflate(a.H, null);
            if (fVar.D) {
                gVar = fVar.H == null ? new android.support.v7.app.g(fVar, fVar.a, a.I, 16908308, fVar.s, listView) : new h(fVar, fVar.a, fVar.H, false, listView, a);
            } else {
                int i2 = fVar.E ? a.J : a.K;
                gVar = fVar.H == null ? fVar.t != null ? fVar.t : new l(fVar.a, i2, 16908308, fVar.s) : new SimpleCursorAdapter(fVar.a, i2, fVar.H, new String[]{fVar.I}, new int[]{16908308});
            }
            a.D = gVar;
            a.E = fVar.F;
            if (fVar.u != null) {
                listView.setOnItemClickListener(new android.support.v7.app.i(fVar, a));
            } else if (fVar.G != null) {
                listView.setOnItemClickListener(new j(fVar, listView, a));
            }
            if (fVar.K != null) {
                listView.setOnItemSelectedListener(fVar.K);
            }
            if (fVar.E) {
                listView.setChoiceMode(1);
            } else if (fVar.D) {
                listView.setChoiceMode(2);
            }
            a.f = listView;
        }
        if (fVar.w != null) {
            if (fVar.B) {
                View view2 = fVar.w;
                int i3 = fVar.x;
                int i4 = fVar.y;
                int i5 = fVar.z;
                int i6 = fVar.A;
                a.g = view2;
                a.h = 0;
                a.m = true;
                a.i = i3;
                a.j = i4;
                a.k = i5;
                a.l = i6;
            } else {
                a.g = fVar.w;
                a.h = 0;
                a.m = false;
            }
        } else if (fVar.v != 0) {
            i = fVar.v;
            a.g = null;
            a.h = i;
            a.m = false;
        }
        mVar.setCancelable(nVar.a.o);
        if (nVar.a.o) {
            mVar.setCanceledOnTouchOutside(true);
        }
        mVar.setOnCancelListener(nVar.a.p);
        mVar.setOnDismissListener(nVar.a.q);
        if (nVar.a.r != null) {
            mVar.setOnKeyListener(nVar.a.r);
        }
        lVar.b = mVar;
        lVar.b.setOnDismissListener(lVar);
        LayoutParams attributes = lVar.b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        lVar.b.show();
        if (this.g != null) {
            this.g.onOpenSubMenu(adVar);
        }
        return true;
    }

    public final void updateMenuView(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }
}
