/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  h.h
 *  h.k.d
 *  h.k.i.a
 *  h.k.j.a.d
 *  h.m.b.j
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 */
package h.k.j.a;

import f.b.k.h;
import h.h;
import h.k.j.a.d;
import h.m.b.j;
import java.io.Serializable;

public abstract class a
implements h.k.d<Object>,
d,
Serializable {
    public final h.k.d<Object> e;

    public a(h.k.d<Object> d2) {
        this.e = d2;
    }

    public final void e(Object object) {
        h.k.d<Object> d2;
        a a2 = this;
        do {
            j.e((Object)a2, (String)"frame");
            d2 = a2.e;
            j.c(d2);
            try {
                object = a2.i(object);
                if (object == h.k.i.a.e) {
                    return;
                }
            }
            catch (Throwable throwable) {
                object = h.i.K(throwable);
            }
            a2.j();
            if (!(d2 instanceof a)) break;
            a2 = (a)d2;
        } while (true);
        d2.e(object);
    }

    public h.k.d<h> g(Object object, h.k.d<?> d2) {
        j.e(d2, (String)"completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    /*
     * Exception decompiling
     */
    public StackTraceElement h() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl110 : ALOAD : trying to set 1 previously set to 0
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

    public abstract Object i(Object var1);

    public void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Continuation at ");
        Object object = this.h();
        if (object == null) {
            object = this.getClass().getName();
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

