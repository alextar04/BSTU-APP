/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  c.a.a.o.c.a
 *  c.a.a.o.c.b
 *  c.a.a.o.c.c$a
 *  c.a.a.o.e.b
 *  c.a.a.o.e.c
 *  e
 *  h.h
 *  h.m.a.l
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a.o.c;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.ScaleGestureDetector;
import c.a.a.i;
import c.a.a.k;
import c.a.a.o.c.b;
import c.a.a.o.c.c;
import c.a.a.o.d.b;
import h.h;
import h.m.a.l;
import h.m.b.f;
import h.m.b.j;

public final class c
implements ScaleGestureDetector.OnScaleGestureListener {
    public static final String h;
    public static final k i;
    public final ScaleGestureDetector a;
    public final c.a.a.b b;
    public final c.a.a.b c;
    public final c.a.a.o.e.c d;
    public final c.a.a.o.e.b e;
    public final c.a.a.o.a f;
    public final c.a.a.o.d.a g;

    public static {
        String string = h = c.class.getSimpleName();
        j.d((Object)string, (String)"TAG");
        j.e((Object)string, (String)"tag");
        i = new k(string, null);
    }

    public c(Context context, c.a.a.o.e.c c2, c.a.a.o.e.b b2, c.a.a.o.a a2, c.a.a.o.d.a a3) {
        ScaleGestureDetector scaleGestureDetector;
        j.e((Object)context, (String)"context");
        j.e((Object)c2, (String)"zoomManager");
        j.e((Object)b2, (String)"panManager");
        j.e((Object)a2, (String)"stateController");
        j.e((Object)a3, (String)"matrixController");
        this.d = c2;
        this.e = b2;
        this.f = a2;
        this.g = a3;
        this.a = scaleGestureDetector = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)this);
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.b = new c.a.a.b(Float.NaN, Float.NaN);
        this.c = new c.a.a.b(0.0f, 0.0f);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        j.e((Object)scaleGestureDetector, (String)"detector");
        if (!this.d.h) {
            return false;
        }
        if (!this.f.c(2)) {
            return false;
        }
        PointF pointF = new PointF(-scaleGestureDetector.getFocusX(), -scaleGestureDetector.getFocusY());
        c.a.a.o.d.a a2 = this.g;
        RectF rectF = a2.a;
        float f2 = rectF.left + pointF.x;
        float f3 = rectF.top + pointF.y;
        float f4 = a2.m();
        c.a.a.b b2 = new c.a.a.b(0.0f, 0.0f, 3);
        j.e((Object)b2, (String)"outPoint");
        b2.d((Number)Float.valueOf((float)(f2 / f4)), (Number)Float.valueOf((float)(f3 / f4)));
        if (Float.isNaN((float)this.b.a)) {
            this.b.c(b2);
            k k2 = i;
            Object[] arrobject = new Object[]{"onScale:", "Setting initial focus:", this.b};
            k2.a(arrobject);
        } else {
            this.c.c(this.b.a(b2));
            k k3 = i;
            Object[] arrobject = new Object[]{"onScale:", "Got focus offset:", this.c};
            k3.a(arrobject);
        }
        float f5 = this.g.m() * scaleGestureDetector.getScaleFactor();
        this.g.d((l<? super b.a, h>)new a(this, f5, scaleGestureDetector));
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        j.e((Object)scaleGestureDetector, (String)"detector");
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onScaleEnd(ScaleGestureDetector var1_1) {
        j.e((Object)var1_1, (String)"detector");
        var2_2 = c.i;
        var3_3 = new Object[]{"onScaleEnd:", "mInitialAbsFocusPoint.x:", Float.valueOf((float)this.b.a), "mInitialAbsFocusPoint.y:", Float.valueOf((float)this.b.b), "mOverZoomEnabled;", this.d.i};
        var2_2.a(var3_3);
        var4_4 = this.d.i;
        var5_5 = Float.valueOf((float)0.0f);
        if (!var4_4 && !this.e.h()) ** GOTO lbl-1000
        var6_6 = this.d.c();
        var7_7 = this.d.d();
        var8_8 = this.d.b(this.g.m(), false);
        var9_9 = c.i;
        var10_10 = new Object[]{"onScaleEnd:", "zoom:", Float.valueOf((float)this.g.m()), "newZoom:", Float.valueOf((float)var8_8), "max:", Float.valueOf((float)var6_6), "min:", Float.valueOf((float)var7_7)};
        var9_9.a(var10_10);
        var11_11 = i.c(this.e.e(), this.g.m(), null, 2);
        if (var11_11.a == 0.0f && var11_11.b == 0.0f && Float.compare((float)var8_8, (float)this.g.m()) == 0) lbl-1000: // 2 sources:
        {
            this.f.a();
        } else {
            if (this.g.m() <= 1.0f) {
                var23_12 = -this.g.h() / 2.0f;
                var24_13 = -this.g.e() / 2.0f;
                var25_14 = this.g.m();
                var26_15 = Float.valueOf((float)(var23_12 * var25_14));
                var27_16 = Float.valueOf((float)(var24_13 * var25_14));
                j.e((Object)var26_15, (String)"x");
                j.e((Object)var27_16, (String)"y");
                var28_17 = var26_15.floatValue();
                var29_18 = var27_16.floatValue();
                var30_19 = this.g.l();
                j.e((Object)var30_19, (String)"scaledPoint");
                var17_20 = new PointF(var28_17 - var30_19.a, var29_18 - var30_19.b);
                var17_20.set(-var17_20.x, -var17_20.y);
            } else {
                var12_21 = var11_11.a;
                var13_22 = (float)false;
                var14_23 = var12_21 > var13_22 ? this.g.f : (var12_21 < var13_22 ? 0.0f : this.g.f / 2.0f);
                var15_24 = var11_11.b;
                var16_25 = var15_24 > var13_22 ? this.g.g : (var15_24 < var13_22 ? 0.0f : this.g.g / 2.0f);
                var17_20 = new PointF(var14_23, var16_25);
            }
            var18_26 = this.g.i().b(var11_11);
            if (Float.compare((float)var8_8, (float)this.g.m()) != 0) {
                var19_27 = this.g.i();
                j.e((Object)var19_27, (String)"point");
                var20_28 = new c.a.a.b(var19_27.a, var19_27.b);
                var21_29 = this.g.m();
                this.g.d((l<? super b.a, h>)new e(0, var8_8, (Object)var17_20));
                var22_30 = i.c(this.e.e(), this.g.m(), null, 2);
                var18_26.c(this.g.i().b(var22_30));
                this.g.d((l<? super b.a, h>)new e(1, var21_29, (Object)var20_28));
                var11_11 = var22_30;
            }
            if (var11_11.a == 0.0f && var11_11.b == 0.0f) {
                this.g.b((l<? super b.a, h>)new c.a.a.o.c.a(var8_8));
            } else {
                this.g.b((l<? super b.a, h>)new b(var8_8, var18_26, var17_20));
            }
        }
        this.b.d((Number)Float.valueOf((float)Float.NaN), (Number)Float.valueOf((float)Float.NaN));
        this.c.d((Number)var5_5, (Number)var5_5);
    }
}

