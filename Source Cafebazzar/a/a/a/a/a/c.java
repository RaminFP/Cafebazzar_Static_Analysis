package a.a.a.a.a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class c {
    final CharSequence a;
    public a b;
    Activity c;
    ViewGroup d;
    e e;
    private final h f;
    private final View g;
    private OnClickListener h;
    private FrameLayout i;
    private Animation j;
    private Animation k;

    public c(Activity activity, View view) {
        this.b = null;
        this.e = null;
        if (activity == null || view == null) {
            throw new IllegalArgumentException("Null parameters are not accepted");
        }
        this.c = activity;
        this.d = null;
        this.g = view;
        this.f = new i().a();
        this.a = null;
    }

    public c(Activity activity, View view, ViewGroup viewGroup) {
        this(activity, view, viewGroup, a.a);
    }

    private c(Activity activity, View view, ViewGroup viewGroup, a aVar) {
        this.b = null;
        this.e = null;
        if (activity == null || view == null) {
            throw new IllegalArgumentException("Null parameters are not accepted");
        }
        this.c = activity;
        this.g = view;
        this.d = viewGroup;
        this.f = new i().a();
        this.a = null;
        this.b = aVar;
    }

    private void a(TextView textView, String str) {
        if (this.a != null) {
            CharSequence spannableString = new SpannableString(this.a);
            spannableString.setSpan(new j(textView.getContext(), str), 0, spannableString.length(), 33);
            textView.setText(spannableString);
        }
    }

    public final Animation a() {
        if (this.j == null && this.c != null) {
            if (e().c > 0) {
                this.j = AnimationUtils.loadAnimation(this.c, e().c);
            } else {
                f().measure(this.d != null ? MeasureSpec.makeMeasureSpec(this.d.getMeasuredWidth(), Integer.MIN_VALUE) : MeasureSpec.makeMeasureSpec(this.c.getWindow().getDecorView().getMeasuredWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
                View f = f();
                if (!d.a(d.c, f) || d.a == null) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-f.getMeasuredHeight()), 0.0f);
                    d.a = translateAnimation;
                    translateAnimation.setDuration(400);
                    d.c = f.getMeasuredHeight();
                }
                this.j = d.a;
            }
        }
        return this.j;
    }

    public final Animation b() {
        if (this.k == null && this.c != null) {
            if (e().d > 0) {
                this.k = AnimationUtils.loadAnimation(this.c, e().d);
            } else {
                View f = f();
                if (!d.a(d.d, f) || d.b == null) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-f.getMeasuredHeight()));
                    d.b = translateAnimation;
                    translateAnimation.setDuration(400);
                    d.d = f.getMeasuredHeight();
                }
                this.k = d.b;
            }
        }
        return this.k;
    }

    public final void c() {
        f.a().a(this);
    }

    final boolean d() {
        if (this.c != null) {
            boolean z = (this.i == null || this.i.getParent() == null) ? false : true;
            if (z) {
                return true;
            }
            z = (this.g == null || this.g.getParent() == null) ? false : true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final a e() {
        if (this.b == null) {
            this.b = this.f.d;
        }
        return this.b;
    }

    final View f() {
        if (this.g != null) {
            return this.g;
        }
        if (this.i == null) {
            Resources resources = this.c.getResources();
            FrameLayout frameLayout = new FrameLayout(this.c);
            if (this.h != null) {
                frameLayout.setOnClickListener(this.h);
            }
            int dimensionPixelSize = this.f.l > 0 ? resources.getDimensionPixelSize(this.f.l) : this.f.k;
            int dimensionPixelSize2 = this.f.n > 0 ? resources.getDimensionPixelSize(this.f.n) : this.f.m;
            if (dimensionPixelSize2 == 0) {
                dimensionPixelSize2 = -1;
            }
            frameLayout.setLayoutParams(new LayoutParams(dimensionPixelSize2, dimensionPixelSize));
            if (this.f.g != -1) {
                frameLayout.setBackgroundColor(this.f.g);
            } else {
                frameLayout.setBackgroundColor(resources.getColor(this.f.e));
            }
            if (this.f.f != 0) {
                Drawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, this.f.f));
                if (this.f.h) {
                    bitmapDrawable.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
                }
                frameLayout.setBackgroundDrawable(bitmapDrawable);
            }
            this.i = frameLayout;
            View relativeLayout = new RelativeLayout(this.c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            dimensionPixelSize = this.f.y;
            if (this.f.z > 0) {
                dimensionPixelSize = resources.getDimensionPixelSize(this.f.z);
            }
            relativeLayout.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            ImageView imageView = null;
            if (!(this.f.p == null && this.f.q == 0)) {
                imageView = new ImageView(this.c);
                imageView.setId(NotificationCompat.FLAG_LOCAL_ONLY);
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(this.f.r);
                if (this.f.p != null) {
                    imageView.setImageDrawable(this.f.p);
                }
                if (this.f.q != 0) {
                    imageView.setImageResource(this.f.q);
                }
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(9, -1);
                layoutParams.addRule(15, -1);
                imageView.setLayoutParams(layoutParams);
                relativeLayout.addView(imageView, imageView.getLayoutParams());
            }
            View textView = new TextView(this.c);
            textView.setId(257);
            if (this.f.A != null) {
                a(textView, this.f.A);
            } else if (this.f.B != 0) {
                a(textView, resources.getString(this.f.B));
            } else {
                textView.setText(this.a);
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setGravity(this.f.o);
            if (this.f.j != -1) {
                textView.setTextColor(this.f.j);
            } else if (this.f.i != 0) {
                textView.setTextColor(resources.getColor(this.f.i));
            }
            if (this.f.s != 0) {
                textView.setTextSize(2, (float) this.f.s);
            }
            if (this.f.t != 0) {
                textView.setShadowLayer(this.f.u, this.f.w, this.f.v, resources.getColor(this.f.t));
            }
            if (this.f.x != 0) {
                textView.setTextAppearance(this.c, this.f.x);
            }
            ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            if (imageView != null) {
                layoutParams2.addRule(1, imageView.getId());
            }
            if ((this.f.o & 17) != 0) {
                layoutParams2.addRule(13);
            } else if ((this.f.o & 16) != 0) {
                layoutParams2.addRule(15);
            } else if ((this.f.o & 1) != 0) {
                layoutParams2.addRule(14);
            }
            relativeLayout.addView(textView, layoutParams2);
            this.i.addView(relativeLayout);
        }
        return this.i;
    }

    public final String toString() {
        return "Crouton{text=" + this.a + ", style=" + this.f + ", configuration=" + this.b + ", customView=" + this.g + ", onClickListener=" + this.h + ", activity=" + this.c + ", viewGroup=" + this.d + ", croutonView=" + this.i + ", inAnimation=" + this.j + ", outAnimation=" + this.k + ", lifecycleCallback=" + this.e + '}';
    }
}
