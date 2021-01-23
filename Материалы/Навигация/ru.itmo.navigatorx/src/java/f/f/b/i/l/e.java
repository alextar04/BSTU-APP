/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$b
 *  f.f.b.i.e
 *  f.f.b.i.f
 *  f.f.b.i.h
 *  f.f.b.i.k
 *  f.f.b.i.l.c
 *  f.f.b.i.l.f
 *  f.f.b.i.l.g
 *  f.f.b.i.l.h
 *  f.f.b.i.l.i
 *  f.f.b.i.l.j
 *  f.f.b.i.l.l
 *  f.f.b.i.l.m
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package f.f.b.i.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.b.i.c;
import f.f.b.i.d;
import f.f.b.i.f;
import f.f.b.i.h;
import f.f.b.i.k;
import f.f.b.i.l.b;
import f.f.b.i.l.g;
import f.f.b.i.l.i;
import f.f.b.i.l.j;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class e {
    public f.f.b.i.e a;
    public boolean b = true;
    public boolean c = true;
    public f.f.b.i.e d;
    public ArrayList<m> e = new ArrayList();
    public b.b f;
    public b.a g;
    public ArrayList<f.f.b.i.l.k> h;

    public e(f.f.b.i.e e2) {
        new ArrayList();
        this.f = null;
        this.g = new b.a();
        this.h = new ArrayList();
        this.a = e2;
        this.d = e2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void a(f.f.b.i.l.f f2, int n2, int n3, f.f.b.i.l.f f3, ArrayList<f.f.b.i.l.k> arrayList, f.f.b.i.l.k k2) {
        m m2 = f2.d;
        if (m2.c != null) return;
        f.f.b.i.e e2 = this.a;
        if (m2 == e2.d) return;
        if (m2 == e2.e) {
            return;
        }
        if (k2 == null) {
            k2 = new f.f.b.i.l.k(m2, n3);
            arrayList.add((Object)k2);
        }
        m2.c = k2;
        k2.b.add((Object)m2);
        for (f.f.b.i.l.d d2 : m2.h.k) {
            if (!(d2 instanceof f.f.b.i.l.f)) continue;
            this.a((f.f.b.i.l.f)d2, n2, 0, f3, arrayList, k2);
        }
        for (f.f.b.i.l.d d3 : m2.i.k) {
            if (!(d3 instanceof f.f.b.i.l.f)) continue;
            this.a((f.f.b.i.l.f)d3, n2, 1, f3, arrayList, k2);
        }
        if (n2 == 1 && m2 instanceof l) {
            for (f.f.b.i.l.d d4 : ((l)m2).k.k) {
                if (!(d4 instanceof f.f.b.i.l.f)) continue;
                this.a((f.f.b.i.l.f)d4, n2, 2, f3, arrayList, k2);
            }
        }
        Iterator iterator = m2.h.l.iterator();
        while (iterator.hasNext()) {
            this.a((f.f.b.i.l.f)iterator.next(), n2, 0, f3, arrayList, k2);
        }
        Iterator iterator2 = m2.i.l.iterator();
        while (iterator2.hasNext()) {
            this.a((f.f.b.i.l.f)iterator2.next(), n2, 1, f3, arrayList, k2);
        }
        if (n2 != 1) return;
        if (!(m2 instanceof l)) return;
        Iterator iterator3 = ((l)m2).k.l.iterator();
        while (iterator3.hasNext()) {
            f.f.b.i.l.f f4 = (f.f.b.i.l.f)iterator3.next();
            f.f.b.i.l.k k3 = k2;
            this.a(f4, n2, 2, f3, arrayList, k3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean b(f.f.b.i.e e2) {
        d.a a2 = d.a.h;
        d.a a3 = d.a.g;
        d.a a4 = d.a.f;
        d.a a5 = d.a.e;
        Iterator iterator = e2.f0.iterator();
        do {
            d d2;
            d.a a6;
            int n2;
            d.a a7;
            d.a a8;
            block22 : {
                int n3;
                block27 : {
                    g g2;
                    block35 : {
                        block39 : {
                            block18 : {
                                d d3;
                                d.a a9;
                                int n4;
                                e e3;
                                int n5;
                                block38 : {
                                    block37 : {
                                        block25 : {
                                            float f2;
                                            float f3;
                                            block33 : {
                                                int n6;
                                                d.a[] arra;
                                                d.a[] arra2;
                                                block31 : {
                                                    block29 : {
                                                        block30 : {
                                                            block36 : {
                                                                int n7;
                                                                block34 : {
                                                                    block32 : {
                                                                        block23 : {
                                                                            block28 : {
                                                                                int n8;
                                                                                block26 : {
                                                                                    block24 : {
                                                                                        d.a a10;
                                                                                        block19 : {
                                                                                            block21 : {
                                                                                                block20 : {
                                                                                                    if (!iterator.hasNext()) {
                                                                                                        return false;
                                                                                                    }
                                                                                                    d2 = (d)iterator.next();
                                                                                                    d.a[] arra3 = d2.J;
                                                                                                    a7 = arra3[0];
                                                                                                    a10 = arra3[1];
                                                                                                    if (d2.X == 8) break block18;
                                                                                                    if (d2.o < 1.0f && a7 == a3) {
                                                                                                        d2.j = 2;
                                                                                                    }
                                                                                                    if (d2.r < 1.0f && a10 == a3) {
                                                                                                        d2.k = 2;
                                                                                                    }
                                                                                                    if (!(d2.N > 0.0f)) break block19;
                                                                                                    if (a7 != a3 || a10 != a4 && a10 != a5) break block20;
                                                                                                    d2.j = 3;
                                                                                                    break block19;
                                                                                                }
                                                                                                if (a10 == a3 && (a7 == a4 || a7 == a5)) break block21;
                                                                                                if (a7 != a3 || a10 != a3) break block19;
                                                                                                if (d2.j == 0) {
                                                                                                    d2.j = 3;
                                                                                                }
                                                                                                if (d2.k != 0) break block19;
                                                                                            }
                                                                                            d2.k = 3;
                                                                                        }
                                                                                        if (a7 == a3 && d2.j == 1 && (d2.y.d == null || d2.A.d == null)) {
                                                                                            a7 = a4;
                                                                                        }
                                                                                        a6 = a10 == a3 && d2.k == 1 && (d2.z.d == null || d2.B.d == null) ? a4 : a10;
                                                                                        j j2 = d2.d;
                                                                                        j2.d = a7;
                                                                                        j2.a = d2.j;
                                                                                        l l2 = d2.e;
                                                                                        l2.d = a6;
                                                                                        l2.a = d2.k;
                                                                                        if ((a7 == a2 || a7 == a5 || a7 == a4) && (a6 == a2 || a6 == a5 || a6 == a4)) break block22;
                                                                                        if (a7 != a3 || a6 != a4 && a6 != a5) break block23;
                                                                                        n8 = d2.j;
                                                                                        if (n8 != 3) break block24;
                                                                                        if (a6 == a4) {
                                                                                            this.f(d2, a4, 0, a4, 0);
                                                                                        }
                                                                                        n5 = d2.i();
                                                                                        n4 = (int)(0.5f + (float)n5 * d2.N);
                                                                                        break block25;
                                                                                    }
                                                                                    if (n8 != 1) break block26;
                                                                                    this.f(d2, a4, 0, a6, 0);
                                                                                    g2 = d2.d.e;
                                                                                    n3 = d2.o();
                                                                                    break block27;
                                                                                }
                                                                                if (n8 != 2) break block28;
                                                                                d.a[] arra4 = e2.J;
                                                                                if (arra4[0] != a5 && arra4[0] != a2) break block23;
                                                                                n4 = (int)(0.5f + d2.o * (float)e2.o());
                                                                                n5 = d2.i();
                                                                                e3 = this;
                                                                                d3 = d2;
                                                                                a7 = a5;
                                                                                break block29;
                                                                            }
                                                                            c[] arrc = d2.G;
                                                                            if (arrc[0].d == null || arrc[1].d == null) break block30;
                                                                        }
                                                                        if (a6 != a3 || a7 != a4 && a7 != a5) break block31;
                                                                        n7 = d2.k;
                                                                        if (n7 != 3) break block32;
                                                                        if (a7 == a4) {
                                                                            this.f(d2, a4, 0, a4, 0);
                                                                        }
                                                                        n4 = d2.o();
                                                                        f2 = d2.N;
                                                                        if (d2.O == -1) {
                                                                            f2 = 1.0f / f2;
                                                                        }
                                                                        f3 = n4;
                                                                        break block33;
                                                                    }
                                                                    if (n7 != 1) break block34;
                                                                    this.f(d2, a7, 0, a4, 0);
                                                                    break block35;
                                                                }
                                                                if (n7 != 2) break block36;
                                                                d.a[] arra5 = e2.J;
                                                                if (arra5[1] != a5 && arra5[1] != a2) break block31;
                                                                float f4 = d2.r;
                                                                n4 = d2.o();
                                                                n5 = (int)(0.5f + f4 * (float)e2.i());
                                                                e3 = this;
                                                                d3 = d2;
                                                                break block37;
                                                            }
                                                            c[] arrc = d2.G;
                                                            if (arrc[2].d != null && arrc[3].d != null) break block31;
                                                        }
                                                        n4 = 0;
                                                        n5 = 0;
                                                        e3 = this;
                                                        d3 = d2;
                                                        a7 = a4;
                                                    }
                                                    a9 = a6;
                                                    break block38;
                                                }
                                                if (a7 != a3 || a6 != a3) continue;
                                                int n9 = d2.j;
                                                if (n9 == 1 || (n6 = d2.k) == 1) break block39;
                                                if (n6 != 2 || n9 != 2 || (arra2 = e2.J)[0] != a5 && arra2[0] != a5 || (arra = e2.J)[1] != a5 && arra[1] != a5) continue;
                                                float f5 = d2.o;
                                                f3 = d2.r;
                                                n4 = (int)(0.5f + f5 * (float)e2.o());
                                                f2 = e2.i();
                                            }
                                            n5 = (int)(0.5f + f3 * f2);
                                        }
                                        e3 = this;
                                        d3 = d2;
                                        a7 = a5;
                                    }
                                    a9 = a5;
                                }
                                e3.f(d3, a7, n4, a9, n5);
                                d2.d.e.c(d2.o());
                                d2.e.e.c(d2.i());
                            }
                            d2.a = true;
                            continue;
                        }
                        this.f(d2, a4, 0, a4, 0);
                        d2.d.e.m = d2.o();
                    }
                    g2 = d2.e.e;
                    n3 = d2.i();
                }
                g2.m = n3;
                continue;
            }
            int n10 = d2.o();
            if (a7 == a2) {
                n10 = e2.o() - d2.y.e - d2.A.e;
                a7 = a5;
            }
            int n11 = d2.i();
            if (a6 == a2) {
                n2 = e2.i() - d2.z.e - d2.B.e;
                a8 = a5;
            } else {
                n2 = n11;
                a8 = a6;
            }
            this.f(d2, a7, n10, a8, n2);
            d2.d.e.c(d2.o());
            d2.e.e.c(d2.i());
            d2.a = true;
        } while (true);
    }

    public void c() {
        ArrayList<m> arrayList = this.e;
        arrayList.clear();
        this.d.d.f();
        this.d.e.f();
        arrayList.add((Object)this.d.d);
        arrayList.add((Object)this.d.e);
        Iterator iterator = this.d.f0.iterator();
        HashSet hashSet = null;
        while (iterator.hasNext()) {
            f.f.b.i.l.h h2;
            d d2 = (d)iterator.next();
            if (d2 instanceof f) {
                h2 = new f.f.b.i.l.h(d2);
            } else {
                if (d2.s()) {
                    if (d2.b == null) {
                        d2.b = new f.f.b.i.l.c(d2, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add((Object)d2.b);
                } else {
                    arrayList.add((Object)d2.d);
                }
                if (d2.t()) {
                    if (d2.c == null) {
                        d2.c = new f.f.b.i.l.c(d2, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add((Object)d2.c);
                } else {
                    arrayList.add((Object)d2.e);
                }
                if (!(d2 instanceof h)) continue;
                h2 = new i(d2);
            }
            arrayList.add((Object)h2);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            ((m)iterator2.next()).f();
        }
        for (m m2 : arrayList) {
            if (m2.b == this.d) continue;
            m2.d();
        }
        this.h.clear();
        f.f.b.i.l.k.c = 0;
        this.e((m)this.a.d, 0, this.h);
        this.e((m)this.a.e, 1, this.h);
        this.b = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final int d(f.f.b.i.e var1_1, int var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_5 = var3_3.h.size();
        var6_6 = 0L;
        var8_7 = 0;
        var9_8 = var6_6;
        while (var8_7 < var5_5) {
            block9 : {
                block11 : {
                    block10 : {
                        var11_9 = (f.f.b.i.l.k)var3_3.h.get(var8_7);
                        var12_10 = var11_9.a;
                        if (var12_10 instanceof f.f.b.i.l.c == false ? (var2_2 != 0 ? var12_10 instanceof l == false : var12_10 instanceof j == false) : ((f.f.b.i.l.c)var12_10).f != var2_2) break block9;
                        if (var2_2 == 0) {
                            var13_12 = var4_4.d;
                        } else {
                            var13_13 = var4_4.e;
                        }
                        var14_14 = var13_11.h;
                        if (var2_2 == 0) {
                            var15_16 = var4_4.d;
                        } else {
                            var15_17 = var4_4.e;
                        }
                        var16_18 = var15_15.i;
                        var17_19 = var11_9.a.h.l.contains((Object)var14_14);
                        var18_20 = var11_9.a.i.l.contains((Object)var16_18);
                        var19_21 = var11_9.a.j();
                        if (!var17_19 || !var18_20) break block10;
                        var30_28 = var11_9.b(var11_9.a.h, var6_6);
                        var32_29 = var11_9.a(var11_9.a.i, var6_6);
                        var34_30 = var30_28 - var19_21;
                        var36_31 = var11_9.a.i.f;
                        if (var34_30 >= (long)(-var36_31)) {
                            var34_30 += (long)var36_31;
                        }
                        if ((var41_34 = (var37_32 = -var32_29 - var19_21) - (var39_33 = (long)var11_9.a.h.f)) >= var39_33) {
                            var41_34 -= var39_33;
                        }
                        if ((var43_35 = var11_9.a.b) == null) throw null;
                        var44_36 = var2_2 == 0 ? var43_35.U : (var2_2 == 1 ? var43_35.V : -1.0f);
                        var45_37 = var44_36 > 0.0f ? (long)((float)var41_34 / var44_36 + (float)var34_30 / (1.0f - var44_36)) : 0L;
                        var47_38 = var45_37;
                        var48_39 = (long)(0.5f + var47_38 * var44_36);
                        var50_40 = (long)(0.5f + var47_38 * (1.0f - var44_36)) + (var48_39 + var19_21);
                        var52_41 = var11_9.a;
                        var6_6 = var50_40 + (long)var52_41.h.f - (long)var52_41.i.f;
                        break block9;
                    }
                    if (!var17_19) break block11;
                    var29_27 = var11_9.a.h;
                    var27_26 = var11_9.b(var29_27, var29_27.f);
                    var25_25 = var19_21 + (long)var11_9.a.h.f;
                    ** GOTO lbl55
                }
                var21_22 = var11_9.a;
                if (var18_20) {
                    var22_23 = var21_22.i;
                    var23_24 = var11_9.a(var22_23, var22_23.f);
                    var25_25 = var19_21 + (long)(-var11_9.a.i.f);
                    var27_26 = -var23_24;
lbl55: // 2 sources:
                    var6_6 = Math.max((long)var27_26, (long)var25_25);
                } else {
                    var6_6 = (long)var21_22.h.f + var21_22.j() - (long)var11_9.a.i.f;
                }
            }
            var9_8 = Math.max((long)var9_8, (long)var6_6);
            ++var8_7;
            var3_3 = this;
            var4_4 = var1_1;
            var6_6 = 0L;
        }
        return (int)var9_8;
    }

    public final void e(m m2, int n2, ArrayList<f.f.b.i.l.k> arrayList) {
        for (f.f.b.i.l.d d2 : m2.h.k) {
            if (d2 instanceof f.f.b.i.l.f) {
                this.a((f.f.b.i.l.f)d2, n2, 0, m2.i, arrayList, null);
                continue;
            }
            if (!(d2 instanceof m)) continue;
            this.a(((m)d2).h, n2, 0, m2.i, arrayList, null);
        }
        for (f.f.b.i.l.d d3 : m2.i.k) {
            if (d3 instanceof f.f.b.i.l.f) {
                this.a((f.f.b.i.l.f)d3, n2, 1, m2.h, arrayList, null);
                continue;
            }
            if (!(d3 instanceof m)) continue;
            this.a(((m)d3).i, n2, 1, m2.h, arrayList, null);
        }
        if (n2 == 1) {
            for (f.f.b.i.l.d d4 : ((l)m2).k.k) {
                if (!(d4 instanceof f.f.b.i.l.f)) continue;
                this.a((f.f.b.i.l.f)d4, n2, 2, null, arrayList, null);
            }
        }
    }

    public final void f(d d2, d.a a2, int n2, d.a a3, int n3) {
        int n4;
        b.a a4 = this.g;
        a4.a = a2;
        a4.b = a3;
        a4.c = n2;
        a4.d = n3;
        ((ConstraintLayout.b)this.f).a(d2, a4);
        d2.B(this.g.e);
        d2.w(this.g.f);
        b.a a5 = this.g;
        d2.w = a5.h;
        d2.R = n4 = a5.g;
        boolean bl = n4 > 0;
        d2.w = bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void g() {
        var1_1 = d.a.e;
        var2_2 = d.a.g;
        var3_3 = d.a.f;
        var4_4 = this.a.f0.iterator();
        while (var4_4.hasNext() != false) {
            block12 : {
                block11 : {
                    block10 : {
                        block9 : {
                            block8 : {
                                var5_5 = (d)var4_4.next();
                                if (var5_5.a) continue;
                                var6_6 = var5_5.J;
                                var7_7 = var6_6[0];
                                var8_8 = var6_6[1];
                                var9_9 = var5_5.j;
                                var10_10 = var5_5.k;
                                var11_11 = var7_7 == var3_3 || var7_7 == var2_2 && var9_9 == 1;
                                if (var8_8 == var3_3) break block8;
                                var12_12 = false;
                                if (var8_8 != var2_2) break block9;
                                var12_12 = false;
                                if (var10_10 != 1) break block9;
                            }
                            var12_12 = true;
                        }
                        var13_13 = var5_5.d.e;
                        var14_14 = var13_13.j;
                        var15_15 = var5_5.e.e;
                        var16_16 = var15_15.j;
                        if (!var14_14 || !var16_16) break block10;
                        this.f(var5_5, var1_1, var13_13.g, var1_1, var15_15.g);
                        ** GOTO lbl46
                    }
                    if (!var14_14 || !var12_12) break block11;
                    this.f(var5_5, var1_1, var5_5.d.e.g, var3_3, var5_5.e.e.g);
                    var18_18 = var5_5.e.e;
                    var19_19 = var5_5.i();
                    if (var8_8 != var2_2) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                if (var16_16 && var11_11) {
                    this.f(var5_5, var3_3, var5_5.d.e.g, var1_1, var5_5.e.e.g);
                    var18_18 = var5_5.d.e;
                    var19_19 = var5_5.o();
                    ** if (var7_7 != var2_2) goto lbl-1000
                }
                break block12;
lbl-1000: // 2 sources:
                {
                    var18_18.m = var19_19;
                    ** GOTO lbl47
                }
lbl-1000: // 2 sources:
                {
                    var18_18.c(var19_19);
lbl46: // 2 sources:
                    var5_5.a = true;
                }
            }
            if (!var5_5.a || (var17_17 = var5_5.e.l) == null) continue;
            var17_17.c(var5_5.R);
        }
    }
}

