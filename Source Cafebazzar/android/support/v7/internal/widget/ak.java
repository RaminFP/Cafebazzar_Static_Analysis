package android.support.v7.internal.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.c.a.a;
import android.util.Log;
import java.lang.reflect.Field;

public final class ak {
    public static final Rect a = new Rect();
    private static Class b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static Rect a(Drawable drawable) {
        if (b != null) {
            Drawable d = a.d(drawable);
            Object invoke = d.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(d, new Object[0]);
            if (invoke != null) {
                Rect rect = new Rect();
                Field[] fields = b.getFields();
                int length = fields.length;
                int i = 0;
                while (i < length) {
                    Field field = fields[i];
                    try {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                        i++;
                    } catch (Exception e) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                    }
                }
                return rect;
            }
        }
        return a;
    }
}
