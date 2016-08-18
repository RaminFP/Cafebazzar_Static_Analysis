package android.support.v7.internal.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class t extends AsyncTask {
    final /* synthetic */ n a;

    private t(n nVar) {
        this.a = nVar;
    }

    private Void a(Object... objArr) {
        int i = 0;
        List list = (List) objArr[0];
        String str = (String) objArr[1];
        try {
            OutputStream openFileOutput = this.a.j.openFileOutput(str, 0);
            XmlSerializer newSerializer = Xml.newSerializer();
            try {
                newSerializer.setOutput(openFileOutput, null);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "historical-records");
                int size = list.size();
                while (i < size) {
                    r rVar = (r) list.remove(0);
                    newSerializer.startTag(null, "historical-record");
                    newSerializer.attribute(null, "activity", rVar.a.flattenToString());
                    newSerializer.attribute(null, "time", String.valueOf(rVar.b));
                    newSerializer.attribute(null, "weight", String.valueOf(rVar.c));
                    newSerializer.endTag(null, "historical-record");
                    i++;
                }
                newSerializer.endTag(null, "historical-records");
                newSerializer.endDocument();
                this.a.n = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                Log.e(n.f, "Error writing historical recrod file: " + this.a.k, e2);
                this.a.n = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(n.f, "Error writing historical recrod file: " + this.a.k, e22);
                this.a.n = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable e222) {
                Log.e(n.f, "Error writing historical recrod file: " + this.a.k, e222);
                this.a.n = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                this.a.n = true;
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (Throwable e2222) {
            Log.e(n.f, "Error writing historical recrod file: " + str, e2222);
        }
        return null;
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a(objArr);
    }
}
