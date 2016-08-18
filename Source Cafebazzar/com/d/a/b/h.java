package com.d.a.b;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

public final class h extends Thread {
    public int a;
    public Process b;
    public BufferedReader c;
    public OutputStreamWriter d;

    private h(Process process, BufferedReader bufferedReader, OutputStreamWriter outputStreamWriter) {
        this.a = -911;
        this.b = process;
        this.c = bufferedReader;
        this.d = outputStreamWriter;
    }

    public final void run() {
        try {
            this.d.write("echo Started\n");
            this.d.flush();
            while (true) {
                String readLine = this.c.readLine();
                if (readLine == null) {
                    throw new EOFException();
                } else if (!"".equals(readLine)) {
                    if ("Started".equals(readLine)) {
                        break;
                    }
                    d.h = "unkown error occured.";
                }
            }
            this.a = 1;
            try {
                Field declaredField;
                try {
                    declaredField = this.b.getClass().getDeclaredField("pid");
                } catch (NoSuchFieldException e) {
                    declaredField = r0.getDeclaredField("id");
                }
                declaredField.setAccessible(true);
                this.d.write("(echo -17 > /proc/" + ((Integer) declaredField.get(this.b)).intValue() + "/oom_adj) &> /dev/null\n");
                this.d.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.d.flush();
            } catch (Exception e2) {
            }
        } catch (IOException e3) {
            this.a = -42;
            if (e3.getMessage() != null) {
                d.h = e3.getMessage();
            } else {
                d.h = "RootAccess denied?.";
            }
        }
    }
}
