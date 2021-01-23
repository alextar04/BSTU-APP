/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package c.c.a.p;

import c.c.a.m.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {
    public final List<String> a = new ArrayList();
    public final Map<String, List<a<?, ?>>> b = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List<a<?, ?>> a(String string) {
        e e2 = this;
        synchronized (e2) {
            List list;
            if (!this.a.contains((Object)string)) {
                this.a.add((Object)string);
            }
            if ((list = (List)this.b.get((Object)string)) == null) {
                list = new ArrayList();
                this.b.put((Object)string, (Object)list);
            }
            return list;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public <T, R> List<Class<R>> b(Class<T> class_, Class<R> class_2) {
        e e2 = this;
        synchronized (e2) {
            ArrayList arrayList = new ArrayList();
            for (String string : this.a) {
                List list = (List)this.b.get((Object)string);
                if (list == null) continue;
                for (a a2 : list) {
                    if (!a2.a(class_, class_2) || arrayList.contains(a2.b)) continue;
                    arrayList.add(a2.b);
                }
            }
            return arrayList;
        }
    }

    public static class a<T, R> {
        public final Class<T> a;
        public final Class<R> b;
        public final q<T, R> c;

        public a(Class<T> class_, Class<R> class_2, q<T, R> q2) {
            this.a = class_;
            this.b = class_2;
            this.c = q2;
        }

        public boolean a(Class<?> class_, Class<?> class_2) {
            return this.a.isAssignableFrom(class_) && class_2.isAssignableFrom(this.b);
        }
    }

}

