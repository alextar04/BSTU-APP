/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.BitSet
 *  java.util.Objects
 */
package c.e.a.a.f0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import c.e.a.a.f0.c;
import c.e.a.a.f0.h;
import c.e.a.a.f0.j;
import c.e.a.a.f0.k;
import c.e.a.a.f0.m;
import c.e.a.a.f0.n;
import f.b.k.h;
import java.util.BitSet;
import java.util.Objects;

public class g
extends Drawable
implements n {
    public static final String A = g.class.getSimpleName();
    public static final Paint B = new Paint(1);
    public b e;
    public final m.f[] f = new m.f[4];
    public final m.f[] g = new m.f[4];
    public final BitSet h = new BitSet(8);
    public boolean i;
    public final Matrix j = new Matrix();
    public final Path k = new Path();
    public final Path l = new Path();
    public final RectF m = new RectF();
    public final RectF n = new RectF();
    public final Region o = new Region();
    public final Region p = new Region();
    public j q;
    public final Paint r = new Paint(1);
    public final Paint s = new Paint(1);
    public final c.e.a.a.e0.a t = new c.e.a.a.e0.a();
    public final k.a u;
    public final k v = new k();
    public PorterDuffColorFilter w;
    public PorterDuffColorFilter x;
    public final RectF y = new RectF();
    public boolean z = true;

    public g() {
        this(new j());
    }

    public g(b b2) {
        this.e = b2;
        this.s.setStyle(Paint.Style.STROKE);
        this.r.setStyle(Paint.Style.FILL);
        B.setColor(-1);
        B.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.w();
        this.v(this.getState());
        this.u = new k.a(){};
    }

    public g(j j2) {
        this(new Drawable.ConstantState(j2, null){
            public j a;
            public c.e.a.a.x.a b;
            public ColorFilter c;
            public ColorStateList d = null;
            public ColorStateList e = null;
            public ColorStateList f = null;
            public ColorStateList g = null;
            public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
            public Rect i = null;
            public float j = 1.0f;
            public float k = 1.0f;
            public float l;
            public int m = 255;
            public float n = 0.0f;
            public float o = 0.0f;
            public float p = 0.0f;
            public int q = 0;
            public int r = 0;
            public int s = 0;
            public int t = 0;
            public boolean u = false;
            public Paint.Style v = Paint.Style.FILL_AND_STROKE;
            {
                this.a = b2.a;
                this.b = b2.b;
                this.l = b2.l;
                this.c = b2.c;
                this.d = b2.d;
                this.e = b2.e;
                this.h = b2.h;
                this.g = b2.g;
                this.m = b2.m;
                this.j = b2.j;
                this.s = b2.s;
                this.q = b2.q;
                this.u = b2.u;
                this.k = b2.k;
                this.n = b2.n;
                this.o = b2.o;
                this.p = b2.p;
                this.r = b2.r;
                this.t = b2.t;
                this.f = b2.f;
                this.v = b2.v;
                if (b2.i != null) {
                    this.i = new Rect(b2.i);
                }
            }
            {
                this.a = j2;
                this.b = null;
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                g g2 = new g(this);
                g2.i = true;
                return g2;
            }
        });
    }

    public static g f(Context context, float f2) {
        int n2 = h.i.t1(context, c.e.a.a.b.colorSurface, g.class.getSimpleName());
        g g2 = new g();
        g2.e.b = new c.e.a.a.x.a(context);
        g2.x();
        g2.q(ColorStateList.valueOf((int)n2));
        b b2 = g2.e;
        if (b2.o != f2) {
            b2.o = f2;
            g2.x();
        }
        return g2;
    }

    public final void b(RectF rectF, Path path) {
        this.c(rectF, path);
        if (this.e.j != 1.0f) {
            this.j.reset();
            Matrix matrix = this.j;
            float f2 = this.e.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.j);
        }
        path.computeBounds(this.y, true);
    }

    public final void c(RectF rectF, Path path) {
        k k2 = this.v;
        b b2 = this.e;
        k2.a(b2.a, b2.k, rectF, this.u, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean bl) {
        int n2;
        int n3;
        if (colorStateList != null && mode != null) {
            int n4 = colorStateList.getColorForState(this.getState(), 0);
            if (bl) {
                n4 = this.e(n4);
            }
            return new PorterDuffColorFilter(n4, mode);
        }
        PorterDuffColorFilter porterDuffColorFilter = bl && (n3 = this.e(n2 = paint.getColor())) != n2 ? new PorterDuffColorFilter(n3, PorterDuff.Mode.SRC_IN) : null;
        return porterDuffColorFilter;
    }

    public void draw(Canvas canvas) {
        block15 : {
            int n2;
            int n3;
            boolean bl;
            block17 : {
                block16 : {
                    block12 : {
                        block14 : {
                            block13 : {
                                boolean bl2;
                                this.r.setColorFilter((ColorFilter)this.w);
                                n2 = this.r.getAlpha();
                                Paint paint = this.r;
                                int n4 = this.e.m;
                                paint.setAlpha(n2 * (n4 + (n4 >>> 7)) >>> 8);
                                this.s.setColorFilter((ColorFilter)this.x);
                                this.s.setStrokeWidth(this.e.l);
                                n3 = this.s.getAlpha();
                                Paint paint2 = this.s;
                                int n5 = this.e.m;
                                paint2.setAlpha(n3 * (n5 + (n5 >>> 7)) >>> 8);
                                if (this.i) {
                                    float f2 = -this.l();
                                    j j2 = this.e.a;
                                    if (j2 != null) {
                                        j j3;
                                        j.b b2 = new j.b(j2);
                                        c c2 = j2.e;
                                        if (!(c2 instanceof h)) {
                                            c2 = new c.e.a.a.f0.b(f2, c2);
                                        }
                                        b2.e = c2;
                                        c c3 = j2.f;
                                        if (!(c3 instanceof h)) {
                                            c3 = new c.e.a.a.f0.b(f2, c3);
                                        }
                                        b2.f = c3;
                                        c c4 = j2.h;
                                        if (!(c4 instanceof h)) {
                                            c4 = new c.e.a.a.f0.b(f2, c4);
                                        }
                                        b2.h = c4;
                                        c c5 = j2.g;
                                        if (!(c5 instanceof h)) {
                                            c5 = new c.e.a.a.f0.b(f2, c5);
                                        }
                                        b2.g = c5;
                                        this.q = j3 = b2.a();
                                        k k2 = this.v;
                                        float f3 = this.e.k;
                                        this.n.set(this.i());
                                        float f4 = this.l();
                                        this.n.inset(f4, f4);
                                        k2.a(j3, f3, this.n, null, this.l);
                                        this.b(this.i(), this.k);
                                        this.i = false;
                                    } else {
                                        throw null;
                                    }
                                }
                                b b3 = this.e;
                                int n6 = b3.q;
                                boolean bl3 = n6 != 1 && b3.r > 0 && (n6 == 2 || (bl2 = !b3.a.d(this.i()) && !this.k.isConvex() && Build.VERSION.SDK_INT < 29));
                                if (!bl3) break block12;
                                canvas.save();
                                int n7 = this.j();
                                int n8 = this.k();
                                canvas.translate((float)n7, (float)n8);
                                if (this.z) break block13;
                                this.g(canvas);
                                break block14;
                            }
                            int n9 = (int)(this.y.width() - (float)this.getBounds().width());
                            int n10 = (int)(this.y.height() - (float)this.getBounds().height());
                            if (n9 < 0 || n10 < 0) break block15;
                            Bitmap bitmap = Bitmap.createBitmap((int)(n9 + ((int)this.y.width() + 2 * this.e.r)), (int)(n10 + ((int)this.y.height() + 2 * this.e.r)), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(bitmap);
                            float f5 = this.getBounds().left - this.e.r - n9;
                            float f6 = this.getBounds().top - this.e.r - n10;
                            canvas2.translate(-f5, -f6);
                            this.g(canvas2);
                            canvas.drawBitmap(bitmap, f5, f6, null);
                            bitmap.recycle();
                        }
                        canvas.restore();
                    }
                    Paint.Style style = this.e.v;
                    if (style == Paint.Style.FILL_AND_STROKE) break block16;
                    Paint.Style style2 = Paint.Style.FILL;
                    bl = false;
                    if (style != style2) break block17;
                }
                bl = true;
            }
            if (bl) {
                this.h(canvas, this.r, this.k, this.e.a, this.i());
            }
            if (this.n()) {
                Paint paint = this.s;
                Path path = this.l;
                j j4 = this.q;
                this.n.set(this.i());
                float f7 = this.l();
                this.n.inset(f7, f7);
                this.h(canvas, paint, path, j4, this.n);
            }
            this.r.setAlpha(n2);
            this.s.setAlpha(n3);
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    public final int e(int n2) {
        boolean bl;
        b b2 = this.e;
        float f2 = b2.o + b2.p + b2.n;
        c.e.a.a.x.a a2 = b2.b;
        if (a2 != null && a2.a && (bl = f.h.f.a.c(n2, 255) == a2.c)) {
            float f3 = a2.d;
            float f4 = f3 FCMPG 0.0f;
            float f5 = 0.0f;
            if (f4 > 0) {
                f5 = f2 <= 0.0f ? 0.0f : Math.min((float)((2.0f + 4.5f * (float)Math.log1p((double)(f2 / f3))) / 100.0f), (float)1.0f);
            }
            int n3 = Color.alpha((int)n2);
            n2 = f.h.f.a.c(h.i.P0(f.h.f.a.c(n2, 255), a2.b, f5), n3);
        }
        return n2;
    }

    public final void g(Canvas canvas) {
        if (this.h.cardinality() > 0) {
            Log.w((String)A, (String)"Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.e.s != 0) {
            canvas.drawPath(this.k, this.t.a);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            m.f f2 = this.f[i2];
            c.e.a.a.e0.a a2 = this.t;
            int n2 = this.e.r;
            f2.a(m.f.a, a2, n2, canvas);
            m.f f3 = this.g[i2];
            c.e.a.a.e0.a a3 = this.t;
            int n3 = this.e.r;
            f3.a(m.f.a, a3, n3, canvas);
        }
        if (this.z) {
            int n4 = this.j();
            int n5 = this.k();
            canvas.translate((float)(-n4), (float)(-n5));
            canvas.drawPath(this.k, B);
            canvas.translate((float)n4, (float)n5);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.e;
    }

    public int getOpacity() {
        return -3;
    }

    /*
     * Exception decompiling
     */
    @TargetApi(value=21)
    public void getOutline(Outline var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        // java.lang.Thread.run(Thread.java:764)
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.e.i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.o.set(rect);
        this.b(this.i(), this.k);
        this.p.setPath(this.k, this.o);
        this.o.op(this.p, Region.Op.DIFFERENCE);
        return this.o;
    }

    public final void h(Canvas canvas, Paint paint, Path path, j j2, RectF rectF) {
        if (j2.d(rectF)) {
            float f2 = j2.f.a(rectF) * this.e.k;
            canvas.drawRoundRect(rectF, f2, f2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public RectF i() {
        this.m.set(this.getBounds());
        return this.m;
    }

    public void invalidateSelf() {
        this.i = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || (colorStateList4 = this.e.g) != null && colorStateList4.isStateful() || (colorStateList3 = this.e.f) != null && colorStateList3.isStateful() || (colorStateList2 = this.e.e) != null && colorStateList2.isStateful() || (colorStateList = this.e.d) != null && colorStateList.isStateful();
        {
        }
    }

    public int j() {
        b b2 = this.e;
        return (int)((double)b2.s * Math.sin((double)Math.toRadians((double)b2.t)));
    }

    public int k() {
        b b2 = this.e;
        return (int)((double)b2.s * Math.cos((double)Math.toRadians((double)b2.t)));
    }

    public final float l() {
        if (this.n()) {
            return this.s.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float m() {
        return this.e.a.e.a(this.i());
    }

    public Drawable mutate() {
        this.e = new /* invalid duplicate definition of identical inner class */;
        return this;
    }

    public final boolean n() {
        Paint.Style style = this.e.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.s.getStrokeWidth() > 0.0f;
    }

    public void o(Context context) {
        this.e.b = new c.e.a.a.x.a(context);
        this.x();
    }

    public void onBoundsChange(Rect rect) {
        this.i = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] arrn) {
        boolean bl = this.v(arrn);
        boolean bl2 = this.w();
        boolean bl3 = bl || bl2;
        if (bl3) {
            this.invalidateSelf();
        }
        return bl3;
    }

    public void p(float f2) {
        b b2 = this.e;
        if (b2.o != f2) {
            b2.o = f2;
            this.x();
        }
    }

    public void q(ColorStateList colorStateList) {
        b b2 = this.e;
        if (b2.d != colorStateList) {
            b2.d = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void r(float f2) {
        b b2 = this.e;
        if (b2.k != f2) {
            b2.k = f2;
            this.i = true;
            this.invalidateSelf();
        }
    }

    public void s(float f2, int n2) {
        this.e.l = f2;
        this.invalidateSelf();
        this.u(ColorStateList.valueOf((int)n2));
    }

    public void setAlpha(int n2) {
        b b2 = this.e;
        if (b2.m != n2) {
            b2.m = n2;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.e.c = colorFilter;
        super.invalidateSelf();
    }

    @Override
    public void setShapeAppearanceModel(j j2) {
        this.e.a = j2;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.e.g = colorStateList;
        this.w();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        b b2 = this.e;
        if (b2.h != mode) {
            b2.h = mode;
            this.w();
            super.invalidateSelf();
        }
    }

    public void t(float f2, ColorStateList colorStateList) {
        this.e.l = f2;
        this.invalidateSelf();
        this.u(colorStateList);
    }

    public void u(ColorStateList colorStateList) {
        b b2 = this.e;
        if (b2.e != colorStateList) {
            b2.e = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public final boolean v(int[] arrn) {
        boolean bl;
        int n2;
        int n3;
        int n4;
        int n5;
        if (this.e.d != null && (n3 = this.r.getColor()) != (n4 = this.e.d.getColorForState(arrn, n3))) {
            this.r.setColor(n4);
            bl = true;
        } else {
            bl = false;
        }
        if (this.e.e != null && (n2 = this.s.getColor()) != (n5 = this.e.e.getColorForState(arrn, n2))) {
            this.s.setColor(n5);
            return true;
        }
        return bl;
    }

    public final boolean w() {
        PorterDuffColorFilter porterDuffColorFilter = this.w;
        PorterDuffColorFilter porterDuffColorFilter2 = this.x;
        b b2 = this.e;
        ColorStateList colorStateList = b2.g;
        PorterDuff.Mode mode = b2.h;
        Paint paint = this.r;
        boolean bl = true;
        this.w = this.d(colorStateList, mode, paint, bl);
        b b3 = this.e;
        this.x = this.d(b3.f, b3.h, this.s, false);
        b b4 = this.e;
        if (b4.u) {
            this.t.a(b4.g.getColorForState(this.getState(), 0));
        }
        if (Objects.equals((Object)porterDuffColorFilter, (Object)this.w)) {
            if (!Objects.equals((Object)porterDuffColorFilter2, (Object)this.x)) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public final void x() {
        b b2 = this.e;
        float f2 = b2.o + b2.p;
        b2.r = (int)Math.ceil((double)(0.75f * f2));
        this.e.s = (int)Math.ceil((double)(f2 * 0.25f));
        this.w();
        super.invalidateSelf();
    }

}

