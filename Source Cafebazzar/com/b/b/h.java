package com.b.b;

public class h extends m implements ak {
    static String a;
    static String b = "http://data.flurry.com/aap.do";
    static String c = "https://data.flurry.com/aap.do";
    private boolean j;

    public h() {
        this(null);
    }

    private h(s sVar) {
        super("Analytics", h.class.getSimpleName());
        this.i = "AnalyticsData_";
        aj a = ai.a();
        this.j = ((Boolean) a.a("UseHttps")).booleanValue();
        a.a("UseHttps", (ak) this);
        ba.a(4, d, "initSettings, UseHttps = " + this.j);
        String str = (String) a.a("ReportUrl");
        a.a("ReportUrl", (ak) this);
        b(str);
        ba.a(4, d, "initSettings, ReportUrl = " + str);
        a(null);
    }

    private static void b(String str) {
        if (!(str == null || str.endsWith(".do"))) {
            ba.a(5, d, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        a = str;
    }

    public final void a(String str, Object obj) {
        if (str.equals("UseHttps")) {
            this.j = ((Boolean) obj).booleanValue();
            ba.a(4, d, "onSettingUpdate, UseHttps = " + this.j);
        } else if (str.equals("ReportUrl")) {
            String str2 = (String) obj;
            b(str2);
            ba.a(4, d, "onSettingUpdate, ReportUrl = " + str2);
        } else {
            ba.a(6, d, "onSettingUpdate internal error!");
        }
    }

    protected final void a(String str, String str2, int i) {
        this.f.submit(new k(this, i));
        super.a(str, str2, i);
    }

    protected final void a(byte[] bArr, String str, String str2) {
        String str3 = a != null ? a : this.j ? c : b;
        ba.a(4, d, "FlurryDataSender: start upload data " + bArr + " with id = " + str + " to " + str3);
        this.g.submit(new l(str3, str, str2, bArr, new i(this)));
    }
}
