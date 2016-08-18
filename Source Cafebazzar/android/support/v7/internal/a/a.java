package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.l;
import android.support.v7.internal.view.b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public final class a {
    static final Class[] a = new Class[]{Context.class, AttributeSet.class};
    private static final Map b = new android.support.v4.f.a();
    private final Object[] c = new Object[2];

    public static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(l.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(l.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
                i = resourceId;
                obtainStyledAttributes.recycle();
                return i == 0 ? ((context instanceof b) || ((b) context).a != i) ? new b(context, i) : context : context;
            }
        }
        i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
        }
        if (context instanceof b) {
        }
    }

    private View a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) b.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(a);
                b.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.c);
    }

    public View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.c[0] = context;
            this.c[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                a = a(context, str, "android.widget.");
                return a;
            }
            a = a(context, str, null);
            this.c[0] = null;
            this.c[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.c[0] = null;
            this.c[1] = null;
        }
    }
}
