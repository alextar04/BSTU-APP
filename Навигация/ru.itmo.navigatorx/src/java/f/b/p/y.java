/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 *  f.h.m.b
 *  f.h.m.e
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.util.concurrent.Future
 */
package f.b.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import f.b.k.h;
import f.b.l.a.a;
import f.b.p.e;
import f.b.p.r0;
import f.b.p.t0;
import f.b.p.u0;
import f.b.p.w;
import f.b.p.x;
import f.b.p.z;
import f.h.f.d;
import f.h.j.b;
import java.util.concurrent.Future;

public class y
extends TextView
implements f.h.m.e,
f.h.m.b {
    public final e e;
    public final x f;
    public final w g;
    public Future<b> h;

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public y(Context context, AttributeSet attributeSet, int n2) {
        e e2;
        x x2;
        t0.a(context);
        super(context, attributeSet, n2);
        r0.a((View)this, this.getContext());
        this.e = e2 = new e((View)this);
        e2.d(attributeSet, n2);
        this.f = x2 = new x(this);
        x2.e(attributeSet, n2);
        this.f.b();
        this.g = new w(this);
    }

    public void drawableStateChanged() {
        x x2;
        super.drawableStateChanged();
        e e2 = this.e;
        if (e2 != null) {
            e2.a();
        }
        if ((x2 = this.f) != null) {
            x2.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (f.h.m.b.a) {
            return super.getAutoSizeMaxTextSize();
        }
        x x2 = this.f;
        if (x2 != null) {
            return Math.round((float)x2.i.e);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f.h.m.b.a) {
            return super.getAutoSizeMinTextSize();
        }
        x x2 = this.f;
        if (x2 != null) {
            return Math.round((float)x2.i.d);
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (f.h.m.b.a) {
            return super.getAutoSizeStepGranularity();
        }
        x x2 = this.f;
        if (x2 != null) {
            return Math.round((float)x2.i.c);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f.h.m.b.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        x x2 = this.f;
        if (x2 != null) {
            return x2.i.f;
        }
        return new int[0];
    }

    @SuppressLint(value={"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f.h.m.b.a) {
            int n2 = super.getAutoSizeTextType();
            int n3 = 0;
            if (n2 == 1) {
                n3 = 1;
            }
            return n3;
        }
        x x2 = this.f;
        if (x2 != null) {
            return x2.i.a;
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return this.getPaddingTop() - this.getPaint().getFontMetricsInt().top;
    }

    public int getLastBaselineToBottomHeight() {
        return this.getPaddingBottom() + this.getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e e2 = this.e;
        if (e2 != null) {
            return e2.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e e2 = this.e;
        if (e2 != null) {
            return e2.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        u0 u02 = this.f.h;
        if (u02 != null) {
            return u02.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        u0 u02 = this.f.h;
        if (u02 != null) {
            return u02.b;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public CharSequence getText() {
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

    public TextClassifier getTextClassifier() {
        w w2;
        if (Build.VERSION.SDK_INT < 28 && (w2 = this.g) != null) {
            return w2.a();
        }
        return super.getTextClassifier();
    }

    public b.a getTextMetricsParamsCompat() {
        return h.i.v0(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        h.i.f1(inputConnection, editorInfo, (View)this);
        return inputConnection;
    }

    public void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        x x2 = this.f;
        if (x2 != null && !f.h.m.b.a) {
            x2.i.a();
        }
    }

    /*
     * Exception decompiling
     */
    public void onMeasure(int var1, int var2) {
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

    public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        super.onTextChanged(charSequence, n2, n3, n4);
        x x2 = this.f;
        if (x2 != null && !f.h.m.b.a && x2.d()) {
            this.f.i.a();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n2, int n3, int n4, int n5) {
        if (f.h.m.b.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n2, n3, n4, n5);
            return;
        }
        x x2 = this.f;
        if (x2 != null) {
            x2.g(n2, n3, n4, n5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arrn, int n2) {
        if (f.h.m.b.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arrn, n2);
            return;
        }
        x x2 = this.f;
        if (x2 != null) {
            x2.h(arrn, n2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int n2) {
        if (f.h.m.b.a) {
            super.setAutoSizeTextTypeWithDefaults(n2);
            return;
        }
        x x2 = this.f;
        if (x2 != null) {
            x2.i(n2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e e2 = this.e;
        if (e2 != null) {
            e2.e();
        }
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        e e2 = this.e;
        if (e2 != null) {
            e2.f(n2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n2, int n3, int n4, int n5) {
        Context context = this.getContext();
        Drawable drawable = n2 != 0 ? a.b(context, n2) : null;
        Drawable drawable2 = n3 != 0 ? a.b(context, n3) : null;
        Drawable drawable3 = n4 != 0 ? a.b(context, n4) : null;
        Drawable drawable4 = null;
        if (n5 != 0) {
            drawable4 = a.b(context, n5);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n2, int n3, int n4, int n5) {
        Context context = this.getContext();
        Drawable drawable = n2 != 0 ? a.b(context, n2) : null;
        Drawable drawable2 = n3 != 0 ? a.b(context, n3) : null;
        Drawable drawable3 = n4 != 0 ? a.b(context, n4) : null;
        Drawable drawable4 = null;
        if (n5 != 0) {
            drawable4 = a.b(context, n5);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x x2 = this.f;
        if (x2 != null) {
            x2.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(h.i.U1(this, callback));
    }

    public void setFirstBaselineToTopHeight(int n2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(n2);
            return;
        }
        h.i.z1(this, n2);
    }

    public void setLastBaselineToBottomHeight(int n2) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(n2);
            return;
        }
        h.i.A1(this, n2);
    }

    public void setLineHeight(int n2) {
        h.i.B1(this, n2);
    }

    public void setPrecomputedText(b b2) {
        h.i.D1(this, b2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e e2 = this.e;
        if (e2 != null) {
            e2.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e e2 = this.e;
        if (e2 != null) {
            e2.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f.j(colorStateList);
        this.f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f.k(mode);
        this.f.b();
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        x x2 = this.f;
        if (x2 != null) {
            x2.f(context, n2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        w w2;
        if (Build.VERSION.SDK_INT < 28 && (w2 = this.g) != null) {
            w2.b = textClassifier;
            return;
        }
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<b> future) {
        this.h = future;
        if (future != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a a2) {
        TextDirectionHeuristic textDirectionHeuristic = a2.b;
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int n2 = 1;
        if (textDirectionHeuristic != textDirectionHeuristic2 && textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                n2 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                n2 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                n2 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                n2 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                n2 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                n2 = 7;
            }
        }
        this.setTextDirection(n2);
        this.getPaint().set(a2.a);
        this.setBreakStrategy(a2.c);
        this.setHyphenationFrequency(a2.d);
    }

    public void setTextSize(int n2, float f2) {
        boolean bl = f.h.m.b.a;
        if (bl) {
            super.setTextSize(n2, f2);
            return;
        }
        x x2 = this.f;
        if (x2 != null && !bl && !x2.d()) {
            x2.i.f(n2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int n2) {
        Typeface typeface2 = typeface != null && n2 > 0 ? d.a(this.getContext(), typeface, n2) : null;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        super.setTypeface(typeface, n2);
    }
}

