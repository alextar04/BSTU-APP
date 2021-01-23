/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.List
 */
package c.c.a.m.u;

import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.e;
import c.c.a.m.u.g;
import c.c.a.m.u.h;
import c.c.a.m.v.n;
import java.io.File;
import java.util.List;

public class d
implements g,
d.a<Object> {
    public final List<m> e;
    public final h<?> f;
    public final g.a g;
    public int h;
    public m i;
    public List<n<File, ?>> j;
    public int k;
    public volatile n.a<?> l;
    public File m;

    public d(h<?> h2, g.a a2) {
        List<m> list = h2.a();
        this.h = -1;
        this.e = list;
        this.f = h2;
        this.g = a2;
    }

    public d(List<m> list, h<?> h2, g.a a2) {
        this.h = -1;
        this.e = list;
        this.f = h2;
        this.g = a2;
    }

    @Override
    public boolean a() {
        do {
            List<n<File, ?>> list;
            int n2;
            boolean bl;
            File file;
            if ((list = this.j) != null && (bl = this.k < list.size())) {
                boolean bl2;
                this.l = null;
                boolean bl3 = false;
                while (!bl3 && (bl2 = this.k < this.j.size())) {
                    List<n<File, ?>> list2 = this.j;
                    int n3 = this.k;
                    this.k = n3 + 1;
                    n n4 = (n)list2.get(n3);
                    File file2 = this.m;
                    h<?> h2 = this.f;
                    this.l = n4.a(file2, h2.e, h2.f, h2.i);
                    if (this.l == null || !this.f.g(this.l.c.a())) continue;
                    this.l.c.e(this.f.o, this);
                    bl3 = true;
                }
                return bl3;
            }
            this.h = n2 = 1 + this.h;
            if (n2 >= this.e.size()) {
                return false;
            }
            m m2 = (m)this.e.get(this.h);
            e e2 = new e(m2, this.f.n);
            this.m = file = this.f.b().b(e2);
            if (file == null) continue;
            this.i = m2;
            this.j = this.f.c.b.f(file);
            this.k = 0;
        } while (true);
    }

    @Override
    public void cancel() {
        n.a<?> a2 = this.l;
        if (a2 != null) {
            a2.c.cancel();
        }
    }

    @Override
    public void d(Exception exception) {
        this.g.d(this.i, exception, this.l.c, c.c.a.m.a.g);
    }

    @Override
    public void f(Object object) {
        this.g.c(this.i, object, this.l.c, c.c.a.m.a.g, this.i);
    }
}

