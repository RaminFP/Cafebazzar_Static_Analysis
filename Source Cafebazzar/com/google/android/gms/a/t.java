package com.google.android.gms.a;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.av;

public abstract class t extends u implements ay {
    final d a;

    public final void a(Status status) {
        av.b(!status.b(), "Failed result must not be success");
        a(b_());
    }
}
