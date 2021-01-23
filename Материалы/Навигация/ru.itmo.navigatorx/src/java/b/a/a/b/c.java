/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.Map
 */
package b.a.a.b;

import b.a.a.b.d;
import b.a.a.b.e;
import c.b.a.a.a;
import h.m.b.j;
import java.util.List;
import java.util.Map;

public final class c {
    public final List<d> a;
    public final Map<String, e> b;
    public final Map<String, List<String>> c;

    public c(List<? extends d> list, Map<String, e> map, Map<String, ? extends List<String>> map2) {
        j.e(list, (String)"markers");
        j.e(map, (String)"pathDots");
        j.e(map2, (String)"pathConnections");
        this.a = list;
        this.b = map;
        this.c = map2;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof c)) break block3;
                c c2 = (c)object;
                if (j.a(this.a, c2.a) && j.a(this.b, c2.b) && j.a(this.c, c2.c)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<d> list = this.a;
        int n2 = list != null ? list.hashCode() : 0;
        int n3 = n2 * 31;
        Map<String, e> map = this.b;
        int n4 = map != null ? map.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        Map<String, List<String>> map2 = this.c;
        int n6 = 0;
        if (map2 != null) {
            n6 = map2.hashCode();
        }
        return n5 + n6;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("MapData(markers=");
        stringBuilder.append(this.a);
        stringBuilder.append(", pathDots=");
        stringBuilder.append(this.b);
        stringBuilder.append(", pathConnections=");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

