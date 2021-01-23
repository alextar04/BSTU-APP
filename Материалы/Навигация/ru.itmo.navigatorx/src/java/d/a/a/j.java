/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.a;

import d.a.a.k;
import d.a.a.p;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class j<E> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, (String)"_cur");
    public volatile Object _cur;

    public j(boolean bl) {
        this._cur = new k(8, bl);
    }

    public final boolean a(E e2) {
        k k2;
        int n2;
        while ((n2 = (k2 = (k)this._cur).a(e2)) != 0) {
            if (n2 != 1) {
                if (n2 != 2) continue;
                return false;
            }
            a.compareAndSet((Object)this, (Object)k2, k2.d());
        }
        return true;
    }

    public final void b() {
        k k2;
        while (!(k2 = (k)this._cur).b()) {
            a.compareAndSet((Object)this, (Object)k2, k2.d());
        }
        return;
    }

    public final int c() {
        long l2 = ((k)this._cur)._state;
        int n2 = (int)((0x3FFFFFFFL & l2) >> 0);
        return 1073741823 & (int)((l2 & 1152921503533105152L) >> 30) - n2;
    }

    public final E d() {
        k k2;
        Object object;
        while ((object = (k2 = (k)this._cur).e()) == k.g) {
            a.compareAndSet((Object)this, (Object)k2, k2.d());
        }
        return (E)object;
    }
}

