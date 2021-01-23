/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  f.b.p.e0$a
 *  f.h.l.q
 *  f.h.m.a
 *  f.h.m.c
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package f.b.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import f.b.p.e0;
import f.h.l.q;
import f.h.m.c;
import java.lang.reflect.Field;

/*
 * Exception performing whole class analysis.
 */
public class e0
extends ListView {
    public final Rect e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Field k;
    public a l;
    public boolean m;
    public boolean n;
    public boolean o;
    public q p;
    public c q;
    public b r;

    public e0(Context context, boolean bl) {
        super(context, null, f.b.a.dropDownListViewStyle);
        this.e = new Rect();
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.n = bl;
        this.setCacheColorHint(0);
        try {
            Field field;
            this.k = field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
            return;
        }
    }

    private void setSelectorEnabled(boolean bl) {
        a a2 = this.l;
        if (a2 != null) {
            a2.f = bl;
        }
    }

    public int a(int n2, int n3, int n4) {
        int n5 = this.getListPaddingTop();
        int n6 = this.getListPaddingBottom();
        int n7 = this.getDividerHeight();
        Drawable drawable = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        int n8 = n5 + n6;
        if (listAdapter == null) {
            return n8;
        }
        if (n7 <= 0 || drawable == null) {
            n7 = 0;
        }
        int n9 = listAdapter.getCount();
        int n10 = 0;
        int n11 = 0;
        View view = null;
        for (int i2 = 0; i2 < n9; ++i2) {
            ViewGroup.LayoutParams layoutParams;
            int n12;
            int n13 = listAdapter.getItemViewType(i2);
            if (n13 != n10) {
                view = null;
                n10 = n13;
            }
            if ((layoutParams = (view = listAdapter.getView(i2, view, (ViewGroup)this)).getLayoutParams()) == null) {
                layoutParams = this.generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int n14 = (n12 = layoutParams.height) > 0 ? View.MeasureSpec.makeMeasureSpec((int)n12, (int)1073741824) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            view.measure(n2, n14);
            view.forceLayout();
            if (i2 > 0) {
                n8 += n7;
            }
            if ((n8 += view.getMeasuredHeight()) >= n3) {
                if (n4 >= 0 && i2 > n4 && n11 > 0 && n8 != n3) {
                    n3 = n11;
                }
                return n3;
            }
            if (n4 < 0 || i2 < n4) continue;
            n11 = n8;
        }
        return n8;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean b(MotionEvent var1_1, int var2_2) {
        block22 : {
            block23 : {
                block20 : {
                    block21 : {
                        var3_3 = var1_1.getActionMasked();
                        if (var3_3 == (var4_4 = 1)) break block20;
                        if (var3_3 == 2) break block21;
                        if (var3_3 == 3) ** GOTO lbl-1000
                        var5_5 = var4_4;
                        var4_4 = 0;
                        break block22;
                    }
                    var5_5 = var4_4;
                    break block23;
                }
                var5_5 = 0;
            }
            var6_6 = var1_1.findPointerIndex(var2_2);
            if (var6_6 < 0) lbl-1000: // 2 sources:
            {
                var5_5 = 0;
                var4_4 = 0;
            } else {
                var7_7 = (int)var1_1.getX(var6_6);
                var9_9 = this.pointToPosition(var7_7, var8_8 = (int)var1_1.getY(var6_6));
                if (var9_9 != -1) {
                    var10_10 = this.getChildAt(var9_9 - this.getFirstVisiblePosition());
                    var11_11 = var7_7;
                    var12_12 = var8_8;
                    this.o = var4_4;
                    this.drawableHotspotChanged(var11_11, var12_12);
                    if (!this.isPressed()) {
                        this.setPressed((boolean)var4_4);
                    }
                    this.layoutChildren();
                    var13_13 = this.j;
                    if (var13_13 != -1 && (var35_14 = this.getChildAt(var13_13 - this.getFirstVisiblePosition())) != null && var35_14 != var10_10 && var35_14.isPressed()) {
                        var35_14.setPressed(false);
                    }
                    this.j = var9_9;
                    var10_10.drawableHotspotChanged(var11_11 - (float)var10_10.getLeft(), var12_12 - (float)var10_10.getTop());
                    if (!var10_10.isPressed()) {
                        var10_10.setPressed((boolean)var4_4);
                    }
                    if (var15_16 = (var14_15 = this.getSelector()) != null && var9_9 != -1 ? var4_4 : 0) {
                        var14_15.setVisible(false, false);
                    }
                    var16_17 = this.e;
                    var16_17.set(var10_10.getLeft(), var10_10.getTop(), var10_10.getRight(), var10_10.getBottom());
                    var16_17.left -= this.f;
                    var16_17.top -= this.g;
                    var16_17.right += this.h;
                    var16_17.bottom += this.i;
                    try {
                        var31_18 = this.k.getBoolean((Object)this);
                        if (var10_10.isEnabled() != var31_18) {
                            var32_19 = this.k;
                            var33_20 = var31_18 == false;
                            var32_19.set((Object)this, (Object)var33_20);
                            if (var9_9 != -1) {
                                this.refreshDrawableState();
                            }
                        }
                    }
                    catch (IllegalAccessException var17_21) {
                        var17_21.printStackTrace();
                    }
                    if (var15_16) {
                        var26_22 = this.e;
                        var27_23 = var26_22.exactCenterX();
                        var28_24 = var26_22.exactCenterY();
                        var29_25 = this.getVisibility() == 0;
                        var14_15.setVisible(var29_25, false);
                        var14_15.setHotspot(var27_23, var28_24);
                    }
                    if ((var18_26 = this.getSelector()) != null && var9_9 != -1) {
                        var18_26.setHotspot(var11_11, var12_12);
                    }
                    this.setSelectorEnabled(false);
                    this.refreshDrawableState();
                    if (var3_3) {
                        this.performItemClick(var10_10, var9_9, this.getItemIdAtPosition(var9_9));
                    }
                    var4_4 = 0;
                    var5_5 = 1;
                }
            }
        }
        if (!var5_5 || var4_4) {
            this.o = false;
            this.setPressed(false);
            this.drawableStateChanged();
            var19_27 = this.getChildAt(this.j - this.getFirstVisiblePosition());
            if (var19_27 != null) {
                var19_27.setPressed(false);
            }
            if ((var20_28 = this.p) != null) {
                var20_28.b();
                this.p = null;
            }
        }
        if (var5_5) {
            if (this.q == null) {
                this.q = new c((ListView)this);
            }
            var22_29 = this.q;
            var22_29.t = true;
            var22_29.onTouch((View)this, var1_1);
            return (boolean)var5_5;
        }
        var21_30 = this.q;
        if (var21_30 == null) return (boolean)var5_5;
        if (var21_30.t) {
            var21_30.d();
        }
        var21_30.t = false;
        return (boolean)var5_5;
    }

    public final void c() {
        Drawable drawable = this.getSelector();
        if (drawable != null && this.o && this.isPressed()) {
            drawable.setState(this.getDrawableState());
        }
    }

    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        if (!this.e.isEmpty() && (drawable = this.getSelector()) != null) {
            drawable.setBounds(this.e);
            drawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.r != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.c();
    }

    public boolean hasFocus() {
        return this.n || super.hasFocus();
        {
        }
    }

    public boolean hasWindowFocus() {
        return this.n || super.hasWindowFocus();
        {
        }
    }

    public boolean isFocused() {
        return this.n || super.isFocused();
        {
        }
    }

    public boolean isInTouchMode() {
        return this.n && this.m || super.isInTouchMode();
    }

    public void onDetachedFromWindow() {
        this.r = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int n2 = motionEvent.getActionMasked();
        if (n2 == 10 && this.r == null) {
            b b2;
            this.r = b2 = new b();
            b2.e0.this.post((Runnable)b2);
        }
        boolean bl = super.onHoverEvent(motionEvent);
        if (n2 != 9 && n2 != 7) {
            this.setSelection(-1);
            return bl;
        }
        int n3 = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        if (n3 != -1 && n3 != this.getSelectedItemPosition()) {
            View view = this.getChildAt(n3 - this.getFirstVisiblePosition());
            if (view.isEnabled()) {
                this.setSelectionFromTop(n3, view.getTop() - this.getTop());
            }
            this.c();
        }
        return bl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.j = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        b b2 = this.r;
        if (b2 != null) {
            e0 e02 = b2.e0.this;
            e02.r = null;
            e02.removeCallbacks((Runnable)b2);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean bl) {
        this.m = bl;
    }

    public void setSelector(Drawable drawable) {
        a a2 = drawable != null ? new /* Unavailable Anonymous Inner Class!! */ : null;
        this.l = a2;
        super.setSelector((Drawable)a2);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f = rect.left;
        this.g = rect.top;
        this.h = rect.right;
        this.i = rect.bottom;
    }

    public class b
    implements Runnable {
        public void run() {
            e0 e02 = e0.this;
            e02.r = null;
            e02.drawableStateChanged();
        }
    }

}

