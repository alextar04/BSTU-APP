/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.m.u;

import c.c.a.m.m;
import c.c.a.m.u.w;
import f.b.k.h;

public class q<Z>
implements w<Z> {
    public final boolean e;
    public final boolean f;
    public final w<Z> g;
    public final a h;
    public final m i;
    public int j;
    public boolean k;

    public q(w<Z> w2, boolean bl, boolean bl2, m m2, a a2) {
        h.i.p(w2, "Argument must not be null");
        this.g = w2;
        this.e = bl;
        this.f = bl2;
        this.i = m2;
        h.i.p(a2, "Argument must not be null");
        this.h = a2;
    }

    public void a() {
        q q2 = this;
        synchronized (q2) {
            if (!this.k) {
                this.j = 1 + this.j;
                return;
            }
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override
    public Z b() {
        return this.g.b();
    }

    @Override
    public int c() {
        return this.g.c();
    }

    @Override
    public Class<Z> d() {
        return this.g.d();
    }

    @Override
    public void e() {
        q q2 = this;
        synchronized (q2) {
            if (this.j <= 0) {
                if (!this.k) {
                    this.k = true;
                    if (this.f) {
                        this.g.e();
                    }
                    return;
                }
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        int n2;
        q q2 = this;
        synchronized (q2) {
            int n3;
            if (this.j <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            int n4 = this.j;
            n2 = 1;
            this.j = n3 = n4 - n2;
            if (n3 != 0) {
                return;
            }
        }
        if (n2 == 0) return;
        this.h.a(this.i, this);
    }

    public String toString() {
        q q2 = this;
        synchronized (q2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EngineResource{isMemoryCacheable=");
            stringBuilder.append(this.e);
            stringBuilder.append(", listener=");
            stringBuilder.append((Object)this.h);
            stringBuilder.append(", key=");
            stringBuilder.append((Object)this.i);
            stringBuilder.append(", acquired=");
            stringBuilder.append(this.j);
            stringBuilder.append(", isRecycled=");
            stringBuilder.append(this.k);
            stringBuilder.append(", resource=");
            stringBuilder.append(this.g);
            stringBuilder.append('}');
            String string = stringBuilder.toString();
            return string;
        }
    }

}

