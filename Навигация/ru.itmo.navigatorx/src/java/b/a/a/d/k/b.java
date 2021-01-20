/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  h.m.a.l
 *  h.m.a.p
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package b.a.a.d.k;

import h.h;
import h.m.a.l;
import h.m.a.p;
import h.m.b.f;
import h.m.b.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b<Model> {
    public Model a;
    public final List<a<Model, Object>> b;
    public final Map<Class<? extends Model>, b<? extends Model>> c;

    public b(List list, Map map, f f2) {
        this.b = list;
        this.c = map;
    }

    public final void a() {
        this.a = null;
        Iterator iterator = this.c.values().iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).a();
        }
    }

    public final void b(Model Model) {
        Object object2;
        block4 : {
            j.e(Model, (String)"newModel");
            for (Object object2 : this.c.keySet()) {
                if (!((Class)object2).isInstance(Model)) continue;
                break block4;
            }
            object2 = null;
        }
        Class class_ = (Class)object2;
        Object object3 = this.c.get((Object)class_);
        Object object4 = !(object3 instanceof b) ? null : object3;
        b b2 = (b)object4;
        if (b2 != null) {
            b2.b(Model);
        }
        for (b b3 : this.c.values()) {
            if (b3 == b2) continue;
            b3.a();
        }
        Model Model2 = this.a;
        for (a a2 : this.b) {
            l l2 = a2.a;
            Object object5 = l2.f(Model);
            if (Model2 != null && !((Boolean)a2.c.c(l2.f(Model2), object5)).booleanValue()) continue;
            a2.b.f(object5);
        }
        this.a = Model;
    }

    public static final class a<Model, Field> {
        public final l<Model, Field> a;
        public final l<Field, h> b;
        public final p<Field, Field, Boolean> c;

        public a(l<? super Model, ? extends Field> l2, l<? super Field, h> l3, p<? super Field, ? super Field, Boolean> p2) {
            j.e(l2, (String)"accessor");
            j.e(l3, (String)"callback");
            j.e(p2, (String)"diff");
            this.a = l2;
            this.b = l3;
            this.c = p2;
        }
    }

}

