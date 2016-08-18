package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;

final class am extends ak implements Factory2 {
    am(an anVar) {
        super(anVar);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.onCreateView(view, str, context, attributeSet);
    }
}
