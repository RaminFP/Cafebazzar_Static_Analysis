package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class dp extends dn {
    dp() {
    }

    public final void a(View view, ea eaVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (eaVar != null) {
            animatorUpdateListener = new dx(eaVar, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
