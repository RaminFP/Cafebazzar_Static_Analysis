package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class n extends DataSetObservable {
    private static final String f = n.class.getSimpleName();
    private static final Object g = new Object();
    private static final Map h = new HashMap();
    public final Object a = new Object();
    final List b = new ArrayList();
    public Intent c;
    public boolean d = false;
    public s e;
    private final List i = new ArrayList();
    private final Context j;
    private final String k;
    private p l = new q();
    private int m = 50;
    private boolean n = true;
    private boolean o = false;
    private boolean p = true;

    private n(Context context, String str) {
        this.j = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.k = str;
        } else {
            this.k = str + ".xml";
        }
    }

    public static n a(Context context, String str) {
        n nVar;
        synchronized (g) {
            nVar = (n) h.get(str);
            if (nVar == null) {
                nVar = new n(context, str);
                h.put(str, nVar);
            }
        }
        return nVar;
    }

    private boolean f() {
        if (this.l == null || this.c == null || this.b.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.l.a(this.b, Collections.unmodifiableList(this.i));
        return true;
    }

    private void g() {
        int size = this.i.size() - this.m;
        if (size > 0) {
            this.p = true;
            for (int i = 0; i < size; i++) {
                this.i.remove(0);
            }
        }
    }

    private void h() {
        try {
            InputStream openFileInput = this.j.openFileInput(this.k);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, null);
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new r(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f, "Error reading historical recrod file: " + this.k, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f, "Error reading historical recrod file: " + this.k, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public final int a() {
        int size;
        synchronized (this.a) {
            d();
            size = this.b.size();
        }
        return size;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.a) {
            d();
            List list = this.b;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((o) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.a) {
            d();
            resolveInfo = ((o) this.b.get(i)).a;
        }
        return resolveInfo;
    }

    boolean a(r rVar) {
        boolean add = this.i.add(rVar);
        if (add) {
            this.p = true;
            g();
            if (this.o) {
                if (this.p) {
                    this.p = false;
                    if (!TextUtils.isEmpty(this.k)) {
                        AsyncTask tVar = new t();
                        Object[] objArr = new Object[]{this.i, this.k};
                        if (VERSION.SDK_INT >= 11) {
                            tVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            tVar.execute(objArr);
                        }
                    }
                }
                f();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    public final Intent b(int i) {
        synchronized (this.a) {
            if (this.c == null) {
                return null;
            }
            d();
            o oVar = (o) this.b.get(i);
            ComponentName componentName = new ComponentName(oVar.a.activityInfo.packageName, oVar.a.activityInfo.name);
            Intent intent = new Intent(this.c);
            intent.setComponent(componentName);
            if (this.e != null) {
                if (this.e.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new r(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo b() {
        synchronized (this.a) {
            d();
            if (this.b.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((o) this.b.get(0)).a;
            return resolveInfo;
        }
    }

    public final int c() {
        int size;
        synchronized (this.a) {
            d();
            size = this.i.size();
        }
        return size;
    }

    public void d() {
        int i;
        int i2 = 1;
        if (!this.d || this.c == null) {
            i = 0;
        } else {
            this.d = false;
            this.b.clear();
            List queryIntentActivities = this.j.getPackageManager().queryIntentActivities(this.c, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.b.add(new o(this, (ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.n && this.p && !TextUtils.isEmpty(this.k)) {
            this.n = false;
            this.o = true;
            h();
        } else {
            i2 = 0;
        }
        g();
        if ((i | i2) != 0) {
            f();
            notifyChanged();
        }
    }
}
