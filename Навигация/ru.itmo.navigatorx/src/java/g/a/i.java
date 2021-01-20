/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  g.a.a
 *  g.a.b0
 *  g.a.i$a
 *  g.a.k0
 *  g.a.q
 *  g.a.z
 *  io.realm.internal.OsSchemaInfo
 *  io.realm.internal.OsSharedRealm
 *  io.realm.internal.OsSharedRealm$a
 *  java.lang.String
 *  java.util.List
 */
package g.a;

import g.a.b0;
import g.a.i;
import g.a.k0;
import g.a.q;
import g.a.z;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import java.util.List;

public class i
extends g.a.a {
    public final k0 n;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public i(z z2, OsSharedRealm.a a2) {
        List list;
        super(z2, null, a2);
        b0 b02 = z2.c;
        a a3 = new a(this, z2);
        List list2 = list = z.e;
        synchronized (list2) {
            z z3 = z.c((String)b02.c, (boolean)false);
            if (z3 == null) {
                a3.a(0);
            } else {
                z z4 = z3;
                synchronized (z4) {
                    a3.a(z3.e());
                }
            }
        }
        this.n = new q((g.a.a)this);
    }

    public i(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.n = new q((g.a.a)this);
    }

    public k0 h() {
        return this.n;
    }
}

