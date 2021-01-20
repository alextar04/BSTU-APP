/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.d
 *  h.k.f
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package d.a;

import d.a.p;
import d.a.r0;
import d.a.t;
import d.a.v0;
import d.a.w0;
import d.a.x;
import f.b.k.h;
import h.k.d;
import h.k.f;

public abstract class b<T>
extends v0
implements r0,
d<T>,
x {
    public final f f;
    public final f g;

    public b(f f2, boolean bl) {
        super(bl);
        this.g = f2;
        this.f = f2.plus((f)this);
    }

    @Override
    public final void A(Throwable throwable) {
        h.i.y0(this.f, throwable);
    }

    @Override
    public String F() {
        t.a(this.f);
        return super.F();
    }

    @Override
    public final void I(Object object) {
        if (object instanceof p) {
            p p2 = (p)object;
        }
    }

    @Override
    public final void K() {
        this.R();
    }

    public void Q(Object object) {
        this.b(object);
    }

    public void R() {
    }

    @Override
    public boolean c() {
        return super.c();
    }

    public final f d() {
        return this.f;
    }

    public final void e(Object object) {
        Object object2;
        Object object3 = h.i.S1(object, null);
        do {
            if ((object2 = this.O(this.y(), object3)) != w0.a) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Job ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" is already complete or completing, ");
            stringBuilder.append("but is being completed with ");
            stringBuilder.append(object3);
            String string = stringBuilder.toString();
            if (!(object3 instanceof p)) {
                object3 = null;
            }
            p p2 = (p)object3;
            Throwable throwable = null;
            if (p2 != null) {
                throwable = p2.a;
            }
            throw new IllegalStateException(string, throwable);
        } while (object2 == w0.c);
        if (object2 == w0.b) {
            return;
        }
        this.Q(object2);
    }

    @Override
    public String k() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" was cancelled");
        return stringBuilder.toString();
    }

    @Override
    public f s() {
        return this.f;
    }
}

