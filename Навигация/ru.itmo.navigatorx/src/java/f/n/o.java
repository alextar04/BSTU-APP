/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.g
 *  f.n.g$a
 *  f.n.g$b
 *  f.n.l
 *  f.n.m
 *  f.n.o$a
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package f.n;

import f.c.a.b.b;
import f.n.g;
import f.n.l;
import f.n.m;
import f.n.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Exception performing whole class analysis.
 */
public class o
extends g {
    public f.c.a.b.a<l, a> b;
    public g.b c;
    public final WeakReference<m> d;
    public int e;
    public boolean f;
    public boolean g;
    public ArrayList<g.b> h;

    public o(m m2) {
        this.b = new f.c.a.b.a();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList();
        this.d = new WeakReference((Object)m2);
        this.c = g.b.f;
    }

    public static g.b c(g.a a2) {
        block2 : {
            block3 : {
                block4 : {
                    int n2 = a2.ordinal();
                    if (n2 == 0) break block2;
                    if (n2 == 1) break block3;
                    if (n2 == 2) break block4;
                    if (n2 == 3) break block3;
                    if (n2 != 4) {
                        if (n2 == 5) {
                            return g.b.e;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected event value ");
                        stringBuilder.append((Object)a2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    break block2;
                }
                return g.b.i;
            }
            return g.b.h;
        }
        return g.b.g;
    }

    public static g.b e(g.b b2, g.b b3) {
        if (b3 != null && b3.compareTo((Enum)b2) < 0) {
            b2 = b3;
        }
        return b2;
    }

    public static g.a i(g.b b2) {
        int n2 = b2.ordinal();
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected state value ");
                        stringBuilder.append((Object)b2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    throw new IllegalArgumentException();
                }
                return g.a.ON_RESUME;
            }
            return g.a.ON_START;
        }
        return g.a.ON_CREATE;
    }

    public void a(l l2) {
        g.b b2 = this.c;
        g.b b3 = g.b.e;
        if (b2 != b3) {
            b3 = g.b.f;
        }
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        if (this.b.e(l2, a2) != null) {
            return;
        }
        m m2 = (m)this.d.get();
        if (m2 == null) {
            return;
        }
        boolean bl = this.e != 0 || this.f;
        g.b b4 = this.b(l2);
        this.e = 1 + this.e;
        while (a2.a.compareTo((Enum)b4) < 0 && this.b.i.containsKey((Object)l2)) {
            g.b b5 = a2.a;
            this.h.add((Object)b5);
            a2.a(m2, o.i(a2.a));
            this.g();
            b4 = this.b(l2);
        }
        if (!bl) {
            this.h();
        }
        --this.e;
    }

    public final g.b b(l l2) {
        f.c.a.b.a<l, a> a2 = this.b;
        b.c c2 = a2.i.containsKey((Object)l2) ? ((b.c)a2.i.get((Object)l2)).h : null;
        g.b b2 = c2 != null ? (c2.getValue()).a : null;
        boolean bl = this.h.isEmpty();
        g.b b3 = null;
        if (!bl) {
            ArrayList<g.b> arrayList = this.h;
            b3 = (g.b)arrayList.get(-1 + arrayList.size());
        }
        return o.e(o.e(this.c, b2), b3);
    }

    public void d(g.a a2) {
        this.f(o.c(a2));
    }

    public final void f(g.b b2) {
        if (this.c == b2) {
            return;
        }
        this.c = b2;
        if (!this.f && this.e == 0) {
            this.f = true;
            this.h();
            this.f = false;
            return;
        }
        this.g = true;
    }

    public final void g() {
        ArrayList<g.b> arrayList = this.h;
        arrayList.remove(-1 + arrayList.size());
    }

    /*
     * Exception decompiling
     */
    public final void h() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 4[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

