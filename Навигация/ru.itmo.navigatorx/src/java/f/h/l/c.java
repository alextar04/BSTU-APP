/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.h.l;

import c.b.a.a.a;

public final class c {
    public final Object a;

    public c(Object object) {
        this.a = object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (c.class != object.getClass()) {
                return false;
            }
            c c2 = (c)object;
            Object object2 = this.a;
            Object object3 = c2.a;
            if (object2 == null) {
                return object3 == null;
            }
            return object2.equals(object3);
        }
        return false;
    }

    public int hashCode() {
        Object object = this.a;
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c((String)"DisplayCutoutCompat{");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

