/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package f.b.p;

public class o0 {
    public int a = 0;
    public int b = 0;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public void a(int n2, int n3) {
        this.c = n2;
        this.d = n3;
        this.h = true;
        if (this.g) {
            if (n3 != Integer.MIN_VALUE) {
                this.a = n3;
            }
            if (n2 != Integer.MIN_VALUE) {
                this.b = n2;
                return;
            }
        } else {
            if (n2 != Integer.MIN_VALUE) {
                this.a = n2;
            }
            if (n3 != Integer.MIN_VALUE) {
                this.b = n3;
            }
        }
    }
}

