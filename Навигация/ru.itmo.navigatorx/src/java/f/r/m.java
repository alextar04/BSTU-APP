/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  f.r.a
 *  f.r.m$a$a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 */
package f.r;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import f.e.e;
import f.e.h;
import f.r.f0;
import f.r.i;
import f.r.m;
import f.r.q;
import f.r.r;
import f.r.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class m {
    public static i a = new f.r.a();
    public static ThreadLocal<WeakReference<f.e.a<ViewGroup, ArrayList<i>>>> b = new ThreadLocal();
    public static ArrayList<ViewGroup> c = new ArrayList();

    public static f.e.a<ViewGroup, ArrayList<i>> a() {
        f.e.a a2;
        WeakReference weakReference = (WeakReference)b.get();
        if (weakReference != null && (a2 = (f.e.a)weakReference.get()) != null) {
            return a2;
        }
        f.e.a<ViewGroup, ArrayList<i>> a3 = new f.e.a<ViewGroup, ArrayList<i>>();
        WeakReference weakReference2 = new WeakReference(a3);
        b.set((Object)weakReference2);
        return a3;
    }

    public static class f.r.m$a
    implements ViewTreeObserver.OnPreDrawListener,
    View.OnAttachStateChangeListener {
        public i e;
        public ViewGroup f;

        public f.r.m$a(i i2, ViewGroup viewGroup) {
            this.e = i2;
            this.f = viewGroup;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean onPreDraw() {
            block26 : {
                block27 : {
                    this.f.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
                    this.f.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
                    var1_1 = m.c.remove((Object)this.f);
                    var2_2 = 1;
                    if (!var1_1) {
                        return (boolean)var2_2;
                    }
                    var3_3 = m.a();
                    var4_4 = (ArrayList)var3_3.get((Object)this.f);
                    if (var4_4 != null) break block27;
                    var4_4 = new ArrayList();
                    var3_3.put(this.f, (ArrayList<i>)var4_4);
                    ** GOTO lbl-1000
                }
                if (var4_4.size() > 0) {
                    var6_5 = new ArrayList((Collection)var4_4);
                } else lbl-1000: // 2 sources:
                {
                    var6_5 = null;
                }
                var4_4.add((Object)this.e);
                this.e.a((i.d)new a(this, var3_3));
                this.e.i(this.f, false);
                if (var6_5 != null) {
                    var84_6 = var6_5.iterator();
                    while (var84_6.hasNext()) {
                        ((i)var84_6.next()).y((View)this.f);
                    }
                }
                var9_7 = this.e;
                var10_8 = this.f;
                if (var9_7 == null) throw null;
                var9_7.x = new ArrayList();
                var9_7.y = new ArrayList();
                var11_9 = var9_7.t;
                var12_10 = var9_7.u;
                var13_11 = new f.e.a<K, V>(var11_9.a);
                var14_12 = new f.e.a<K, V>(var12_10.a);
                var15_13 = 0;
                do {
                    block33 : {
                        block32 : {
                            block28 : {
                                block29 : {
                                    block30 : {
                                        block31 : {
                                            if (var15_13 >= (var16_25 = var9_7.w).length) break block28;
                                            var37_27 = var16_25[var15_13];
                                            if (var37_27 == var2_2) break block29;
                                            if (var37_27 == 2) break block30;
                                            if (var37_27 == 3) break block31;
                                            if (var37_27 == 4) {
                                                break;
                                            }
                                            break block32;
                                        }
                                        var38_28 = var11_9;
                                        var57_41 = var38_28.b;
                                        var58_42 = var12_10.b;
                                        var59_43 = var57_41.size();
                                        for (var60_44 = 0; var60_44 < var59_43; ++var60_44) {
                                            var61_45 = (View)var57_41.valueAt(var60_44);
                                            if (var61_45 == null || !var9_7.t(var61_45) || (var62_46 = (View)var58_42.get(var57_41.keyAt(var60_44))) == null || !var9_7.t(var62_46)) continue;
                                            var63_47 = var13_11.getOrDefault((Object)var61_45, null);
                                            var64_14 = var14_12.getOrDefault((Object)var62_46, null);
                                            if (var63_47 == null || var64_14 == null) continue;
                                            var9_7.x.add((Object)var63_47);
                                            var9_7.y.add((Object)var64_14);
                                            var13_11.remove((Object)var61_45);
                                            var14_12.remove((Object)var62_46);
                                        }
                                        break block33;
                                    }
                                    var38_28 = var11_9;
                                    var45_33 = var38_28.d;
                                    var46_34 = var12_10.d;
                                    var47_35 = var45_33.g;
                                    for (var48_36 = 0; var48_36 < var47_35; ++var48_36) {
                                        var49_37 = (View)var45_33.l(var48_36);
                                        if (var49_37 == null || !var9_7.t(var49_37) || (var50_38 = (View)var46_34.get(var45_33.h(var48_36))) == null || !var9_7.t(var50_38)) continue;
                                        var51_39 = var13_11.getOrDefault((Object)var49_37, null);
                                        var52_40 = var14_12.getOrDefault((Object)var50_38, null);
                                        if (var51_39 == null || var52_40 == null) continue;
                                        var9_7.x.add((Object)var51_39);
                                        var9_7.y.add((Object)var52_40);
                                        var13_11.remove((Object)var49_37);
                                        var14_12.remove((Object)var50_38);
                                    }
                                    break block33;
                                }
                                var38_28 = var11_9;
                                var39_29 = var13_11.g;
                                while (--var39_29 >= 0) {
                                    var40_30 = (View)var13_11.h(var39_29);
                                    if (var40_30 == null || !var9_7.t(var40_30) || (var41_31 = (q)var14_12.remove((Object)var40_30)) == null || !var9_7.t(var41_31.b)) continue;
                                    var42_32 = (q)var13_11.j(var39_29);
                                    var9_7.x.add((Object)var42_32);
                                    var9_7.y.add((Object)var41_31);
                                }
                                break block33;
                            }
                            for (var17_48 = 0; var17_48 < var13_11.g; ++var17_48) {
                                var34_49 = (q)var13_11.l(var17_48);
                                if (!var9_7.t(var34_49.b)) continue;
                                var9_7.x.add((Object)var34_49);
                                var9_7.y.add(null);
                            }
                            for (var18_50 = 0; var18_50 < var14_12.g; ++var18_50) {
                                var31_51 = (q)var14_12.l(var18_50);
                                if (!var9_7.t(var31_51.b)) continue;
                                var9_7.y.add((Object)var31_51);
                                var9_7.x.add(null);
                            }
                            break block26;
                        }
                        do {
                            var83_26 = var11_9;
                            var38_28 = var83_26;
                            break;
                        } while (true);
                    }
                    ++var15_13;
                    var11_9 = var38_28;
                    var2_2 = 1;
                } while (true);
                var69_15 = var11_9.c;
                var70_16 = var12_10.c;
                var71_17 = var69_15.h();
                var72_18 = 0;
                do {
                    if (var72_18 >= var71_17) ** continue;
                    var73_19 = var69_15.i(var72_18);
                    if (var73_19 != null && var9_7.t(var73_19)) {
                        if (var69_15.e) {
                            var69_15.d();
                        }
                        var75_21 = var69_15.f;
                        var74_20 = var11_9;
                        var76_22 = var70_16.e(var75_21[var72_18]);
                        if (var76_22 != null && var9_7.t(var76_22)) {
                            var77_23 = var13_11.getOrDefault((Object)var73_19, null);
                            var78_24 = var14_12.getOrDefault((Object)var76_22, null);
                            if (var77_23 != null && var78_24 != null) {
                                var9_7.x.add((Object)var77_23);
                                var9_7.y.add((Object)var78_24);
                                var13_11.remove((Object)var73_19);
                                var14_12.remove((Object)var76_22);
                            }
                        }
                    } else {
                        var74_20 = var11_9;
                    }
                    ++var72_18;
                    var11_9 = var74_20;
                } while (true);
            }
            var19_52 = i.p();
            var20_53 = var19_52.g;
            var21_54 = v.c((View)var10_8);
            var22_55 = var20_53 - 1;
            do {
                if (var22_55 < 0) {
                    var9_7.m(var10_8, var9_7.t, var9_7.u, var9_7.x, var9_7.y);
                    var9_7.z();
                    return true;
                }
                var23_56 = (Animator)var19_52.h(var22_55);
                if (var23_56 != null && (var24_57 = (i.b)var19_52.getOrDefault((Object)var23_56, null)) != null && var24_57.a != null && var21_54.equals((Object)var24_57.d)) {
                    var25_58 = var24_57.c;
                    var26_59 = var24_57.a;
                    var27_60 = var9_7.r(var26_59, true);
                    var28_61 = var9_7.o(var26_59, true);
                    if (var27_60 == null && var28_61 == null) {
                        var28_61 = (q)var9_7.u.a.get((Object)var26_59);
                    }
                    if (var29_62 = (var27_60 != null || var28_61 != null) && var24_57.e.s(var25_58, var28_61) != false) {
                        if (!var23_56.isRunning() && !var23_56.isStarted()) {
                            var19_52.remove((Object)var23_56);
                        } else {
                            var23_56.cancel();
                        }
                    }
                }
                --var22_55;
            } while (true);
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.f.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
            this.f.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            m.c.remove((Object)this.f);
            ArrayList arrayList = (ArrayList)m.a().get((Object)this.f);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    ((i)iterator.next()).y((View)this.f);
                }
            }
            this.e.j(true);
        }
    }

}

