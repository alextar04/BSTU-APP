/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package f.f.b;

import f.f.b.c;
import f.f.b.d;
import f.f.b.g;
import java.util.ArrayList;

public class b
implements d.a {
    public g a = null;
    public float b = 0.0f;
    public boolean c;
    public ArrayList<g> d = new ArrayList();
    public a e;
    public boolean f = false;

    public b() {
    }

    public b(c c2) {
        this.e = new f.f.b.a(this, c2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(g var1_1) {
        var2_2 = var1_1.e;
        if (var2_2 == 1) ** GOTO lbl-1000
        if (var2_2 == 2) {
            var3_3 = 1000.0f;
        } else if (var2_2 == 3) {
            var3_3 = 1000000.0f;
        } else if (var2_2 == 4) {
            var3_3 = 1.0E9f;
        } else if (var2_2 == 5) {
            var3_3 = 1.0E12f;
        } else lbl-1000: // 2 sources:
        {
            var3_3 = 1.0f;
        }
        this.e.c(var1_1, var3_3);
    }

    @Override
    public g b(d d2, boolean[] arrbl) {
        return this.i(arrbl, null);
    }

    public b c(d d2, int n2) {
        this.e.c(d2.k(n2, "ep"), 1.0f);
        this.e.c(d2.k(n2, "em"), -1.0f);
        return this;
    }

    @Override
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(g g2, g g3, g g4, g g5, float f2) {
        this.e.c(g2, -1.0f);
        this.e.c(g3, 1.0f);
        this.e.c(g4, f2);
        this.e.c(g5, -f2);
        return this;
    }

    public b e(g g2, g g3, g g4, int n2) {
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            this.b = n2;
        }
        if (!bl) {
            this.e.c(g2, -1.0f);
            this.e.c(g3, 1.0f);
            this.e.c(g4, 1.0f);
            return this;
        }
        this.e.c(g2, 1.0f);
        this.e.c(g3, -1.0f);
        this.e.c(g4, -1.0f);
        return this;
    }

    public b f(g g2, g g3, g g4, int n2) {
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            this.b = n2;
        }
        if (!bl) {
            this.e.c(g2, -1.0f);
            this.e.c(g3, 1.0f);
            this.e.c(g4, -1.0f);
            return this;
        }
        this.e.c(g2, 1.0f);
        this.e.c(g3, -1.0f);
        this.e.c(g4, 1.0f);
        return this;
    }

    public b g(g g2, g g3, g g4, g g5, float f2) {
        this.e.c(g4, 0.5f);
        this.e.c(g5, 0.5f);
        this.e.c(g2, -0.5f);
        this.e.c(g3, -0.5f);
        this.b = -f2;
        return this;
    }

    public final boolean h(g g2) {
        return g2.m <= 1;
    }

    public final g i(boolean[] arrbl, g g2) {
        int n2 = this.e.k();
        g g3 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            g.a a2;
            float f3 = this.e.a(i2);
            if (!(f3 < 0.0f)) continue;
            g g4 = this.e.f(i2);
            if (arrbl != null && arrbl[g4.c] || g4 == g2 || (a2 = g4.j) != g.a.g && a2 != g.a.h || !(f3 < f2)) continue;
            f2 = f3;
            g3 = g4;
        }
        return g3;
    }

    public void j(g g2) {
        g g3 = this.a;
        if (g3 != null) {
            this.e.c(g3, -1.0f);
            this.a = null;
        }
        float f2 = -1.0f * this.e.d(g2, true);
        this.a = g2;
        if (f2 == 1.0f) {
            return;
        }
        this.b /= f2;
        this.e.i(f2);
    }

    public void k(g g2, boolean bl) {
        if (!g2.g) {
            return;
        }
        float f2 = this.e.g(g2);
        this.b += f2 * g2.f;
        this.e.d(g2, bl);
        if (bl) {
            g2.b(this);
        }
    }

    public void l(b b2, boolean bl) {
        float f2 = this.e.b(b2, bl);
        this.b += f2 * b2.b;
        if (bl) {
            b2.a.b(this);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String toString() {
        if (this.a == null) {
            var3_1 = "0";
        } else {
            var1_2 = c.b.a.a.a.c("");
            var1_2.append((Object)this.a);
            var3_1 = var1_2.toString();
        }
        var4_3 = c.b.a.a.a.j(var3_1, " = ");
        var5_4 = this.b FCMPL 0.0f;
        var6_5 = 0;
        if (var5_4 != false) {
            var20_6 = c.b.a.a.a.c(var4_3);
            var20_6.append(this.b);
            var4_3 = var20_6.toString();
            var7_7 = true;
        } else {
            var7_7 = false;
        }
        var8_8 = this.e.k();
        do {
            block10 : {
                block12 : {
                    block11 : {
                        if (var6_5 >= var8_8) {
                            if (var7_7 != false) return var4_3;
                            return c.b.a.a.a.j(var4_3, "0.0");
                        }
                        var9_9 = this.e.f(var6_5);
                        if (var9_9 == null || (var11_11 = (var10_10 = this.e.a(var6_5) FCMPL 0.0f)) == false) break block10;
                        var12_12 = var9_9.toString();
                        if (var7_7) break block11;
                        if (!(var10_10 < 0.0f)) break block12;
                        var13_13 = c.b.a.a.a.c(var4_3);
                        var14_14 = "- ";
                        ** GOTO lbl37
                    }
                    var13_13 = c.b.a.a.a.c(var4_3);
                    if (var11_11 > 0) {
                        var13_13.append(" + ");
                        var4_3 = var13_13.toString();
                    } else {
                        var14_14 = " - ";
lbl37: // 2 sources:
                        var13_13.append(var14_14);
                        var4_3 = var13_13.toString();
                        var10_10 *= -1.0f;
                    }
                }
                if (var10_10 == 1.0f) {
                    var16_15 = new StringBuilder();
                } else {
                    var16_15 = new StringBuilder();
                    var16_15.append(var4_3);
                    var16_15.append(var10_10);
                    var4_3 = " ";
                }
                var4_3 = c.b.a.a.a.l(var16_15, var4_3, var12_12);
                var7_7 = true;
            }
            ++var6_5;
        } while (true);
    }

}

