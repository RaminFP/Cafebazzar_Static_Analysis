package android.support.v7.d;

import java.util.Comparator;

public abstract class b implements Comparator {
    public abstract boolean areContentsTheSame(Object obj, Object obj2);

    public abstract boolean areItemsTheSame(Object obj, Object obj2);

    public abstract int compare(Object obj, Object obj2);

    public abstract void onChanged(int i, int i2);

    public abstract void onInserted(int i, int i2);

    public abstract void onMoved(int i, int i2);

    public abstract void onRemoved(int i, int i2);
}
