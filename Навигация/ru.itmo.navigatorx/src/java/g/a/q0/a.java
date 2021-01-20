/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.mongodb.User
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.Iterator
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package g.a.q0;

import g.a.q0.c;
import g.a.q0.e;
import io.realm.mongodb.User;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
implements Runnable {
    public final /* synthetic */ User e;
    public final /* synthetic */ c f;

    public a(c c2, User user) {
        this.f = c2;
        this.e = user;
    }

    public void run() {
        Iterator iterator = this.f.d.iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).a(this.e);
        }
    }
}

