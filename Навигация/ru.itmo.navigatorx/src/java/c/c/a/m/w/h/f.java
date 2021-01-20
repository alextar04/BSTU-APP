/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package c.c.a.m.w.h;

import c.c.a.m.w.h.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f {
    public final List<a<?, ?>> a = new ArrayList();

    public <Z, R> List<Class<R>> a(Class<Z> class_, Class<R> class_2) {
        f f2 = this;
        synchronized (f2) {
            ArrayList arrayList;
            block5 : {
                arrayList = new ArrayList();
                if (!class_2.isAssignableFrom(class_)) break block5;
                arrayList.add(class_2);
                return arrayList;
            }
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                if (!((a)iterator.next()).a(class_, class_2)) continue;
                arrayList.add(class_2);
            }
            return arrayList;
        }
    }

    public static final class a<Z, R> {
        public final Class<Z> a;
        public final Class<R> b;
        public final e<Z, R> c;

        public a(Class<Z> class_, Class<R> class_2, e<Z, R> e2) {
            this.a = class_;
            this.b = class_2;
            this.c = e2;
        }

        public boolean a(Class<?> class_, Class<?> class_2) {
            return this.a.isAssignableFrom(class_) && class_2.isAssignableFrom(this.b);
        }
    }

}

