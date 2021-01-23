/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.Table
 *  io.realm.internal.Util
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package g.a;

import g.a.a;
import g.a.b0;
import g.a.e0;
import g.a.i0;
import g.a.l;
import g.a.p0.b;
import g.a.p0.c;
import g.a.p0.o;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import io.realm.internal.Util;
import java.util.HashMap;
import java.util.Map;

public abstract class k0 {
    public final Map<String, Table> a = new HashMap();
    public final Map<Class<? extends e0>, Table> b = new HashMap();
    public final Map<Class<? extends e0>, i0> c = new HashMap();
    public final Map<String, i0> d = new HashMap();
    public final a e;
    public final b f;

    public k0(a a2, b b2) {
        this.e = a2;
        this.f = b2;
    }

    public final c a(Class<? extends e0> class_) {
        boolean bl = this.f != null;
        if (bl) {
            b b2 = this.f;
            c c2 = (c)b2.a.get(class_);
            if (c2 == null) {
                c2 = b2.b.c(class_, b2.c);
                b2.a.put(class_, (Object)c2);
            }
            return c2;
        }
        throw new IllegalStateException("Attempt to use column key before set.");
    }

    public i0 b(Class<? extends e0> class_) {
        i0 i02 = (i0)this.c.get(class_);
        if (i02 != null) {
            return i02;
        }
        Class class_2 = Util.c(class_);
        if (class_2.equals(class_)) {
            i02 = (i0)this.c.get((Object)class_2);
        }
        if (i02 == null) {
            Table table = this.c(class_);
            l l2 = new l(this.e, this, table, this.a((Class<? extends e0>)class_2));
            this.c.put((Object)class_2, (Object)l2);
            i02 = l2;
        }
        if (class_2.equals(class_)) {
            this.c.put(class_, (Object)i02);
        }
        return i02;
    }

    public Table c(Class<? extends e0> class_) {
        Table table = (Table)this.b.get(class_);
        if (table != null) {
            return table;
        }
        Class class_2 = Util.c(class_);
        if (class_2.equals(class_)) {
            table = (Table)this.b.get((Object)class_2);
        }
        if (table == null) {
            String string = Table.g((String)this.e.g.j.g((Class<? extends e0>)class_2));
            table = this.e.i.getTable(string);
            this.b.put((Object)class_2, (Object)table);
        }
        if (class_2.equals(class_)) {
            this.b.put(class_, (Object)table);
        }
        return table;
    }
}

