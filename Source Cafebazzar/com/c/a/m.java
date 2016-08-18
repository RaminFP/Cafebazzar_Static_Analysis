package com.c.a;

final class m implements ae {
    final /* synthetic */ l a;
    private final int b;
    private final al c;
    private final boolean d;

    m(l lVar, int i, al alVar, boolean z) {
        this.a = lVar;
        this.b = i;
        this.c = alVar;
        this.d = z;
    }

    public final ap a(al alVar) {
        if (this.b >= this.a.a.f.size()) {
            return this.a.a(alVar, this.d);
        }
        m mVar = new m(this.a, this.b + 1, alVar, this.d);
        return ((ad) this.a.a.f.get(this.b)).a();
    }
}
