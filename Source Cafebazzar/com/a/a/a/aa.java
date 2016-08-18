package com.a.a.a;

import java.math.BigDecimal;
import java.util.Currency;

public final class aa extends z {
    static final BigDecimal d = BigDecimal.valueOf(1000000);

    public final aa a(String str) {
        this.c.a("itemId", str);
        return this;
    }

    public final aa a(BigDecimal bigDecimal) {
        if (!this.a.a(bigDecimal, "itemPrice")) {
            this.c.a("itemPrice", Long.valueOf(d.multiply(bigDecimal).longValue()));
        }
        return this;
    }

    public final aa a(Currency currency) {
        if (!this.a.a(currency, "currency")) {
            this.c.a("currency", currency.getCurrencyCode());
        }
        return this;
    }

    public final aa a(boolean z) {
        this.c.a("success", Boolean.toString(true));
        return this;
    }

    final String a() {
        return "purchase";
    }

    public final aa b(String str) {
        this.c.a("itemType", str);
        return this;
    }
}
