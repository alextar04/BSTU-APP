/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.NativeObjectReference
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.ReferenceQueue
 */
package g.a.p0;

import g.a.p0.e;
import g.a.p0.i;
import io.realm.internal.NativeObjectReference;
import java.lang.ref.ReferenceQueue;

public class h {
    public static final ReferenceQueue<i> a = new ReferenceQueue();
    public static final Thread b = new Thread((Runnable)new e(a));
    public static final h c = new h();

    public static {
        b.setName("RealmFinalizingDaemon");
        b.start();
    }

    public void a(i i2) {
        new NativeObjectReference(this, i2, a);
    }
}

