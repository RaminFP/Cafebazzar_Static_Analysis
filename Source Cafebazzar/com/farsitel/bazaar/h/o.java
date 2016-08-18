package com.farsitel.bazaar.h;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public final class o implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ p b;

    public o(String str, p pVar) {
        this.a = str;
        this.b = pVar;
    }

    public final void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            if (httpURLConnection.getResponseCode() == Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        this.b.a(new JSONObject(str));
                        return;
                    }
                }
            }
            this.b.a();
        } catch (IOException e) {
            this.b.a();
        } catch (JSONException e2) {
            this.b.a();
        }
    }
}
