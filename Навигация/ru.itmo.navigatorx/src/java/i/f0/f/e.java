/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.k$a
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package i.f0.f;

import i.a0;
import i.j;
import i.k;
import i.q;
import i.r;
import i.x;
import j.h;

public final class e {
    public static {
        h.e("\"\\");
        h.e("\t ,=");
    }

    /*
     * Exception decompiling
     */
    public static long a(a0 var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14.1 : LDC2_W : trying to set 1 previously set to 0
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

    public static boolean b(a0 a02) {
        if (a02.e.b.equals((Object)"HEAD")) {
            return false;
        }
        int n2 = a02.g;
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        if (e.a(a02) == -1L) {
            String string = a02.j.c("Transfer-Encoding");
            if (string == null) {
                string = null;
            }
            return "chunked".equalsIgnoreCase(string);
        }
        return true;
    }

    public static int c(String string, int n2) {
        long l2;
        block3 : {
            try {
                l2 = Long.parseLong((String)string);
                if (l2 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (l2 >= 0L) break block3;
                return 0;
            }
            catch (NumberFormatException numberFormatException) {
                return n2;
            }
        }
        return (int)l2;
    }

    public static void d(k k2, r r2, q q2) {
        if (k2 == k.a) {
            return;
        }
        if (j.b(r2, q2).isEmpty()) {
            return;
        }
        if ((k.a)k2 != null) {
            return;
        }
        throw null;
    }

    public static int e(String string, int n2, String string2) {
        while (n2 < string.length()) {
            if (string2.indexOf((int)string.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n2;
    }
}

