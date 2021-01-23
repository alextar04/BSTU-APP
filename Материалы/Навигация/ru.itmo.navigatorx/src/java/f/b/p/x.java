/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.TextView
 *  c.b.a.a.a
 *  f.b.k.h
 *  f.h.l.l
 *  f.h.m.b
 *  f.h.m.e
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Locale
 */
package f.b.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import c.b.a.a.a;
import f.b.k.h;
import f.b.p.d0;
import f.b.p.j;
import f.b.p.u0;
import f.b.p.w0;
import f.b.p.z;
import f.h.l.l;
import f.h.m.b;
import f.h.m.e;
import java.util.Arrays;
import java.util.Locale;

public class x {
    public final TextView a;
    public u0 b;
    public u0 c;
    public u0 d;
    public u0 e;
    public u0 f;
    public u0 g;
    public u0 h;
    public final z i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public x(TextView textView) {
        this.a = textView;
        this.i = new z(this.a);
    }

    public static u0 c(Context context, j j2, int n2) {
        ColorStateList colorStateList = j2.d(context, n2);
        if (colorStateList != null) {
            u0 u02 = new u0();
            u02.d = true;
            u02.a = colorStateList;
            return u02;
        }
        return null;
    }

    public final void a(Drawable drawable, u0 u02) {
        if (drawable != null && u02 != null) {
            j.f(drawable, u02, this.a.getDrawableState());
        }
    }

    public void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] arrdrawable = this.a.getCompoundDrawables();
            this.a(arrdrawable[0], this.b);
            this.a(arrdrawable[1], this.c);
            this.a(arrdrawable[2], this.d);
            this.a(arrdrawable[3], this.e);
        }
        if (this.f != null || this.g != null) {
            Drawable[] arrdrawable = this.a.getCompoundDrawablesRelative();
            this.a(arrdrawable[0], this.f);
            this.a(arrdrawable[2], this.g);
        }
    }

    public boolean d() {
        z z2 = this.i;
        return z2.i() && z2.a != 0;
    }

    @SuppressLint(value={"NewApi"})
    public void e(AttributeSet attributeSet, int n2) {
        int n3;
        String string;
        String string2;
        int n4;
        Typeface typeface;
        TypedArray typedArray;
        boolean bl;
        boolean bl2;
        Context context = this.a.getContext();
        j j2 = j.a();
        w0 w02 = w0.q(context, attributeSet, f.b.j.AppCompatTextHelper, n2, 0);
        TextView textView = this.a;
        l.R((View)textView, (Context)textView.getContext(), (int[])f.b.j.AppCompatTextHelper, (AttributeSet)attributeSet, (TypedArray)w02.b, (int)n2, (int)0);
        int n5 = w02.l(f.b.j.AppCompatTextHelper_android_textAppearance, -1);
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableTop)) {
            this.c = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableRight)) {
            this.d = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableStart)) {
            this.f = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (w02.o(f.b.j.AppCompatTextHelper_android_drawableEnd)) {
            this.g = x.c(context, j2, w02.l(f.b.j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        w02.b.recycle();
        boolean bl3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n5 != -1) {
            w0 w03 = new w0(context, context.obtainStyledAttributes(n5, f.b.j.TextAppearance));
            if (!bl3 && w03.o(f.b.j.TextAppearance_textAllCaps)) {
                bl2 = w03.a(f.b.j.TextAppearance_textAllCaps, false);
                bl = true;
            } else {
                bl2 = false;
                bl = false;
            }
            this.l(context, w03);
            string2 = w03.o(f.b.j.TextAppearance_textLocale) ? w03.m(f.b.j.TextAppearance_textLocale) : null;
            string = Build.VERSION.SDK_INT >= 26 && w03.o(f.b.j.TextAppearance_fontVariationSettings) ? w03.m(f.b.j.TextAppearance_fontVariationSettings) : null;
            w03.b.recycle();
        } else {
            bl2 = false;
            bl = false;
            string2 = null;
            string = null;
        }
        w0 w04 = new w0(context, context.obtainStyledAttributes(attributeSet, f.b.j.TextAppearance, n2, 0));
        if (!bl3 && w04.o(f.b.j.TextAppearance_textAllCaps)) {
            bl2 = w04.a(f.b.j.TextAppearance_textAllCaps, false);
            bl = true;
        }
        if (w04.o(f.b.j.TextAppearance_textLocale)) {
            string2 = w04.m(f.b.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && w04.o(f.b.j.TextAppearance_fontVariationSettings)) {
            string = w04.m(f.b.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && w04.o(f.b.j.TextAppearance_android_textSize) && w04.f(f.b.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.l(context, w04);
        w04.b.recycle();
        if (!bl3 && bl) {
            this.a.setAllCaps(bl2);
        }
        if ((typeface = this.l) != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (string != null) {
            this.a.setFontVariationSettings(string);
        }
        if (string2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.a.setTextLocales(LocaleList.forLanguageTags((String)string2));
            } else {
                String string3 = string2.substring(0, string2.indexOf(44));
                this.a.setTextLocale(Locale.forLanguageTag((String)string3));
            }
        }
        z z2 = this.i;
        TypedArray typedArray2 = z2.j.obtainStyledAttributes(attributeSet, f.b.j.AppCompatTextView, n2, 0);
        TextView textView2 = z2.i;
        l.R((View)textView2, (Context)textView2.getContext(), (int[])f.b.j.AppCompatTextView, (AttributeSet)attributeSet, (TypedArray)typedArray2, (int)n2, (int)0);
        if (typedArray2.hasValue(f.b.j.AppCompatTextView_autoSizeTextType)) {
            z2.a = typedArray2.getInt(f.b.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float f2 = typedArray2.hasValue(f.b.j.AppCompatTextView_autoSizeStepGranularity) ? typedArray2.getDimension(f.b.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float f3 = typedArray2.hasValue(f.b.j.AppCompatTextView_autoSizeMinTextSize) ? typedArray2.getDimension(f.b.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float f4 = typedArray2.hasValue(f.b.j.AppCompatTextView_autoSizeMaxTextSize) ? typedArray2.getDimension(f.b.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArray2.hasValue(f.b.j.AppCompatTextView_autoSizePresetSizes) && (n4 = typedArray2.getResourceId(f.b.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArray3 = typedArray2.getResources().obtainTypedArray(n4);
            int n6 = typedArray3.length();
            int[] arrn = new int[n6];
            if (n6 > 0) {
                for (int i2 = 0; i2 < n6; ++i2) {
                    arrn[i2] = typedArray3.getDimensionPixelSize(i2, -1);
                }
                z2.f = z2.b(arrn);
                z2.h();
            }
            typedArray3.recycle();
        }
        typedArray2.recycle();
        if (z2.i()) {
            if (z2.a == 1) {
                if (!z2.g) {
                    DisplayMetrics displayMetrics = z2.j.getResources().getDisplayMetrics();
                    if (f3 == -1.0f) {
                        f3 = TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)displayMetrics);
                    }
                    if (f4 == -1.0f) {
                        f4 = TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)displayMetrics);
                    }
                    if (f2 == -1.0f) {
                        f2 = 1.0f;
                    }
                    z2.j(f3, f4, f2);
                }
                z2.g();
            }
        } else {
            z2.a = 0;
        }
        if (b.a) {
            int[] arrn;
            z z3 = this.i;
            if (z3.a != 0 && (arrn = z3.f).length > 0) {
                if ((float)this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round((float)this.i.d), Math.round((float)this.i.e), Math.round((float)this.i.c), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(arrn, 0);
                }
            }
        }
        Drawable drawable = (n3 = (typedArray = context.obtainStyledAttributes(attributeSet, f.b.j.AppCompatTextView)).getResourceId(f.b.j.AppCompatTextView_drawableLeftCompat, -1)) != -1 ? j2.b(context, n3) : null;
        int n7 = typedArray.getResourceId(f.b.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawable2 = n7 != -1 ? j2.b(context, n7) : null;
        int n8 = typedArray.getResourceId(f.b.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawable3 = n8 != -1 ? j2.b(context, n8) : null;
        int n9 = typedArray.getResourceId(f.b.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawable4 = n9 != -1 ? j2.b(context, n9) : null;
        int n10 = typedArray.getResourceId(f.b.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawable5 = n10 != -1 ? j2.b(context, n10) : null;
        int n11 = typedArray.getResourceId(f.b.j.AppCompatTextView_drawableEndCompat, -1);
        Drawable drawable6 = n11 != -1 ? j2.b(context, n11) : null;
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] arrdrawable = this.a.getCompoundDrawablesRelative();
                if (arrdrawable[0] == null && arrdrawable[2] == null) {
                    Drawable[] arrdrawable2 = this.a.getCompoundDrawables();
                    TextView textView3 = this.a;
                    if (drawable == null) {
                        drawable = arrdrawable2[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = arrdrawable2[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = arrdrawable2[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = arrdrawable2[3];
                    }
                    textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                } else {
                    TextView textView4 = this.a;
                    Drawable drawable7 = arrdrawable[0];
                    if (drawable2 == null) {
                        drawable2 = arrdrawable[1];
                    }
                    Drawable drawable8 = arrdrawable[2];
                    if (drawable4 == null) {
                        drawable4 = arrdrawable[3];
                    }
                    textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                }
            }
        } else {
            Drawable[] arrdrawable = this.a.getCompoundDrawablesRelative();
            TextView textView5 = this.a;
            if (drawable5 == null) {
                drawable5 = arrdrawable[0];
            }
            if (drawable2 == null) {
                drawable2 = arrdrawable[1];
            }
            if (drawable6 == null) {
                drawable6 = arrdrawable[2];
            }
            if (drawable4 == null) {
                drawable4 = arrdrawable[3];
            }
            textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        }
        if (typedArray.hasValue(f.b.j.AppCompatTextView_drawableTint)) {
            int n12;
            ColorStateList colorStateList;
            int n13 = f.b.j.AppCompatTextView_drawableTint;
            if (!typedArray.hasValue(n13) || (n12 = typedArray.getResourceId(n13, 0)) == 0 || (colorStateList = f.b.l.a.a.a(context, n12)) == null) {
                colorStateList = typedArray.getColorStateList(n13);
            }
            TextView textView6 = this.a;
            if (textView6 != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    textView6.setCompoundDrawableTintList(colorStateList);
                } else if (textView6 instanceof e) {
                    ((e)textView6).setSupportCompoundDrawablesTintList(colorStateList);
                }
            } else {
                throw null;
            }
        }
        if (typedArray.hasValue(f.b.j.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode mode = d0.c(typedArray.getInt(f.b.j.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView7 = this.a;
            if (textView7 != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    textView7.setCompoundDrawableTintMode(mode);
                } else if (textView7 instanceof e) {
                    ((e)textView7).setSupportCompoundDrawablesTintMode(mode);
                }
            } else {
                throw null;
            }
        }
        int n14 = typedArray.getDimensionPixelSize(f.b.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int n15 = typedArray.getDimensionPixelSize(f.b.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int n16 = typedArray.getDimensionPixelSize(f.b.j.AppCompatTextView_lineHeight, -1);
        typedArray.recycle();
        if (n14 != -1) {
            h.i.z1(this.a, n14);
        }
        if (n15 != -1) {
            h.i.A1(this.a, n15);
        }
        if (n16 != -1) {
            h.i.B1(this.a, n16);
        }
    }

    public void f(Context context, int n2) {
        String string;
        w0 w02 = new w0(context, context.obtainStyledAttributes(n2, f.b.j.TextAppearance));
        if (w02.o(f.b.j.TextAppearance_textAllCaps)) {
            boolean bl = w02.a(f.b.j.TextAppearance_textAllCaps, false);
            this.a.setAllCaps(bl);
        }
        if (w02.o(f.b.j.TextAppearance_android_textSize) && w02.f(f.b.j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        this.l(context, w02);
        if (Build.VERSION.SDK_INT >= 26 && w02.o(f.b.j.TextAppearance_fontVariationSettings) && (string = w02.m(f.b.j.TextAppearance_fontVariationSettings)) != null) {
            this.a.setFontVariationSettings(string);
        }
        w02.b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void g(int n2, int n3, int n4, int n5) {
        z z2 = this.i;
        if (z2.i()) {
            DisplayMetrics displayMetrics = z2.j.getResources().getDisplayMetrics();
            z2.j(TypedValue.applyDimension((int)n5, (float)n2, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n5, (float)n3, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)n5, (float)n4, (DisplayMetrics)displayMetrics));
            if (z2.g()) {
                z2.a();
            }
        }
    }

    public void h(int[] arrn, int n2) {
        z z2 = this.i;
        if (z2.i()) {
            int n3 = arrn.length;
            if (n3 > 0) {
                int[] arrn2 = new int[n3];
                if (n2 == 0) {
                    arrn2 = Arrays.copyOf((int[])arrn, (int)n3);
                } else {
                    DisplayMetrics displayMetrics = z2.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        arrn2[i2] = Math.round((float)TypedValue.applyDimension((int)n2, (float)arrn[i2], (DisplayMetrics)displayMetrics));
                    }
                }
                z2.f = z2.b(arrn2);
                if (!z2.h()) {
                    StringBuilder stringBuilder = a.c((String)"None of the preset sizes is valid: ");
                    stringBuilder.append(Arrays.toString((int[])arrn));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            } else {
                z2.g = false;
            }
            if (z2.g()) {
                z2.a();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void i(int n2) {
        z z2 = this.i;
        if (!z2.i()) return;
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalArgumentException(a.b((String)"Unknown auto-size text type: ", (int)n2));
            DisplayMetrics displayMetrics = z2.j.getResources().getDisplayMetrics();
            z2.j(TypedValue.applyDimension((int)2, (float)12.0f, (DisplayMetrics)displayMetrics), TypedValue.applyDimension((int)2, (float)112.0f, (DisplayMetrics)displayMetrics), 1.0f);
            if (!z2.g()) return;
            z2.a();
            return;
        }
        z2.a = 0;
        z2.d = -1.0f;
        z2.e = -1.0f;
        z2.c = -1.0f;
        z2.f = new int[0];
        z2.b = false;
    }

    public void j(ColorStateList colorStateList) {
        u0 u02;
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u03 = this.h;
        u03.a = colorStateList;
        boolean bl = colorStateList != null;
        u03.d = bl;
        this.b = u02 = this.h;
        this.c = u02;
        this.d = u02;
        this.e = u02;
        this.f = u02;
        this.g = u02;
    }

    public void k(PorterDuff.Mode mode) {
        u0 u02;
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u03 = this.h;
        u03.b = mode;
        boolean bl = mode != null;
        u03.c = bl;
        this.b = u02 = this.h;
        this.c = u02;
        this.d = u02;
        this.e = u02;
        this.f = u02;
        this.g = u02;
    }

    /*
     * Exception decompiling
     */
    public final void l(Context var1, w0 var2) {
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
}

