package ir.cafebazaar.pardakht;

import com.farsitel.bazaar.h.f;
import java.util.Locale;

public enum d implements f {
    CONSUME_PURCHASE(String.format(Locale.US, "https://consumer.pardakht.cafebazaar.ir/%s", new Object[]{"json/"}));
    
    private final String b;

    private d(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
