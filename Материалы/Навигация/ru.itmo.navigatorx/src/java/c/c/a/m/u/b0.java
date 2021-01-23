/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Collections
 *  java.util.List
 */
package c.c.a.m.u;

import android.util.Log;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.u.a0;
import c.c.a.m.u.d;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.e;
import c.c.a.m.u.f;
import c.c.a.m.u.g;
import c.c.a.m.u.h;
import c.c.a.m.u.k;
import c.c.a.m.v.n;
import java.util.Collections;
import java.util.List;

public class b0
implements g,
g.a {
    public final h<?> e;
    public final g.a f;
    public int g;
    public d h;
    public Object i;
    public volatile n.a<?> j;
    public e k;

    public b0(h<?> h2, g.a a2) {
        this.e = h2;
        this.f = a2;
    }

    @Override
    public boolean a() {
        d d2;
        boolean bl;
        Object object = this.i;
        if (object != null) {
            this.i = null;
            long l2 = c.c.a.s.f.b();
            try {
                c.c.a.m.d<Object> d3 = this.e.e(object);
                f<Object> f2 = new f<Object>(d3, object, this.e.i);
                this.k = new e(this.j.a, this.e.n);
                this.e.b().a(this.k, f2);
                if (Log.isLoggable((String)"SourceGenerator", (int)2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Finished encoding source to cache, key: ");
                    stringBuilder.append((Object)this.k);
                    stringBuilder.append(", data: ");
                    stringBuilder.append(object);
                    stringBuilder.append(", encoder: ");
                    stringBuilder.append(d3);
                    stringBuilder.append(", duration: ");
                    stringBuilder.append(c.c.a.s.f.a(l2));
                    Log.v((String)"SourceGenerator", (String)stringBuilder.toString());
                }
                this.h = new d((List<m>)Collections.singletonList((Object)this.j.a), this.e, this);
            }
            finally {
                this.j.c.b();
            }
        }
        if ((d2 = this.h) != null && d2.a()) {
            return true;
        }
        this.h = null;
        this.j = null;
        boolean bl2 = false;
        while (!bl2 && (bl = this.g < this.e.c().size())) {
            List<n.a<?>> list = this.e.c();
            int n2 = this.g;
            this.g = n2 + 1;
            this.j = (n.a)list.get(n2);
            if (this.j == null || !this.e.p.c(this.j.c.c()) && !this.e.g(this.j.c.a())) continue;
            n.a<?> a2 = this.j;
            this.j.c.e(this.e.o, new a0(this, a2));
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public void b() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void c(m m2, Object object, c.c.a.m.t.d<?> d2, c.c.a.m.a a2, m m3) {
        this.f.c(m2, object, d2, this.j.c.c(), m2);
    }

    @Override
    public void cancel() {
        n.a<?> a2 = this.j;
        if (a2 != null) {
            a2.c.cancel();
        }
    }

    @Override
    public void d(m m2, Exception exception, c.c.a.m.t.d<?> d2, c.c.a.m.a a2) {
        this.f.d(m2, exception, d2, this.j.c.c());
    }
}

