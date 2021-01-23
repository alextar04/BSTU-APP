/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.g$b
 *  c.c.a.g$c
 *  c.c.a.m.r
 *  c.c.a.s.k.a$c
 *  c.c.a.s.k.b
 *  c.c.a.s.k.c
 *  com.bumptech.glide.load.ImageHeaderParser
 *  f.h.k.e
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 */
package c.c.a;

import c.c.a.g;
import c.c.a.m.d;
import c.c.a.m.q;
import c.c.a.m.r;
import c.c.a.m.t.e;
import c.c.a.m.t.f;
import c.c.a.m.v.n;
import c.c.a.m.v.o;
import c.c.a.m.v.p;
import c.c.a.m.v.r;
import c.c.a.m.w.h.f;
import c.c.a.p.a;
import c.c.a.p.e;
import c.c.a.p.f;
import c.c.a.s.k.a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public class g {
    public final p a;
    public final c.c.a.p.a b;
    public final c.c.a.p.e c;
    public final c.c.a.p.f d;
    public final f e;
    public final c.c.a.m.w.h.f f;
    public final c.c.a.p.b g;
    public final c.c.a.p.d h;
    public final c.c.a.p.c i;
    public final f.h.k.c<List<Throwable>> j;

    public g() {
        c.c.a.p.e e2;
        a.c c2;
        this.h = new c.c.a.p.d();
        this.i = new c.c.a.p.c();
        this.j = c2 = new a.c((f.h.k.c)new f.h.k.e(20), (a.b)new c.c.a.s.k.b(), (a.e)new c.c.a.s.k.c());
        this.a = new p((f.h.k.c<List<Throwable>>)c2);
        this.b = new c.c.a.p.a();
        this.c = new c.c.a.p.e();
        this.d = new c.c.a.p.f();
        this.e = new f();
        this.f = new c.c.a.m.w.h.f();
        this.g = new c.c.a.p.b();
        List list = Arrays.asList((Object[])new String[]{"Gif", "Bitmap", "BitmapDrawable"});
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll((Collection)list);
        arrayList.add(0, (Object)"legacy_prepend_all");
        arrayList.add((Object)"legacy_append");
        c.c.a.p.e e3 = e2 = this.c;
        synchronized (e3) {
            ArrayList arrayList2 = new ArrayList(e2.a);
            e2.a.clear();
            for (String string : arrayList) {
                e2.a.add((Object)string);
            }
            for (String string : arrayList2) {
                if (arrayList.contains((Object)string)) continue;
                e2.a.add((Object)string);
            }
            return;
        }
    }

    public <Data> g a(Class<Data> class_, d<Data> d2) {
        c.c.a.p.a a2;
        c.c.a.p.a a3 = a2 = this.b;
        synchronized (a3) {
            a2.a.add(new a.a<Data>(class_, d2));
            return this;
        }
    }

    public <TResource> g b(Class<TResource> class_, r<TResource> r2) {
        c.c.a.p.f f2;
        c.c.a.p.f f3 = f2 = this.d;
        synchronized (f3) {
            f2.a.add(new f.a<TResource>(class_, r2));
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <Model, Data> g c(Class<Model> class_, Class<Data> class_2, o<Model, Data> o2) {
        p p2;
        p p3 = p2 = this.a;
        synchronized (p3) {
            c.c.a.m.v.r r2;
            c.c.a.m.v.r r3 = r2 = p2.a;
            synchronized (r3) {
                r.b<Model, Data> b2 = new r.b<Model, Data>(class_, class_2, o2);
                List<r.b<?, ?>> list = r2.a;
                list.add(list.size(), b2);
            }
            p2.b.a.clear();
            return this;
        }
    }

    public <Data, TResource> g d(String string, Class<Data> class_, Class<TResource> class_2, q<Data, TResource> q2) {
        c.c.a.p.e e2;
        c.c.a.p.e e3 = e2 = this.c;
        synchronized (e3) {
            e2.a(string).add(new e.a<Data, TResource>(class_, class_2, q2));
            return this;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public List<ImageHeaderParser> e() {
        c.c.a.p.b b2;
        c.c.a.p.b b3 = b2 = this.g;
        // MONITORENTER : b3
        List<ImageHeaderParser> list = b2.a;
        // MONITOREXIT : b3
        if (list.isEmpty()) throw new /* Unavailable Anonymous Inner Class!! */;
        return list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public <Model> List<n<Model, ?>> f(Model Model) {
        p p2 = this.a;
        if (p2 == null) throw null;
        Class class_ = Model.getClass();
        p p3 = p2;
        // MONITORENTER : p3
        p.a.a a2 = (p.a.a)p2.b.a.get((Object)class_);
        List list = a2 == null ? null : a2.a;
        if (list == null && (p.a.a)p2.b.a.put((Object)class_, new p.a.a(list = Collections.unmodifiableList(p2.a.c(class_)))) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Already cached loaders for model: ");
            stringBuilder.append((Object)class_);
            throw new IllegalStateException(stringBuilder.toString());
        }
        // MONITOREXIT : p3
        if (list.isEmpty()) throw new /* Unavailable Anonymous Inner Class!! */;
        int n2 = list.size();
        List list2 = Collections.emptyList();
        boolean bl = true;
        int i2 = 0;
        do {
            if (i2 >= n2) {
                if (list2.isEmpty()) throw new /* Unavailable Anonymous Inner Class!! */;
                return list2;
            }
            n n3 = (n)list.get(i2);
            if (n3.b(Model)) {
                if (bl) {
                    list2 = new ArrayList(n2 - i2);
                    bl = false;
                }
                list2.add((Object)n3);
            }
            ++i2;
        } while (true);
    }

    public g g(e.a<?> a2) {
        f f2;
        f f3 = f2 = this.e;
        synchronized (f3) {
            f2.a.put(a2.a(), a2);
            return this;
        }
    }

    public <TResource, Transcode> g h(Class<TResource> class_, Class<Transcode> class_2, c.c.a.m.w.h.e<TResource, Transcode> e2) {
        c.c.a.m.w.h.f f2;
        c.c.a.m.w.h.f f3 = f2 = this.f;
        synchronized (f3) {
            f2.a.add(new f.a<TResource, Transcode>(class_, class_2, e2));
            return this;
        }
    }

    public static class a
    extends RuntimeException {
        public a(String string) {
            super(string);
        }
    }

}

