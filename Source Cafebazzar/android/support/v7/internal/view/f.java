package android.support.v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.d.a.a;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;

public final class f extends MenuInflater {
    private static final Class[] a;
    private static final Class[] b;
    private final Object[] c;
    private final Object[] d = this.c;
    private Context e;
    private Object f;

    static {
        Class[] clsArr = new Class[]{Context.class};
        a = clsArr;
        b = clsArr;
    }

    public f(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    private Object a(Object obj) {
        Object obj2 = obj;
        while (!(obj2 instanceof Activity) && (obj2 instanceof ContextWrapper)) {
            obj2 = ((ContextWrapper) obj2).getBaseContext();
        }
        return obj2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r5 = new android.support.v7.internal.view.h;
        r5.<init>(r10, r13);
        r0 = r11.getEventType();
        r1 = 0;
        r3 = 0;
    L_0x000b:
        r2 = 2;
        if (r0 != r2) goto L_0x0046;
    L_0x000e:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001a:
        r0 = r11.next();
    L_0x001e:
        r2 = 0;
    L_0x001f:
        if (r2 != 0) goto L_0x0230;
    L_0x0021:
        switch(r0) {
            case 1: goto L_0x0228;
            case 2: goto L_0x004e;
            case 3: goto L_0x01bd;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0027:
        r3 = r11.next();
        r9 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x001f;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0046:
        r0 = r11.next();
        r2 = 1;
        if (r0 != r2) goto L_0x000b;
    L_0x004d:
        goto L_0x001e;
    L_0x004e:
        if (r1 != 0) goto L_0x0024;
    L_0x0050:
        r4 = r11.getName();
        r0 = "group";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x00a3;
    L_0x005c:
        r0 = r5.z;
        r0 = r0.e;
        r4 = android.support.v7.a.l.MenuGroup;
        r0 = r0.obtainStyledAttributes(r12, r4);
        r4 = android.support.v7.a.l.MenuGroup_android_id;
        r6 = 0;
        r4 = r0.getResourceId(r4, r6);
        r5.b = r4;
        r4 = android.support.v7.a.l.MenuGroup_android_menuCategory;
        r6 = 0;
        r4 = r0.getInt(r4, r6);
        r5.c = r4;
        r4 = android.support.v7.a.l.MenuGroup_android_orderInCategory;
        r6 = 0;
        r4 = r0.getInt(r4, r6);
        r5.d = r4;
        r4 = android.support.v7.a.l.MenuGroup_android_checkableBehavior;
        r6 = 0;
        r4 = r0.getInt(r4, r6);
        r5.e = r4;
        r4 = android.support.v7.a.l.MenuGroup_android_visible;
        r6 = 1;
        r4 = r0.getBoolean(r4, r6);
        r5.f = r4;
        r4 = android.support.v7.a.l.MenuGroup_android_enabled;
        r6 = 1;
        r4 = r0.getBoolean(r4, r6);
        r5.g = r4;
        r0.recycle();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x00a3:
        r0 = "item";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x01a4;
    L_0x00ab:
        r0 = r5.z;
        r0 = r0.e;
        r4 = android.support.v7.a.l.MenuItem;
        r4 = r0.obtainStyledAttributes(r12, r4);
        r0 = android.support.v7.a.l.MenuItem_android_id;
        r6 = 0;
        r0 = r4.getResourceId(r0, r6);
        r5.i = r0;
        r0 = android.support.v7.a.l.MenuItem_android_menuCategory;
        r6 = r5.c;
        r0 = r4.getInt(r0, r6);
        r6 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r6;
        r6 = android.support.v7.a.l.MenuItem_android_orderInCategory;
        r7 = r5.d;
        r6 = r4.getInt(r6, r7);
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r7;
        r0 = r0 | r6;
        r5.j = r0;
        r0 = android.support.v7.a.l.MenuItem_android_title;
        r0 = r4.getText(r0);
        r5.k = r0;
        r0 = android.support.v7.a.l.MenuItem_android_titleCondensed;
        r0 = r4.getText(r0);
        r5.l = r0;
        r0 = android.support.v7.a.l.MenuItem_android_icon;
        r6 = 0;
        r0 = r4.getResourceId(r0, r6);
        r5.m = r0;
        r0 = android.support.v7.a.l.MenuItem_android_alphabeticShortcut;
        r0 = r4.getString(r0);
        r0 = android.support.v7.internal.view.h.a(r0);
        r5.n = r0;
        r0 = android.support.v7.a.l.MenuItem_android_numericShortcut;
        r0 = r4.getString(r0);
        r0 = android.support.v7.internal.view.h.a(r0);
        r5.o = r0;
        r0 = android.support.v7.a.l.MenuItem_android_checkable;
        r0 = r4.hasValue(r0);
        if (r0 == 0) goto L_0x0190;
    L_0x0111:
        r0 = android.support.v7.a.l.MenuItem_android_checkable;
        r6 = 0;
        r0 = r4.getBoolean(r0, r6);
        if (r0 == 0) goto L_0x018e;
    L_0x011a:
        r0 = 1;
    L_0x011b:
        r5.p = r0;
    L_0x011d:
        r0 = android.support.v7.a.l.MenuItem_android_checked;
        r6 = 0;
        r0 = r4.getBoolean(r0, r6);
        r5.q = r0;
        r0 = android.support.v7.a.l.MenuItem_android_visible;
        r6 = r5.f;
        r0 = r4.getBoolean(r0, r6);
        r5.r = r0;
        r0 = android.support.v7.a.l.MenuItem_android_enabled;
        r6 = r5.g;
        r0 = r4.getBoolean(r0, r6);
        r5.s = r0;
        r0 = android.support.v7.a.l.MenuItem_showAsAction;
        r6 = -1;
        r0 = r4.getInt(r0, r6);
        r5.t = r0;
        r0 = android.support.v7.a.l.MenuItem_android_onClick;
        r0 = r4.getString(r0);
        r5.x = r0;
        r0 = android.support.v7.a.l.MenuItem_actionLayout;
        r6 = 0;
        r0 = r4.getResourceId(r0, r6);
        r5.u = r0;
        r0 = android.support.v7.a.l.MenuItem_actionViewClass;
        r0 = r4.getString(r0);
        r5.v = r0;
        r0 = android.support.v7.a.l.MenuItem_actionProviderClass;
        r0 = r4.getString(r0);
        r5.w = r0;
        r0 = r5.w;
        if (r0 == 0) goto L_0x0195;
    L_0x0168:
        r0 = 1;
    L_0x0169:
        if (r0 == 0) goto L_0x0197;
    L_0x016b:
        r6 = r5.u;
        if (r6 != 0) goto L_0x0197;
    L_0x016f:
        r6 = r5.v;
        if (r6 != 0) goto L_0x0197;
    L_0x0173:
        r0 = r5.w;
        r6 = b;
        r7 = r5.z;
        r7 = r7.d;
        r0 = r5.a(r0, r6, r7);
        r0 = (android.support.v4.view.n) r0;
        r5.y = r0;
    L_0x0183:
        r4.recycle();
        r0 = 0;
        r5.h = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x018e:
        r0 = 0;
        goto L_0x011b;
    L_0x0190:
        r0 = r5.e;
        r5.p = r0;
        goto L_0x011d;
    L_0x0195:
        r0 = 0;
        goto L_0x0169;
    L_0x0197:
        if (r0 == 0) goto L_0x01a0;
    L_0x0199:
        r0 = "SupportMenuInflater";
        r6 = "Ignoring attribute 'actionProviderClass'. Action view already specified.";
        android.util.Log.w(r0, r6);
    L_0x01a0:
        r0 = 0;
        r5.y = r0;
        goto L_0x0183;
    L_0x01a4:
        r0 = "menu";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x01b8;
    L_0x01ac:
        r0 = r5.b();
        r10.a(r11, r12, r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x01b8:
        r0 = 1;
        r1 = r2;
        r2 = r4;
        goto L_0x0027;
    L_0x01bd:
        r0 = r11.getName();
        if (r1 == 0) goto L_0x01d0;
    L_0x01c3:
        r4 = r0.equals(r3);
        if (r4 == 0) goto L_0x01d0;
    L_0x01c9:
        r0 = 0;
        r1 = 0;
        r9 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0027;
    L_0x01d0:
        r4 = "group";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x01e0;
    L_0x01d8:
        r5.a();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x01e0:
        r4 = "item";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0219;
    L_0x01e8:
        r0 = r5.h;
        if (r0 != 0) goto L_0x0024;
    L_0x01ec:
        r0 = r5.y;
        if (r0 == 0) goto L_0x0200;
    L_0x01f0:
        r0 = r5.y;
        r0 = r0.hasSubMenu();
        if (r0 == 0) goto L_0x0200;
    L_0x01f8:
        r5.b();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x0200:
        r0 = 1;
        r5.h = r0;
        r0 = r5.a;
        r4 = r5.b;
        r6 = r5.i;
        r7 = r5.j;
        r8 = r5.k;
        r0 = r0.add(r4, r6, r7, r8);
        r5.a(r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0027;
    L_0x0219:
        r4 = "menu";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0024;
    L_0x0221:
        r0 = 1;
        r2 = r3;
        r9 = r0;
        r0 = r1;
        r1 = r9;
        goto L_0x0027;
    L_0x0228:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x0230:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.f.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    static /* synthetic */ Object b(f fVar) {
        if (fVar.f == null) {
            fVar.f = fVar.a(fVar.e);
        }
        return fVar.f;
    }

    public final void inflate(int i, Menu menu) {
        XmlResourceParser xmlResourceParser = null;
        if (menu instanceof a) {
            try {
                xmlResourceParser = this.e.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
