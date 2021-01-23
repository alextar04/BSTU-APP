/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicReference
 */
package c.c.a.m.u;

import c.c.a.d;
import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.s;
import c.c.a.m.t.d;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.g;
import c.c.a.m.u.h;
import c.c.a.m.u.y;
import c.c.a.m.v.n;
import c.c.a.m.v.p;
import c.c.a.m.v.r;
import c.c.a.m.w.h.f;
import c.c.a.s.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class x
implements g,
d.a<Object> {
    public final g.a e;
    public final h<?> f;
    public int g;
    public int h = -1;
    public m i;
    public List<n<File, ?>> j;
    public int k;
    public volatile n.a<?> l;
    public File m;
    public y n;

    public x(h<?> h2, g.a a2) {
        this.f = h2;
        this.e = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a() {
        f.e.a<i, List<Class<?>>> a2;
        List list;
        List<m> list2 = this.f.a();
        if (list2.isEmpty()) {
            return false;
        }
        h<?> h2 = this.f;
        c.c.a.g g2 = h2.c.b;
        Class class_ = h2.d.getClass();
        Class<?> class_2 = h2.g;
        Class class_3 = h2.k;
        c.c.a.p.d d2 = g2.h;
        i i2 = (i)d2.a.getAndSet(null);
        if (i2 == null) {
            i2 = new i(class_, class_2, class_3);
        } else {
            i2.a = class_;
            i2.b = class_2;
            i2.c = class_3;
        }
        f.e.a<i, List<Class<?>>> a3 = a2 = d2.b;
        synchronized (a3) {
            list = d2.b.getOrDefault(i2, null);
        }
        d2.a.set((Object)i2);
        if (list == null) {
            f.e.a<i, List<Class<?>>> a4;
            List<Class<?>> list3;
            p p2;
            list = new ArrayList();
            p p3 = p2 = g2.a;
            synchronized (p3) {
                list3 = p2.a.d(class_);
            }
            for (Class class_4 : (ArrayList)list3) {
                for (Class class_5 : (ArrayList)g2.c.b(class_4, class_2)) {
                    if (((ArrayList)g2.f.a(class_5, class_3)).isEmpty() || list.contains((Object)class_5)) continue;
                    list.add((Object)class_5);
                }
            }
            c.c.a.p.d d3 = g2.h;
            List list4 = Collections.unmodifiableList((List)list);
            f.e.a<i, List<Class<?>>> a5 = a4 = d3.b;
            synchronized (a5) {
                d3.b.put(new i(class_, class_2, class_3), list4);
            }
        }
        if (list.isEmpty()) {
            if (File.class.equals(this.f.k)) {
                return false;
            }
            StringBuilder stringBuilder = c.b.a.a.a.c("Failed to find any load path from ");
            stringBuilder.append((Object)this.f.d.getClass());
            stringBuilder.append(" to ");
            stringBuilder.append(this.f.k);
            throw new IllegalStateException(stringBuilder.toString());
        }
        do {
            List<n<File, ?>> list5;
            int n2;
            boolean bl;
            y y2;
            File file;
            if ((list5 = this.j) != null && (bl = this.k < list5.size())) {
                this.l = null;
                boolean bl2 = false;
                do {
                    if (bl2) return bl2;
                    boolean bl3 = this.k < this.j.size();
                    if (!bl3) return bl2;
                    List<n<File, ?>> list6 = this.j;
                    int n3 = this.k;
                    this.k = n3 + 1;
                    n n4 = (n)list6.get(n3);
                    File file2 = this.m;
                    h<?> h3 = this.f;
                    this.l = n4.a(file2, h3.e, h3.f, h3.i);
                } while (this.l == null || !this.f.g(this.l.c.a()));
                this.l.c.e(this.f.o, this);
                return true;
            }
            this.h = n2 = 1 + this.h;
            if (n2 >= list.size()) {
                int n5;
                this.g = n5 = 1 + this.g;
                if (n5 >= list2.size()) {
                    return false;
                }
                this.h = 0;
            }
            m m2 = (m)list2.get(this.g);
            Class class_6 = (Class)list.get(this.h);
            s s2 = this.f.f(class_6);
            h<?> h4 = this.f;
            this.n = y2 = new y(h4.c.a, m2, h4.n, h4.e, h4.f, s2, class_6, h4.i);
            this.m = file = this.f.b().b(this.n);
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
        this.e.d(this.n, exception, this.l.c, c.c.a.m.a.h);
    }

    @Override
    public void f(Object object) {
        this.e.c(this.i, object, this.l.c, c.c.a.m.a.h, this.n);
    }
}

