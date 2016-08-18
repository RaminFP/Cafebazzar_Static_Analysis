package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.h.f;
import java.util.Locale;

public enum ao implements f {
    IAP(String.format(Locale.US, "https://sku.pardakht.cafebazaar.ir/%s", new Object[]{"json/"}));
    
    private final String b;

    private ao(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
