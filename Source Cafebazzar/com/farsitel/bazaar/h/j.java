package com.farsitel.bazaar.h;

public enum j implements f {
    APPS_LIST(i.a("al", "json/")),
    CATEGS_LIST(i.a("ca", "json/")),
    APP_DETAILS(i.a("ad", "json/")),
    APP_REQUEST(i.a("aq", "json/")),
    APP_REPORT(i.a("ar", "json/")),
    SUPPORT(i.a("sp", "json/")),
    BOOKMARK(i.a("bk", "json/")),
    REVIEW_READ(i.a("rr", "json/")),
    REVIEW_WRITE(i.a("rw", "json/")),
    REVIEW_BILLUP(i.a("rb", "json/")),
    DEVICE_REGISTER(i.a("dr", "json/")),
    USER_WRITE(i.a("uw", "json/")),
    USER_CREDIT(i.a("uc", "json/")),
    APP_PURCHASE(i.a("ap", "json/")),
    UPGRADABLE_APPS(i.a("ua", "json/")),
    SHETAB(i.a("shetab", "pay/")),
    PAYMENT(i.a("payment", "json/")),
    PURCHASE_BY_CREDIT(i.a("ap", "json/"));
    
    private final String s;

    private j(String str) {
        this.s = str;
    }

    public final String a() {
        return this.s;
    }
}
