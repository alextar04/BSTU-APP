/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  f.f.b.b
 *  f.f.b.i.a
 *  f.f.b.i.e
 *  f.f.b.i.f
 *  f.f.b.i.l.c
 *  f.f.b.i.l.f
 *  f.f.b.i.l.j
 *  f.f.b.i.l.l
 *  f.f.b.i.l.m
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package f.f.b.i;

import f.f.b.b;
import f.f.b.c;
import f.f.b.g;
import f.f.b.i.c;
import f.f.b.i.e;
import f.f.b.i.l.f;
import f.f.b.i.l.j;
import f.f.b.i.l.l;
import f.f.b.i.l.m;
import java.util.ArrayList;

public class d {
    public f.f.b.i.c A = new f.f.b.i.c(this, c.a.h);
    public f.f.b.i.c B = new f.f.b.i.c(this, c.a.i);
    public f.f.b.i.c C = new f.f.b.i.c(this, c.a.j);
    public f.f.b.i.c D = new f.f.b.i.c(this, c.a.l);
    public f.f.b.i.c E = new f.f.b.i.c(this, c.a.m);
    public f.f.b.i.c F;
    public f.f.b.i.c[] G;
    public ArrayList<f.f.b.i.c> H;
    public boolean[] I;
    public a[] J;
    public d K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public float V;
    public Object W;
    public int X;
    public String Y;
    public String Z;
    public boolean a = false;
    public int a0;
    public f.f.b.i.l.c b;
    public int b0;
    public f.f.b.i.l.c c;
    public float[] c0;
    public j d = new j(this);
    public d[] d0;
    public l e = new l(this);
    public d[] e0;
    public boolean[] f = new boolean[]{true, true};
    public int[] g = new int[]{0, 0, 0, 0};
    public int h = -1;
    public int i = -1;
    public int j = 0;
    public int k = 0;
    public int[] l = new int[2];
    public int m = 0;
    public int n = 0;
    public float o = 1.0f;
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = -1;
    public float t = 1.0f;
    public int[] u = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float v = 0.0f;
    public boolean w = false;
    public boolean x;
    public f.f.b.i.c y = new f.f.b.i.c(this, c.a.f);
    public f.f.b.i.c z = new f.f.b.i.c(this, c.a.g);

    public d() {
        ArrayList arrayList;
        f.f.b.i.c c2;
        this.F = c2 = new f.f.b.i.c(this, c.a.k);
        f.f.b.i.c[] arrc = new f.f.b.i.c[]{this.y, this.A, this.z, this.B, this.C, c2};
        this.G = arrc;
        this.H = arrayList = new ArrayList();
        this.I = new boolean[2];
        a a2 = a.e;
        a[] arra = new a[]{a2, a2};
        this.J = arra;
        this.K = null;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        this.X = 0;
        this.Y = null;
        this.Z = null;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = new float[]{-1.0f, -1.0f};
        this.d0 = new d[]{null, null};
        this.e0 = new d[]{null, null};
        arrayList.add((Object)this.y);
        this.H.add((Object)this.z);
        this.H.add((Object)this.A);
        this.H.add((Object)this.B);
        this.H.add((Object)this.D);
        this.H.add((Object)this.E);
        this.H.add((Object)this.F);
        this.H.add((Object)this.C);
    }

    public void A(a a2) {
        this.J[1] = a2;
    }

    public void B(int n2) {
        this.L = n2;
        int n3 = this.S;
        if (n2 < n3) {
            this.L = n3;
        }
    }

    public void C(boolean bl, boolean bl2) {
        a a2 = a.e;
        j j2 = this.d;
        boolean bl3 = bl & j2.g;
        l l2 = this.e;
        boolean bl4 = bl2 & l2.g;
        int n2 = j2.h.g;
        int n3 = l2.h.g;
        int n4 = j2.i.g;
        int n5 = l2.i.g;
        int n6 = n4 - n2;
        int n7 = n5 - n3;
        if (n6 < 0 || n7 < 0 || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE) {
            n4 = 0;
            n5 = 0;
            n2 = 0;
            n3 = 0;
        }
        int n8 = n4 - n2;
        int n9 = n5 - n3;
        if (bl3) {
            this.P = n2;
        }
        if (bl4) {
            this.Q = n3;
        }
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (bl3) {
            int n10;
            if (this.J[0] == a2 && n8 < (n10 = this.L)) {
                n8 = n10;
            }
            this.L = n8;
            int n11 = this.S;
            if (n8 < n11) {
                this.L = n11;
            }
        }
        if (bl4) {
            int n12;
            if (this.J[1] == a2 && n9 < (n12 = this.M)) {
                n9 = n12;
            }
            this.M = n9;
            int n13 = this.T;
            if (n9 < n13) {
                this.M = n13;
            }
        }
    }

    public void D(f.f.b.d d2) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = d2.o(this.y);
        int n7 = d2.o(this.z);
        int n8 = d2.o(this.A);
        int n9 = d2.o(this.B);
        j j2 = this.d;
        f f2 = j2.h;
        if (f2.j) {
            f f3 = j2.i;
            if (f3.j) {
                n6 = f2.g;
                n8 = f3.g;
            }
        }
        l l2 = this.e;
        f f4 = l2.h;
        if (f4.j) {
            f f5 = l2.i;
            if (f5.j) {
                n7 = f4.g;
                n9 = f5.g;
            }
        }
        int n10 = n8 - n6;
        int n11 = n9 - n7;
        if (n10 < 0 || n11 < 0 || n6 == Integer.MIN_VALUE || n6 == Integer.MAX_VALUE || n7 == Integer.MIN_VALUE || n7 == Integer.MAX_VALUE || n8 == Integer.MIN_VALUE || n8 == Integer.MAX_VALUE || n9 == Integer.MIN_VALUE || n9 == Integer.MAX_VALUE) {
            n9 = 0;
            n6 = 0;
            n7 = 0;
            n8 = 0;
        }
        a a2 = a.e;
        int n12 = n8 - n6;
        int n13 = n9 - n7;
        this.P = n6;
        this.Q = n7;
        if (this.X == 8) {
            this.L = 0;
            this.M = 0;
            return;
        }
        if (this.J[0] == a2 && n12 < (n2 = this.L)) {
            n12 = n2;
        }
        if (this.J[1] == a2 && n13 < (n4 = this.M)) {
            n13 = n4;
        }
        this.L = n12;
        this.M = n13;
        int n14 = this.T;
        if (n13 < n14) {
            this.M = n14;
        }
        if ((n5 = this.L) < (n3 = this.S)) {
            this.L = n3;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b(f.f.b.d var1_1) {
        block68 : {
            block67 : {
                block65 : {
                    block66 : {
                        block63 : {
                            block64 : {
                                block62 : {
                                    block61 : {
                                        block60 : {
                                            block58 : {
                                                block59 : {
                                                    block46 : {
                                                        block54 : {
                                                            block57 : {
                                                                block47 : {
                                                                    block56 : {
                                                                        block55 : {
                                                                            block51 : {
                                                                                block53 : {
                                                                                    block52 : {
                                                                                        block50 : {
                                                                                            block49 : {
                                                                                                block48 : {
                                                                                                    var2_2 = this;
                                                                                                    var3_3 = a.f;
                                                                                                    var4_4 = a.g;
                                                                                                    var5_5 = var1_1.l(var2_2.y);
                                                                                                    var6_6 = var1_1.l(var2_2.A);
                                                                                                    var7_7 = var1_1.l(var2_2.z);
                                                                                                    var8_8 = var1_1.l(var2_2.B);
                                                                                                    var9_9 = var1_1.l(var2_2.C);
                                                                                                    var10_10 = var2_2.d;
                                                                                                    var11_11 = var10_10.h;
                                                                                                    if (var11_11.j && var10_10.i.j) {
                                                                                                        var161_12 = var2_2.e;
                                                                                                        if (var161_12.h.j && var161_12.i.j) {
                                                                                                            var1_1.e(var5_5, var11_11.g);
                                                                                                            var1_1.e(var6_6, var2_2.d.i.g);
                                                                                                            var1_1.e(var7_7, var2_2.e.h.g);
                                                                                                            var1_1.e(var8_8, var2_2.e.i.g);
                                                                                                            var1_1.e(var9_9, var2_2.e.k.g);
                                                                                                            var162_13 = var2_2.K;
                                                                                                            if (var162_13 == null) return;
                                                                                                            var163_14 = var162_13 != null && var162_13.J[0] == var3_3;
                                                                                                            var164_15 = var2_2.K;
                                                                                                            var165_16 = var164_15 != null && var164_15.J[1] == var3_3;
                                                                                                            if (var163_14 && var2_2.f[0] && !this.s()) {
                                                                                                                var1_1.f(var1_1.l(var2_2.K.A), var6_6, 0, 8);
                                                                                                            }
                                                                                                            if (var165_16 == false) return;
                                                                                                            if (var2_2.f[1] == false) return;
                                                                                                            if (this.t() != false) return;
                                                                                                            var1_1.f(var1_1.l(var2_2.K.B), var8_8, 0, 8);
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    if ((var12_17 = var2_2.K) != null) {
                                                                                                        var156_18 = var12_17 != null && var12_17.J[0] == var3_3;
                                                                                                        var157_19 = var2_2.K;
                                                                                                        var158_20 = var157_19 != null && var157_19.J[1] == var3_3;
                                                                                                        if (var2_2.r(0)) {
                                                                                                            ((e)var2_2.K).F(var2_2, 0);
                                                                                                            var159_21 = true;
                                                                                                        } else {
                                                                                                            var159_21 = this.s();
                                                                                                        }
                                                                                                        if (var2_2.r(1)) {
                                                                                                            ((e)var2_2.K).F(var2_2, 1);
                                                                                                            var160_22 = true;
                                                                                                        } else {
                                                                                                            var160_22 = this.t();
                                                                                                        }
                                                                                                        if (!var159_21 && var156_18 && var2_2.X != 8 && var2_2.y.d == null && var2_2.A.d == null) {
                                                                                                            var1_1.f(var1_1.l(var2_2.K.A), var6_6, 0, 1);
                                                                                                        }
                                                                                                        if (!var160_22 && var158_20 && var2_2.X != 8 && var2_2.z.d == null && var2_2.B.d == null && var2_2.C == null) {
                                                                                                            var1_1.f(var1_1.l(var2_2.K.B), var8_8, 0, 1);
                                                                                                        }
                                                                                                        var14_23 = var156_18;
                                                                                                        var13_24 = var158_20;
                                                                                                        var16_25 = var159_21;
                                                                                                        var15_26 = var160_22;
                                                                                                    } else {
                                                                                                        var13_24 = false;
                                                                                                        var14_23 = false;
                                                                                                        var15_26 = false;
                                                                                                        var16_25 = false;
                                                                                                    }
                                                                                                    var17_27 = var2_2.L;
                                                                                                    var18_28 = var2_2.S;
                                                                                                    if (var17_27 < var18_28) {
                                                                                                        var17_27 = var18_28;
                                                                                                    }
                                                                                                    if ((var19_29 = var2_2.M) < (var20_30 = var2_2.T)) {
                                                                                                        var19_29 = var20_30;
                                                                                                    }
                                                                                                    var21_31 = var2_2.J[0] != var4_4;
                                                                                                    var22_32 = var2_2.J[1] != var4_4;
                                                                                                    var2_2.s = var2_2.O;
                                                                                                    var2_2.t = var23_33 = var2_2.N;
                                                                                                    var24_34 = var2_2.j;
                                                                                                    var25_35 = var2_2.k;
                                                                                                    var26_36 = var23_33 FCMPL 0.0f;
                                                                                                    var27_37 = var17_27;
                                                                                                    if (var26_36 <= 0 || var2_2.X == 8) break block46;
                                                                                                    if (var2_2.J[0] == var4_4 && var24_34 == 0) {
                                                                                                        var24_34 = 3;
                                                                                                    }
                                                                                                    if (var2_2.J[1] == var4_4 && var25_35 == 0) {
                                                                                                        var25_35 = 3;
                                                                                                    }
                                                                                                    if ((var149_38 = var2_2.J)[0] != var4_4 || var149_38[1] != var4_4 || var24_34 != 3 || var25_35 != 3) break block47;
                                                                                                    if (var2_2.s == -1) {
                                                                                                        if (var21_31 && !var22_32) {
                                                                                                            var2_2.s = 0;
                                                                                                        } else if (!var21_31 && var22_32) {
                                                                                                            var2_2.s = 1;
                                                                                                            if (var2_2.O == -1) {
                                                                                                                var2_2.t = 1.0f / var2_2.t;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (var2_2.s != 0 || var2_2.z.d() && var2_2.B.d()) break block48;
                                                                                                    var155_39 = 1;
                                                                                                    break block49;
                                                                                                }
                                                                                                if (var2_2.s != 1 || var2_2.y.d() && var2_2.A.d()) break block50;
                                                                                                var155_39 = 0;
                                                                                            }
                                                                                            var2_2.s = var155_39;
                                                                                        }
                                                                                        if (var2_2.s != -1 || var2_2.z.d() && var2_2.B.d() && var2_2.y.d() && var2_2.A.d()) break block51;
                                                                                        if (!var2_2.z.d() || !var2_2.B.d()) break block52;
                                                                                        var154_40 = 0;
                                                                                        break block53;
                                                                                    }
                                                                                    if (!var2_2.y.d() || !var2_2.A.d()) break block51;
                                                                                    var2_2.t = 1.0f / var2_2.t;
                                                                                    var154_40 = 1;
                                                                                }
                                                                                var2_2.s = var154_40;
                                                                            }
                                                                            if (var2_2.s != -1) break block54;
                                                                            if (var2_2.m <= 0 || var2_2.p != 0) break block55;
                                                                            var153_41 = 0;
                                                                            break block56;
                                                                        }
                                                                        if (var2_2.m != 0 || var2_2.p <= 0) break block54;
                                                                        var2_2.t = 1.0f / var2_2.t;
                                                                        var153_41 = 1;
                                                                    }
                                                                    var2_2.s = var153_41;
                                                                    break block54;
                                                                }
                                                                var150_42 = var2_2.J;
                                                                if (var150_42[0] != var4_4 || var24_34 != 3) break block57;
                                                                var2_2.s = 0;
                                                                var151_43 = (int)(var2_2.t * (float)var2_2.M);
                                                                var152_44 = var150_42[1];
                                                                var28_45 = var19_29;
                                                                if (var152_44 != var4_4) {
                                                                    var32_46 = var151_43;
                                                                    var29_47 = var25_35;
                                                                    var30_48 = 4;
                                                                    var31_49 = false;
                                                                } else {
                                                                    var32_46 = var151_43;
                                                                    var31_49 = true;
                                                                    var29_47 = var25_35;
                                                                    var30_48 = var24_34;
                                                                }
                                                                break block58;
                                                            }
                                                            if (var2_2.J[1] != var4_4 || var25_35 != 3) break block54;
                                                            var2_2.s = 1;
                                                            if (var2_2.O == -1) {
                                                                var2_2.t = 1.0f / var2_2.t;
                                                            }
                                                            var19_29 = (int)(var2_2.t * (float)var2_2.L);
                                                            if (var2_2.J[0] == var4_4) break block54;
                                                            var28_45 = var19_29;
                                                            var30_48 = var24_34;
                                                            var31_49 = false;
                                                            var29_47 = 4;
                                                            break block59;
                                                        }
                                                        var28_45 = var19_29;
                                                        var29_47 = var25_35;
                                                        var30_48 = var24_34;
                                                        var32_46 = var27_37;
                                                        var31_49 = true;
                                                        break block58;
                                                    }
                                                    var28_45 = var19_29;
                                                    var29_47 = var25_35;
                                                    var30_48 = var24_34;
                                                    var31_49 = false;
                                                }
                                                var32_46 = var27_37;
                                            }
                                            var33_50 = var2_2.l;
                                            var33_50[0] = var30_48;
                                            var33_50[1] = var29_47;
                                            if (!var31_49) break block60;
                                            var148_51 = var2_2.s;
                                            var34_52 = -1;
                                            if (var148_51 != 0 && var148_51 != var34_52) break block61;
                                            var35_53 = true;
                                            break block62;
                                        }
                                        var34_52 = -1;
                                    }
                                    var35_53 = false;
                                }
                                var36_54 = var2_2.J[0] == var3_3 && var2_2 instanceof e != false;
                                var37_55 = var36_54 != false ? 0 : var32_46;
                                var38_56 = true ^ var2_2.F.d();
                                var39_57 = var2_2.I;
                                var40_58 = var39_57[0];
                                var41_59 = var39_57[1];
                                if (var2_2.h == 2) break block63;
                                var127_60 = var2_2.d;
                                var128_61 = var127_60.h;
                                if (!var128_61.j || !var127_60.i.j) break block64;
                                var1_1.e(var5_5, var128_61.g);
                                var1_1.e(var6_6, var2_2.d.i.g);
                                if (var2_2.K != null && var14_23 && var2_2.f[0] && !this.s()) {
                                    var1_1.f(var1_1.l(var2_2.K.A), var6_6, 0, 8);
                                }
                                var42_62 = var8_8;
                                var43_63 = var7_7;
                                var44_64 = var6_6;
                                var45_65 = var5_5;
                                var46_66 = var3_3;
                                var47_67 = var9_9;
                                break block65;
                            }
                            var129_68 = var2_2.K;
                            var130_69 = var129_68 != null ? var1_1.l(var129_68.A) : null;
                            var131_70 = var2_2.K;
                            var132_71 = var131_70 != null ? var1_1.l(var131_70.y) : null;
                            var134_72 = var2_2.f[0];
                            var135_73 = var2_2.J[0];
                            var136_74 = var2_2.y;
                            var137_75 = var2_2.A;
                            var138_76 = var2_2.P;
                            var139_77 = var2_2.S;
                            var140_78 = var2_2.u[0];
                            var47_67 = var9_9;
                            var141_79 = var2_2.U;
                            var142_80 = var2_2.m;
                            var143_81 = var2_2.n;
                            var144_82 = var2_2.o;
                            var42_62 = var8_8;
                            var43_63 = var7_7;
                            var145_83 = var14_23;
                            var44_64 = var6_6;
                            var146_84 = var13_24;
                            var45_65 = var5_5;
                            var147_85 = var132_71;
                            var46_66 = var3_3;
                            this.d(var1_1, true, var145_83, var146_84, var134_72, var147_85, var130_69, var135_73, var36_54, var136_74, var137_75, var138_76, var37_55, var139_77, var140_78, var141_79, var35_53, var16_25, var15_26, var40_58, var30_48, var29_47, var142_80, var143_81, var144_82, var38_56);
                            break block66;
                        }
                        var42_62 = var8_8;
                        var43_63 = var7_7;
                        var44_64 = var6_6;
                        var45_65 = var5_5;
                        var46_66 = var3_3;
                        var47_67 = var9_9;
                    }
                    var2_2 = this;
                }
                var48_86 = var2_2.e;
                var49_87 = var48_86.h;
                if (var49_87.j && var48_86.i.j) {
                    var121_88 = var49_87.g;
                    var50_89 = var1_1;
                    var53_90 = var43_63;
                    var50_89.e(var53_90, var121_88);
                    var122_91 = var2_2.e.i.g;
                    var52_92 = var42_62;
                    var50_89.e(var52_92, var122_91);
                    var123_93 = var2_2.e.k.g;
                    var51_94 = var47_67;
                    var50_89.e(var51_94, var123_93);
                    var124_95 = var2_2.K;
                    if (var124_95 != null && !var15_26 && var13_24) {
                        var125_96 = var2_2.f;
                        var55_97 = true;
                        if (var125_96[var55_97]) {
                            var126_98 = var50_89.l(var124_95.B);
                            var54_99 = 8;
                            var50_89.f(var126_98, var52_92, 0, var54_99);
                        } else {
                            var54_99 = 8;
                        }
                    } else {
                        var54_99 = 8;
                        var55_97 = true;
                    }
                    var56_100 = false;
                } else {
                    var50_89 = var1_1;
                    var51_94 = var47_67;
                    var52_92 = var42_62;
                    var53_90 = var43_63;
                    var54_99 = 8;
                    var56_100 = var55_97 = true;
                }
                var57_101 = var2_2.i == 2 ? false : var56_100;
                if (!var57_101) break block67;
                var94_102 = var2_2.J[var55_97] == var46_66 && var2_2 instanceof e != false ? var55_97 : false;
                if (var94_102) {
                    var28_45 = 0;
                }
                var95_104 = var31_49 != false && ((var120_103 = var2_2.s) == var55_97 || var120_103 == BADBOOL -1) ? var55_97 : false;
                var96_105 = var2_2.K;
                var97_106 = var96_105 != null ? var50_89.l(var96_105.B) : null;
                var98_107 = var2_2.K;
                var99_108 = null;
                if (var98_107 != null) {
                    var99_108 = var50_89.l(var98_107.z);
                }
                if (var2_2.R <= 0 && var2_2.X != var54_99) ** GOTO lbl291
                var50_89.d(var51_94, var53_90, var2_2.R, var54_99);
                var101_109 = var2_2.C.d;
                if (var101_109 != null) {
                    var50_89.d(var51_94, var50_89.l(var101_109), 0, var54_99);
                    if (var13_24) {
                        var50_89.f(var97_106, var50_89.l(var2_2.B), 0, 5);
                    }
                    var102_110 = false;
                } else {
                    if (var2_2.X == var54_99) {
                        var50_89.d(var51_94, var53_90, 0, var54_99);
                    }
lbl291: // 4 sources:
                    var102_110 = var38_56;
                }
                var103_111 = var2_2.f[var55_97];
                var104_112 = var2_2.J[var55_97];
                var105_113 = var2_2.z;
                var106_114 = var2_2.B;
                var107_115 = var2_2.Q;
                var108_116 = var2_2.T;
                var109_117 = var2_2.u[var55_97];
                var110_118 = var2_2.V;
                var111_119 = var2_2.p;
                var112_120 = var2_2.q;
                var113_121 = var2_2.r;
                var114_122 = var97_106;
                var115_123 = var13_24;
                var116_124 = var14_23;
                var58_125 = var52_92;
                var117_126 = var99_108;
                var59_127 = var53_90;
                this.d(var1_1, false, var115_123, var116_124, var103_111, var117_126, var114_122, var104_112, var94_102, var105_113, var106_114, var107_115, var28_45, var108_116, var109_117, var110_118, var95_104, var15_26, var16_25, var41_59, var29_47, var30_48, var111_119, var112_120, var113_121, var102_110);
                break block68;
            }
            var58_125 = var52_92;
            var59_127 = var53_90;
        }
        if (var31_49) {
            var86_128 = 8;
            var60_129 = this;
            var87_130 = var60_129.s;
            var88_131 = var60_129.t;
            if (var87_130 == 1) {
                var89_132 = var1_1;
                var90_133 = var58_125;
                var91_134 = var59_127;
                var92_135 = var44_64;
                var93_136 = var45_65;
            } else {
                var86_128 = 8;
                var89_132 = var1_1;
                var90_133 = var44_64;
                var91_134 = var45_65;
                var92_135 = var58_125;
                var93_136 = var59_127;
            }
            var89_132.h(var90_133, var91_134, var92_135, var93_136, var88_131, var86_128);
        } else {
            var60_129 = this;
        }
        if (var60_129.F.d() == false) return;
        var61_137 = var60_129.F.d.b;
        var62_138 = (float)Math.toRadians((double)(90.0f + var60_129.v));
        var63_139 = var60_129.F.b();
        var64_140 = c.a.i;
        var65_141 = c.a.h;
        var66_142 = c.a.g;
        var67_143 = c.a.f;
        var68_144 = var1_1.l(var60_129.f(var67_143));
        var69_145 = var1_1.l(var60_129.f(var66_142));
        var70_146 = var1_1.l(var60_129.f(var65_141));
        var71_147 = var1_1.l(var60_129.f(var64_140));
        var72_148 = var1_1.l(var61_137.f(var67_143));
        var73_149 = var1_1.l(var61_137.f(var66_142));
        var74_150 = var1_1.l(var61_137.f(var65_141));
        var75_151 = var1_1.l(var61_137.f(var64_140));
        var76_152 = var1_1.m();
        var77_153 = var62_138;
        var79_154 = Math.sin((double)var77_153);
        var81_155 = var63_139;
        var76_152.g(var69_145, var71_147, var73_149, var75_151, (float)(var79_154 * var81_155));
        var1_1.c(var76_152);
        var84_156 = var1_1.m();
        var84_156.g(var68_144, var70_146, var72_148, var74_150, (float)(var81_155 * Math.cos((double)var77_153)));
        var1_1.c(var84_156);
    }

    public boolean c() {
        return this.X != 8;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void d(f.f.b.d var1_1, boolean var2_2, boolean var3_3, boolean var4_4, boolean var5_5, g var6_6, g var7_7, a var8_8, boolean var9_9, f.f.b.i.c var10_10, f.f.b.i.c var11_11, int var12_12, int var13_13, int var14_14, int var15_15, float var16_16, boolean var17_17, boolean var18_18, boolean var19_19, boolean var20_20, int var21_21, int var22_22, int var23_23, int var24_24, float var25_25, boolean var26_26) {
        block62 : {
            block60 : {
                block64 : {
                    block67 : {
                        block71 : {
                            block72 : {
                                block84 : {
                                    block85 : {
                                        block68 : {
                                            block74 : {
                                                block82 : {
                                                    block83 : {
                                                        block81 : {
                                                            block76 : {
                                                                block77 : {
                                                                    block80 : {
                                                                        block79 : {
                                                                            block78 : {
                                                                                block75 : {
                                                                                    block73 : {
                                                                                        block69 : {
                                                                                            block70 : {
                                                                                                block65 : {
                                                                                                    block66 : {
                                                                                                        block63 : {
                                                                                                            block61 : {
                                                                                                                block59 : {
                                                                                                                    block58 : {
                                                                                                                        block57 : {
                                                                                                                            block55 : {
                                                                                                                                block56 : {
                                                                                                                                    var27_27 = var23_23;
                                                                                                                                    var28_28 = var24_24;
                                                                                                                                    var29_29 = c.a.i;
                                                                                                                                    var30_30 = c.a.g;
                                                                                                                                    var31_31 = var1_1.l(var10_10);
                                                                                                                                    var32_32 = var1_1.l(var11_11);
                                                                                                                                    var33_33 = var1_1.l(var10_10.d);
                                                                                                                                    var34_34 = var1_1.l(var11_11.d);
                                                                                                                                    var35_35 = var10_10.d();
                                                                                                                                    var36_36 = var11_11.d();
                                                                                                                                    var37_37 = this.F.d();
                                                                                                                                    var38_38 = var36_36 != false ? var35_35 + 1 : var35_35;
                                                                                                                                    if (var37_37) {
                                                                                                                                        ++var38_38;
                                                                                                                                    }
                                                                                                                                    var39_39 = var38_38;
                                                                                                                                    if (var17_17) {
                                                                                                                                        var41_40 = var34_34;
                                                                                                                                        var40_41 = 3;
                                                                                                                                    } else {
                                                                                                                                        var40_41 = var21_21;
                                                                                                                                        var41_40 = var34_34;
                                                                                                                                    }
                                                                                                                                    var42_42 = var8_8.ordinal();
                                                                                                                                    var43_43 = var42_42 != 0 && var42_42 != 1 && var42_42 == 2 && var40_41 != 4;
                                                                                                                                    var44_44 = this.X;
                                                                                                                                    var45_45 = var43_43;
                                                                                                                                    if (var44_44 == 8) {
                                                                                                                                        var46_46 = 0;
                                                                                                                                        var45_45 = false;
                                                                                                                                    } else {
                                                                                                                                        var46_46 = var13_13;
                                                                                                                                    }
                                                                                                                                    if (!var26_26) break block55;
                                                                                                                                    if (var35_35 != 0 || var36_36 || var37_37) break block56;
                                                                                                                                    var1_1.e(var31_31, var12_12);
                                                                                                                                    ** GOTO lbl-1000
                                                                                                                                }
                                                                                                                                if (var35_35 != 0 && !var36_36) {
                                                                                                                                    var133_47 = var10_10.b();
                                                                                                                                    var47_48 = var37_37;
                                                                                                                                    var48_49 = 8;
                                                                                                                                    var1_1.d(var31_31, var33_33, var133_47, var48_49);
                                                                                                                                } else lbl-1000: // 2 sources:
                                                                                                                                {
                                                                                                                                    var47_48 = var37_37;
                                                                                                                                    var48_49 = 8;
                                                                                                                                }
                                                                                                                                break block57;
                                                                                                                            }
                                                                                                                            var47_48 = var37_37;
                                                                                                                            var48_49 = 8;
                                                                                                                        }
                                                                                                                        if (var45_45) break block58;
                                                                                                                        if (var9_9) {
                                                                                                                            var1_1.d(var32_32, var31_31, 0, 3);
                                                                                                                            if (var14_14 > 0) {
                                                                                                                                var1_1.f(var32_32, var31_31, var14_14, var48_49);
                                                                                                                            }
                                                                                                                            if (var15_15 < Integer.MAX_VALUE) {
                                                                                                                                var1_1.g(var32_32, var31_31, var15_15, var48_49);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            var1_1.d(var32_32, var31_31, var46_46, var48_49);
                                                                                                                        }
                                                                                                                        var49_50 = 3;
                                                                                                                        ** GOTO lbl94
                                                                                                                    }
                                                                                                                    var49_50 = 3;
                                                                                                                    if (var39_39 == 2 || var17_17 || var40_41 != 1 && var40_41 != 0) break block59;
                                                                                                                    var129_51 = Math.max((int)var27_27, (int)var46_46);
                                                                                                                    if (var28_28 > 0) {
                                                                                                                        var129_51 = Math.min((int)var28_28, (int)var129_51);
                                                                                                                    }
                                                                                                                    var1_1.d(var32_32, var31_31, var129_51, 8);
                                                                                                                    ** GOTO lbl110
                                                                                                                }
                                                                                                                if (var27_27 == -2) {
                                                                                                                    var27_27 = var46_46;
                                                                                                                }
                                                                                                                if (var28_28 == -2) {
                                                                                                                    var28_28 = var46_46;
                                                                                                                }
                                                                                                                if (var46_46 > 0 && var40_41 != 1) {
                                                                                                                    var46_46 = 0;
                                                                                                                }
                                                                                                                if (var27_27 > 0) {
                                                                                                                    var1_1.f(var32_32, var31_31, var27_27, 8);
                                                                                                                    var46_46 = Math.max((int)var46_46, (int)var27_27);
                                                                                                                }
                                                                                                                if (var28_28 > 0) {
                                                                                                                    var128_52 = var3_3 == false || var40_41 != 1;
                                                                                                                    if (var128_52) {
                                                                                                                        var50_53 = 8;
                                                                                                                        var1_1.g(var32_32, var31_31, var28_28, var50_53);
                                                                                                                    } else {
                                                                                                                        var50_53 = 8;
                                                                                                                    }
                                                                                                                    var46_46 = Math.min((int)var46_46, (int)var28_28);
                                                                                                                } else {
                                                                                                                    var50_53 = 8;
                                                                                                                }
                                                                                                                if (var40_41 == 1) {
                                                                                                                    if (var3_3) {
                                                                                                                        var1_1.d(var32_32, var31_31, var46_46, var50_53);
                                                                                                                    } else {
                                                                                                                        var1_1.d(var32_32, var31_31, var46_46, 5);
                                                                                                                        var1_1.g(var32_32, var31_31, var46_46, var50_53);
                                                                                                                    }
lbl94: // 3 sources:
                                                                                                                    var52_54 = var5_5;
                                                                                                                    var51_55 = var27_27;
                                                                                                                } else if (var40_41 == 2) {
                                                                                                                    var119_56 = var10_10.c;
                                                                                                                    if (var119_56 != var30_30 && var119_56 != var29_29) {
                                                                                                                        var120_57 = var1_1.l(this.K.f(c.a.f));
                                                                                                                        var121_58 = this.K.f(c.a.h);
                                                                                                                    } else {
                                                                                                                        var120_57 = var1_1.l(this.K.f(var30_30));
                                                                                                                        var121_58 = this.K.f(var29_29);
                                                                                                                    }
                                                                                                                    var122_59 = var1_1.l(var121_58);
                                                                                                                    var123_60 = var120_57;
                                                                                                                    var124_61 = var1_1.m();
                                                                                                                    var124_61.d(var32_32, var31_31, var122_59, var123_60, var25_25);
                                                                                                                    var1_1.c(var124_61);
lbl110: // 2 sources:
                                                                                                                    var52_54 = var5_5;
                                                                                                                    var51_55 = var27_27;
                                                                                                                    var45_45 = false;
                                                                                                                } else {
                                                                                                                    var51_55 = var27_27;
                                                                                                                    var52_54 = true;
                                                                                                                }
                                                                                                                if (!var26_26) break block60;
                                                                                                                if (!var18_18) break block61;
                                                                                                                var53_62 = var6_6;
                                                                                                                var54_63 = var7_7;
                                                                                                                var55_64 = var32_32;
                                                                                                                var56_65 = var52_54;
                                                                                                                var57_66 = var39_39;
                                                                                                                var60_67 = 2;
                                                                                                                var58_68 = 1;
                                                                                                                var59_69 = var31_31;
                                                                                                                break block62;
                                                                                                            }
                                                                                                            if ((var35_35 != 0 || var36_36 || var47_48) && (var35_35 == 0 || var36_36)) break block63;
                                                                                                            var69_70 = var32_32;
                                                                                                            var70_71 = var52_54;
                                                                                                            var68_72 = var41_40;
                                                                                                            break block64;
                                                                                                        }
                                                                                                        if (var35_35 != 0 || !var36_36) break block65;
                                                                                                        var117_73 = -var11_11.b();
                                                                                                        var68_72 = var41_40;
                                                                                                        var1_1.d(var32_32, var68_72, var117_73, 8);
                                                                                                        if (!var3_3) break block66;
                                                                                                        var1_1.f(var31_31, var6_6, 0, 5);
                                                                                                        break block67;
                                                                                                    }
                                                                                                    var69_70 = var32_32;
                                                                                                    var70_71 = var52_54;
                                                                                                    break block64;
                                                                                                }
                                                                                                var68_72 = var41_40;
                                                                                                if (var35_35 == 0 || !var36_36) break block67;
                                                                                                var73_74 = var10_10.d.b;
                                                                                                var74_75 = var11_11.d.b;
                                                                                                var75_76 = this.K;
                                                                                                var76_77 = 6;
                                                                                                if (!var45_45) break block68;
                                                                                                if (var40_41 != 0) break block69;
                                                                                                if (var28_28 == 0 && var51_55 == 0) {
                                                                                                    var80_78 = 1;
                                                                                                    var83_79 = 8;
                                                                                                    var85_80 = 8;
                                                                                                    var79_81 = 0;
                                                                                                } else {
                                                                                                    var79_81 = 1;
                                                                                                    var80_78 = 0;
                                                                                                    var83_79 = 5;
                                                                                                    var85_80 = 5;
                                                                                                }
                                                                                                if (var73_74 instanceof f.f.b.i.a || var74_75 instanceof f.f.b.i.a) break block70;
                                                                                                var84_82 = var76_77;
                                                                                                var77_83 = 1;
                                                                                                var81_84 = 0;
                                                                                                break block71;
                                                                                            }
                                                                                            var82_85 = var83_79;
                                                                                            var77_83 = 1;
                                                                                            var81_84 = 0;
                                                                                            break block72;
                                                                                        }
                                                                                        if (var40_41 != 1) break block73;
                                                                                        var82_85 = 8;
                                                                                        var79_81 = 1;
                                                                                        var77_83 = 1;
                                                                                        var81_84 = 1;
                                                                                        var80_78 = 0;
                                                                                        break block72;
                                                                                    }
                                                                                    if (var40_41 != 3) break block74;
                                                                                    if (this.s != -1) break block75;
                                                                                    var84_82 = var19_19 ? (var3_3 ? 5 : 4) : 8;
                                                                                    var113_86 = 8;
                                                                                    var77_83 = 1;
                                                                                    break block76;
                                                                                }
                                                                                if (!var17_17) break block77;
                                                                                if (var22_22 == 2) break block78;
                                                                                var77_83 = 1;
                                                                                if (var22_22 == var77_83) break block79;
                                                                                var114_87 = 0;
                                                                                break block80;
                                                                            }
                                                                            var77_83 = 1;
                                                                        }
                                                                        var114_87 = var77_83;
                                                                    }
                                                                    if (var114_87 == 0) {
                                                                        var115_88 = 8;
                                                                        var116_89 = 5;
                                                                    } else {
                                                                        var115_88 = 5;
                                                                        var116_89 = 4;
                                                                    }
                                                                    var83_79 = var115_88;
                                                                    var85_80 = var116_89;
                                                                    var81_84 = var80_78 = (var79_81 = var77_83);
                                                                    var84_82 = var76_77;
                                                                    break block71;
                                                                }
                                                                var77_83 = 1;
                                                                if (var28_28 <= 0) break block81;
                                                                var84_82 = var76_77;
                                                                var113_86 = 5;
                                                            }
                                                            var83_79 = var113_86;
                                                            var81_84 = var80_78 = (var79_81 = var77_83);
                                                            var85_80 = 5;
                                                            break block71;
                                                        }
                                                        if (var28_28 != 0 || var51_55 != 0) break block82;
                                                        if (var19_19) break block83;
                                                        var81_84 = var80_78 = (var79_81 = var77_83);
                                                        var84_82 = var76_77;
                                                        var83_79 = 5;
                                                        var85_80 = 8;
                                                        break block71;
                                                    }
                                                    var82_85 = var73_74 != var75_76 && var74_75 != var75_76 ? 4 : 5;
                                                    var81_84 = var80_78 = (var79_81 = var77_83);
                                                    break block72;
                                                }
                                                var80_78 = var79_81 = (var78_90 = var77_83);
                                                break block84;
                                            }
                                            var77_83 = 1;
                                            var78_90 = 0;
                                            var79_81 = 0;
                                            break block85;
                                        }
                                        var79_81 = var78_90 = (var77_83 = 1);
                                    }
                                    var80_78 = 0;
                                }
                                var81_84 = var78_90;
                                var82_85 = 5;
                            }
                            var83_79 = var82_85;
                            var84_82 = var76_77;
                            var85_80 = 4;
                        }
                        if (var81_84 != 0 && var33_33 == var68_72 && var73_74 != var75_76) {
                            var86_91 = 0;
                            var81_84 = 0;
                        } else {
                            var86_91 = var77_83;
                        }
                        if (var79_81 != 0) {
                            var109_92 = this.X == 8 ? 4 : var84_82;
                            var110_93 = var10_10.b();
                            var111_94 = var11_11.b();
                            var87_95 = var73_74;
                            var70_71 = var52_54;
                            var92_96 = var40_41;
                            var94_97 = var74_75;
                            var93_98 = 4;
                            var89_99 = 1;
                            var112_100 = var68_72;
                            var90_101 = var33_33;
                            var88_102 = var75_76;
                            var91_103 = var32_32;
                            var95_104 = var31_31;
                            var1_1.b(var31_31, var33_33, var110_93, var16_16, var112_100, var32_32, var111_94, var109_92);
                        } else {
                            var87_95 = var73_74;
                            var88_102 = var75_76;
                            var89_99 = var77_83;
                            var90_101 = var33_33;
                            var91_103 = var32_32;
                            var92_96 = var40_41;
                            var70_71 = var52_54;
                            var93_98 = 4;
                            var94_97 = var74_75;
                            var95_104 = var31_31;
                        }
                        if (this.X == 8) {
                            return;
                        }
                        if (var81_84 != 0) {
                            var107_105 = var3_3 != false && var90_101 != var68_72 && var45_45 == false && (var87_95 instanceof f.f.b.i.a != false || var94_97 instanceof f.f.b.i.a != false) ? var76_77 : var83_79;
                            var1_1.f(var95_104, var90_101, var10_10.b(), var107_105);
                            var108_106 = -var11_11.b();
                            var69_70 = var91_103;
                            var1_1.g(var69_70, var68_72, var108_106, var107_105);
                            var83_79 = var107_105;
                        } else {
                            var69_70 = var91_103;
                        }
                        if (var3_3 && var20_20 && !(var87_95 instanceof f.f.b.i.a) && !(var94_97 instanceof f.f.b.i.a)) {
                            var97_108 = var96_107 = var76_77;
                            var98_109 = var89_99;
                        } else {
                            var96_107 = var83_79;
                            var97_108 = var85_80;
                            var98_109 = var86_91;
                        }
                        if (var98_109 != 0) {
                            if (var80_78 != 0 && (!var19_19 || var4_4)) {
                                var102_110 = var88_102;
                                if (var87_95 != var102_110 && var94_97 != var102_110) {
                                    var76_77 = var97_108;
                                }
                                if (var87_95 instanceof f.f.b.i.f || var94_97 instanceof f.f.b.i.f) {
                                    var76_77 = 5;
                                }
                                if (var87_95 instanceof f.f.b.i.a || var94_97 instanceof f.f.b.i.a) {
                                    var76_77 = 5;
                                }
                                var106_111 = var19_19 != false ? 5 : var76_77;
                                var97_108 = Math.max((int)var106_111, (int)var97_108);
                            } else {
                                var102_110 = var88_102;
                            }
                            var103_112 = var97_108;
                            if (var3_3) {
                                var103_112 = Math.min((int)var96_107, (int)var103_112);
                                if (var17_17 && !var19_19 && (var87_95 == var102_110 || var94_97 == var102_110)) {
                                    var103_112 = var93_98;
                                }
                            }
                            var1_1.d(var95_104, var90_101, var10_10.b(), var103_112);
                            var1_1.d(var69_70, var68_72, -var11_11.b(), var103_112);
                        }
                        if (var3_3) {
                            var100_113 = var90_101;
                            var101_114 = var6_6 == var100_113 ? var10_10.b() : 0;
                            if (var100_113 != var6_6) {
                                var1_1.f(var95_104, var6_6, var101_114, 5);
                            }
                        }
                        if (var3_3 && var45_45 && var14_14 == 0 && var51_55 == 0) {
                            var99_115 = var45_45 != false && var92_96 == 3 ? 8 : 5;
                            var1_1.f(var69_70, var95_104, 0, var99_115);
                        }
                        break block64;
                    }
                    var69_70 = var32_32;
                    var70_71 = var52_54;
                }
                if (var3_3 == false) return;
                if (var70_71 == false) return;
                if (var11_11.d != null) {
                    var72_116 = var11_11.b();
                    var71_117 = var7_7;
                } else {
                    var71_117 = var7_7;
                    var72_116 = 0;
                }
                if (var68_72 == var71_117) return;
                var1_1.f(var71_117, var69_70, var72_116, 5);
                return;
            }
            var53_62 = var6_6;
            var54_63 = var7_7;
            var55_64 = var32_32;
            var56_65 = var52_54;
            var57_66 = var39_39;
            var58_68 = 1;
            var59_69 = var31_31;
            var60_67 = 2;
        }
        if (var57_66 >= var60_67) return;
        if (var3_3 == false) return;
        if (var56_65 == false) return;
        var1_1.f(var59_69, var53_62, 0, 8);
        var61_118 = !var2_2 && this.C.d != null ? 0 : var58_68;
        if (!var2_2 && (var62_119 = this.C.d) != null) {
            var63_120 = var62_119.b;
            var61_118 = var63_120.N != 0.0f && (var65_122 = (var64_121 = var63_120.J)[0]) == (var66_123 = a.g) && var64_121[var58_68] == var66_123 ? var58_68 : 0;
        }
        if (var61_118 == 0) return;
        var1_1.f(var54_63, var55_64, 0, 8);
    }

    public void e(f.f.b.d d2) {
        d2.l(this.y);
        d2.l(this.z);
        d2.l(this.A);
        d2.l(this.B);
        if (this.R > 0) {
            d2.l(this.C);
        }
    }

    public f.f.b.i.c f(c.a a2) {
        switch (a2.ordinal()) {
            default: {
                throw new AssertionError((Object)a2.name());
            }
            case 0: {
                return null;
            }
            case 8: {
                return this.E;
            }
            case 7: {
                return this.D;
            }
            case 6: {
                return this.F;
            }
            case 5: {
                return this.C;
            }
            case 4: {
                return this.B;
            }
            case 3: {
                return this.A;
            }
            case 2: {
                return this.z;
            }
            case 1: 
        }
        return this.y;
    }

    public int g() {
        return this.q() + this.M;
    }

    public a h(int n2) {
        if (n2 == 0) {
            return this.j();
        }
        if (n2 == 1) {
            return this.n();
        }
        return null;
    }

    public int i() {
        if (this.X == 8) {
            return 0;
        }
        return this.M;
    }

    public a j() {
        return this.J[0];
    }

    public d k(int n2) {
        if (n2 == 0) {
            f.f.b.i.c c2 = this.A;
            f.f.b.i.c c3 = c2.d;
            if (c3 != null && c3.d == c2) {
                return c3.b;
            }
        } else if (n2 == 1) {
            f.f.b.i.c c4 = this.B;
            f.f.b.i.c c5 = c4.d;
            if (c5 != null && c5.d == c4) {
                return c5.b;
            }
        }
        return null;
    }

    public d l(int n2) {
        if (n2 == 0) {
            f.f.b.i.c c2 = this.y;
            f.f.b.i.c c3 = c2.d;
            if (c3 != null && c3.d == c2) {
                return c3.b;
            }
        } else if (n2 == 1) {
            f.f.b.i.c c4 = this.z;
            f.f.b.i.c c5 = c4.d;
            if (c5 != null && c5.d == c4) {
                return c5.b;
            }
        }
        return null;
    }

    public int m() {
        return this.p() + this.L;
    }

    public a n() {
        return this.J[1];
    }

    public int o() {
        if (this.X == 8) {
            return 0;
        }
        return this.L;
    }

    public int p() {
        d d2 = this.K;
        if (d2 != null && d2 instanceof e) {
            return ((e)d2).l0 + this.P;
        }
        return this.P;
    }

    public int q() {
        d d2 = this.K;
        if (d2 != null && d2 instanceof e) {
            return ((e)d2).m0 + this.Q;
        }
        return this.Q;
    }

    public final boolean r(int n2) {
        int n3 = n2 * 2;
        f.f.b.i.c[] arrc = this.G;
        if (arrc[n3].d != null && arrc[n3].d.d != arrc[n3]) {
            int n4 = n3 + 1;
            if (arrc[n4].d != null && arrc[n4].d.d == arrc[n4]) {
                return true;
            }
        }
        return false;
    }

    public boolean s() {
        block3 : {
            block2 : {
                f.f.b.i.c c2 = this.y;
                f.f.b.i.c c3 = c2.d;
                if (c3 != null && c3.d == c2) break block2;
                f.f.b.i.c c4 = this.A;
                f.f.b.i.c c5 = c4.d;
                if (c5 == null || c5.d != c4) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean t() {
        block3 : {
            block2 : {
                f.f.b.i.c c2 = this.z;
                f.f.b.i.c c3 = c2.d;
                if (c3 != null && c3.d == c2) break block2;
                f.f.b.i.c c4 = this.B;
                f.f.b.i.c c5 = c4.d;
                if (c5 == null || c5.d != c4) break block3;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.Z;
        String string2 = "";
        String string3 = string != null ? c.b.a.a.a.l((StringBuilder)c.b.a.a.a.c((String)"type: "), (String)this.Z, (String)" ") : string2;
        stringBuilder.append(string3);
        if (this.Y != null) {
            string2 = c.b.a.a.a.l((StringBuilder)c.b.a.a.a.c((String)"id: "), (String)this.Y, (String)" ");
        }
        stringBuilder.append(string2);
        stringBuilder.append("(");
        stringBuilder.append(this.P);
        stringBuilder.append(", ");
        stringBuilder.append(this.Q);
        stringBuilder.append(") - (");
        stringBuilder.append(this.L);
        stringBuilder.append(" x ");
        stringBuilder.append(this.M);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void u() {
        a a2;
        this.y.e();
        this.z.e();
        this.A.e();
        this.B.e();
        this.C.e();
        this.D.e();
        this.E.e();
        this.F.e();
        this.K = null;
        this.v = 0.0f;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0.5f;
        this.V = 0.5f;
        a[] arra = this.J;
        arra[0] = a2 = a.e;
        arra[1] = a2;
        this.W = null;
        this.X = 0;
        this.Z = null;
        this.a0 = 0;
        this.b0 = 0;
        float[] arrf = this.c0;
        arrf[0] = -1.0f;
        arrf[1] = -1.0f;
        this.h = -1;
        this.i = -1;
        int[] arrn = this.u;
        arrn[0] = Integer.MAX_VALUE;
        arrn[1] = Integer.MAX_VALUE;
        this.j = 0;
        this.k = 0;
        this.o = 1.0f;
        this.r = 1.0f;
        this.n = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.m = 0;
        this.p = 0;
        this.s = -1;
        this.t = 1.0f;
        boolean[] arrbl = this.f;
        arrbl[0] = true;
        arrbl[1] = true;
        boolean[] arrbl2 = this.I;
        arrbl2[0] = false;
        arrbl2[1] = false;
    }

    public void v(c c2) {
        this.y.f();
        this.z.f();
        this.A.f();
        this.B.f();
        this.C.f();
        this.F.f();
        this.D.f();
        this.E.f();
    }

    public void w(int n2) {
        this.M = n2;
        int n3 = this.T;
        if (n2 < n3) {
            this.M = n3;
        }
    }

    public void x(a a2) {
        this.J[0] = a2;
    }

    public void y(int n2) {
        if (n2 < 0) {
            n2 = 0;
        }
        this.T = n2;
    }

    public void z(int n2) {
        if (n2 < 0) {
            n2 = 0;
        }
        this.S = n2;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* synthetic */ a[] i;

        public static {
            a a2;
            e = new a();
            f = new a();
            g = new a();
            h = a2 = new a();
            a[] arra = new a[]{e, f, g, a2};
            i = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])i.clone();
        }
    }

}

