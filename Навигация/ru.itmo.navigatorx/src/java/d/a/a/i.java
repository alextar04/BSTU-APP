/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package d.a.a;

import d.a.a.m;
import d.a.a.n;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class i {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"_next");
    public static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"_prev");
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final i a(m var1_1) {
        block0 : do {
            var3_3 = var2_2 = (i)this._prev;
            block1 : do {
                var4_4 = null;
                do {
                    if ((var5_5 = var3_3._next) == this) {
                        if (var2_2 == var3_3) {
                            return var3_3;
                        }
                        if (i.f.compareAndSet((Object)this, (Object)var2_2, (Object)var3_3) != false) return var3_3;
                        continue block0;
                    }
                    if (this.k()) {
                        return null;
                    }
                    if (var5_5 == null) {
                        return var3_3;
                    }
                    if (var5_5 instanceof m) {
                        ((m)var5_5).a(var3_3);
                        continue block0;
                    }
                    if (var5_5 instanceof n) {
                        if (var4_4 != null) {
                            if (i.e.compareAndSet((Object)var4_4, (Object)var3_3, (Object)((n)var5_5).a)) ** break;
                            continue block0;
                            var3_3 = var4_4;
                            continue block1;
                        }
                        var3_3 = (i)var3_3._prev;
                        continue;
                    }
                    if (var5_5 == null) throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    var6_6 = (i)var5_5;
                    var4_4 = var3_3;
                    var3_3 = var6_6;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }

    public final void g(i i2) {
        i i3;
        do {
            i3 = (i)i2._prev;
            if (this.h() == i2) continue;
            return;
        } while (!f.compareAndSet((Object)i2, (Object)i3, (Object)this));
        if (this.k()) {
            i2.a(null);
        }
    }

    public final Object h() {
        Object object;
        while ((object = this._next) instanceof m) {
            ((m)object).a(this);
        }
        return object;
    }

    public final i i() {
        i i2;
        Object object = this.h();
        Object object2 = !(object instanceof n) ? null : object;
        n n2 = (n)object2;
        if (n2 != null && (i2 = n2.a) != null) {
            return i2;
        }
        if (object != null) {
            return (i)object;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final i j() {
        i i2 = this.a(null);
        if (i2 != null) {
            return i2;
        }
        i i3 = (i)this._prev;
        while (i3.k()) {
            i3 = (i)i3._prev;
        }
        return i3;
    }

    public boolean k() {
        return this.h() instanceof n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)this)));
        return stringBuilder.toString();
    }
}

