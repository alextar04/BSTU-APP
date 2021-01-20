/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.p0.t.a
 *  g.a.p0.t.b
 *  io.realm.RealmFieldType
 *  io.realm.internal.Table
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 *  java.util.regex.Pattern
 */
package g.a.p0.t;

import g.a.p0.t.b;
import io.realm.RealmFieldType;
import io.realm.internal.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class c {
    public static final Pattern g = Pattern.compile((String)"\\.");
    public static final Set<RealmFieldType> h;
    public static final Set<RealmFieldType> i;
    public static final Set<RealmFieldType> j;
    public final List<String> a;
    public final Set<RealmFieldType> b;
    public final Set<RealmFieldType> c;
    public String d;
    public RealmFieldType e;
    public long[] f;

    public static {
        HashSet hashSet = new HashSet(3);
        hashSet.add((Object)RealmFieldType.OBJECT);
        hashSet.add((Object)RealmFieldType.LIST);
        hashSet.add((Object)RealmFieldType.LINKING_OBJECTS);
        h = Collections.unmodifiableSet((Set)hashSet);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add((Object)RealmFieldType.OBJECT);
        hashSet2.add((Object)RealmFieldType.LIST);
        i = Collections.unmodifiableSet((Set)hashSet2);
        HashSet hashSet3 = new HashSet(1);
        hashSet3.add((Object)RealmFieldType.LIST);
        Collections.unmodifiableSet((Set)hashSet3);
        HashSet hashSet4 = new HashSet(1);
        hashSet4.add((Object)RealmFieldType.OBJECT);
        j = Collections.unmodifiableSet((Set)hashSet4);
        Collections.emptySet();
    }

    public c(String string, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        if (string != null && !string.equals((Object)"")) {
            int n2 = string.lastIndexOf(".");
            if (n2 != -1 + string.length()) {
                List list = n2 > -1 ? Arrays.asList((Object[])g.split((CharSequence)string)) : Collections.singletonList((Object)string);
                this.a = list;
                if (list.size() > 0) {
                    this.b = set;
                    this.c = set2;
                    return;
                }
                throw new IllegalArgumentException("Invalid query: Empty field descriptor");
            }
            throw new IllegalArgumentException("Invalid query: field name must not end with a period ('.')");
        }
        throw new IllegalArgumentException("Invalid query: field name is empty");
    }

    public static c c(a a2, Table table, String string, Set<RealmFieldType> set, Set<RealmFieldType> set2) {
        if (a2 != null && a2.a()) {
            String string2 = table.b();
            if (set == null) {
                set = h;
            }
            g.a.p0.t.a a3 = new g.a.p0.t.a(a2, string2, string, set, null);
            return a3;
        }
        if (set == null) {
            set = i;
        }
        return new b(table, string, set, null);
    }

    public abstract void a(List<String> var1);

    public final void b() {
        if (this.e == null) {
            this.a(this.a);
        }
    }

    public final void d(String string, String string2, RealmFieldType realmFieldType, long[] arrl, long[] arrl2) {
        Set<RealmFieldType> set = this.c;
        if (set != null && set.size() > 0) {
            this.e(string, string2, realmFieldType, this.c);
        }
        this.d = string2;
        this.e = realmFieldType;
        this.f = arrl;
    }

    public final void e(String string, String string2, RealmFieldType realmFieldType, Set<RealmFieldType> set) {
        if (set.contains((Object)realmFieldType)) {
            return;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{string2, string, realmFieldType.toString()};
        throw new IllegalArgumentException(String.format((Locale)locale, (String)"Invalid query: field '%s' in class '%s' is of invalid type '%s'.", (Object[])arrobject));
    }

    public static interface a {
        public boolean a();

        public g.a.p0.c b(String var1);

        public long c(String var1);
    }

}

