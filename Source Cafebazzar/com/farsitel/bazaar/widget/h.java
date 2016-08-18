package com.farsitel.bazaar.widget;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public final class h {
    MediaPlayerControl a;
    l b;
    public ImageView c;
    Context d;
    final int e;
    boolean f;
    public Handler g = new j(this);
    private SeekBar h;
    private l i;
    private View j;
    private View k;
    private OnSeekBarChangeListener l = new i(this);

    public h(Context context, ViewGroup viewGroup, LayoutParams layoutParams, MediaPlayerControl mediaPlayerControl) {
        this.d = context;
        View inflate = ((LayoutInflater) this.d.getSystemService("layout_inflater")).inflate(2130903138, null);
        inflate.setLayoutParams(layoutParams);
        viewGroup.addView(inflate);
        this.k = inflate.findViewById(2131624342);
        this.c = (ImageView) inflate.findViewById(2131624343);
        this.h = (SeekBar) inflate.findViewById(2131624346);
        this.h.setMax(1000);
        this.a = mediaPlayerControl;
        this.b = new l(this, (TextView) inflate.findViewById(2131624345));
        this.i = new l(this, (TextView) inflate.findViewById(2131624347));
        this.e = Math.min(mediaPlayerControl.getDuration() / 1000, 500);
        this.h.setOnSeekBarChangeListener(this.l);
        this.k.setOnClickListener(new k(this));
        this.j = inflate.findViewById(2131624344);
        this.c.setVisibility(4);
    }

    static /* synthetic */ void a(h hVar) {
        if (hVar.a != null) {
            try {
                int currentPosition = hVar.a.getCurrentPosition();
                int duration = hVar.a.getDuration();
                if (hVar.h != null) {
                    if (duration > 0) {
                        hVar.h.setProgress((int) ((1000 * ((long) currentPosition)) / ((long) duration)));
                    }
                    hVar.h.setSecondaryProgress(hVar.a.getBufferPercentage() * 10);
                }
                if (hVar.i != null) {
                    hVar.i.a((long) duration);
                }
                if (hVar.b != null) {
                    hVar.b.a((long) currentPosition);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void a(boolean z) {
        this.j.setVisibility(z ? 0 : 8);
    }
}
