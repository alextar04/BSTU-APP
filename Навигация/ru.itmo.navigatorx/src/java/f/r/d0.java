/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  android.view.ViewParent
 *  f.r.b0
 *  f.r.c
 *  f.r.c0
 *  f.r.d0$b
 *  f.r.f
 *  f.r.i
 *  f.r.i$d
 *  f.r.p
 *  f.r.q
 *  f.r.s
 *  f.r.v
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package f.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import f.r.b0;
import f.r.c;
import f.r.c0;
import f.r.d0;
import f.r.f;
import f.r.i;
import f.r.p;
import f.r.q;
import f.r.s;
import f.r.v;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public abstract class d0
extends i {
    public static final String[] N;
    public int M;

    public static {
        N = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    }

    public d0() {
        this.M = 3;
    }

    public final void I(q q2) {
        int n2 = q2.b.getVisibility();
        q2.a.put((Object)"android:visibility:visibility", (Object)n2);
        q2.a.put((Object)"android:visibility:parent", (Object)q2.b.getParent());
        int[] arrn = new int[2];
        q2.b.getLocationOnScreen(arrn);
        q2.a.put((Object)"android:visibility:screenLocation", (Object)arrn);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final b J(q q2, q q3) {
        b b2;
        block11 : {
            block14 : {
                block10 : {
                    block13 : {
                        block12 : {
                            block8 : {
                                block9 : {
                                    b2 = new /* Unavailable Anonymous Inner Class!! */;
                                    b2.a = false;
                                    b2.b = false;
                                    if (q2 != null && q2.a.containsKey((Object)"android:visibility:visibility")) {
                                        b2.c = (Integer)q2.a.get((Object)"android:visibility:visibility");
                                        b2.e = (ViewGroup)q2.a.get((Object)"android:visibility:parent");
                                    } else {
                                        b2.c = -1;
                                        b2.e = null;
                                    }
                                    if (q3 != null && q3.a.containsKey((Object)"android:visibility:visibility")) {
                                        b2.d = (Integer)q3.a.get((Object)"android:visibility:visibility");
                                        b2.f = (ViewGroup)q3.a.get((Object)"android:visibility:parent");
                                    } else {
                                        b2.d = -1;
                                        b2.f = null;
                                    }
                                    if (q2 == null || q3 == null) break block8;
                                    if (b2.c == b2.d && b2.e == b2.f) {
                                        return b2;
                                    }
                                    int n2 = b2.c;
                                    int n3 = b2.d;
                                    if (n2 == n3) break block9;
                                    if (n2 == 0) break block10;
                                    if (n3 != 0) break block11;
                                    break block12;
                                }
                                if (b2.f == null) break block10;
                                if (b2.e != null) break block11;
                                break block12;
                            }
                            if (q2 != null || b2.d != 0) break block13;
                        }
                        b2.b = true;
                        break block14;
                    }
                    if (q3 != null || b2.c != 0) break block11;
                }
                b2.b = false;
            }
            b2.a = true;
            return b2;
        }
        return b2;
    }

    public abstract Animator K(ViewGroup var1, View var2, q var3, q var4);

    public void e(q q2) {
        this.I(q2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public Animator l(ViewGroup var1_1, q var2_2, q var3_3) {
        block16 : {
            block19 : {
                block18 : {
                    block17 : {
                        block15 : {
                            var4_4 = this.J(var2_2, var3_3);
                            var5_5 = var4_4.a;
                            var6_6 = null;
                            if (var5_5 == false) return var6_6;
                            if (var4_4.e == null) {
                                var34_7 = var4_4.f;
                                var6_6 = null;
                                if (var34_7 == null) return var6_6;
                            }
                            if (var4_4.b) {
                                var26_8 = 1 & this.M;
                                var27_9 = null;
                                if (var26_8 != 1) return var27_9;
                                if (var3_3 == null) {
                                    return null;
                                }
                                if (var2_2 == null) {
                                    var33_10 = (View)var3_3.b.getParent();
                                    if (this.J((q)this.o((View)var33_10, (boolean)false), (q)this.r((View)var33_10, (boolean)false)).a) {
                                        return null;
                                    }
                                }
                                var28_11 = var3_3.b;
                                var29_12 = (c)this;
                                var30_14 = var2_2 != null && (var32_13 = (Float)var2_2.a.get((Object)"android:fade:transitionAlpha")) != null ? var32_13.floatValue() : 0.0f;
                                var31_15 = var30_14 == 1.0f ? 0.0f : var30_14;
                                return var29_12.L(var28_11, var31_15, 1.0f);
                            }
                            var7_16 = var4_4.d;
                            if ((2 & this.M) != 2) {
                                return null;
                            }
                            if (var2_2 == null) {
                                return null;
                            }
                            var8_17 = var2_2.b;
                            var9_18 = var3_3 != null ? var3_3.b : null;
                            var10_19 = (View)var8_17.getTag(f.save_overlay_view);
                            if (var10_19 == null) break block15;
                            var13_20 = true;
                            var15_21 = null;
                            break block16;
                        }
                        if (var9_18 == null || var9_18.getParent() == null) break block17;
                        if (var7_16 != 4 && var8_17 != var9_18) ** GOTO lbl-1000
                        var11_22 = var9_18;
                        var9_18 = null;
                        var12_23 = false;
                        break block18;
                    }
                    if (var9_18 != null) {
                        var11_22 = null;
                        var12_23 = false;
                    } else lbl-1000: // 2 sources:
                    {
                        var9_18 = null;
                        var11_22 = null;
                        var12_23 = true;
                    }
                }
                if (!var12_23) ** GOTO lbl-1000
                if (var8_17.getParent() == null) ** GOTO lbl-1000
                if (!(var8_17.getParent() instanceof View)) ** GOTO lbl-1000
                var24_24 = (View)var8_17.getParent();
                if (this.J((q)this.r((View)var24_24, (boolean)true), (q)this.o((View)var24_24, (boolean)true)).a) break block19;
                var9_18 = p.a((ViewGroup)var1_1, (View)var8_17, (View)var24_24);
                ** GOTO lbl-1000
            }
            var25_25 = var24_24.getId();
            if (var24_24.getParent() == null && var25_25 != -1 && var1_1.findViewById(var25_25) != null && this.z) lbl-1000: // 2 sources:
            {
                var15_21 = var11_22;
                var10_19 = var8_17;
                var13_20 = false;
            } else lbl-1000: // 4 sources:
            {
                var13_20 = false;
                var14_26 = var11_22;
                var10_19 = var9_18;
                var15_21 = var14_26;
            }
        }
        if (var10_19 != null) {
            if (!var13_20) {
                var20_27 = (int[])var2_2.a.get((Object)"android:visibility:screenLocation");
                var21_28 = var20_27[0];
                var22_29 = var20_27[1];
                var23_30 = new int[2];
                var1_1.getLocationOnScreen(var23_30);
                var10_19.offsetLeftAndRight(var21_28 - var23_30[0] - var10_19.getLeft());
                var10_19.offsetTopAndBottom(var22_29 - var23_30[1] - var10_19.getTop());
                var1_1.getOverlay().add(var10_19);
            }
            var6_6 = this.K(var1_1, var10_19, var2_2, var3_3);
            if (var13_20 != false) return var6_6;
            if (var6_6 == null) {
                var1_1.getOverlay().remove(var10_19);
                return var6_6;
            }
            var8_17.setTag(f.save_overlay_view, (Object)var10_19);
            this.a((i.d)new c0(this, var1_1, var10_19, var8_17));
            return var6_6;
        }
        var6_6 = null;
        if (var15_21 == null) return var6_6;
        var16_31 = var15_21.getVisibility();
        v.a.f(var15_21, 0);
        var6_6 = this.K(var1_1, var15_21, var2_2, var3_3);
        if (var6_6 != null) {
            var17_32 = new a(var15_21, var7_16, true);
            var6_6.addListener((Animator.AnimatorListener)var17_32);
            var6_6.addPauseListener((Animator.AnimatorPauseListener)var17_32);
            this.a((i.d)var17_32);
            return var6_6;
        }
        v.a.f(var15_21, var16_31);
        return var6_6;
    }

    public String[] q() {
        return N;
    }

    public boolean s(q q2, q q3) {
        boolean bl;
        block5 : {
            block6 : {
                if (q2 == null && q3 == null) {
                    return false;
                }
                if (q2 != null && q3 != null && q3.a.containsKey((Object)"android:visibility:visibility") != q2.a.containsKey((Object)"android:visibility:visibility")) {
                    return false;
                }
                b b2 = this.J(q2, q3);
                boolean bl2 = b2.a;
                bl = false;
                if (!bl2) break block5;
                if (b2.c == 0) break block6;
                int n2 = b2.d;
                bl = false;
                if (n2 != 0) break block5;
            }
            bl = true;
        }
        return bl;
    }

    public static class a
    extends AnimatorListenerAdapter
    implements i.d {
        public final View a;
        public final int b;
        public final ViewGroup c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public a(View view, int n2, boolean bl) {
            this.a = view;
            this.b = n2;
            this.c = (ViewGroup)view.getParent();
            this.d = bl;
            this.g(true);
        }

        public void a(i i2) {
            this.g(false);
        }

        public void b(i i2) {
            this.g(true);
        }

        public void c(i i2) {
        }

        public void d(i i2) {
        }

        public void e(i i2) {
            this.f();
            i2.w((i.d)this);
        }

        public final void f() {
            if (!this.f) {
                View view = this.a;
                int n2 = this.b;
                v.a.f(view, n2);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            this.g(false);
        }

        public final void g(boolean bl) {
            ViewGroup viewGroup;
            if (this.d && this.e != bl && (viewGroup = this.c) != null) {
                this.e = bl;
                s.a((ViewGroup)viewGroup, (boolean)bl);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                View view = this.a;
                int n2 = this.b;
                v.a.f(view, n2);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                View view = this.a;
                v.a.f(view, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

}

