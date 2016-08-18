package com.farsitel.bazaar.util;

import com.congenialmobile.util.e;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Pattern;

public final class ax {
    public static int a(String str, Class cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            return declaredField.getInt(declaredField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean a(String str) {
        return Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+").matcher(str).matches();
    }

    public static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String toLowerCase = str.toLowerCase(Locale.ROOT);
        return ("false".equals(toLowerCase) || "0".equals(toLowerCase)) ? false : true;
    }

    public static boolean b(String str) {
        return Pattern.compile("(98|0)(9[0-9][0-9])([0-9]{7})").matcher(e.a(str)).matches();
    }
}
