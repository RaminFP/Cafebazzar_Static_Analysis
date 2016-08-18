package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;

class d implements c {
    d() {
    }

    public Intent a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
