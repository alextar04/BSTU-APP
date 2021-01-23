/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.Log
 *  android.view.Gravity
 *  android.view.View
 *  c.e.a.a.c0.a
 *  f.b.k.h
 *  f.h.j.d$c
 *  f.h.l.l
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.e.a.a.a0;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import c.e.a.a.a0.h;
import c.e.a.a.c0.a;
import f.b.k.h;
import f.h.j.d;
import f.h.l.l;

public final class c {
    public static final Paint U;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public int[] E;
    public boolean F;
    public final TextPaint G;
    public final TextPaint H;
    public TimeInterpolator I;
    public TimeInterpolator J;
    public float K;
    public float L;
    public float M;
    public ColorStateList N;
    public StaticLayout O;
    public float P;
    public float Q;
    public float R;
    public CharSequence S;
    public int T = 1;
    public final View a;
    public boolean b;
    public float c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public a v;
    public CharSequence w;
    public CharSequence x;
    public boolean y;
    public boolean z;

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.NullPointerException: Attempt to invoke interface method 'org.benf.cfr.reader.b.a.e.u org.benf.cfr.reader.b.a.e.q.m()' on a null object reference
        // org.benf.cfr.reader.b.a.e.b.b$d.a(InferredJavaType.java:471)
        // org.benf.cfr.reader.b.a.e.b.b.g(InferredJavaType.java:1173)
        // org.benf.cfr.reader.b.a.b.a.t.<init>(CastExpression.java:29)
        // org.benf.cfr.reader.b.a.a.c.c.h.a(NakedNullCaster.java:44)
        // org.benf.cfr.reader.b.a.d.b.o.a(StructuredExpressionStatement.java:63)
        // org.benf.cfr.reader.b.a.a.c.c.h.a(NakedNullCaster.java:31)
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:680)
        // org.benf.cfr.reader.b.a.d.b.e.a(Block.java:407)
        // org.benf.cfr.reader.b.a.a.c.c.h.a(NakedNullCaster.java:30)
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:680)
        // org.benf.cfr.reader.b.a.a.c.c.h.a(NakedNullCaster.java:25)
        // org.benf.cfr.reader.b.a.a.j.l(Op04StructuredStatement.java:763)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:772)
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

    public c(View view) {
        this.a = view;
        this.G = new TextPaint(129);
        this.H = new TextPaint((Paint)this.G);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static int a(int n2, int n3, float f2) {
        float f3 = 1.0f - f2;
        float f4 = f3 * (float)Color.alpha((int)n2) + f2 * (float)Color.alpha((int)n3);
        float f5 = f3 * (float)Color.red((int)n2) + f2 * (float)Color.red((int)n3);
        float f6 = f3 * (float)Color.green((int)n2) + f2 * (float)Color.green((int)n3);
        float f7 = f3 * (float)Color.blue((int)n2) + f2 * (float)Color.blue((int)n3);
        return Color.argb((int)((int)f4), (int)((int)f5), (int)((int)f6), (int)((int)f7));
    }

    public static float i(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return c.e.a.a.l.a.a(f2, f3, f4);
    }

    public static boolean l(Rect rect, int n2, int n3, int n4, int n5) {
        return rect.left == n2 && rect.top == n3 && rect.right == n4 && rect.bottom == n5;
    }

    public float b() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        TextPaint textPaint2 = this.H;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        int n2;
        int n3 = l.n((View)this.a);
        if (n3 != (n2 = 1)) {
            n2 = 0;
        }
        f.h.j.c c2 = n2 != 0 ? d.d : d.c;
        int n4 = charSequence.length();
        return (c2).b(charSequence, 0, n4);
    }

    public final void d(float f2) {
        int n2;
        TextPaint textPaint;
        this.f.left = c.i(this.d.left, this.e.left, f2, this.I);
        this.f.top = c.i(this.m, this.n, f2, this.I);
        this.f.right = c.i(this.d.right, this.e.right, f2, this.I);
        this.f.bottom = c.i(this.d.bottom, this.e.bottom, f2, this.I);
        this.q = c.i(this.o, this.p, f2, this.I);
        this.r = c.i(this.m, this.n, f2, this.I);
        this.p(c.i(this.i, this.j, f2, this.J));
        this.P = 1.0f - c.i(0.0f, 1.0f, 1.0f - f2, c.e.a.a.l.a.b);
        l.K((View)this.a);
        this.Q = c.i(1.0f, 0.0f, f2, c.e.a.a.l.a.b);
        l.K((View)this.a);
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint = this.G;
            n2 = c.a(this.h(colorStateList2), this.g(), f2);
        } else {
            textPaint = this.G;
            n2 = this.g();
        }
        textPaint.setColor(n2);
        this.G.setShadowLayer(c.i(0.0f, this.K, f2, null), c.i(0.0f, this.L, f2, null), c.i(0.0f, this.M, f2, null), c.a(this.h(null), this.h(this.N), f2));
        this.a.postInvalidateOnAnimation();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e(float f2) {
        boolean bl;
        float f3;
        if (this.w == null) {
            return;
        }
        float f4 = this.e.width();
        float f5 = this.d.width();
        boolean bl2 = Math.abs((float)(f2 - this.j)) < 0.001f;
        if (bl2) {
            f3 = this.j;
            this.C = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                bl = true;
            } else {
                bl = false;
            }
        } else {
            float f6 = this.i;
            Typeface typeface = this.u;
            Typeface typeface3 = this.t;
            if (typeface != typeface3) {
                this.u = typeface3;
                bl = true;
            } else {
                bl = false;
            }
            boolean bl3 = Math.abs((float)(f2 - this.i)) < 0.001f;
            this.C = bl3 ? 1.0f : f2 / this.i;
            float f7 = this.j / this.i;
            f4 = f5 * f7 > f4 ? Math.min((float)(f4 / f7), (float)f5) : f5;
            f3 = f6;
        }
        if (f4 > 0.0f) {
            bl = this.D != f3 || this.F || bl;
            this.D = f3;
            this.F = false;
        }
        if (this.x == null || bl) {
            StaticLayout staticLayout;
            boolean bl4;
            this.G.setTextSize(this.D);
            this.G.setTypeface(this.u);
            TextPaint textPaint = this.G;
            boolean bl5 = this.C != 1.0f;
            textPaint.setLinearText(bl5);
            this.y = bl4 = this.c(this.w);
            boolean bl6 = this.T > 1 && !bl4 && !this.z;
            int n2 = bl6 ? this.T : 1;
            boolean bl7 = this.y;
            CharSequence charSequence = this.w;
            TextPaint textPaint2 = this.G;
            int n3 = (int)f4;
            try {
                int n4 = charSequence.length();
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                int n5 = Math.max((int)0, (int)n3);
                if (n2 == 1) {
                    charSequence = TextUtils.ellipsize((CharSequence)charSequence, (TextPaint)textPaint2, (float)n5, (TextUtils.TruncateAt)truncateAt);
                }
                int n6 = Math.min((int)charSequence.length(), (int)n4);
                if (bl7) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
                StaticLayout.Builder builder = StaticLayout.Builder.obtain((CharSequence)charSequence, (int)0, (int)n6, (TextPaint)textPaint2, (int)n5);
                builder.setAlignment(alignment);
                builder.setIncludePad(false);
                TextDirectionHeuristic textDirectionHeuristic = bl7 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                builder.setTextDirection(textDirectionHeuristic);
                if (truncateAt != null) {
                    builder.setEllipsize(truncateAt);
                }
                builder.setMaxLines(n2);
                staticLayout = builder.build();
            }
            catch (h h2) {
                Log.e((String)"CollapsingTextHelper", (String)h2.getCause().getMessage(), (Throwable)h2);
                staticLayout = null;
            }
            h.i.n(staticLayout);
            this.O = staticLayout;
            this.x = staticLayout.getText();
        }
    }

    public float f() {
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        return -this.H.ascent();
    }

    public int g() {
        return this.h(this.l);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] arrn = this.E;
        if (arrn != null) {
            return colorStateList.getColorForState(arrn, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void j() {
        boolean bl = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
        this.b = bl;
    }

    public void k() {
        block8 : {
            float f2;
            float f3;
            block19 : {
                float f4;
                float f5;
                block20 : {
                    block17 : {
                        block18 : {
                            int n2;
                            block15 : {
                                float f6;
                                block16 : {
                                    block13 : {
                                        float f7;
                                        block14 : {
                                            block11 : {
                                                float f8;
                                                float f9;
                                                block12 : {
                                                    block9 : {
                                                        block10 : {
                                                            StaticLayout staticLayout;
                                                            CharSequence charSequence;
                                                            if (this.a.getHeight() <= 0 || this.a.getWidth() <= 0) break block8;
                                                            f3 = this.D;
                                                            this.e(this.j);
                                                            CharSequence charSequence2 = this.x;
                                                            if (charSequence2 != null && (staticLayout = this.O) != null) {
                                                                this.S = TextUtils.ellipsize((CharSequence)charSequence2, (TextPaint)this.G, (float)staticLayout.getWidth(), (TextUtils.TruncateAt)TextUtils.TruncateAt.END);
                                                            }
                                                            f9 = (charSequence = this.S) != null ? this.G.measureText(charSequence, 0, charSequence.length()) : 0.0f;
                                                            int n3 = Gravity.getAbsoluteGravity((int)this.h, (int)this.y);
                                                            int n4 = n3 & 112;
                                                            if (n4 != 48) {
                                                                float f10;
                                                                if (n4 != 80) {
                                                                    float f11 = (this.G.descent() - this.G.ascent()) / 2.0f;
                                                                    f10 = (float)this.e.centerY() - f11;
                                                                } else {
                                                                    f10 = (float)this.e.bottom + this.G.ascent();
                                                                }
                                                                this.n = f10;
                                                            } else {
                                                                this.n = this.e.top;
                                                            }
                                                            int n5 = n3 & 8388615;
                                                            if (n5 == 1) break block9;
                                                            if (n5 == 5) break block10;
                                                            this.p = this.e.left;
                                                            break block11;
                                                        }
                                                        f8 = this.e.right;
                                                        break block12;
                                                    }
                                                    f8 = this.e.centerX();
                                                    f9 /= 2.0f;
                                                }
                                                this.p = f8 - f9;
                                            }
                                            this.e(this.i);
                                            StaticLayout staticLayout = this.O;
                                            f7 = staticLayout != null ? (float)staticLayout.getHeight() : 0.0f;
                                            CharSequence charSequence = this.x;
                                            f4 = charSequence != null ? this.G.measureText(charSequence, 0, charSequence.length()) : 0.0f;
                                            StaticLayout staticLayout2 = this.O;
                                            if (staticLayout2 != null && this.T > 1 && !this.y) {
                                                f4 = staticLayout2.getWidth();
                                            }
                                            StaticLayout staticLayout3 = this.O;
                                            float f12 = 0.0f;
                                            if (staticLayout3 != null) {
                                                f12 = staticLayout3.getLineLeft(0);
                                            }
                                            this.R = f12;
                                            n2 = Gravity.getAbsoluteGravity((int)this.g, (int)this.y);
                                            int n6 = n2 & 112;
                                            if (n6 == 48) break block13;
                                            if (n6 == 80) break block14;
                                            float f13 = f7 / 2.0f;
                                            this.m = (float)this.d.centerY() - f13;
                                            break block15;
                                        }
                                        f6 = (float)this.d.bottom - f7 + this.G.descent();
                                        break block16;
                                    }
                                    f6 = this.d.top;
                                }
                                this.m = f6;
                            }
                            int n7 = n2 & 8388615;
                            if (n7 == 1) break block17;
                            if (n7 == 5) break block18;
                            f2 = this.d.left;
                            break block19;
                        }
                        f5 = this.d.right;
                        break block20;
                    }
                    f5 = this.d.centerX();
                    f4 /= 2.0f;
                }
                f2 = f5 - f4;
            }
            this.o = f2;
            Bitmap bitmap = this.A;
            if (bitmap != null) {
                bitmap.recycle();
                this.A = null;
            }
            this.p(f3);
            this.d(this.c);
        }
    }

    public void m(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            this.k();
        }
    }

    public void n(int n2) {
        if (this.h != n2) {
            this.h = n2;
            this.k();
        }
    }

    public void o(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 != this.c) {
            this.c = f2;
            this.d(f2);
        }
    }

    public final void p(float f2) {
        this.e(f2);
        this.z = false;
        if (false && this.A == null && !this.d.isEmpty() && !TextUtils.isEmpty((CharSequence)this.x)) {
            this.d(0.0f);
            int n2 = this.O.getWidth();
            int n3 = this.O.getHeight();
            if (n2 > 0 && n3 > 0) {
                this.A = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.A);
                this.O.draw(canvas);
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
        l.K((View)this.a);
    }

    public void q(Typeface typeface) {
        boolean bl;
        a a2 = this.v;
        boolean bl2 = true;
        if (a2 != null) {
            a2.c = bl2;
        }
        if (this.s != typeface) {
            this.s = typeface;
            bl = bl2;
        } else {
            bl = false;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            bl2 = false;
        }
        if (bl || bl2) {
            this.k();
        }
    }
}

