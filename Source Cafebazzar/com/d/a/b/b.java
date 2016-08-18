package com.d.a.b;

import android.os.Handler;
import android.os.Message;

final class b extends Handler {
    final /* synthetic */ a a;

    private b(a aVar) {
        this.a = aVar;
    }

    public final void handleMessage(Message message) {
        int i = message.getData().getInt("action");
        message.getData().getString("text");
        switch (i) {
            case 2:
                this.a.a();
                return;
            default:
                return;
        }
    }
}
