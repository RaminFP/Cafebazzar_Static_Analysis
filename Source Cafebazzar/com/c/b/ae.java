package com.c.b;

public enum ae {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int c;

    private ae(int i) {
        this.c = i;
    }

    static boolean a(int i) {
        return (NO_CACHE.c & i) == 0;
    }

    static boolean b(int i) {
        return (NO_STORE.c & i) == 0;
    }
}
