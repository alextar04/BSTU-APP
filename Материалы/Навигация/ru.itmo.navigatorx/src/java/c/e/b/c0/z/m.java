/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.z.m;
import c.e.b.e0.c;
import c.e.b.e0.d;
import c.e.b.j;
import c.e.b.n;
import c.e.b.o;
import c.e.b.p;
import c.e.b.q;
import c.e.b.u;
import c.e.b.v;
import c.e.b.w;
import c.e.b.z;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Type;

public final class m<T>
extends z<T> {
    public final v<T> a;
    public final n<T> b;
    public final j c;
    public final c.e.b.d0.a<T> d;
    public final a0 e;
    public final m<T> f = new b(this, null);
    public z<T> g;

    public m(v<T> v2, n<T> n2, j j2, c.e.b.d0.a<T> a2, a0 a02) {
        this.a = v2;
        this.b = n2;
        this.c = j2;
        this.d = a2;
        this.e = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public T a(c.e.b.e0.a a2) {
        o o2;
        block10 : {
            boolean bl;
            if (this.b == null) {
                z<T> z2 = this.g;
                if (z2 != null) {
                    return z2.a(a2);
                }
                z2 = this.c.c(this.e, this.d);
                this.g = z2;
                return z2.a(a2);
            }
            try {
                try {
                    a2.T();
                }
                catch (EOFException eOFException) {
                    bl = true;
                }
                try {
                    o2 = c.e.b.c0.z.o.X.a(a2);
                    break block10;
                }
                catch (EOFException eOFException) {
                    bl = false;
                }
            }
            catch (NumberFormatException numberFormatException) {
                throw new w(numberFormatException);
            }
            catch (IOException iOException) {
                throw new p(iOException);
            }
            catch (d d2) {
                throw new w((Throwable)d2);
            }
            if (!bl) void var2_6;
            throw new w((Throwable)var2_6);
            o2 = q.a;
        }
        if (o2 == null) throw null;
        if (!(o2 instanceof q)) return this.b.a(o2, this.d.b, (c.e.b.m)((Object)this.f));
        return null;
    }

    @Override
    public void b(c c2, T t2) {
        v<T> v2 = this.a;
        if (v2 == null) {
            z<T> z2 = this.g;
            if (z2 == null) {
                z2 = this.c.c(this.e, this.d);
                this.g = z2;
            }
            z2.b(c2, t2);
            return;
        }
        if (t2 == null) {
            c2.u();
            return;
        }
        o o2 = v2.a(t2, this.d.b, (u)((Object)this.f));
        c.e.b.c0.z.o.X.b(c2, o2);
    }

    public final class b
    implements u,
    c.e.b.m {
        public b(m m2, a a2) {
        }
    }

}

