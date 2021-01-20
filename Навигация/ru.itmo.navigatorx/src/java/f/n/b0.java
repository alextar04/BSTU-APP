/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.a0
 *  f.n.d0
 *  f.n.g0
 *  f.n.h0
 *  h.a
 *  h.m.a.a
 *  h.m.b.c
 *  h.m.b.j
 *  h.p.b
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package f.n;

import f.n.a0;
import f.n.d0;
import f.n.e0;
import f.n.g0;
import f.n.h0;
import h.m.a.a;
import h.m.b.c;
import h.m.b.j;
import h.p.b;
import java.util.HashMap;

public final class b0<VM extends a0>
implements h.a<VM> {
    public VM e;
    public final b<VM> f;
    public final a<h0> g;
    public final a<d0> h;

    public b0(b<VM> b2, a<? extends h0> a2, a<? extends d0> a3) {
        j.f(b2, (String)"viewModelClass");
        j.f(a2, (String)"storeProducer");
        j.f(a3, (String)"factoryProducer");
        this.f = b2;
        this.g = a2;
        this.h = a3;
    }

    public Object getValue() {
        VM VM = this.e;
        if (VM == null) {
            d0 d02 = (d0)this.h.a();
            h0 h02 = (h0)this.g.a();
            b<VM> b2 = this.f;
            j.e(b2, (String)"$this$java");
            Class class_ = ((c)b2).a();
            if (class_ != null) {
                String string = class_.getCanonicalName();
                if (string != null) {
                    Object object;
                    String string2 = c.b.a.a.a.j("androidx.lifecycle.ViewModelProvider.DefaultKey:", string);
                    a0 a02 = (a0)h02.a.get((Object)string2);
                    if (class_.isInstance((Object)a02)) {
                        if (d02 instanceof g0) {
                            ((g0)d02).b(a02);
                        }
                        object = a02;
                    } else {
                        object = d02 instanceof e0 ? ((e0)d02).c(string2, class_) : d02.a(class_);
                        a0 a03 = (a0)h02.a.put((Object)string2, object);
                        if (a03 != null) {
                            a03.b();
                        }
                    }
                    this.e = object;
                    j.b((Object)object, (String)"ViewModelProvider(store,\u2026ed = it\n                }");
                    return object;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
        }
        return VM;
    }
}

