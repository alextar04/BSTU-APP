/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.RippleDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  c.e.a.a.c0.c
 *  c.e.a.a.f0.g
 *  f.b.k.h
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 */
package c.e.a.a.t;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import c.e.a.a.a0.i;
import c.e.a.a.c0.c;
import c.e.a.a.c0.d;
import c.e.a.a.f0.g;
import c.e.a.a.f0.j;
import c.e.a.a.l.g;
import f.b.k.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class b
extends c.e.a.a.f0.g
implements Drawable.Callback,
i.b {
    public static final int[] M0 = new int[]{16842910};
    public static final ShapeDrawable N0 = new ShapeDrawable((Shape)new OvalShape());
    public ColorFilter A0;
    public PorterDuffColorFilter B0;
    public ColorStateList C;
    public ColorStateList C0;
    public ColorStateList D;
    public PorterDuff.Mode D0 = PorterDuff.Mode.SRC_IN;
    public float E;
    public int[] E0;
    public float F = -1.0f;
    public boolean F0;
    public ColorStateList G;
    public ColorStateList G0;
    public float H;
    public WeakReference<a> H0 = new WeakReference(null);
    public ColorStateList I;
    public TextUtils.TruncateAt I0;
    public CharSequence J;
    public boolean J0;
    public boolean K;
    public int K0;
    public Drawable L;
    public boolean L0;
    public ColorStateList M;
    public float N;
    public boolean O;
    public boolean P;
    public Drawable Q;
    public Drawable R;
    public ColorStateList S;
    public float T;
    public CharSequence U;
    public boolean V;
    public boolean W;
    public Drawable X;
    public ColorStateList Y;
    public g Z;
    public g a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public final Context j0;
    public final Paint k0 = new Paint(1);
    public final Paint l0;
    public final Paint.FontMetrics m0 = new Paint.FontMetrics();
    public final RectF n0 = new RectF();
    public final PointF o0 = new PointF();
    public final Path p0 = new Path();
    public final i q0;
    public int r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public boolean x0;
    public int y0;
    public int z0 = 255;

    public b(Context context, AttributeSet attributeSet, int n2, int n3) {
        i i2;
        super(j.b(context, attributeSet, n2, n3).a());
        this.e.b = new c.e.a.a.x.a(context);
        this.x();
        this.j0 = context;
        this.q0 = i2 = new i(this);
        this.J = "";
        i2.a.density = context.getResources().getDisplayMetrics().density;
        this.l0 = null;
        this.setState(M0);
        this.d0(M0);
        this.J0 = true;
        N0.setTint(-1);
    }

    public static boolean G(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean H(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public float A() {
        if (!this.p0() && !this.o0()) {
            return 0.0f;
        }
        return this.c0 + this.N + this.d0;
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.q0()) {
            float f2;
            float f3 = this.i0 + this.h0;
            if (this.getLayoutDirection() == 0) {
                float f4;
                rectF.right = f4 = (float)rect.right - f3;
                rectF.left = f4 - this.T;
            } else {
                float f5;
                rectF.left = f5 = f3 + (float)rect.left;
                rectF.right = f5 + this.T;
            }
            float f6 = rect.exactCenterY();
            float f7 = this.T;
            rectF.top = f2 = f6 - f7 / 2.0f;
            rectF.bottom = f2 + f7;
        }
    }

    public final void C(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.q0()) {
            float f2 = this.i0 + this.h0 + this.T + this.g0 + this.f0;
            if (this.getLayoutDirection() == 0) {
                float f3;
                rectF.right = f3 = (float)rect.right;
                rectF.left = f3 - f2;
            } else {
                int n2 = rect.left;
                rectF.left = n2;
                rectF.right = f2 + (float)n2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public float D() {
        if (this.q0()) {
            return this.g0 + this.T + this.h0;
        }
        return 0.0f;
    }

    public float E() {
        if (this.L0) {
            return this.m();
        }
        return this.F;
    }

    public Drawable F() {
        Drawable drawable = this.Q;
        if (drawable != null) {
            if (drawable instanceof f.h.f.k.a) {
                return ((f.h.f.k.a)drawable).a();
            }
        } else {
            drawable = null;
        }
        return drawable;
    }

    public void I() {
        a a2 = this.H0.get();
        if (a2 != null) {
            a2.a();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean J(int[] var1_1, int[] var2_2) {
        var3_3 = super.onStateChange(var1_1);
        var4_4 = this.C;
        var5_5 = var4_4 != null ? var4_4.getColorForState(var1_1, this.r0) : 0;
        var6_6 = this.r0;
        var7_7 = true;
        if (var6_6 != var5_5) {
            this.r0 = var5_5;
            var3_3 = var7_7;
        }
        if (this.s0 != (var9_9 = (var8_8 = this.D) != null ? var8_8.getColorForState(var1_1, this.s0) : 0)) {
            this.s0 = var9_9;
            var3_3 = var7_7;
        }
        if ((var11_11 = this.t0 != (var10_10 = f.h.f.a.a(var9_9, var5_5)) ? var7_7 : false) | (var12_12 = this.e.d == null ? var7_7 : false)) {
            this.t0 = var10_10;
            this.q(ColorStateList.valueOf((int)var10_10));
            var3_3 = var7_7;
        }
        if (this.u0 != (var14_14 = (var13_13 = this.G) != null ? var13_13.getColorForState(var1_1, this.u0) : 0)) {
            this.u0 = var14_14;
            var3_3 = var7_7;
        }
        if (this.v0 != (var15_15 = this.G0 != null && c.e.a.a.d0.a.b(var1_1) != false ? this.G0.getColorForState(var1_1, this.v0) : 0)) {
            this.v0 = var15_15;
            if (this.F0) {
                var3_3 = var7_7;
            }
        }
        if (this.w0 != (var17_18 = (var16_16 = this.q0.f) != null && (var29_17 = var16_16.b) != null ? var29_17.getColorForState(var1_1, this.w0) : 0)) {
            this.w0 = var17_18;
            var3_3 = var7_7;
        }
        if ((var18_19 = this.getState()) == null) ** GOTO lbl31
        var19_21 = var18_19.length;
        var20_22 = 0;
        do {
            block23 : {
                if (var20_22 < var19_21) break block23;
lbl31: // 2 sources:
                var21_20 = false;
                break;
            }
            if (var18_19[var20_22] == 16842912) {
                var21_20 = var7_7;
                break;
            }
            ++var20_22;
        } while (true);
        var22_23 = var21_20 != false && this.V != false ? var7_7 : false;
        if (this.x0 != var22_23 && this.X != null) {
            var28_24 = this.A();
            this.x0 = var22_23;
            if (var28_24 != this.A()) {
                var23_25 = var3_3 = var7_7;
            } else {
                var3_3 = var7_7;
                var23_25 = false;
            }
        } else {
            var23_25 = false;
        }
        var24_26 = this.C0;
        var25_27 = var24_26 != null ? var24_26.getColorForState(var1_1, this.y0) : 0;
        if (this.y0 != var25_27) {
            this.y0 = var25_27;
            this.B0 = h.i.T1((Drawable)this, this.C0, this.D0);
        } else {
            var7_7 = var3_3;
        }
        if (b.H(this.L)) {
            var7_7 |= this.L.setState(var1_1);
        }
        if (b.H(this.X)) {
            var7_7 |= this.X.setState(var1_1);
        }
        if (b.H(this.Q)) {
            var27_28 = new int[var1_1.length + var2_2.length];
            System.arraycopy((Object)var1_1, (int)0, (Object)var27_28, (int)0, (int)var1_1.length);
            System.arraycopy((Object)var2_2, (int)0, (Object)var27_28, (int)var1_1.length, (int)var2_2.length);
            var7_7 |= this.Q.setState(var27_28);
        }
        if (b.H(this.R)) {
            var7_7 |= this.R.setState(var2_2);
        }
        if (var7_7) {
            this.invalidateSelf();
        }
        if (var23_25 == false) return var7_7;
        this.I();
        return var7_7;
    }

    public void K(boolean bl) {
        if (this.V != bl) {
            this.V = bl;
            float f2 = this.A();
            if (!bl && this.x0) {
                this.x0 = false;
            }
            float f3 = this.A();
            this.invalidateSelf();
            if (f2 != f3) {
                this.I();
            }
        }
    }

    public void L(Drawable drawable) {
        if (this.X != drawable) {
            float f2 = this.A();
            this.X = drawable;
            float f3 = this.A();
            this.r0(this.X);
            this.y(this.X);
            this.invalidateSelf();
            if (f2 != f3) {
                this.I();
            }
        }
    }

    public void M(ColorStateList colorStateList) {
        if (this.Y != colorStateList) {
            this.Y = colorStateList;
            boolean bl = this.W && this.X != null && this.V;
            if (bl) {
                this.X.setTintList(colorStateList);
            }
            this.onStateChange(this.getState());
        }
    }

    public void N(boolean bl) {
        if (this.W != bl) {
            boolean bl2 = this.o0();
            this.W = bl;
            boolean bl3 = this.o0();
            boolean bl4 = bl2 != bl3;
            if (bl4) {
                if (bl3) {
                    this.y(this.X);
                } else {
                    this.r0(this.X);
                }
                this.invalidateSelf();
                this.I();
            }
        }
    }

    public void O(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    @Deprecated
    public void P(float f2) {
        if (this.F != f2) {
            j j2;
            this.F = f2;
            this.e.a = j2 = this.e.a.e(f2);
            this.invalidateSelf();
        }
    }

    public void Q(float f2) {
        if (this.i0 != f2) {
            this.i0 = f2;
            this.invalidateSelf();
            this.I();
        }
    }

    public void R(Drawable drawable) {
        Drawable drawable2 = this.L;
        if (drawable2 != null) {
            if (drawable2 instanceof f.h.f.k.a) {
                drawable2 = ((f.h.f.k.a)drawable2).a();
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float f2 = this.A();
            Drawable drawable3 = null;
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.L = drawable3;
            float f3 = this.A();
            this.r0(drawable2);
            if (this.p0()) {
                this.y(this.L);
            }
            this.invalidateSelf();
            if (f2 != f3) {
                this.I();
            }
        }
    }

    public void S(float f2) {
        if (this.N != f2) {
            float f3 = this.A();
            this.N = f2;
            float f4 = this.A();
            this.invalidateSelf();
            if (f3 != f4) {
                this.I();
            }
        }
    }

    public void T(ColorStateList colorStateList) {
        this.O = true;
        if (this.M != colorStateList) {
            this.M = colorStateList;
            if (this.p0()) {
                this.L.setTintList(colorStateList);
            }
            this.onStateChange(this.getState());
        }
    }

    public void U(boolean bl) {
        if (this.K != bl) {
            boolean bl2 = this.p0();
            this.K = bl;
            boolean bl3 = this.p0();
            boolean bl4 = bl2 != bl3;
            if (bl4) {
                if (bl3) {
                    this.y(this.L);
                } else {
                    this.r0(this.L);
                }
                this.invalidateSelf();
                this.I();
            }
        }
    }

    public void V(float f2) {
        if (this.E != f2) {
            this.E = f2;
            this.invalidateSelf();
            this.I();
        }
    }

    public void W(float f2) {
        if (this.b0 != f2) {
            this.b0 = f2;
            this.invalidateSelf();
            this.I();
        }
    }

    public void X(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (this.L0) {
                this.u(colorStateList);
            }
            this.onStateChange(this.getState());
        }
    }

    public void Y(float f2) {
        if (this.H != f2) {
            this.H = f2;
            this.k0.setStrokeWidth(f2);
            if (this.L0) {
                this.e.l = f2;
                this.invalidateSelf();
            }
            this.invalidateSelf();
        }
    }

    public void Z(Drawable drawable) {
        Drawable drawable2 = this.F();
        if (drawable2 != drawable) {
            float f2 = this.D();
            Drawable drawable3 = drawable != null ? drawable.mutate() : null;
            this.Q = drawable3;
            this.R = new RippleDrawable(c.e.a.a.d0.a.a(this.I), this.Q, (Drawable)N0);
            float f3 = this.D();
            this.r0(drawable2);
            if (this.q0()) {
                this.y(this.Q);
            }
            this.invalidateSelf();
            if (f2 != f3) {
                this.I();
            }
        }
    }

    @Override
    public void a() {
        this.I();
        this.invalidateSelf();
    }

    public void a0(float f2) {
        if (this.h0 != f2) {
            this.h0 = f2;
            this.invalidateSelf();
            if (this.q0()) {
                this.I();
            }
        }
    }

    public void b0(float f2) {
        if (this.T != f2) {
            this.T = f2;
            this.invalidateSelf();
            if (this.q0()) {
                this.I();
            }
        }
    }

    public void c0(float f2) {
        if (this.g0 != f2) {
            this.g0 = f2;
            this.invalidateSelf();
            if (this.q0()) {
                this.I();
            }
        }
    }

    public boolean d0(int[] arrn) {
        if (!Arrays.equals((int[])this.E0, (int[])arrn)) {
            this.E0 = arrn;
            if (this.q0()) {
                return this.J(this.getState(), arrn);
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        if (!rect.isEmpty()) {
            int n2;
            int n3;
            Paint paint;
            int n4;
            int n5;
            int n6 = this.z0;
            if (n6 == 0) {
                return;
            }
            int n7 = n6 < 255 ? canvas.saveLayerAlpha((float)rect.left, (float)rect.top, (float)rect.right, (float)rect.bottom, n6) : 0;
            if (!this.L0) {
                this.k0.setColor(this.r0);
                this.k0.setStyle(Paint.Style.FILL);
                this.n0.set(rect);
                canvas.drawRoundRect(this.n0, this.E(), this.E(), this.k0);
            }
            if (!this.L0) {
                this.k0.setColor(this.s0);
                this.k0.setStyle(Paint.Style.FILL);
                Paint paint2 = this.k0;
                ColorFilter colorFilter = this.A0;
                if (colorFilter == null) {
                    colorFilter = this.B0;
                }
                paint2.setColorFilter(colorFilter);
                this.n0.set(rect);
                canvas.drawRoundRect(this.n0, this.E(), this.E(), this.k0);
            }
            if (this.L0) {
                super.draw(canvas);
            }
            if (this.H > 0.0f && !this.L0) {
                this.k0.setColor(this.u0);
                this.k0.setStyle(Paint.Style.STROKE);
                if (!this.L0) {
                    Paint paint3 = this.k0;
                    ColorFilter colorFilter = this.A0;
                    if (colorFilter == null) {
                        colorFilter = this.B0;
                    }
                    paint3.setColorFilter(colorFilter);
                }
                RectF rectF = this.n0;
                float f2 = rect.left;
                float f3 = this.H / 2.0f;
                rectF.set(f2 + f3, f3 + (float)rect.top, (float)rect.right - f3, (float)rect.bottom - f3);
                float f4 = this.F - this.H / 2.0f;
                canvas.drawRoundRect(this.n0, f4, f4, this.k0);
            }
            this.k0.setColor(this.v0);
            this.k0.setStyle(Paint.Style.FILL);
            this.n0.set(rect);
            if (!this.L0) {
                canvas.drawRoundRect(this.n0, this.E(), this.E(), this.k0);
            } else {
                this.c(new RectF(rect), this.p0);
                Paint paint4 = this.k0;
                Path path = this.p0;
                RectF rectF = this.i();
                this.h(canvas, paint4, path, this.e.a, rectF);
            }
            if (this.p0()) {
                this.z(rect, this.n0);
                RectF rectF = this.n0;
                float f5 = rectF.left;
                float f6 = rectF.top;
                canvas.translate(f5, f6);
                this.L.setBounds(0, 0, (int)this.n0.width(), (int)this.n0.height());
                this.L.draw(canvas);
                canvas.translate(-f5, -f6);
            }
            if (this.o0()) {
                this.z(rect, this.n0);
                RectF rectF = this.n0;
                float f7 = rectF.left;
                float f8 = rectF.top;
                canvas.translate(f7, f8);
                this.X.setBounds(0, 0, (int)this.n0.width(), (int)this.n0.height());
                this.X.draw(canvas);
                canvas.translate(-f7, -f8);
            }
            if (this.J0 && this.J != null) {
                int n8;
                PointF pointF = this.o0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                if (this.J != null) {
                    float f9 = this.b0 + this.A() + this.e0;
                    if (this.getLayoutDirection() == 0) {
                        pointF.x = f9 + (float)rect.left;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = (float)rect.right - f9;
                        align = Paint.Align.RIGHT;
                    }
                    float f10 = rect.centerY();
                    this.q0.a.getFontMetrics(this.m0);
                    Paint.FontMetrics fontMetrics = this.m0;
                    pointF.y = f10 - (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
                }
                RectF rectF = this.n0;
                rectF.setEmpty();
                if (this.J != null) {
                    float f11;
                    float f12 = this.b0 + this.A() + this.e0;
                    float f13 = this.i0 + this.D() + this.f0;
                    if (this.getLayoutDirection() == 0) {
                        rectF.left = f12 + (float)rect.left;
                        f11 = (float)rect.right - f13;
                    } else {
                        rectF.left = f13 + (float)rect.left;
                        f11 = (float)rect.right - f12;
                    }
                    rectF.right = f11;
                    rectF.top = rect.top;
                    rectF.bottom = rect.bottom;
                }
                i i2 = this.q0;
                if (i2.f != null) {
                    i2.a.drawableState = this.getState();
                    i i3 = this.q0;
                    Context context = this.j0;
                    i3.f.c(context, i3.a, i3.b);
                }
                this.q0.a.setTextAlign(align);
                boolean bl = Math.round((float)this.q0.a(this.J.toString())) > Math.round((float)this.n0.width());
                if (bl) {
                    n8 = canvas.save();
                    canvas.clipRect(this.n0);
                } else {
                    n8 = 0;
                }
                CharSequence charSequence = this.J;
                if (bl && this.I0 != null) {
                    charSequence = TextUtils.ellipsize((CharSequence)charSequence, (TextPaint)this.q0.a, (float)this.n0.width(), (TextUtils.TruncateAt)this.I0);
                }
                CharSequence charSequence2 = charSequence;
                int n9 = charSequence2.length();
                PointF pointF2 = this.o0;
                float f14 = pointF2.x;
                float f15 = pointF2.y;
                TextPaint textPaint = this.q0.a;
                n3 = n7;
                n4 = 255;
                canvas.drawText(charSequence2, 0, n9, f14, f15, (Paint)textPaint);
                if (bl) {
                    canvas.restoreToCount(n8);
                }
            } else {
                n3 = n7;
                n4 = 255;
            }
            if (this.q0()) {
                this.B(rect, this.n0);
                RectF rectF = this.n0;
                float f16 = rectF.left;
                float f17 = rectF.top;
                canvas.translate(f16, f17);
                this.Q.setBounds(0, 0, (int)this.n0.width(), (int)this.n0.height());
                this.R.setBounds(this.Q.getBounds());
                this.R.jumpToCurrentState();
                this.R.draw(canvas);
                canvas.translate(-f16, -f17);
            }
            if ((paint = this.l0) != null) {
                paint.setColor(f.h.f.a.c(-16777216, 127));
                canvas.drawRect(rect, this.l0);
                if (this.p0() || this.o0()) {
                    this.z(rect, this.n0);
                    canvas.drawRect(this.n0, this.l0);
                }
                if (this.J != null) {
                    float f18 = rect.left;
                    float f19 = rect.exactCenterY();
                    float f20 = rect.right;
                    float f21 = rect.exactCenterY();
                    Paint paint5 = this.l0;
                    n2 = n4;
                    n5 = n3;
                    canvas.drawLine(f18, f19, f20, f21, paint5);
                } else {
                    n2 = n4;
                    n5 = n3;
                }
                if (this.q0()) {
                    this.B(rect, this.n0);
                    canvas.drawRect(this.n0, this.l0);
                }
                this.l0.setColor(f.h.f.a.c(-65536, 127));
                RectF rectF = this.n0;
                rectF.set(rect);
                if (this.q0()) {
                    float f22 = this.i0 + this.h0 + this.T + this.g0 + this.f0;
                    if (this.getLayoutDirection() == 0) {
                        rectF.right = (float)rect.right - f22;
                    } else {
                        rectF.left = f22 + (float)rect.left;
                    }
                }
                canvas.drawRect(this.n0, this.l0);
                this.l0.setColor(f.h.f.a.c(-16711936, 127));
                this.C(rect, this.n0);
                canvas.drawRect(this.n0, this.l0);
            } else {
                n2 = n4;
                n5 = n3;
            }
            if (this.z0 < n2) {
                canvas.restoreToCount(n5);
            }
        }
    }

    public void e0(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            if (this.q0()) {
                this.Q.setTintList(colorStateList);
            }
            this.onStateChange(this.getState());
        }
    }

    public void f0(boolean bl) {
        if (this.P != bl) {
            boolean bl2 = this.q0();
            this.P = bl;
            boolean bl3 = this.q0();
            boolean bl4 = bl2 != bl3;
            if (bl4) {
                if (bl3) {
                    this.y(this.Q);
                } else {
                    this.r0(this.Q);
                }
                this.invalidateSelf();
                this.I();
            }
        }
    }

    public void g0(float f2) {
        if (this.d0 != f2) {
            float f3 = this.A();
            this.d0 = f2;
            float f4 = this.A();
            this.invalidateSelf();
            if (f3 != f4) {
                this.I();
            }
        }
    }

    public int getAlpha() {
        return this.z0;
    }

    public ColorFilter getColorFilter() {
        return this.A0;
    }

    public int getIntrinsicHeight() {
        return (int)this.E;
    }

    public int getIntrinsicWidth() {
        return Math.min((int)Math.round((float)(this.b0 + this.A() + this.e0 + this.q0.a(this.J.toString()) + this.f0 + this.D() + this.i0)), (int)this.K0);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(value=21)
    public void getOutline(Outline outline) {
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect rect = this.getBounds();
        if (!rect.isEmpty()) {
            outline.setRoundRect(rect, this.F);
        } else {
            outline.setRoundRect(0, 0, this.getIntrinsicWidth(), (int)this.E, this.F);
        }
        outline.setAlpha((float)this.z0 / 255.0f);
    }

    public void h0(float f2) {
        if (this.c0 != f2) {
            float f3 = this.A();
            this.c0 = f2;
            float f4 = this.A();
            this.invalidateSelf();
            if (f3 != f4) {
                this.I();
            }
        }
    }

    public void i0(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            ColorStateList colorStateList2 = this.F0 ? c.e.a.a.d0.a.a(colorStateList) : null;
            this.G0 = colorStateList2;
            this.onStateChange(this.getState());
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }

    public boolean isStateful() {
        boolean bl;
        block3 : {
            block2 : {
                boolean bl2;
                ColorStateList colorStateList;
                boolean bl3;
                c.e.a.a.c0.b b2;
                if (b.G(this.C) || b.G(this.D) || b.G(this.G) || this.F0 && b.G(this.G0) || (bl3 = (b2 = this.q0.f) != null && (colorStateList = b2.b) != null && colorStateList.isStateful()) || (bl2 = this.W && this.X != null && this.V) || b.H(this.L) || b.H(this.X)) break block2;
                boolean bl4 = b.G(this.C0);
                bl = false;
                if (!bl4) break block3;
            }
            bl = true;
        }
        return bl;
    }

    public void j0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals((CharSequence)this.J, (CharSequence)charSequence)) {
            this.J = charSequence;
            this.q0.d = true;
            this.invalidateSelf();
            this.I();
        }
    }

    public void k0(c.e.a.a.c0.b b2) {
        i i2 = this.q0;
        Context context = this.j0;
        if (i2.f != b2) {
            i.b b3;
            i2.f = b2;
            if (b2 != null) {
                TextPaint textPaint = i2.a;
                d d2 = i2.b;
                b2.a();
                b2.d(textPaint, b2.l);
                b2.b(context, (d)new c(b2, textPaint, d2));
                i.b b4 = (i.b)i2.e.get();
                if (b4 != null) {
                    i2.a.drawableState = b4.getState();
                }
                b2.c(context, i2.a, i2.b);
                i2.d = true;
            }
            if ((b3 = (i.b)i2.e.get()) != null) {
                b3.a();
                b3.onStateChange(b3.getState());
            }
        }
    }

    public void l0(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            this.invalidateSelf();
            this.I();
        }
    }

    public void m0(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            this.invalidateSelf();
            this.I();
        }
    }

    public void n0(boolean bl) {
        if (this.F0 != bl) {
            this.F0 = bl;
            ColorStateList colorStateList = bl ? c.e.a.a.d0.a.a(this.I) : null;
            this.G0 = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public final boolean o0() {
        return this.W && this.X != null && this.x0;
    }

    public boolean onLayoutDirectionChanged(int n2) {
        boolean bl = Drawable.super.onLayoutDirectionChanged(n2);
        if (this.p0()) {
            bl |= this.L.setLayoutDirection(n2);
        }
        if (this.o0()) {
            bl |= this.X.setLayoutDirection(n2);
        }
        if (this.q0()) {
            bl |= this.Q.setLayoutDirection(n2);
        }
        if (bl) {
            this.invalidateSelf();
        }
        return true;
    }

    public boolean onLevelChange(int n2) {
        boolean bl = Drawable.super.onLevelChange(n2);
        if (this.p0()) {
            bl |= this.L.setLevel(n2);
        }
        if (this.o0()) {
            bl |= this.X.setLevel(n2);
        }
        if (this.q0()) {
            bl |= this.Q.setLevel(n2);
        }
        if (bl) {
            this.invalidateSelf();
        }
        return bl;
    }

    @Override
    public boolean onStateChange(int[] arrn) {
        if (this.L0) {
            super.onStateChange(arrn);
        }
        return this.J(arrn, this.E0);
    }

    public final boolean p0() {
        return this.K && this.L != null;
    }

    public final boolean q0() {
        return this.P && this.Q != null;
    }

    public final void r0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        Drawable.Callback callback = this.getCallback();
        if (callback != null) {
            callback.scheduleDrawable((Drawable)this, runnable, l2);
        }
    }

    public void setAlpha(int n2) {
        if (this.z0 != n2) {
            this.z0 = n2;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.A0 != colorFilter) {
            this.A0 = colorFilter;
            this.invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.D0 != mode) {
            this.D0 = mode;
            this.B0 = h.i.T1((Drawable)this, this.C0, mode);
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = Drawable.super.setVisible(bl, bl2);
        if (this.p0()) {
            bl3 |= this.L.setVisible(bl, bl2);
        }
        if (this.o0()) {
            bl3 |= this.X.setVisible(bl, bl2);
        }
        if (this.q0()) {
            bl3 |= this.Q.setVisible(bl, bl2);
        }
        if (bl3) {
            this.invalidateSelf();
        }
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = this.getCallback();
        if (callback != null) {
            callback.unscheduleDrawable((Drawable)this, runnable);
        }
    }

    public final void y(Drawable drawable) {
        Drawable drawable2;
        if (drawable == null) {
            return;
        }
        drawable.setCallback((Drawable.Callback)this);
        drawable.setLayoutDirection(this.getLayoutDirection());
        drawable.setLevel(this.getLevel());
        drawable.setVisible(this.isVisible(), false);
        if (drawable == this.Q) {
            if (drawable.isStateful()) {
                drawable.setState(this.E0);
            }
            drawable.setTintList(this.S);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(this.getState());
        }
        if (drawable == (drawable2 = this.L) && this.O) {
            drawable2.setTintList(this.M);
        }
    }

    public final void z(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.p0() || this.o0()) {
            float f2;
            float f3 = this.b0 + this.c0;
            if (this.getLayoutDirection() == 0) {
                float f4;
                rectF.left = f4 = f3 + (float)rect.left;
                rectF.right = f4 + this.N;
            } else {
                float f5;
                rectF.right = f5 = (float)rect.right - f3;
                rectF.left = f5 - this.N;
            }
            float f6 = rect.exactCenterY();
            float f7 = this.N;
            rectF.top = f2 = f6 - f7 / 2.0f;
            rectF.bottom = f2 + f7;
        }
    }

}

