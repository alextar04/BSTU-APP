/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  g.a.j
 *  g.a.x
 *  g.a.z$a
 *  g.a.z$d
 *  io.realm.internal.CheckedRow
 *  io.realm.internal.OsRealmConfig
 *  io.realm.internal.OsRealmConfig$b
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.OsSharedRealm$InitializationCallback
 *  io.realm.internal.OsSharedRealm$MigrationCallback
 *  io.realm.internal.OsSharedRealm$SchemaChangedCallback
 *  io.realm.internal.OsSharedRealm$a
 *  io.realm.internal.UncheckedRow
 *  io.realm.log.RealmLog
 *  java.io.Closeable
 *  java.io.File
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ThreadLocal
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package g.a;

import android.content.Context;
import g.a.a;
import g.a.b0;
import g.a.d0;
import g.a.e0;
import g.a.k0;
import g.a.p0.j;
import g.a.p0.o;
import g.a.p0.p;
import g.a.x;
import g.a.z;
import io.realm.internal.CheckedRow;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.UncheckedRow;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
implements Closeable {
    public static volatile Context l;
    public static final c m;
    public final boolean e;
    public final long f;
    public final b0 g;
    public z h;
    public OsSharedRealm i;
    public boolean j;
    public OsSharedRealm.SchemaChangedCallback k;

    public static {
        int n2 = g.a.p0.s.b.g;
        new g.a.p0.s.b(n2, n2);
        new g.a.p0.s.b(1, 1);
        m = new c();
    }

    public a(z z2, OsSchemaInfo osSchemaInfo, OsSharedRealm.a a2) {
        OsSharedRealm osSharedRealm;
        d0 d02;
        b0 b02 = z2.c;
        this.k = new OsSharedRealm.SchemaChangedCallback(this){
            public final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void onSchemaChanged() {
                k0 k02 = this.a.h();
                if (k02 != null) {
                    g.a.p0.b b2 = k02.f;
                    if (b2 != null) {
                        for (java.util.Map$Entry entry : b2.a.entrySet()) {
                            g.a.p0.c c2 = b2.b.c((Class<? extends e0>)((Class)entry.getKey()), b2.c);
                            ((g.a.p0.c)entry.getValue()).c(c2);
                        }
                    }
                    k02.a.clear();
                    k02.b.clear();
                    k02.c.clear();
                    k02.d.clear();
                }
            }
        };
        this.f = Thread.currentThread().getId();
        this.g = b02;
        this.h = null;
        g.a.c c2 = osSchemaInfo != null && (d02 = b02.g) != null ? new g.a.c(d02) : null;
        x.a a3 = b02.c();
        g.a.b b2 = null;
        if (a3 != null) {
            b2 = new g.a.b(this, a3);
        }
        OsRealmConfig.b b3 = new OsRealmConfig.b(b02);
        b3.f = new File(l.getFilesDir(), ".realm.temp").getAbsolutePath();
        b3.e = true;
        b3.c = c2;
        b3.b = osSchemaInfo;
        b3.d = b2;
        this.i = osSharedRealm = OsSharedRealm.getInstance((OsRealmConfig.b)b3, (OsSharedRealm.a)a2);
        this.e = osSharedRealm.isFrozen();
        this.j = true;
        this.i.registerSchemaChangedCallback(this.k);
        this.h = z2;
    }

    public a(OsSharedRealm osSharedRealm) {
        this.k = new /* invalid duplicate definition of identical inner class */;
        this.f = Thread.currentThread().getId();
        this.g = osSharedRealm.getConfiguration();
        this.h = null;
        this.i = osSharedRealm;
        this.e = osSharedRealm.isFrozen();
        this.j = false;
    }

    public void c() {
        OsSharedRealm osSharedRealm = this.i;
        if (osSharedRealm != null && !osSharedRealm.isClosed()) {
            if (!this.e) {
                if (this.f == Thread.currentThread().getId()) {
                    return;
                }
                throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
            }
            return;
        }
        throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close() {
        block14 : {
            block13 : {
                block12 : {
                    if (!this.e) {
                        if (this.f != Thread.currentThread().getId()) throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
                    }
                    if ((var1_1 = this.h) == null) {
                        this.h = null;
                        var2_19 = this.i;
                        if (var2_19 == null) return;
                        if (this.j == false) return;
                        var2_19.close();
                        this.i = null;
                        return;
                    }
                    var20_2 = var1_1;
                    // MONITORENTER : var20_2
                    var4_3 = this.g.c;
                    var5_4 = this.getClass();
                    var6_5 = this.j() != false ? this.i.getVersionID() : OsSharedRealm.a.g;
                    var7_6 = var1_1.d(var5_4, var6_5);
                    var8_7 = var7_6.c();
                    if (var8_7 <= 0) {
                        var9_8 = new Object[]{var4_3, var8_7};
                        RealmLog.e((String)"%s has been closed already. refCount is %s", (Object[])var9_8);
                        return;
                    }
                    var10_9 = var8_7 - 1;
                    if (var10_9 != 0) break block12;
                    var7_6.a();
                    this.h = null;
                    var11_10 = this.i;
                    if (var11_10 != null && this.j) {
                        var11_10.close();
                        this.i = null;
                    }
                    var12_11 = var1_1.a.values().iterator();
                    var13_12 = 0;
                    while (var12_11.hasNext()) {
                        var19_13 = (z.c)var12_11.next();
                        if (!(var19_13 instanceof z.d)) continue;
                        var13_12 += var19_13.b.get();
                    }
                    if (var13_12 != 0) break block13;
                    break block14;
                }
                var7_6.a.set((Object)var10_9);
            }
            // MONITOREXIT : var20_2
            return;
        }
        var1_1.c = null;
        var14_14 = var1_1.a.values().iterator();
        block4 : do lbl-1000: // 3 sources:
        {
            if (!var14_14.hasNext()) {
                j.getFacade(this.g.e()).realmClosed(this.g);
                return;
            }
            var15_15 = (z.c)var14_14.next();
            if (!(var15_15 instanceof z.a) || (var16_16 = var15_15.b()) == null) ** GOTO lbl-1000
            do {
                if (!var16_16.e) {
                    if (var16_16.f != Thread.currentThread().getId()) throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
                }
                var18_18 = (var17_17 = var16_16.i) == null || var17_17.isClosed();
                if (var18_18) continue block4;
                var16_16.close();
            } while (true);
            break;
        } while (true);
    }

    public <E extends e0> E f(Class<E> class_, String string, UncheckedRow uncheckedRow) {
        boolean bl = string != null;
        if (bl) {
            return (E)new g.a.j(this, (p)new CheckedRow(uncheckedRow));
        }
        return this.g.j.j(class_, this, (p)uncheckedRow, this.h().a(class_), false, (List<String>)Collections.emptyList());
    }

    public void finalize() {
        OsSharedRealm osSharedRealm;
        if (this.j && (osSharedRealm = this.i) != null && !osSharedRealm.isClosed()) {
            Object[] arrobject = new Object[]{this.g.c};
            RealmLog.e((String)"Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", (Object[])arrobject);
            z z2 = this.h;
            if (z2 != null && !z2.d.getAndSet(true)) {
                z.f.add((Object)z2);
            }
        }
        super.finalize();
    }

    public abstract k0 h();

    public boolean j() {
        OsSharedRealm osSharedRealm = this.i;
        if (osSharedRealm != null && !osSharedRealm.isClosed()) {
            return this.e;
        }
        throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
    }

    public boolean m() {
        this.c();
        return this.i.isInTransaction();
    }

    public static final class b {
        public a a;
        public p b;
        public g.a.p0.c c;
        public boolean d;
        public List<String> e;

        public void a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = false;
            this.e = null;
        }

        public void b(a a2, p p2, g.a.p0.c c2, boolean bl, List<String> list) {
            this.a = a2;
            this.b = p2;
            this.c = c2;
            this.d = bl;
            this.e = list;
        }
    }

    public static final class c
    extends ThreadLocal<b> {
        public Object initialValue() {
            return new b();
        }
    }

}

