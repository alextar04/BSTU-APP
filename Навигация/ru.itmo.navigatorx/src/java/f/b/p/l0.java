/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MenuItem
 *  f.b.o.i.g
 *  f.b.p.j0
 *  f.b.p.l0$a
 *  java.lang.reflect.Method
 */
package f.b.p;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import f.b.o.i.g;
import f.b.p.e0;
import f.b.p.j0;
import f.b.p.k0;
import f.b.p.l0;
import java.lang.reflect.Method;

/*
 * Exception performing whole class analysis.
 */
public class l0
extends j0
implements k0 {
    public static Method K;
    public k0 J;

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    public l0(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, null, n2, n3);
    }

    @Override
    public void e(g g2, MenuItem menuItem) {
        k0 k02 = this.J;
        if (k02 != null) {
            k02.e(g2, menuItem);
        }
    }

    @Override
    public void h(g g2, MenuItem menuItem) {
        k0 k02 = this.J;
        if (k02 != null) {
            k02.h(g2, menuItem);
        }
    }

    public e0 q(Context context, boolean bl) {
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        a2.setHoverListener((k0)this);
        return a2;
    }
}

