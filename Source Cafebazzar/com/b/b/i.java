package com.b.b;

final class i implements u {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void a(int i, String str, String str2, String str3) {
        ba.c(m.d, "FlurryDataSender: report " + str2 + " sent. HTTP response: " + i + " : " + str);
        if (ba.b() <= 3 && ba.c()) {
            ah ahVar = ah.a;
            ahVar.c.post(new j(this, i));
        }
        this.a.a(str2, str3, i);
        this.a.a();
    }

    public final void a(String str, String str2) {
        ba.c(m.d, "FlurryDataSender: could not send report " + str);
        this.a.a(str);
    }
}
