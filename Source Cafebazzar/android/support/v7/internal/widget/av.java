package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import android.support.v7.app.c;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

final class av extends LinearLayoutCompat implements OnLongClickListener {
    c a;
    final /* synthetic */ ar b;
    private final int[] c = new int[]{16842964};
    private TextView d;
    private ImageView e;
    private View f;

    public av(ar arVar, Context context, c cVar, boolean z) {
        this.b = arVar;
        super(context, null, b.actionBarTabStyle);
        this.a = cVar;
        bk a = bk.a(context, null, this.c, b.actionBarTabStyle, 0);
        if (a.d(0)) {
            setBackgroundDrawable(a.a(0));
        }
        a.a.recycle();
        if (z) {
            setGravity(8388627);
        }
        a();
    }

    public final void a() {
        c cVar = this.a;
        View c = cVar.c();
        if (c != null) {
            av parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f = c;
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
                return;
            }
            return;
        }
        if (this.f != null) {
            removeView(this.f);
            this.f = null;
        }
        Drawable a = cVar.a();
        CharSequence b = cVar.b();
        if (a != null) {
            if (this.e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView, 0);
                this.e = imageView;
            }
            this.e.setImageDrawable(a);
            this.e.setVisibility(0);
        } else if (this.e != null) {
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
        }
        boolean z = !TextUtils.isEmpty(b);
        if (z) {
            if (this.d == null) {
                imageView = new AppCompatTextView(getContext(), null, b.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView);
                this.d = imageView;
            }
            this.d.setText(b);
            this.d.setVisibility(0);
        } else if (this.d != null) {
            this.d.setVisibility(8);
            this.d.setText(null);
        }
        if (this.e != null) {
            this.e.setContentDescription(cVar.d());
        }
        if (z || TextUtils.isEmpty(cVar.d())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(c.class.getName());
        }
    }

    public final boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.a.d(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.b > 0 && getMeasuredWidth() > this.b.b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.b.b, 1073741824), i2);
        }
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }
}
