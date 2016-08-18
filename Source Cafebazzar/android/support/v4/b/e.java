package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;

class e extends d {
    e() {
    }

    public final Intent a(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }
}
