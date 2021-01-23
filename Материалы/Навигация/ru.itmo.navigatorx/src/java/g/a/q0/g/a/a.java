/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.Util
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package g.a.q0.g.a;

import g.a.p0.v.a.d;
import io.realm.internal.Util;
import java.util.Map;

public class a {
    public String a;
    public Map<String, d> b;

    public a(String string, Map<String, d> map) {
        Util.b((Object)string, (String)"feature");
        this.a = string;
        Util.b(map, (String)"patternObfuscatorMap");
        this.b = map;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        return this.b.equals(a2.b);
    }

    public int hashCode() {
        return 13 + this.b.hashCode();
    }
}

