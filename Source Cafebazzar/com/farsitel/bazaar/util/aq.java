package com.farsitel.bazaar.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.style.ClickableSpan;
import android.view.View;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.g.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public final class aq extends ClickableSpan {
    String a;

    public aq(String str) {
        this.a = str;
    }

    public final void onClick(View view) {
        if (this.a.contains("support@cafebazaar.ir")) {
            File file = new File(t.b(), "device_information.txt");
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.println("Device:");
                printWriter.print("model: " + Build.MODEL);
                printWriter.print(", product: " + Build.PRODUCT);
                printWriter.print(", device: " + Build.DEVICE);
                printWriter.print(", Manufacturer: " + Build.MANUFACTURER);
                printWriter.print(", SDK Version: " + VERSION.SDK_INT);
                printWriter.print(", Android_id: " + p.a());
                printWriter.print(", Size: " + o.a());
                printWriter.print(", mcc: " + q.c());
                printWriter.print(", mnc: " + q.d());
                printWriter.print(", City: " + h.INSTANCE.b());
                printWriter.print(", Province: " + h.INSTANCE.c());
                printWriter.print(", Bazaar Version: " + k.c());
                printWriter.flush();
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (file.exists() && file.canRead()) {
                Parcelable fromFile = Uri.fromFile(file);
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    if (j.a().n()) {
                        intent.putExtra("android.intent.extra.SUBJECT", "Feedback from " + j.a().h());
                    } else {
                        intent.putExtra("android.intent.extra.SUBJECT", "Feedback from Bazaar App");
                    }
                    intent.putExtra("android.intent.extra.STREAM", fromFile);
                    intent.setData(Uri.fromParts("mailto", "support@cafebazaar.ir", null));
                    intent.setFlags(268435456);
                    BazaarApplication.c().startActivity(intent);
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            return;
        }
        BazaarApplication.c().startActivity(new Intent(this.a));
    }
}
