/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.cert.Certificate
 *  java.util.List
 *  javax.net.ssl.SSLSession
 */
package i;

import i.e0;
import i.g;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLSession;

public final class p {
    public final e0 a;
    public final g b;
    public final List<Certificate> c;
    public final List<Certificate> d;

    public p(e0 e02, g g2, List<Certificate> list, List<Certificate> list2) {
        this.a = e02;
        this.b = g2;
        this.c = list;
        this.d = list2;
    }

    /*
     * Exception decompiling
     */
    public static p a(SSLSession var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl31 : ALOAD : trying to set 1 previously set to 0
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

    public boolean equals(Object object) {
        if (!(object instanceof p)) {
            return false;
        }
        p p2 = (p)object;
        boolean bl = this.a.equals((Object)p2.a);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = this.b.equals((Object)p2.b);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.c.equals(p2.c);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = this.d.equals(p2.d);
                    bl2 = false;
                    if (bl5) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
    }
}

