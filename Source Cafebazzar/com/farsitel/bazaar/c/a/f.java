package com.farsitel.bazaar.c.a;

public final class f {
    public static boolean a(int i) {
        return i == 12 || i == 13 || i == 14;
    }

    public static boolean b(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 11 || i == 12;
    }

    public static String c(int i) {
        switch (i) {
            case 0:
                return "uninstalled";
            case 1:
                return "installed";
            case 2:
                return "installing";
            case 3:
                return "success";
            case 4:
                return "failed";
            case 5:
                return "failed_storage";
            case 6:
                return "failed_not_bought";
            case 7:
                return "failed_disabled";
            case 8:
                return "failed_not_found";
            case 9:
                return "failed_patch";
            case 10:
                return "not_initiated";
            case 11:
                return "paused";
            case 12:
                return "queued";
            case 13:
                return "in_progress";
            case 14:
                return "checking";
            default:
                return null;
        }
    }
}
