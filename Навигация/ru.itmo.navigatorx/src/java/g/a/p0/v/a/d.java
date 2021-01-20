/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.regex.Pattern
 */
package g.a.p0.v.a;

import java.util.Map;
import java.util.regex.Pattern;

public abstract class d {
    public Map<Pattern, String> a;

    public d(Map<Pattern, String> map) {
        this.a = map;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof d)) {
            return false;
        }
        d d2 = (d)object;
        return this.a.equals(d2.a);
    }

    public int hashCode() {
        return 13 + this.a.hashCode();
    }
}

