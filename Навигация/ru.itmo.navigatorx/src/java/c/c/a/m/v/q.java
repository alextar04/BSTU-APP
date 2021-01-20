/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package c.c.a.m.v;

import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.u.r;
import c.c.a.m.v.n;
import f.b.k.h;
import f.h.k.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class q<Model, Data>
implements n<Model, Data> {
    public final List<n<Model, Data>> a;
    public final c<List<Throwable>> b;

    public q(List<n<Model, Data>> list, c<List<Throwable>> c2) {
        this.a = list;
        this.b = c2;
    }

    @Override
    public n.a<Data> a(Model Model, int n2, int n3, o o2) {
        int n4 = this.a.size();
        ArrayList arrayList = new ArrayList(n4);
        m m2 = null;
        for (int i2 = 0; i2 < n4; ++i2) {
            n.a a2;
            n n5 = (n)this.a.get(i2);
            if (!n5.b(Model) || (a2 = n5.a(Model, n2, n3, o2)) == null) continue;
            m2 = a2.a;
            arrayList.add(a2.c);
        }
        boolean bl = arrayList.isEmpty();
        n.a a3 = null;
        if (!bl) {
            a3 = null;
            if (m2 != null) {
                a3 = new n.a(m2, new a(arrayList, this.b));
            }
        }
        return a3;
    }

    @Override
    public boolean b(Model Model) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (!((n)iterator.next()).b(Model)) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("MultiModelLoader{modelLoaders=");
        stringBuilder.append(Arrays.toString((Object[])this.a.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a<Data>
    implements d<Data>,
    d.a<Data> {
        public final List<d<Data>> e;
        public final c<List<Throwable>> f;
        public int g;
        public e h;
        public d.a<? super Data> i;
        public List<Throwable> j;
        public boolean k;

        public a(List<d<Data>> list, c<List<Throwable>> c2) {
            this.f = c2;
            if (!list.isEmpty()) {
                this.e = list;
                this.g = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        @Override
        public Class<Data> a() {
            return ((d)this.e.get(0)).a();
        }

        @Override
        public void b() {
            List<Throwable> list = this.j;
            if (list != null) {
                this.f.a(list);
            }
            this.j = null;
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                ((d)iterator.next()).b();
            }
        }

        @Override
        public c.c.a.m.a c() {
            return ((d)this.e.get(0)).c();
        }

        @Override
        public void cancel() {
            this.k = true;
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                ((d)iterator.next()).cancel();
            }
        }

        @Override
        public void d(Exception exception) {
            List<Throwable> list = this.j;
            h.i.p(list, "Argument must not be null");
            list.add((Object)exception);
            this.g();
        }

        @Override
        public void e(e e2, d.a<? super Data> a2) {
            this.h = e2;
            this.i = a2;
            this.j = this.f.b();
            ((d)this.e.get(this.g)).e(e2, this);
            if (this.k) {
                this.cancel();
            }
        }

        @Override
        public void f(Data Data) {
            if (Data != null) {
                this.i.f(Data);
                return;
            }
            this.g();
        }

        public final void g() {
            if (this.k) {
                return;
            }
            if (this.g < -1 + this.e.size()) {
                this.g = 1 + this.g;
                this.e(this.h, this.i);
                return;
            }
            h.i.p(this.j, "Argument must not be null");
            this.i.d(new r("Fetch failed", (List<Throwable>)new ArrayList(this.j)));
        }
    }

}

