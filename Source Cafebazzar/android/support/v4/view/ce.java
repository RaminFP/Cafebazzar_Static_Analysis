package android.support.v4.view;

import android.view.View;

final class ce {
    static void a(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
