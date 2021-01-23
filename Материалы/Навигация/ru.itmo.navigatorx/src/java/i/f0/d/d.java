/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package i.f0.d;

import i.a0;
import i.q;
import i.x;

public final class d {
    public final x a;
    public final a0 b;

    public d(x x2, a0 a02) {
        this.a = x2;
        this.b = a02;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean a(a0 var0, x var1_1) {
        block8 : {
            var2_2 = var0.g;
            if (var2_2 == 200 || var2_2 == 410 || var2_2 == 414 || var2_2 == 501 || var2_2 == 203 || var2_2 == 204) break block8;
            if (var2_2 == 307) ** GOTO lbl-1000
            if (var2_2 == 308 || var2_2 == 404 || var2_2 == 405) break block8;
            switch (var2_2) {
                default: {
                    return false;
                }
                case 302: lbl-1000: // 2 sources:
                {
                    if ((var6_3 = var0.j.c("Expires")) == null) {
                        var6_3 = null;
                    }
                    if (var6_3 != null || var0.c().c != -1 || var0.c().f) break;
                    if (var0.c().e == false) return false;
                    break;
                }
                case 300: 
                case 301: 
            }
        }
        var3_4 = var0.c().b;
        var4_5 = false;
        if (var3_4 != false) return var4_5;
        var5_6 = var1_1.a().b;
        var4_5 = false;
        if (var5_6 != false) return var4_5;
        return true;
    }
}

