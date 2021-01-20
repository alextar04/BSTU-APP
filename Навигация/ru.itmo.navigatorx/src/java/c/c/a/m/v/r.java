/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.g$c
 *  c.c.a.m.v.q
 *  c.c.a.m.v.r$a
 *  f.b.k.h
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package c.c.a.m.v;

import c.c.a.g;
import c.c.a.m.v.n;
import c.c.a.m.v.o;
import c.c.a.m.v.q;
import c.c.a.m.v.r;
import f.b.k.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public class r {
    public static final c e;
    public static final n<Object, Object> f;
    public final List<b<?, ?>> a;
    public final c b;
    public final Set<b<?, ?>> c;
    public final f.h.k.c<List<Throwable>> d;

    public static {
        e = new c();
        f = new /* Unavailable Anonymous Inner Class!! */;
    }

    public r(f.h.k.c<List<Throwable>> c2) {
        c c3 = e;
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = c2;
        this.b = c3;
    }

    public final <Model, Data> n<Model, Data> a(b<?, ?> b2) {
        n n2 = b2.c.b(this);
        h.i.p(n2, "Argument must not be null");
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <Model, Data> n<Model, Data> b(Class<Model> class_, Class<Data> class_2) {
        r r2 = this;
        synchronized (r2) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator iterator = this.a.iterator();
                boolean bl = false;
                do {
                    b b2;
                    if (iterator.hasNext()) {
                        b2 = (b)iterator.next();
                        if (this.c.contains((Object)b2)) {
                            bl = true;
                            continue;
                        }
                    } else {
                        if (arrayList.size() > 1) {
                            c c2 = this.b;
                            f.h.k.c<List<Throwable>> c3 = this.d;
                            if (c2 == null) throw null;
                            return new q((List)arrayList, c3);
                        }
                        if (arrayList.size() == 1) {
                            return (n)arrayList.get(0);
                        }
                        if (!bl) throw new /* Unavailable Anonymous Inner Class!! */;
                        return f;
                    }
                    boolean bl2 = b2.a.isAssignableFrom(class_) && b2.b.isAssignableFrom(class_2);
                    if (!bl2) continue;
                    this.c.add((Object)b2);
                    arrayList.add(this.a(b2));
                    this.c.remove((Object)b2);
                } while (true);
            }
            catch (Throwable throwable) {
                this.c.clear();
                throw throwable;
            }
        }
    }

    public <Model> List<n<Model, ?>> c(Class<Model> class_) {
        r r2 = this;
        synchronized (r2) {
            try {
                ArrayList arrayList = new ArrayList();
                for (b b2 : this.a) {
                    if (this.c.contains((Object)b2) || !b2.a.isAssignableFrom(class_)) continue;
                    this.c.add((Object)b2);
                    n n2 = b2.c.b(this);
                    h.i.p(n2, "Argument must not be null");
                    arrayList.add(n2);
                    this.c.remove((Object)b2);
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                this.c.clear();
                throw throwable;
            }
        }
    }

    public List<Class<?>> d(Class<?> class_) {
        r r2 = this;
        synchronized (r2) {
            ArrayList arrayList = new ArrayList();
            for (b b2 : this.a) {
                if (arrayList.contains(b2.b) || !b2.a.isAssignableFrom(class_)) continue;
                arrayList.add(b2.b);
            }
            return arrayList;
        }
    }

    public static class b<Model, Data> {
        public final Class<Model> a;
        public final Class<Data> b;
        public final o<? extends Model, ? extends Data> c;

        public b(Class<Model> class_, Class<Data> class_2, o<? extends Model, ? extends Data> o2) {
            this.a = class_;
            this.b = class_2;
            this.c = o2;
        }
    }

    public static class c {
    }

}

