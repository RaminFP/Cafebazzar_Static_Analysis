package b.a.a.a.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class m extends PriorityBlockingQueue {
    final Queue a = new LinkedList();
    private final ReentrantLock b = new ReentrantLock();

    private l a(int i, Long l, TimeUnit timeUnit) {
        while (true) {
            l lVar;
            switch (i) {
                case 0:
                    lVar = (l) super.take();
                    break;
                case 1:
                    lVar = (l) super.peek();
                    break;
                case 2:
                    lVar = (l) super.poll();
                    break;
                case 3:
                    lVar = (l) super.poll(l.longValue(), timeUnit);
                    break;
                default:
                    lVar = null;
                    break;
            }
            if (lVar == null || lVar.d()) {
                return lVar;
            }
            a(i, lVar);
        }
    }

    private boolean a(int i, l lVar) {
        try {
            this.b.lock();
            if (i == 1) {
                super.remove(lVar);
            }
            boolean offer = this.a.offer(lVar);
            return offer;
        } finally {
            this.b.unlock();
        }
    }

    private static Object[] a(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length + length2);
        System.arraycopy(objArr, 0, objArr3, 0, length);
        System.arraycopy(objArr2, 0, objArr3, length, length2);
        return objArr3;
    }

    private l b() {
        l lVar = null;
        try {
            lVar = a(1, null, null);
        } catch (InterruptedException e) {
        }
        return lVar;
    }

    private l c() {
        l lVar = null;
        try {
            lVar = a(2, null, null);
        } catch (InterruptedException e) {
        }
        return lVar;
    }

    public final void a() {
        try {
            this.b.lock();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.d()) {
                    super.offer(lVar);
                    it.remove();
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public final void clear() {
        try {
            this.b.lock();
            this.a.clear();
            super.clear();
        } finally {
            this.b.unlock();
        }
    }

    public final boolean contains(Object obj) {
        try {
            this.b.lock();
            boolean z = super.contains(obj) || this.a.contains(obj);
            this.b.unlock();
            return z;
        } catch (Throwable th) {
            this.b.unlock();
        }
    }

    public final int drainTo(Collection collection) {
        int size;
        try {
            this.b.lock();
            int drainTo = super.drainTo(collection);
            size = this.a.size();
            while (!this.a.isEmpty()) {
                collection.add(this.a.poll());
            }
            return drainTo + size;
        } finally {
            size = this.b;
            size.unlock();
        }
    }

    public final int drainTo(Collection collection, int i) {
        try {
            this.b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.a.isEmpty() && drainTo <= i) {
                collection.add(this.a.poll());
                drainTo++;
            }
            this.b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.b.unlock();
        }
    }

    public final /* synthetic */ Object peek() {
        return b();
    }

    public final /* synthetic */ Object poll() {
        return c();
    }

    public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return a(3, Long.valueOf(j), timeUnit);
    }

    public final boolean remove(Object obj) {
        try {
            this.b.lock();
            boolean z = super.remove(obj) || this.a.remove(obj);
            this.b.unlock();
            return z;
        } catch (Throwable th) {
            this.b.unlock();
        }
    }

    public final boolean removeAll(Collection collection) {
        int removeAll;
        try {
            this.b.lock();
            int removeAll2 = super.removeAll(collection);
            removeAll = this.a.removeAll(collection);
            return removeAll2 | removeAll;
        } finally {
            removeAll = this.b;
            removeAll.unlock();
        }
    }

    public final int size() {
        int size;
        try {
            this.b.lock();
            int size2 = this.a.size();
            size = super.size();
            return size2 + size;
        } finally {
            size = this.b;
            size.unlock();
        }
    }

    public final /* synthetic */ Object take() {
        return a(0, null, null);
    }

    public final Object[] toArray() {
        try {
            this.b.lock();
            Object[] a = a(super.toArray(), this.a.toArray());
            return a;
        } finally {
            this.b.unlock();
        }
    }

    public final Object[] toArray(Object[] objArr) {
        try {
            this.b.lock();
            Object[] a = a(super.toArray(objArr), this.a.toArray(objArr));
            return a;
        } finally {
            this.b.unlock();
        }
    }
}
