package d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class r {
    private static final Logger a = Logger.getLogger(r.class.getName());

    private r() {
    }

    private static ab a(OutputStream outputStream) {
        return a(outputStream, new ad());
    }

    private static ab a(OutputStream outputStream, ad adVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (adVar != null) {
            return new s(adVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static ab a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        ad c = c(socket);
        return new b(c, a(socket.getOutputStream(), c));
    }

    public static ac a(File file) {
        if (file != null) {
            return a(new FileInputStream(file), new ad());
        }
        throw new IllegalArgumentException("file == null");
    }

    private static ac a(InputStream inputStream, ad adVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (adVar != null) {
            return new t(adVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static i a(ab abVar) {
        if (abVar != null) {
            return new v(abVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static j a(ac acVar) {
        if (acVar != null) {
            return new x(acVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static ab b(File file) {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static ac b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        ad c = c(socket);
        return new c(c, a(socket.getInputStream(), c));
    }

    private static a c(Socket socket) {
        return new u(socket);
    }

    public static ab c(File file) {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }
}
