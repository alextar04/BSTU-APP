/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.concurrent.atomic.AtomicReference
 */
package c.c.a.s;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a {
    public static final AtomicReference<byte[]> a = new AtomicReference();

    /*
     * Exception decompiling
     */
    public static ByteBuffer a(File var0) {
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

    public static ByteBuffer b(InputStream inputStream) {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] arrby = (byte[])a.getAndSet(null);
        if (arrby == null) {
            arrby = new byte[16384];
        }
        while ((n2 = inputStream.read(arrby)) >= 0) {
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        a.set((Object)arrby);
        byte[] arrby2 = byteArrayOutputStream.toByteArray();
        return (ByteBuffer)ByteBuffer.allocateDirect((int)arrby2.length).put(arrby2).position(0);
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        b b2 = !byteBuffer.isReadOnly() && byteBuffer.hasArray() ? new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit()) : null;
        if (b2 != null && b2.a == 0 && b2.b == b2.c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBuffer2 = byteBuffer.asReadOnlyBuffer();
        byte[] arrby = new byte[byteBuffer2.limit()];
        byteBuffer2.position(0);
        byteBuffer2.get(arrby);
        return arrby;
    }

    /*
     * Exception decompiling
     */
    public static void d(ByteBuffer var0, File var1) {
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

    public static InputStream e(ByteBuffer byteBuffer) {
        return new a(byteBuffer);
    }

    public static class a
    extends InputStream {
        public final ByteBuffer e;
        public int f = -1;

        public a(ByteBuffer byteBuffer) {
            this.e = byteBuffer;
        }

        public int available() {
            return this.e.remaining();
        }

        public void mark(int n2) {
            a a2 = this;
            synchronized (a2) {
                this.f = this.e.position();
                return;
            }
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!this.e.hasRemaining()) {
                return -1;
            }
            return 255 & this.e.get();
        }

        public int read(byte[] arrby, int n2, int n3) {
            if (!this.e.hasRemaining()) {
                return -1;
            }
            int n4 = Math.min((int)n3, (int)this.available());
            this.e.get(arrby, n2, n4);
            return n4;
        }

        public void reset() {
            a a2 = this;
            synchronized (a2) {
                if (this.f != -1) {
                    this.e.position(this.f);
                    return;
                }
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        public long skip(long l2) {
            if (!this.e.hasRemaining()) {
                return -1L;
            }
            long l3 = Math.min((long)l2, (long)this.available());
            ByteBuffer byteBuffer = this.e;
            byteBuffer.position((int)(l3 + (long)byteBuffer.position()));
            return l3;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final byte[] c;

        public b(byte[] arrby, int n2, int n3) {
            this.c = arrby;
            this.a = n2;
            this.b = n3;
        }
    }

}

