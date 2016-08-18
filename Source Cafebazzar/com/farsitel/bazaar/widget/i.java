package com.farsitel.bazaar.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

final class i implements OnSeekBarChangeListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (((long) this.a.a.getDuration()) * ((long) i)) / 1000;
            this.a.a.seekTo((int) duration);
            if (this.a.b != null) {
                this.a.b.a((long) ((int) duration));
            }
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.a.f = true;
        this.a.g.removeMessages(0);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.a.f = false;
        h.a(this.a);
        this.a.g.sendEmptyMessage(0);
        this.a.c.setVisibility(4);
    }
}
