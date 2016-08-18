package a.a.a.a.a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.f.g;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class j extends MetricAffectingSpan {
    private static g a = new g(5);
    private Typeface b;

    public j(Context context, String str) {
        this.b = (Typeface) a.a((Object) str);
        if (this.b == null) {
            this.b = Typeface.createFromAsset(context.getApplicationContext().getAssets(), String.format("%s", new Object[]{str}));
            a.a(str, this.b);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setTypeface(this.b);
    }

    public final void updateMeasureState(TextPaint textPaint) {
        textPaint.setTypeface(this.b);
    }
}
