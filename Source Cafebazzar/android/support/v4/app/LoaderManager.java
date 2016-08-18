package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.b.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks {
        g onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(g gVar, Object obj);

        void onLoaderReset(g gVar);
    }

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract g getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract g initLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);

    public abstract g restartLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);
}
