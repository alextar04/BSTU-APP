/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.r
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package c.c.a.p;

import c.c.a.m.r;
import java.util.ArrayList;
import java.util.List;

public class f {
    public final List<a<?>> a = new ArrayList();

    public <Z> r<Z> a(Class<Z> class_) {
        f f2 = this;
        synchronized (f2) {
            int n2 = this.a.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                a a2 = (a)this.a.get(i2);
                if (!a2.a.isAssignableFrom(class_)) continue;
                r r2 = a2.b;
                return r2;
            }
            return null;
        }
    }

    public static final class a<T> {
        public final Class<T> a;
        public final r<T> b;

        public a(Class<T> class_, r<T> r2) {
            this.a = class_;
            this.b = r2;
        }
    }

}

