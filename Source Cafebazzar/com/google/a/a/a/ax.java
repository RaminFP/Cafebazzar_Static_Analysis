package com.google.a.a.a;

import android.content.Context;
import android.text.TextUtils;

final class ax implements aw {
    private final Context a;
    private String b;

    public ax(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.a = context.getApplicationContext();
    }

    private int a(String str, String str2) {
        if (this.a == null) {
            return 0;
        }
        return this.a.getResources().getIdentifier(str, str2, this.b != null ? this.b : this.a.getPackageName());
    }

    public final int a(String str, int i) {
        int a = a(str, "integer");
        if (a != 0) {
            try {
                i = Integer.parseInt(this.a.getString(a));
            } catch (NumberFormatException e) {
                as.d("NumberFormatException parsing " + this.a.getString(a));
            }
        }
        return i;
    }

    public final String a(String str) {
        int a = a(str, "string");
        return a == 0 ? null : this.a.getString(a);
    }

    public final Double b(String str) {
        Double d = null;
        String a = a(str);
        if (TextUtils.isEmpty(a)) {
            return d;
        }
        try {
            return Double.valueOf(Double.parseDouble(a));
        } catch (NumberFormatException e) {
            as.d("NumberFormatException parsing " + a);
            return d;
        }
    }

    public final boolean c(String str) {
        int a = a(str, "bool");
        return a == 0 ? false : "true".equalsIgnoreCase(this.a.getString(a));
    }

    public final void d(String str) {
        this.b = str;
    }
}
