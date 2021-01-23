/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.x
 *  g.a.x$a
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.OsSharedRealm$InitializationCallback
 *  java.lang.Object
 */
package g.a;

import g.a.a;
import g.a.x;
import io.realm.internal.OsSharedRealm;

public class b
implements OsSharedRealm.InitializationCallback {
    public final /* synthetic */ x.a a;
    public final /* synthetic */ a b;

    public b(a a2, x.a a3) {
        this.b = a2;
        this.a = a3;
    }

    public void onInit(OsSharedRealm osSharedRealm) {
        x x2 = new x(osSharedRealm);
        this.a.a(x2);
    }
}

