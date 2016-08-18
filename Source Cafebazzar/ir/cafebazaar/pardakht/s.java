package ir.cafebazaar.pardakht;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class s implements OnTouchListener {
    final /* synthetic */ PardakhtActivity a;

    s(PardakhtActivity pardakhtActivity) {
        this.a = pardakhtActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
