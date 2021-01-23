/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.c.a.m.v;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.f;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class f<Data>
implements n<File, Data> {
    public final d<Data> a;

    public f(d<Data> d2) {
        this.a = d2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        File file = (File)object;
        return new n.a<Data>(new c.c.a.r.d((Object)file), new c<Data>(file, this.a));
    }

    @Override
    public boolean b(Object object) {
        (File)object;
        return true;
    }

    public static class a<Data>
    implements c.c.a.m.v.o<File, Data> {
        public final d<Data> a;

        public a(d<Data> d2) {
            this.a = d2;
        }

        @Override
        public final n<File, Data> b(r r2) {
            return new f<Data>(this.a);
        }
    }

    public static final class c<Data>
    implements c.c.a.m.t.d<Data> {
        public final File e;
        public final d<Data> f;
        public Data g;

        public c(File file, d<Data> d2) {
            this.e = file;
            this.f = d2;
        }

        @Override
        public Class<Data> a() {
            return this.f.a();
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

        @Override
        public c.c.a.m.a c() {
            return c.c.a.m.a.e;
        }

        @Override
        public void cancel() {
        }

        @Override
        public void e(c.c.a.e e2, d.a<? super Data> a2) {
            Data Data;
            try {
                Data = this.f.b(this.e);
                this.g = Data;
            }
            catch (FileNotFoundException fileNotFoundException) {
                if (Log.isLoggable((String)"FileLoader", (int)3)) {
                    Log.d((String)"FileLoader", (String)"Failed to open file", (Throwable)fileNotFoundException);
                }
                a2.d((Exception)fileNotFoundException);
                return;
            }
            a2.f(Data);
        }
    }

}

