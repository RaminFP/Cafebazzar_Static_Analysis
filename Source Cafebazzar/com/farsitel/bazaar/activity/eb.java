package com.farsitel.bazaar.activity;

import com.farsitel.bazaar.h.p;
import org.json.JSONException;
import org.json.JSONObject;

final class eb implements p {
    final /* synthetic */ VideoPlayerActivity a;

    private eb(VideoPlayerActivity videoPlayerActivity) {
        this.a = videoPlayerActivity;
    }

    public final void a() {
        this.a.a();
        this.a.finish();
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.a.l = jSONObject.getJSONObject("videoshow").getString("file_link");
            this.a.b();
        } catch (JSONException e) {
            e.printStackTrace();
            this.a.a();
            this.a.finish();
        }
    }
}
