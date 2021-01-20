/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.util.Log
 *  java.io.FileNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.c.a.m.t;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import c.c.a.e;
import c.c.a.m.a;
import c.c.a.m.t.d;
import java.io.FileNotFoundException;

public abstract class l<T>
implements d<T> {
    public final Uri e;
    public final ContentResolver f;
    public T g;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f = contentResolver;
        this.e = uri;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void b() {
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

    @Override
    public a c() {
        return a.e;
    }

    @Override
    public void cancel() {
    }

    public abstract void d(T var1);

    @Override
    public final void e(e e2, d.a<? super T> a2) {
        T t2;
        try {
            t2 = this.f(this.e, this.f);
            this.g = t2;
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (Log.isLoggable((String)"LocalUriFetcher", (int)3)) {
                Log.d((String)"LocalUriFetcher", (String)"Failed to open Uri", (Throwable)fileNotFoundException);
            }
            a2.d((Exception)fileNotFoundException);
            return;
        }
        a2.f(t2);
    }

    public abstract T f(Uri var1, ContentResolver var2);
}

