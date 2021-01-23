/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.h.g$e
 *  i.f0.h.g$f
 *  i.f0.h.h
 *  i.f0.h.k
 *  i.f0.h.m
 *  i.f0.h.n
 *  i.f0.h.o$a
 *  j.g
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package i.f0.h;

import i.f0.c;
import i.f0.h.d;
import i.f0.h.e;
import i.f0.h.g;
import i.f0.h.h;
import i.f0.h.k;
import i.f0.h.m;
import i.f0.h.n;
import i.f0.h.o;
import i.f0.h.p;
import i.f0.h.t;
import j.w;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Exception performing whole class analysis.
 */
public final class o
implements Closeable {
    public static final Logger i;
    public final j.g e;
    public final a f;
    public final boolean g;
    public final d.a h;

    public static {
        i = Logger.getLogger((String)e.class.getName());
    }

    public o(j.g g2, boolean bl) {
        a a2;
        this.e = g2;
        this.g = bl;
        this.f = a2 = new /* Unavailable Anonymous Inner Class!! */;
        this.h = new d.a(4096, (w)a2);
    }

    public static int c(int n2, byte by, short s2) {
        if ((by & 8) != 0) {
            --n2;
        }
        if (s2 <= n2) {
            return (short)(n2 - s2);
        }
        Object[] arrobject = new Object[]{s2, n2};
        e.c("PROTOCOL_ERROR padding %s > remaining length %s", arrobject);
        throw null;
    }

    public static int p(j.g g2) {
        return (255 & g2.readByte()) << 16 | (255 & g2.readByte()) << 8 | 255 & g2.readByte();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void B(b b2, int n2, byte by, int n3) {
        int n4;
        g.f f2;
        p[] arrp;
        long l2;
        block31 : {
            g g2;
            n4 = 0;
            if (n3 != 0) {
                e.c("TYPE_SETTINGS streamId != 0", new Object[0]);
                throw null;
            }
            if ((by & 1) != 0) {
                if (n2 == 0) {
                    if (b2 == null) throw null;
                    return;
                }
                e.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
            if (n2 % 6 != 0) {
                Object[] arrobject = new Object[]{n2};
                e.c("TYPE_SETTINGS length %% 6 != 0: %s", arrobject);
                throw null;
            }
            t t2 = new t();
            for (int i2 = 0; i2 < n2; i2 += 6) {
                int n5 = 65535 & this.e.readShort();
                int n6 = this.e.readInt();
                if (n5 != 2) {
                    if (n5 != 3) {
                        if (n5 != 4) {
                            if (n5 == 5 && (n6 < 16384 || n6 > 16777215)) {
                                Object[] arrobject = new Object[]{n6};
                                e.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", arrobject);
                                throw null;
                            }
                        } else {
                            n5 = 7;
                            if (n6 < 0) {
                                e.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                throw null;
                            }
                        }
                    } else {
                        n5 = 4;
                    }
                } else if (n6 != 0 && n6 != 1) {
                    e.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                t2.b(n5, n6);
            }
            f2 = b2;
            g g3 = g2 = f2.g;
            // MONITORENTER : g3
            int n7 = f2.g.s.a();
            t t3 = f2.g.s;
            if (t3 == null) throw null;
            int n8 = 0;
            do {
                block32 : {
                    if (n8 >= 10) break block32;
                }
                try {
                    ScheduledExecutorService scheduledExecutorService = f2.g.l;
                    Object[] arrobject = new Object[]{f2.g.h};
                    scheduledExecutorService.execute((Runnable)new n(f2, "OkHttp %s ACK Settings", arrobject, t2));
                }
                catch (RejectedExecutionException rejectedExecutionException) {}
                int n9 = f2.g.s.a();
                if (n9 == -1 || n9 == n7) break;
                l2 = n9 - n7;
                if (!f2.g.t) {
                    f2.g.t = true;
                }
                boolean bl = f2.g.g.isEmpty();
                arrp = null;
                if (!bl) {
                    arrp = (p[])f2.g.g.values().toArray((Object[])new p[f2.g.g.size()]);
                }
                break block31;
                boolean bl2 = (1 << n8 & t2.a) != 0;
                if (bl2) {
                    t3.b(n8, t2.b[n8]);
                }
                ++n8;
            } while (true);
            l2 = 0L;
            arrp = null;
        }
        ExecutorService executorService = g.y;
        Object[] arrobject = new Object[]{f2.g.h};
        executorService.execute((Runnable)new m(f2, "OkHttp %s settings", arrobject));
        // MONITOREXIT : g3
        if (arrp == null) return;
        long l3 = l2 LCMP 0L;
        if (l3 == false) return;
        int n10 = arrp.length;
        while (n4 < n10) {
            p p2;
            p p3 = p2 = arrp[n4];
            // MONITORENTER : p3
            p2.b = l2 + p2.b;
            if (l3 > 0) {
                p2.notifyAll();
            }
            // MONITOREXIT : p3
            ++n4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void J(b b2, int n2, int n3) {
        if (n2 != 4) {
            Object[] arrobject = new Object[]{n2};
            e.c("TYPE_WINDOW_UPDATE length !=4: %s", arrobject);
            throw null;
        }
        long l2 = Integer.MAX_VALUE & (long)this.e.readInt();
        long l3 = l2 LCMP 0L;
        if (l3 == false) {
            Object[] arrobject = new Object[]{l2};
            e.c("windowSizeIncrement was 0", arrobject);
            throw null;
        }
        g.f f2 = b2;
        g g2 = f2.g;
        if (n3 == 0) {
            g g3 = g2;
            synchronized (g3) {
                g g4 = f2.g;
                g4.q = l2 + g4.q;
                f2.g.notifyAll();
                return;
            }
        }
        p p2 = g2.h(n3);
        if (p2 == null) {
            return;
        }
        p p3 = p2;
        synchronized (p3) {
            p2.b = l2 + p2.b;
            if (l3 > 0) {
                p2.notifyAll();
            }
            return;
        }
    }

    public void close() {
        this.e.close();
    }

    /*
     * Exception decompiling
     */
    public boolean f(boolean var1, b var2) {
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

    public void h(b b2) {
        if (this.g) {
            if (this.f(true, b2)) {
                return;
            }
            e.c("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        j.h h2 = this.e.o((long)e.a.k());
        if (i.isLoggable(Level.FINE)) {
            Logger logger = i;
            Object[] arrobject = new Object[]{h2.g()};
            logger.fine(c.n("<< CONNECTION %s", arrobject));
        }
        if (e.a.equals(h2)) {
            return;
        }
        Object[] arrobject = new Object[]{h2.o()};
        e.c("Expected a connection header but was %s", arrobject);
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j(b b2, int n2, int n3) {
        g.f f2;
        p[] arrp;
        g g2;
        int n4 = 0;
        if (n2 < 8) {
            Object[] arrobject = new Object[]{n2};
            e.c("TYPE_GOAWAY length < 8: %s", arrobject);
            throw null;
        }
        if (n3 != 0) {
            e.c("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int n5 = this.e.readInt();
        int n6 = this.e.readInt();
        int n7 = n2 - 8;
        if (i.f0.h.b.a(n6) == null) {
            Object[] arrobject = new Object[]{n6};
            e.c("TYPE_GOAWAY unexpected error code: %d", arrobject);
            throw null;
        }
        j.h h2 = j.h.i;
        if (n7 > 0) {
            h2 = this.e.o((long)n7);
        }
        if ((f2 = b2) == null) {
            throw null;
        }
        h2.k();
        g g3 = g2 = f2.g;
        synchronized (g3) {
            arrp = (p[])f2.g.g.values().toArray((Object[])new p[f2.g.g.size()]);
            f2.g.k = true;
        }
        int n8 = arrp.length;
        while (n4 < n8) {
            p p2 = arrp[n4];
            if (p2.c > n5 && p2.g()) {
                i.f0.h.b b3 = i.f0.h.b.j;
                p p3 = p2;
                synchronized (p3) {
                    if (p2.l == null) {
                        p2.l = b3;
                        p2.notifyAll();
                    }
                }
                f2.g.s(p2.c);
            }
            ++n4;
        }
        return;
    }

    public final List<i.f0.h.c> m(int n2, short s2, byte by, int n3) {
        a a2 = this.f;
        a2.i = n2;
        a2.f = n2;
        a2.j = s2;
        a2.g = by;
        a2.h = n3;
        d.a a3 = this.h;
        while (!a3.b.C()) {
            int n4 = 255 & a3.b.readByte();
            if (n4 != 128) {
                if ((n4 & 128) == 128) {
                    i.f0.h.c[] arrc;
                    int n5 = a3.g(n4, 127) - 1;
                    boolean bl = n5 >= 0 && n5 <= d.a.length - 1;
                    if (bl) {
                        i.f0.h.c c2 = d.a[n5];
                        a3.a.add((Object)c2);
                        continue;
                    }
                    int n6 = a3.b(n5 - d.a.length);
                    if (n6 >= 0 && n6 < (arrc = a3.e).length) {
                        a3.a.add((Object)arrc[n6]);
                        continue;
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c("Header index too large ");
                    stringBuilder.append(n5 + 1);
                    throw new IOException(stringBuilder.toString());
                }
                if (n4 == 64) {
                    j.h h2 = a3.f();
                    d.a(h2);
                    a3.e(-1, new i.f0.h.c(h2, a3.f()));
                    continue;
                }
                if ((n4 & 64) == 64) {
                    a3.e(-1, new i.f0.h.c(a3.d(a3.g(n4, 63) - 1), a3.f()));
                    continue;
                }
                if ((n4 & 32) == 32) {
                    int n7;
                    a3.d = n7 = a3.g(n4, 31);
                    if (n7 >= 0 && n7 <= a3.c) {
                        int n8 = a3.h;
                        if (n7 >= n8) continue;
                        if (n7 == 0) {
                            a3.a();
                            continue;
                        }
                        a3.c(n8 - n7);
                        continue;
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c("Invalid dynamic table size update ");
                    stringBuilder.append(a3.d);
                    throw new IOException(stringBuilder.toString());
                }
                if (n4 != 16 && n4 != 0) {
                    j.h h3 = a3.d(a3.g(n4, 15) - 1);
                    j.h h4 = a3.f();
                    a3.a.add((Object)new i.f0.h.c(h3, h4));
                    continue;
                }
                j.h h5 = a3.f();
                d.a(h5);
                j.h h6 = a3.f();
                a3.a.add((Object)new i.f0.h.c(h5, h6));
                continue;
            }
            throw new IOException("index == 0");
        }
        d.a a4 = this.h;
        if (a4 != null) {
            ArrayList arrayList = new ArrayList(a4.a);
            a4.a.clear();
            return arrayList;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void s(b b2, int n2, byte by, int n3) {
        if (n2 != 8) {
            Object[] arrobject = new Object[]{n2};
            e.c("TYPE_PING length != 8: %s", arrobject);
            throw null;
        }
        if (n3 != 0) {
            e.c("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int n4 = this.e.readInt();
        int n5 = this.e.readInt();
        boolean bl = (by & 1) != 0;
        g.f f2 = b2;
        if (f2 == null) throw null;
        if (bl) {
            g g2;
            g g3 = g2 = f2.g;
            synchronized (g3) {
                f2.g.o = false;
                f2.g.notifyAll();
                return;
            }
        }
        try {
            f2.g.l.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {}
    }

    public final void u(b b2, int n2) {
        Integer.MIN_VALUE & this.e.readInt();
        this.e.readByte();
        if (b2 != null) {
            return;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void v(b b2, int n2, byte by, int n3) {
        g g2;
        if (n3 == 0) {
            e.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s2 = (by & 8) != 0 ? (short)(255 & this.e.readByte()) : (short)0;
        int n4 = Integer.MAX_VALUE & this.e.readInt();
        List<i.f0.h.c> list = this.m(o.c(n2 - 4, by, s2), s2, by, n3);
        g g3 = g2 = (b2).g;
        synchronized (g3) {
            if (g2.x.contains((Object)n4)) {
                g2.B(n4, i.f0.h.b.g);
                return;
            }
            g2.x.add((Object)n4);
        }
        try {
            Object[] arrobject = new Object[]{g2.h, n4};
            h h2 = new h(g2, "OkHttp %s Push Request[%s]", arrobject, n4, list);
            g2.m((i.f0.b)h2);
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {}
    }

    public final void x(b b2, int n2, int n3) {
        if (n2 == 4) {
            if (n3 != 0) {
                int n4 = this.e.readInt();
                i.f0.h.b b3 = i.f0.h.b.a(n4);
                if (b3 != null) {
                    g.f f2 = b2;
                    boolean bl = f2.g.p(n3);
                    g g2 = f2.g;
                    if (bl) {
                        Object[] arrobject = new Object[]{g2.h, n3};
                        k k2 = new k(g2, "OkHttp %s Push Reset[%s]", arrobject, n3, b3);
                        g2.m((i.f0.b)k2);
                        return;
                    }
                    p p2 = g2.s(n3);
                    if (p2 != null) {
                        p p3 = p2;
                        synchronized (p3) {
                            if (p2.l == null) {
                                p2.l = b3;
                                p2.notifyAll();
                            }
                            return;
                        }
                    }
                    return;
                }
                Object[] arrobject = new Object[]{n4};
                e.c("TYPE_RST_STREAM unexpected error code: %d", arrobject);
                throw null;
            }
            e.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        Object[] arrobject = new Object[]{n2};
        e.c("TYPE_RST_STREAM length: %d != 4", arrobject);
        throw null;
    }

    public static interface b {
    }

}

