/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f.b.i.l.f
 *  f.f.b.i.l.m
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package f.f.b.i.l;

import c.b.a.a.a;
import f.f.b.i.d;
import f.f.b.i.e;
import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.g;
import f.f.b.i.l.j;
import f.f.b.i.l.k;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
extends m {
    public ArrayList<m> k;
    public int l;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public c(f.f.b.i.d var1_1, int var2_2) {
        block10 : {
            block9 : {
                super(var1_1);
                this.k = new ArrayList();
                this.f = var2_2;
                var3_3 = this.b;
                while ((var4_4 = var3_3.l(this.f)) != null) {
                    var3_3 = var4_4;
                }
                this.b = var3_3;
                var5_5 = this.k;
                var6_6 = this.f;
                if (var6_6 != 0) break block9;
                var7_7 = this;
                ** GOTO lbl29
            }
            if (var6_6 != 1) break block10;
            var7_7 = this;
            ** GOTO lbl33
        }
        var7_7 = this;
        block1 : do {
            var8_9 = null;
            do {
                block11 : {
                    var5_5.add((Object)var8_9);
                    var3_3 = var3_3.k(var7_7.f);
                    if (var3_3 == null) break block1;
                    var5_5 = var7_7.k;
                    var16_8 = var7_7.f;
                    if (var16_8 != 0) break block11;
lbl29: // 2 sources:
                    var8_9 = var3_3.d;
                    continue;
                }
                if (var16_8 != 1) continue block1;
lbl33: // 2 sources:
                var8_9 = var3_3.e;
            } while (true);
            break;
        } while (true);
        for (m var14_11 : var7_7.k) {
            var15_12 = var7_7.f;
            if (var15_12 == 0) {
                var14_11.b.b = var7_7;
                continue;
            }
            if (var15_12 != 1) continue;
            var14_11.b.c = var7_7;
        }
        var11_13 = var7_7.f == 0 && ((e)var7_7.b.K).j0 != false;
        if (var11_13 && var7_7.k.size() > 1) {
            var13_14 = var7_7.k;
            var7_7.b = ((m)var13_14.get((int)(var13_14.size() - 1))).b;
        }
        var12_15 = var7_7.f == 0 ? var7_7.b.a0 : var7_7.b.b0;
        var7_7.l = var12_15;
    }

    public void a(d d2) {
        block58 : {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            d.a a2;
            int n8;
            int n9;
            int n10;
            boolean bl;
            int n11;
            block72 : {
                int n12;
                d.a a3;
                block71 : {
                    int n13;
                    block70 : {
                        int n14;
                        d.a a4;
                        block64 : {
                            float f2;
                            block57 : {
                                int n15;
                                block56 : {
                                    a4 = d.a.g;
                                    if (!this.h.j) break block58;
                                    if (!this.i.j) {
                                        return;
                                    }
                                    f.f.b.i.d d3 = this.b.K;
                                    bl = d3 != null && d3 instanceof e ? ((e)d3).j0 : false;
                                    n7 = this.i.g - this.h.g;
                                    n2 = this.k.size();
                                    n10 = 0;
                                    do {
                                        n8 = -1;
                                        n15 = 8;
                                        if (n10 >= n2) break;
                                        if (((m)this.k.get((int)n10)).b.X == n15) {
                                            ++n10;
                                            continue;
                                        }
                                        break block56;
                                        break;
                                    } while (true);
                                    n10 = n8;
                                }
                                for (int i2 = n5 = n2 - 1; i2 >= 0; --i2) {
                                    if (((m)this.k.get((int)i2)).b.X == n15) {
                                        continue;
                                    }
                                    n8 = i2;
                                    break;
                                }
                                for (int i3 = 0; i3 < 2; ++i3) {
                                    n11 = 0;
                                    int n16 = 0;
                                    int n17 = 0;
                                    f2 = 0.0f;
                                    for (int i4 = 0; i4 < n2; ++i4) {
                                        block59 : {
                                            int n18;
                                            m m2;
                                            boolean bl2;
                                            block61 : {
                                                block63 : {
                                                    block62 : {
                                                        block60 : {
                                                            m2 = (m)this.k.get(i4);
                                                            if (m2.b.X == n15) break block59;
                                                            ++n17;
                                                            if (i4 > 0 && i4 >= n10) {
                                                                n11 += m2.h.f;
                                                            }
                                                            n18 = m2.e.g;
                                                            bl2 = m2.d != a4;
                                                            if (!bl2) break block60;
                                                            if (this.f == 0 && !m2.b.d.e.j) {
                                                                return;
                                                            }
                                                            if (this.f == 1 && !m2.b.e.e.j) {
                                                                return;
                                                            }
                                                            break block61;
                                                        }
                                                        if (m2.a != 1 || i3 != 0) break block62;
                                                        n18 = m2.e.m;
                                                        ++n16;
                                                        break block63;
                                                    }
                                                    if (!m2.e.j) break block61;
                                                }
                                                bl2 = true;
                                            }
                                            if (!bl2) {
                                                ++n16;
                                                float f3 = m2.b.c0[this.f];
                                                if (f3 >= 0.0f) {
                                                    f2 += f3;
                                                }
                                            } else {
                                                n11 += n18;
                                            }
                                            if (i4 < n5 && i4 < n8) {
                                                n11 += -m2.i.f;
                                            }
                                        }
                                        n15 = 8;
                                    }
                                    if (n11 >= n7 && n16 != 0) {
                                        n15 = 8;
                                        continue;
                                    }
                                    n3 = n16;
                                    n12 = n17;
                                    break block57;
                                }
                                n3 = 0;
                                n12 = 0;
                                n11 = 0;
                                f2 = 0.0f;
                            }
                            n14 = this.h.g;
                            if (bl) {
                                n14 = this.i.g;
                            }
                            if (n11 > n7) {
                                int n19 = (int)(0.5f + (float)(n11 - n7) / 2.0f);
                                n14 = bl ? (n14 += n19) : (n14 -= n19);
                            }
                            if (n3 <= 0) break block64;
                            float f4 = n7 - n11;
                            int n20 = (int)(0.5f + f4 / (float)n3);
                            int n21 = 0;
                            for (int i5 = 0; i5 < n2; ++i5) {
                                int n22;
                                float f5;
                                int n23;
                                d.a a5;
                                int n24;
                                block69 : {
                                    block65 : {
                                        int n25;
                                        m m3;
                                        block67 : {
                                            int n26;
                                            block68 : {
                                                block66 : {
                                                    m3 = (m)this.k.get(i5);
                                                    n23 = n20;
                                                    f.f.b.i.d d4 = m3.b;
                                                    n24 = n11;
                                                    int n27 = d4.X;
                                                    n22 = n14;
                                                    if (n27 == 8 || m3.d != a4 || m3.e.j) break block65;
                                                    n25 = f2 > 0.0f ? (int)(0.5f + f4 * d4.c0[this.f] / f2) : n23;
                                                    if (this.f != 0) break block66;
                                                    f.f.b.i.d d5 = m3.b;
                                                    int n28 = d5.n;
                                                    int n29 = d5.m;
                                                    f5 = f4;
                                                    int n30 = m3.a;
                                                    a5 = a4;
                                                    int n31 = n30 == 1 ? Math.min((int)n25, (int)m3.e.m) : n25;
                                                    n26 = Math.max((int)n29, (int)n31);
                                                    if (n28 > 0) {
                                                        n26 = Math.min((int)n28, (int)n26);
                                                    }
                                                    if (n26 == n25) break block67;
                                                    break block68;
                                                }
                                                a5 = a4;
                                                f5 = f4;
                                                f.f.b.i.d d6 = m3.b;
                                                int n32 = d6.q;
                                                int n33 = d6.p;
                                                int n34 = m3.a == 1 ? Math.min((int)n25, (int)m3.e.m) : n25;
                                                n26 = Math.max((int)n33, (int)n34);
                                                if (n32 > 0) {
                                                    n26 = Math.min((int)n32, (int)n26);
                                                }
                                                if (n26 == n25) break block67;
                                            }
                                            ++n21;
                                            n25 = n26;
                                        }
                                        m3.e.c(n25);
                                        break block69;
                                    }
                                    a5 = a4;
                                    f5 = f4;
                                }
                                n20 = n23;
                                n11 = n24;
                                n14 = n22;
                                f4 = f5;
                                a4 = a5;
                            }
                            a3 = a4;
                            n9 = n14;
                            int n35 = n11;
                            if (n21 > 0) {
                                n3 -= n21;
                                int n36 = 0;
                                for (int i6 = 0; i6 < n2; ++i6) {
                                    m m4 = (m)this.k.get(i6);
                                    if (m4.b.X == 8) continue;
                                    if (i6 > 0 && i6 >= n10) {
                                        n36 += m4.h.f;
                                    }
                                    n36 += m4.e.g;
                                    if (i6 >= n5 || i6 >= n8) continue;
                                    n36 += -m4.i.f;
                                }
                                n11 = n36;
                            } else {
                                n11 = n35;
                            }
                            int n37 = this.l;
                            n13 = 2;
                            if (n37 == n13 && n21 == 0) {
                                this.l = 0;
                            }
                            break block70;
                        }
                        a3 = a4;
                        n9 = n14;
                        n13 = 2;
                    }
                    if (n11 > n7) {
                        this.l = n13;
                    }
                    if (n12 > 0 && n3 == 0 && n10 == n8) {
                        this.l = n13;
                    }
                    if ((n4 = this.l) != 1) break block71;
                    int n38 = n12 > 1 ? (n7 - n11) / (n12 - 1) : (n12 == 1 ? (n7 - n11) / 2 : 0);
                    if (n3 > 0) {
                        n38 = 0;
                    }
                    int n39 = n9;
                    for (int i7 = 0; i7 < n2; ++i7) {
                        d.a a6;
                        int n40 = bl ? n2 - (i7 + 1) : i7;
                        m m5 = (m)this.k.get(n40);
                        if (m5.b.X == 8) {
                            m5.h.c(n39);
                            m5.i.c(n39);
                            a6 = a3;
                        } else {
                            if (i7 > 0) {
                                n39 = bl ? (n39 -= n38) : (n39 += n38);
                            }
                            if (i7 > 0 && i7 >= n10) {
                                int n41 = m5.h.f;
                                n39 = bl ? (n39 -= n41) : (n39 += n41);
                            }
                            f f6 = bl ? m5.i : m5.h;
                            f6.c(n39);
                            g g2 = m5.e;
                            int n42 = g2.g;
                            d.a a7 = m5.d;
                            a6 = a3;
                            if (a7 == a6 && m5.a == 1) {
                                n42 = g2.m;
                            }
                            n39 = bl ? (n39 -= n42) : (n39 += n42);
                            f f7 = bl ? m5.h : m5.i;
                            f7.c(n39);
                            m5.g = true;
                            if (i7 < n5 && i7 < n8) {
                                int n43 = -m5.i.f;
                                n39 = bl ? (n39 -= n43) : (n39 += n43);
                            }
                        }
                        a3 = a6;
                    }
                    break block58;
                }
                a2 = a3;
                if (n4 != 0) break block72;
                int n44 = (n7 - n11) / (n12 + 1);
                if (n3 > 0) {
                    n44 = 0;
                }
                int n45 = n9;
                for (int i8 = 0; i8 < n2; ++i8) {
                    int n46 = bl ? n2 - (i8 + 1) : i8;
                    m m6 = (m)this.k.get(n46);
                    if (m6.b.X == 8) {
                        m6.h.c(n45);
                        m6.i.c(n45);
                        continue;
                    }
                    int n47 = bl ? n45 - n44 : n45 + n44;
                    if (i8 > 0 && i8 >= n10) {
                        int n48 = m6.h.f;
                        n47 = bl ? (n47 -= n48) : (n47 += n48);
                    }
                    f f8 = bl ? m6.i : m6.h;
                    f8.c(n47);
                    g g3 = m6.e;
                    int n49 = g3.g;
                    if (m6.d == a2 && m6.a == 1) {
                        n49 = Math.min((int)n49, (int)g3.m);
                    }
                    n45 = bl ? n47 - n49 : n47 + n49;
                    f f9 = bl ? m6.h : m6.i;
                    f9.c(n45);
                    if (i8 >= n5 || i8 >= n8) continue;
                    int n50 = -m6.i.f;
                    if (bl) {
                        n45 -= n50;
                        continue;
                    }
                    n45 += n50;
                }
                break block58;
            }
            if (n4 != 2) break block58;
            float f10 = this.f == 0 ? this.b.U : this.b.V;
            if (bl) {
                f10 = 1.0f - f10;
            }
            if ((n6 = (int)(0.5f + f10 * (float)(n7 - n11))) < 0 || n3 > 0) {
                n6 = 0;
            }
            int n51 = bl ? n9 - n6 : n9 + n6;
            for (int i9 = 0; i9 < n2; ++i9) {
                int n52 = bl ? n2 - (i9 + 1) : i9;
                m m7 = (m)this.k.get(n52);
                if (m7.b.X == 8) {
                    m7.h.c(n51);
                    m7.i.c(n51);
                    continue;
                }
                if (i9 > 0 && i9 >= n10) {
                    int n53 = m7.h.f;
                    n51 = bl ? (n51 -= n53) : (n51 += n53);
                }
                f f11 = bl ? m7.i : m7.h;
                f11.c(n51);
                g g4 = m7.e;
                int n54 = g4.g;
                if (m7.d == a2 && m7.a == 1) {
                    n54 = g4.m;
                }
                n51 = bl ? (n51 -= n54) : (n51 += n54);
                f f12 = bl ? m7.h : m7.i;
                f12.c(n51);
                if (i9 >= n5 || i9 >= n8) continue;
                int n55 = -m7.i.f;
                if (bl) {
                    n51 -= n55;
                    continue;
                }
                n51 += n55;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d() {
        block12 : {
            int n2;
            f f2;
            block13 : {
                f.f.b.i.d d2;
                f.f.b.i.d d3;
                block11 : {
                    Iterator iterator = this.k.iterator();
                    while (iterator.hasNext()) {
                        ((m)iterator.next()).d();
                    }
                    int n3 = this.k.size();
                    if (n3 < 1) {
                        return;
                    }
                    d2 = ((m)this.k.get((int)0)).b;
                    d3 = ((m)this.k.get((int)(n3 - 1))).b;
                    if (this.f != 0) break block11;
                    f.f.b.i.c c2 = d2.y;
                    f.f.b.i.c c3 = d3.A;
                    f f3 = this.i(c2, 0);
                    int n4 = c2.b();
                    f.f.b.i.d d4 = this.m();
                    if (d4 != null) {
                        n4 = d4.y.b();
                    }
                    if (f3 != null) {
                        f f4 = this.h;
                        f4.l.add((Object)f3);
                        f4.f = n4;
                        f3.k.add((Object)f4);
                    }
                    f2 = this.i(c3, 0);
                    n2 = c3.b();
                    f.f.b.i.d d5 = this.n();
                    if (d5 != null) {
                        n2 = d5.A.b();
                    }
                    if (f2 == null) break block12;
                    break block13;
                }
                f.f.b.i.c c4 = d2.z;
                f.f.b.i.c c5 = d3.B;
                f f5 = this.i(c4, 1);
                int n5 = c4.b();
                f.f.b.i.d d6 = this.m();
                if (d6 != null) {
                    n5 = d6.z.b();
                }
                if (f5 != null) {
                    f f6 = this.h;
                    f6.l.add((Object)f5);
                    f6.f = n5;
                    f5.k.add((Object)f6);
                }
                f2 = this.i(c5, 1);
                n2 = c5.b();
                f.f.b.i.d d7 = this.n();
                if (d7 != null) {
                    n2 = d7.B.b();
                }
                if (f2 == null) break block12;
            }
            f f7 = this.i;
            int n6 = -n2;
            f7.l.add((Object)f2);
            f7.f = n6;
            f2.k.add((Object)f7);
        }
        this.h.a = this;
        this.i.a = this;
    }

    public void e() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            ((m)this.k.get(i2)).e();
        }
    }

    public void f() {
        this.c = null;
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            ((m)iterator.next()).f();
        }
    }

    public long j() {
        int n2 = this.k.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            m m2 = (m)this.k.get(i2);
            l2 = l2 + (long)m2.h.f + m2.j() + (long)m2.i.f;
        }
        return l2;
    }

    public boolean k() {
        int n2 = this.k.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((m)this.k.get(i2)).k()) continue;
            return false;
        }
        return true;
    }

    public final f.f.b.i.d m() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            f.f.b.i.d d2 = ((m)this.k.get((int)i2)).b;
            if (d2.X == 8) continue;
            return d2;
        }
        return null;
    }

    public final f.f.b.i.d n() {
        for (int i2 = -1 + this.k.size(); i2 >= 0; --i2) {
            f.f.b.i.d d2 = ((m)this.k.get((int)i2)).b;
            if (d2.X == 8) continue;
            return d2;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("ChainRun ");
        String string = this.f == 0 ? "horizontal : " : "vertical : ";
        stringBuilder.append(string);
        String string2 = stringBuilder.toString();
        for (m m2 : this.k) {
            String string3 = a.j(string2, "<");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append((Object)m2);
            string2 = a.j(stringBuilder2.toString(), "> ");
        }
        return string2;
    }
}

