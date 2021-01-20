/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.p.d.s
 *  java.lang.Math
 *  java.lang.Object
 */
package f.p.d;

import f.p.d.s;

public class b
implements s {
    public final s a;
    public int b = 0;
    public int c = -1;
    public int d = -1;
    public Object e = null;

    public b(s s2) {
        this.a = s2;
    }

    public void a(int n2, int n3) {
        int n4;
        if (this.b == 2 && (n4 = this.c) >= n2 && n4 <= n2 + n3) {
            this.d = n3 + this.d;
            this.c = n2;
            return;
        }
        this.e();
        this.c = n2;
        this.d = n3;
        this.b = 2;
    }

    public void b(int n2, int n3) {
        int n4;
        int n5;
        if (this.b == 1 && n2 >= (n5 = this.c) && n2 <= n5 + (n4 = this.d)) {
            this.d = n4 + n3;
            this.c = Math.min((int)n2, (int)n5);
            return;
        }
        this.e();
        this.c = n2;
        this.d = n3;
        this.b = 1;
    }

    public void c(int n2, int n3) {
        this.e();
        this.a.c(n2, n3);
    }

    public void d(int n2, int n3, Object object) {
        int n4;
        int n5;
        int n6;
        if (this.b == 3 && n2 <= (n6 = this.c) + (n4 = this.d) && (n5 = n2 + n3) >= n6 && this.e == object) {
            int n7 = n4 + n6;
            this.c = Math.min((int)n2, (int)n6);
            this.d = Math.max((int)n7, (int)n5) - this.c;
            return;
        }
        this.e();
        this.c = n2;
        this.d = n3;
        this.e = object;
        this.b = 3;
    }

    public void e() {
        int n2 = this.b;
        if (n2 == 0) {
            return;
        }
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    this.a.d(this.c, this.d, this.e);
                }
            } else {
                this.a.a(this.c, this.d);
            }
        } else {
            this.a.b(this.c, this.d);
        }
        this.e = null;
        this.b = 0;
    }
}

