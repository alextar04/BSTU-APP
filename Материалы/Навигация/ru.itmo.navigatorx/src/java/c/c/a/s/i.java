/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.s;

import c.b.a.a.a;
import c.c.a.s.j;

public class i {
    public Class<?> a;
    public Class<?> b;
    public Class<?> c;

    public i() {
    }

    public i(Class<?> class_, Class<?> class_2, Class<?> class_3) {
        this.a = class_;
        this.b = class_2;
        this.c = class_3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (i.class != object.getClass()) {
                return false;
            }
            i i2 = (i)object;
            if (!this.a.equals(i2.a)) {
                return false;
            }
            if (!this.b.equals(i2.b)) {
                return false;
            }
            return j.b(this.c, i2.c);
        }
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.a.hashCode() + this.b.hashCode());
        Class<?> class_ = this.c;
        int n3 = class_ != null ? class_.hashCode() : 0;
        return n2 + n3;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("MultiClassKey{first=");
        stringBuilder.append(this.a);
        stringBuilder.append(", second=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

