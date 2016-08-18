package com.c.b;

public enum ap {
    MEMORY(-16711936),
    DISK(-16776961),
    NETWORK(-65536);
    
    final int d;

    private ap(int i) {
        this.d = i;
    }
}
