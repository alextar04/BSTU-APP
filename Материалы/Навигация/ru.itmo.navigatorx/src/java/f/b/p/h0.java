/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.Gravity
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  c.b.a.a.a
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.b.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import f.b.j;
import f.b.p.c1;
import f.h.l.l;

public class h0
extends ViewGroup {
    public boolean e = true;
    public int f = -1;
    public int g = 0;
    public int h;
    public int i = 8388659;
    public int j;
    public float k;
    public boolean l;
    public int[] m;
    public int[] n;
    public Drawable o;
    public int p;
    public int q;
    public int r;
    public int s;

    public h0(Context context) {
        this(context, null);
    }

    public h0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h0(Context context, AttributeSet attributeSet, int n2) {
        int n3;
        int n4;
        boolean bl;
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat, n2, 0);
        l.R((View)this, (Context)context, (int[])j.LinearLayoutCompat, (AttributeSet)attributeSet, (TypedArray)typedArray, (int)n2, (int)0);
        int n5 = typedArray.getInt(j.LinearLayoutCompat_android_orientation, -1);
        if (n5 >= 0) {
            this.setOrientation(n5);
        }
        if ((n3 = typedArray.getInt(j.LinearLayoutCompat_android_gravity, -1)) >= 0) {
            this.setGravity(n3);
        }
        if (!(bl = typedArray.getBoolean(j.LinearLayoutCompat_android_baselineAligned, true))) {
            this.setBaselineAligned(bl);
        }
        this.k = typedArray.getFloat(j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f = typedArray.getInt(j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.l = typedArray.getBoolean(j.LinearLayoutCompat_measureWithLargestChild, false);
        int n6 = j.LinearLayoutCompat_divider;
        Drawable drawable = typedArray.hasValue(n6) && (n4 = typedArray.getResourceId(n6, 0)) != 0 ? f.b.l.a.a.b(context, n4) : typedArray.getDrawable(n6);
        this.setDividerDrawable(drawable);
        this.r = typedArray.getInt(j.LinearLayoutCompat_showDividers, 0);
        this.s = typedArray.getDimensionPixelSize(j.LinearLayoutCompat_dividerPadding, 0);
        typedArray.recycle();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void g(Canvas canvas, int n2) {
        this.o.setBounds(this.getPaddingLeft() + this.s, n2, this.getWidth() - this.getPaddingRight() - this.s, n2 + this.q);
        this.o.draw(canvas);
    }

    public int getBaseline() {
        int n2;
        if (this.f < 0) {
            return super.getBaseline();
        }
        int n3 = this.getChildCount();
        if (n3 > (n2 = this.f)) {
            int n4;
            View view = this.getChildAt(n2);
            int n5 = view.getBaseline();
            if (n5 == -1) {
                if (this.f == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int n6 = this.g;
            if (this.h == 1 && (n4 = 112 & this.i) != 48) {
                if (n4 != 16) {
                    if (n4 == 80) {
                        n6 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.j;
                    }
                } else {
                    n6 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.j) / 2;
                }
            }
            return n5 + (n6 + ((a)view.getLayoutParams()).topMargin);
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f;
    }

    public Drawable getDividerDrawable() {
        return this.o;
    }

    public int getDividerPadding() {
        return this.s;
    }

    public int getDividerWidth() {
        return this.p;
    }

    public int getGravity() {
        return this.i;
    }

    public int getOrientation() {
        return this.h;
    }

    public int getShowDividers() {
        return this.r;
    }

    public int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.k;
    }

    public void h(Canvas canvas, int n2) {
        this.o.setBounds(n2, this.getPaddingTop() + this.s, n2 + this.p, this.getHeight() - this.getPaddingBottom() - this.s);
        this.o.draw(canvas);
    }

    public a i() {
        int n2 = this.h;
        if (n2 == 0) {
            return new a(-2, -2);
        }
        if (n2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    public a j(AttributeSet attributeSet) {
        return new a(this.getContext(), attributeSet);
    }

    public a k(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int l() {
        return 0;
    }

    public int m() {
        return 0;
    }

    public int n() {
        return 0;
    }

    public boolean o(int n2) {
        if (n2 == 0) {
            int n3 = 1 & this.r;
            boolean bl = false;
            if (n3 != 0) {
                bl = true;
            }
            return bl;
        }
        if (n2 == this.getChildCount()) {
            int n4 = 4 & this.r;
            boolean bl = false;
            if (n4 != 0) {
                bl = true;
            }
            return bl;
        }
        if ((2 & this.r) != 0) {
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                if (this.getChildAt(i2).getVisibility() == 8) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onDraw(Canvas var1_1) {
        block11 : {
            block9 : {
                block10 : {
                    if (this.o == null) {
                        return;
                    }
                    var2_2 = this.h;
                    if (var2_2 == 1) {
                        var14_4 = this.getVirtualChildCount();
                        for (var3_3 = 0; var3_3 < var14_4; ++var3_3) {
                            var18_5 = this.getChildAt(var3_3);
                            if (var18_5 == null || var18_5.getVisibility() == 8 || !this.o(var3_3)) continue;
                            var19_6 = (a)var18_5.getLayoutParams();
                            this.g(var1_1, var18_5.getTop() - var19_6.topMargin - this.q);
                        }
                        if (this.o(var14_4) == false) return;
                        var15_7 = this.getChildAt(var14_4 - 1);
                        if (var15_7 == null) {
                            var17_8 = this.getHeight() - this.getPaddingBottom() - this.q;
                        } else {
                            var16_9 = (a)var15_7.getLayoutParams();
                            var17_8 = var15_7.getBottom() + var16_9.bottomMargin;
                        }
                        this.g(var1_1, var17_8);
                        return;
                    }
                    var4_10 = this.getVirtualChildCount();
                    var5_11 = c1.b((View)this);
                    while (var3_3 < var4_10) {
                        var11_12 = this.getChildAt(var3_3);
                        if (var11_12 != null && var11_12.getVisibility() != 8 && this.o(var3_3)) {
                            var12_13 = (a)var11_12.getLayoutParams();
                            var13_14 = var5_11 != false ? var11_12.getRight() + var12_13.rightMargin : var11_12.getLeft() - var12_13.leftMargin - this.p;
                            this.h(var1_1, var13_14);
                        }
                        ++var3_3;
                    }
                    if (this.o(var4_10) == false) return;
                    var6_15 = this.getChildAt(var4_10 - 1);
                    if (var6_15 != null) break block9;
                    if (!var5_11) break block10;
                    var8_16 = this.getPaddingLeft();
                    break block11;
                }
                var9_17 = this.getWidth();
                var10_18 = this.getPaddingRight();
                ** GOTO lbl46
            }
            var7_19 = (a)var6_15.getLayoutParams();
            if (var5_11) {
                var9_17 = var6_15.getLeft();
                var10_18 = var7_19.leftMargin;
lbl46: // 2 sources:
                var8_16 = var9_17 - var10_18 - this.p;
            } else {
                var8_16 = var6_15.getRight() + var7_19.rightMargin;
            }
        }
        this.h(var1_1, var8_16);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)"androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)"androidx.appcompat.widget.LinearLayoutCompat");
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6;
        boolean bl2;
        int[] arrn;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int[] arrn2;
        int n12;
        int n13;
        int n14;
        block17 : {
            int n15;
            int n16;
            block16 : {
                int n17 = this.h;
                n16 = 8;
                n15 = 5;
                if (n17 == 1) break block16;
                boolean bl3 = c1.b((View)this);
                n9 = this.getPaddingTop();
                int n18 = n5 - n3;
                n8 = n18 - this.getPaddingBottom();
                n10 = n18 - n9 - this.getPaddingBottom();
                n11 = this.getVirtualChildCount();
                int n19 = this.i;
                int n20 = 8388615 & n19;
                n14 = n19 & 112;
                bl2 = this.e;
                arrn2 = this.m;
                arrn = this.n;
                int n21 = Gravity.getAbsoluteGravity((int)n20, (int)this.getLayoutDirection());
                n13 = n21 != 1 ? (n21 != 5 ? this.getPaddingLeft() : n4 + this.getPaddingLeft() - n2 - this.j) : this.getPaddingLeft() + (n4 - n2 - this.j) / 2;
                if (bl3) {
                    n12 = n11 - 1;
                    n7 = -1;
                    n6 = 0;
                } else {
                    n7 = 1;
                    n6 = 0;
                    n12 = 0;
                }
                break block17;
            }
            int n22 = this.getPaddingLeft();
            int n23 = n4 - n2;
            int n24 = n23 - this.getPaddingRight();
            int n25 = n23 - n22 - this.getPaddingRight();
            int n26 = this.getVirtualChildCount();
            int n27 = this.i;
            int n28 = n27 & 112;
            int n29 = 8388615 & n27;
            int n30 = n28 != 16 ? (n28 != 80 ? this.getPaddingTop() : n5 + this.getPaddingTop() - n3 - this.j) : this.getPaddingTop() + (n5 - n3 - this.j) / 2;
            for (int i2 = 0; i2 < n26; ++i2) {
                block20 : {
                    int n31;
                    block19 : {
                        a a2;
                        int n32;
                        int n33;
                        int n34;
                        View view;
                        block23 : {
                            int n35;
                            block24 : {
                                block21 : {
                                    block22 : {
                                        int n36;
                                        block18 : {
                                            view = this.getChildAt(i2);
                                            if (view != null) break block18;
                                            n31 = n30 + this.q();
                                            break block19;
                                        }
                                        if (view.getVisibility() == n16) break block20;
                                        n33 = view.getMeasuredWidth();
                                        n32 = view.getMeasuredHeight();
                                        a2 = (a)view.getLayoutParams();
                                        int n37 = a2.b;
                                        if (n37 < 0) {
                                            n37 = n29;
                                        }
                                        if ((n36 = 7 & Gravity.getAbsoluteGravity((int)n37, (int)l.n((View)this))) == 1) break block21;
                                        if (n36 == n15) break block22;
                                        n34 = n22 + a2.leftMargin;
                                        break block23;
                                    }
                                    n35 = n24 - n33;
                                    break block24;
                                }
                                n35 = n22 + (n25 - n33) / 2 + a2.leftMargin;
                            }
                            n34 = n35 - a2.rightMargin;
                        }
                        if (this.o(i2)) {
                            n30 += this.q;
                        }
                        int n38 = n30 + a2.topMargin;
                        int n39 = n38 + this.m();
                        view.layout(n34, n39, n33 + n34, n32 + n39);
                        n31 = n38 + (n32 + a2.bottomMargin + this.n());
                        i2 += this.l();
                    }
                    n30 = n31;
                }
                n16 = 8;
                n15 = 5;
            }
            return;
        }
        while (n6 < n11) {
            int n40;
            int n41;
            boolean bl4;
            block30 : {
                a a3;
                int n42;
                int n43;
                int n44;
                View view;
                int n45;
                int n46;
                block29 : {
                    block28 : {
                        block27 : {
                            block26 : {
                                block25 : {
                                    n43 = n12 + n7 * n6;
                                    view = this.getChildAt(n43);
                                    if (view != null) break block25;
                                    n13 += this.q();
                                    break block26;
                                }
                                if (view.getVisibility() == 8) break block26;
                                n44 = view.getMeasuredWidth();
                                n42 = view.getMeasuredHeight();
                                a3 = (a)view.getLayoutParams();
                                n40 = n11;
                                if (!bl2) break block27;
                                int n47 = a3.height;
                                n41 = n14;
                                if (n47 == -1) break block28;
                                n45 = view.getBaseline();
                                break block29;
                            }
                            n40 = n11;
                            n41 = n14;
                            bl4 = bl2;
                            break block30;
                        }
                        n41 = n14;
                    }
                    n45 = -1;
                }
                int n48 = a3.b;
                if (n48 < 0) {
                    n48 = n41;
                }
                int n49 = n48 & 112;
                bl4 = bl2;
                if (n49 != 16) {
                    if (n49 != 48) {
                        if (n49 != 80) {
                            n46 = n9;
                        } else {
                            n46 = n8 - n42 - a3.bottomMargin;
                            if (n45 != -1) {
                                int n50 = view.getMeasuredHeight() - n45;
                                n46 -= arrn[2] - n50;
                            }
                        }
                    } else {
                        n46 = n9 + a3.topMargin;
                        if (n45 != -1) {
                            n46 += arrn2[1] - n45;
                        }
                    }
                } else {
                    n46 = n9 + (n10 - n42) / 2 + a3.topMargin - a3.bottomMargin;
                }
                if (this.o(n43)) {
                    n13 += this.p;
                }
                int n51 = n13 + a3.leftMargin;
                int n52 = n51 + this.m();
                view.layout(n52, n46, n44 + n52, n42 + n46);
                n13 = n51 + (n44 + a3.rightMargin + this.n());
                n6 += this.l();
            }
            ++n6;
            n11 = n40;
            n14 = n41;
            bl2 = bl4;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onMeasure(int var1_1, int var2_2) {
        block108 : {
            block120 : {
                block119 : {
                    block107 : {
                        block105 : {
                            block106 : {
                                block104 : {
                                    block103 : {
                                        block102 : {
                                            block101 : {
                                                block79 : {
                                                    block84 : {
                                                        block82 : {
                                                            block83 : {
                                                                block81 : {
                                                                    block78 : {
                                                                        var3_3 = this.h;
                                                                        var4_4 = -2;
                                                                        var5_5 = Integer.MIN_VALUE;
                                                                        var6_6 = 8;
                                                                        var7_7 = 1073741824;
                                                                        var8_8 = 1;
                                                                        if (var3_3 == var8_8) break block78;
                                                                        var9_92 = var8_8;
                                                                        this.j = 0;
                                                                        var10_93 = this.getVirtualChildCount();
                                                                        var11_94 = View.MeasureSpec.getMode((int)var1_1);
                                                                        var12_95 = View.MeasureSpec.getMode((int)var2_2);
                                                                        if (this.m == null || this.n == null) {
                                                                            this.m = new int[4];
                                                                            this.n = new int[4];
                                                                        }
                                                                        var13_96 = this.m;
                                                                        var14_97 = this.n;
                                                                        var13_96[3] = -1;
                                                                        var13_96[2] = -1;
                                                                        var13_96[var9_92] = -1;
                                                                        var13_96[0] = -1;
                                                                        var14_97[3] = -1;
                                                                        var14_97[2] = -1;
                                                                        var14_97[var9_92] = -1;
                                                                        var14_97[0] = -1;
                                                                        var15_98 = this.e;
                                                                        var16_99 = this.l;
                                                                        var17_100 = var11_94 == 1073741824 ? var9_92 : 0;
                                                                        var18_101 = var9_92;
                                                                        var19_102 = 0;
                                                                        var20_103 = 0.0f;
                                                                        var21_104 = 0;
                                                                        var23_106 = 0;
                                                                        var24_107 = 0;
                                                                        var25_108 = 0;
                                                                        var26_109 = 0;
                                                                        var27_110 = 0;
                                                                        break block79;
                                                                    }
                                                                    this.j = 0;
                                                                    var129_9 = this.getVirtualChildCount();
                                                                    var130_10 = View.MeasureSpec.getMode((int)var1_1);
                                                                    var131_11 = View.MeasureSpec.getMode((int)var2_2);
                                                                    var132_12 = this.f;
                                                                    var133_13 = this.l;
                                                                    var135_15 = 0;
                                                                    var136_16 = 0;
                                                                    var137_17 = 0;
                                                                    var138_18 = 0;
                                                                    var139_19 = false;
                                                                    var140_20 = 0;
                                                                    var141_21 = 0;
                                                                    var142_22 = var8_8;
                                                                    var143_23 = 0.0f;
                                                                    for (var134_14 = 0; var134_14 < var129_9; ++var134_14) {
                                                                        block80 : {
                                                                            var187_24 = this.getChildAt(var134_14);
                                                                            if (var187_24 != null) break block80;
                                                                            this.j += this.q();
                                                                            ** GOTO lbl63
                                                                        }
                                                                        if (var187_24.getVisibility() == var6_6) {
                                                                            var134_14 += this.l();
lbl63: // 2 sources:
                                                                            var191_28 = var132_12;
                                                                            var193_30 = var131_11;
                                                                            var202_39 = var130_10;
                                                                            var195_32 = var129_9;
                                                                            var197_34 = var8_8;
                                                                            var206_43 = var138_18;
                                                                        } else {
                                                                            if (this.o(var134_14)) {
                                                                                this.j += this.q;
                                                                            }
                                                                            var188_25 = (a)var187_24.getLayoutParams();
                                                                            var189_26 = var188_25.a;
                                                                            var143_23 += var189_26;
                                                                            if (var131_11 == var7_7 && var188_25.height == 0 && var189_26 > 0.0f) {
                                                                                var211_48 = this.j;
                                                                                this.j = Math.max((int)var211_48, (int)(var211_48 + var188_25.topMargin + var188_25.bottomMargin));
                                                                                var191_28 = var132_12;
                                                                                var193_30 = var131_11;
                                                                                var194_31 = var130_10;
                                                                                var195_32 = var129_9;
                                                                                var196_33 = var188_25;
                                                                                var201_38 = true;
                                                                                var197_34 = 1;
                                                                            } else {
                                                                                if (var188_25.height == 0 && var188_25.a > 0.0f) {
                                                                                    var188_25.height = var4_4;
                                                                                    var190_27 = 0;
                                                                                } else {
                                                                                    var190_27 = var5_5;
                                                                                }
                                                                                if (var143_23 == 0.0f) {
                                                                                    var192_29 = this.j;
                                                                                    var191_28 = var132_12;
                                                                                } else {
                                                                                    var191_28 = var132_12;
                                                                                    var192_29 = 0;
                                                                                }
                                                                                var193_30 = var131_11;
                                                                                var194_31 = var130_10;
                                                                                var195_32 = var129_9;
                                                                                var196_33 = var188_25;
                                                                                var197_34 = 1;
                                                                                this.p(var187_24, var1_1, 0, var2_2, var192_29);
                                                                                if (var190_27 != var5_5) {
                                                                                    var196_33.height = var190_27;
                                                                                }
                                                                                var198_35 = var187_24.getMeasuredHeight();
                                                                                var199_36 = this.j;
                                                                                this.j = Math.max((int)var199_36, (int)(var199_36 + var198_35 + var196_33.topMargin + var196_33.bottomMargin + this.n()));
                                                                                var200_37 = var136_16;
                                                                                if (var133_13) {
                                                                                    var136_16 = Math.max((int)var198_35, (int)var200_37);
                                                                                }
                                                                                var201_38 = var139_19;
                                                                            }
                                                                            if (var191_28 >= 0 && var191_28 == var134_14 + 1) {
                                                                                this.g = this.j;
                                                                            }
                                                                            if (var134_14 < var191_28) {
                                                                                if (var196_33.a > 0.0f) throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                                                                            }
                                                                            if ((var202_39 = var194_31) != 1073741824 && var196_33.width == -1) {
                                                                                var140_20 = var203_40 = var197_34;
                                                                            } else {
                                                                                var203_40 = 0;
                                                                            }
                                                                            var204_41 = var196_33.leftMargin + var196_33.rightMargin;
                                                                            var205_42 = var204_41 + var187_24.getMeasuredWidth();
                                                                            var206_43 = Math.max((int)var138_18, (int)var205_42);
                                                                            var207_44 = var187_24.getMeasuredState();
                                                                            var208_45 = View.combineMeasuredStates((int)var141_21, (int)var207_44);
                                                                            var209_46 = var142_22 != 0 && var196_33.width == -1 ? var197_34 : 0;
                                                                            if (var196_33.a > 0.0f) {
                                                                                if (var203_40 == 0) {
                                                                                    var204_41 = var205_42;
                                                                                }
                                                                                var135_15 = Math.max((int)var135_15, (int)var204_41);
                                                                            } else {
                                                                                var210_47 = var135_15;
                                                                                if (var203_40 == 0) {
                                                                                    var204_41 = var205_42;
                                                                                }
                                                                                var137_17 = Math.max((int)var137_17, (int)var204_41);
                                                                                var135_15 = var210_47;
                                                                            }
                                                                            var134_14 += this.l();
                                                                            var139_19 = var201_38;
                                                                            var142_22 = var209_46;
                                                                            var141_21 = var208_45;
                                                                        }
                                                                        var130_10 = var202_39;
                                                                        var138_18 = var206_43;
                                                                        var132_12 = var191_28;
                                                                        var8_8 = var197_34;
                                                                        var131_11 = var193_30;
                                                                        var129_9 = var195_32;
                                                                        var4_4 = -2;
                                                                        var5_5 = Integer.MIN_VALUE;
                                                                        var6_6 = 8;
                                                                        var7_7 = 1073741824;
                                                                    }
                                                                    var144_49 = var131_11;
                                                                    var145_50 = var130_10;
                                                                    var146_51 = var129_9;
                                                                    var147_52 = var8_8;
                                                                    var148_53 = var135_15;
                                                                    var149_54 = var136_16;
                                                                    var150_55 = var137_17;
                                                                    var151_56 = var138_18;
                                                                    var152_57 = var141_21;
                                                                    if (this.j > 0 && this.o(var146_51)) {
                                                                        this.j += this.q;
                                                                    }
                                                                    var153_58 = var144_49;
                                                                    if (var133_13 && (var153_58 == Integer.MIN_VALUE || var153_58 == 0)) {
                                                                        this.j = 0;
                                                                        for (var183_59 = 0; var183_59 < var146_51; ++var183_59) {
                                                                            var184_60 = this.getChildAt(var183_59);
                                                                            if (var184_60 == null) {
                                                                                this.j += this.q();
                                                                                continue;
                                                                            }
                                                                            if (var184_60.getVisibility() == 8) {
                                                                                var183_59 += this.l();
                                                                                continue;
                                                                            }
                                                                            var185_61 = (a)var184_60.getLayoutParams();
                                                                            var186_62 = this.j;
                                                                            this.j = Math.max((int)var186_62, (int)(var186_62 + var149_54 + var185_61.topMargin + var185_61.bottomMargin + this.n()));
                                                                        }
                                                                    }
                                                                    this.j = var154_63 = this.j + (this.getPaddingTop() + this.getPaddingBottom());
                                                                    var155_64 = View.resolveSizeAndState((int)Math.max((int)var154_63, (int)this.getSuggestedMinimumHeight()), (int)var2_2, (int)0);
                                                                    var156_65 = (16777215 & var155_64) - this.j;
                                                                    if (var139_19 || var156_65 != 0 && var143_23 > 0.0f) break block81;
                                                                    var150_55 = Math.max((int)var150_55, (int)var148_53);
                                                                    if (!var133_13 || var153_58 == 1073741824) break block82;
                                                                    break block83;
                                                                }
                                                                var157_68 = this.k;
                                                                if (var157_68 > 0.0f) {
                                                                    var143_23 = var157_68;
                                                                }
                                                                this.j = 0;
                                                                break block84;
                                                            }
                                                            for (var181_66 = 0; var181_66 < var146_51; ++var181_66) {
                                                                var182_67 = this.getChildAt(var181_66);
                                                                if (var182_67 == null || var182_67.getVisibility() == 8 || !(((a)var182_67.getLayoutParams()).a > 0.0f)) continue;
                                                                var182_67.measure(View.MeasureSpec.makeMeasureSpec((int)var182_67.getMeasuredWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)var149_54, (int)1073741824));
                                                            }
                                                        }
lbl197: // 2 sources:
                                                        do {
                                                            var159_86 = var151_56;
                                                            if (var142_22 != 0 || var145_50 == 1073741824) {
                                                                var150_55 = var159_86;
                                                            }
                                                            this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max((int)(var150_55 + (this.getPaddingLeft() + this.getPaddingRight())), (int)this.getSuggestedMinimumWidth()), (int)var1_1, (int)var152_57), var155_64);
                                                            if (var140_20 == 0) return;
                                                            var160_87 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824);
                                                            var161_88 = 0;
                                                            while (var161_88 < var146_51) {
                                                                var162_89 = this.getChildAt(var161_88);
                                                                if (var162_89.getVisibility() != 8) {
                                                                    var163_90 = (a)var162_89.getLayoutParams();
                                                                    if (var163_90.width == -1) {
                                                                        var164_91 = var163_90.height;
                                                                        var163_90.height = var162_89.getMeasuredHeight();
                                                                        this.measureChildWithMargins(var162_89, var160_87, 0, var2_2, 0);
                                                                        var163_90.height = var164_91;
                                                                    }
                                                                }
                                                                ++var161_88;
                                                            }
                                                            return;
                                                            break;
                                                        } while (true);
                                                    }
                                                    for (var158_69 = 0; var158_69 < var146_51; ++var158_69) {
                                                        block86 : {
                                                            block93 : {
                                                                block92 : {
                                                                    block91 : {
                                                                        block87 : {
                                                                            block90 : {
                                                                                block89 : {
                                                                                    block88 : {
                                                                                        block85 : {
                                                                                            var165_70 = this.getChildAt(var158_69);
                                                                                            if (var165_70.getVisibility() != 8) break block85;
                                                                                            var170_75 = var153_58;
                                                                                            break block86;
                                                                                        }
                                                                                        var166_71 = (a)var165_70.getLayoutParams();
                                                                                        var167_72 = var166_71.a;
                                                                                        if (!(var167_72 > 0.0f)) break block87;
                                                                                        var177_82 = (int)(var167_72 * (float)var156_65 / var143_23);
                                                                                        var143_23 -= var167_72;
                                                                                        var178_83 = var156_65 - var177_82;
                                                                                        var179_84 = ViewGroup.getChildMeasureSpec((int)var1_1, (int)(this.getPaddingLeft() + this.getPaddingRight() + var166_71.leftMargin + var166_71.rightMargin), (int)var166_71.width);
                                                                                        if (var166_71.height != 0 || var153_58 != 1073741824) break block88;
                                                                                        if (var177_82 <= 0) break block89;
                                                                                        var180_85 = var177_82;
                                                                                        break block90;
                                                                                    }
                                                                                    var180_85 = var177_82 + var165_70.getMeasuredHeight();
                                                                                    if (var180_85 >= 0) break block90;
                                                                                }
                                                                                var180_85 = 0;
                                                                            }
                                                                            var165_70.measure(var179_84, View.MeasureSpec.makeMeasureSpec((int)var180_85, (int)1073741824));
                                                                            var152_57 = View.combineMeasuredStates((int)var152_57, (int)(-256 & var165_70.getMeasuredState()));
                                                                            var156_65 = var178_83;
                                                                        }
                                                                        var168_73 = var166_71.leftMargin + var166_71.rightMargin;
                                                                        var169_74 = var168_73 + var165_70.getMeasuredWidth();
                                                                        var151_56 = Math.max((int)var151_56, (int)var169_74);
                                                                        var170_75 = var153_58;
                                                                        if (var145_50 == 1073741824) break block91;
                                                                        var176_81 = var166_71.width;
                                                                        var171_76 = var156_65;
                                                                        var172_77 = -1;
                                                                        if (var176_81 != var172_77) break block92;
                                                                        var173_78 = var147_52;
                                                                        break block93;
                                                                    }
                                                                    var171_76 = var156_65;
                                                                    var172_77 = -1;
                                                                }
                                                                var173_78 = 0;
                                                            }
                                                            if (var173_78 == 0) {
                                                                var168_73 = var169_74;
                                                            }
                                                            var150_55 = Math.max((int)var150_55, (int)var168_73);
                                                            var174_79 = var142_22 != 0 && var166_71.width == var172_77 ? var147_52 : 0;
                                                            var175_80 = this.j;
                                                            this.j = Math.max((int)var175_80, (int)(var175_80 + var165_70.getMeasuredHeight() + var166_71.topMargin + var166_71.bottomMargin + this.n()));
                                                            var142_22 = var174_79;
                                                            var156_65 = var171_76;
                                                        }
                                                        var153_58 = var170_75;
                                                    }
                                                    this.j += this.getPaddingTop() + this.getPaddingBottom();
                                                    ** while (true)
                                                }
                                                for (var22_105 = 0; var22_105 < var10_93; ++var22_105) {
                                                    block95 : {
                                                        block100 : {
                                                            block99 : {
                                                                block97 : {
                                                                    block98 : {
                                                                        block96 : {
                                                                            block94 : {
                                                                                var91_112 = this.getChildAt(var22_105);
                                                                                if (var91_112 != null) break block94;
                                                                                this.j += this.q();
                                                                                var106_127 = var16_99;
                                                                                var107_128 = var15_98;
                                                                                break block95;
                                                                            }
                                                                            var92_113 = var19_102;
                                                                            var93_114 = var91_112.getVisibility();
                                                                            var94_115 = var21_104;
                                                                            if (var93_114 != 8) break block96;
                                                                            var22_105 += this.l();
                                                                            var107_128 = var15_98;
                                                                            var19_102 = var92_113;
                                                                            var21_104 = var94_115;
                                                                            var106_127 = var16_99;
                                                                            break block95;
                                                                        }
                                                                        if (this.o(var22_105)) {
                                                                            this.j += this.p;
                                                                        }
                                                                        var95_116 = (a)var91_112.getLayoutParams();
                                                                        var96_117 = var95_116.a;
                                                                        var97_118 = var20_103 + var96_117;
                                                                        if (var11_94 != 1073741824 || var95_116.width != 0 || !(var96_117 > 0.0f)) break block97;
                                                                        if (var17_100 != 0) {
                                                                            var127_148 = this.j;
                                                                            var128_111 = var95_116.leftMargin;
                                                                            var124_145 = var22_105;
                                                                            this.j = var127_148 + (var128_111 + var95_116.rightMargin);
                                                                        } else {
                                                                            var124_145 = var22_105;
                                                                            var125_146 = this.j;
                                                                            this.j = Math.max((int)var125_146, (int)(var125_146 + var95_116.leftMargin + var95_116.rightMargin));
                                                                        }
                                                                        if (!var15_98) break block98;
                                                                        var126_147 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                                                                        var91_112.measure(var126_147, var126_147);
                                                                        var108_129 = var95_116;
                                                                        var101_122 = var92_113;
                                                                        var102_123 = var94_115;
                                                                        var104_125 = var124_145;
                                                                        var106_127 = var16_99;
                                                                        var107_128 = var15_98;
                                                                        break block99;
                                                                    }
                                                                    var108_129 = var95_116;
                                                                    var101_122 = var92_113;
                                                                    var102_123 = var94_115;
                                                                    var104_125 = var124_145;
                                                                    var112_133 = 1073741824;
                                                                    var106_127 = var16_99;
                                                                    var107_128 = var15_98;
                                                                    var111_132 = var9_92;
                                                                    break block100;
                                                                }
                                                                var98_119 = var22_105;
                                                                if (var95_116.width == 0 && var95_116.a > 0.0f) {
                                                                    var95_116.width = -2;
                                                                    var99_120 = 0;
                                                                } else {
                                                                    var99_120 = Integer.MIN_VALUE;
                                                                }
                                                                var100_121 = var97_118 == 0.0f ? this.j : 0;
                                                                var101_122 = var92_113;
                                                                var102_123 = var94_115;
                                                                var103_124 = var99_120;
                                                                var104_125 = var98_119;
                                                                var105_126 = var100_121;
                                                                var106_127 = var16_99;
                                                                var107_128 = var15_98;
                                                                this.p(var91_112, var1_1, var105_126, var2_2, 0);
                                                                if (var103_124 != Integer.MIN_VALUE) {
                                                                    var108_129 = var95_116;
                                                                    var108_129.width = var103_124;
                                                                } else {
                                                                    var108_129 = var95_116;
                                                                }
                                                                var109_130 = var91_112.getMeasuredWidth();
                                                                var110_131 = this.j;
                                                                this.j = var17_100 != 0 ? var110_131 + (var109_130 + var108_129.leftMargin + var108_129.rightMargin + this.n()) : Math.max((int)var110_131, (int)(var110_131 + var109_130 + var108_129.leftMargin + var108_129.rightMargin + this.n()));
                                                                if (var106_127) {
                                                                    var23_106 = Math.max((int)var109_130, (int)var23_106);
                                                                }
                                                            }
                                                            var111_132 = var26_109;
                                                            var112_133 = 1073741824;
                                                        }
                                                        if (var12_95 != var112_133 && var108_129.height == -1) {
                                                            var27_110 = var113_134 = var9_92;
                                                        } else {
                                                            var113_134 = 0;
                                                        }
                                                        var114_135 = var108_129.topMargin + var108_129.bottomMargin;
                                                        var115_136 = var114_135 + var91_112.getMeasuredHeight();
                                                        var116_137 = View.combineMeasuredStates((int)var24_107, (int)var91_112.getMeasuredState());
                                                        if (var107_128 && (var121_142 = var91_112.getBaseline()) != -1) {
                                                            var122_143 = var108_129.b;
                                                            if (var122_143 < 0) {
                                                                var122_143 = this.i;
                                                            }
                                                            var123_144 = (-2 & (var122_143 & 112) >> 4) >> 1;
                                                            var117_138 = var114_135;
                                                            var13_96[var123_144] = Math.max((int)var13_96[var123_144], (int)var121_142);
                                                            var14_97[var123_144] = Math.max((int)var14_97[var123_144], (int)(var115_136 - var121_142));
                                                        } else {
                                                            var117_138 = var114_135;
                                                        }
                                                        var118_139 = Math.max((int)var25_108, (int)var115_136);
                                                        var119_140 = var18_101 != 0 && var108_129.height == -1 ? var9_92 : 0;
                                                        if (var108_129.a > 0.0f) {
                                                            if (var113_134 != 0) {
                                                                var115_136 = var117_138;
                                                            }
                                                            var19_102 = Math.max((int)var101_122, (int)var115_136);
                                                        } else {
                                                            var120_141 = var101_122;
                                                            if (var113_134 != 0) {
                                                                var115_136 = var117_138;
                                                            }
                                                            var102_123 = Math.max((int)var102_123, (int)var115_136);
                                                            var19_102 = var120_141;
                                                        }
                                                        var22_105 = var104_125 + this.l();
                                                        var25_108 = var118_139;
                                                        var24_107 = var116_137;
                                                        var26_109 = var111_132;
                                                        var18_101 = var119_140;
                                                        var20_103 = var97_118;
                                                        var21_104 = var102_123;
                                                    }
                                                    var16_99 = var106_127;
                                                    var15_98 = var107_128;
                                                }
                                                var28_149 = var16_99;
                                                var29_150 = var15_98;
                                                var30_151 = var21_104;
                                                var31_152 = var19_102;
                                                var32_153 = var30_151;
                                                if (this.j > 0 && this.o(var10_93)) {
                                                    this.j += this.p;
                                                }
                                                if (var13_96[var9_92] != -1 || var13_96[0] != -1 || var13_96[2] != -1) break block101;
                                                var33_154 = 3;
                                                if (var13_96[var33_154] != -1) break block102;
                                                var38_155 = var24_107;
                                                break block103;
                                            }
                                            var33_154 = 3;
                                        }
                                        var34_156 = Math.max((int)var13_96[var33_154], (int)Math.max((int)var13_96[0], (int)Math.max((int)var13_96[var9_92], (int)var13_96[2])));
                                        var35_157 = var14_97[3];
                                        var36_158 = var14_97[0];
                                        var37_159 = var14_97[var9_92];
                                        var38_155 = var24_107;
                                        var25_108 = Math.max((int)var25_108, (int)(var34_156 + Math.max((int)var35_157, (int)Math.max((int)var36_158, (int)Math.max((int)var37_159, (int)var14_97[2])))));
                                    }
                                    if (var28_149 && (var11_94 == Integer.MIN_VALUE || var11_94 == 0)) {
                                        this.j = 0;
                                        for (var86_160 = 0; var86_160 < var10_93; ++var86_160) {
                                            var87_161 = this.getChildAt(var86_160);
                                            if (var87_161 == null) {
                                                this.j += this.q();
                                                continue;
                                            }
                                            if (var87_161.getVisibility() == 8) {
                                                var86_160 += this.l();
                                                continue;
                                            }
                                            var88_162 = (a)var87_161.getLayoutParams();
                                            var89_163 = this.j;
                                            var90_164 = var17_100 != 0 ? var89_163 + (var23_106 + var88_162.leftMargin + var88_162.rightMargin + this.n()) : Math.max((int)var89_163, (int)(var89_163 + var23_106 + var88_162.leftMargin + var88_162.rightMargin + this.n()));
                                            this.j = var90_164;
                                        }
                                    }
                                    this.j = var39_165 = this.j + (this.getPaddingLeft() + this.getPaddingRight());
                                    var40_166 = View.resolveSizeAndState((int)Math.max((int)var39_165, (int)this.getSuggestedMinimumWidth()), (int)var1_1, (int)0);
                                    var41_167 = (16777215 & var40_166) - this.j;
                                    if (var26_109 != 0 || var41_167 != 0 && var20_103 > 0.0f) break block104;
                                    var32_153 = Math.max((int)var32_153, (int)var31_152);
                                    if (!var28_149 || var11_94 == 1073741824) break block105;
                                    break block106;
                                }
                                var42_173 = this.k;
                                if (var42_173 > 0.0f) {
                                    var20_103 = var42_173;
                                }
                                var13_96[3] = -1;
                                var13_96[2] = -1;
                                var13_96[var9_92] = -1;
                                var13_96[0] = -1;
                                var14_97[3] = -1;
                                var14_97[2] = -1;
                                var14_97[var9_92] = -1;
                                var14_97[0] = -1;
                                this.j = 0;
                                var43_174 = var41_167;
                                var44_172 = var38_155;
                                var45_175 = -1;
                                break block107;
                            }
                            for (var84_168 = 0; var84_168 < var10_93; ++var84_168) {
                                var85_169 = this.getChildAt(var84_168);
                                if (var85_169 == null || var85_169.getVisibility() == 8 || !(((a)var85_169.getLayoutParams()).a > 0.0f)) continue;
                                var85_169.measure(View.MeasureSpec.makeMeasureSpec((int)var23_106, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)var85_169.getMeasuredHeight(), (int)1073741824));
                            }
                        }
                        var47_170 = var2_2;
                        var48_171 = var10_93;
                        var44_172 = var38_155;
                        break block108;
                    }
                    for (var46_176 = 0; var46_176 < var10_93; ++var46_176) {
                        block118 : {
                            block109 : {
                                block117 : {
                                    block116 : {
                                        block115 : {
                                            block114 : {
                                                block110 : {
                                                    block113 : {
                                                        block112 : {
                                                            block111 : {
                                                                var57_178 = this.getChildAt(var46_176);
                                                                if (var57_178 == null || var57_178.getVisibility() == 8) break block109;
                                                                var60_181 = (a)var57_178.getLayoutParams();
                                                                var61_182 = var60_181.a;
                                                                if (!(var61_182 > 0.0f)) break block110;
                                                                var59_180 = var10_93;
                                                                var79_200 = (int)(var61_182 * (float)var43_174 / var20_103);
                                                                var80_201 = var20_103 - var61_182;
                                                                var81_202 = var43_174 - var79_200;
                                                                var82_203 = ViewGroup.getChildMeasureSpec((int)var2_2, (int)(this.getPaddingTop() + this.getPaddingBottom() + var60_181.topMargin + var60_181.bottomMargin), (int)var60_181.height);
                                                                if (var60_181.width != 0 || var11_94 != 1073741824) break block111;
                                                                if (var79_200 <= 0) break block112;
                                                                var83_204 = var79_200;
                                                                break block113;
                                                            }
                                                            var83_204 = var79_200 + var57_178.getMeasuredWidth();
                                                            if (var83_204 >= 0) break block113;
                                                        }
                                                        var83_204 = 0;
                                                    }
                                                    var57_178.measure(View.MeasureSpec.makeMeasureSpec((int)var83_204, (int)1073741824), var82_203);
                                                    var44_172 = View.combineMeasuredStates((int)var44_172, (int)(-16777216 & var57_178.getMeasuredState()));
                                                    var20_103 = var80_201;
                                                    var62_183 = var81_202;
                                                    break block114;
                                                }
                                                var62_183 = var43_174;
                                                var59_180 = var10_93;
                                            }
                                            if (var17_100 != 0) {
                                                var77_198 = this.j;
                                                var78_199 = var57_178.getMeasuredWidth();
                                                var63_184 = var20_103;
                                                var67_188 = var77_198 + (var78_199 + var60_181.leftMargin + var60_181.rightMargin + this.n());
                                                var66_187 = var62_183;
                                            } else {
                                                var63_184 = var20_103;
                                                var64_185 = this.j;
                                                var65_186 = var64_185 + var57_178.getMeasuredWidth();
                                                var66_187 = var62_183;
                                                var67_188 = Math.max((int)var64_185, (int)(var65_186 + var60_181.leftMargin + var60_181.rightMargin + this.n()));
                                            }
                                            this.j = var67_188;
                                            var68_189 = var12_95 != 1073741824 && var60_181.height == -1 ? var9_92 : 0;
                                            var69_190 = var60_181.topMargin + var60_181.bottomMargin;
                                            var70_191 = var69_190 + var57_178.getMeasuredHeight();
                                            var45_175 = Math.max((int)var45_175, (int)var70_191);
                                            if (var68_189 == 0) {
                                                var69_190 = var70_191;
                                            }
                                            var32_153 = Math.max((int)var32_153, (int)var69_190);
                                            if (var18_101 == 0) break block115;
                                            var76_197 = var60_181.height;
                                            var71_192 = -1;
                                            if (var76_197 != var71_192) break block116;
                                            var72_193 = var9_92;
                                            break block117;
                                        }
                                        var71_192 = -1;
                                    }
                                    var72_193 = 0;
                                }
                                if (var29_150 && (var73_194 = var57_178.getBaseline()) != var71_192) {
                                    var74_195 = var60_181.b;
                                    if (var74_195 < 0) {
                                        var74_195 = this.i;
                                    }
                                    var75_196 = (-2 & (var74_195 & 112) >> 4) >> 1;
                                    var13_96[var75_196] = Math.max((int)var13_96[var75_196], (int)var73_194);
                                    var14_97[var75_196] = Math.max((int)var14_97[var75_196], (int)(var70_191 - var73_194));
                                }
                                var18_101 = var72_193;
                                var58_179 = var66_187;
                                var20_103 = var63_184;
                                break block118;
                            }
                            var58_179 = var43_174;
                            var59_180 = var10_93;
                        }
                        var43_174 = var58_179;
                        var10_93 = var59_180;
                    }
                    var47_170 = var2_2;
                    var48_171 = var10_93;
                    this.j += this.getPaddingLeft() + this.getPaddingRight();
                    if (var13_96[var9_92] != -1 || var13_96[0] != -1 || var13_96[2] != -1) break block119;
                    var49_177 = 3;
                    if (var13_96[var49_177] != -1) break block120;
                    var25_108 = var45_175;
                    break block108;
                }
                var49_177 = 3;
            }
            var25_108 = Math.max((int)var45_175, (int)(Math.max((int)var13_96[var49_177], (int)Math.max((int)var13_96[0], (int)Math.max((int)var13_96[var9_92], (int)var13_96[2]))) + Math.max((int)var14_97[var49_177], (int)Math.max((int)var14_97[0], (int)Math.max((int)var14_97[var9_92], (int)var14_97[2])))));
        }
        if (var18_101 != 0 || var12_95 == 1073741824) {
            var32_153 = var25_108;
        }
        var50_205 = Math.max((int)(var32_153 + (this.getPaddingTop() + this.getPaddingBottom())), (int)this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(var40_166 | -16777216 & var44_172, View.resolveSizeAndState((int)var50_205, (int)var47_170, (int)(var44_172 << 16)));
        if (var27_110 == 0) return;
        var51_206 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)1073741824);
        var52_207 = 0;
        var53_208 = var48_171;
        while (var52_207 < var53_208) {
            var54_209 = this.getChildAt(var52_207);
            if (var54_209.getVisibility() != 8) {
                var55_210 = (a)var54_209.getLayoutParams();
                if (var55_210.height == -1) {
                    var56_211 = var55_210.width;
                    var55_210.width = var54_209.getMeasuredWidth();
                    this.measureChildWithMargins(var54_209, var1_1, 0, var51_206, 0);
                    var55_210.width = var56_211;
                }
            }
            ++var52_207;
        }
    }

    public void p(View view, int n2, int n3, int n4, int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }

    public int q() {
        return 0;
    }

    public void setBaselineAligned(boolean bl) {
        this.e = bl;
    }

    public void setBaselineAlignedChildIndex(int n2) {
        if (n2 >= 0 && n2 < this.getChildCount()) {
            this.f = n2;
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.c((String)"base aligned child index out of range (0, ");
        stringBuilder.append(this.getChildCount());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.o) {
            return;
        }
        this.o = drawable;
        if (drawable != null) {
            this.p = drawable.getIntrinsicWidth();
            this.q = drawable.getIntrinsicHeight();
        } else {
            this.p = 0;
            this.q = 0;
        }
        boolean bl = false;
        if (drawable == null) {
            bl = true;
        }
        this.setWillNotDraw(bl);
        this.requestLayout();
    }

    public void setDividerPadding(int n2) {
        this.s = n2;
    }

    public void setGravity(int n2) {
        if (this.i != n2) {
            if ((8388615 & n2) == 0) {
                n2 |= 8388611;
            }
            if ((n2 & 112) == 0) {
                n2 |= 48;
            }
            this.i = n2;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int n2) {
        int n3 = this.i;
        int n4 = n2 & 8388615;
        if ((8388615 & n3) != n4) {
            this.i = n4 | -8388616 & n3;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean bl) {
        this.l = bl;
    }

    public void setOrientation(int n2) {
        if (this.h != n2) {
            this.h = n2;
            this.requestLayout();
        }
    }

    public void setShowDividers(int n2) {
        if (n2 != this.r) {
            this.requestLayout();
        }
        this.r = n2;
    }

    public void setVerticalGravity(int n2) {
        int n3 = this.i;
        int n4 = n2 & 112;
        if ((n3 & 112) != n4) {
            this.i = n4 | n3 & -113;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.k = Math.max((float)0.0f, (float)f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static class a
    extends ViewGroup.MarginLayoutParams {
        public float a;
        public int b = -1;

        public a(int n2, int n3) {
            super(n2, n3);
            this.a = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, j.LinearLayoutCompat_Layout);
            this.a = typedArray.getFloat(j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.b = typedArray.getInt(j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArray.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

}

