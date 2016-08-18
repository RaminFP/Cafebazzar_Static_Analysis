package com.android.a;

import android.content.Intent;

public final class a extends y {
    private Intent b;

    public a(m mVar) {
        super(mVar);
    }

    public final String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
