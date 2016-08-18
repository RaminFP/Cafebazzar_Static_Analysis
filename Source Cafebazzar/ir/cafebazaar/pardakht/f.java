package ir.cafebazaar.pardakht;

import java.util.Locale;

public enum f implements com.farsitel.bazaar.h.f {
    PAYMENT_WEB(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"payment/"})),
    INAPP_SERVICES(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"json/"})),
    BUY_CREDIT(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"buy-credit/"})),
    GET_CREDIT(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"json/"})),
    PURCHASE(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"json/"})),
    PAYMENT(String.format(Locale.US, "https://pardakht.cafebazaar.ir/%s", new Object[]{"json/"}));
    
    final String g;

    private f(String str) {
        this.g = str;
    }

    public final String a() {
        return this.g;
    }
}
