/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  h.p.a
 *  h.p.c
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package h.m.b;

import c.b.a.a.a;
import h.m.b.b;
import h.m.b.j;
import h.p.c;
import h.p.f;

public abstract class n
extends b
implements f {
    public n() {
    }

    public n(Object object, Class class_, String string, String string2, int n2) {
        int n3 = 1;
        if ((n2 & n3) != n3) {
            n3 = 0;
        }
        super(object, class_, string, string2, (boolean)n3);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof n) {
            n n2 = (n)object;
            return this.e().equals((Object)n2.e()) && this.h.equals((Object)n2.h) && this.i.equals((Object)n2.i) && j.a((Object)this.f, (Object)n2.f);
        }
        if (object instanceof f) {
            return object.equals((Object)this.c());
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * this.e().hashCode() + this.h.hashCode()) + this.i.hashCode();
    }

    public String toString() {
        h.p.a a2 = this.c();
        if (a2 != this) {
            return a2.toString();
        }
        return a.l(a.c("property "), this.h, " (Kotlin reflection is not available)");
    }
}

