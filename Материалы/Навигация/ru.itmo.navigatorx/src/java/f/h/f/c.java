/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 *  f.b.k.h
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.h.f;

import android.graphics.Path;
import android.util.Log;
import f.b.k.h;

public class c {
    public char a;
    public float[] b;

    public c(char c2, float[] arrf) {
        this.a = c2;
        this.b = arrf;
    }

    public c(c c2) {
        this.a = c2.a;
        float[] arrf = c2.b;
        this.b = h.i.D(arrf, 0, arrf.length);
    }

    public static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, boolean bl2) {
        double d2;
        double d3;
        double d4 = Math.toRadians((double)f8);
        double d5 = Math.cos((double)d4);
        double d6 = Math.sin((double)d4);
        double d7 = f2;
        double d8 = d7 * d5;
        double d9 = f3;
        double d10 = d8 + d9 * d6;
        double d11 = d7;
        double d12 = f6;
        double d13 = d10 / d12;
        double d14 = d6 * (double)(-f2) + d9 * d5;
        double d15 = f7;
        double d16 = d14 / d15;
        double d17 = d9;
        double d18 = d5 * (double)f4;
        double d19 = f5;
        double d20 = (d18 + d19 * d6) / d12;
        double d21 = (d6 * (double)(-f4) + d19 * d5) / d15;
        double d22 = d13 - d20;
        double d23 = d16 - d21;
        double d24 = (d13 + d20) / 2.0;
        double d25 = (d16 + d21) / 2.0;
        double d26 = d22 * d22 + d23 * d23;
        if (d26 == 0.0) {
            Log.w((String)"PathParser", (String)" Points are coincident");
            return;
        }
        double d27 = 1.0 / d26 - 0.25;
        if (d27 < 0.0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Points are too far apart ");
            stringBuilder.append(d26);
            Log.w((String)"PathParser", (String)stringBuilder.toString());
            float f9 = (float)(Math.sqrt((double)d26) / 1.99999);
            c.a(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl, bl2);
            return;
        }
        double d28 = Math.sqrt((double)d27);
        double d29 = d22 * d28;
        double d30 = d28 * d23;
        if (bl == bl2) {
            d2 = d24 - d30;
            d3 = d25 + d29;
        } else {
            d2 = d24 + d30;
            d3 = d25 - d29;
        }
        double d31 = Math.atan2((double)(d16 - d3), (double)(d13 - d2));
        double d32 = Math.atan2((double)(d21 - d3), (double)(d20 - d2)) - d31;
        double d33 = d32 DCMPL 0.0;
        boolean bl3 = d33 >= 0;
        if (bl2 != bl3) {
            d32 = d33 > 0 ? (d32 -= 6.283185307179586) : (d32 += 6.283185307179586);
        }
        double d34 = d2 * d12;
        double d35 = d3 * d15;
        double d36 = d34 * d5 - d35 * d6;
        double d37 = d34 * d6 + d35 * d5;
        int n2 = (int)Math.ceil((double)Math.abs((double)(d32 * 4.0 / 3.141592653589793)));
        double d38 = Math.cos((double)d4);
        double d39 = Math.sin((double)d4);
        double d40 = Math.cos((double)d31);
        double d41 = Math.sin((double)d31);
        double d42 = -d12;
        double d43 = d42 * d38;
        double d44 = d43 * d41;
        double d45 = d15 * d39;
        double d46 = d44 - d45 * d40;
        double d47 = d42 * d39;
        double d48 = d41 * d47;
        double d49 = d15 * d38;
        double d50 = d48 + d40 * d49;
        double d51 = d32 / (double)n2;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d52 = d31 + d51;
            double d53 = Math.sin((double)d52);
            double d54 = Math.cos((double)d52);
            double d55 = d36 + d54 * (d12 * d38);
            double d56 = d45 * d53;
            double d57 = d51;
            double d58 = d55 - d56;
            double d59 = d37 + d54 * (d12 * d39);
            double d60 = d49 * d53;
            double d61 = d36;
            double d62 = d60 + d59;
            double d63 = d43 * d53 - d45 * d54;
            double d64 = d53 * d47 + d54 * d49;
            double d65 = d52 - d31;
            double d66 = Math.tan((double)(d65 / 2.0));
            double d67 = Math.sin((double)d65) * (Math.sqrt((double)(4.0 + d66 * (d66 * 3.0))) - 1.0) / 3.0;
            double d68 = d11 + d46 * d67;
            double d69 = d17 + d50 * d67;
            double d70 = d67 * d63;
            double d71 = d47;
            double d72 = d58 - d70;
            double d73 = d67 * d64;
            double d74 = d38;
            double d75 = d62 - d73;
            int n3 = n2;
            double d76 = d12;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float)d68, (float)d69, (float)d72, (float)d75, (float)d58, (float)d62);
            d31 = d52;
            d38 = d74;
            d47 = d71;
            d50 = d64;
            n2 = n3;
            d12 = d76;
            d46 = d63;
            d11 = d58;
            d17 = d62;
            d51 = d57;
            d36 = d61;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void b(c[] var0, Path var1_1) {
        var2_2 = var0;
        var3_3 = 6;
        var4_4 = new float[var3_3];
        var6_6 = var5_5 = 109;
        var7_7 = 0;
        while (var7_7 < var2_2.length) {
            block20 : {
                var8_8 = var2_2[var7_7].a;
                var9_9 = var2_2[var7_7].b;
                var10_10 = var4_4[0];
                var11_11 = var4_4[1];
                var12_12 = var4_4[2];
                var13_13 = var4_4[3];
                var14_14 = var4_4[4];
                var15_15 = var4_4[5];
                switch (var8_8) {
                    default: {
                        ** break;
                    }
                    case 90: 
                    case 122: {
                        var1_1.close();
                        var1_1.moveTo(var14_14, var15_15);
                        var12_12 = var10_10 = var14_14;
                        var13_13 = var11_11 = var15_15;
                        ** break;
                    }
                    case 81: 
                    case 83: 
                    case 113: 
                    case 115: {
                        var16_16 = 4;
                        break;
                    }
                    case 72: 
                    case 86: 
                    case 104: 
                    case 118: {
                        var16_16 = 1;
                        break;
                    }
                    case 67: 
                    case 99: {
                        var16_16 = var3_3;
                        break;
                    }
                    case 65: 
                    case 97: {
                        var16_16 = 7;
                        break;
                    }
                }
                break block20;
lbl37: // 2 sources:
                var16_16 = 2;
            }
            var17_17 = var14_14;
            var18_18 = var15_15;
            var19_19 = var10_10;
            var20_20 = var11_11;
            var21_21 = 0;
            while (var21_21 < var9_9.length) {
                block42 : {
                    block44 : {
                        block21 : {
                            block45 : {
                                block22 : {
                                    block23 : {
                                        block24 : {
                                            block25 : {
                                                block26 : {
                                                    block38 : {
                                                        block43 : {
                                                            block39 : {
                                                                block27 : {
                                                                    block28 : {
                                                                        block29 : {
                                                                            block41 : {
                                                                                block30 : {
                                                                                    block31 : {
                                                                                        block32 : {
                                                                                            block33 : {
                                                                                                block34 : {
                                                                                                    block35 : {
                                                                                                        block40 : {
                                                                                                            block36 : {
                                                                                                                block37 : {
                                                                                                                    if (var8_8 == 65) break block21;
                                                                                                                    if (var8_8 == 67) break block22;
                                                                                                                    if (var8_8 == 72) break block23;
                                                                                                                    if (var8_8 == 81) break block24;
                                                                                                                    if (var8_8 == 86) break block25;
                                                                                                                    if (var8_8 == 97) break block26;
                                                                                                                    if (var8_8 == 99) break block27;
                                                                                                                    if (var8_8 == 104) break block28;
                                                                                                                    if (var8_8 == 113) break block29;
                                                                                                                    if (var8_8 == 118) break block30;
                                                                                                                    if (var8_8 == 76) break block31;
                                                                                                                    if (var8_8 == 77) break block32;
                                                                                                                    if (var8_8 == 83) break block33;
                                                                                                                    if (var8_8 == 84) break block34;
                                                                                                                    if (var8_8 == 108) break block35;
                                                                                                                    if (var8_8 == var5_5) break block36;
                                                                                                                    if (var8_8 == 115) break block37;
                                                                                                                    if (var8_8 == 116) {
                                                                                                                        if (var6_6 != 113 && var6_6 != 116 && var6_6 != 81 && var6_6 != 84) {
                                                                                                                            var170_168 = 0.0f;
                                                                                                                            var169_167 = 0.0f;
                                                                                                                        } else {
                                                                                                                            var169_167 = var19_19 - var12_12;
                                                                                                                            var170_168 = var20_20 - var13_13;
                                                                                                                        }
                                                                                                                        var171_169 = var21_21 + 0;
                                                                                                                        var172_170 = var9_9[var171_169];
                                                                                                                        var173_171 = var21_21 + 1;
                                                                                                                        var1_1.rQuadTo(var169_167, var170_168, var172_170, var9_9[var173_171]);
                                                                                                                        var174_172 = var169_167 + var19_19;
                                                                                                                        var175_173 = var170_168 + var20_20;
                                                                                                                        var19_19 += var9_9[var171_169];
                                                                                                                        var20_20 += var9_9[var173_171];
                                                                                                                        var13_13 = var175_173;
                                                                                                                        var12_12 = var174_172;
                                                                                                                    }
                                                                                                                    var26_26 = var21_21;
                                                                                                                    break block38;
                                                                                                                }
                                                                                                                if (var6_6 != 99 && var6_6 != 115 && var6_6 != 67 && var6_6 != 83) {
                                                                                                                    var158_156 = 0.0f;
                                                                                                                    var157_155 = 0.0f;
                                                                                                                } else {
                                                                                                                    var156_154 = var19_19 - var12_12;
                                                                                                                    var157_155 = var20_20 - var13_13;
                                                                                                                    var158_156 = var156_154;
                                                                                                                }
                                                                                                                var159_157 = var21_21 + 0;
                                                                                                                var160_158 = var9_9[var159_157];
                                                                                                                var161_159 = var21_21 + 1;
                                                                                                                var162_160 = var9_9[var161_159];
                                                                                                                var163_161 = var21_21 + 2;
                                                                                                                var164_162 = var9_9[var163_161];
                                                                                                                var165_163 = var21_21 + 3;
                                                                                                                var166_164 = var9_9[var165_163];
                                                                                                                var26_26 = var21_21;
                                                                                                                var167_165 = var157_155;
                                                                                                                var82_82 = var20_20;
                                                                                                                var168_166 = var19_19;
                                                                                                                var1_1.rCubicTo(var158_156, var167_165, var160_158, var162_160, var164_162, var166_164);
                                                                                                                var93_93 = var168_166 + var9_9[var159_157];
                                                                                                                var94_94 = var82_82 + var9_9[var161_159];
                                                                                                                var95_95 = var168_166 + var9_9[var163_161];
                                                                                                                var96_96 = var9_9[var165_163];
                                                                                                                break block39;
                                                                                                            }
                                                                                                            var26_26 = var21_21;
                                                                                                            var152_150 = var20_20;
                                                                                                            var153_151 = var19_19;
                                                                                                            var154_152 = var26_26 + 0;
                                                                                                            var19_19 = var153_151 + var9_9[var154_152];
                                                                                                            var155_153 = var26_26 + 1;
                                                                                                            var20_20 = var152_150 + var9_9[var155_153];
                                                                                                            if (var26_26 <= 0) break block40;
                                                                                                            var1_1.rLineTo(var9_9[var154_152], var9_9[var155_153]);
                                                                                                            break block38;
                                                                                                        }
                                                                                                        var1_1.rMoveTo(var9_9[var154_152], var9_9[var155_153]);
                                                                                                        var18_18 = var20_20;
                                                                                                        var17_17 = var19_19;
                                                                                                        ** GOTO lbl198
                                                                                                    }
                                                                                                    var26_26 = var21_21;
                                                                                                    var112_111 = var20_20;
                                                                                                    var148_146 = var19_19;
                                                                                                    var149_147 = var26_26 + 0;
                                                                                                    var150_148 = var9_9[var149_147];
                                                                                                    var151_149 = var26_26 + 1;
                                                                                                    var1_1.rLineTo(var150_148, var9_9[var151_149]);
                                                                                                    var19_19 = var148_146 + var9_9[var149_147];
                                                                                                    var115_113 = var9_9[var151_149];
                                                                                                    break block41;
                                                                                                }
                                                                                                var26_26 = var21_21;
                                                                                                var139_137 = var20_20;
                                                                                                var140_138 = var19_19;
                                                                                                if (var6_6 != 113 && var6_6 != 116 && var6_6 != 81 && var6_6 != 84) {
                                                                                                    var141_139 = var140_138;
                                                                                                    var142_140 = var139_137;
                                                                                                } else {
                                                                                                    var141_139 = var140_138 * 2.0f - var12_12;
                                                                                                    var142_140 = var139_137 * 2.0f - var13_13;
                                                                                                }
                                                                                                var143_141 = var26_26 + 0;
                                                                                                var144_142 = var9_9[var143_141];
                                                                                                var145_143 = var26_26 + 1;
                                                                                                var1_1.quadTo(var141_139, var142_140, var144_142, var9_9[var145_143]);
                                                                                                var146_144 = var9_9[var143_141];
                                                                                                var147_145 = var9_9[var145_143];
                                                                                                var13_13 = var142_140;
                                                                                                var12_12 = var141_139;
                                                                                                var29_29 = var9_9;
                                                                                                var30_30 = var8_8;
                                                                                                var31_31 = var7_7;
                                                                                                var19_19 = var146_144;
                                                                                                var20_20 = var147_145;
                                                                                                break block42;
                                                                                            }
                                                                                            var26_26 = var21_21;
                                                                                            var125_123 = var20_20;
                                                                                            var126_124 = var19_19;
                                                                                            if (var6_6 != 99 && var6_6 != 115 && var6_6 != 67 && var6_6 != 83) {
                                                                                                var129_127 = var126_124;
                                                                                                var128_126 = var125_123;
                                                                                            } else {
                                                                                                var127_125 = var126_124 * 2.0f - var12_12;
                                                                                                var128_126 = var125_123 * 2.0f - var13_13;
                                                                                                var129_127 = var127_125;
                                                                                            }
                                                                                            var130_128 = var26_26 + 0;
                                                                                            var131_129 = var9_9[var130_128];
                                                                                            var132_130 = var26_26 + 1;
                                                                                            var133_131 = var9_9[var132_130];
                                                                                            var134_132 = var26_26 + 2;
                                                                                            var135_133 = var9_9[var134_132];
                                                                                            var136_134 = var26_26 + 3;
                                                                                            var1_1.cubicTo(var129_127, var128_126, var131_129, var133_131, var135_133, var9_9[var136_134]);
                                                                                            var137_135 = var9_9[var130_128];
                                                                                            var138_136 = var9_9[var132_130];
                                                                                            var98_98 = var9_9[var134_132];
                                                                                            var97_97 = var9_9[var136_134];
                                                                                            var12_12 = var137_135;
                                                                                            var13_13 = var138_136;
                                                                                            break block43;
                                                                                        }
                                                                                        var26_26 = var21_21;
                                                                                        var121_119 = var26_26 + 0;
                                                                                        var122_120 = var9_9[var121_119];
                                                                                        var123_121 = var26_26 + 1;
                                                                                        var124_122 = var9_9[var123_121];
                                                                                        if (var26_26 > 0) {
                                                                                            var1_1.lineTo(var9_9[var121_119], var9_9[var123_121]);
                                                                                            var19_19 = var122_120;
                                                                                            var20_20 = var124_122;
                                                                                        } else {
                                                                                            var1_1.moveTo(var9_9[var121_119], var9_9[var123_121]);
                                                                                            var17_17 = var122_120;
                                                                                            var18_18 = var124_122;
lbl198: // 2 sources:
                                                                                            var19_19 = var17_17;
                                                                                            var20_20 = var18_18;
                                                                                        }
                                                                                        break block38;
                                                                                    }
                                                                                    var26_26 = var21_21;
                                                                                    var116_114 = var26_26 + 0;
                                                                                    var117_115 = var9_9[var116_114];
                                                                                    var118_116 = var26_26 + 1;
                                                                                    var1_1.lineTo(var117_115, var9_9[var118_116]);
                                                                                    var119_117 = var9_9[var116_114];
                                                                                    var120_118 = var9_9[var118_116];
                                                                                    var19_19 = var119_117;
                                                                                    var20_20 = var120_118;
                                                                                    break block38;
                                                                                }
                                                                                var26_26 = var21_21;
                                                                                var112_111 = var20_20;
                                                                                var114_112 = var26_26 + 0;
                                                                                var1_1.rLineTo(0.0f, var9_9[var114_112]);
                                                                                var115_113 = var9_9[var114_112];
                                                                            }
                                                                            var20_20 = var112_111 + var115_113;
                                                                            break block38;
                                                                        }
                                                                        var26_26 = var21_21;
                                                                        var82_82 = var20_20;
                                                                        var102_101 = var19_19;
                                                                        var103_102 = var26_26 + 0;
                                                                        var104_103 = var9_9[var103_102];
                                                                        var105_104 = var26_26 + 1;
                                                                        var106_105 = var9_9[var105_104];
                                                                        var107_106 = var26_26 + 2;
                                                                        var108_107 = var9_9[var107_106];
                                                                        var109_108 = var26_26 + 3;
                                                                        var1_1.rQuadTo(var104_103, var106_105, var108_107, var9_9[var109_108]);
                                                                        var93_93 = var102_101 + var9_9[var103_102];
                                                                        var94_94 = var82_82 + var9_9[var105_104];
                                                                        var110_109 = var102_101 + var9_9[var107_106];
                                                                        var111_110 = var9_9[var109_108];
                                                                        var95_95 = var110_109;
                                                                        var96_96 = var111_110;
                                                                        break block39;
                                                                    }
                                                                    var26_26 = var21_21;
                                                                    var100_99 = var19_19;
                                                                    var101_100 = var26_26 + 0;
                                                                    var1_1.rLineTo(var9_9[var101_100], 0.0f);
                                                                    var19_19 = var100_99 + var9_9[var101_100];
                                                                    break block38;
                                                                }
                                                                var26_26 = var21_21;
                                                                var82_82 = var20_20;
                                                                var83_83 = var19_19;
                                                                var84_84 = var9_9[var26_26 + 0];
                                                                var85_85 = var9_9[var26_26 + 1];
                                                                var86_86 = var26_26 + 2;
                                                                var87_87 = var9_9[var86_86];
                                                                var88_88 = var26_26 + 3;
                                                                var89_89 = var9_9[var88_88];
                                                                var90_90 = var26_26 + 4;
                                                                var91_91 = var9_9[var90_90];
                                                                var92_92 = var26_26 + 5;
                                                                var1_1.rCubicTo(var84_84, var85_85, var87_87, var89_89, var91_91, var9_9[var92_92]);
                                                                var93_93 = var83_83 + var9_9[var86_86];
                                                                var94_94 = var82_82 + var9_9[var88_88];
                                                                var95_95 = var83_83 + var9_9[var90_90];
                                                                var96_96 = var9_9[var92_92];
                                                            }
                                                            var97_97 = var82_82 + var96_96;
                                                            var12_12 = var93_93;
                                                            var13_13 = var94_94;
                                                            var98_98 = var95_95;
                                                        }
                                                        var19_19 = var98_98;
                                                        var20_20 = var97_97;
                                                    }
                                                    var29_29 = var9_9;
                                                    var30_30 = var8_8;
                                                    var31_31 = var7_7;
                                                    break block42;
                                                }
                                                var26_26 = var21_21;
                                                var70_70 = var20_20;
                                                var71_71 = var19_19;
                                                var72_72 = var26_26 + 5;
                                                var73_73 = var71_71 + var9_9[var72_72];
                                                var74_74 = var26_26 + 6;
                                                var75_75 = var70_70 + var9_9[var74_74];
                                                var76_76 = var9_9[var26_26 + 0];
                                                var77_77 = var9_9[var26_26 + 1];
                                                var78_78 = var9_9[var26_26 + 2];
                                                var79_79 = var9_9[var26_26 + 3] != 0.0f;
                                                var80_80 = var9_9[var26_26 + 4] != 0.0f;
                                                var29_29 = var9_9;
                                                var30_30 = var8_8;
                                                var81_81 = var79_79;
                                                var31_31 = var7_7;
                                                c.a(var1_1, var71_71, var70_70, var73_73, var75_75, var76_76, var77_77, var78_78, var81_81, var80_80);
                                                var19_19 = var71_71 + var29_29[var72_72];
                                                var20_20 = var70_70 + var29_29[var74_74];
                                                break block44;
                                            }
                                            var26_26 = var21_21;
                                            var68_68 = var19_19;
                                            var29_29 = var9_9;
                                            var30_30 = var8_8;
                                            var31_31 = var7_7;
                                            var69_69 = var26_26 + 0;
                                            var1_1.lineTo(var68_68, var29_29[var69_69]);
                                            var20_20 = var29_29[var69_69];
                                            break block42;
                                        }
                                        var26_26 = var21_21;
                                        var29_29 = var9_9;
                                        var30_30 = var8_8;
                                        var31_31 = var7_7;
                                        var59_59 = var26_26 + 0;
                                        var60_60 = var29_29[var59_59];
                                        var61_61 = var26_26 + 1;
                                        var62_62 = var29_29[var61_61];
                                        var63_63 = var26_26 + 2;
                                        var64_64 = var29_29[var63_63];
                                        var65_65 = var26_26 + 3;
                                        var1_1.quadTo(var60_60, var62_62, var64_64, var29_29[var65_65]);
                                        var54_54 = var29_29[var59_59];
                                        var56_56 = var29_29[var61_61];
                                        var66_66 = var29_29[var63_63];
                                        var67_67 = var29_29[var65_65];
                                        var19_19 = var66_66;
                                        var20_20 = var67_67;
                                        break block45;
                                    }
                                    var26_26 = var21_21;
                                    var57_57 = var20_20;
                                    var29_29 = var9_9;
                                    var30_30 = var8_8;
                                    var31_31 = var7_7;
                                    var58_58 = var26_26 + 0;
                                    var1_1.lineTo(var29_29[var58_58], var57_57);
                                    var19_19 = var29_29[var58_58];
                                    break block42;
                                }
                                var26_26 = var21_21;
                                var29_29 = var9_9;
                                var30_30 = var8_8;
                                var31_31 = var7_7;
                                var43_43 = var29_29[var26_26 + 0];
                                var44_44 = var29_29[var26_26 + 1];
                                var45_45 = var26_26 + 2;
                                var46_46 = var29_29[var45_45];
                                var47_47 = var26_26 + 3;
                                var48_48 = var29_29[var47_47];
                                var49_49 = var26_26 + 4;
                                var50_50 = var29_29[var49_49];
                                var51_51 = var26_26 + 5;
                                var1_1.cubicTo(var43_43, var44_44, var46_46, var48_48, var50_50, var29_29[var51_51]);
                                var52_52 = var29_29[var49_49];
                                var53_53 = var29_29[var51_51];
                                var54_54 = var29_29[var45_45];
                                var55_55 = var29_29[var47_47];
                                var19_19 = var52_52;
                                var20_20 = var53_53;
                                var56_56 = var55_55;
                            }
                            var12_12 = var54_54;
                            var13_13 = var56_56;
                            break block42;
                        }
                        var26_26 = var21_21;
                        var27_27 = var20_20;
                        var28_28 = var19_19;
                        var29_29 = var9_9;
                        var30_30 = var8_8;
                        var31_31 = var7_7;
                        var32_32 = var26_26 + 5;
                        var33_33 = var29_29[var32_32];
                        var34_34 = var26_26 + 6;
                        var35_35 = var29_29[var34_34];
                        var36_36 = var29_29[var26_26 + 0];
                        var37_37 = var29_29[var26_26 + 1];
                        var38_38 = var29_29[var26_26 + 2];
                        var39_39 = var29_29[var26_26 + 3] != 0.0f;
                        var40_40 = var29_29[var26_26 + 4] != 0.0f;
                        c.a(var1_1, var28_28, var27_27, var33_33, var35_35, var36_36, var37_37, var38_38, var39_39, var40_40);
                        var41_41 = var29_29[var32_32];
                        var42_42 = var29_29[var34_34];
                        var19_19 = var41_41;
                        var20_20 = var42_42;
                    }
                    var13_13 = var20_20;
                    var12_12 = var19_19;
                }
                var21_21 = var26_26 + var16_16;
                var8_8 = var6_6 = (int)var30_30;
                var9_9 = var29_29;
                var7_7 = var31_31;
                var5_5 = 109;
            }
            var22_22 = var20_20;
            var23_23 = var19_19;
            var24_24 = var7_7;
            var4_4[0] = var23_23;
            var4_4[1] = var22_22;
            var4_4[2] = var12_12;
            var4_4[3] = var13_13;
            var4_4[4] = var17_17;
            var4_4[5] = var18_18;
            var25_25 = var0[var24_24].a;
            var7_7 = var24_24 + 1;
            var3_3 = 6;
            var5_5 = 109;
            var6_6 = var25_25;
            var2_2 = var0;
        }
    }
}

