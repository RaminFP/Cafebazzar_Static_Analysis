package android.support.v4.view;

import android.view.MotionEvent;

final class bc extends bb {
    bc() {
    }

    public final float e(MotionEvent motionEvent, int i) {
        return motionEvent.getAxisValue(i);
    }
}
