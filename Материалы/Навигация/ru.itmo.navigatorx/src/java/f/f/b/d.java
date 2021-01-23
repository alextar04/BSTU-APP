/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.b
 *  f.f.b.d$b
 *  f.f.b.f
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 */
package f.f.b;

import f.f.b.b;
import f.f.b.c;
import f.f.b.d;
import f.f.b.e;
import f.f.b.f;
import f.f.b.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Exception performing whole class analysis.
 */
public class d {
    public static int q = 1000;
    public static boolean r = true;
    public static long s;
    public static long t;
    public int a;
    public HashMap<String, g> b;
    public a c;
    public int d;
    public int e;
    public f.f.b.b[] f;
    public boolean g;
    public boolean h;
    public boolean[] i;
    public int j;
    public int k;
    public int l;
    public final c m;
    public g[] n;
    public int o;
    public a p;

    public d() {
        c c2;
        this.a = 0;
        this.b = null;
        this.d = 32;
        this.e = 32;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = new boolean[32];
        this.j = 1;
        this.k = 0;
        this.l = 32;
        this.n = new g[q];
        this.o = 0;
        this.f = new f.f.b.b[32];
        this.s();
        this.m = c2 = new c();
        this.c = new f(c2);
        Object object = r ? new /* Unavailable Anonymous Inner Class!! */ : new f.f.b.b(this.m);
        this.p = object;
    }

    public final g a(g.a a2, String string) {
        g g2 = this.m.c.a();
        if (g2 == null) {
            g2 = new g(a2);
        } else {
            g2.c();
        }
        g2.j = a2;
        int n2 = this.o;
        int n3 = q;
        if (n2 >= n3) {
            int n4;
            q = n4 = n3 * 2;
            this.n = (g[])Arrays.copyOf((Object[])this.n, (int)n4);
        }
        g[] arrg = this.n;
        int n5 = this.o;
        this.o = n5 + 1;
        arrg[n5] = g2;
        return g2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b(g var1_1, g var2_2, int var3_3, float var4_4, g var5_5, g var6_6, int var7_7, int var8_8) {
        block5 : {
            block7 : {
                block6 : {
                    block4 : {
                        var9_9 = this.m();
                        if (var2_2 != var5_5) break block4;
                        var9_9.e.c(var1_1, 1.0f);
                        var9_9.e.c(var6_6, 1.0f);
                        var9_9.e.c(var2_2, -2.0f);
                        break block5;
                    }
                    if (var4_4 != 0.5f) break block6;
                    var9_9.e.c(var1_1, 1.0f);
                    var9_9.e.c(var2_2, -1.0f);
                    var9_9.e.c(var5_5, -1.0f);
                    var9_9.e.c(var6_6, 1.0f);
                    if (var3_3 <= 0 && var7_7 <= 0) break block5;
                    var13_10 = var7_7 + -var3_3;
                    ** GOTO lbl27
                }
                if (!(var4_4 <= 0.0f)) break block7;
                var9_9.e.c(var1_1, -1.0f);
                var9_9.e.c(var2_2, 1.0f);
                var14_11 = var3_3;
                ** GOTO lbl28
            }
            if (var4_4 >= 1.0f) {
                var9_9.e.c(var6_6, -1.0f);
                var9_9.e.c(var5_5, 1.0f);
                var13_10 = -var7_7;
lbl27: // 2 sources:
                var14_11 = var13_10;
lbl28: // 2 sources:
                var9_9.b = var14_11;
            } else {
                var10_12 = var9_9.e;
                var11_13 = 1.0f - var4_4;
                var10_12.c(var1_1, var11_13 * 1.0f);
                var9_9.e.c(var2_2, var11_13 * -1.0f);
                var9_9.e.c(var5_5, -1.0f * var4_4);
                var9_9.e.c(var6_6, 1.0f * var4_4);
                if (var3_3 > 0 || var7_7 > 0) {
                    var9_9.b = var11_13 * (float)(-var3_3) + var4_4 * (float)var7_7;
                }
            }
        }
        if (var8_8 != 8) {
            var9_9.c(this, var8_8);
        }
        this.c(var9_9);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void c(f.f.b.b b2) {
        int n2;
        g.a a2 = g.a.e;
        int n3 = this.k;
        int n4 = 1;
        if (n3 + n4 >= this.l || n4 + this.j >= this.e) {
            this.p();
        }
        if (!b2.f) {
            int n5;
            int n6;
            if (this.f.length != 0) {
                int n7 = 0;
                while (n7 == 0) {
                    int n8 = b2.e.k();
                    for (int i2 = 0; i2 < n8; ++i2) {
                        g g2 = b2.e.f(i2);
                        if (g2.d == -1 && !g2.g) continue;
                        b2.d.add((Object)g2);
                    }
                    if (b2.d.size() > 0) {
                        for (g g3 : b2.d) {
                            if (g3.g) {
                                b2.k(g3, (boolean)n4);
                                continue;
                            }
                            b2.l(this.f[g3.d], (boolean)n4);
                        }
                        b2.d.clear();
                        continue;
                    }
                    n7 = n4;
                }
            }
            int n9 = b2.a == null && b2.b == 0.0f && b2.e.k() == 0 ? n4 : 0;
            if (n9 != 0) {
                return;
            }
            float f2 = b2.b;
            if (f2 < 0.0f) {
                b2.b = f2 * -1.0f;
                b2.e.j();
            }
            int n10 = b2.e.k();
            float f3 = 0.0f;
            float f4 = 0.0f;
            g g4 = null;
            g g5 = null;
            int n11 = 0;
            int n12 = 0;
            for (int i3 = 0; i3 < n10; ++i3) {
                float f5 = b2.e.a(i3);
                g g6 = b2.e.f(i3);
                if (g6.j == a2) {
                    if (g4 == null || f3 > f5) {
                        n11 = b2.h(g6);
                    } else {
                        if (n11 != 0 || !b2.h(g6)) continue;
                        n11 = n4;
                    }
                    f3 = f5;
                    g4 = g6;
                    continue;
                }
                if (g4 != null || !(f5 < 0.0f)) continue;
                if (g5 == null || f4 > f5) {
                    n12 = b2.h(g6);
                } else {
                    if (n12 != 0 || !b2.h(g6)) continue;
                    n12 = n4;
                }
                f4 = f5;
                g5 = g6;
            }
            if (g4 == null) {
                g4 = g5;
            }
            if (g4 == null) {
                n6 = n4;
            } else {
                b2.j(g4);
                n6 = 0;
            }
            if (b2.e.k() == 0) {
                b2.f = n4;
            }
            if (n6 != 0) {
                int n13;
                if (n4 + this.j >= this.e) {
                    this.p();
                }
                g g7 = this.a(g.a.g, null);
                this.a = n13 = n4 + this.a;
                this.j = n4 + this.j;
                g7.c = n13;
                this.m.d[n13] = g7;
                b2.a = g7;
                this.i(b2);
                f.f.b.b b3 = (f.f.b.b)this.p;
                if (b3 == null) throw null;
                b3.a = null;
                b3.e.clear();
                for (int i4 = 0; i4 < b2.e.k(); ++i4) {
                    g g8 = b2.e.f(i4);
                    float f6 = b2.e.a(i4);
                    b3.e.e(g8, f6, (boolean)n4);
                }
                this.r(this.p);
                if (g7.d == -1) {
                    g g9;
                    if (b2.a == g7 && (g9 = b2.i(null, g7)) != null) {
                        b2.j(g9);
                    }
                    if (!b2.f) {
                        b2.a.e(b2);
                    }
                    this.k -= n4;
                }
                n5 = n4;
            } else {
                n5 = 0;
            }
            g g10 = b2.a;
            if (g10 == null) return;
            if (g10.j != a2) {
                if (b2.b < 0.0f) return;
            }
            if (n4 == 0) {
                return;
            }
            n2 = n5;
        } else {
            n2 = 0;
        }
        if (n2 != 0) return;
        this.i(b2);
    }

    public f.f.b.b d(g g2, g g3, int n2, int n3) {
        if (n3 == 8 && g3.g && g2.d == -1) {
            g2.d(this, g3.f + (float)n2);
            return null;
        }
        f.f.b.b b2 = this.m();
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            b2.b = n2;
        }
        if (!bl) {
            b2.e.c(g2, -1.0f);
            b2.e.c(g3, 1.0f);
        } else {
            b2.e.c(g2, 1.0f);
            b2.e.c(g3, -1.0f);
        }
        if (n3 != 8) {
            b2.c(this, n3);
        }
        this.c(b2);
        return b2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void e(g g2, int n2) {
        f.f.b.b b2;
        block9 : {
            float f2;
            block6 : {
                float f3;
                b.a a2;
                block8 : {
                    block7 : {
                        int n3 = g2.d;
                        if (n3 == -1) {
                            g2.d(this, n2);
                            return;
                        }
                        if (n3 == -1) break block6;
                        f.f.b.b b3 = this.f[n3];
                        if (b3.f) break block7;
                        if (b3.e.k() != 0) break block8;
                        b3.f = true;
                    }
                    b3.b = n2;
                    return;
                }
                b2 = this.m();
                if (n2 < 0) {
                    b2.b = n2 * -1;
                    a2 = b2.e;
                    f3 = 1.0f;
                } else {
                    b2.b = n2;
                    a2 = b2.e;
                    f3 = -1.0f;
                }
                a2.c(g2, f3);
                break block9;
            }
            b2 = this.m();
            b2.a = g2;
            g2.f = f2 = (float)n2;
            b2.b = f2;
            b2.f = true;
        }
        this.c(b2);
    }

    public void f(g g2, g g3, int n2, int n3) {
        f.f.b.b b2 = this.m();
        g g4 = this.n();
        g4.e = 0;
        b2.e(g2, g3, g4, n2);
        if (n3 != 8) {
            int n4 = (int)(-1.0f * b2.e.g(g4));
            g g5 = this.k(n3, null);
            b2.e.c(g5, n4);
        }
        this.c(b2);
    }

    public void g(g g2, g g3, int n2, int n3) {
        f.f.b.b b2 = this.m();
        g g4 = this.n();
        g4.e = 0;
        b2.f(g2, g3, g4, n2);
        if (n3 != 8) {
            int n4 = (int)(-1.0f * b2.e.g(g4));
            g g5 = this.k(n3, null);
            b2.e.c(g5, n4);
        }
        this.c(b2);
    }

    public void h(g g2, g g3, g g4, g g5, float f2, int n2) {
        f.f.b.b b2 = this.m();
        b2.d(g2, g3, g4, g5, f2);
        if (n2 != 8) {
            b2.c(this, n2);
        }
        this.c(b2);
    }

    public final void i(f.f.b.b b2) {
        block3 : {
            f.f.b.b b3;
            e<f.f.b.b> e2;
            block4 : {
                block2 : {
                    if (!r) break block2;
                    f.f.b.b[] arrb = this.f;
                    int n2 = this.k;
                    if (arrb[n2] == null) break block3;
                    e2 = this.m.a;
                    b3 = arrb[n2];
                    break block4;
                }
                f.f.b.b[] arrb = this.f;
                int n3 = this.k;
                if (arrb[n3] == null) break block3;
                e2 = this.m.b;
                b3 = arrb[n3];
            }
            e2.b(b3);
        }
        f.f.b.b[] arrb = this.f;
        int n4 = this.k;
        arrb[n4] = b2;
        g g2 = b2.a;
        g2.d = n4;
        this.k = n4 + 1;
        g2.e(b2);
    }

    public final void j() {
        for (int i2 = 0; i2 < this.k; ++i2) {
            f.f.b.b b2 = this.f[i2];
            b2.a.f = b2.b;
        }
    }

    public g k(int n2, String string) {
        int n3;
        if (1 + this.j >= this.e) {
            this.p();
        }
        g g2 = this.a(g.a.h, string);
        this.a = n3 = 1 + this.a;
        this.j = 1 + this.j;
        g2.c = n3;
        g2.e = n2;
        this.m.d[n3] = g2;
        this.c.a(g2);
        return g2;
    }

    public g l(Object object) {
        if (object == null) {
            return null;
        }
        if (1 + this.j >= this.e) {
            this.p();
        }
        boolean bl = object instanceof f.f.b.i.c;
        g g2 = null;
        if (bl) {
            int n2;
            f.f.b.i.c c2 = (f.f.b.i.c)object;
            g2 = c2.g;
            if (g2 == null) {
                c2.f();
                g2 = c2.g;
            }
            if ((n2 = g2.c) == -1 || n2 > this.a || this.m.d[n2] == null) {
                int n3;
                if (g2.c != -1) {
                    g2.c();
                }
                this.a = n3 = 1 + this.a;
                this.j = 1 + this.j;
                g2.c = n3;
                g2.j = g.a.e;
                this.m.d[n3] = g2;
            }
        }
        return g2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public f.f.b.b m() {
        block3 : {
            block2 : {
                if (!d.r) break block2;
                var1_1 = this.m.a.a();
                if (var1_1 != null) ** GOTO lbl-1000
                var1_1 = new /* Unavailable Anonymous Inner Class!! */;
                d.t = 1L + d.t;
                break block3;
            }
            var1_1 = this.m.b.a();
            if (var1_1 == null) {
                var1_1 = new f.f.b.b(this.m);
                d.s = 1L + d.s;
            } else lbl-1000: // 2 sources:
            {
                var1_1.a = null;
                var1_1.e.clear();
                var1_1.b = 0.0f;
                var1_1.f = false;
            }
        }
        g.n = 1 + g.n;
        return var1_1;
    }

    public g n() {
        int n2;
        if (1 + this.j >= this.e) {
            this.p();
        }
        g g2 = this.a(g.a.g, null);
        this.a = n2 = 1 + this.a;
        this.j = 1 + this.j;
        g2.c = n2;
        this.m.d[n2] = g2;
        return g2;
    }

    public int o(Object object) {
        g g2 = ((f.f.b.i.c)object).g;
        if (g2 != null) {
            return (int)(0.5f + g2.f);
        }
        return 0;
    }

    public final void p() {
        int n2;
        this.d = n2 = 2 * this.d;
        this.f = (f.f.b.b[])Arrays.copyOf((Object[])this.f, (int)n2);
        c c2 = this.m;
        c2.d = (g[])Arrays.copyOf((Object[])c2.d, (int)this.d);
        int n3 = this.d;
        this.i = new boolean[n3];
        this.e = n3;
        this.l = n3;
    }

    public void q(a a2) {
        int n2;
        g.a a3;
        int n3;
        block11 : {
            a3 = g.a.e;
            int n4 = 0;
            do {
                int n5 = this.k;
                n3 = 1;
                if (n4 >= n5) break;
                f.f.b.b[] arrb = this.f;
                if (arrb[n4].a.j != a3 && arrb[n4].b < 0.0f) {
                    n2 = n3;
                    break block11;
                }
                ++n4;
            } while (true);
            n2 = 0;
        }
        if (n2 != 0) {
            boolean bl = false;
            int n6 = 0;
            while (!bl) {
                int n7;
                n6 += n3;
                float f2 = Float.MAX_VALUE;
                int n8 = n7 = -1;
                int n9 = 0;
                for (int i2 = 0; i2 < this.k; ++i2) {
                    f.f.b.b b2 = this.f[i2];
                    if (b2.a.j != a3 && !b2.f && b2.b < 0.0f) {
                        for (int i3 = n3; i3 < this.j; ++i3) {
                            g g2 = this.m.d[i3];
                            float f3 = b2.e.g(g2);
                            if (f3 <= 0.0f) continue;
                            for (int i4 = 0; i4 < 9; ++i4) {
                                float f4 = g2.h[i4] / f3;
                                if (!(f4 < f2 && i4 == n9) && i4 <= n9) continue;
                                n9 = i4;
                                f2 = f4;
                                n7 = i2;
                                n8 = i3;
                            }
                        }
                    }
                    n3 = 1;
                }
                if (n7 != -1) {
                    f.f.b.b b3 = this.f[n7];
                    b3.a.d = -1;
                    b3.j(this.m.d[n8]);
                    g g3 = b3.a;
                    g3.d = n7;
                    g3.e(b3);
                } else {
                    bl = true;
                }
                if (n6 > this.j / 2) {
                    bl = true;
                }
                n3 = 1;
            }
        }
        this.r(a2);
        this.j();
    }

    public final int r(a a2) {
        for (int i2 = 0; i2 < this.j; ++i2) {
            this.i[i2] = false;
        }
        boolean bl = false;
        int n2 = 0;
        while (!bl) {
            g g2;
            if (++n2 >= 2 * this.j) {
                return n2;
            }
            g g3 = ((f.f.b.b)a2).a;
            if (g3 != null) {
                this.i[g3.c] = true;
            }
            if ((g2 = a2.b(this, this.i)) != null) {
                boolean[] arrbl = this.i;
                int n3 = g2.c;
                if (arrbl[n3]) {
                    return n2;
                }
                arrbl[n3] = true;
            }
            if (g2 != null) {
                float f2 = Float.MAX_VALUE;
                int n4 = -1;
                for (int i3 = 0; i3 < this.k; ++i3) {
                    float f3;
                    float f4;
                    f.f.b.b b2 = this.f[i3];
                    if (b2.a.j == g.a.e || b2.f || !b2.e.h(g2) || !((f4 = b2.e.g(g2)) < 0.0f) || !((f3 = -b2.b / f4) < f2)) continue;
                    n4 = i3;
                    f2 = f3;
                }
                if (n4 <= -1) continue;
                f.f.b.b b3 = this.f[n4];
                b3.a.d = -1;
                b3.j(g2);
                g g4 = b3.a;
                g4.d = n4;
                g4.e(b3);
                continue;
            }
            bl = true;
        }
        return n2;
    }

    public final void s() {
        int n2;
        boolean bl = r;
        if (bl) {
            f.f.b.b[] arrb;
            for (n2 = 0; n2 < (arrb = this.f).length; ++n2) {
                f.f.b.b b2 = arrb[n2];
                if (b2 != null) {
                    this.m.a.b(b2);
                }
                this.f[n2] = null;
            }
        } else {
            f.f.b.b[] arrb;
            while (n2 < (arrb = this.f).length) {
                f.f.b.b b3 = arrb[n2];
                if (b3 != null) {
                    this.m.b.b(b3);
                }
                this.f[n2] = null;
                ++n2;
            }
        }
    }

    public void t() {
        c c2;
        int n2 = 0;
        do {
            c2 = this.m;
            g[] arrg = c2.d;
            if (n2 >= arrg.length) break;
            g g2 = arrg[n2];
            if (g2 != null) {
                g2.c();
            }
            ++n2;
        } while (true);
        e<g> e2 = c2.c;
        g[] arrg = this.n;
        int n3 = this.o;
        if (e2 != null) {
            if (n3 > arrg.length) {
                n3 = arrg.length;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                g g3 = arrg[i2];
                int n4 = e2.b;
                Object[] arrobject = e2.a;
                if (n4 >= arrobject.length) continue;
                arrobject[n4] = g3;
                e2.b = n4 + 1;
            }
            this.o = 0;
            Arrays.fill((Object[])this.m.d, null);
            HashMap<String, g> hashMap = this.b;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.a = 0;
            this.c.clear();
            this.j = 1;
            for (int i3 = 0; i3 < this.k; ++i3) {
                this.f[i3].c = false;
            }
            this.s();
            this.k = 0;
            Object object = r ? new /* Unavailable Anonymous Inner Class!! */ : new f.f.b.b(this.m);
            this.p = object;
            return;
        }
        throw null;
    }

    public static interface a {
        public void a(g var1);

        public g b(d var1, boolean[] var2);

        public void clear();
    }

}

