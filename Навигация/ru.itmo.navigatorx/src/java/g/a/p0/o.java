/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.p0.n
 *  g.a.x
 *  io.realm.exceptions.RealmException
 *  io.realm.internal.OsObjectSchemaInfo
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.Util
 *  java.lang.Class
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package g.a.p0;

import g.a.e0;
import g.a.p0.c;
import g.a.p0.n;
import g.a.p0.p;
import g.a.x;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Util;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class o {
    public static void a(Class<? extends e0> class_) {
        if (class_ != null) {
            return;
        }
        throw new NullPointerException("A class extending RealmObject must be provided");
    }

    public static RealmException e(Class<? extends e0> class_) {
        Object[] arrobject = new Object[]{class_.toString()};
        return new RealmException(String.format((String)"'%s' is not part of the schema for this Realm.", (Object[])arrobject));
    }

    public abstract <E extends e0> E b(x var1, E var2, boolean var3, Map<e0, n> var4, Set<g.a.n> var5);

    public abstract c c(Class<? extends e0> var1, OsSchemaInfo var2);

    public abstract Map<Class<? extends e0>, OsObjectSchemaInfo> d();

    public boolean equals(Object object) {
        if (!(object instanceof o)) {
            return false;
        }
        o o2 = (o)object;
        return this.f().equals(o2.f());
    }

    public abstract Set<Class<? extends e0>> f();

    public final String g(Class<? extends e0> class_) {
        return this.h((Class<? extends e0>)Util.c(class_));
    }

    public abstract String h(Class<? extends e0> var1);

    public int hashCode() {
        return this.f().hashCode();
    }

    public abstract <E extends e0> boolean i(Class<E> var1);

    public abstract <E extends e0> E j(Class<E> var1, Object var2, p var3, c var4, boolean var5, List<String> var6);

    public boolean k() {
        return false;
    }

    public abstract <E extends e0> void l(x var1, E var2, E var3, Map<e0, n> var4, Set<g.a.n> var5);
}

