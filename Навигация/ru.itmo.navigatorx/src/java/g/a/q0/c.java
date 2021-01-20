/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  edu.umd.cs.findbugs.annotations.SuppressFBWarnings
 *  g.a.q0.c$c
 *  g.a.x
 *  io.realm.internal.KeepMember
 *  io.realm.internal.Util
 *  io.realm.internal.objectstore.OsApp
 *  io.realm.internal.objectstore.OsSyncUser
 *  io.realm.log.RealmLog
 *  io.realm.mongodb.AppException
 *  io.realm.mongodb.User
 *  io.realm.mongodb.sync.Sync
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.ThreadPoolExecutor
 */
package g.a.q0;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import g.a.q0.c;
import g.a.q0.d;
import g.a.q0.e;
import g.a.x;
import io.realm.internal.KeepMember;
import io.realm.internal.Util;
import io.realm.internal.objectstore.OsApp;
import io.realm.internal.objectstore.OsSyncUser;
import io.realm.log.RealmLog;
import io.realm.mongodb.AppException;
import io.realm.mongodb.User;
import io.realm.mongodb.sync.Sync;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * Exception performing whole class analysis.
 */
public class c {
    @SuppressFBWarnings(value={"MS_SHOULD_BE_FINAL"})
    public static ThreadPoolExecutor f;
    @KeepMember
    public final OsApp a;
    public final d b;
    public final Sync c;
    public CopyOnWriteArrayList<e> d;
    public Handler e;

    public static {
        int n2 = g.a.p0.s.b.g;
        f = new g.a.p0.s.b(n2, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c(d d2) {
        Context context;
        String string;
        this.d = new CopyOnWriteArrayList();
        this.e = new Handler(Looper.getMainLooper());
        this.b = d2;
        String string2 = "Unknown";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RealmJava/");
            stringBuilder.append("10.0.0");
            stringBuilder.append(" (");
            String string3 = Util.d((String)Build.DEVICE) ? "unknown-device" : Build.DEVICE;
            stringBuilder.append(string3);
            stringBuilder.append(", ");
            String string4 = Util.d((String)Build.MODEL) ? "unknown-model" : Build.MODEL;
            stringBuilder.append(string4);
            stringBuilder.append(", v");
            stringBuilder.append(Build.VERSION.SDK_INT);
            stringBuilder.append(")");
            string = stringBuilder.toString();
        }
        catch (Exception exception) {
            RealmLog.e((String)"Constructing User-Agent description failed.", (Object[])new Object[]{exception});
            string = string2;
        }
        try {
            String string5 = d2.b;
            String string6 = d2.c;
            if (!Util.d((String)string5) || !Util.d((String)string6)) {
                StringBuilder stringBuilder = new StringBuilder();
                boolean bl = Util.d((String)string5);
                String string7 = bl ? "Undefined" : string5;
                stringBuilder.append(string7);
                stringBuilder.append('/');
                if (Util.d((String)string5)) {
                    string6 = "Undefined";
                }
                stringBuilder.append(string6);
                string2 = stringBuilder.toString();
            }
        }
        catch (Exception exception) {
            RealmLog.e((String)"Constructing Binding User-Agent description failed.", (Object[])new Object[]{exception});
        }
        if ((context = x.s()) != null) {
            this.a = new OsApp(d2, string, string2, context.getFilesDir().getPath());
            this.c = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        throw new IllegalStateException("Call Realm.init() first.");
    }

    public User a() {
        Long l2 = OsApp.nativeCurrentUser((long)this.a.f);
        OsSyncUser osSyncUser = l2 != null ? new OsSyncUser(l2.longValue()) : null;
        User user = null;
        if (osSyncUser != null) {
            user = new User(osSyncUser, this);
        }
        return user;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (c.class != object.getClass()) {
                return false;
            }
            c c2 = (c)object;
            if (!this.a.equals((Object)c2.a)) {
                return false;
            }
            return this.b.equals(c2.b);
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + this.b.hashCode();
    }

    public static interface a<T> {
        public void a(b<T> var1);
    }

    public static class b<T> {
        public T a;

        public b(T t2, AppException appException) {
            this.a = t2;
        }
    }

}

