/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package d.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class p {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(p.class, (String)"_handled");
    public volatile int _handled;
    public final Throwable a;

    public p(Throwable throwable, boolean bl) {
        this.a = throwable;
        this._handled = bl ? 1 : 0;
    }

    public p(Throwable throwable, boolean bl, int n2) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        this.a = throwable;
        this._handled = bl ? 1 : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append((Object)this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

