/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.ExceptionInInitializerError
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 */
package k.a.z0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b {
    public static final a a;

    /*
     * Exception decompiling
     */
    public static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_0 : trying to set 1 previously set to 0
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

    public static a a(String string) {
        try {
            a a2 = (a)Class.forName((String)string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return a2;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new ExceptionInInitializerError((Throwable)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ExceptionInInitializerError((Throwable)noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ExceptionInInitializerError((Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new ExceptionInInitializerError((Throwable)instantiationException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ExceptionInInitializerError((Throwable)classNotFoundException);
        }
    }

    public static interface a {
        public String a(long var1);
    }

}

