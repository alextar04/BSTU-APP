/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.a.b.a.a$a
 *  b.a.a.b.a.b
 *  b.a.a.b.d$a
 *  b.a.a.b.d$b
 *  b.a.a.b.d$c
 *  b.a.a.b.d$d
 *  b.a.a.b.d$e
 *  c.e.b.p
 *  c.e.b.w
 *  f.b.k.h
 *  g.a.c0
 *  h.i.f
 *  h.j.a
 *  h.m.a.l
 *  h.m.b.j
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  org.bson.types.ObjectId
 */
package b.a.a.b.a;

import b.a.a.b.a.a;
import b.a.a.b.a.b;
import b.a.a.b.a.c;
import b.a.a.b.a.d;
import b.a.a.b.a.f;
import b.a.a.b.a.g;
import b.a.a.b.d;
import b.a.a.b.e;
import c.e.b.j;
import c.e.b.p;
import c.e.b.w;
import c.e.b.z;
import f.b.k.h;
import g.a.c0;
import h.m.a.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/*
 * Exception performing whole class analysis.
 */
public final class a {
    public final j a;
    public final g b;

    public a(j j2, g g2) {
        h.m.b.j.e((Object)j2, (String)"gson");
        h.m.b.j.e((Object)g2, (String)"realmRoomInfoMapper");
        this.a = j2;
        this.b = g2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final b.a.a.b.c a(List<? extends b> var1_1) {
        h.m.b.j.e(var1_1, (String)"realmPoints");
        var2_2 = new ArrayList();
        var3_3 = new LinkedHashMap();
        var4_4 = new LinkedHashMap();
        var5_5 = var1_1.iterator();
        block18 : do {
            block51 : {
                block52 : {
                    block50 : {
                        var6_6 = var5_5.hasNext();
                        var7_7 = 1;
                        if (var6_6) {
                            var12_8 = (b)var5_5.next();
                            var13_9 = var12_8.m().d();
                            h.m.b.j.d((Object)var13_9, (String)"it._id.toString()");
                            var3_3.put((Object)var13_9, (Object)new e(var13_9, (float)var12_8.e(), (float)var12_8.k(), var12_8.b()));
                            var4_4.put((Object)var13_9, (Object)var12_8.n());
                            var16_10 = b.a.a.b.b.values();
                            var17_11 = var16_10.length;
                        } else {
                            var8_84 = new l[2];
                            var8_84[0] = a.g;
                            var8_84[var7_7] = a.h;
                            h.m.b.j.e((Object)var8_84, (String)"selectors");
                            var9_85 = new h.j.a(var8_84);
                            h.m.b.j.e((Object)var2_2, (String)"$this$sortedWith");
                            h.m.b.j.e((Object)var9_85, (String)"comparator");
                            if (var2_2.size() <= var7_7) {
                                var11_86 = h.i.f.c((Iterable)var2_2);
                                return new b.a.a.b.c((List<? extends b.a.a.b.d>)var11_86, (Map<String, e>)var3_3, (Map<String, ? extends List<String>>)var4_4);
                            }
                            var10_87 = var2_2.toArray(new Object[0]);
                            if (var10_87 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            h.m.b.j.e((Object)var10_87, (String)"$this$sortWith");
                            h.m.b.j.e((Object)var9_85, (String)"comparator");
                            if (var10_87.length > var7_7) {
                                Arrays.sort((Object[])var10_87, (Comparator)var9_85);
                            }
                            var11_86 = h.i.d(var10_87);
                            return new b.a.a.b.c((List<? extends b.a.a.b.d>)var11_86, (Map<String, e>)var3_3, (Map<String, ? extends List<String>>)var4_4);
                        }
                        for (var18_12 = 0; var18_12 < var17_11; ++var18_12) {
                            var93_74 = var16_10[var18_12];
                            var94_75 = var93_74.e == var12_8.d() ? var7_7 : 0;
                            if (!var94_75) continue;
                            var19_13 = var93_74;
                            break block50;
                        }
                        var19_13 = null;
                    }
                    if (var19_13 == null) continue;
                    var20_14 = var12_8.o().ordinal();
                    if (var20_14 != var7_7) {
                        if (var20_14 != 2) {
                            if (var20_14 != 5 && var20_14 != 6) {
                                switch (var20_14) {
                                    default: {
                                        continue block18;
                                    }
                                    case 10: 
                                    case 11: 
                                    case 12: {
                                        var84_65 = var12_8.m().d();
                                        h.m.b.j.d((Object)var84_65, (String)"it._id.toString()");
                                        var85_66 = (float)var12_8.h();
                                        var86_67 = (float)var12_8.e();
                                        var87_68 = (float)var12_8.k();
                                        var88_69 = var12_8.g();
                                        var89_70 = var12_8.b();
                                        var90_71 = var12_8.o().ordinal();
                                        var91_72 = var90_71 != 10 ? (var90_71 != 11 ? d.a.g : d.a.f) : d.a.e;
                                        var92_73 = var91_72;
                                        var66_48 = new /* Unavailable Anonymous Inner Class!! */;
                                        ** break;
                                    }
                                    case 8: 
                                    case 9: 
                                }
                                var75_56 = var12_8.m().d();
                                h.m.b.j.d((Object)var75_56, (String)"it._id.toString()");
                                var76_57 = (float)var12_8.h();
                                var77_58 = (float)var12_8.e();
                                var78_59 = (float)var12_8.k();
                                var79_60 = var12_8.g();
                                var80_61 = var12_8.b();
                                var81_62 = var12_8.o() == c.o ? d.a.f : d.a.e;
                                var82_63 = var81_62;
                                var83_64 = var12_8.a();
                                var66_48 = new /* Unavailable Anonymous Inner Class!! */;
                                ** break;
lbl78: // 2 sources:
                            } else {
                                var68_49 = var12_8.m().d();
                                h.m.b.j.d((Object)var68_49, (String)"it._id.toString()");
                                var69_50 = (float)var12_8.h();
                                var70_51 = (float)var12_8.e();
                                var71_52 = (float)var12_8.k();
                                var72_53 = var12_8.g();
                                var73_54 = var12_8.b();
                                var74_55 = var12_8.o() == c.k ? var7_7 : 0;
                                var66_48 = new /* Unavailable Anonymous Inner Class!! */;
                            }
                        } else {
                            var59_41 = var12_8.m().d();
                            h.m.b.j.d((Object)var59_41, (String)"it._id.toString()");
                            var60_42 = (float)var12_8.h();
                            var61_43 = (float)var12_8.e();
                            var62_44 = (float)var12_8.k();
                            var63_45 = var12_8.g();
                            var64_46 = var12_8.b();
                            var65_47 = var12_8.a();
                            var66_48 = new /* Unavailable Anonymous Inner Class!! */;
                        }
                        var2_2.add((Object)var66_48);
                        continue;
                    }
                    var21_15 = var12_8.m().d();
                    h.m.b.j.d((Object)var21_15, (String)"it._id.toString()");
                    var22_16 = (float)var12_8.h();
                    var23_17 = (float)var12_8.e();
                    var24_18 = (float)var12_8.k();
                    var25_19 = var12_8.g();
                    var26_20 = var12_8.b();
                    var27_21 = var12_8.a();
                    var28_22 = this.b;
                    var29_23 = this.a;
                    var30_24 = var12_8.f();
                    var31_25 = var30_24.length() > 0 ? var7_7 : 0;
                    if (!var31_25) {
                        var30_24 = null;
                    }
                    if (var30_24 == null) {
                        var30_24 = "{}";
                    }
                    var32_26 = f.class;
                    if (var29_23 == null) throw null;
                    var33_27 = new c.e.b.e0.a((Reader)new StringReader(var30_24));
                    var33_27.f = var34_28 = var29_23.g;
                    var33_27.f = var7_7;
                    try {
                        var33_27.T();
                        try {
                            var37_32 = var29_23.b(new c.e.b.d0.a<T>((Type)var32_26)).a(var33_27);
                            break block51;
                        }
                        catch (EOFException var35_30) {
                            var7_7 = 0;
                            break block52;
                        }
                    }
                    catch (AssertionError var52_77) {
                        var53_78 = new StringBuilder();
                        var53_78.append("AssertionError (GSON 2.8.6): ");
                        var53_78.append(var52_77.getMessage());
                        var56_79 = new AssertionError((Object)var53_78.toString());
                        var56_79.initCause((Throwable)var52_77);
                        throw var56_79;
                    }
                    catch (IOException var51_80) {
                        throw new w((Throwable)var51_80);
                    }
                    catch (IllegalStateException var50_81) {
                        throw new w((Throwable)var50_81);
                    }
                    catch (EOFException var35_31) {
                        // empty catch block
                    }
                }
                if (!var7_7) break;
                var37_32 = null;
            }
            var33_27.f = var34_28;
            if (var37_32 != null) {
                try {
                    if (var33_27.T() != c.e.b.e0.b.n) throw new p("JSON document was not fully consumed.");
                }
                catch (IOException var49_82) {
                    throw new p((Throwable)var49_82);
                }
                catch (c.e.b.e0.d var48_83) {
                    throw new w((Throwable)var48_83);
                }
            }
            if (var32_26 == Integer.TYPE) {
                var38_33 /* !! */  = Integer.class;
            } else if (var32_26 == Float.TYPE) {
                var38_33 /* !! */  = Float.class;
            } else if (var32_26 == Byte.TYPE) {
                var38_33 /* !! */  = Byte.class;
            } else if (var32_26 == Double.TYPE) {
                var38_33 /* !! */  = Double.class;
            } else if (var32_26 == Long.TYPE) {
                var38_33 /* !! */  = Long.class;
            } else if (var32_26 == Character.TYPE) {
                var38_33 /* !! */  = Character.class;
            } else if (var32_26 == Boolean.TYPE) {
                var38_33 /* !! */  = Boolean.class;
            } else if (var32_26 == Short.TYPE) {
                var38_33 /* !! */  = Short.class;
            } else {
                if (var32_26 == Void.TYPE) {
                    var32_26 = Void.class;
                }
                var38_33 /* !! */  = var32_26;
            }
            var39_34 = var38_33 /* !! */ .cast(var37_32);
            h.m.b.j.d((Object)var39_34, (String)"gson.fromJson(it.info.ta\u2026ealmRoomInfo::class.java)");
            var40_35 = (f)var39_34;
            if (var28_22 == null) throw null;
            h.m.b.j.e((Object)var40_35, (String)"realmRoomInfo");
            var41_36 = var40_35.a;
            var42_37 = new ArrayList(h.i.x(var41_36, 10));
            var43_38 = var41_36.iterator();
            while (var43_38.hasNext()) {
                if ((d)var43_38.next() == null) throw null;
                var42_37.add((Object)"null, 0");
            }
            var44_39 = new b.a.a.b.f(null, null, null, null, null, (List<String>)var42_37, null);
            var45_40 = new /* Unavailable Anonymous Inner Class!! */;
            var2_2.add((Object)var45_40);
        } while (true);
        try {
            throw new w((Throwable)var35_29);
        }
        catch (Throwable var36_76) {}
        var33_27.f = var34_28;
        throw var36_76;
    }
}

