/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.p0.w.a
 *  g.a.p0.w.b
 *  g.a.x
 *  io.realm.CompactOnLaunchCallback
 *  io.realm.exceptions.RealmException
 *  io.realm.internal.OsRealmConfig
 *  io.realm.internal.OsRealmConfig$c
 *  java.io.File
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.ExceptionInInitializerError
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Set
 */
package g.a;

import g.a.d0;
import g.a.e0;
import g.a.p0.o;
import g.a.p0.w.a;
import g.a.p0.w.b;
import g.a.x;
import io.realm.CompactOnLaunchCallback;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsRealmConfig;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class b0 {
    public static final Object q;
    public static final o r;
    public final File a;
    public final String b;
    public final String c;
    public final String d;
    public final byte[] e;
    public final long f;
    public final d0 g;
    public final boolean h;
    public final OsRealmConfig.c i;
    public final o j;
    public final g.a.t0.b k;
    public final x.a l;
    public final boolean m;
    public final CompactOnLaunchCallback n;
    public final long o;
    public final boolean p;

    public static {
        o o2;
        Object object;
        q = object = x.u();
        if (object != null) {
            o2 = b0.d(object.getClass().getCanonicalName());
            if (!o2.k()) {
                throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
            }
        } else {
            o2 = null;
        }
        r = o2;
    }

    public b0(File file, String string, byte[] arrby, long l2, d0 d02, boolean bl, OsRealmConfig.c c2, o o2, g.a.t0.b b2, x.a a2, boolean bl2, CompactOnLaunchCallback compactOnLaunchCallback, boolean bl3, long l3, boolean bl4, boolean bl5) {
        this.a = file.getParentFile();
        this.b = file.getName();
        this.c = file.getAbsolutePath();
        this.d = string;
        this.e = arrby;
        this.f = l2;
        this.g = d02;
        this.h = bl;
        this.i = c2;
        this.j = o2;
        this.k = b2;
        this.l = a2;
        this.m = bl2;
        this.n = compactOnLaunchCallback;
        this.p = bl3;
        this.o = l3;
    }

    public static o a(Set<Object> set, Set<Class<? extends e0>> set2) {
        if (set2.size() > 0) {
            return new b(r, set2);
        }
        if (set.size() == 1) {
            return b0.d(set.iterator().next().getClass().getCanonicalName());
        }
        o[] arro = new o[set.size()];
        int n2 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            arro[n2] = b0.d(iterator.next().getClass().getCanonicalName());
            ++n2;
        }
        return new a(arro);
    }

    public static o d(String string) {
        String[] arrstring = string.split("\\.");
        String string2 = arrstring[arrstring.length - 1];
        String string3 = String.format((Locale)Locale.US, (String)"io.realm.%s%s", (Object[])new Object[]{string2, "Mediator"});
        try {
            Constructor constructor = Class.forName((String)string3).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            o o2 = (o)constructor.newInstance(new Object[0]);
            return o2;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RealmException(c.b.a.a.a.j("Could not create an instance of ", string3), (Throwable)illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new RealmException(c.b.a.a.a.j("Could not create an instance of ", string3), (Throwable)instantiationException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RealmException(c.b.a.a.a.j("Could not create an instance of ", string3), (Throwable)invocationTargetException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RealmException(c.b.a.a.a.j("Could not find ", string3), (Throwable)classNotFoundException);
        }
    }

    public byte[] b() {
        byte[] arrby = this.e;
        if (arrby == null) {
            return null;
        }
        return Arrays.copyOf((byte[])arrby, (int)arrby.length);
    }

    public x.a c() {
        return this.l;
    }

    public boolean e() {
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            b0 b02 = (b0)object;
            if (this.f != b02.f) {
                return false;
            }
            if (this.h != b02.h) {
                return false;
            }
            if (this.m != b02.m) {
                return false;
            }
            if (this.p != b02.p) {
                return false;
            }
            File file = this.a;
            if (file != null ? !file.equals((Object)b02.a) : b02.a != null) {
                return false;
            }
            String string = this.b;
            if (string != null ? !string.equals((Object)b02.b) : b02.b != null) {
                return false;
            }
            if (!this.c.equals((Object)b02.c)) {
                return false;
            }
            String string2 = this.d;
            if (string2 != null ? !string2.equals((Object)b02.d) : b02.d != null) {
                return false;
            }
            if (!Arrays.equals((byte[])this.e, (byte[])b02.e)) {
                return false;
            }
            d0 d02 = this.g;
            if (d02 != null ? !d02.equals((Object)b02.g) : b02.g != null) {
                return false;
            }
            if (this.i != b02.i) {
                return false;
            }
            if (!this.j.equals(b02.j)) {
                return false;
            }
            g.a.t0.b b2 = this.k;
            if (b2 != null ? !b2.equals((Object)b02.k) : b02.k != null) {
                return false;
            }
            x.a a2 = this.l;
            if (a2 != null ? !a2.equals((Object)b02.l) : b02.l != null) {
                return false;
            }
            CompactOnLaunchCallback compactOnLaunchCallback = this.n;
            if (compactOnLaunchCallback != null ? !compactOnLaunchCallback.equals((Object)b02.n) : b02.n != null) {
                return false;
            }
            return this.o == b02.o;
        }
        return false;
    }

    public boolean f() {
        return new File(this.c).exists();
    }

    public int hashCode() {
        File file = this.a;
        int n2 = file != null ? file.hashCode() : 0;
        int n3 = n2 * 31;
        String string = this.b;
        int n4 = string != null ? string.hashCode() : 0;
        int n5 = 31 * (31 * (n3 + n4) + this.c.hashCode());
        String string2 = this.d;
        int n6 = string2 != null ? string2.hashCode() : 0;
        int n7 = 31 * (31 * (n5 + n6) + Arrays.hashCode((byte[])this.e));
        long l2 = this.f;
        int n8 = 31 * (n7 + (int)(l2 ^ l2 >>> 32));
        d0 d02 = this.g;
        int n9 = d02 != null ? d02.hashCode() : 0;
        int n10 = 31 * (31 * (31 * (31 * (n8 + n9) + this.h) + this.i.hashCode()) + this.j.hashCode());
        g.a.t0.b b2 = this.k;
        int n11 = b2 != null ? b2.hashCode() : 0;
        int n12 = 31 * (n10 + n11);
        x.a a2 = this.l;
        int n13 = a2 != null ? a2.hashCode() : 0;
        int n14 = 31 * (31 * (n12 + n13) + this.m);
        CompactOnLaunchCallback compactOnLaunchCallback = this.n;
        int n15 = 0;
        if (compactOnLaunchCallback != null) {
            n15 = compactOnLaunchCallback.hashCode();
        }
        int n16 = 31 * (31 * (n14 + n15) + this.p);
        long l3 = this.o;
        return n16 + (int)(l3 ^ l3 >>> 32);
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("realmDirectory: ");
        File file = this.a;
        String string = file != null ? file.toString() : "";
        stringBuilder.append(string);
        stringBuilder.append("\n");
        stringBuilder.append("realmFileName : ");
        stringBuilder.append(this.b);
        stringBuilder.append("\n");
        stringBuilder.append("canonicalPath: ");
        stringBuilder.append(this.c);
        stringBuilder.append("\n");
        stringBuilder.append("key: ");
        stringBuilder.append("[length: ");
        int n2 = this.e == null ? 0 : 64;
        stringBuilder.append(n2);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        stringBuilder.append("schemaVersion: ");
        stringBuilder.append(Long.toString((long)this.f));
        stringBuilder.append("\n");
        stringBuilder.append("migration: ");
        stringBuilder.append((Object)this.g);
        stringBuilder.append("\n");
        stringBuilder.append("deleteRealmIfMigrationNeeded: ");
        stringBuilder.append(this.h);
        stringBuilder.append("\n");
        stringBuilder.append("durability: ");
        stringBuilder.append((Object)this.i);
        stringBuilder.append("\n");
        stringBuilder.append("schemaMediator: ");
        stringBuilder.append((Object)this.j);
        stringBuilder.append("\n");
        stringBuilder.append("readOnly: ");
        stringBuilder.append(this.m);
        stringBuilder.append("\n");
        stringBuilder.append("compactOnLaunch: ");
        stringBuilder.append((Object)this.n);
        stringBuilder.append("\n");
        stringBuilder.append("maxNumberOfActiveVersions: ");
        stringBuilder.append(this.o);
        return stringBuilder.toString();
    }
}

