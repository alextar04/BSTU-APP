/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  h.h
 *  h.m.a.l
 *  h.m.b.j
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a.o.c;

import android.graphics.PointF;
import c.a.a.o.d.b;
import h.h;
import h.m.a.l;
import h.m.b.j;
import h.m.b.k;

public final class b
extends k
implements l<b.a, h> {
    public final /* synthetic */ float f;
    public final /* synthetic */ c.a.a.b g;
    public final /* synthetic */ PointF h;

    public b(float f2, c.a.a.b b2, PointF pointF) {
        this.f = f2;
        this.g = b2;
        this.h = pointF;
        super(1);
    }

    public Object f(Object object) {
        b.a a2 = (b.a)object;
        j.e((Object)a2, (String)"$receiver");
        a2.c(this.f, true);
        a2.a(this.g, true);
        Float f2 = Float.valueOf((float)this.h.x);
        Float f3 = Float.valueOf((float)this.h.y);
        a2.h = f2;
        a2.i = f3;
        return h.a;
    }
}

