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
import android.graphics.PointF;
import c.a.a.o.d.b;
import h.h;
import h.m.a.l;
import h.m.b.j;
import h.m.b.k;

public final class e
extends k
implements l<b.a, h> {
    public final /* synthetic */ int f;
    public final /* synthetic */ float g;
    public final /* synthetic */ Object h;

    public e(int n2, float f2, Object object) {
        this.f = n2;
        this.g = f2;
        this.h = object;
        super(1);
    }

    public final Object f(Object object) {
        int n2 = this.f;
        if (n2 != 0) {
            if (n2 == 1) {
                b.a a2 = (b.a)object;
                j.e((Object)a2, (String)"$receiver");
                a2.c(this.g, true);
                a2.a((c.a.a.b)this.h, true);
                a2.j = false;
                return h.a;
            }
            throw null;
        }
        b.a a3 = (b.a)object;
        j.e((Object)a3, (String)"$receiver");
        a3.c(this.g, true);
        Float f2 = Float.valueOf((float)((PointF)this.h).x);
        Float f3 = Float.valueOf((float)((PointF)this.h).y);
        a3.h = f2;
        a3.i = f3;
        a3.g = true;
        a3.j = false;
        return h.a;
    }
}

