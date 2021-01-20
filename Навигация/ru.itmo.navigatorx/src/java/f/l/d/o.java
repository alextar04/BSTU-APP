/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  f.l.d.e
 *  f.l.d.k
 *  f.l.d.r
 *  java.lang.Object
 */
package f.l.d;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import f.b.k.h;
import f.l.d.e;
import f.l.d.k;
import f.l.d.r;
import f.l.d.t;

public abstract class o<E>
extends k {
    public final Activity e;
    public final Context f;
    public final Handler g;
    public final r h;

    public o(e e2) {
        Handler handler = new Handler();
        this.h = new t();
        this.e = e2;
        h.i.o(e2, "context == null");
        this.f = e2;
        h.i.o(handler, "handler == null");
        this.g = handler;
    }
}

