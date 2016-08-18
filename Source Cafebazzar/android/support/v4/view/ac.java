package android.support.v4.view;

import android.view.KeyEvent;

final class ac extends ab {
    ac() {
    }

    public final int a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public final boolean a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public final boolean b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
