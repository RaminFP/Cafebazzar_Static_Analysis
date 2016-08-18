package com.farsitel.bazaar.util;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;

public final class ag {
    public static void a(Context context, IBinder iBinder) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        } catch (Exception e) {
        }
    }
}
