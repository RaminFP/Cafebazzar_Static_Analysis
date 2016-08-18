package android.support.v4.e;

import java.util.Locale;

class i {
    private i() {
    }

    public int a(Locale locale) {
        if (locale == null || locale.equals(h.a)) {
            return 0;
        }
        String a = a.a(locale);
        if (a == null) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    break;
                default:
                    return 0;
            }
        } else if (!(a.equalsIgnoreCase(h.c) || a.equalsIgnoreCase(h.d))) {
            return 0;
        }
        return 1;
    }
}
