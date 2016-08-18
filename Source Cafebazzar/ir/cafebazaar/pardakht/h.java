package ir.cafebazaar.pardakht;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.util.ab;

public final class h {
    private final ImageView a = ((ImageView) this.b.findViewById(2131624270));
    private final View b;
    private final TextView c;
    private final TextView d;
    private final View e;
    private final Context f;

    public h(View view, Context context) {
        this.b = view;
        this.f = context;
        this.d = (TextView) view.findViewById(2131624380);
        this.e = view.findViewById(2131624337);
        this.c = (TextView) view.findViewById(2131624381);
        this.c.setText(j.a().h());
    }

    public final void a(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public final void a(Character ch) {
        if (ch == null) {
            this.d.setVisibility(8);
            return;
        }
        switch (ch.charValue()) {
            case 'A':
                this.d.setVisibility(0);
                this.d.setText(2131165503);
                return;
            case 'M':
                this.d.setVisibility(0);
                this.d.setText(2131165504);
                return;
            case 'P':
                this.d.setVisibility(8);
                return;
            default:
                this.d.setVisibility(8);
                return;
        }
    }

    public final void a(String str) {
        ab.a().a(str, this.a);
    }

    public final void a(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
    }
}
