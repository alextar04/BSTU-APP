/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 */
package k.a.x0;

import java.math.BigInteger;

public final class g {
    public static final long[] a = new long[37];
    public static final int[] b = new int[37];
    public static final int[] c = new int[37];

    /*
     * Enabled aggressive block sorting
     */
    public static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        int n2 = 2;
        do {
            long l2;
            block7 : {
                long l3;
                block6 : {
                    block5 : {
                        long l4;
                        if (n2 > 36) {
                            return;
                        }
                        long[] arrl = a;
                        l3 = n2;
                        long l5 = l3 LCMP 0L;
                        l2 = -1L;
                        if (l5 < 0) {
                            l4 = g.a(l2, l3) < 0 ? 0L : 1L;
                        } else {
                            long l6 = Long.MAX_VALUE / l3 << 1;
                            int n3 = g.a(l2 - l6 * l3, l3) >= 0 ? 1 : 0;
                            l4 = l6 + (long)n3;
                        }
                        arrl[n2] = l4;
                        int[] arrn = b;
                        if (l5 >= 0) break block5;
                        if (g.a(l2, l3) >= 0) break block6;
                        break block7;
                    }
                    if (g.a(l2 -= l3 * (Long.MAX_VALUE / l3 << 1), l3) < 0) {
                        l3 = 0L;
                    }
                }
                l2 -= l3;
            }
            arrn[n2] = (int)l2;
            g.c[n2] = bigInteger.toString(n2).length() - 1;
            ++n2;
        } while (true);
    }

    public static int a(long l2, long l3) {
        long l4 = l2 - Long.MIN_VALUE LCMP l3 - Long.MIN_VALUE;
        if (l4 < 0) {
            return -1;
        }
        return l4 != false;
    }

    public static String b(long l2) {
        if (l2 >= 0L) {
            return Long.toString((long)l2);
        }
        long l3 = (l2 >>> 1) / 5L;
        long l4 = l2 - 10L * l3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Long.toString((long)l3));
        stringBuilder.append(l4);
        return stringBuilder.toString();
    }
}

