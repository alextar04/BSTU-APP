/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.p0.r.a
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.RealmNotifier
 *  io.realm.internal.android.AndroidRealmNotifier
 *  io.realm.log.RealmLog
 *  io.realm.mongodb.AppException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.ThreadPoolExecutor
 */
package g.a.p0.x;

import g.a.p0.a;
import g.a.p0.x.b;
import g.a.q0.c;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.RealmNotifier;
import io.realm.internal.android.AndroidRealmNotifier;
import io.realm.log.RealmLog;
import io.realm.mongodb.AppException;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class d<T> {
    public final c.a<T> a;
    public final RealmNotifier b;
    public final ThreadPoolExecutor c;

    public d(ThreadPoolExecutor threadPoolExecutor, c.a<T> a2) {
        this.a = a2;
        this.b = new AndroidRealmNotifier(null, (a)new g.a.p0.r.a());
        this.c = threadPoolExecutor;
    }

    public static void a(d d2, AppException appException) {
        boolean bl;
        if (d2.a != null) {
            b b2 = new b(d2, appException);
            bl = d2.b.post((Runnable)b2);
        } else {
            bl = false;
        }
        if (!bl) {
            StringBuilder stringBuilder = c.b.a.a.a.c("An error was thrown, but could not be posted: \n");
            stringBuilder.append(appException.toString());
            RealmLog.d((int)6, (Throwable)appException, (String)stringBuilder.toString(), (Object[])new Object[0]);
        }
    }

    public abstract T b();
}

