package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.d.a.a;
import android.support.v4.view.as;
import android.support.v4.view.n;
import android.support.v7.a.c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class i implements a {
    private static final int[] l = new int[]{1, 4, 5, 3, 2, 0};
    final Context a;
    public j b;
    ArrayList c;
    public ArrayList d;
    public int e = 1;
    CharSequence f;
    Drawable g;
    View h;
    boolean i = false;
    m j;
    public boolean k;
    private final Resources m;
    private boolean n;
    private boolean o;
    private ArrayList p;
    private boolean q;
    private ArrayList r;
    private boolean s;
    private ContextMenuInfo t;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private ArrayList x = new ArrayList();
    private CopyOnWriteArrayList y = new CopyOnWriteArrayList();

    public i(Context context) {
        boolean z = true;
        this.a = context;
        this.m = context.getResources();
        this.c = new ArrayList();
        this.p = new ArrayList();
        this.q = true;
        this.d = new ArrayList();
        this.r = new ArrayList();
        this.s = true;
        if (this.m.getConfiguration().keyboard == 1 || !this.m.getBoolean(c.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z = false;
        }
        this.o = z;
    }

    private static int a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((m) arrayList.get(size)).a <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private m a(int i, KeyEvent keyEvent) {
        List list = this.x;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (m) list.get(0);
        }
        boolean b = b();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = (m) list.get(i2);
            char alphabeticShortcut = b ? mVar.getAlphabeticShortcut() : mVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return mVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return mVar;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return mVar;
            }
        }
        return null;
    }

    private MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = i3 >> 16;
        if (i4 < 0 || i4 >= l.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (l[i4] << 16) | (65535 & i3);
        MenuItem mVar = new m(this, i, i2, i3, i5, charSequence, this.e);
        if (this.t != null) {
            mVar.e = this.t;
        }
        this.c.add(a(this.c, i5), mVar);
        b(true);
        return mVar;
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.c.size()) {
            this.c.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    private void a(List list, int i, KeyEvent keyEvent) {
        boolean b = b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar = (m) this.c.get(i2);
                if (mVar.hasSubMenu()) {
                    ((i) mVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? mVar.getAlphabeticShortcut() : mVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && mVar.isEnabled())) {
                    list.add(mVar);
                }
            }
        }
    }

    protected final i a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected final i a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.h = view;
            this.f = null;
            this.g = null;
        } else {
            if (charSequence != null) {
                this.f = charSequence;
            }
            if (drawable != null) {
                this.g = drawable;
            }
            this.h = null;
        }
        b(false);
    }

    public final void a(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        int i = 0;
        while (i < size) {
            SparseArray sparseArray2;
            MenuItem item = getItem(i);
            View a = as.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (as.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                    sparseArray2 = sparseArray;
                    if (item.hasSubMenu()) {
                        ((ad) item.getSubMenu()).a(bundle);
                    }
                    i++;
                    sparseArray = sparseArray2;
                }
            }
            sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ad) item.getSubMenu()).a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void a(j jVar) {
        this.b = jVar;
    }

    public final void a(x xVar) {
        a(xVar, this.a);
    }

    public final void a(x xVar, Context context) {
        this.y.add(new WeakReference(xVar));
        xVar.initForMenu(context, this);
        this.s = true;
    }

    public final void a(boolean z) {
        if (!this.w) {
            this.w = true;
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    this.y.remove(weakReference);
                } else {
                    xVar.onCloseMenu(this, z);
                }
            }
            this.w = false;
        }
    }

    boolean a(i iVar, MenuItem menuItem) {
        return this.b != null && this.b.onMenuItemSelected(iVar, menuItem);
    }

    public boolean a(m mVar) {
        boolean z = false;
        if (!this.y.isEmpty()) {
            d();
            Iterator it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar != null) {
                    z = xVar.expandItemActionView(this, mVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                } else {
                    this.y.remove(weakReference);
                }
            }
            z = z2;
            e();
            if (z) {
                this.j = mVar;
            }
        }
        return z;
    }

    public final boolean a(MenuItem menuItem, x xVar, int i) {
        boolean z = false;
        m mVar = (m) menuItem;
        if (mVar == null || !mVar.isEnabled()) {
            return false;
        }
        boolean b = mVar.b();
        n nVar = mVar.d;
        boolean z2 = nVar != null && nVar.hasSubMenu();
        if (mVar.i()) {
            z = mVar.expandActionView() | b;
            if (!z) {
                return z;
            }
            a(true);
            return z;
        } else if (mVar.hasSubMenu() || z2) {
            int i2;
            a(false);
            if (!mVar.hasSubMenu()) {
                mVar.a(new ad(this.a, this, mVar));
            }
            ad adVar = (ad) mVar.getSubMenu();
            if (z2) {
                nVar.onPrepareSubMenu(adVar);
            }
            if (this.y.isEmpty()) {
                i2 = 0;
            } else {
                if (xVar != null) {
                    z = xVar.onSubMenuSelected(adVar);
                }
                Iterator it = this.y.iterator();
                i2 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    x xVar2 = (x) weakReference.get();
                    if (xVar2 == null) {
                        this.y.remove(weakReference);
                    } else {
                        i2 = i2 == 0 ? xVar2.onSubMenuSelected(adVar) : i2;
                    }
                }
            }
            z = b | i2;
            if (z) {
                return z;
            }
            a(true);
            return z;
        } else {
            if ((i & 1) == 0) {
                a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.m.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.m.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.a.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.m.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.m.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        m mVar = (m) a(i, i2, i3, charSequence);
        ad adVar = new ad(this.a, this, mVar);
        mVar.a(adVar);
        return adVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = as.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ad) item.getSubMenu()).b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    as.b(item);
                }
            }
        }
    }

    public final void b(x xVar) {
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar2 = (x) weakReference.get();
            if (xVar2 == null || xVar2 == xVar) {
                this.y.remove(weakReference);
            }
        }
    }

    public final void b(boolean z) {
        if (this.u) {
            this.v = true;
            return;
        }
        if (z) {
            this.q = true;
            this.s = true;
        }
        if (!this.y.isEmpty()) {
            d();
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    this.y.remove(weakReference);
                } else {
                    xVar.updateMenuView(z);
                }
            }
            e();
        }
    }

    boolean b() {
        return this.n;
    }

    public boolean b(m mVar) {
        boolean z = false;
        if (!this.y.isEmpty() && this.j == mVar) {
            d();
            Iterator it = this.y.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar != null) {
                    z = xVar.collapseItemActionView(this, mVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                } else {
                    this.y.remove(weakReference);
                }
            }
            z = z2;
            e();
            if (z) {
                this.j = null;
            }
        }
        return z;
    }

    public boolean c() {
        return this.o;
    }

    public void clear() {
        if (this.j != null) {
            b(this.j);
        }
        this.c.clear();
        b(true);
    }

    public void clearHeader() {
        this.g = null;
        this.f = null;
        this.h = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    public final void d() {
        if (!this.u) {
            this.u = true;
            this.v = false;
        }
    }

    public final void e() {
        this.u = false;
        if (this.v) {
            this.v = false;
            b(true);
        }
    }

    final void f() {
        this.q = true;
        b(true);
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = (m) this.c.get(i2);
            if (mVar.getItemId() == i) {
                return mVar;
            }
            if (mVar.hasSubMenu()) {
                MenuItem findItem = mVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    final void g() {
        this.s = true;
        b(true);
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.c.get(i);
    }

    public final ArrayList h() {
        if (!this.q) {
            return this.p;
        }
        this.p.clear();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            m mVar = (m) this.c.get(i);
            if (mVar.isVisible()) {
                this.p.add(mVar);
            }
        }
        this.q = false;
        this.s = true;
        return this.p;
    }

    public boolean hasVisibleItems() {
        if (this.k) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((m) this.c.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList h = h();
        if (this.s) {
            Iterator it = this.y.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    this.y.remove(weakReference);
                } else {
                    i = xVar.flagActionItems() | i;
                }
            }
            if (i != 0) {
                this.d.clear();
                this.r.clear();
                i = h.size();
                for (int i2 = 0; i2 < i; i2++) {
                    m mVar = (m) h.get(i2);
                    if (mVar.f()) {
                        this.d.add(mVar);
                    } else {
                        this.r.add(mVar);
                    }
                }
            } else {
                this.d.clear();
                this.r.clear();
                this.r.addAll(h());
            }
            this.s = false;
        }
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public final ArrayList j() {
        i();
        return this.r;
    }

    public i k() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return z;
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((m) this.c.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.c.size();
            for (i2 = 0; i2 < size2 - size && ((m) this.c.get(size)).getGroupId() == i; i2++) {
                a(size, false);
            }
            b(true);
        }
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((m) this.c.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        a(i2, true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = (m) this.c.get(i2);
            if (mVar.getGroupId() == i) {
                mVar.a(z2);
                mVar.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = (m) this.c.get(i2);
            if (mVar.getGroupId() == i) {
                mVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.c.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            m mVar = (m) this.c.get(i2);
            boolean z3 = (mVar.getGroupId() == i && mVar.c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.n = z;
        b(false);
    }

    public int size() {
        return this.c.size();
    }
}
