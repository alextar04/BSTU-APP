/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.g$e
 *  c.c.a.m.o
 *  c.c.a.m.s
 *  c.c.a.m.u.i
 *  c.c.a.m.u.l
 *  c.c.a.m.u.l$c
 *  c.c.a.m.w.b
 *  c.c.a.m.w.h.g
 *  f.e.a
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicReference
 */
package c.c.a.m.u;

import c.c.a.d;
import c.c.a.e;
import c.c.a.g;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.s;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.i;
import c.c.a.m.u.j;
import c.c.a.m.u.k;
import c.c.a.m.u.l;
import c.c.a.m.u.u;
import c.c.a.m.v.n;
import c.c.a.m.w.b;
import c.c.a.m.w.h.f;
import c.c.a.p.a;
import c.c.a.p.c;
import c.c.a.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public final class h<Transcode> {
    public final List<n.a<?>> a;
    public final List<m> b;
    public d c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public i.d h;
    public o i;
    public Map<Class<?>, s<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public m n;
    public e o;
    public k p;
    public boolean q;
    public boolean r;

    public h() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<m> a() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<n.a<?>> list = this.c();
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                n.a a2 = (n.a)list.get(i2);
                if (!this.b.contains((Object)a2.a)) {
                    this.b.add((Object)a2.a);
                }
                for (int i3 = 0; i3 < a2.b.size(); ++i3) {
                    if (this.b.contains(a2.b.get(i3))) continue;
                    this.b.add(a2.b.get(i3));
                }
            }
        }
        return this.b;
    }

    public a b() {
        return ((l.c)this.h).a();
    }

    public List<n.a<?>> c() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List<n<Object, ?>> list = this.c.b.f(this.d);
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                n.a a2 = ((n)list.get(i2)).a(this.d, this.e, this.f, this.i);
                if (a2 == null) continue;
                this.a.add(a2);
            }
        }
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <Data> u<Data, ?, Transcode> d(Class<Data> class_) {
        u u2;
        f.e.a<c.c.a.s.i, u<?, ?, ?>> a2;
        g g2 = this.c.b;
        Class<?> class_2 = this.g;
        Class<Transcode> class_3 = this.k;
        c c2 = g2.i;
        c.c.a.s.i i2 = (c.c.a.s.i)c2.b.getAndSet(null);
        if (i2 == null) {
            i2 = new c.c.a.s.i();
        }
        i2.a = class_;
        i2.b = class_2;
        i2.c = class_3;
        f.e.a<c.c.a.s.i, u<?, ?, ?>> a3 = a2 = c2.a;
        synchronized (a3) {
            u2 = c2.a.getOrDefault(i2, null);
        }
        c2.b.set((Object)i2);
        if (g2.i == null) {
            throw null;
        }
        if (c.c.equals((Object)u2)) {
            return null;
        }
        if (u2 != null) {
            return u2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = ((ArrayList)g2.c.b(class_, class_2)).iterator();
        block10 : do {
            if (!iterator.hasNext()) {
                u u3;
                f.e.a<c.c.a.s.i, u<?, ?, ?>> a4;
                if (arrayList.isEmpty()) {
                    u3 = null;
                } else {
                    f.h.k.c<List<Throwable>> c3 = g2.j;
                    u3 = new u(class_, class_2, class_3, (List<j<Data, ?, Transcode>>)arrayList, c3);
                }
                c c4 = g2.i;
                f.e.a<c.c.a.s.i, u<?, ?, ?>> a5 = a4 = c4.a;
                synchronized (a5) {
                    f.e.a<c.c.a.s.i, u<?, ?, ?>> a6 = c4.a;
                    c.c.a.s.i i3 = new c.c.a.s.i(class_, class_2, class_3);
                    u<Object, ?, Object> u4 = u3 != null ? u3 : c.c;
                    a6.put(i3, u4);
                    return u3;
                }
            }
            Class class_4 = (Class)iterator.next();
            Iterator iterator2 = ((ArrayList)g2.f.a(class_4, class_3)).iterator();
            do {
                f f2;
                c.c.a.p.e e2;
                ArrayList arrayList2;
                c.c.a.m.w.h.g g3;
                if (!iterator2.hasNext()) continue block10;
                Class class_5 = (Class)iterator2.next();
                c.c.a.p.e e3 = e2 = g2.c;
                synchronized (e3) {
                    arrayList2 = new ArrayList();
                    for (String string : e2.a) {
                        List list = (List)e2.b.get((Object)string);
                        if (list == null) continue;
                        for (e.a a7 : list) {
                            if (!a7.a(class_, class_4)) continue;
                            arrayList2.add(a7.c);
                        }
                    }
                }
                f f3 = f2 = g2.f;
                synchronized (f3) {
                    Object object;
                    if (class_5.isAssignableFrom(class_4)) {
                        object = c.c.a.m.w.h.g.a;
                    } else {
                        f.a a8;
                        Iterator iterator3 = f2.a.iterator();
                        do {
                            if (iterator3.hasNext()) continue;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("No transcoder registered to transcode from ");
                            stringBuilder.append((Object)class_4);
                            stringBuilder.append(" to ");
                            stringBuilder.append((Object)class_5);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        } while (!(a8 = (f.a)iterator3.next()).a(class_4, class_5));
                        object = a8.c;
                    }
                    g3 = object;
                }
                j j2 = new j(class_, class_4, class_5, arrayList2, g3, g2.j);
                arrayList.add(j2);
            } while (true);
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public <X> c.c.a.m.d<X> e(X x2) {
        c.c.a.m.d d2;
        block3 : {
            c.c.a.p.a a2 = this.c.b.b;
            Class class_ = x2.getClass();
            c.c.a.p.a a3 = a2;
            // MONITORENTER : a3
            for (a.a a4 : a2.a) {
                if (!a4.a.isAssignableFrom(class_)) continue;
                d2 = a4.b;
                break block3;
            }
            d2 = null;
        }
        // MONITOREXIT : a3
        if (d2 == null) throw new /* Unavailable Anonymous Inner Class!! */;
        return d2;
    }

    public <Z> s<Z> f(Class<Z> class_) {
        s s2 = (s)this.j.get(class_);
        if (s2 == null) {
            for (Map.Entry entry : this.j.entrySet()) {
                if (!((Class)entry.getKey()).isAssignableFrom(class_)) continue;
                s2 = (s)entry.getValue();
                break;
            }
        }
        if (s2 == null) {
            if (this.j.isEmpty() && this.q) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Missing transformation for ");
                stringBuilder.append(class_);
                stringBuilder.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return (b)b.b;
        }
        return s2;
    }

    public boolean g(Class<?> class_) {
        return this.d(class_) != null;
    }
}

