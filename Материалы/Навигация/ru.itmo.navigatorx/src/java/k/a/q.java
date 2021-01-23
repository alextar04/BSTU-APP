/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package k.a;

import k.a.k0;

public class q {
    public final String a;
    public final k0 b;

    public q(String string, k0 k02) {
        this.a = string;
        this.b = k02;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (q.class != object.getClass()) {
                return false;
            }
            q q2 = (q)object;
            String string = this.a;
            if (string != null ? !string.equals((Object)q2.a) : q2.a != null) {
                return false;
            }
            k0 k02 = this.b;
            return !(k02 != null ? !k02.equals((Object)q2.b) : q2.b != null);
        }
        return false;
    }

    public int hashCode() {
        String string = this.a;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        k0 k02 = this.b;
        int n4 = 0;
        if (k02 != null) {
            n4 = k02.hashCode();
        }
        return n3 + n4;
    }
}

