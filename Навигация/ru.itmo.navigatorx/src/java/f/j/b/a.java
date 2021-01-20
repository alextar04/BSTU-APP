/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityNodeInfo
 *  com.google.android.material.chip.Chip
 *  com.google.android.material.chip.Chip$b
 *  f.h.l.l
 *  f.h.l.v.b
 *  f.h.l.v.c
 *  f.j.b.b
 *  f.j.b.c
 *  f.j.b.d
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package f.j.b;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import f.b.k.h;
import f.e.i;
import f.h.l.l;
import f.j.b.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class a
extends f.h.l.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final f.j.b.b<f.h.l.v.b> o = new f.j.b.b<f.h.l.v.b>(){

        public void a(Object object, Rect rect) {
            ((f.h.l.v.b)object).a.getBoundsInParent(rect);
        }
    };
    public static final f.j.b.c<i<f.h.l.v.b>, f.h.l.v.b> p = new f.j.b.c<i<f.h.l.v.b>, f.h.l.v.b>(){};
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    public a(View view) {
        if (view != null) {
            this.i = view;
            this.h = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (l.l((View)view) == 0) {
                view.setImportantForAccessibility(1);
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override
    public f.h.l.v.c b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override
    public void d(View view, f.h.l.v.b b2) {
        this.a.onInitializeAccessibilityNodeInfo(view, b2.a);
        Chip.b b3 = (Chip.b)this;
        boolean bl = b3.q.g();
        b2.a.setCheckable(bl);
        boolean bl2 = b3.q.isClickable();
        b2.a.setClickable(bl2);
        if (!b3.q.g() && !b3.q.isClickable()) {
            b2.a.setClassName((CharSequence)"android.view.View");
        } else {
            String string = b3.q.g() ? "android.widget.CompoundButton" : "android.widget.Button";
            b2.a.setClassName((CharSequence)string);
        }
        CharSequence charSequence = b3.q.getText();
        b2.a.setText(charSequence);
    }

    public final boolean j(int n2) {
        if (this.k == n2) {
            this.k = Integer.MIN_VALUE;
            this.i.invalidate();
            this.s(n2, 65536);
            return true;
        }
        return false;
    }

    public final boolean k(int n2) {
        if (this.l != n2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        Chip.b b2 = (Chip.b)this;
        if (n2 == 1) {
            Chip chip = b2.q;
            chip.p = false;
            chip.refreshDrawableState();
        }
        this.s(n2, 8);
        return true;
    }

    public final f.h.l.v.b l(int n2) {
        f.h.l.v.b b2 = new f.h.l.v.b(AccessibilityNodeInfo.obtain());
        b2.a.setEnabled(true);
        b2.a.setFocusable(true);
        b2.a.setClassName((CharSequence)"android.view.View");
        Rect rect = n;
        b2.a.setBoundsInParent(rect);
        Rect rect2 = n;
        b2.a.setBoundsInScreen(rect2);
        View view = this.i;
        b2.b = -1;
        b2.a.setParent(view);
        this.q(n2, b2);
        if (b2.g() == null && b2.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect3 = this.e;
        b2.a.getBoundsInParent(rect3);
        if (!this.e.equals((Object)n)) {
            int n3 = b2.a.getActions();
            if ((n3 & 64) == 0) {
                int n4 = 128;
                if ((n3 & n4) == 0) {
                    AccessibilityNodeInfo accessibilityNodeInfo;
                    String string = this.i.getContext().getPackageName();
                    b2.a.setPackageName((CharSequence)string);
                    View view2 = this.i;
                    b2.c = n2;
                    b2.a.setSource(view2, n2);
                    if (this.k == n2) {
                        b2.a.setAccessibilityFocused(true);
                        accessibilityNodeInfo = b2.a;
                    } else {
                        b2.a.setAccessibilityFocused(false);
                        accessibilityNodeInfo = b2.a;
                        n4 = 64;
                    }
                    accessibilityNodeInfo.addAction(n4);
                    boolean bl = this.l == n2;
                    if (bl) {
                        b2.a.addAction(2);
                    } else if (b2.a.isFocusable()) {
                        b2.a.addAction(1);
                    }
                    b2.a.setFocused(bl);
                    this.i.getLocationOnScreen(this.g);
                    Rect rect4 = this.d;
                    b2.a.getBoundsInScreen(rect4);
                    if (this.d.equals((Object)n)) {
                        Rect rect5 = this.d;
                        b2.a.getBoundsInParent(rect5);
                        if (b2.b != -1) {
                            f.h.l.v.b b3 = new f.h.l.v.b(AccessibilityNodeInfo.obtain());
                            int n5 = b2.b;
                            while (n5 != -1) {
                                View view3 = this.i;
                                b3.b = -1;
                                b3.a.setParent(view3, -1);
                                Rect rect6 = n;
                                b3.a.setBoundsInParent(rect6);
                                this.q(n5, b3);
                                Rect rect7 = this.e;
                                b3.a.getBoundsInParent(rect7);
                                Rect rect8 = this.d;
                                Rect rect9 = this.e;
                                rect8.offset(rect9.left, rect9.top);
                                n5 = b3.b;
                            }
                            b3.a.recycle();
                        }
                        this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                    }
                    if (this.i.getLocalVisibleRect(this.f)) {
                        this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                        if (this.d.intersect(this.f)) {
                            boolean bl2;
                            block23 : {
                                Rect rect10 = this.d;
                                b2.a.setBoundsInScreen(rect10);
                                Rect rect11 = this.d;
                                bl2 = false;
                                if (rect11 != null) {
                                    if (rect11.isEmpty()) {
                                        bl2 = false;
                                    } else if (this.i.getWindowVisibility() != 0) {
                                        bl2 = false;
                                    } else {
                                        ViewParent viewParent;
                                        View view4 = this.i;
                                        while ((viewParent = view4.getParent()) instanceof View) {
                                            view4 = (View)viewParent;
                                            float f2 = view4.getAlpha() FCMPG 0.0f;
                                            bl2 = false;
                                            if (f2 > 0) {
                                                if (view4.getVisibility() == 0) continue;
                                                bl2 = false;
                                            }
                                            break block23;
                                        }
                                        bl2 = false;
                                        if (viewParent != null) {
                                            bl2 = true;
                                        }
                                    }
                                }
                            }
                            if (bl2) {
                                b2.a.setVisibleToUser(true);
                            }
                        }
                    }
                    return b2;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public abstract void m(List<Integer> var1);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean n(int var1_1, Rect var2_2) {
        block26 : {
            block32 : {
                block31 : {
                    block27 : {
                        block30 : {
                            block28 : {
                                block29 : {
                                    block23 : {
                                        block25 : {
                                            block24 : {
                                                var3_3 = new ArrayList();
                                                this.m((List<Integer>)var3_3);
                                                var4_4 = new i<f.h.l.v.b>(10);
                                                for (var5_5 = 0; var5_5 < var3_3.size(); ++var5_5) {
                                                    var4_4.g(var5_5, this.l(var5_5));
                                                }
                                                var6_6 = this.l;
                                                var7_7 = var6_6 == Integer.MIN_VALUE ? null : (f.h.l.v.b)var4_4.d(var6_6);
                                                var8_8 = -1;
                                                if (var1_1 != 1 && var1_1 != 2) break block23;
                                                var9_30 = l.n((View)this.i) == 1;
                                                var10_31 = a.p;
                                                var11_32 = a.o;
                                                if (var10_31 == null) throw null;
                                                var12_33 = var4_4.i();
                                                var13_34 = new ArrayList(var12_33);
                                                for (var14_35 = 0; var14_35 < var12_33; ++var14_35) {
                                                    if (var4_4.e) {
                                                        var4_4.c();
                                                    }
                                                    var13_34.add((Object)((f.h.l.v.b)var4_4.g[var14_35]));
                                                }
                                                Collections.sort((List)var13_34, (Comparator)new d(var9_30, var11_32));
                                                if (var1_1 == 1) break block24;
                                                if (var1_1 != 2) throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                                                var23_36 = var13_34.size();
                                                var24_37 = var7_7 == null ? var8_8 : var13_34.lastIndexOf((Object)var7_7);
                                                var25_38 = var24_37 + 1;
                                                if (var25_38 >= var23_36) ** GOTO lbl-1000
                                                var17_39 = var13_34.get(var25_38);
                                                break block25;
                                            }
                                            var15_40 = var13_34.size();
                                            if (var7_7 != null) {
                                                var15_40 = var13_34.indexOf((Object)var7_7);
                                            }
                                            if ((var16_41 = var15_40 + var8_8) >= 0) {
                                                var17_39 = var13_34.get(var16_41);
                                            } else lbl-1000: // 2 sources:
                                            {
                                                var17_39 = null;
                                            }
                                        }
                                        var18_22 = (f.h.l.v.b)var17_39;
                                        break block26;
                                    }
                                    if (var1_1 != 17 && var1_1 != 33 && var1_1 != 66) {
                                        if (var1_1 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                    }
                                    var27_9 = new Rect();
                                    var28_10 = this.l;
                                    if (var28_10 != Integer.MIN_VALUE) {
                                        this.o((int)var28_10).a.getBoundsInParent(var27_9);
                                    } else if (var2_2 != null) {
                                        var27_9.set(var2_2);
                                    } else {
                                        var29_11 = this.i;
                                        var30_12 = var29_11.getWidth();
                                        var31_13 = var29_11.getHeight();
                                        if (var1_1 != 17) {
                                            if (var1_1 != 33) {
                                                if (var1_1 != 66) {
                                                    if (var1_1 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                                    var27_9.set(0, var8_8, var30_12, var8_8);
                                                } else {
                                                    var27_9.set(var8_8, 0, var8_8, var31_13);
                                                }
                                            } else {
                                                var27_9.set(0, var31_13, var30_12, var31_13);
                                            }
                                        } else {
                                            var27_9.set(var30_12, 0, var30_12, var31_13);
                                        }
                                    }
                                    var32_14 = a.p;
                                    var33_15 = a.o;
                                    var34_16 = new Rect(var27_9);
                                    if (var1_1 == 17) break block27;
                                    if (var1_1 == 33) break block28;
                                    if (var1_1 == 66) break block29;
                                    if (var1_1 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                    var46_17 = -(1 + var27_9.height());
                                    break block30;
                                }
                                var35_18 = -(1 + var27_9.width());
                                break block31;
                            }
                            var46_17 = 1 + var27_9.height();
                        }
                        var34_16.offset(0, var46_17);
                        break block32;
                    }
                    var35_18 = 1 + var27_9.width();
                }
                var34_16.offset(var35_18, 0);
            }
            if (var32_14 == null) throw null;
            var36_19 = var4_4.i();
            var37_20 = new Rect();
            var18_22 = null;
            for (var38_21 = 0; var38_21 < var36_19; ++var38_21) {
                if (var4_4.e) {
                    var4_4.c();
                }
                if ((var39_23 = (f.h.l.v.b)var4_4.g[var38_21]) == var7_7) continue;
                (var33_15).a((Object)var39_23, var37_20);
                var45_29 = h.i.F0(var27_9, var37_20, var1_1) != false && (h.i.F0(var27_9, var34_16, var1_1) == false || h.i.f(var1_1, var27_9, var37_20, var34_16) != false || h.i.f(var1_1, var27_9, var34_16, var37_20) == false && (var42_26 = (var40_24 = h.i.W0(var1_1, var27_9, var37_20)) * (var40_24 * 13) + (var41_25 = h.i.Y0(var1_1, var27_9, var37_20)) * var41_25) < (var43_27 = h.i.W0(var1_1, var27_9, var34_16)) * (var43_27 * 13) + (var44_28 = h.i.Y0(var1_1, var27_9, var34_16)) * var44_28);
                if (!var45_29) continue;
                var34_16.set(var37_20);
                var18_22 = var39_23;
            }
        }
        if ((var19_42 = var18_22) == null) {
            var22_43 = Integer.MIN_VALUE;
            return this.r(var22_43);
        }
        var20_44 = var4_4.e;
        var21_45 = 0;
        if (var20_44) {
            var4_4.c();
        }
        while (var21_45 < var4_4.h) {
            if (var4_4.g[var21_45] == var19_42) {
                var8_8 = var21_45;
                break;
            }
            ++var21_45;
        }
        var22_43 = var4_4.f(var8_8);
        return this.r(var22_43);
    }

    public f.h.l.v.b o(int n2) {
        if (n2 == -1) {
            f.h.l.v.b b2 = new f.h.l.v.b(AccessibilityNodeInfo.obtain((View)this.i));
            l.I((View)this.i, (f.h.l.v.b)b2);
            ArrayList arrayList = new ArrayList();
            this.m((List<Integer>)arrayList);
            if (b2.a.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int n3 = arrayList.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                View view = this.i;
                int n4 = (Integer)arrayList.get(i2);
                b2.a.addChild(view, n4);
            }
            return b2;
        }
        return this.l(n2);
    }

    public abstract boolean p(int var1, int var2, Bundle var3);

    public abstract void q(int var1, f.h.l.v.b var2);

    public final boolean r(int n2) {
        if (!this.i.isFocused() && !this.i.requestFocus()) {
            return false;
        }
        int n3 = this.l;
        if (n3 == n2) {
            return false;
        }
        if (n3 != Integer.MIN_VALUE) {
            this.k(n3);
        }
        this.l = n2;
        Chip.b b2 = (Chip.b)this;
        if (n2 == 1) {
            Chip chip = b2.q;
            chip.p = true;
            chip.refreshDrawableState();
        }
        this.s(n2, 8);
        return true;
    }

    public final boolean s(int n2, int n3) {
        if (n2 != Integer.MIN_VALUE) {
            AccessibilityEvent accessibilityEvent;
            if (!this.h.isEnabled()) {
                return false;
            }
            ViewParent viewParent = this.i.getParent();
            if (viewParent == null) {
                return false;
            }
            if (n2 != -1) {
                accessibilityEvent = AccessibilityEvent.obtain((int)n3);
                f.h.l.v.b b2 = this.o(n2);
                accessibilityEvent.getText().add((Object)b2.g());
                accessibilityEvent.setContentDescription(b2.e());
                accessibilityEvent.setScrollable(b2.a.isScrollable());
                accessibilityEvent.setPassword(b2.a.isPassword());
                accessibilityEvent.setEnabled(b2.a.isEnabled());
                accessibilityEvent.setChecked(b2.a.isChecked());
                if (accessibilityEvent.getText().isEmpty() && accessibilityEvent.getContentDescription() == null) {
                    throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
                }
                accessibilityEvent.setClassName(b2.a.getClassName());
                accessibilityEvent.setSource(this.i, n2);
                accessibilityEvent.setPackageName((CharSequence)this.i.getContext().getPackageName());
            } else {
                accessibilityEvent = AccessibilityEvent.obtain((int)n3);
                this.i.onInitializeAccessibilityEvent(accessibilityEvent);
            }
            return viewParent.requestSendAccessibilityEvent(this.i, accessibilityEvent);
        }
        return false;
    }

    public final void t(int n2) {
        int n3 = this.m;
        if (n3 == n2) {
            return;
        }
        this.m = n2;
        this.s(n2, 128);
        this.s(n3, 256);
    }

    public class c
    extends f.h.l.v.c {
        public f.h.l.v.b a(int n2) {
            return new f.h.l.v.b(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)a.this.o((int)n2).a));
        }

        public f.h.l.v.b b(int n2) {
            int n3 = n2 == 2 ? a.this.k : a.this.l;
            if (n3 == Integer.MIN_VALUE) {
                return null;
            }
            return new f.h.l.v.b(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)a.this.o((int)n3).a));
        }

        public boolean c(int n2, int n3, Bundle bundle) {
            a a2 = a.this;
            if (n2 != -1) {
                int n4 = 1;
                if (n3 != n4) {
                    if (n3 != 2) {
                        int n5;
                        if (n3 != 64) {
                            if (n3 != 128) {
                                return a2.p(n2, n3, bundle);
                            }
                            return a2.j(n2);
                        }
                        if (a2.h.isEnabled() && a2.h.isTouchExplorationEnabled() && (n5 = a2.k) != n2) {
                            if (n5 != Integer.MIN_VALUE) {
                                a2.j(n5);
                            }
                            a2.k = n2;
                            a2.i.invalidate();
                            a2.s(n2, 32768);
                        } else {
                            n4 = 0;
                        }
                        return n4;
                    }
                    return a2.k(n2);
                }
                return a2.r(n2);
            }
            return l.J((View)a2.i, (int)n3, (Bundle)bundle);
        }
    }

}

