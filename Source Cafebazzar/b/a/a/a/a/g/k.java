package b.a.a.a.a.g;

import b.a.a.a.a.b.q;
import org.json.JSONObject;

final class k implements x {
    k() {
    }

    public final v a(q qVar, JSONObject jSONObject) {
        long j;
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        String string = jSONObject2.getString("identifier");
        String string2 = jSONObject2.getString("status");
        String string3 = jSONObject2.getString("url");
        String string4 = jSONObject2.getString("reports_url");
        boolean optBoolean = jSONObject2.optBoolean("update_required", false);
        c cVar = null;
        if (jSONObject2.has("icon") && jSONObject2.getJSONObject("icon").has("hash")) {
            jSONObject2 = jSONObject2.getJSONObject("icon");
            cVar = new c(jSONObject2.getString("hash"), jSONObject2.getInt("width"), jSONObject2.getInt("height"));
        }
        e eVar = new e(string, string2, string3, string4, optBoolean, cVar);
        JSONObject jSONObject3 = jSONObject.getJSONObject("session");
        p pVar = new p(jSONObject3.optInt("log_buffer_size", 64000), jSONObject3.optInt("max_chained_exception_depth", 8), jSONObject3.optInt("max_custom_exception_events", 64), jSONObject3.optInt("max_custom_key_value_pairs", 64), jSONObject3.optInt("identifier_mask", 255), jSONObject3.optBoolean("send_session_without_crash", false));
        JSONObject jSONObject4 = jSONObject.getJSONObject("prompt");
        o oVar = new o(jSONObject4.optString("title", "Send Crash Report?"), jSONObject4.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject4.optString("send_button_title", "Send"), jSONObject4.optBoolean("show_cancel_button", true), jSONObject4.optString("cancel_button_title", "Don't Send"), jSONObject4.optBoolean("show_always_send_button", true), jSONObject4.optString("always_send_button_title", "Always Send"));
        JSONObject jSONObject5 = jSONObject.getJSONObject("features");
        m mVar = new m(jSONObject5.optBoolean("prompt_enabled", false), jSONObject5.optBoolean("collect_logged_exceptions", true), jSONObject5.optBoolean("collect_reports", true), jSONObject5.optBoolean("collect_analytics", false));
        JSONObject jSONObject6 = jSONObject.getJSONObject("analytics");
        b bVar = new b(jSONObject6.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject6.optInt("flush_interval_secs", 600), jSONObject6.optInt("max_byte_size_per_file", 8000), jSONObject6.optInt("max_file_count_per_send", 1), jSONObject6.optInt("max_pending_send_file_count", 100), jSONObject6.optBoolean("track_custom_events", true), jSONObject6.optBoolean("track_predefined_events", true), jSONObject6.optInt("sampling_rate", 1), jSONObject6.optBoolean("flush_on_background", true));
        JSONObject jSONObject7 = jSONObject.getJSONObject("beta");
        f fVar = new f(jSONObject7.optString("update_endpoint", w.a), jSONObject7.optInt("update_suspend_duration", 3600));
        long j2 = (long) optInt2;
        if (jSONObject.has("expires_at")) {
            j = jSONObject.getLong("expires_at");
        } else {
            j = qVar.a() + (j2 * 1000);
        }
        return new v(j, eVar, pVar, oVar, mVar, bVar, fVar, optInt, optInt2);
    }
}
