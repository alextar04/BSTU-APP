/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.b0
 *  g.a.e0
 *  g.a.i0
 *  g.a.j
 *  g.a.k0
 *  g.a.n
 *  g.a.p
 *  g.a.p0.c
 *  g.a.p0.h
 *  g.a.p0.n
 *  g.a.p0.o
 *  g.a.p0.p
 *  g.a.w
 *  g.a.x
 *  io.realm.internal.OsList
 *  io.realm.internal.OsObjectSchemaInfo
 *  io.realm.internal.OsObjectStore
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.Property
 *  io.realm.internal.Table
 *  io.realm.internal.UncheckedRow
 *  io.realm.internal.Util
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 */
package g.a;

import g.a.a;
import g.a.b0;
import g.a.e0;
import g.a.i0;
import g.a.j;
import g.a.k0;
import g.a.l;
import g.a.p0.c;
import g.a.p0.h;
import g.a.p0.n;
import g.a.p0.o;
import g.a.p0.p;
import g.a.w;
import g.a.x;
import io.realm.internal.OsList;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Property;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class f0<T>
extends g.a.p<T> {
    public final String d;

    public f0(a a2, OsList osList, Class<T> class_, String string) {
        super(a2, osList, class_);
        this.d = string;
    }

    public void a(Object object) {
        e0 e02 = (e0)object;
        boolean bl = this.h(this.a, e02);
        if (this.j(e02)) {
            if (!(object instanceof j)) {
                OsList osList = this.b;
                this.k(e02, OsList.nativeCreateAndAddEmbeddedObject((long)osList.e, (long)osList.b()));
                return;
            }
            throw new IllegalArgumentException("Embedded objects are not supported by RealmLists of DynamicRealmObjects yet.");
        }
        if (bl) {
            e02 = this.i((E)e02);
        }
        n n2 = (n)e02;
        OsList osList = this.b;
        long l2 = n2.c().b.t();
        OsList.nativeAddRow((long)osList.e, (long)l2);
    }

    public void b(Object object) {
        if (object != null) {
            if (object instanceof e0) {
                return;
            }
            Locale locale = Locale.ENGLISH;
            Object[] arrobject = new Object[]{"java.lang.String", object.getClass().getName()};
            throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unacceptable value type. Acceptable: %1$s, actual: %2$s .", (Object[])arrobject));
        }
        throw new IllegalArgumentException("RealmList does not accept null values.");
    }

    public T c(int n2) {
        a a2 = this.a;
        Class class_ = this.c;
        String string = this.d;
        OsList osList = this.b;
        long l2 = n2;
        return (T)a2.f(class_, string, osList.g.h(OsList.nativeGetRow((long)osList.e, (long)l2)));
    }

    public void d(int n2) {
        throw new RuntimeException("Should not reach here.");
    }

    public void e(int n2, Object object) {
        long l2 = this.b.b();
        int n3 = l2 < Integer.MAX_VALUE ? (int)l2 : Integer.MAX_VALUE;
        if (n2 >= 0 && n3 >= n2) {
            e0 e02 = (e0)object;
            boolean bl = this.h(this.a, e02);
            if (this.j(e02)) {
                if (!(object instanceof j)) {
                    OsList osList = this.b;
                    long l3 = n2;
                    this.k(e02, OsList.nativeCreateAndAddEmbeddedObject((long)osList.e, (long)l3));
                    return;
                }
                throw new IllegalArgumentException("Embedded objects are not supported by RealmLists of DynamicRealmObjects yet.");
            }
            if (bl) {
                e02 = this.i((E)e02);
            }
            n n4 = (n)e02;
            OsList osList = this.b;
            long l4 = n2;
            long l5 = n4.c().b.t();
            OsList.nativeInsertRow((long)osList.e, (long)l4, (long)l5);
            return;
        }
        StringBuilder stringBuilder = c.b.a.a.a.d("Invalid index ", n2, ", size is ");
        stringBuilder.append(this.b.b());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void f(int n2) {
        throw new RuntimeException("Should not reach here.");
    }

    public void g(int n2, Object object) {
        e0 e02 = (e0)object;
        boolean bl = this.h(this.a, e02);
        if (this.j(e02)) {
            if (!(object instanceof j)) {
                OsList osList = this.b;
                long l2 = n2;
                this.k(e02, OsList.nativeCreateAndSetEmbeddedObject((long)osList.e, (long)l2));
                return;
            }
            throw new IllegalArgumentException("Embedded objects are not supported by RealmLists of DynamicRealmObjects yet.");
        }
        if (bl) {
            e02 = this.i((E)e02);
        }
        n n3 = (n)e02;
        OsList osList = this.b;
        long l3 = n2;
        long l4 = n3.c().b.t();
        OsList.nativeSetRow((long)osList.e, (long)l3, (long)l4);
    }

    public final boolean h(a a2, e0 e02) {
        if (e02 instanceof n) {
            n n2 = (n)e02;
            if (n2 instanceof j) {
                String string = this.d;
                if (n2.c().c == a2) {
                    j j2 = (j)e02;
                    j2.a.c.c();
                    String string2 = j2.a.b.k().b();
                    if (string.equals((Object)string2)) {
                        return false;
                    }
                    throw new IllegalArgumentException(String.format((Locale)Locale.US, (String)"The object has a different type from list's. Type of the list is '%s', type of object is '%s'.", (Object[])new Object[]{string, string2}));
                }
                if (a2.f == n2.c().c.f) {
                    throw new IllegalArgumentException("Cannot copy DynamicRealmObject between Realm instances.");
                }
                throw new IllegalStateException("Cannot copy an object to a Realm instance created in another thread.");
            }
            if (n2.c().b != null && n2.c().c.g.c.equals((Object)a2.g.c)) {
                if (a2 == n2.c().c) {
                    return false;
                }
                throw new IllegalArgumentException("Cannot copy an object from another Realm instance.");
            }
        }
        return true;
    }

    public final <E extends e0> E i(E e2) {
        x x2 = (x)this.a;
        OsSharedRealm osSharedRealm = x2.i;
        String string = x2.g.j.g(e2.getClass());
        if (OsObjectStore.nativeGetPrimaryKeyForObject((long)osSharedRealm.getNativePtr(), (String)string) != null) {
            Object[] arrobject = new g.a.n[]{};
            Class class_ = e2.getClass();
            String string2 = x2.g.j.g(class_);
            OsSchemaInfo osSchemaInfo = x2.i.getSchemaInfo();
            if (osSchemaInfo != null) {
                OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo(OsSchemaInfo.nativeGetObjectSchemaInfo((long)osSchemaInfo.e, (String)string2));
                Property property = OsObjectSchemaInfo.nativeGetPrimaryKeyProperty((long)osObjectSchemaInfo.e) == 0L ? null : new Property(OsObjectSchemaInfo.nativeGetPrimaryKeyProperty((long)osObjectSchemaInfo.e));
                if (property != null) {
                    return (E)x2.p(e2, true, (Map)new HashMap(), Util.f((Object[])arrobject));
                }
                StringBuilder stringBuilder = c.b.a.a.a.c("A RealmObject with no @PrimaryKey cannot be updated: ");
                stringBuilder.append(class_.toString());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw null;
        }
        Object[] arrobject = new g.a.n[]{};
        return (E)x2.p(e2, false, (Map)new HashMap(), Util.f((Object[])arrobject));
    }

    public final boolean j(e0 e02) {
        block4 : {
            String string;
            block7 : {
                Table table;
                block3 : {
                    i0 i02;
                    block6 : {
                        String string2;
                        k0 k02;
                        block5 : {
                            block2 : {
                                a a2 = this.a;
                                if (!(a2 instanceof x)) break block2;
                                table = a2.h().b((Class)e02.getClass()).b;
                                break block3;
                            }
                            j j2 = (j)e02;
                            j2.a.c.c();
                            string = j2.a.b.k().b();
                            k02 = this.a.h();
                            if (k02 == null) break block4;
                            string2 = Table.g((String)string);
                            i02 = (i0)k02.d.get((Object)string2);
                            if (i02 == null) break block5;
                            Table table2 = i02.b;
                            long l2 = table2.e;
                            boolean bl = l2 != 0L && table2.nativeIsValid(l2);
                            if (bl && i02.b.b().equals((Object)string)) break block6;
                        }
                        if (!k02.e.i.hasTable(string2)) break block7;
                        a a3 = k02.e;
                        i02 = new l(a3, k02, a3.i.getTable(string2));
                        k02.d.put((Object)string2, (Object)i02);
                    }
                    table = i02.b;
                }
                return Table.nativeIsEmbedded((long)table.e);
            }
            throw new IllegalArgumentException(c.b.a.a.a.k("The class ", string, " doesn't exist in this Realm."));
        }
        throw null;
    }

    public final void k(e0 e02, long l2) {
        o o2 = this.a.g.j;
        Class class_ = Util.c((Class)e02.getClass());
        Table table = ((x)this.a).n.c(class_);
        e0 e03 = o2.j(class_, (Object)this.a, (p)UncheckedRow.w((h)table.f, (Table)table, (long)l2), this.a.h().a(class_), true, Collections.EMPTY_LIST);
        o2.l((x)this.a, e02, e03, (Map)new HashMap(), Collections.EMPTY_SET);
    }
}

