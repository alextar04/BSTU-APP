/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package b.a.a.d;

import b.a.a.d.i;
import h.m.b.j;
import java.util.List;
import java.util.Map;

public final class b {
    public final Map<Integer, List<i>> a;
    public final Map<String, i.a> b;

    public b(Map<Integer, ? extends List<i>> map, float f2, Map<String, ? extends i.a> map2) {
        j.e(map, (String)"floorPaths");
        j.e(map2, (String)"pathBreakTypes");
        this.a = map;
        this.b = map2;
    }
}

