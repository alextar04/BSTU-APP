/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.b$a
 *  h.m.b.l
 *  h.m.b.o
 *  h.m.b.p
 *  h.p.a
 *  h.p.c
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package h.m.b;

import h.m.b.b;
import h.m.b.l;
import h.m.b.o;
import h.m.b.p;
import h.p.c;
import java.io.Serializable;

public abstract class b
implements h.p.a,
Serializable {
    public static final Object k = a.e;
    public transient h.p.a e;
    public final Object f;
    public final Class g;
    public final String h;
    public final String i;
    public final boolean j;

    public b() {
        Object object = k;
        this.f = object;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
    }

    public b(Object object, Class class_, String string, String string2, boolean bl) {
        this.f = object;
        this.g = class_;
        this.h = string;
        this.i = string2;
        this.j = bl;
    }

    public h.p.a c() {
        h.p.a a2 = this.e;
        if (a2 == null) {
            this.e = a2 = this.d();
        }
        return a2;
    }

    public abstract h.p.a d();

    public c e() {
        Class class_ = this.g;
        if (class_ == null) {
            return null;
        }
        if (this.j) {
            if (o.a != null) {
                return new l(class_, "");
            }
            throw null;
        }
        return o.a((Class)class_);
    }
}

