package b.a.a.a.a.b;

import android.os.Build;
import android.text.TextUtils;
import b.a.a.a.f;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

enum n {
    X86_32,
    X86_64,
    ARM_UNKNOWN,
    PPC,
    PPC64,
    ARMV6,
    ARMV7,
    UNKNOWN,
    ARMV7S,
    ARM64;
    
    private static final Map k = null;

    static {
        Map hashMap = new HashMap(4);
        k = hashMap;
        hashMap.put("armeabi-v7a", ARMV7);
        k.put("armeabi", ARMV6);
        k.put("x86", X86_32);
    }

    static n a() {
        Object obj = Build.CPU_ABI;
        if (TextUtils.isEmpty(obj)) {
            f.a().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
            return UNKNOWN;
        }
        n nVar = (n) k.get(obj.toLowerCase(Locale.US));
        return nVar == null ? UNKNOWN : nVar;
    }
}
