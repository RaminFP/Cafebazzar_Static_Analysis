package android.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

final class m {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    m(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.a = intentFilter;
        this.b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
