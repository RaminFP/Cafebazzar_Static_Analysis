package a.a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class f extends Handler {
    private static f b;
    public final Queue a = new LinkedBlockingQueue();

    private f() {
    }

    public static f a() {
        synchronized (f.class) {
            try {
                if (b == null) {
                    b = new f();
                }
                f fVar = b;
                return fVar;
            } finally {
                Object obj = f.class;
            }
        }
    }

    private void a(c cVar, int i, long j) {
        Message obtainMessage = obtainMessage(i);
        obtainMessage.obj = cVar;
        sendMessageDelayed(obtainMessage, j);
    }

    public static void a(Context context, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 4) {
            AccessibilityManager accessibilityManager = context != null ? (AccessibilityManager) context.getSystemService("accessibility") : null;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(VERSION.SDK_INT < 16 ? 8 : 16384);
                obtain.getText().add(charSequence);
                obtain.setClassName(f.class.getName());
                obtain.setPackageName(context.getPackageName());
                accessibilityManager.sendAccessibilityEvent(obtain);
            }
        }
    }

    private static void a(MarginLayoutParams marginLayoutParams, Activity activity) {
        View findViewById = activity.findViewById(Resources.getSystem().getIdentifier("action_bar_container", "id", "android"));
        if (findViewById != null) {
            marginLayoutParams.topMargin = findViewById.getBottom();
        }
    }

    public static void b(c cVar) {
        if (cVar.d()) {
            ViewGroup viewGroup = (ViewGroup) cVar.f().getParent();
            if (viewGroup != null) {
                viewGroup.removeView(cVar.f());
            }
        }
    }

    protected final void a(c cVar) {
        View f = cVar.f();
        ViewGroup viewGroup = (ViewGroup) f.getParent();
        if (viewGroup != null) {
            f.startAnimation(cVar.b());
            c cVar2 = (c) this.a.poll();
            viewGroup.removeView(f);
            if (cVar2 != null) {
                cVar2.c = null;
                cVar2.d = null;
                cVar2.e = null;
            }
            a(cVar, 794631, cVar.b().getDuration());
        }
    }

    public void b() {
        if (!this.a.isEmpty()) {
            c cVar = (c) this.a.peek();
            if (cVar.c == null) {
                this.a.poll();
            }
            if (cVar.d()) {
                a(cVar, 794631, (((long) cVar.e().b) + cVar.a().getDuration()) + cVar.b().getDuration());
                return;
            }
            Message obtainMessage = obtainMessage(-1040157475);
            obtainMessage.obj = cVar;
            sendMessage(obtainMessage);
            if (cVar.e == null) {
            }
        }
    }

    public final void handleMessage(Message message) {
        c cVar = (c) message.obj;
        if (cVar != null) {
            switch (message.what) {
                case -1040157475:
                    if (!cVar.d()) {
                        View f = cVar.f();
                        if (f.getParent() == null) {
                            LayoutParams layoutParams = f.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new MarginLayoutParams(-1, -2);
                            }
                            if (cVar.d != null) {
                                ViewGroup viewGroup = cVar.d;
                                int i = ((viewGroup instanceof FrameLayout) || (viewGroup instanceof AdapterView) || (viewGroup instanceof RelativeLayout)) ? 1 : 0;
                                if (i != 0) {
                                    viewGroup.addView(f, layoutParams);
                                } else {
                                    viewGroup.addView(f, 0, layoutParams);
                                }
                            } else {
                                Activity activity = cVar.c;
                                if (activity != null && !activity.isFinishing()) {
                                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                                    if (VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) == 67108864) {
                                        a(marginLayoutParams, activity);
                                    }
                                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                                    if (VERSION.SDK_INT >= 11 && activity.getWindow().hasFeature(9)) {
                                        a(marginLayoutParams, activity);
                                    }
                                    activity.addContentView(f, layoutParams);
                                } else {
                                    return;
                                }
                            }
                        }
                        f.requestLayout();
                        ViewTreeObserver viewTreeObserver = f.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnGlobalLayoutListener(new g(this, f, cVar));
                            return;
                        }
                        return;
                    }
                    return;
                case -1040155167:
                    a(cVar);
                    if (cVar.e == null) {
                        return;
                    }
                    return;
                case 794631:
                    b();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public final String toString() {
        return "Manager{croutonQueue=" + this.a + '}';
    }
}
