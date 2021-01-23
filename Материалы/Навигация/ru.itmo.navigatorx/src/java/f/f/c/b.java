/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$a
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.HashMap
 */
package f.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import f.f.b.i.d;
import f.f.b.i.g;
import f.f.c.j;
import java.util.Arrays;
import java.util.HashMap;

public abstract class b
extends View {
    public int[] e = new int[32];
    public int f;
    public Context g;
    public g h;
    public boolean i = false;
    public String j;
    public HashMap<Integer, String> k = new HashMap();

    public b(Context context) {
        super(context);
        this.g = context;
        this.e(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = context;
        this.e(attributeSet);
    }

    /*
     * Exception decompiling
     */
    public final void a(String var1) {
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

    public final void b(int n2) {
        if (n2 == this.getId()) {
            return;
        }
        int n3 = 1 + this.f;
        int[] arrn = this.e;
        if (n3 > arrn.length) {
            this.e = Arrays.copyOf((int[])arrn, (int)(2 * arrn.length));
        }
        int[] arrn2 = this.e;
        int n4 = this.f;
        arrn2[n4] = n2;
        this.f = n4 + 1;
    }

    public void c() {
        ViewParent viewParent = this.getParent();
        if (viewParent != null && viewParent instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout)viewParent;
            int n2 = this.getVisibility();
            float f2 = this.getElevation();
            for (int i2 = 0; i2 < this.f; ++i2) {
                View view = constraintLayout.d(this.e[i2]);
                if (view == null) continue;
                view.setVisibility(n2);
                if (!(f2 > 0.0f)) continue;
                view.setTranslationZ(f2 + view.getTranslationZ());
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String string) {
        if (string != null) {
            if (constraintLayout == null) {
                return 0;
            }
            Resources resources = this.g.getResources();
            if (resources == null) {
                return 0;
            }
            int n2 = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view;
                String string2;
                view = constraintLayout.getChildAt(i2);
                if (view.getId() == -1) continue;
                string2 = null;
                try {
                    string2 = resources.getResourceEntryName(view.getId());
                }
                catch (Resources.NotFoundException notFoundException) {}
                if (!string.equals((Object)string2)) continue;
                return view.getId();
            }
        }
        return 0;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, j.ConstraintLayout_Layout);
            int n2 = typedArray.getIndexCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string;
                int n3 = typedArray.getIndex(i2);
                if (n3 != j.ConstraintLayout_Layout_constraint_referenced_ids) continue;
                this.j = string = typedArray.getString(n3);
                this.setIds(string);
            }
        }
    }

    public void f(d d2, boolean bl) {
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf((int[])this.e, (int)this.f);
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
        if (this.h == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a)layoutParams).m0 = (d)((Object)this.h);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String string = this.j;
        if (string != null) {
            this.setIds(string);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int n2, int n3) {
        if (this.i) {
            super.onMeasure(n2, n3);
            return;
        }
        this.setMeasuredDimension(0, 0);
    }

    public void setIds(String string) {
        this.j = string;
        if (string == null) {
            return;
        }
        int n2 = 0;
        this.f = 0;
        do {
            int n3;
            if ((n3 = string.indexOf(44, n2)) == -1) {
                this.a(string.substring(n2));
                return;
            }
            this.a(string.substring(n2, n3));
            n2 = n3 + 1;
        } while (true);
    }

    public void setReferencedIds(int[] arrn) {
        this.j = null;
        this.f = 0;
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            this.b(arrn[i2]);
        }
    }
}

