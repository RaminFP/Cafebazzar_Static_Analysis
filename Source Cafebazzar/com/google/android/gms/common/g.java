package com.google.android.gms.common;

import android.content.Intent;

public class g extends Exception {
    public final Intent b;

    public g(String str, Intent intent) {
        super(str);
        this.b = intent;
    }
}
