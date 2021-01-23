/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.b;

import c.e.b.c0.s;
import c.e.b.o;

public final class r
extends o {
    public final s<String, o> a = new s();

    public boolean equals(Object object) {
        return object == this || object instanceof r && ((r)object).a.equals(this.a);
        {
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

