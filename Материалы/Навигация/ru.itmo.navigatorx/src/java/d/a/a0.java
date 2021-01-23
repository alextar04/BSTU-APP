/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.util.concurrent.locks.LockSupport
 */
package d.a;

import d.a.g0;
import d.a.g1;
import d.a.h0;
import java.util.concurrent.locks.LockSupport;

public final class a0
extends h0
implements Runnable {
    public static volatile Thread _thread;
    public static volatile int debugStatus;
    public static final long k;
    public static final a0 l;

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : ALOAD_1 : trying to set 1 previously set to 0
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Thread T() {
        Thread thread = _thread;
        if (thread != null) {
            return thread;
        }
        a0 a02 = this;
        synchronized (a02) {
            Thread thread2 = _thread;
            if (thread2 == null) {
                _thread = thread2 = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
                thread2.setDaemon(true);
                thread2.start();
            }
            return thread2;
        }
    }

    public final void Z() {
        a0 a02 = this;
        synchronized (a02) {
            block4 : {
                boolean bl = this.a0();
                if (bl) break block4;
                return;
            }
            debugStatus = 3;
            this._queue = null;
            this._delayed = null;
            this.notifyAll();
            return;
        }
    }

    public final boolean a0() {
        int n2 = debugStatus;
        return n2 == 2 || n2 == 3;
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        long l2;
        long l3;
        long l4;
        block14 : {
            int n2;
            g1.a.set((Object)this);
            a0 a02 = this;
            // MONITORENTER : a02
            boolean bl = this.a0();
            if (bl) {
                n2 = 0;
            } else {
                debugStatus = n2 = 1;
                this.notifyAll();
            }
            try {
                // MONITOREXIT : a02
                if (n2 != 0) break block14;
            }
            catch (Throwable throwable) {
                _thread = null;
                this.Z();
                if (this.X()) throw throwable;
                this.T();
                throw throwable;
            }
            _thread = null;
            this.Z();
            if (this.X()) return;
            this.T();
            return;
        }
        long l5 = Long.MAX_VALUE;
        do {
            Thread.interrupted();
            l2 = this.Y();
            if (l2 != Long.MAX_VALUE) break block15;
            l4 = System.nanoTime();
            if (l5 != Long.MAX_VALUE) break block16;
            l3 = k;
            break;
        } while (true);
        {
            block17 : {
                block18 : {
                    block15 : {
                        long l6;
                        block16 : {
                            l5 = l3 + l4;
                        }
                        if ((l6 = l5 - l4) <= 0L) {
                            _thread = null;
                            this.Z();
                            if (this.X()) return;
                            this.T();
                            return;
                        }
                        if (l2 > l6) {
                            l2 = l6;
                        }
                        break block18;
                    }
                    l5 = Long.MAX_VALUE;
                }
                if (l2 <= 0L) continue;
                boolean bl = this.a0();
                if (!bl) break block17;
                _thread = null;
                this.Z();
                if (this.X()) return;
                this.T();
                return;
            }
            LockSupport.parkNanos((Object)this, (long)l2);
            continue;
        }
    }
}

