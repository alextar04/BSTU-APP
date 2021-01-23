/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package i;

import i.c0;
import i.d;
import i.p;
import i.q;
import i.r;
import i.v;
import i.x;
import java.io.Closeable;
import java.util.List;

public final class a0
implements Closeable {
    public final x e;
    public final v f;
    public final int g;
    public final String h;
    public final p i;
    public final q j;
    public final c0 k;
    public final a0 l;
    public final a0 m;
    public final a0 n;
    public final long o;
    public final long p;
    public volatile d q;

    public a0(a a2) {
        this.e = a2.a;
        this.f = a2.b;
        this.g = a2.c;
        this.h = a2.d;
        this.i = a2.e;
        q.a a3 = a2.f;
        if (a3 != null) {
            this.j = new q(a3);
            this.k = a2.g;
            this.l = a2.h;
            this.m = a2.i;
            this.n = a2.j;
            this.o = a2.k;
            this.p = a2.l;
            return;
        }
        throw null;
    }

    public d c() {
        d d2;
        d d3 = this.q;
        if (d3 != null) {
            return d3;
        }
        this.q = d2 = d.a(this.j);
        return d2;
    }

    public void close() {
        c0 c02 = this.k;
        if (c02 != null) {
            c02.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Response{protocol=");
        stringBuilder.append((Object)this.f);
        stringBuilder.append(", code=");
        stringBuilder.append(this.g);
        stringBuilder.append(", message=");
        stringBuilder.append(this.h);
        stringBuilder.append(", url=");
        stringBuilder.append((Object)this.e.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        public x a;
        public v b;
        public int c = -1;
        public String d;
        public p e;
        public q.a f;
        public c0 g;
        public a0 h;
        public a0 i;
        public a0 j;
        public long k;
        public long l;

        public a() {
            this.f = new q.a();
        }

        public a(a0 a02) {
            this.a = a02.e;
            this.b = a02.f;
            this.c = a02.g;
            this.d = a02.h;
            this.e = a02.i;
            this.f = a02.j.e();
            this.g = a02.k;
            this.h = a02.l;
            this.i = a02.m;
            this.j = a02.n;
            this.k = a02.o;
            this.l = a02.p;
        }

        public a a(String string, String string2) {
            q.a a2 = this.f;
            if (a2 != null) {
                q.a(string);
                q.b(string2, string);
                a2.a.add((Object)string);
                a2.a.add((Object)string2.trim());
                return this;
            }
            throw null;
        }

        public a0 b() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.d != null) {
                            return new a0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c("code < 0: ");
                    stringBuilder.append(this.c);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public a c(a0 a02) {
            if (a02 != null) {
                this.d("cacheResponse", a02);
            }
            this.i = a02;
            return this;
        }

        public final void d(String string, a0 a02) {
            if (a02.k == null) {
                if (a02.l == null) {
                    if (a02.m == null) {
                        if (a02.n == null) {
                            return;
                        }
                        throw new IllegalArgumentException(c.b.a.a.a.j(string, ".priorResponse != null"));
                    }
                    throw new IllegalArgumentException(c.b.a.a.a.j(string, ".cacheResponse != null"));
                }
                throw new IllegalArgumentException(c.b.a.a.a.j(string, ".networkResponse != null"));
            }
            throw new IllegalArgumentException(c.b.a.a.a.j(string, ".body != null"));
        }

        public a e(q q2) {
            this.f = q2.e();
            return this;
        }
    }

}

