/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package k.a.a1;

import java.io.Serializable;

public class f
implements Serializable {
    public final String e;

    public f(String string) {
        this.e = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (f.class != object.getClass()) {
                return false;
            }
            f f2 = (f)object;
            return this.e.equals((Object)f2.e);
        }
        return false;
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        return this.e;
    }
}

