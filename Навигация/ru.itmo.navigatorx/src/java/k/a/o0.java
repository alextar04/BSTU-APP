/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package k.a;

import c.b.a.a.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class o0
implements Map<String, Object>,
Serializable,
Object {
    public final LinkedHashMap<String, Object> e = new LinkedHashMap();

    public void clear() {
        this.e.clear();
    }

    public boolean containsKey(Object object) {
        return this.e.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.e.containsValue(object);
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.e.entrySet();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (o0.class != object.getClass()) {
                return false;
            }
            o0 o02 = (o0)object;
            return this.e.equals(o02.e);
        }
        return false;
    }

    public Object get(Object object) {
        return this.e.get(object);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public boolean isEmpty() {
        return this.e.isEmpty();
    }

    public Set<String> keySet() {
        return this.e.keySet();
    }

    public Object put(Object object, Object object2) {
        String string = (String)object;
        return this.e.put((Object)string, object2);
    }

    public void putAll(Map<? extends String, ?> map) {
        this.e.putAll(map);
    }

    public Object remove(Object object) {
        return this.e.remove(object);
    }

    public int size() {
        return this.e.size();
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Document{");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Collection<Object> values() {
        return this.e.values();
    }
}

