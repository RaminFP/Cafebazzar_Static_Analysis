package b.a.a.a.a.c;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class d extends FutureTask {
    final /* synthetic */ a a;

    d(a aVar, Callable callable) {
        this.a = aVar;
        super(callable);
    }

    protected final void done() {
        try {
            a.b(this.a, get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            a.b(this.a, null);
        }
    }
}
