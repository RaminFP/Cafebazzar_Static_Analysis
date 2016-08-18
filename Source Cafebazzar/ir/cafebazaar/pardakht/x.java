package ir.cafebazaar.pardakht;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import com.congenialmobile.SOB;
import com.farsitel.bazaar.g.j;
import com.farsitel.bazaar.i;
import com.farsitel.bazaar.util.k;
import com.farsitel.bazaar.util.q;
import ir.cafebazaar.pardakht.a.a;
import ir.cafebazaar.pardakht.a.b;
import org.json.JSONObject;

final class x implements SOB {
    final /* synthetic */ PardakhtActivity a;

    private x(PardakhtActivity pardakhtActivity) {
        this.a = pardakhtActivity;
    }

    @JavascriptInterface
    public final boolean dial(String[] strArr) {
        int i = 0;
        if (strArr[0].equals("140") || strArr[0].equals("130") || strArr[0].equals("141") || strArr[0].equals("131")) {
            return false;
        }
        String str = "";
        while (i < strArr.length) {
            str = str + "*" + strArr[i];
            i++;
        }
        this.a.startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:" + (str + Uri.encode("#")))), 101);
        return true;
    }

    @JavascriptInterface
    public final int getBazaarVersion() {
        return k.b();
    }

    @JavascriptInterface
    public final String getFromSecureCache(String str) {
        b bVar = b.INSTANCE;
        a aVar = (a) bVar.b.get(str);
        if (aVar.b >= System.currentTimeMillis()) {
            return aVar.a;
        }
        bVar.b.remove(str);
        return null;
    }

    @JavascriptInterface
    public final int getMcc() {
        return q.c();
    }

    @JavascriptInterface
    public final int getMnc() {
        return q.d();
    }

    @JavascriptInterface
    public final void setInSecureCache(String str, String str2, int i) {
        b.INSTANCE.b.put(str, new a(str2, System.currentTimeMillis() + ((long) i)));
    }

    @JavascriptInterface
    public final void setV1CreditFinished(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("credit")) {
                long parseLong = Long.parseLong(jSONObject.get("credit").toString());
                if (j.a() != null) {
                    j.a().a(parseLong);
                }
                Intent intent = new Intent();
                intent.putExtra("credit", parseLong);
                this.a.setResult(-1, intent);
            } else {
                this.a.setResult(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.a.setResult(-1);
        }
        this.a.l = false;
        this.a.finish();
    }

    @JavascriptInterface
    public final void setV1Failed(int i) {
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", i);
        this.a.setResult(0, intent);
        this.a.l = false;
    }

    @JavascriptInterface
    public final void setV1Result(String str, String str2, String str3) {
        this.a.h.a(str, str2, str3);
        Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        this.a.setResult(-1, intent);
        this.a.l = false;
        this.a.finish();
    }

    @JavascriptInterface
    public final void track(String str) {
        PardakhtActivity.f.d();
        i.a(str);
    }
}
