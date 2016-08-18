package com.a.a.c;

import b.a.a.a.a.b.l;
import b.a.a.a.f;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

final class az {
    public static void a(Throwable th, OutputStream outputStream) {
        Closeable printWriter;
        Throwable e;
        Throwable th2;
        Throwable th3;
        Closeable closeable = null;
        if (outputStream != null) {
            try {
                printWriter = new PrintWriter(outputStream);
                try {
                    a(th, (Writer) printWriter);
                    l.a(printWriter, "Failed to close stack trace writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        f.a().c("CrashlyticsCore", "Failed to create PrintWriter", e);
                        l.a(printWriter, "Failed to close stack trace writer.");
                    } catch (Throwable e3) {
                        th2 = e3;
                        closeable = printWriter;
                        th3 = th2;
                        l.a(closeable, "Failed to close stack trace writer.");
                        throw th3;
                    }
                }
            } catch (Throwable th32) {
                th2 = th32;
                printWriter = null;
                e3 = th2;
                f.a().c("CrashlyticsCore", "Failed to create PrintWriter", e3);
                l.a(printWriter, "Failed to close stack trace writer.");
            } catch (Throwable th4) {
                th32 = th4;
                l.a(closeable, "Failed to close stack trace writer.");
                throw th32;
            }
        }
    }

    private static void a(Throwable th, Writer writer) {
        Object obj = 1;
        while (th != null) {
            String localizedMessage = th.getLocalizedMessage();
            localizedMessage = localizedMessage == null ? null : localizedMessage.replaceAll("(\r\n|\n|\f)", " ");
            if (localizedMessage == null) {
                localizedMessage = "";
            }
            try {
                writer.write((obj != null ? "" : "Caused by: ") + th.getClass().getName() + ": " + localizedMessage + "\n");
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    writer.write("\tat " + stackTraceElement.toString() + "\n");
                }
                th = th.getCause();
                obj = null;
            } catch (Throwable e) {
                f.a().c("CrashlyticsCore", "Could not write stack trace", e);
                return;
            }
        }
    }
}
