package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.g;
import android.support.v7.a.i;
import android.support.v7.a.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements aa {
    private m a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.MenuView, i, 0);
        this.g = obtainStyledAttributes.getDrawable(l.MenuView_android_itemBackground);
        this.h = obtainStyledAttributes.getResourceId(l.MenuView_android_itemTextAppearance, -1);
        this.j = obtainStyledAttributes.getBoolean(l.MenuView_preserveIconSpacing, false);
        this.i = context;
        obtainStyledAttributes.recycle();
    }

    private void b() {
        this.c = (RadioButton) getInflater().inflate(i.abc_list_menu_item_radio, this, false);
        addView(this.c);
    }

    private void c() {
        this.e = (CheckBox) getInflater().inflate(i.abc_list_menu_item_checkbox, this, false);
        addView(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.m == null) {
            this.m = LayoutInflater.from(this.l);
        }
        return this.m;
    }

    private void setShortcut$25d965e(boolean z) {
        int i = (z && this.a.d()) ? 0 : 8;
        if (i == 0) {
            CharSequence charSequence;
            TextView textView = this.f;
            char c = this.a.c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(m.f);
                switch (c) {
                    case '\b':
                        stringBuilder.append(m.h);
                        break;
                    case '\n':
                        stringBuilder.append(m.g);
                        break;
                    case ' ':
                        stringBuilder.append(m.i);
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public final void a(m mVar, int i) {
        int i2 = 0;
        this.a = mVar;
        this.k = 0;
        setVisibility(mVar.isVisible() ? 0 : 8);
        setTitle(mVar.a((aa) this));
        setCheckable(mVar.isCheckable());
        boolean d = mVar.d();
        mVar.c();
        if (!(d && this.a.d())) {
            i2 = 8;
        }
        if (i2 == 0) {
            CharSequence charSequence;
            TextView textView = this.f;
            char c = this.a.c();
            if (c == '\u0000') {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(m.f);
                switch (c) {
                    case '\b':
                        stringBuilder.append(m.h);
                        break;
                    case '\n':
                        stringBuilder.append(m.g);
                        break;
                    case ' ':
                        stringBuilder.append(m.i);
                        break;
                    default:
                        stringBuilder.append(c);
                        break;
                }
                charSequence = stringBuilder.toString();
            }
            textView.setText(charSequence);
        }
        if (this.f.getVisibility() != i2) {
            this.f.setVisibility(i2);
        }
        setIcon(mVar.getIcon());
        setEnabled(mVar.isEnabled());
    }

    public final boolean a() {
        return false;
    }

    public m getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        this.d = (TextView) findViewById(g.title);
        if (this.h != -1) {
            this.d.setTextAppearance(this.i, this.h);
        }
        this.f = (TextView) findViewById(g.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.c != null || this.e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.a.e()) {
                if (this.c == null) {
                    b();
                }
                compoundButton = this.c;
                compoundButton2 = this.e;
            } else {
                if (this.e == null) {
                    c();
                }
                compoundButton = this.e;
                compoundButton2 = this.c;
            }
            if (z) {
                compoundButton.setChecked(this.a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.e()) {
            if (this.c == null) {
                b();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.n = z;
        this.j = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.a.b.i || this.n;
        if (!z && !this.j) {
            return;
        }
        if (this.b != null || drawable != null || this.j) {
            if (this.b == null) {
                this.b = (ImageView) getInflater().inflate(i.abc_list_menu_item_icon, this, false);
                addView(this.b, 0);
            }
            if (drawable != null || this.j) {
                ImageView imageView = this.b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.b.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }
}
