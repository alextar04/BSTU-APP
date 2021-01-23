/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package k.a.a1;

import c.b.a.a.a;
import java.io.Serializable;

public class b
implements Serializable {
    public final String e;

    public b(String string) {
        this.e = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            return this.e.equals((Object)b2.e);
        }
        return false;
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Code{code='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

