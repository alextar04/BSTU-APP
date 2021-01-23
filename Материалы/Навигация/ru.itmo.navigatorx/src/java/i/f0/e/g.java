/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.e.c
 *  i.m$a
 *  i.u$a
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Deque
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.Set
 *  java.util.concurrent.Executor
 */
package i.f0.e;

import i.d0;
import i.e;
import i.f0.c;
import i.f0.e.d;
import i.f0.e.f;
import i.f0.h.b;
import i.h;
import i.m;
import i.n;
import i.r;
import i.u;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Executor;

public final class g {
    public final i.a a;
    public f.a b;
    public d0 c;
    public final h d;
    public final e e;
    public final n f;
    public final Object g;
    public final f h;
    public int i;
    public i.f0.e.c j;
    public boolean k;
    public boolean l;
    public boolean m;
    public i.f0.f.c n;

    public g(h h2, i.a a2, e e2, n n2, Object object) {
        this.d = h2;
        this.a = a2;
        this.e = e2;
        this.f = n2;
        if ((u.a)i.f0.a.a != null) {
            this.h = new f(a2, h2.e, e2, n2);
            this.g = object;
            return;
        }
        throw null;
    }

    public void a(i.f0.e.c c2, boolean bl) {
        if (this.j == null) {
            this.j = c2;
            this.k = bl;
            c2.n.add((Object)new a(this, this.g));
            return;
        }
        throw new IllegalStateException();
    }

    public i.f0.e.c b() {
        g g2 = this;
        synchronized (g2) {
            i.f0.e.c c2 = this.j;
            return c2;
        }
    }

    public final Socket c(boolean bl, boolean bl2, boolean bl3) {
        block6 : {
            i.f0.e.c c2;
            if (bl3) {
                this.n = null;
            }
            boolean bl4 = true;
            if (bl2) {
                this.l = bl4;
            }
            if ((c2 = this.j) == null) break block6;
            if (bl) {
                c2.k = bl4;
            }
            if (this.n != null || !this.l && !this.j.k) break block6;
            i.f0.e.c c3 = this.j;
            int n2 = c3.n.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                Socket socket;
                block10 : {
                    block7 : {
                        block8 : {
                            block9 : {
                                if (((Reference)c3.n.get(i2)).get() != this) continue;
                                c3.n.remove(i2);
                                if (!this.j.n.isEmpty()) break block7;
                                this.j.o = System.nanoTime();
                                i.f0.a a2 = i.f0.a.a;
                                h h2 = this.d;
                                i.f0.e.c c4 = this.j;
                                if ((u.a)a2 == null) break block8;
                                if (h2 == null) break block9;
                                if (!c4.k && h2.a != 0) {
                                    h2.notifyAll();
                                    bl4 = false;
                                } else {
                                    h2.d.remove((Object)c4);
                                }
                                if (!bl4) break block7;
                                socket = this.j.e;
                                break block10;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    socket = null;
                }
                this.j = null;
                return socket;
            }
            throw new IllegalStateException();
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final i.f0.e.c d(int n2, int n3, int n4, int n5, boolean bl) {
        i.f0.e.c c2;
        h h3;
        int n6;
        boolean bl2;
        i.f0.e.c c3;
        Socket socket;
        h h2;
        d0 d02;
        block44 : {
            int n7;
            block43 : {
                i.f0.e.c c4;
                f.a a2;
                Socket socket2;
                block42 : {
                    block41 : {
                        block39 : {
                            block40 : {
                                h h4;
                                h h5 = h4 = this.d;
                                // MONITORENTER : h5
                                if (this.l) throw new IllegalStateException("released");
                                if (this.n != null) throw new IllegalStateException("codec != null");
                                if (this.m) throw new IOException("Canceled");
                                i.f0.e.c c5 = this.j;
                                i.f0.e.c c6 = this.j;
                                n7 = 1;
                                socket2 = c6 != null && c6.k ? this.c(false, false, (boolean)n7) : null;
                                if (this.j != null) {
                                    c3 = this.j;
                                    c4 = null;
                                } else {
                                    c4 = c5;
                                    c3 = null;
                                }
                                if (!this.k) {
                                    c4 = null;
                                }
                                if (c3 != null) break block39;
                                i.f0.a.a.c(this.d, this.a, this, null);
                                if (this.j == null) break block40;
                                c3 = this.j;
                                n6 = n7;
                                break block41;
                            }
                            d02 = this.c;
                            n6 = 0;
                            break block42;
                        }
                        n6 = 0;
                    }
                    d02 = null;
                }
                // MONITOREXIT : h5
                c.g(socket2);
                if (c4 != null) {
                    if (this.f == null) throw null;
                }
                if (n6 != 0) {
                    if (this.f == null) throw null;
                }
                if (c3 != null) {
                    return c3;
                }
                if (!(d02 != null || (a2 = this.b) != null && a2.a())) break block43;
                bl2 = false;
                break block44;
            }
            f f2 = this.h;
            if (!f2.b()) throw new NoSuchElementException();
            ArrayList arrayList = new ArrayList();
            while (f2.c()) {
                int n8;
                Proxy proxy;
                block46 : {
                    String string;
                    int n9;
                    block45 : {
                        if (!f2.c()) {
                            StringBuilder stringBuilder = c.b.a.a.a.c("No route to ");
                            stringBuilder.append(f2.a.a.d);
                            stringBuilder.append("; exhausted proxy configurations: ");
                            stringBuilder.append(f2.e);
                            throw new SocketException(stringBuilder.toString());
                        }
                        List<Proxy> list = f2.e;
                        int n10 = f2.f;
                        f2.f = n10 + 1;
                        proxy = (Proxy)list.get(n10);
                        f2.g = new ArrayList();
                        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                            SocketAddress socketAddress = proxy.address();
                            if (!(socketAddress instanceof InetSocketAddress)) {
                                StringBuilder stringBuilder = c.b.a.a.a.c("Proxy.address() is not an InetSocketAddress: ");
                                stringBuilder.append((Object)socketAddress.getClass());
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
                            InetAddress inetAddress = inetSocketAddress.getAddress();
                            string = inetAddress == null ? inetSocketAddress.getHostName() : inetAddress.getHostAddress();
                            n9 = inetSocketAddress.getPort();
                        } else {
                            r r2 = f2.a.a;
                            string = r2.d;
                            n9 = r2.e;
                        }
                        if (n9 < n7 || n9 > 65535) break block45;
                        if (proxy.type() == Proxy.Type.SOCKS) {
                            f2.g.add((Object)InetSocketAddress.createUnresolved((String)string, (int)n9));
                        } else {
                            if (f2.d == null) throw null;
                            if ((m.a)f2.a.b == null) throw null;
                            if (string == null) throw new UnknownHostException("hostname == null");
                            List list2 = Arrays.asList((Object[])InetAddress.getAllByName((String)string));
                            if (list2.isEmpty()) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append((Object)f2.a.b);
                                stringBuilder.append(" returned no addresses for ");
                                stringBuilder.append(string);
                                throw new UnknownHostException(stringBuilder.toString());
                            }
                            if (f2.d == null) throw null;
                            int n11 = list2.size();
                            for (int i2 = 0; i2 < n11; ++i2) {
                                InetAddress inetAddress = (InetAddress)list2.get(i2);
                                f2.g.add((Object)new InetSocketAddress(inetAddress, n9));
                            }
                        }
                        n8 = f2.g.size();
                        break block46;
                        catch (NullPointerException nullPointerException) {
                            UnknownHostException unknownHostException = new UnknownHostException(c.b.a.a.a.j("Broken system behaviour for dns lookup of ", string));
                            unknownHostException.initCause((Throwable)nullPointerException);
                            throw unknownHostException;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No route to ");
                    stringBuilder.append(string);
                    stringBuilder.append(":");
                    stringBuilder.append(n9);
                    stringBuilder.append("; port is out of range");
                    throw new SocketException(stringBuilder.toString());
                }
                for (int i3 = 0; i3 < n8; ++i3) {
                    d d2;
                    d0 d03 = new d0(f2.a, proxy, (InetSocketAddress)f2.g.get(i3));
                    d d3 = d2 = f2.b;
                    // MONITORENTER : d3
                    boolean bl3 = d2.a.contains((Object)d03);
                    // MONITOREXIT : d3
                    if (bl3) {
                        f2.h.add((Object)d03);
                        continue;
                    }
                    arrayList.add((Object)d03);
                }
                if (!arrayList.isEmpty()) break;
                n7 = 1;
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(f2.h);
                f2.h.clear();
            }
            this.b = new f.a((List<d0>)arrayList);
            bl2 = true;
        }
        h h6 = h3 = this.d;
        // MONITORENTER : h6
        if (this.m) throw new IOException("Canceled");
        if (bl2) {
            f.a a3 = this.b;
            if (a3 == null) throw null;
            ArrayList arrayList = new ArrayList(a3.a);
            int n12 = arrayList.size();
            for (int i4 = 0; i4 < n12; ++i4) {
                d0 d04 = (d0)arrayList.get(i4);
                i.f0.a.a.c(this.d, this.a, this, d04);
                if (this.j == null) continue;
                c3 = this.j;
                this.c = d04;
                n6 = 1;
                break;
            }
        }
        if (n6 == 0) {
            if (d02 == null) {
                f.a a4 = this.b;
                if (!a4.a()) throw new NoSuchElementException();
                List<d0> list = a4.a;
                int n13 = a4.b;
                a4.b = n13 + 1;
                d02 = (d0)list.get(n13);
            }
            this.c = d02;
            this.i = 0;
            c3 = new i.f0.e.c(this.d, d02);
            this.a(c3, false);
        }
        // MONITOREXIT : h6
        if (n6 != 0) {
            if (this.f == null) throw null;
            return c3;
        }
        e e2 = this.e;
        n n14 = this.f;
        c3.c(n2, n3, n4, n5, bl, e2, n14);
        i.f0.a a5 = i.f0.a.a;
        h h7 = this.d;
        if ((u.a)a5 == null) throw null;
        h7.e.a(c3.c);
        h h8 = h2 = this.d;
        // MONITORENTER : h8
        this.k = true;
        i.f0.a a6 = i.f0.a.a;
        h h9 = this.d;
        if ((u.a)a6 == null) throw null;
        if (!h9.f) {
            h9.f = true;
            h.g.execute(h9.c);
        }
        h9.d.add((Object)c3);
        if (c3.h()) {
            socket = i.f0.a.a.b(this.d, this.a, this);
            c2 = this.j;
        } else {
            c2 = c3;
            socket = null;
        }
        // MONITOREXIT : h8
        c.g(socket);
        if (this.f == null) throw null;
        return c2;
    }

    /*
     * Exception decompiling
     */
    public final i.f0.e.c e(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        Socket socket;
        h h2;
        i.f0.e.c c2;
        h h3 = h2 = this.d;
        synchronized (h3) {
            c2 = this.j;
            socket = this.c(true, false, false);
            if (this.j != null) {
                c2 = null;
            }
        }
        c.g(socket);
        if (c2 == null) {
            return;
        }
        if (this.f != null) {
            return;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        Socket socket;
        h h2;
        i.f0.e.c c2;
        h h3 = h2 = this.d;
        synchronized (h3) {
            c2 = this.j;
            socket = this.c(false, true, false);
            if (this.j != null) {
                c2 = null;
            }
        }
        c.g(socket);
        if (c2 == null) {
            return;
        }
        i.f0.a.a.d(this.e, null);
        if (this.f != null) {
            return;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(IOException iOException) {
        h h2;
        i.f0.e.c c2;
        Socket socket;
        h h3 = h2 = this.d;
        synchronized (h3) {
            boolean bl;
            block15 : {
                block12 : {
                    block14 : {
                        block13 : {
                            block10 : {
                                b b2;
                                block11 : {
                                    int n2;
                                    if (!(iOException instanceof i.f0.h.u)) break block10;
                                    b2 = ((i.f0.h.u)iOException).e;
                                    if (b2 != b.j) break block11;
                                    this.i = n2 = 1 + this.i;
                                    if (n2 <= 1) break block12;
                                    break block13;
                                }
                                if (b2 == b.k) break block12;
                                break block13;
                            }
                            if (this.j == null || this.j.h() && !(iOException instanceof i.f0.h.a)) break block12;
                            if (this.j.l != 0) break block14;
                            if (this.c != null && iOException != null) {
                                this.h.a(this.c, iOException);
                            }
                        }
                        this.c = null;
                    }
                    bl = true;
                    break block15;
                }
                bl = false;
            }
            c2 = this.j;
            socket = this.c(bl, false, true);
            if (this.j != null || !this.k) {
                c2 = null;
            }
        }
        c.g(socket);
        if (c2 == null) {
            return;
        }
        if (this.f != null) {
            return;
        }
        throw null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i(boolean bl, i.f0.f.c c2, long l2, IOException iOException) {
        h h2;
        if (this.f == null) {
            throw null;
        }
        h h3 = h2 = this.d;
        synchronized (h3) {
            if (c2 != null && c2 == this.n) {
                if (!bl) {
                    i.f0.e.c c3 = this.j;
                    c3.l = 1 + c3.l;
                }
                i.f0.e.c c4 = this.j;
                Socket socket = this.c(bl, false, true);
                if (this.j != null) {
                    c4 = null;
                }
                boolean bl2 = this.l;
                // MONITOREXIT [2, 10] lbl14 : w: MONITOREXIT : var19_6
                c.g(socket);
                if (c4 != null && this.f == null) {
                    throw null;
                }
                if (iOException != null) {
                    i.f0.a.a.d(this.e, iOException);
                    if (this.f != null) {
                        return;
                    }
                    throw null;
                }
                if (!bl2) {
                    return;
                }
                i.f0.a.a.d(this.e, null);
                if (this.f != null) {
                    return;
                }
                throw null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append((Object)this.n);
            stringBuilder.append(" but was ");
            stringBuilder.append((Object)c2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public String toString() {
        i.f0.e.c c2 = this.b();
        if (c2 != null) {
            return c2.toString();
        }
        return this.a.toString();
    }

    public static final class a
    extends WeakReference<g> {
        public final Object a;

        public a(g g2, Object object) {
            super((Object)g2);
            this.a = object;
        }
    }

}

