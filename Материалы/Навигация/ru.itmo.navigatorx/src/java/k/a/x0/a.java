/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package k.a.x0;

public final class a {
    public static final byte[] a;
    public static final int[] b;

    public static {
        byte[] arrby;
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        b = new int[128];
        int n2 = 0;
        while (n2 < (arrby = a).length) {
            a.b[arrby[n2]] = n2++;
        }
    }

    public static String a(byte[] arrby) {
        int n2 = 4 * (arrby.length / 3);
        int n3 = arrby.length % 3 == 0 ? 0 : 4;
        int n4 = n2 + n3;
        byte[] arrby2 = new byte[n4];
        int n5 = arrby.length;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n9 = arrby[i2];
            n6 = (n6 + 1) % 3;
            if (n9 < 0) {
                n9 += 256;
            }
            n8 = n9 + (n8 << 8);
            if (n6 != 0) continue;
            int n10 = n7 + 1;
            byte[] arrby3 = a;
            arrby2[n7] = arrby3[63 & n8 >> 18];
            int n11 = n10 + 1;
            arrby2[n10] = arrby3[63 & n8 >> 12];
            int n12 = n11 + 1;
            arrby2[n11] = arrby3[63 & n8 >> 6];
            n7 = n12 + 1;
            arrby2[n12] = arrby3[n8 & 63];
        }
        if (n6 != 1) {
            if (n6 == 2) {
                int n13 = n7 + 1;
                byte[] arrby4 = a;
                arrby2[n7] = arrby4[63 & n8 >> 10];
                int n14 = n13 + 1;
                arrby2[n13] = arrby4[63 & n8 >> 4];
                int n15 = n14 + 1;
                arrby2[n14] = arrby4[63 & n8 << 2];
                arrby2[n15] = 61;
            }
        } else {
            int n16 = n7 + 1;
            byte[] arrby5 = a;
            arrby2[n7] = arrby5[63 & n8 >> 2];
            int n17 = n16 + 1;
            arrby2[n16] = arrby5[63 & n8 << 4];
            int n18 = n17 + 1;
            arrby2[n17] = 61;
            arrby2[n18] = 61;
        }
        return new String(arrby2, 0, 0, n4);
    }
}

