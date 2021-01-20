/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  f.f.b.b
 *  f.f.b.i.f
 *  f.f.b.i.h
 *  f.f.b.i.k
 *  f.f.b.i.l.f
 *  f.f.b.i.l.m
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package f.f.b.i;

import f.b.k.h;
import f.f.b.b;
import f.f.b.c;
import f.f.b.d;
import f.f.b.g;
import f.f.b.i.a;
import f.f.b.i.d;
import f.f.b.i.f;
import f.f.b.i.h;
import f.f.b.i.i;
import f.f.b.i.j;
import f.f.b.i.k;
import f.f.b.i.l.b;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class e
extends k {
    public f.f.b.i.l.b g0 = new f.f.b.i.l.b(this);
    public f.f.b.i.l.e h0 = new f.f.b.i.l.e(this);
    public b.b i0 = null;
    public boolean j0 = false;
    public d k0 = new d();
    public int l0;
    public int m0;
    public int n0 = 0;
    public int o0 = 0;
    public f.f.b.i.b[] p0 = new f.f.b.i.b[4];
    public f.f.b.i.b[] q0 = new f.f.b.i.b[4];
    public int r0 = 263;
    public boolean s0 = false;
    public boolean t0 = false;

    public void C(boolean bl, boolean bl2) {
        f.f.b.i.d.super.C(bl, bl2);
        int n2 = this.f0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((f.f.b.i.d)this.f0.get(i2)).C(bl, bl2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void E() {
        var1_1 = d.a.e;
        var2_2 = d.a.f;
        this.P = 0;
        this.Q = 0;
        var3_3 = Math.max((int)0, (int)this.o());
        var4_4 = Math.max((int)0, (int)this.i());
        this.s0 = false;
        this.t0 = false;
        var5_5 = (64 & this.r0) == 64;
        var6_7 = var5_5 || (var49_6 = (128 & this.r0) == 128);
        var7_8 = this.k0;
        var7_8.g = false;
        var7_8.h = false;
        if (this.r0 != 0 && var6_7) {
            var7_8.h = true;
        }
        var8_9 = this.J;
        var9_10 = var8_9[1];
        var10_11 = var8_9[0];
        var11_12 = this.f0;
        var12_13 = this.j() == var2_2 || this.n() == var2_2;
        this.n0 = 0;
        this.o0 = 0;
        var13_14 = this.f0.size();
        for (var14_15 = 0; var14_15 < var13_14; ++var14_15) {
            var48_16 = (f.f.b.i.d)this.f0.get(var14_15);
            if (!(var48_16 instanceof k)) continue;
            ((k)var48_16).E();
        }
        var15_17 = 0;
        var16_18 = 0;
        var17_19 = 1;
        do {
            block34 : {
                block32 : {
                    block30 : {
                        block31 : {
                            block33 : {
                                if (var17_19 == 0) ** GOTO lbl41
                                var19_20 = var15_17 + 1;
                                this.k0.t();
                                this.n0 = 0;
                                this.o0 = 0;
                                this.e(this.k0);
                                break block33;
lbl41: // 1 sources:
                                this.f0 = var11_12;
                                if (var16_18 != 0) {
                                    var18_48 = this.J;
                                    var18_48[0] = var10_11;
                                    var18_48[1] = var9_10;
                                }
                                this.v(this.k0.m);
                                return;
                            }
                            for (var43_44 = 0; var43_44 < var13_14; ++var43_44) {
                                ((f.f.b.i.d)this.f0.get(var43_44)).e(this.k0);
                            }
                            this.G(this.k0);
                            try {
                                var45_45 = this.k0;
                                if (var45_45.g || var45_45.h) {
                                    break block30;
                                }
                                ** GOTO lbl-1000
                            }
                            catch (Exception var20_22) {
                                var17_19 = 1;
                                break block31;
                            }
                            catch (Exception var20_23) {
                                // empty catch block
                            }
                        }
                        var20_21.printStackTrace();
                        var21_24 = System.out;
                        var22_25 = new StringBuilder();
                        var23_26 = var17_19;
                        var22_25.append("EXCEPTION : ");
                        var22_25.append((Object)var20_21);
                        var21_24.println(var22_25.toString());
                        break block34;
                    }
                    for (var46_46 = 0; var46_46 < var45_45.k; ++var46_46) {
                        if (var45_45.f[var46_46].f) continue;
                        var47_47 = false;
                        break block32;
                    }
                    var47_47 = true;
                }
                if (!var47_47) lbl-1000: // 2 sources:
                {
                    var45_45.q(var45_45.c);
                } else {
                    var45_45.j();
                }
                var23_26 = 1;
            }
            if (var23_26 != 0) {
                var40_41 = this.k0;
                i.a[2] = false;
                this.D(var40_41);
                var41_42 = this.f0.size();
                for (var42_43 = 0; var42_43 < var41_42; ++var42_43) {
                    ((f.f.b.i.d)this.f0.get(var42_43)).D(var40_41);
                }
            } else {
                this.D(this.k0);
                for (var26_27 = 0; var26_27 < var13_14; ++var26_27) {
                    ((f.f.b.i.d)this.f0.get(var26_27)).D(this.k0);
                }
            }
            if (var12_13 && var19_20 < 8 && i.a[2]) {
                var34_35 = 0;
                var35_36 = 0;
                for (var33_34 = 0; var33_34 < var13_14; ++var33_34) {
                    var38_39 = (f.f.b.i.d)this.f0.get(var33_34);
                    var39_40 = var12_13;
                    var34_35 = Math.max((int)var34_35, (int)(var38_39.P + var38_39.o()));
                    var35_36 = Math.max((int)var35_36, (int)(var38_39.Q + var38_39.i()));
                    var12_13 = var39_40;
                }
                var27_28 = var12_13;
                var36_37 = Math.max((int)this.S, (int)var34_35);
                var37_38 = Math.max((int)this.T, (int)var35_36);
                if (var10_11 == var2_2 && this.o() < var36_37) {
                    this.B(var36_37);
                    this.J[0] = var2_2;
                    var28_29 = 1;
                    var16_18 = 1;
                } else {
                    var28_29 = 0;
                }
                if (var9_10 == var2_2 && this.i() < var37_38) {
                    this.w(var37_38);
                    this.J[1] = var2_2;
                    var28_29 = 1;
                    var16_18 = 1;
                }
            } else {
                var27_28 = var12_13;
                var28_29 = 0;
            }
            if ((var29_30 = Math.max((int)this.S, (int)this.o())) > this.o()) {
                this.B(var29_30);
                this.J[0] = var1_1;
                var28_29 = 1;
                var16_18 = 1;
            }
            if ((var30_31 = Math.max((int)this.T, (int)this.i())) > this.i()) {
                this.w(var30_31);
                var32_33 = this.J;
                var31_32 = 1;
                var32_33[var31_32] = var1_1;
                var16_18 = var28_29 = var31_32;
            } else {
                var31_32 = 1;
            }
            if (var16_18 != 0) ** GOTO lbl-1000
            if (this.J[0] == var2_2 && var3_3 > 0 && this.o() > var3_3) {
                this.s0 = var31_32;
                this.J[0] = var1_1;
                this.B(var3_3);
                var16_18 = var28_29 = var31_32;
            }
            if (this.J[var31_32] == var2_2 && var4_4 > 0 && this.i() > var4_4) {
                this.t0 = var31_32;
                this.J[var31_32] = var1_1;
                this.w(var4_4);
                var17_19 = 1;
                var16_18 = 1;
            } else lbl-1000: // 2 sources:
            {
                var17_19 = var28_29;
            }
            var15_17 = var19_20;
            var12_13 = var27_28;
        } while (true);
    }

    public void F(f.f.b.i.d d2, int n2) {
        if (n2 == 0) {
            int n3 = 1 + this.n0;
            Object[] arrobject = this.q0;
            if (n3 >= arrobject.length) {
                this.q0 = (f.f.b.i.b[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
            }
            this.q0[this.n0] = new f.f.b.i.b(d2, 0, this.j0);
            this.n0 = 1 + this.n0;
            return;
        }
        if (n2 == 1) {
            int n4 = 1 + this.o0;
            Object[] arrobject = this.p0;
            if (n4 >= arrobject.length) {
                this.p0 = (f.f.b.i.b[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
            }
            this.p0[this.o0] = new f.f.b.i.b(d2, 1, this.j0);
            this.o0 = 1 + this.o0;
        }
    }

    public boolean G(d d2) {
        d.a a2 = d.a.e;
        d.a a3 = d.a.f;
        ((f.f.b.i.d)((Object)this)).b(d2);
        int n2 = this.f0.size();
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            f.f.b.i.d d3 = (f.f.b.i.d)this.f0.get(i2);
            boolean[] arrbl = d3.I;
            arrbl[0] = false;
            arrbl[1] = false;
            if (!(d3 instanceof a)) continue;
            bl = true;
        }
        if (bl) {
            for (int i3 = 0; i3 < n2; ++i3) {
                f.f.b.i.d d4 = (f.f.b.i.d)this.f0.get(i3);
                if (!(d4 instanceof a)) continue;
                a a4 = (a)((Object)d4);
                for (int i4 = 0; i4 < a4.g0; ++i4) {
                    f.f.b.i.d d5 = a4.f0[i4];
                    int n3 = a4.h0;
                    if (n3 != 0 && n3 != 1) {
                        if (n3 != 2 && n3 != 3) continue;
                        d5.I[1] = true;
                        continue;
                    }
                    d5.I[0] = true;
                }
            }
        }
        for (int i5 = 0; i5 < n2; ++i5) {
            f.f.b.i.d d6 = (f.f.b.i.d)this.f0.get(i5);
            if (d6 != null) {
                boolean bl2 = d6 instanceof j || d6 instanceof f;
                if (!bl2) continue;
                d6.b(d2);
                continue;
            }
            throw null;
        }
        for (int i6 = 0; i6 < n2; ++i6) {
            f.f.b.i.d d7 = (f.f.b.i.d)this.f0.get(i6);
            if (d7 instanceof e) {
                d.a[] arra = d7.J;
                d.a a5 = arra[0];
                d.a a6 = arra[1];
                if (a5 == a3) {
                    arra[0] = a2;
                }
                if (a6 == a3) {
                    d7.J[1] = a2;
                }
                d7.b(d2);
                if (a5 == a3) {
                    d7.x(a5);
                }
                if (a6 != a3) continue;
                d7.A(a6);
                continue;
            }
            d.a a7 = d.a.h;
            d7.h = -1;
            d7.i = -1;
            if (((f.f.b.i.d)this).J[0] != a3 && d7.J[0] == a7) {
                int n4;
                int n5 = d7.y.e;
                int n6 = ((f.f.b.i.d)((Object)this)).o() - d7.A.e;
                f.f.b.i.c c2 = d7.y;
                c2.g = d2.l(c2);
                f.f.b.i.c c3 = d7.A;
                c3.g = d2.l(c3);
                d2.e(d7.y.g, n5);
                d2.e(d7.A.g, n6);
                d7.h = 2;
                d7.P = n5;
                d7.L = n4 = n6 - n5;
                int n7 = d7.S;
                if (n4 < n7) {
                    d7.L = n7;
                }
            }
            if (((f.f.b.i.d)this).J[1] != a3 && d7.J[1] == a7) {
                int n8;
                int n9 = d7.z.e;
                int n10 = ((f.f.b.i.d)((Object)this)).i() - d7.B.e;
                f.f.b.i.c c4 = d7.z;
                c4.g = d2.l(c4);
                f.f.b.i.c c5 = d7.B;
                c5.g = d2.l(c5);
                d2.e(d7.z.g, n9);
                d2.e(d7.B.g, n10);
                if (d7.R > 0 || d7.X == 8) {
                    f.f.b.i.c c6 = d7.C;
                    c6.g = d2.l(c6);
                    d2.e(d7.C.g, n9 + d7.R);
                }
                d7.i = 2;
                d7.Q = n9;
                d7.M = n8 = n10 - n9;
                int n11 = d7.T;
                if (n8 < n11) {
                    d7.M = n11;
                }
            }
            boolean bl3 = d7 instanceof j || d7 instanceof f;
            if (bl3) continue;
            d7.b(d2);
        }
        if (this.n0 > 0) {
            h.i.c(this, d2, 0);
        }
        if (this.o0 > 0) {
            h.i.c(this, d2, 1);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean H(boolean var1_1, int var2_2) {
        block11 : {
            block8 : {
                block10 : {
                    block9 : {
                        var3_3 = this.h0;
                        var4_4 = d.a.h;
                        var5_5 = d.a.f;
                        var6_6 = d.a.e;
                        var7_7 = true;
                        var8_8 = var1_1 & var7_7;
                        var9_9 = var3_3.a.h(0);
                        var10_10 = var3_3.a.h((int)var7_7);
                        var11_11 = var3_3.a.p();
                        var12_12 = var3_3.a.q();
                        if (!var8_8 || var9_9 != var5_5 && var10_10 != var5_5) break block8;
                        for (m var30_14 : var3_3.e) {
                            if (var30_14.f != var2_2 || var30_14.k()) continue;
                            var8_8 = false;
                            break;
                        }
                        if (var2_2 != 0) break block9;
                        if (!var8_8 || var9_9 != var5_5) break block8;
                        var28_15 = var3_3.a;
                        var28_15.J[0] = var6_6;
                        var28_15.B(var3_3.d(var28_15, 0));
                        var29_16 = var3_3.a;
                        var26_17 = var29_16.d.e;
                        var27_18 = var29_16.o();
                        break block10;
                    }
                    if (!var8_8 || var10_10 != var5_5) break block8;
                    var24_19 = var3_3.a;
                    var24_19.J[var7_7] = var6_6;
                    var24_19.w(var3_3.d(var24_19, (int)var7_7));
                    var25_20 = var3_3.a;
                    var26_17 = var25_20.e.e;
                    var27_18 = var25_20.i();
                }
                var26_17.c(var27_18);
            }
            var13_21 = var3_3.a.J;
            if (var2_2 != 0) break block11;
            if (var13_21[0] != var6_6 && var13_21[0] != var4_4) ** GOTO lbl-1000
            var22_22 = var11_11 + var3_3.a.o();
            var3_3.a.d.i.c(var22_22);
            var15_23 = var3_3.a.d.e;
            var16_24 = var22_22 - var11_11;
            ** GOTO lbl52
        }
        if (var13_21[var7_7] != var6_6 && var13_21[var7_7] != var4_4) lbl-1000: // 2 sources:
        {
            var17_25 = false;
        } else {
            var14_26 = var12_12 + var3_3.a.i();
            var3_3.a.e.i.c(var14_26);
            var15_23 = var3_3.a.e.e;
            var16_24 = var14_26 - var12_12;
lbl52: // 2 sources:
            var15_23.c(var16_24);
            var17_25 = var7_7;
        }
        var3_3.g();
        for (m var21_28 : var3_3.e) {
            if (var21_28.f != var2_2 || var21_28.b == var3_3.a && !var21_28.g) continue;
            var21_28.e();
        }
        for (m var20_30 : var3_3.e) {
            if (var20_30.f != var2_2 || !var17_25 && var20_30.b == var3_3.a || var20_30.h.j && var20_30.i.j && (var20_30 instanceof f.f.b.i.l.c || var20_30.e.j)) continue;
            var7_7 = false;
            break;
        }
        var3_3.a.x(var9_9);
        var3_3.a.A(var10_10);
        return var7_7;
    }

    public void I() {
        this.h0.b = true;
    }

    public void J(int n2) {
        this.r0 = n2;
        d.r = i.a(n2, 256);
    }

    public void u() {
        this.k0.t();
        this.l0 = 0;
        this.m0 = 0;
        super.u();
    }
}

