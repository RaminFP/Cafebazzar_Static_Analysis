package com.ms.square.android.expandabletextview;

final class b implements Runnable {
    final /* synthetic */ ExpandableTextView a;

    b(ExpandableTextView expandableTextView) {
        this.a = expandableTextView;
    }

    public final void run() {
        this.a.i = this.a.getHeight() - this.a.a.getHeight();
    }
}
