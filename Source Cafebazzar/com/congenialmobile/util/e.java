package com.congenialmobile.util;

import android.text.TextUtils;
import java.util.Locale;

public final class e {
    public static String a(int i) {
        return b(String.valueOf(i));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            str2 = (charAt < '۰' || charAt > '۹') ? str2 + charAt : str2 + Character.toString((char) (charAt - 1728));
        }
        return str2;
    }

    public static String b(String str) {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (!"fa".equals(language) || "TJ".equals(country)) {
            return str;
        }
        country = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            country = (charAt < '0' || charAt > '9') ? country + charAt : country + Character.toString((char) (charAt + 1728));
        }
        return country;
    }
}
