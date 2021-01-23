/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.OsSchemaInfo
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package g.a.p0;

import g.a.e0;
import g.a.p0.c;
import g.a.p0.o;
import io.realm.internal.OsSchemaInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public final Map<Class<? extends e0>, c> a = new ConcurrentHashMap();
    public final o b;
    public final OsSchemaInfo c;

    public b(o o2, OsSchemaInfo osSchemaInfo) {
        new HashMap();
        this.b = o2;
        this.c = osSchemaInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ColumnIndices[");
        Iterator iterator = this.a.entrySet().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (bl) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Class)entry.getKey()).getSimpleName());
            stringBuilder.append("->");
            stringBuilder.append(entry.getValue());
            bl = true;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

