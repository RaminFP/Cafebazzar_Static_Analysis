package android.support.v4.view;

import android.view.MotionEvent;

class az implements bd {
    az() {
    }

    public int a(MotionEvent motionEvent) {
        return 1;
    }

    public int a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int b(MotionEvent motionEvent) {
        return 0;
    }

    public int b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
