/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.d
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package d.a;

import d.a.p;
import h.k.d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class h
extends p {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(h.class, (String)"_resumed");
    public volatile int _resumed;

    public h(d<?> d2, Throwable throwable, boolean bl) {
        if (throwable == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Continuation ");
            stringBuilder.append(d2);
            stringBuilder.append(" was cancelled normally");
            throwable = new CancellationException(stringBuilder.toString());
        }
        super(throwable, bl);
        this._resumed = 0;
    }
}

