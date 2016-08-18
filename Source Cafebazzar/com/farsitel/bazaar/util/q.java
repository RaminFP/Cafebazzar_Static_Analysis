package com.farsitel.bazaar.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.farsitel.bazaar.BazaarApplication;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;

public class q {
    private static long a = 0;
    private static long b = 0;

    public static String a() {
        TelephonyManager telephonyManager = (TelephonyManager) BazaarApplication.c().getSystemService("phone");
        if (telephonyManager == null) {
            return "null";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator == null) {
            return BazaarApplication.c().getString(2131165855);
        }
        Object obj = -1;
        switch (networkOperator.hashCode()) {
            case 47834357:
                if (networkOperator.equals("26207")) {
                    obj = 5;
                    break;
                }
                break;
            case 47897777:
                if (networkOperator.equals("28601")) {
                    obj = 7;
                    break;
                }
                break;
            case 49564152:
                if (networkOperator.equals("42402")) {
                    obj = 6;
                    break;
                }
                break;
            case 49592051:
                if (networkOperator.equals("43211")) {
                    obj = 2;
                    break;
                }
                break;
            case 49592081:
                if (networkOperator.equals("43220")) {
                    obj = null;
                    break;
                }
                break;
            case 49592114:
                if (networkOperator.equals("43232")) {
                    obj = 4;
                    break;
                }
                break;
            case 49592117:
                if (networkOperator.equals("43235")) {
                    obj = 1;
                    break;
                }
                break;
            case 49592236:
                if (networkOperator.equals("43270")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return BazaarApplication.c().getString(2131165816);
            case 1:
                return BazaarApplication.c().getString(2131165813);
            case 2:
                return BazaarApplication.c().getString(2131165814);
            case 3:
                return BazaarApplication.c().getString(2131165817);
            case 4:
                return BazaarApplication.c().getString(2131165818);
            case 5:
                return BazaarApplication.c().getString(2131165815);
            case 6:
                return BazaarApplication.c().getString(2131165812);
            case 7:
                return BazaarApplication.c().getString(2131165819);
            default:
                return networkOperator;
        }
    }

    public static String a(boolean z) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if ((hostAddress.indexOf(58) < 0 ? 1 : null) != null) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static void a(long j) {
        b = (a + j) / 2;
        a = j;
    }

    public static int b() {
        try {
            Object simCountryIso = ((TelephonyManager) BazaarApplication.c().getSystemService("phone")).getSimCountryIso();
            if (!(simCountryIso == null || TextUtils.isEmpty(simCountryIso))) {
                return simCountryIso.toLowerCase().equals("ir") ? r.c : r.a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r.b;
    }

    public static int c() {
        return h()[0];
    }

    public static int d() {
        return h()[1];
    }

    public static boolean e() {
        try {
            return ((ConnectivityManager) BazaarApplication.c().getSystemService("connectivity")).getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean f() {
        try {
            return !((ConnectivityManager) BazaarApplication.c().getSystemService("connectivity")).getNetworkInfo(0).isConnectedOrConnecting();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String g() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BazaarApplication.c().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return "NOT CONNECTED";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G (" + subtype + ")";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G (" + subtype + ")";
                    case 13:
                        return "4G (" + subtype + ")";
                    default:
                        return "UNKNOWN MOBILE NETWORK";
                }
            }
            return "NONE";
        } catch (Exception e) {
        }
    }

    private static int[] h() {
        TelephonyManager telephonyManager = (TelephonyManager) BazaarApplication.c().getSystemService("phone");
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null) {
                try {
                    if (networkOperator.length() > 3) {
                        int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
                        int parseInt2 = Integer.parseInt(networkOperator.substring(3));
                        return new int[]{parseInt, parseInt2};
                    }
                } catch (Throwable e) {
                    Log.e(q.class.getSimpleName(), "telephony manager : network", e);
                }
            }
        }
        return new int[]{0, 0};
    }
}
