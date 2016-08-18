package android.support.v7.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.Window;

class s extends AppCompatDelegateImplV7 {
    s(Context context, Window window, o oVar) {
        super(context, window, oVar);
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        View a = super.a(view, str, context, attributeSet);
        return a != null ? a : this.c instanceof Factory2 ? ((Factory2) this.c).onCreateView(view, str, context, attributeSet) : null;
    }
}
