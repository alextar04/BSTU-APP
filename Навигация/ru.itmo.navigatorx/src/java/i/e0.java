/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package i;

import c.b.a.a.a;

public final class e0
extends Enum<e0> {
    public static final /* enum */ e0 f;
    public static final /* enum */ e0 g;
    public static final /* enum */ e0 h;
    public static final /* enum */ e0 i;
    public static final /* enum */ e0 j;
    public static final /* synthetic */ e0[] k;
    public final String e;

    public static {
        e0 e02;
        f = new e0("TLSv1.3");
        g = new e0("TLSv1.2");
        h = new e0("TLSv1.1");
        i = new e0("TLSv1");
        j = e02 = new e0("SSLv3");
        e0[] arre0 = new e0[]{f, g, h, i, e02};
        k = arre0;
    }

    public e0(String string2) {
        this.e = string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static e0 a(String var0) {
        block12 : {
            block10 : {
                block11 : {
                    var1_1 = var0.hashCode();
                    if (var1_1 == 79201641) break block10;
                    if (var1_1 == 79923350) break block11;
                    switch (var1_1) {
                        default: {
                            ** GOTO lbl-1000
                        }
                        case -503070501: {
                            if (var0.equals((Object)"TLSv1.3")) {
                                var2_2 = 0;
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case -503070502: {
                            if (var0.equals((Object)"TLSv1.2")) {
                                var2_2 = 1;
                                ** break;
                            }
                            ** GOTO lbl-1000
                        }
                        case -503070503: {
                            if (var0.equals((Object)"TLSv1.1")) {
                                var2_2 = 2;
                                ** break;
                            }
                            ** GOTO lbl-1000
lbl22: // 3 sources:
                            break;
                        }
                    }
                    break block12;
                }
                if (!var0.equals((Object)"TLSv1")) ** GOTO lbl-1000
                var2_2 = 3;
                break block12;
            }
            if (var0.equals((Object)"SSLv3")) {
                var2_2 = 4;
            } else lbl-1000: // 6 sources:
            {
                var2_2 = -1;
            }
        }
        if (var2_2 == 0) return e0.f;
        if (var2_2 == 1) return e0.g;
        if (var2_2 == 2) return e0.h;
        if (var2_2 == 3) return e0.i;
        if (var2_2 != 4) throw new IllegalArgumentException(a.j("Unexpected TLS version: ", var0));
        return e0.j;
    }

    public static e0 valueOf(String string) {
        return (e0)Enum.valueOf(e0.class, (String)string);
    }

    public static e0[] values() {
        return (e0[])k.clone();
    }
}

