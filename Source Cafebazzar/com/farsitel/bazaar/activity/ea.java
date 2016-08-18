package com.farsitel.bazaar.activity;

import android.widget.Toast;
import com.farsitel.bazaar.util.q;

final class ea implements Runnable {
    final /* synthetic */ VideoPlayerActivity a;

    ea(VideoPlayerActivity videoPlayerActivity) {
        this.a = videoPlayerActivity;
    }

    public final void run() {
        if (q.e()) {
            Toast.makeText(this.a.getApplicationContext(), 2131165783, 0).show();
        } else {
            Toast.makeText(this.a.getApplicationContext(), 2131165452, 0).show();
        }
    }
}
