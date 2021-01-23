/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  i.f0.h.p$a
 *  i.f0.h.p$b
 *  i.f0.h.p$c
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayDeque
 *  java.util.Deque
 */
package i.f0.h;

import i.f0.h.c;
import i.f0.h.g;
import i.f0.h.p;
import i.f0.h.q;
import i.f0.h.t;
import i.f0.h.u;
import j.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Exception performing whole class analysis.
 */
public final class p {
    public long a;
    public long b;
    public final int c;
    public final g d;
    public final Deque<i.q> e;
    public c.a f;
    public boolean g;
    public final b h;
    public final a i;
    public final c j;
    public final c k;
    public i.f0.h.b l;

    public p(int n2, g g2, boolean bl, boolean bl2, i.q q2) {
        this.a = 0L;
        this.e = new ArrayDeque();
        this.j = new /* Unavailable Anonymous Inner Class!! */;
        this.k = new /* Unavailable Anonymous Inner Class!! */;
        this.l = null;
        if (g2 != null) {
            a a2;
            this.c = n2;
            this.d = g2;
            this.b = g2.s.a();
            this.h = new /* Unavailable Anonymous Inner Class!! */;
            this.i = a2 = new /* Unavailable Anonymous Inner Class!! */;
            this.h.i = bl2;
            a2.g = bl;
            if (q2 != null) {
                this.e.add((Object)q2);
            }
            if (this.g() && q2 != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            if (!this.g()) {
                if (q2 != null) {
                    return;
                }
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
            return;
        }
        throw new NullPointerException("connection == null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a() {
        p p2 = this;
        // MONITORENTER : p2
        boolean bl = !this.h.i && this.h.h && (this.i.g || this.i.f);
        boolean bl2 = this.h();
        // MONITOREXIT : p2
        if (bl) {
            this.c(i.f0.h.b.k);
            return;
        }
        if (bl2) return;
        this.d.s(this.c);
    }

    public void b() {
        a a2 = this.i;
        if (!a2.f) {
            if (!a2.g) {
                if (this.l == null) {
                    return;
                }
                throw new u(this.l);
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void c(i.f0.h.b b2) {
        if (!this.d(b2)) {
            return;
        }
        g g2 = this.d;
        int n2 = this.c;
        g2.v.s(n2, b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean d(i.f0.h.b b2) {
        p p2 = this;
        synchronized (p2) {
            if (this.l != null) {
                return false;
            }
            if (this.h.i && this.i.g) {
                return false;
            }
            this.l = b2;
            this.notifyAll();
        }
        this.d.s(this.c);
        return true;
    }

    public void e(i.f0.h.b b2) {
        if (!this.d(b2)) {
            return;
        }
        this.d.B(this.c, b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public v f() {
        p p2 = this;
        synchronized (p2) {
            if (!this.g && !this.g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.i;
        }
    }

    public boolean g() {
        boolean bl = (1 & this.c) == 1;
        return this.d.e == bl;
    }

    public boolean h() {
        p p2 = this;
        synchronized (p2) {
            block5 : {
                boolean bl;
                block4 : {
                    i.f0.h.b b2 = this.l;
                    if (b2 == null) break block4;
                    return false;
                }
                if (!this.h.i && !this.h.h || !this.i.g && !this.i.f || !(bl = this.g)) break block5;
                return false;
            }
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void i() {
        p p2 = this;
        // MONITORENTER : p2
        this.h.i = true;
        boolean bl = this.h();
        this.notifyAll();
        // MONITOREXIT : p2
        if (bl) return;
        this.d.s(this.c);
    }

    public void j() {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}

