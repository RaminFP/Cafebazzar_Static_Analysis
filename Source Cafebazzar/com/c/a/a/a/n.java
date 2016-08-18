package com.c.a.a.a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class n extends ThreadLocal {
    n() {
    }

    protected final /* synthetic */ Object initialValue() {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(m.a);
        return simpleDateFormat;
    }
}
