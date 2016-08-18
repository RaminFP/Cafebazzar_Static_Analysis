package com.c.a.a.a;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class m {
    private static final TimeZone a = TimeZone.getTimeZone("GMT");
    private static final ThreadLocal b = new n();
    private static final String[] c;
    private static final DateFormat[] d;

    static {
        String[] strArr = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        c = strArr;
        d = new DateFormat[strArr.length];
    }

    public static String a(Date date) {
        return ((DateFormat) b.get()).format(date);
    }

    public static Date a(String str) {
        Date date;
        int i = 0;
        if (str.length() == 0) {
            date = null;
        } else {
            ParsePosition parsePosition = new ParsePosition(0);
            date = ((DateFormat) b.get()).parse(str, parsePosition);
            if (parsePosition.getIndex() != str.length()) {
                synchronized (c) {
                    int length = c.length;
                    while (i < length) {
                        DateFormat dateFormat = d[i];
                        if (dateFormat == null) {
                            dateFormat = new SimpleDateFormat(c[i], Locale.US);
                            dateFormat.setTimeZone(a);
                            d[i] = dateFormat;
                        }
                        parsePosition.setIndex(0);
                        date = dateFormat.parse(str, parsePosition);
                        if (parsePosition.getIndex() != 0) {
                            return date;
                        }
                        i++;
                    }
                    return null;
                }
            }
        }
        return date;
    }
}
