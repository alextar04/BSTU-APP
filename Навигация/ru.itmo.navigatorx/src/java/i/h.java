/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.e.c
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.Reference
 *  java.util.ArrayDeque
 *  java.util.Deque
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package i;

import i.d0;
import i.f0.c;
import i.f0.e.d;
import i.f0.e.g;
import i.f0.i.f;
import i.r;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h {
    public static final Executor g;
    public final int a;
    public final long b;
    public final Runnable c = new Runnable(){

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl134.1 : ALOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
    };
    public final Deque<i.f0.e.c> d = new ArrayDeque();
    public final d e = new d();
    public boolean f;

    public static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), c.A("OkHttp ConnectionPool", true));
        g = threadPoolExecutor;
    }

    public h(int n2, long l2, TimeUnit timeUnit) {
        this.a = n2;
        this.b = timeUnit.toNanos(l2);
        if (l2 > 0L) {
            return;
        }
        throw new IllegalArgumentException(c.b.a.a.a.f("keepAliveDuration <= 0: ", l2));
    }

    public final int a(i.f0.e.c c2, long l2) {
        List list = c2.n;
        int n2 = 0;
        while (n2 < list.size()) {
            Reference reference = (Reference)list.get(n2);
            if (reference.get() != null) {
                ++n2;
                continue;
            }
            g.a a2 = (g.a)reference;
            StringBuilder stringBuilder = c.b.a.a.a.c("A connection to ");
            stringBuilder.append((Object)c2.c.a.a);
            stringBuilder.append(" was leaked. Did you forget to close a response body?");
            String string = stringBuilder.toString();
            f.a.m(string, a2.a);
            list.remove(n2);
            c2.k = true;
            if (!list.isEmpty()) continue;
            c2.o = l2 - this.b;
            return 0;
        }
        return list.size();
    }

}

