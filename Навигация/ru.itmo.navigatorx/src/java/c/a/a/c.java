/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ComposePathEffect
 *  android.graphics.CornerPathEffect
 *  android.graphics.DashPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.PathEffect
 *  android.graphics.PathMeasure
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.ImageView
 *  androidx.appcompat.widget.AppCompatImageView
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import f.b.k.h;
import h.m.b.j;
import java.util.ArrayList;
import java.util.List;

public final class c
extends AppCompatImageView {
    public final CornerPathEffect g;
    public final Paint h;
    public final Paint i;
    public final Path j;
    public final float[] k;
    public final float[] l;
    public List<b> m;
    public PathMeasure n;
    public float o;
    public int p;
    public int q;

    public c(Context context, AttributeSet attributeSet, int n2, int n3) {
        n3 & 2;
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        j.e((Object)context, "context");
        super(context, null, n2);
        this.g = new CornerPathEffect(32.0f);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(16.0f);
        paint.setPathEffect((PathEffect)this.g);
        this.h = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.i = paint2;
        Path path = new Path();
        path.addCircle(0.0f, 0.0f, 8.0f, Path.Direction.CW);
        this.j = path;
        this.k = new float[2];
        this.l = new float[2];
        this.m = new ArrayList();
        this.n = new PathMeasure();
        this.o = 1.0f;
    }

    public final int getMapHeight() {
        return this.q;
    }

    public final int getMapWidth() {
        return this.p;
    }

    public final float getPathProgress() {
        return this.o;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"CanvasSize", "DrawAllocation"})
    public void onDraw(Canvas var1_1) {
        j.e((Object)var1_1, "canvas");
        var2_2 = this.getDrawable();
        if (!(var2_2 instanceof BitmapDrawable)) {
            var2_2 = null;
        }
        if ((var3_3 = (BitmapDrawable)var2_2) != null && (var23_4 = var3_3.getBitmap()) != null && var23_4.isRecycled()) {
            return;
        }
        ImageView.super.onDraw(var1_1);
        var4_5 = (float)var1_1.getWidth() / (float)this.p;
        var5_6 = (float)var1_1.getHeight() / (float)this.q;
        var6_7 = var1_1.save();
        var1_1.scale(var4_5, var5_6, 0.0f, 0.0f);
        try {
            for (b var9_9 : this.m) {
                this.h.setColor(var9_9.c);
                this.i.setColor(var9_9.c);
                if (this.o <= 1.0f) {
                    var20_16 = new float[]{this.o * var9_9.b, 0.0f, 0.0f, (1.0f - this.o) * var9_9.b};
                    var21_17 = new DashPathEffect(var20_16, 0.0f);
                    this.h.setPathEffect((PathEffect)new ComposePathEffect((PathEffect)var21_17, (PathEffect)this.g));
                }
                var1_1.drawPath(var9_9.a, this.h);
                this.n.setPath(var9_9.a, false);
                this.n.getPosTan(this.o * var9_9.b, this.k, this.l);
                if (this.o != 1.0f) ** GOTO lbl39
                var16_13 = this.k[0];
                var17_14 = this.k[1];
                var18_15 = var1_1.save();
                var1_1.translate(var16_13, var17_14);
            }
        }
        catch (Throwable var7_20) {
            var1_1.restoreToCount(var6_7);
            throw var7_20;
        }
        {
            var1_1.drawPath(this.j, this.i);
            {
                catch (Throwable var19_18) {
                    var1_1.restoreToCount(var18_15);
                    throw var19_18;
                }
            }
            var1_1.restoreToCount(var18_15);
lbl39: // 2 sources:
            this.n.getPosTan(0.0f, this.k, this.l);
            var12_10 = this.k[0];
            var13_11 = this.k[1];
            var14_12 = var1_1.save();
            var1_1.translate(var12_10, var13_11);
            var1_1.drawPath(this.j, this.i);
            {
                catch (Throwable var15_19) {
                    var1_1.restoreToCount(var14_12);
                    throw var15_19;
                }
            }
            var1_1.restoreToCount(var14_12);
            continue;
        }
        var1_1.restoreToCount(var6_7);
    }

    public final void setMapHeight(int n2) {
        this.q = n2;
    }

    public final void setMapWidth(int n2) {
        this.p = n2;
    }

    public final void setPathProgress(float f2) {
        this.o = h.i.v(f2, 0.0f, 1.0f);
        this.invalidateDrawable(this.getDrawable());
    }

}

