package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.h.f;
import java.util.Locale;

public enum am implements f {
    PURCHASES(String.format(Locale.US, "https://purchases.pardakht.cafebazaar.ir/%s", new Object[]{"json/"}));
    
    private final String b;

    private am(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
