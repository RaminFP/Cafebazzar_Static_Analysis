package com.google.android.gms.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class bd {
    private static final ExecutorService a = Executors.newFixedThreadPool(2, new ch("GAC_Executor"));

    public static ExecutorService a() {
        return a;
    }
}
