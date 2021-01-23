/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.PrintStream
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package c.c.a.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
implements Closeable {
    public final File e;
    public final File f;
    public final File g;
    public final File h;
    public final int i;
    public long j;
    public final int k;
    public long l = 0L;
    public Writer m;
    public final LinkedHashMap<String, d> n = new LinkedHashMap(0, 0.75f, true);
    public int o;
    public long p = 0L;
    public final ThreadPoolExecutor q;
    public final Callable<Void> r;

    public a(File file, int n2, int n3, long l2) {
        ThreadPoolExecutor threadPoolExecutor;
        this.q = threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new b(null));
        this.r = new Callable<Void>(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object call() {
                a a2;
                a a3 = a2 = a.this;
                synchronized (a3) {
                    if (a.this.m != null) {
                        a.this.M();
                        if (!a.this.u()) return null;
                        a.this.K();
                        a.this.o = 0;
                    }
                    return null;
                }
            }
        };
        this.e = file;
        this.i = n2;
        this.f = new File(file, "journal");
        this.g = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.k = n3;
        this.j = l2;
    }

    public static void L(File file, File file2, boolean bl) {
        if (bl) {
            a.j(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(a a2, c c2, boolean bl) {
        a a3 = a2;
        synchronized (a3) {
            block16 : {
                d d2 = c2.a;
                if (d2.f != c2) {
                    throw new IllegalStateException();
                }
                int n2 = 0;
                if (bl) {
                    boolean bl2 = d2.e;
                    n2 = 0;
                    if (!bl2) {
                        int n3 = 0;
                        do {
                            int n4 = a2.k;
                            n2 = 0;
                            if (n3 >= n4) break;
                            if (!c2.b[n3]) {
                                c2.a();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Newly created entry didn't create value for index ");
                                stringBuilder.append(n3);
                                throw new IllegalStateException(stringBuilder.toString());
                            }
                            if (!d2.d[n3].exists()) {
                                c2.a();
                                break block16;
                            }
                            ++n3;
                        } while (true);
                    }
                }
                do {
                    if (n2 >= a2.k) {
                        a2.o = 1 + a2.o;
                        d2.f = null;
                        if (bl | d2.e) {
                            d2.e = true;
                            a2.m.append((CharSequence)"CLEAN");
                            a2.m.append(' ');
                            a2.m.append((CharSequence)d2.a);
                            a2.m.append((CharSequence)d2.a());
                            a2.m.append('\n');
                            if (bl) {
                                long l2 = a2.p;
                                a2.p = 1L + l2;
                                d2.g = l2;
                            }
                        } else {
                            a2.n.remove((Object)d2.a);
                            a2.m.append((CharSequence)"REMOVE");
                            a2.m.append(' ');
                            a2.m.append((CharSequence)d2.a);
                            a2.m.append('\n');
                        }
                        a.p(a2.m);
                        if (a2.l <= a2.j && !a2.u()) break;
                        a2.q.submit(a2.r);
                        break;
                    }
                    File file = d2.d[n2];
                    if (bl) {
                        if (file.exists()) {
                            long l3;
                            File file2 = d2.c[n2];
                            file.renameTo(file2);
                            long l4 = d2.b[n2];
                            d2.b[n2] = l3 = file2.length();
                            a2.l = l3 + (a2.l - l4);
                        }
                    } else {
                        a.j(file);
                    }
                    ++n2;
                } while (true);
            }
            return;
        }
    }

    @TargetApi(value=26)
    public static void h(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
            return;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    public static void j(File file) {
        if (file.exists()) {
            if (file.delete()) {
                return;
            }
            throw new IOException();
        }
    }

    @TargetApi(value=26)
    public static void p(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
            return;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    public static a v(File file, int n2, int n3, long l2) {
        if (l2 > 0L) {
            if (n3 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a.L(file2, file3, false);
                    }
                }
                a a2 = new a(file, n2, n3, l2);
                if (a2.f.exists()) {
                    try {
                        a2.B();
                        a2.x();
                        return a2;
                    }
                    catch (IOException iOException) {
                        PrintStream printStream = System.out;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("DiskLruCache ");
                        stringBuilder.append((Object)file);
                        stringBuilder.append(" is corrupt: ");
                        stringBuilder.append(iOException.getMessage());
                        stringBuilder.append(", removing");
                        printStream.println(stringBuilder.toString());
                        a2.close();
                        c.c.a.k.c.a(a2.e);
                    }
                }
                file.mkdirs();
                a a3 = new a(file, n2, n3, l2);
                a3.K();
                return a3;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /*
     * Exception decompiling
     */
    public final void B() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl101 : RETURN : trying to set 0 previously set to 1
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
    public final void J(String string) {
        d d2;
        String string2;
        int n2 = string.indexOf(32);
        if (n2 == -1) {
            throw new IOException(c.b.a.a.a.j("unexpected journal line: ", string));
        }
        int n3 = n2 + 1;
        int n4 = string.indexOf(32, n3);
        if (n4 == -1) {
            string2 = string.substring(n3);
            if (n2 == 6 && string.startsWith("REMOVE")) {
                this.n.remove((Object)string2);
                return;
            }
        } else {
            string2 = string.substring(n3, n4);
        }
        if ((d2 = (d)this.n.get((Object)string2)) == null) {
            d2 = new d(string2, null);
            this.n.put((Object)string2, (Object)d2);
        }
        if (n4 == -1 || n2 != 5 || !string.startsWith("CLEAN")) {
            if (n4 == -1 && n2 == 5 && string.startsWith("DIRTY")) {
                d2.f = new c(d2, null);
                return;
            }
            if (n4 == -1 && n2 == 4 && string.startsWith("READ")) return;
            {
                throw new IOException(c.b.a.a.a.j("unexpected journal line: ", string));
            }
        }
        String[] arrstring = string.substring(n4 + 1).split(" ");
        d2.e = true;
        d2.f = null;
        if (arrstring.length != d2.a.this.k) {
            d2.b(arrstring);
            throw null;
        }
        try {
            for (int i2 = 0; i2 < arrstring.length; ++i2) {
                d2.b[i2] = Long.parseLong((String)arrstring[i2]);
            }
            return;
        }
        catch (NumberFormatException numberFormatException) {
            d2.b(arrstring);
            throw null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void K() {
        a a2 = this;
        synchronized (a2) {
            if (this.m != null) {
                a.h(this.m);
            }
            BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(this.g), c.c.a.k.c.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString((int)this.i));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString((int)this.k));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d d2 : this.n.values()) {
                    String string;
                    if (d2.f != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("DIRTY ");
                        stringBuilder.append(d2.a);
                        stringBuilder.append('\n');
                        string = stringBuilder.toString();
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("CLEAN ");
                        stringBuilder.append(d2.a);
                        stringBuilder.append(d2.a());
                        stringBuilder.append('\n');
                        string = stringBuilder.toString();
                    }
                    bufferedWriter.write(string);
                }
            }
            catch (Throwable throwable) {}
            a.h((Writer)bufferedWriter);
            if (this.f.exists()) {
                a.L(this.f, this.h, true);
            }
            a.L(this.g, this.f, false);
            this.h.delete();
            this.m = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(this.f, true), c.c.a.k.c.a));
            return;
            a.h((Writer)bufferedWriter);
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void M() {
        while (this.l > this.j) {
            String string = (String)((Map.Entry)this.n.entrySet().iterator().next()).getKey();
            a a2 = this;
            synchronized (a2) {
                this.f();
                d d2 = (d)this.n.get((Object)string);
                if (d2 != null) {
                    c c2 = d2.f;
                    if (c2 == null) {
                        for (int i2 = 0; i2 < this.k; this.l -= d2.b[i2], ++i2) {
                            File file = d2.c[i2];
                            if (file.exists() && !file.delete()) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("failed to delete ");
                                stringBuilder.append((Object)file);
                                throw new IOException(stringBuilder.toString());
                            }
                            d2.b[i2] = 0L;
                        }
                        this.o = 1 + this.o;
                        this.m.append((CharSequence)"REMOVE");
                        this.m.append(' ');
                        this.m.append((CharSequence)string);
                        this.m.append('\n');
                        this.n.remove((Object)string);
                        if (this.u()) {
                            this.q.submit(this.r);
                        }
                    }
                }
            }
        }
        return;
    }

    public void close() {
        a a2 = this;
        synchronized (a2) {
            block5 : {
                Writer writer = this.m;
                if (writer != null) break block5;
                return;
            }
            for (d d2 : new ArrayList(this.n.values())) {
                if (d2.f == null) continue;
                d2.f.a();
            }
            this.M();
            a.h(this.m);
            this.m = null;
            return;
        }
    }

    public final void f() {
        if (this.m != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c m(String string) {
        a a2 = this;
        synchronized (a2) {
            c c2;
            this.f();
            d d2 = (d)this.n.get((Object)string);
            if (d2 == null) {
                d2 = new d(string, null);
                this.n.put((Object)string, (Object)d2);
            } else {
                c c3 = d2.f;
                if (c3 != null) {
                    return null;
                }
            }
            d2.f = c2 = new c(d2, null);
            this.m.append((CharSequence)"DIRTY");
            this.m.append(' ');
            this.m.append((CharSequence)string);
            this.m.append('\n');
            a.p(this.m);
            return c2;
        }
    }

    public e s(String string) {
        a a2 = this;
        synchronized (a2) {
            d d2;
            block10 : {
                block9 : {
                    this.f();
                    d2 = (d)this.n.get((Object)string);
                    if (d2 != null) break block9;
                    return null;
                }
                boolean bl = d2.e;
                if (bl) break block10;
                return null;
            }
            File[] arrfile = d2.c;
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                boolean bl = arrfile[i2].exists();
                if (bl) continue;
                return null;
            }
            this.o = 1 + this.o;
            this.m.append((CharSequence)"READ");
            this.m.append(' ');
            this.m.append((CharSequence)string);
            this.m.append('\n');
            if (this.u()) {
                this.q.submit(this.r);
            }
            e e2 = new e(string, d2.g, d2.c, d2.b, null);
            return e2;
        }
    }

    public final boolean u() {
        int n2 = this.o;
        return n2 >= 2000 && n2 >= this.n.size();
    }

    public final void x() {
        a.j(this.g);
        Iterator iterator = this.n.values().iterator();
        while (iterator.hasNext()) {
            int n2;
            d d2 = (d)iterator.next();
            c c2 = d2.f;
            if (c2 == null) {
                for (n2 = 0; n2 < this.k; ++n2) {
                    this.l += d2.b[n2];
                }
                continue;
            }
            d2.f = null;
            while (n2 < this.k) {
                a.j(d2.c[n2]);
                a.j(d2.d[n2]);
                ++n2;
            }
            iterator.remove();
        }
    }

    public static final class b
    implements ThreadFactory {
        public b(a a2) {
        }

        public Thread newThread(Runnable runnable) {
            b b2 = this;
            synchronized (b2) {
                Thread thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
                return thread;
            }
        }
    }

    public final class c {
        public final d a;
        public final boolean[] b;
        public boolean c;

        public c(d d2, a a3) {
            this.a = d2;
            boolean[] arrbl = d2.e ? null : new boolean[a.this.k];
            this.b = arrbl;
        }

        public void a() {
            a.c(a.this, this, false);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public File b(int n2) {
            a a2;
            a a3 = a2 = a.this;
            synchronized (a3) {
                if (this.a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.e) {
                    this.b[n2] = true;
                }
                File file = this.a.d[n2];
                if (!a.this.e.exists()) {
                    a.this.e.mkdirs();
                }
                return file;
            }
        }
    }

    public final class d {
        public final String a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public d(String string, a a3) {
            this.a = string;
            int n2 = a.this.k;
            this.b = new long[n2];
            this.c = new File[n2];
            this.d = new File[n2];
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.append('.');
            int n3 = stringBuilder.length();
            for (int i2 = 0; i2 < a.this.k; ++i2) {
                stringBuilder.append(i2);
                this.c[i2] = new File(a.this.e, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.d[i2] = new File(a.this.e, stringBuilder.toString());
                stringBuilder.setLength(n3);
            }
        }

        public String a() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long l2 : this.b) {
                stringBuilder.append(' ');
                stringBuilder.append(l2);
            }
            return stringBuilder.toString();
        }

        public final IOException b(String[] arrstring) {
            StringBuilder stringBuilder = c.b.a.a.a.c("unexpected journal line: ");
            stringBuilder.append(Arrays.toString((Object[])arrstring));
            throw new IOException(stringBuilder.toString());
        }
    }

    public final class e {
        public final File[] a;

        public e(String string, long l2, File[] arrfile, long[] arrl, a a3) {
            this.a = arrfile;
        }
    }

}

