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
 *  java.util.List
 */
package f.f.b.i.l;

import c.b.a.a.a;
import f.f.b.i.c;
import f.f.b.i.d;
import f.f.b.i.l.d;
import f.f.b.i.l.f;
import f.f.b.i.l.g;
import f.f.b.i.l.k;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.List;

public class j
extends m {
    public static int[] k = new int[2];

    public j(f.f.b.i.d d2) {
        super(d2);
        this.h.e = f.a.h;
        this.i.e = f.a.i;
        this.f = 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(d var1_1) {
        block27 : {
            block35 : {
                block28 : {
                    block42 : {
                        block43 : {
                            block40 : {
                                block41 : {
                                    block36 : {
                                        block38 : {
                                            block39 : {
                                                block37 : {
                                                    block34 : {
                                                        block29 : {
                                                            block32 : {
                                                                block33 : {
                                                                    block30 : {
                                                                        block31 : {
                                                                            var2_2 = d.a.g;
                                                                            var3_3 = this.j.ordinal();
                                                                            if (var3_3 != 1 && var3_3 != 2 && var3_3 == 3) {
                                                                                var84_4 = this.b;
                                                                                this.l(var84_4.y, var84_4.A, 0);
                                                                                return;
                                                                            }
                                                                            var4_5 = this.e;
                                                                            if (var4_5.j || this.d != var2_2) break block27;
                                                                            var30_6 = this.b;
                                                                            var31_7 = var30_6.j;
                                                                            if (var31_7 == 2) break block28;
                                                                            if (var31_7 != 3) break block27;
                                                                            var35_8 = var30_6.k;
                                                                            if (var35_8 == 0 || var35_8 == 3) break block29;
                                                                            var81_9 = var30_6.O;
                                                                            if (var81_9 == -1) break block30;
                                                                            if (var81_9 == 0) break block31;
                                                                            if (var81_9 == 1) break block30;
                                                                            var83_10 = 0;
                                                                            break block32;
                                                                        }
                                                                        var82_11 = (float)var30_6.e.e.g / var30_6.N;
                                                                        break block33;
                                                                    }
                                                                    var82_11 = (float)var30_6.e.e.g * var30_6.N;
                                                                }
                                                                var83_10 = (int)(var82_11 + 0.5f);
                                                            }
                                                            this.e.c(var83_10);
                                                            break block27;
                                                        }
                                                        var36_12 = this.b;
                                                        var37_13 = var36_12.e;
                                                        var38_14 = var37_13.h;
                                                        var39_15 = var37_13.i;
                                                        var40_16 = var36_12.y.d != null;
                                                        var41_17 = this.b.z.d != null;
                                                        var42_18 = this.b.A.d != null;
                                                        var43_19 = this.b.B.d != null;
                                                        var44_20 = this.b;
                                                        var45_21 = var44_20.O;
                                                        if (!var40_16 || !var41_17 || !var42_18 || !var43_19) break block34;
                                                        var62_22 = var44_20.N;
                                                        if (var38_14.j && var39_15.j) {
                                                            var76_23 = this.h;
                                                            if (var76_23.c == false) return;
                                                            if (!this.i.c) {
                                                                return;
                                                            }
                                                            var77_24 = ((f)var76_23.l.get((int)0)).g + this.h.f;
                                                            var78_25 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                                            var79_26 = var38_14.g + var38_14.f;
                                                            var80_27 = var39_15.g - var39_15.f;
                                                            this.m(j.k, var77_24, var78_25, var79_26, var80_27, var62_22, var45_21);
                                                            this.e.c(j.k[0]);
                                                            this.b.e.e.c(j.k[1]);
                                                            return;
                                                        }
                                                        var63_28 = this.h;
                                                        if (!var63_28.j) ** GOTO lbl-1000
                                                        var70_29 = this.i;
                                                        if (var70_29.j) {
                                                            if (var38_14.c == false) return;
                                                            if (!var39_15.c) {
                                                                return;
                                                            }
                                                            var71_30 = var63_28.g + var63_28.f;
                                                            var72_31 = var70_29.g - var70_29.f;
                                                            var73_32 = ((f)var38_14.l.get((int)0)).g + var38_14.f;
                                                            var74_33 = ((f)var39_15.l.get((int)0)).g - var39_15.f;
                                                            var75_34 = j.k;
                                                            var64_35 = var62_22;
                                                            this.m(var75_34, var71_30, var72_31, var73_32, var74_33, var62_22, var45_21);
                                                            this.e.c(j.k[0]);
                                                            this.b.e.e.c(j.k[1]);
                                                        } else lbl-1000: // 2 sources:
                                                        {
                                                            var64_35 = var62_22;
                                                        }
                                                        var65_36 = this.h;
                                                        if (var65_36.c == false) return;
                                                        if (this.i.c == false) return;
                                                        if (var38_14.c == false) return;
                                                        if (!var39_15.c) {
                                                            return;
                                                        }
                                                        var66_37 = ((f)var65_36.l.get((int)0)).g + this.h.f;
                                                        var67_38 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                                        var68_39 = ((f)var38_14.l.get((int)0)).g + var38_14.f;
                                                        var69_40 = ((f)var39_15.l.get((int)0)).g - var39_15.f;
                                                        this.m(j.k, var66_37, var67_38, var68_39, var69_40, var64_35, var45_21);
                                                        this.e.c(j.k[0]);
                                                        var4_5 = this.b.e.e;
                                                        var34_41 = j.k[1];
                                                        break block35;
                                                    }
                                                    if (!var40_16 || !var42_18) break block36;
                                                    var53_42 = this.h;
                                                    if (var53_42.c == false) return;
                                                    if (!this.i.c) {
                                                        return;
                                                    }
                                                    var54_43 = this.b.N;
                                                    var55_44 = ((f)var53_42.l.get((int)0)).g + this.h.f;
                                                    var56_45 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                                    if (var45_21 == -1 || var45_21 == 0) break block37;
                                                    if (var45_21 != 1) break block27;
                                                    var57_46 = this.g(var56_45 - var55_44, 0);
                                                    var61_47 = (int)(0.5f + (float)var57_46 / var54_43);
                                                    if (var61_47 == (var59_48 = this.g(var61_47, 1))) break block38;
                                                    var60_49 = var54_43 * (float)var59_48;
                                                    break block39;
                                                }
                                                var57_46 = this.g(var56_45 - var55_44, 0);
                                                var58_50 = (int)(0.5f + var54_43 * (float)var57_46);
                                                if (var58_50 == (var59_48 = this.g(var58_50, 1))) break block38;
                                                var60_49 = (float)var59_48 / var54_43;
                                            }
                                            var57_46 = (int)(var60_49 + 0.5f);
                                        }
                                        this.e.c(var57_46);
                                        this.b.e.e.c(var59_48);
                                        break block27;
                                    }
                                    if (!var41_17 || !var43_19) break block27;
                                    if (var38_14.c == false) return;
                                    if (!var39_15.c) {
                                        return;
                                    }
                                    var46_51 = this.b.N;
                                    var47_52 = ((f)var38_14.l.get((int)0)).g + var38_14.f;
                                    var48_53 = ((f)var39_15.l.get((int)0)).g - var39_15.f;
                                    if (var45_21 == -1) break block40;
                                    if (var45_21 == 0) break block41;
                                    if (var45_21 == 1) break block40;
                                    break block27;
                                }
                                var34_41 = this.g(var48_53 - var47_52, 1);
                                var52_54 = (int)(0.5f + var46_51 * (float)var34_41);
                                if (var52_54 == (var50_55 = this.g(var52_54, 0))) break block42;
                                var51_56 = (float)var50_55 / var46_51;
                                break block43;
                            }
                            if ((var49_57 = (int)(0.5f + (float)(var34_41 = this.g(var48_53 - var47_52, 1)) / var46_51)) == (var50_55 = this.g(var49_57, 0))) break block42;
                            var51_56 = var46_51 * (float)var50_55;
                        }
                        var34_41 = (int)(var51_56 + 0.5f);
                    }
                    this.e.c(var50_55);
                    var4_5 = this.b.e.e;
                    break block35;
                }
                var32_58 = var30_6.K;
                if (var32_58 == null) break block27;
                var33_59 = var32_58.d.e;
                if (!var33_59.j) break block27;
                var34_41 = (int)(0.5f + var30_6.o * (float)var33_59.g);
            }
            var4_5.c(var34_41);
        }
        var5_60 = this.h;
        if (var5_60.c == false) return;
        var6_61 = this.i;
        if (!var6_61.c) {
            return;
        }
        if (var5_60.j && var6_61.j && this.e.j) {
            return;
        }
        if (!this.e.j && this.d == var2_2) {
            var22_62 = this.b;
            if (var22_62.j == 0 && !var22_62.s()) {
                var23_63 = (f)this.h.l.get(0);
                var24_64 = (f)this.i.l.get(0);
                var25_65 = var23_63.g;
                var26_66 = this.h;
                var27_67 = var25_65 + var26_66.f;
                var28_68 = var24_64.g + this.i.f;
                var29_69 = var28_68 - var27_67;
                var26_66.c(var27_67);
                this.i.c(var28_68);
                this.e.c(var29_69);
                return;
            }
        }
        if (!this.e.j && this.d == var2_2 && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
            var15_70 = (f)this.h.l.get(0);
            var16_71 = (f)this.i.l.get(0);
            var17_72 = var15_70.g + this.h.f;
            var18_73 = Math.min((int)(var16_71.g + this.i.f - var17_72), (int)this.e.m);
            var19_74 = this.b;
            var20_75 = var19_74.n;
            var21_76 = Math.max((int)var19_74.m, (int)var18_73);
            if (var20_75 > 0) {
                var21_76 = Math.min((int)var20_75, (int)var21_76);
            }
            this.e.c(var21_76);
        }
        if (!this.e.j) {
            return;
        }
        var7_77 = (f)this.h.l.get(0);
        var8_78 = (f)this.i.l.get(0);
        var9_79 = var7_77.g;
        var10_80 = var9_79 + this.h.f;
        var11_81 = var8_78.g;
        var12_82 = var11_81 + this.i.f;
        var13_83 = this.b.U;
        if (var7_77 == var8_78) {
            var13_83 = 0.5f;
        } else {
            var9_79 = var10_80;
            var11_81 = var12_82;
        }
        var14_84 = var11_81 - var9_79 - this.e.g;
        this.h.c((int)(0.5f + (float)var9_79 + var13_83 * (float)var14_84));
        this.i.c(this.h.g + this.e.g);
    }

    public void d() {
        block35 : {
            block50 : {
                f.f.b.i.d d2;
                f.f.b.i.d d3;
                block51 : {
                    c[] arrc;
                    block49 : {
                        block47 : {
                            block48 : {
                                c c2;
                                block33 : {
                                    f f2;
                                    block39 : {
                                        List list;
                                        f f3;
                                        block45 : {
                                            f.f.b.i.d d4;
                                            block40 : {
                                                block43 : {
                                                    g g2;
                                                    block46 : {
                                                        block41 : {
                                                            block44 : {
                                                                block42 : {
                                                                    d.a a2;
                                                                    block30 : {
                                                                        f f4;
                                                                        int n2;
                                                                        f f5;
                                                                        block38 : {
                                                                            block36 : {
                                                                                f.f.b.i.d d5;
                                                                                block37 : {
                                                                                    c[] arrc2;
                                                                                    block34 : {
                                                                                        block31 : {
                                                                                            f f6;
                                                                                            block32 : {
                                                                                                f.f.b.i.d d6;
                                                                                                a2 = d.a.g;
                                                                                                d.a a3 = d.a.e;
                                                                                                d.a a4 = d.a.h;
                                                                                                f.f.b.i.d d7 = this.b;
                                                                                                if (d7.a) {
                                                                                                    this.e.c(d7.o());
                                                                                                }
                                                                                                if (!this.e.j) {
                                                                                                    d.a a5;
                                                                                                    this.d = a5 = this.b.j();
                                                                                                    if (a5 != a2) {
                                                                                                        f.f.b.i.d d8;
                                                                                                        if (a5 == a4 && ((d8 = this.b.K) != null && d8.j() == a3 || d8.j() == a4)) {
                                                                                                            int n3 = d8.o() - this.b.y.b() - this.b.A.b();
                                                                                                            this.b(this.h, d8.d.h, this.b.y.b());
                                                                                                            this.b(this.i, d8.d.i, -this.b.A.b());
                                                                                                            this.e.c(n3);
                                                                                                            return;
                                                                                                        }
                                                                                                        if (this.d == a3) {
                                                                                                            this.e.c(this.b.o());
                                                                                                        }
                                                                                                    }
                                                                                                } else if (this.d == a4 && ((d6 = this.b.K) != null && d6.j() == a3 || d6.j() == a4)) {
                                                                                                    this.b(this.h, d6.d.h, this.b.y.b());
                                                                                                    this.b(this.i, d6.d.i, -this.b.A.b());
                                                                                                    return;
                                                                                                }
                                                                                                if (!this.e.j) break block30;
                                                                                                f.f.b.i.d d9 = this.b;
                                                                                                if (!d9.a) break block30;
                                                                                                c[] arrc3 = d9.G;
                                                                                                if (arrc3[0].d == null || arrc3[1].d == null) break block31;
                                                                                                if (!d9.s()) break block32;
                                                                                                this.h.f = this.b.G[0].b();
                                                                                                f2 = this.i;
                                                                                                c2 = this.b.G[1];
                                                                                                break block33;
                                                                                            }
                                                                                            f f7 = this.h(this.b.G[0]);
                                                                                            if (f7 != null) {
                                                                                                f f8 = this.h;
                                                                                                int n4 = this.b.G[0].b();
                                                                                                f8.l.add((Object)f7);
                                                                                                f8.f = n4;
                                                                                                f7.k.add((Object)f8);
                                                                                            }
                                                                                            if ((f6 = this.h(this.b.G[1])) != null) {
                                                                                                f f9 = this.i;
                                                                                                int n5 = -this.b.G[1].b();
                                                                                                f9.l.add((Object)f6);
                                                                                                f9.f = n5;
                                                                                                f6.k.add((Object)f9);
                                                                                            }
                                                                                            this.h.b = true;
                                                                                            this.i.b = true;
                                                                                            return;
                                                                                        }
                                                                                        d5 = this.b;
                                                                                        arrc2 = d5.G;
                                                                                        if (arrc2[0].d == null) break block34;
                                                                                        f f10 = this.h(arrc2[0]);
                                                                                        if (f10 == null) break block35;
                                                                                        f f11 = this.h;
                                                                                        int n6 = this.b.G[0].b();
                                                                                        f11.l.add((Object)f10);
                                                                                        f11.f = n6;
                                                                                        f10.k.add((Object)f11);
                                                                                        break block36;
                                                                                    }
                                                                                    if (arrc2[1].d == null) break block37;
                                                                                    f f12 = this.h(arrc2[1]);
                                                                                    if (f12 == null) break block35;
                                                                                    f f13 = this.i;
                                                                                    int n7 = -this.b.G[1].b();
                                                                                    f13.l.add((Object)f12);
                                                                                    f13.f = n7;
                                                                                    f12.k.add((Object)f13);
                                                                                    f5 = this.h;
                                                                                    f4 = this.i;
                                                                                    n2 = -this.e.g;
                                                                                    break block38;
                                                                                }
                                                                                if (d5 instanceof f.f.b.i.g || d5.K == null || d5.f((c.a)c.a.k).d != null) break block35;
                                                                                f.f.b.i.d d10 = this.b;
                                                                                f f14 = d10.K.d.h;
                                                                                this.b(this.h, f14, d10.p());
                                                                            }
                                                                            f5 = this.i;
                                                                            f4 = this.h;
                                                                            n2 = this.e.g;
                                                                        }
                                                                        this.b(f5, f4, n2);
                                                                        return;
                                                                    }
                                                                    if (this.d != a2) break block39;
                                                                    d4 = this.b;
                                                                    int n8 = d4.j;
                                                                    if (n8 == 2) break block40;
                                                                    if (n8 != 3) break block39;
                                                                    if (d4.k != 3) break block41;
                                                                    this.h.a = this;
                                                                    this.i.a = this;
                                                                    l l2 = d4.e;
                                                                    l2.h.a = this;
                                                                    l2.i.a = this;
                                                                    this.e.a = this;
                                                                    if (!d4.t()) break block42;
                                                                    this.e.l.add((Object)this.b.e.e);
                                                                    this.b.e.e.k.add((Object)this.e);
                                                                    l l3 = this.b.e;
                                                                    l3.e.a = this;
                                                                    this.e.l.add((Object)l3.h);
                                                                    this.e.l.add((Object)this.b.e.i);
                                                                    this.b.e.h.k.add((Object)this.e);
                                                                    list = this.b.e.i.k;
                                                                    break block43;
                                                                }
                                                                if (!this.b.s()) break block44;
                                                                this.b.e.e.l.add((Object)this.e);
                                                                list = this.e.k;
                                                                f3 = this.b.e.e;
                                                                break block45;
                                                            }
                                                            g2 = this.b.e.e;
                                                            break block46;
                                                        }
                                                        g g3 = d4.e.e;
                                                        this.e.l.add((Object)g3);
                                                        g3.k.add((Object)this.e);
                                                        this.b.e.h.k.add((Object)this.e);
                                                        this.b.e.i.k.add((Object)this.e);
                                                        g g4 = this.e;
                                                        g4.b = true;
                                                        g4.k.add((Object)this.h);
                                                        this.e.k.add((Object)this.i);
                                                        this.h.l.add((Object)this.e);
                                                        g2 = this.i;
                                                    }
                                                    list = g2.l;
                                                }
                                                f3 = this.e;
                                                break block45;
                                            }
                                            f.f.b.i.d d11 = d4.K;
                                            if (d11 == null) break block39;
                                            g g5 = d11.e.e;
                                            this.e.l.add((Object)g5);
                                            g5.k.add((Object)this.e);
                                            g g6 = this.e;
                                            g6.b = true;
                                            g6.k.add((Object)this.h);
                                            list = this.e.k;
                                            f3 = this.i;
                                        }
                                        list.add((Object)f3);
                                    }
                                    f.f.b.i.d d12 = this.b;
                                    c[] arrc4 = d12.G;
                                    if (arrc4[0].d == null || arrc4[1].d == null) break block47;
                                    if (!d12.s()) break block48;
                                    this.h.f = this.b.G[0].b();
                                    f2 = this.i;
                                    c2 = this.b.G[1];
                                }
                                f2.f = -c2.b();
                                return;
                            }
                            f f15 = this.h(this.b.G[0]);
                            f f16 = this.h(this.b.G[1]);
                            f15.k.add((Object)this);
                            if (f15.j) {
                                this.a((d)((Object)this));
                            }
                            f16.k.add((Object)this);
                            if (f16.j) {
                                this.a((d)((Object)this));
                            }
                            this.j = m.a.h;
                            return;
                        }
                        d2 = this.b;
                        arrc = d2.G;
                        if (arrc[0].d == null) break block49;
                        f f17 = this.h(arrc[0]);
                        if (f17 == null) break block35;
                        f f18 = this.h;
                        int n9 = this.b.G[0].b();
                        f18.l.add((Object)f17);
                        f18.f = n9;
                        f17.k.add((Object)f18);
                        break block50;
                    }
                    if (arrc[1].d == null) break block51;
                    f f19 = this.h(arrc[1]);
                    if (f19 != null) {
                        f f20 = this.i;
                        int n10 = -this.b.G[1].b();
                        f20.l.add((Object)f19);
                        f20.f = n10;
                        f19.k.add((Object)f20);
                        this.c(this.h, this.i, -1, this.e);
                        return;
                    }
                    break block35;
                }
                if (d2 instanceof f.f.b.i.g || (d3 = d2.K) == null) break block35;
                f f21 = d3.d.h;
                this.b(this.h, f21, d2.p());
            }
            this.c(this.i, this.h, 1, this.e);
        }
    }

    public void e() {
        f f2 = this.h;
        if (f2.j) {
            this.b.P = f2.g;
        }
    }

    public void f() {
        this.c = null;
        this.h.b();
        this.i.b();
        this.e.b();
        this.g = false;
    }

    public boolean k() {
        if (this.d == d.a.g) {
            return this.b.j == 0;
        }
        return true;
    }

    public final void m(int[] arrn, int n2, int n3, int n4, int n5, float f2, int n6) {
        int n7 = n3 - n2;
        int n8 = n5 - n4;
        if (n6 != -1) {
            if (n6 != 0) {
                if (n6 != 1) {
                    return;
                }
                int n9 = (int)(0.5f + f2 * (float)n7);
                arrn[0] = n7;
                arrn[1] = n9;
                return;
            }
            arrn[0] = (int)(0.5f + f2 * (float)n8);
            arrn[1] = n8;
            return;
        }
        int n10 = (int)(0.5f + f2 * (float)n8);
        int n11 = (int)(0.5f + (float)n7 / f2);
        if (n10 <= n7 && n8 <= n8) {
            arrn[0] = n10;
            arrn[1] = n8;
            return;
        }
        if (n7 <= n7 && n11 <= n8) {
            arrn[0] = n7;
            arrn[1] = n11;
        }
    }

    public void n() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("HorizontalRun ");
        stringBuilder.append(this.b.Y);
        return stringBuilder.toString();
    }
}

