package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

class ak implements Factory {
    final an a;

    ak(an anVar) {
        this.a = anVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.a.onCreateView(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.a + "}";
    }
}
