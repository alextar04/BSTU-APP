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

public class b
implements Runnable {
    public final /* synthetic */ AppException e;
    public final /* synthetic */ d f;

    public b(d d2, AppException appException) {
        this.f = d2;
        this.e = appException;
    }

    public void run() {
        this.f.a.a(new c.b<Object>(null, this.e));
    }
}

