/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 *  b.a.a.b.a.b
 *  b.a.a.b.a.e$a
 *  b.a.a.b.a.e$b
 *  d.a.l1.d
 *  d.a.l1.i
 *  d.a.l1.j
 *  g.a.a
 *  g.a.b0
 *  g.a.d0
 *  g.a.e0
 *  g.a.i0
 *  g.a.j0
 *  g.a.k0
 *  g.a.p0.a
 *  g.a.p0.h
 *  g.a.p0.k
 *  g.a.p0.k$b
 *  g.a.p0.o
 *  g.a.p0.r.a
 *  g.a.p0.x.a
 *  g.a.p0.x.d
 *  g.a.q0.b
 *  g.a.q0.c
 *  g.a.q0.c$a
 *  g.a.q0.d
 *  g.a.q0.d$a
 *  g.a.q0.d$b
 *  g.a.q0.f
 *  g.a.q0.f$a
 *  g.a.q0.g.a.a
 *  g.a.q0.h.a
 *  g.a.q0.h.g
 *  g.a.q0.h.g$a
 *  g.a.q0.h.g$b
 *  g.a.t0.a
 *  g.a.t0.b
 *  g.a.v
 *  g.a.x
 *  g.a.x$a
 *  g.a.z
 *  h.i.h
 *  h.i.i
 *  h.m.b.j
 *  io.realm.CompactOnLaunchCallback
 *  io.realm.internal.ObservableCollection
 *  io.realm.internal.ObservableCollection$b
 *  io.realm.internal.OsRealmConfig
 *  io.realm.internal.OsRealmConfig$c
 *  io.realm.internal.OsRealmConfig$e
 *  io.realm.internal.OsResults
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.Table
 *  io.realm.internal.TableQuery
 *  io.realm.internal.Util
 *  io.realm.internal.core.DescriptorOrdering
 *  io.realm.internal.objectstore.OsAppCredentials
 *  io.realm.internal.objectstore.OsSyncUser
 *  io.realm.mongodb.User
 *  io.realm.mongodb.sync.Sync
 *  io.realm.mongodb.sync.SyncSession
 *  io.realm.mongodb.sync.SyncSession$b
 *  io.realm.mongodb.sync.SyncSession$c
 *  java.io.File
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.URI
 *  java.net.URL
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.Future
 *  java.util.concurrent.ThreadPoolExecutor
 *  k.a.k0
 *  k.a.w0.n1.d
 */
package b.a.a.b.a;

import android.os.Looper;
import android.util.Log;
import b.a.a.b.a.e;
import b.a.a.b.c;
import b.a.a.b.d;
import d.a.l1.i;
import d.a.l1.j;
import g.a.b0;
import g.a.d0;
import g.a.e0;
import g.a.i0;
import g.a.j0;
import g.a.p0.h;
import g.a.p0.k;
import g.a.p0.o;
import g.a.q0.c;
import g.a.q0.d;
import g.a.q0.f;
import g.a.q0.h.g;
import g.a.v;
import g.a.x;
import g.a.z;
import io.realm.CompactOnLaunchCallback;
import io.realm.internal.ObservableCollection;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsResults;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import io.realm.internal.Util;
import io.realm.internal.core.DescriptorOrdering;
import io.realm.internal.objectstore.OsAppCredentials;
import io.realm.internal.objectstore.OsSyncUser;
import io.realm.mongodb.User;
import io.realm.mongodb.sync.Sync;
import io.realm.mongodb.sync.SyncSession;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import k.a.k0;

public final class e {
    public final d.a.l1.d<c> a;
    public final i<c> b;
    public final g.a.q0.c c;
    public final b.a.a.b.a.a d;

    public e(String string, b.a.a.b.a.a a2) {
        g.a.q0.c c2;
        j j2;
        h.m.b.j.e((Object)string, (String)"realmAppId");
        h.m.b.j.e((Object)a2, (String)"realmMapper");
        this.d = a2;
        h.i.h h2 = h.i.h.e;
        h.i.i i2 = h.i.i.e;
        this.a = j2 = new j((Object)new c((List<? extends d>)h2, (Map<String, b.a.a.b.e>)i2, (Map<String, ? extends List<String>>)i2));
        this.b = j2;
        d.b b2 = new d.b(string);
        g.a.q0.d d2 = new g.a.q0.d(b2.a, null, null, b2.b, b2.c, b2.d, null, b2.e, null, b2.f, b2.g, b2.h, b2.i, null);
        this.c = c2 = new g.a.q0.c(d2);
        User user = c2.a();
        if (user == null) {
            g.a.q0.c c3 = this.c;
            f f2 = new f(new OsAppCredentials(OsAppCredentials.nativeCreate((int)1, (Object[])new Object[0])), f.a.f);
            a a3 = new a(this);
            if (c3 != null) {
                Looper looper = Looper.myLooper();
                String string2 = Thread.currentThread().getName();
                boolean bl = string2 != null && string2.startsWith("IntentService[");
                boolean bl2 = false;
                if (looper != null) {
                    bl2 = true;
                }
                if (bl2) {
                    if (!bl) {
                        g.a.q0.b b3 = new g.a.q0.b(c3, g.a.q0.c.f, (c.a)a3, f2);
                        b3.c.submit((Runnable)new g.a.p0.x.a((g.a.p0.x.d)b3));
                        return;
                    }
                    throw new IllegalStateException(c.b.a.a.a.k("Asynchronous log in is only possible from looper threads.", " ", "Realm cannot be automatically updated on an IntentService thread."));
                }
                throw new IllegalStateException(c.b.a.a.a.k("Asynchronous log in is only possible from looper threads.", " ", "Realm cannot be automatically updated on a thread without a looper."));
            }
            throw null;
        }
        this.a(user);
    }

    public final void a(User user) {
        g.b b2 = new g.b(user, "nav");
        if (b2.j != null && b2.k != null) {
            TableQuery tableQuery;
            if (b2.f && !b2.g) {
                throw new IllegalStateException("A read-only Realms must be provided by some source. 'waitForInitialRemoteData()' wasn't enabled which is currently the only supported source.");
            }
            if (b2.p == null) {
                b2.p = g.a.q0.h.a.g;
            }
            if (b2.d == null && Util.e()) {
                b2.d = new g.a.t0.a(true);
            }
            URI uRI = b2.j;
            Object[] arrobject = new Object[]{b2.k.b.b.a};
            b2.o = String.format((String)"/api/client/v2.0/app/%s/realm-sync", (Object[])arrobject);
            User user2 = b2.k;
            File file = new File(user2.b.c.getAbsolutePathForRealm(user2.a.a(), b2.s, null));
            g g2 = new g(file, null, null, b2.a, null, false, b2.e, b0.a((Set)b2.b, (Set)b2.c), b2.d, null, b2.f, b2.q, b2.r, false, b2.k, uRI, b2.l, b2.m, b2.i, b2.g, b2.h, b2.n, null, b2.o, b2.p, b2.s, null);
            x x2 = (x)z.b((b0)g2, x.class);
            h.m.b.j.d((Object)x2, (String)"realm");
            x2.c();
            DescriptorOrdering descriptorOrdering = new DescriptorOrdering();
            if (true ^ e0.class.isAssignableFrom(b.a.a.b.a.b.class)) {
                tableQuery = null;
            } else {
                Table table = x2.n.b(b.a.a.b.a.b.class).b;
                long l2 = table.nativeWhere(table.e);
                tableQuery = new TableQuery(table.f, table, l2);
            }
            x2.c();
            ((g.a.p0.r.a)x2.i.capabilities).b("Async query cannot be created on current thread.");
            j0 j02 = new j0((g.a.a)x2, OsResults.a((OsSharedRealm)x2.i, tableQuery, (DescriptorOrdering)descriptorOrdering), b.a.a.b.a.b.class);
            d.a.l1.d<c> d2 = this.a;
            b.a.a.b.a.a a2 = this.d;
            h.m.b.j.d((Object)j02, (String)"data");
            d2.setValue((Object)a2.a((List<? extends b.a.a.b.a.b>)j02));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("savedData: ");
            stringBuilder.append((Object)j02);
            Log.d((String)"RealmRepository", (String)stringBuilder.toString());
            b b3 = new b(this);
            j02.e.c();
            ((g.a.p0.r.a)j02.e.i.capabilities).b("Listeners cannot be used on current thread.");
            OsResults osResults = j02.h;
            if (osResults.k.c()) {
                osResults.nativeStartListening(osResults.e);
            }
            ObservableCollection.b b4 = new ObservableCollection.b((Object)j02, (Object)b3);
            osResults.k.a((k.b)b4);
            return;
        }
        throw new IllegalStateException("serverUrl() and user() are both required.");
    }
}

