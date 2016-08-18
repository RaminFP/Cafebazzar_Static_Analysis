package android.support.v4.e;

import android.text.TextUtils;
import java.util.Locale;

final class j extends i {
    private j() {
        super();
    }

    public final int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
