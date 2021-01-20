/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  j.e
 *  j.f
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package i.f0.h;

import i.f0.h.b;
import i.f0.h.c;
import i.f0.h.d;
import i.f0.h.e;
import i.f0.h.t;
import j.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class q
implements Closeable {
    public static final Logger k = Logger.getLogger((String)e.class.getName());
    public final f e;
    public final boolean f;
    public final j.e g;
    public int h;
    public boolean i;
    public final d.b j;

    public q(f f2, boolean bl) {
        j.e e2;
        this.e = f2;
        this.f = bl;
        this.g = e2 = new j.e();
        this.j = new d.b(e2);
        this.h = 16384;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(t t2) {
        q q2 = this;
        synchronized (q2) {
            int n2;
            if (this.i) {
                throw new IOException("closed");
            }
            int n3 = this.h;
            if ((32 & t2.a) != 0) {
                n3 = t2.b[5];
            }
            this.h = n3;
            int n4 = 2 & t2.a;
            int n5 = n4 != 0 ? t2.b[1] : n2;
            if (n5 != (n2 = -1)) {
                d.b b2 = this.j;
                if ((2 & t2.a) != 0) {
                    n2 = t2.b[1];
                }
                if (b2 == null) {
                    throw null;
                }
                int n6 = b2.e;
                int n7 = Math.min((int)n2, (int)16384);
                if (n6 != n7) {
                    if (n7 < n6) {
                        b2.c = Math.min((int)b2.c, (int)n7);
                    }
                    b2.d = true;
                    b2.e = n7;
                    int n8 = b2.i;
                    if (n7 < n8) {
                        if (n7 == 0) {
                            b2.a();
                        } else {
                            b2.b(n8 - n7);
                        }
                    }
                }
            }
            this.h(0, 0, (byte)4, (byte)1);
            this.e.flush();
            return;
        }
    }

    public void close() {
        q q2 = this;
        synchronized (q2) {
            this.i = true;
            this.e.close();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(boolean bl, int n2, j.e e2, int n3) {
        q q2 = this;
        synchronized (q2) {
            if (this.i) {
                throw new IOException("closed");
            }
            byte by = bl ? (byte)(true ? 1 : 0) : (byte)0;
            this.h(n2, n3, (byte)0, by);
            if (n3 > 0) {
                this.e.g(e2, n3);
            }
            return;
        }
    }

    public void flush() {
        q q2 = this;
        synchronized (q2) {
            if (!this.i) {
                this.e.flush();
                return;
            }
            throw new IOException("closed");
        }
    }

    public void h(int n2, int n3, byte by, byte by2) {
        int n4;
        if (k.isLoggable(Level.FINE)) {
            k.fine(e.a(false, n2, n3, by, by2));
        }
        if (n3 <= (n4 = this.h)) {
            if ((Integer.MIN_VALUE & n2) == 0) {
                f f2 = this.e;
                f2.D(255 & n3 >>> 16);
                f2.D(255 & n3 >>> 8);
                f2.D(n3 & 255);
                this.e.D(by & 255);
                this.e.D(by2 & 255);
                this.e.t(n2 & Integer.MAX_VALUE);
                return;
            }
            Object[] arrobject = new Object[]{n2};
            e.b("reserved bit set: %s", arrobject);
            throw null;
        }
        Object[] arrobject = new Object[]{n4, n3};
        e.b("FRAME_SIZE_ERROR length > %d: %d", arrobject);
        throw null;
    }

    public void j(int n2, b b2, byte[] arrby) {
        q q2 = this;
        synchronized (q2) {
            block6 : {
                if (this.i) break block6;
                if (b2.e != -1) {
                    this.h(0, 8 + arrby.length, (byte)7, (byte)0);
                    this.e.t(n2);
                    this.e.t(b2.e);
                    if (arrby.length > 0) {
                        this.e.e(arrby);
                    }
                    this.e.flush();
                    return;
                }
                e.b("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            throw new IOException("closed");
        }
    }

    public void m(boolean bl, int n2, List<c> list) {
        if (!this.i) {
            this.j.e(list);
            long l2 = this.g.f;
            int n3 = (int)Math.min((long)this.h, (long)l2);
            long l3 = n3;
            long l4 = l2 LCMP l3;
            byte by = l4 == false ? (byte)4 : 0;
            if (bl) {
                by = (byte)(by | 1);
            }
            this.h(n2, n3, (byte)1, by);
            this.e.g(this.g, l3);
            if (l4 > 0) {
                this.v(n2, l2 - l3);
            }
            return;
        }
        throw new IOException("closed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void p(boolean bl, int n2, int n3) {
        q q2 = this;
        synchronized (q2) {
            if (this.i) {
                throw new IOException("closed");
            }
            byte by = bl ? (byte)1 : 0;
            this.h(0, 8, (byte)6, by);
            this.e.t(n2);
            this.e.t(n3);
            this.e.flush();
            return;
        }
    }

    public void s(int n2, b b2) {
        q q2 = this;
        synchronized (q2) {
            if (!this.i) {
                if (b2.e != -1) {
                    this.h(n2, 4, (byte)3, (byte)0);
                    this.e.t(b2.e);
                    this.e.flush();
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IOException("closed");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(int n2, long l2) {
        q q2 = this;
        synchronized (q2) {
            if (this.i) {
                throw new IOException("closed");
            }
            if (l2 != 0L && l2 <= Integer.MAX_VALUE) {
                this.h(n2, 4, (byte)8, (byte)0);
                this.e.t((int)l2);
                this.e.flush();
                return;
            }
            Object[] arrobject = new Object[]{l2};
            e.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrobject);
            throw null;
        }
    }

    public final void v(int n2, long l2) {
        while (l2 > 0L) {
            long l3;
            int n3;
            byte by = (l2 -= (l3 = (long)(n3 = (int)Math.min((long)this.h, (long)l2)))) == 0L ? (byte)4 : 0;
            this.h(n2, n3, (byte)9, by);
            this.e.g(this.g, l3);
        }
    }
}

