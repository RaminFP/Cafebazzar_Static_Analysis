package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

public final class l extends ArrayAdapter {
    public l(Context context, int i, int i2, CharSequence[] charSequenceArr) {
        super(context, i, 16908308, charSequenceArr);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean hasStableIds() {
        return true;
    }
}
