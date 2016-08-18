package com.farsitel.bazaar.g.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.farsitel.bazaar.database.g;
import com.farsitel.bazaar.database.k;
import com.farsitel.bazaar.g.d;
import com.farsitel.bazaar.g.e.f;
import com.farsitel.bazaar.receiver.h;
import com.farsitel.bazaar.util.af;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends i {
    public final boolean A;
    public final int[] B;
    public final int C;
    public c[] D;
    public f[] E;
    public boolean F;
    public long G;
    public long H;
    public long I;
    public boolean J;
    private boolean V;
    private String[] W;
    public String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final float j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final Spanned w;
    public final String[] x;
    final d[] y;
    g z;

    public a(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        int length;
        int i;
        int i2 = 0;
        super(str, jSONObject.getString("n"), jSONObject.getJSONArray("p").length() == 0, 10);
        this.z = null;
        this.D = null;
        this.O = jSONObject.has("pi") ? jSONObject.getLong("vc") : 0;
        this.a = jSONObject.has("pi") ? jSONObject.getString("vn") : "";
        this.j = (float) jSONObject.getDouble("r");
        this.k = jSONObject.getInt("rc");
        this.e = jSONObject.getString("a");
        this.i = jSONObject.getString("as");
        if (jSONObject.has("ic")) {
            this.q = jSONObject.getString("ic");
        } else {
            this.q = null;
        }
        if (jSONObject.has("r1")) {
            this.l = jSONObject.getInt("r1");
        } else {
            this.l = 0;
        }
        if (jSONObject.has("r2")) {
            this.m = jSONObject.getInt("r2");
        } else {
            this.m = 0;
        }
        if (jSONObject.has("r3")) {
            this.n = jSONObject.getInt("r3");
        } else {
            this.n = 0;
        }
        if (jSONObject.has("r4")) {
            this.o = jSONObject.getInt("r4");
        } else {
            this.o = 0;
        }
        if (jSONObject.has("r5")) {
            this.p = jSONObject.getInt("r5");
        } else {
            this.p = 0;
        }
        if (jSONObject.has("ae")) {
            this.f = jSONObject.getString("ae");
        } else {
            this.f = "";
        }
        if (jSONObject.has("ap")) {
            this.g = jSONObject.getString("ap");
        } else {
            this.g = "";
        }
        if (jSONObject.has("aw")) {
            this.h = jSONObject.getString("aw");
        } else {
            this.h = "";
        }
        if (jSONObject.has("cd")) {
            jSONArray = jSONObject.getJSONArray("cd");
            length = jSONArray.length();
            this.W = new String[length];
            for (i = 0; i < length; i++) {
                this.W[i] = jSONArray.getString(i);
            }
        } else {
            this.W = null;
        }
        this.r = jSONObject.getString("c");
        this.s = jSONObject.getString("cs");
        this.v = jSONObject.getString("d").trim();
        jSONArray = jSONObject.getJSONArray("ss");
        length = jSONArray.length();
        this.y = new d[length];
        for (i = 0; i < length; i++) {
            this.y[i] = new d(jSONArray.getJSONObject(i));
        }
        boolean z = jSONObject.has("vs") && jSONObject.has("vst") && jSONObject.has("vsp");
        this.V = z;
        if (this.V) {
            this.z = new g(jSONObject);
        }
        jSONArray = jSONObject.getJSONArray("p");
        length = jSONArray.length();
        this.B = new int[length];
        for (i = 0; i < length; i++) {
            this.B[i] = jSONArray.getInt(i);
        }
        if (jSONObject.has("op")) {
            this.C = jSONObject.getInt("op");
        } else {
            this.C = -1;
        }
        if (jSONObject.has("pi")) {
            this.I = jSONObject.getLong("pi");
            this.w = Html.fromHtml(jSONObject.getString("cl").trim());
            this.G = jSONObject.getLong("s");
            jSONArray = jSONObject.getJSONArray("ps");
            length = jSONArray.length();
            this.x = new String[length];
            for (i = 0; i < length; i++) {
                this.x[i] = jSONArray.getString(i);
            }
        } else {
            this.I = -1;
            this.w = null;
            this.O = -1;
            this.a = null;
            this.G = -1;
            this.x = new String[0];
        }
        af afVar = af.INSTANCE;
        d b = af.b(this.M);
        if (b != null && jSONObject.has("df")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("df");
            for (i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2.getLong("ovc") == b.d && jSONObject2.getLong("nvc") == this.O) {
                    this.H = jSONObject2.getLong("s");
                    break;
                }
            }
        }
        if (jSONObject.has("pr")) {
            jSONArray = jSONObject.getJSONArray("pr");
            length = jSONArray.length();
            this.D = new c[length];
            for (i = 0; i < length; i++) {
                this.D[i] = new c(jSONArray.getJSONObject(i));
            }
        }
        z = jSONObject.has("iap") && jSONObject.getBoolean("iap");
        this.A = z;
        if (jSONObject.has("apps") && jSONObject.getJSONObject("apps").has("rows")) {
            JSONArray jSONArray3 = jSONObject.getJSONObject("apps").getJSONArray("rows");
            this.E = new f[jSONArray3.length()];
            while (i2 < jSONArray3.length()) {
                this.E[i2] = f.a(jSONArray3.getJSONObject(i2));
                if (this.E[i2].d.length > 0) {
                    this.F = true;
                }
                i2++;
            }
        } else {
            this.E = null;
        }
        if (jSONObject.has("sh")) {
            this.J = jSONObject.getBoolean("sh");
        } else {
            this.J = true;
        }
        if (this.M.equals("com.farsitel.bazaar")) {
            this.J = true;
        }
        if (jSONObject.has("mis")) {
            this.t = jSONObject.getString("mis");
        } else {
            this.t = "";
        }
        if (jSONObject.has("lu")) {
            this.u = jSONObject.getString("lu");
        } else {
            this.u = "";
        }
        if (jSONObject.has("ri")) {
            this.b = jSONObject.getString("ri");
        } else {
            this.b = "";
        }
        if (jSONObject.has("tri")) {
            this.c = jSONObject.getString("tri");
        } else {
            this.c = "";
        }
        if (jSONObject.has("cr")) {
            this.d = jSONObject.getString("cr");
        } else {
            this.d = "";
        }
        e();
    }

    public final boolean a() {
        return this.B.length == 0;
    }

    public final int b() {
        return this.B.length == 0 ? 0 : this.B[0];
    }

    public final boolean c() {
        return this.V && this.z.e;
    }

    public final boolean d() {
        if (this.W != null) {
            String[] strArr = this.W;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!strArr[i].equals(Build.DEVICE)) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    public final void e() {
        int i = 1;
        int i2 = 0;
        super.e();
        if (this.S) {
            int containsKey = g.a().b(this.M) != null ? g.a().a.containsKey(this.M) : 1;
            af afVar = af.INSTANCE;
            boolean a = af.a(this.M);
            g a2 = g.a();
            d dVar = new d(this.M, this.O, this.a, containsKey & a, this.L);
            d dVar2 = a2.a.containsKey(dVar.a) ? (d) a2.a.get(dVar.a) : a2.b.containsKey(dVar.a) ? (d) a2.b.get(dVar.a) : null;
            if (dVar.e) {
                a2.a.put(dVar.a, dVar);
                a2.b.remove(dVar.a);
            } else {
                a2.b.put(dVar.a, dVar);
                a2.a.remove(dVar.a);
            }
            synchronized (a2) {
                SQLiteDatabase writableDatabase = a2.getWritableDatabase();
                if (dVar2 == null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("pkgname", dVar.a);
                    contentValues.put("version_name", dVar.c);
                    contentValues.put("version_code", Long.valueOf(dVar.d));
                    if (!dVar.f) {
                        i = 0;
                    }
                    contentValues.put("package_wolf", Integer.valueOf(i));
                    try {
                        writableDatabase.insert("upgradables_apps", null, contentValues);
                    } catch (Exception e) {
                        new Thread(new k(a2)).start();
                        return;
                    }
                } else if (dVar.d > dVar2.d) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("version_name", dVar.c);
                    contentValues2.put("version_code", Long.valueOf(dVar.d));
                    if (dVar2.e) {
                        i2 = 1;
                    }
                    contentValues2.put("count_as_upgradable", Integer.valueOf(i2));
                    contentValues2.put("notified", Integer.valueOf(0));
                    writableDatabase.update("upgradables_apps", contentValues2, "pkgname = ?", new String[]{dVar.a});
                    writableDatabase.close();
                }
            }
            h.c();
            return;
        }
        g.a().a(this.M);
    }
}
