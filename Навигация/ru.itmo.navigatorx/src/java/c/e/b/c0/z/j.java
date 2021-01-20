/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.g;
import c.e.b.c0.o;
import c.e.b.c0.t;
import c.e.b.c0.z.i;
import c.e.b.c0.z.n;
import c.e.b.d;
import c.e.b.e0.c;
import c.e.b.w;
import c.e.b.z;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class j
implements a0 {
    public final g e;
    public final d f;
    public final o g;
    public final c.e.b.c0.z.d h;
    public final c.e.b.c0.a0.b i = c.e.b.c0.a0.b.a;

    public j(g g2, d d2, o o2, c.e.b.c0.z.d d3) {
        this.e = g2;
        this.f = d2;
        this.g = o2;
        this.h = d3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public <T> z<T> a(c.e.b.j var1_1, c.e.b.d0.a<T> var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_5 = Object.class;
        var6_6 = var2_2.a;
        if (!var5_5.isAssignableFrom(var6_6)) {
            return null;
        }
        var7_7 = var3_3.e.a(var2_2);
        var9_9 = new LinkedHashMap();
        if (var6_6.isInterface()) ** GOTO lbl15
        var10_13 = var2_2.b;
        var11_14 = var2_2;
        var12_15 = var6_6;
        block0 : do {
            block16 : {
                if (var12_15 != var5_5) break block16;
lbl15: // 2 sources:
                var86_10 = var9_9;
                var87_11 = var8_8;
                var88_12 = var7_7;
                var87_11(var88_12, (Map<String, b>)var86_10);
                return var87_11;
            }
            var13_16 = var12_15.getDeclaredFields();
            var14_17 = var13_16.length;
            var15_18 = 0;
            do {
                block19 : {
                    block21 : {
                        block17 : {
                            block20 : {
                                block18 : {
                                    if (var15_18 >= var14_17) break block17;
                                    var23_22 = var13_16[var15_18];
                                    var24_23 = var3_3.b(var23_22, true);
                                    var25_24 = var3_3.b(var23_22, false);
                                    if (var24_23 || var25_24) break block18;
                                    var30_29 = var15_18;
                                    var31_30 = var14_17;
                                    var43_41 = var13_16;
                                    var44_42 = var12_15;
                                    var45_43 = var11_14;
                                    var46_44 = var9_9;
                                    var47_45 = var8_8;
                                    var48_46 = var5_5;
                                    var49_47 = var7_7;
                                    var50_48 = var10_13;
                                    break block19;
                                }
                                var3_3.i.a((AccessibleObject)var23_22);
                                var26_25 = c.e.b.c0.a.g(var11_14.b, var12_15, var23_22.getGenericType());
                                var27_26 = (c.e.b.b0.b)var23_22.getAnnotation(c.e.b.b0.b.class);
                                if (var27_26 != null) break block20;
                                var85_82 = Collections.singletonList((Object)var3_3.f.a(var23_22));
                                var30_29 = var15_18;
                                ** GOTO lbl55
                            }
                            var28_27 = var27_26.value();
                            var29_28 = var27_26.alternate();
                            var30_29 = var15_18;
                            if (var29_28.length == 0) {
                                var85_82 = Collections.singletonList((Object)var28_27);
lbl55: // 2 sources:
                                var31_30 = var14_17;
                                var33_32 = true;
                                var38_36 = var85_82;
                            } else {
                                var31_30 = var14_17;
                                var32_31 = var29_28.length;
                                var33_32 = true;
                                var34_33 = new ArrayList(var32_31 + 1);
                                var34_33.add((Object)var28_27);
                                var36_34 = var29_28.length;
                                for (var37_35 = 0; var37_35 < var36_34; ++var37_35) {
                                    var83_81 = var36_34;
                                    var34_33.add((Object)var29_28[var37_35]);
                                    var36_34 = var83_81;
                                }
                                var38_36 = var34_33;
                            }
                            var39_37 = var38_36.size();
                            var40_38 = null;
                            var41_39 = 0;
                            break block21;
                        }
                        var16_19 = var12_15;
                        var17_20 = var11_14;
                        var21_21 = var7_7;
                        var11_14 = new c.e.b.d0.a<T>(c.e.b.c0.a.g(var17_20.b, var16_19, var16_19.getGenericSuperclass()));
                        var12_15 = var11_14.a;
                        var3_3 = this;
                        var4_4 = var1_1;
                        var7_7 = var21_21;
                        continue block0;
                    }
                    while (var41_39 < var39_37) {
                        var55_49 = var38_36.get(var41_39);
                        var56_50 = var5_5;
                        var57_51 = (String)var55_49;
                        var58_52 = var9_9;
                        if (var41_39 != 0) {
                            var24_23 = false;
                        }
                        var59_53 = new c.e.b.d0.a<T>(var26_25);
                        var60_54 = var40_38;
                        var61_55 = var59_53.a;
                        var62_56 = var41_39;
                        var63_57 = var61_55 instanceof Class != false && var61_55.isPrimitive() != false ? var33_32 : false;
                        var64_58 = (c.e.b.b0.a)var23_22.getAnnotation(c.e.b.b0.a.class);
                        if (var64_58 != null) {
                            var82_80 = var3_3.h;
                            var65_59 = var23_22;
                            var66_61 = var82_80.b(var3_3.e, var4_4, var59_53, var64_58);
                        } else {
                            var65_59 = var23_22;
                            var66_62 = null;
                        }
                        var67_65 = var66_63 != null ? var33_32 : false;
                        if (var66_63 == null) {
                            var66_64 = var4_4.b(var59_53);
                        }
                        var68_66 = var66_60;
                        var69_67 = var65_59;
                        var70_68 = var39_37;
                        var71_69 = var24_23;
                        var72_70 = var38_36;
                        var73_71 = var13_16;
                        var74_72 = var12_15;
                        var75_73 = var67_65;
                        var76_74 = var26_25;
                        var77_75 = var11_14;
                        var78_76 = var7_7;
                        var79_77 = var10_13;
                        var80_78 = var8_8;
                        var81_79 = new i(this, var57_51, var71_69, var25_24, var69_67, var75_73, (z)var68_66, var1_1, var59_53, var63_57);
                        var40_38 = var58_52.put((Object)var57_51, (Object)var81_79);
                        if (var60_54 != null) {
                            var40_38 = var60_54;
                        }
                        var41_39 = var62_56 + 1;
                        var3_3 = this;
                        var4_4 = var1_1;
                        var12_15 = var74_72;
                        var9_9 = var58_52;
                        var10_13 = var79_77;
                        var5_5 = var56_50;
                        var23_22 = var69_67;
                        var39_37 = var70_68;
                        var26_25 = var76_74;
                        var7_7 = var78_76;
                        var38_36 = var72_70;
                        var13_16 = var73_71;
                        var11_14 = var77_75;
                        var8_8 = var80_78;
                    }
                    var42_40 = var40_38;
                    var43_41 = var13_16;
                    var44_42 = var12_15;
                    var45_43 = var11_14;
                    var46_44 = var9_9;
                    var47_45 = var8_8;
                    var48_46 = var5_5;
                    var49_47 = var7_7;
                    var50_48 = var10_13;
                    if (var42_40 != null) {
                        var51_83 = new StringBuilder();
                        var51_83.append((Object)var50_48);
                        var51_83.append(" declares multiple JSON fields named ");
                        var51_83.append(var42_40.a);
                        throw new IllegalArgumentException(var51_83.toString());
                    }
                }
                var15_18 = var30_29 + 1;
                var3_3 = this;
                var4_4 = var1_1;
                var12_15 = var44_42;
                var9_9 = var46_44;
                var10_13 = var50_48;
                var14_17 = var31_30;
                var5_5 = var48_46;
                var7_7 = var49_47;
                var13_16 = var43_41;
                var11_14 = var45_43;
                var8_8 = var47_45;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b(Field field, boolean bl) {
        o o2 = this.g;
        Class class_ = field.getType();
        if (o2.b(class_)) return false;
        if (o2.c(class_, bl)) {
            return false;
        }
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl2) return bl3;
        if ((o2.f & field.getModifiers()) != 0 || o2.e != -1.0 && !o2.f((c.e.b.b0.c)field.getAnnotation(c.e.b.b0.c.class), (c.e.b.b0.d)field.getAnnotation(c.e.b.b0.d.class)) || field.isSynthetic() || !o2.g && o2.e(field.getType()) || o2.d(field.getType())) return false;
        List<c.e.b.a> list = bl ? o2.h : o2.i;
        if (list.isEmpty()) return true;
        c.e.b.b b2 = new c.e.b.b(field);
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (!((c.e.b.a)iterator.next()).b(b2));
        return false;
    }

    public static final class a<T>
    extends z<T> {
        public final t<T> a;
        public final Map<String, b> b;

        public a(t<T> t2, Map<String, b> map) {
            this.a = t2;
            this.b = map;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T a(c.e.b.e0.a a2) {
            if (a2.T() == c.e.b.e0.b.m) {
                a2.P();
                return null;
            }
            T t2 = this.a.a();
            try {
                a2.f();
                while (a2.v()) {
                    String string = a2.N();
                    b b2 = this.b.get((Object)string);
                    if (b2 != null && b2.c) {
                        i i2 = (i)b2;
                        Object t3 = i2.f.a(a2);
                        if (t3 == null && i2.i) continue;
                        i2.d.set(t2, t3);
                        continue;
                    }
                    a2.Y();
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            catch (IllegalStateException illegalStateException) {
                throw new w(illegalStateException);
            }
            a2.p();
            return t2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b(c c2, T t2) {
            if (t2 == null) {
                c2.u();
                return;
            }
            c2.h();
            try {
                for (b b2 : this.b.values()) {
                    boolean bl;
                    i i2 = (i)b2;
                    if (!i2.b) {
                        bl = false;
                    } else {
                        Object object = i2.d.get(t2);
                        bl = false;
                        if (object != t2) {
                            bl = true;
                        }
                    }
                    if (!bl) continue;
                    c2.s(b2.a);
                    i i3 = (i)b2;
                    Object object = i3.d.get(t2);
                    n<Object> n2 = i3.e ? i3.f : new n<Object>(i3.g, i3.f, i3.h.b);
                    ((z)n2).b(c2, object);
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError((Object)illegalAccessException);
            }
            c2.p();
        }
    }

}

