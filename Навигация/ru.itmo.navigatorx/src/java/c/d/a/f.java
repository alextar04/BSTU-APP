/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  c.d.a.a
 *  c.d.a.h
 *  f.b.k.h
 *  java.io.File
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.UnsatisfiedLinkError
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 */
package c.d.a;

import android.content.Context;
import c.d.a.b;
import c.d.a.c;
import c.d.a.d;
import c.d.a.e;
import c.d.a.h;
import f.b.k.h;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class f {
    public final Set<String> a;
    public final d b;
    public final c c;

    public f() {
        h h2 = new h();
        c.d.a.a a2 = new c.d.a.a();
        this.a = new HashSet();
        this.b = h2;
        this.c = a2;
    }

    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    public File b(Context context, String string, String string2) {
        String string3 = ((h)this.b).a(string);
        if (h.i.H0(string2)) {
            return new File(this.a(context), string3);
        }
        return new File(this.a(context), c.b.a.a.a.k(string3, ".", string2));
    }

    public void c(final Context context, final String string, final String string2, final e e2) {
        if (context != null) {
            if (!h.i.H0(string)) {
                Object[] arrobject = new Object[]{string};
                String.format((Locale)Locale.US, (String)"Beginning load of %s...", (Object[])arrobject);
                if (e2 == null) {
                    this.d(context, string, string2);
                    return;
                }
                Runnable runnable = new Runnable(){

                    public void run() {
                        void var1_3;
                        try {
                            f.this.d(context, string, string2);
                            e2.b();
                            return;
                        }
                        catch (b b2) {
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                            // empty catch block
                        }
                        e2.a((Throwable)var1_3);
                    }
                };
                new Thread(runnable).start();
                return;
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    /*
     * Exception decompiling
     */
    public final void d(Context var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl377.1 : ILOAD : trying to set 1 previously set to 0
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

}

