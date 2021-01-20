/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package i.f0.h;

import c.b.a.a.a;
import i.f0.c;
import j.h;
import java.io.IOException;

public final class e {
    public static final h a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;

    public static {
        String[] arrstring;
        String[] arrstring2;
        a = h.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        c = new String[64];
        d = new String[256];
        for (int i2 = 0; i2 < (arrstring = d).length; ++i2) {
            Object[] arrobject = new Object[]{Integer.toBinaryString((int)i2)};
            arrstring[i2] = c.n("%8s", arrobject).replace(' ', '0');
        }
        String[] arrstring3 = c;
        arrstring3[0] = "";
        arrstring3[1] = "END_STREAM";
        int[] arrn = new int[]{1};
        arrstring3[8] = "PADDED";
        for (int i3 = 0; i3 < 1; ++i3) {
            int n2 = arrn[i3];
            e.c[n2 | 8] = a.l(new StringBuilder(), c[n2], "|PADDED");
        }
        String[] arrstring4 = c;
        arrstring4[4] = "END_HEADERS";
        arrstring4[32] = "PRIORITY";
        arrstring4[36] = "END_HEADERS|PRIORITY";
        int[] arrn2 = new int[]{4, 32, 36};
        int n3 = 0;
        do {
            if (n3 >= 3) break;
            int n4 = arrn2[n3];
            for (int i4 = 0; i4 < 1; ++i4) {
                int n5 = arrn[i4];
                String[] arrstring5 = c;
                int n6 = n5 | n4;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c[n5]);
                stringBuilder.append('|');
                stringBuilder.append(c[n4]);
                arrstring5[n6] = stringBuilder.toString();
                String[] arrstring6 = c;
                int n7 = n6 | 8;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(c[n5]);
                stringBuilder2.append('|');
                arrstring6[n7] = a.l(stringBuilder2, c[n4], "|PADDED");
            }
            ++n3;
        } while (true);
        for (int i5 = 0; i5 < (arrstring2 = c).length; ++i5) {
            if (arrstring2[i5] != null) continue;
            arrstring2[i5] = d[i5];
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static String a(boolean var0, int var1_1, int var2_2, byte var3_3, byte var4_4) {
        block5 : {
            block6 : {
                block7 : {
                    block8 : {
                        block4 : {
                            var5_5 = e.b;
                            if (var3_3 < var5_5.length) {
                                var7_6 = var5_5[var3_3];
                            } else {
                                var6_7 = new Object[]{var3_3};
                                var7_6 = c.n("0x%02x", var6_7);
                            }
                            if (var4_4 != 0) break block4;
                            var8_8 = "";
                            break block5;
                        }
                        if (var3_3 == 2 || var3_3 == 3) break block6;
                        if (var3_3 == 4 || var3_3 == 6) break block7;
                        if (var3_3 == 7 || var3_3 == 8) break block6;
                        var11_9 = e.c;
                        var12_10 = var4_4 < var11_9.length ? var11_9[var4_4] : e.d[var4_4];
                        if (var3_3 != 5 || (var4_4 & 4) == 0) break block8;
                        var13_11 = "HEADERS";
                        var14_12 = "PUSH_PROMISE";
                        ** GOTO lbl24
                    }
                    if (var3_3 == 0 && (var4_4 & 32) != 0) {
                        var13_11 = "PRIORITY";
                        var14_12 = "COMPRESSED";
lbl24: // 2 sources:
                        var8_8 = var12_10.replace((CharSequence)var13_11, (CharSequence)var14_12);
                    } else {
                        var8_8 = var12_10;
                    }
                    break block5;
                }
                var8_8 = var4_4 == 1 ? "ACK" : e.d[var4_4];
                break block5;
            }
            var8_8 = e.d[var4_4];
        }
        var9_13 = new Object[5];
        var10_14 = var0 != false ? "<<" : ">>";
        var9_13[0] = var10_14;
        var9_13[1] = var1_1;
        var9_13[2] = var2_2;
        var9_13[3] = var7_6;
        var9_13[4] = var8_8;
        return c.n("%s 0x%08x %5d %-13s %s", var9_13);
    }

    public static /* varargs */ IllegalArgumentException b(String string, Object ... arrobject) {
        throw new IllegalArgumentException(c.n(string, arrobject));
    }

    public static /* varargs */ IOException c(String string, Object ... arrobject) {
        throw new IOException(c.n(string, arrobject));
    }
}

