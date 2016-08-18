package com.farsitel.bazaar.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public final class k extends n {
    public TextView a;
    public RatingBar b;
    public ImageView c;
    public Button d;
    public TextView e;
    public View f;
    public ImageView g;
    public ProgressBar h;
    public TextView i;

    public k(View view) {
        this.a = (TextView) view.findViewById(2131624212);
        this.c = (ImageView) view.findViewById(2131624208);
        this.b = (RatingBar) view.findViewById(2131624323);
        this.d = (Button) view.findViewById(2131624321);
        this.e = (TextView) view.findViewById(2131624218);
        this.e.setPaintFlags(this.e.getPaintFlags() | 16);
        this.f = view.findViewById(2131624219);
        this.g = (ImageView) view.findViewById(2131624320);
        this.h = (ProgressBar) view.findViewById(2131624043);
        this.i = (TextView) view.findViewById(2131624319);
    }
}
