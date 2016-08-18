package com.d.a;

import android.util.Log;
import com.d.a.b.d;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static boolean a = false;
    public static List b = new ArrayList();
    public static boolean c = true;
    public static int d = 20000;
    private static com.d.a.c.a e = null;

    public static d a(boolean z) {
        return d.a(25000);
    }

    public static void a(String str) {
        a(null, str, 3, null);
    }

    public static void a(String str, int i, Exception exception) {
        a(null, str, 2, exception);
    }

    private static void a(String str, String str2, int i, Exception exception) {
        if (str2 != null && !str2.equals("") && a) {
            switch (i) {
                case 1:
                    Log.v("RootTools v3.4", str2);
                    return;
                case 2:
                    Log.e("RootTools v3.4", str2, exception);
                    return;
                case 3:
                    Log.d("RootTools v3.4", str2);
                    return;
                default:
                    return;
            }
        }
    }
}
