package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.b.ab;
import b.a.a.a.a.b.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class j implements e {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private ab e = new ab(this.d);
    private File f = new File(this.b, this.c);

    public j(Context context, File file, String str, String str2) {
        this.a = context;
        this.b = file;
        this.c = str2;
        this.d = new File(this.b, str);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    public final int a() {
        return this.e.a();
    }

    public OutputStream a(File file) {
        return new FileOutputStream(file);
    }

    public final List a(int i) {
        List arrayList = new ArrayList();
        for (Object add : this.f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() > 0) {
                break;
            }
        }
        return arrayList;
    }

    public final void a(String str) {
        Throwable th;
        Throwable th2;
        this.e.close();
        File file = this.d;
        File file2 = new File(this.f, str);
        Closeable fileInputStream;
        Closeable a;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a = a(file2);
                try {
                    l.a((InputStream) fileInputStream, (OutputStream) a, new byte[1024]);
                    l.a(fileInputStream, "Failed to close file input stream");
                    l.a(a, "Failed to close output stream");
                    file.delete();
                    this.e = new ab(this.d);
                } catch (Throwable th3) {
                    th = th3;
                    l.a(fileInputStream, "Failed to close file input stream");
                    l.a(a, "Failed to close output stream");
                    file.delete();
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                a = null;
                th = th2;
                l.a(fileInputStream, "Failed to close file input stream");
                l.a(a, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th5) {
            a = null;
            th2 = th5;
            fileInputStream = null;
            th = th2;
            l.a(fileInputStream, "Failed to close file input stream");
            l.a(a, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public final void a(List list) {
        for (File file : list) {
            l.a(this.a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public final void a(byte[] bArr) {
        this.e.a(bArr, 0, bArr.length);
    }

    public final boolean a(int i, int i2) {
        return (this.e.a() + 4) + i <= i2;
    }

    public final boolean b() {
        return this.e.b();
    }

    public final List c() {
        return Arrays.asList(this.f.listFiles());
    }

    public final void d() {
        try {
            this.e.close();
        } catch (IOException e) {
        }
        this.d.delete();
    }
}
