/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.c0
 *  io.realm.RealmFieldType
 *  io.realm.internal.Table
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 */
package g.a;

import g.a.c0;
import g.a.g0;
import g.a.k0;
import g.a.p0.c;
import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class i0 {
    public final g.a.a a;
    public final Table b;

    public static {
        HashMap hashMap = new HashMap();
        hashMap.put(String.class, (Object)new b(RealmFieldType.STRING, RealmFieldType.STRING_LIST, true));
        hashMap.put((Object)Short.TYPE, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Short.class, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put((Object)Integer.TYPE, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Integer.class, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put((Object)Long.TYPE, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Long.class, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put((Object)Float.TYPE, (Object)new b(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, false));
        hashMap.put(Float.class, (Object)new b(RealmFieldType.FLOAT, RealmFieldType.FLOAT_LIST, true));
        hashMap.put((Object)Double.TYPE, (Object)new b(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, false));
        hashMap.put(Double.class, (Object)new b(RealmFieldType.DOUBLE, RealmFieldType.DOUBLE_LIST, true));
        hashMap.put((Object)Boolean.TYPE, (Object)new b(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, false));
        hashMap.put(Boolean.class, (Object)new b(RealmFieldType.BOOLEAN, RealmFieldType.BOOLEAN_LIST, true));
        hashMap.put((Object)Byte.TYPE, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, false));
        hashMap.put(Byte.class, (Object)new b(RealmFieldType.INTEGER, RealmFieldType.INTEGER_LIST, true));
        hashMap.put(byte[].class, (Object)new b(RealmFieldType.BINARY, RealmFieldType.BINARY_LIST, true));
        hashMap.put(Date.class, (Object)new b(RealmFieldType.DATE, RealmFieldType.DATE_LIST, true));
        Collections.unmodifiableMap((Map)hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(g0.class, (Object)new b(RealmFieldType.OBJECT, null, false));
        hashMap2.put(c0.class, (Object)new b(RealmFieldType.LIST, null, false));
        Collections.unmodifiableMap((Map)hashMap2);
    }

    public i0(g.a.a a2, k0 k02, Table table, c c2) {
        this.a = a2;
        this.b = table;
    }

    public static final class b {
        public b(RealmFieldType realmFieldType, RealmFieldType realmFieldType2, boolean bl) {
        }
    }

}

