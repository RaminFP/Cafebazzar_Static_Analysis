package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

final class s implements r {
    private static final int e = ViewConfiguration.getLongPressTimeout();
    private static final int f = ViewConfiguration.getTapTimeout();
    private static final int g = ViewConfiguration.getDoubleTapTimeout();
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler h;
    private final OnGestureListener i;
    private OnDoubleTapListener j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private MotionEvent p;
    private MotionEvent q;
    private boolean r;
    private float s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    private VelocityTracker x;

    public s(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.h = new t(this, handler);
        } else {
            this.h = new t(this);
        }
        this.i = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            this.j = (OnDoubleTapListener) onGestureListener;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.a = scaledTouchSlop * scaledTouchSlop;
            this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    static /* synthetic */ void c(s sVar) {
        sVar.h.removeMessages(3);
        sVar.l = false;
        sVar.m = true;
        sVar.i.onLongPress(sVar.p);
    }

    public final boolean a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.x == null) {
            this.x = VelocityTracker.obtain();
        }
        this.x.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int b = z ? ay.b(motionEvent) : -1;
        int c = ay.c(motionEvent);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < c; i++) {
            if (b != i) {
                f += ay.c(motionEvent, i);
                f2 += ay.d(motionEvent, i);
            }
        }
        b = z ? c - 1 : c;
        f /= (float) b;
        f2 /= (float) b;
        boolean hasMessages;
        float b2;
        float a;
        switch (action & 255) {
            case 0:
                if (this.j != null) {
                    hasMessages = this.h.hasMessages(3);
                    if (hasMessages) {
                        this.h.removeMessages(3);
                    }
                    if (!(this.p == null || this.q == null || !hasMessages)) {
                        MotionEvent motionEvent2 = this.p;
                        MotionEvent motionEvent3 = this.q;
                        if (this.o && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) g)) {
                            c = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            b = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((b * b) + (c * c) < this.b) {
                                hasMessages = true;
                                if (hasMessages) {
                                    this.r = true;
                                    b = (this.j.onDoubleTap(this.p) | 0) | this.j.onDoubleTapEvent(motionEvent);
                                    this.s = f;
                                    this.u = f;
                                    this.t = f2;
                                    this.v = f2;
                                    if (this.p != null) {
                                        this.p.recycle();
                                    }
                                    this.p = MotionEvent.obtain(motionEvent);
                                    this.n = true;
                                    this.o = true;
                                    this.k = true;
                                    this.m = false;
                                    this.l = false;
                                    if (this.w) {
                                        this.h.removeMessages(2);
                                        this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                                    }
                                    this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                                    return b | this.i.onDown(motionEvent);
                                }
                            }
                        }
                        hasMessages = false;
                        if (hasMessages) {
                            this.r = true;
                            b = (this.j.onDoubleTap(this.p) | 0) | this.j.onDoubleTapEvent(motionEvent);
                            this.s = f;
                            this.u = f;
                            this.t = f2;
                            this.v = f2;
                            if (this.p != null) {
                                this.p.recycle();
                            }
                            this.p = MotionEvent.obtain(motionEvent);
                            this.n = true;
                            this.o = true;
                            this.k = true;
                            this.m = false;
                            this.l = false;
                            if (this.w) {
                                this.h.removeMessages(2);
                                this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                            }
                            this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                            return b | this.i.onDown(motionEvent);
                        }
                    }
                    this.h.sendEmptyMessageDelayed(3, (long) g);
                }
                b = 0;
                this.s = f;
                this.u = f;
                this.t = f2;
                this.v = f2;
                if (this.p != null) {
                    this.p.recycle();
                }
                this.p = MotionEvent.obtain(motionEvent);
                this.n = true;
                this.o = true;
                this.k = true;
                this.m = false;
                this.l = false;
                if (this.w) {
                    this.h.removeMessages(2);
                    this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                }
                this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                return b | this.i.onDown(motionEvent);
            case 1:
                this.k = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.r) {
                    hasMessages = this.j.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.m) {
                    this.h.removeMessages(3);
                    this.m = false;
                    hasMessages = false;
                } else if (this.n) {
                    hasMessages = this.i.onSingleTapUp(motionEvent);
                    if (this.l && this.j != null) {
                        this.j.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.x;
                    int b3 = ay.b(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.d);
                    b2 = bl.b(velocityTracker, b3);
                    a = bl.a(velocityTracker, b3);
                    hasMessages = (Math.abs(b2) > ((float) this.c) || Math.abs(a) > ((float) this.c)) ? this.i.onFling(this.p, motionEvent, a, b2) : false;
                }
                if (this.q != null) {
                    this.q.recycle();
                }
                this.q = obtain;
                if (this.x != null) {
                    this.x.recycle();
                    this.x = null;
                }
                this.r = false;
                this.l = false;
                this.h.removeMessages(1);
                this.h.removeMessages(2);
                return hasMessages;
            case 2:
                if (this.m) {
                    return false;
                }
                a = this.s - f;
                b2 = this.t - f2;
                if (this.r) {
                    return this.j.onDoubleTapEvent(motionEvent) | 0;
                }
                if (this.n) {
                    i = (int) (f - this.u);
                    int i2 = (int) (f2 - this.v);
                    i = (i * i) + (i2 * i2);
                    if (i > this.a) {
                        hasMessages = this.i.onScroll(this.p, motionEvent, a, b2);
                        this.s = f;
                        this.t = f2;
                        this.n = false;
                        this.h.removeMessages(3);
                        this.h.removeMessages(1);
                        this.h.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.a) {
                        this.o = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.i.onScroll(this.p, motionEvent, a, b2);
                    this.s = f;
                    this.t = f2;
                    return onScroll;
                }
            case 3:
                this.h.removeMessages(1);
                this.h.removeMessages(2);
                this.h.removeMessages(3);
                this.x.recycle();
                this.x = null;
                this.r = false;
                this.k = false;
                this.n = false;
                this.o = false;
                this.l = false;
                if (!this.m) {
                    return false;
                }
                this.m = false;
                return false;
            case 5:
                this.s = f;
                this.u = f;
                this.t = f2;
                this.v = f2;
                this.h.removeMessages(1);
                this.h.removeMessages(2);
                this.h.removeMessages(3);
                this.r = false;
                this.n = false;
                this.o = false;
                this.l = false;
                if (!this.m) {
                    return false;
                }
                this.m = false;
                return false;
            case 6:
                this.s = f;
                this.u = f;
                this.t = f2;
                this.v = f2;
                this.x.computeCurrentVelocity(1000, (float) this.d);
                int b4 = ay.b(motionEvent);
                b = ay.b(motionEvent, b4);
                f = bl.a(this.x, b);
                float b5 = bl.b(this.x, b);
                for (b = 0; b < c; b++) {
                    if (b != b4) {
                        i = ay.b(motionEvent, b);
                        if ((bl.b(this.x, i) * b5) + (bl.a(this.x, i) * f) < 0.0f) {
                            this.x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
