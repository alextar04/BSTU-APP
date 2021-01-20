/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.d0
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.OsSharedRealm$MigrationCallback
 *  java.lang.Object
 */
package g.a;

import g.a.d0;
import g.a.i;
import io.realm.internal.OsSharedRealm;

public class c
implements OsSharedRealm.MigrationCallback {
    public final /* synthetic */ d0 a;

    public c(d0 d02) {
        this.a = d02;
    }

    public void onMigrationNeeded(OsSharedRealm osSharedRealm, long l2, long l3) {
        this.a.a(new i(osSharedRealm), l2, l3);
    }
}

