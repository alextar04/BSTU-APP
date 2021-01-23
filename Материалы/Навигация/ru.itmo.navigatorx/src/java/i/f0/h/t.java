/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package i.f0.h;

public final class t {
    public int a;
    public final int[] b = new int[10];

    public int a() {
        if ((128 & this.a) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public t b(int n2, int n3) {
        if (n2 >= 0) {
            int[] arrn = this.b;
            if (n2 >= arrn.length) {
                return this;
            }
            this.a = 1 << n2 | this.a;
            arrn[n2] = n3;
        }
        return this;
    }
}

