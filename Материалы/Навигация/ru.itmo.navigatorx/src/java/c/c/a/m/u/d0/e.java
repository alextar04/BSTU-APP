/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c.c.a.m.u.d0;

import android.util.Log;
import c.c.a.k.a;
import c.c.a.m.m;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.d0.c;
import c.c.a.m.u.d0.k;
import java.io.File;
import java.io.IOException;

public class e
implements a {
    public final k a;
    public final File b;
    public final long c;
    public final c d = new c();
    public c.c.a.k.a e;

    @Deprecated
    public e(File file, long l2) {
        this.b = file;
        this.c = l2;
        this.a = new k();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(m var1, a.b var2) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public File b(m m2) {
        String string = this.a.a(m2);
        if (Log.isLoggable((String)"DiskLruCacheWrapper", (int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Get: Obtained: ");
            stringBuilder.append(string);
            stringBuilder.append(" for for Key: ");
            stringBuilder.append((Object)m2);
            Log.v((String)"DiskLruCacheWrapper", (String)stringBuilder.toString());
        }
        a.e e2 = this.c().s(string);
        if (e2 == null) return null;
        try {
            return e2.a[0];
        }
        catch (IOException iOException) {
            if (!Log.isLoggable((String)"DiskLruCacheWrapper", (int)5)) return null;
            Log.w((String)"DiskLruCacheWrapper", (String)"Unable to get from disk cache", (Throwable)iOException);
        }
        return null;
    }

    public final c.c.a.k.a c() {
        e e2 = this;
        synchronized (e2) {
            if (this.e == null) {
                this.e = c.c.a.k.a.v(this.b, 1, 1, this.c);
            }
            c.c.a.k.a a2 = this.e;
            return a2;
        }
    }
}

