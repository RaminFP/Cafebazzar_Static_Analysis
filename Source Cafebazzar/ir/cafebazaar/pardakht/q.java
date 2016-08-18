package ir.cafebazaar.pardakht;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

final class q extends WebViewClient {
    final /* synthetic */ PardakhtActivity a;

    q(PardakhtActivity pardakhtActivity) {
        this.a = pardakhtActivity;
    }

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        message2.sendToTarget();
    }

    public final void onPageFinished(WebView webView, String str) {
        PardakhtActivity pardakhtActivity = this.a;
        SslCertificate certificate = webView.getCertificate();
        pardakhtActivity.e = certificate;
        Uri parse = Uri.parse(str);
        try {
            String scheme = parse.getScheme();
            pardakhtActivity.b = (TextView) pardakhtActivity.findViewById(2131624370);
            pardakhtActivity.a = (ImageView) pardakhtActivity.findViewById(2131624369);
            pardakhtActivity.c = (TextView) pardakhtActivity.findViewById(2131624371);
            pardakhtActivity.d = (TextView) pardakhtActivity.findViewById(2131624372);
            if (scheme.contains("http")) {
                pardakhtActivity.a.setVisibility(0);
                pardakhtActivity.b.setVisibility(0);
                pardakhtActivity.c.setVisibility(0);
                pardakhtActivity.d.setVisibility(0);
                pardakhtActivity.b.setText(scheme + "://");
                int color;
                if (certificate == null) {
                    color = pardakhtActivity.getResources().getColor(2131558543);
                    pardakhtActivity.a.setColorFilter(color);
                    pardakhtActivity.b.setTextColor(color);
                    pardakhtActivity.a.setOnClickListener(null);
                    pardakhtActivity.b.setOnClickListener(null);
                } else {
                    color = pardakhtActivity.getResources().getColor(2131558471);
                    pardakhtActivity.a.setColorFilter(color);
                    pardakhtActivity.b.setTextColor(color);
                    OnClickListener tVar = new t(pardakhtActivity);
                    pardakhtActivity.a.setOnClickListener(tVar);
                    pardakhtActivity.b.setOnClickListener(tVar);
                }
                pardakhtActivity.c.setText(parse.getAuthority());
                pardakhtActivity.d.setText(str.substring(str.indexOf(parse.getPath())));
            } else {
                pardakhtActivity.a.setVisibility(4);
                pardakhtActivity.b.setVisibility(8);
                pardakhtActivity.c.setVisibility(8);
                pardakhtActivity.d.setVisibility(8);
            }
        } catch (Exception e) {
        }
        this.a.k.setVisibility(8);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.k.setVisibility(0);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Log.e("Bazaar-Payment-Web", "onReceivedError :: errorCode= " + i);
        this.a.findViewById(2131624376).setVisibility(0);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a.a(sslError)) {
            sslErrorHandler.proceed();
            return;
        }
        Log.e("Bazaar-Payment-Web", "onReceivedSslError :: " + sslError.toString());
        sslErrorHandler.cancel();
        this.a.j.loadData(this.a.getString(2131165660), "text/html; charset=utf-8", "utf-8");
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
