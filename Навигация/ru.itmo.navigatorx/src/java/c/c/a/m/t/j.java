/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.util.Map
 */
package c.c.a.m.t;

import android.util.Log;
import c.c.a.e;
import c.c.a.m.t.d;
import c.c.a.m.v.g;
import c.c.a.m.v.h;
import c.c.a.s.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class j
implements d<InputStream> {
    public static final b k = new a();
    public final g e;
    public final int f;
    public final b g;
    public HttpURLConnection h;
    public InputStream i;
    public volatile boolean j;

    public j(g g2, int n2) {
        b b2 = k;
        this.e = g2;
        this.f = n2;
        this.g = b2;
    }

    @Override
    public Class<InputStream> a() {
        return InputStream.class;
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
    public c.c.a.m.a c() {
        return c.c.a.m.a.f;
    }

    @Override
    public void cancel() {
        this.j = true;
    }

    /*
     * Exception decompiling
     */
    public final InputStream d(URL var1, int var2, URL var3, Map<String, String> var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void e(e e2, d.a<? super InputStream> a2) {
        Throwable throwable2222;
        long l2;
        block5 : {
            StringBuilder stringBuilder;
            block6 : {
                l2 = f.b();
                a2.f((InputStream)this.d(this.e.d(), 0, null, this.e.b.a()));
                if (!Log.isLoggable((String)"HttpUrlFetcher", (int)2)) return;
                stringBuilder = new StringBuilder();
                break block6;
                {
                    catch (Throwable throwable2222) {
                        break block5;
                    }
                    catch (IOException iOException) {}
                    {
                        if (Log.isLoggable((String)"HttpUrlFetcher", (int)3)) {
                            Log.d((String)"HttpUrlFetcher", (String)"Failed to load data for url", (Throwable)iOException);
                        }
                        a2.d((Exception)iOException);
                    }
                    if (!Log.isLoggable((String)"HttpUrlFetcher", (int)2)) return;
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append("Finished http url fetcher fetch in ");
            stringBuilder.append(f.a(l2));
            Log.v((String)"HttpUrlFetcher", (String)stringBuilder.toString());
            return;
        }
        if (!Log.isLoggable((String)"HttpUrlFetcher", (int)2)) throw throwable2222;
        StringBuilder stringBuilder = c.b.a.a.a.c("Finished http url fetcher fetch in ");
        stringBuilder.append(f.a(l2));
        Log.v((String)"HttpUrlFetcher", (String)stringBuilder.toString());
        throw throwable2222;
    }

    public static class a
    implements b {
    }

}

