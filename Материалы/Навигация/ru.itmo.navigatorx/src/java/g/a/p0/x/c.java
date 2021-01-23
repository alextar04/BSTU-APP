/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.mongodb.AppException
 *  java.lang.Object
 *  java.lang.Runnable
 */
package g.a.p0.x;

import g.a.p0.x.d;
import g.a.q0.c;
import io.realm.mongodb.AppException;

public class c
implements Runnable {
    public final /* synthetic */ Object e;
    public final /* synthetic */ d f;

    public c(d d2, Object object) {
        this.f = d2;
        this.e = object;
    }

    public void run() {
        c.a<Object> a2 = this.f.a;
        Object object = this.e;
        c.b<Object> b2 = object == null ? new c.b<Object>(null, null) : new c.b<Object>(object, null);
        a2.a(b2);
    }
}

