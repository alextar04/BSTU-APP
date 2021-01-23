/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.d
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.f$b
 *  h.m.b.j
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package d.a;

import d.a.a.a;
import d.a.a.e;
import d.a.m1.h;
import d.a.m1.i;
import d.a.p;
import d.a.r0;
import d.a.z;
import f.b.k.h;
import h.k.d;
import h.k.f;
import h.m.b.j;
import java.util.concurrent.CancellationException;

public abstract class b0<T>
extends h {
    public int g;

    public b0(int n2) {
        this.g = n2;
    }

    public void a(Object object, Throwable throwable) {
    }

    public abstract d<T> b();

    public Throwable c(Object object) {
        if (!(object instanceof p)) {
            object = null;
        }
        p p2 = (p)object;
        Throwable throwable = null;
        if (p2 != null) {
            throwable = p2.a;
        }
        return throwable;
    }

    public <T> T f(Object object) {
        return (T)object;
    }

    public final void g(Throwable throwable, Throwable throwable2) {
        if (throwable == null && throwable2 == null) {
            return;
        }
        if (throwable != null && throwable2 != null) {
            h.i.a(throwable, throwable2);
        }
        if (throwable == null) {
            throwable = throwable2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fatal exception in coroutines machinery for ");
        stringBuilder.append((Object)this);
        stringBuilder.append(". ");
        stringBuilder.append("Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
        String string = stringBuilder.toString();
        j.c((Object)throwable);
        z z2 = new z(string, throwable);
        h.i.y0(this.b().d(), (Throwable)z2);
    }

    public abstract Object h();

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void run() {
        Object object2;
        Object object;
        i i2 = this.f;
        d<T> d2 = this.b();
        if (d2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        e e2 = (e)d2;
        d<T> d3 = e2.l;
        f f2 = d3.d();
        Object object3 = this.h();
        Object object4 = a.c(f2, e2.j);
        {
            catch (Throwable throwable) {
                Object object5;
                try {
                    i2.K();
                    object5 = h.h.a;
                }
                catch (Throwable throwable2) {
                    object5 = h.i.K(throwable2);
                }
                this.g(throwable, h.d.a((Object)object5));
                return;
            }
        }
        Throwable throwable = this.c(object3);
        r0 r02 = throwable == null && h.i.E0(this.g) ? (r0)f2.get((f.b)r0.d) : null;
        if (r02 != null && !r02.c()) {
            CancellationException cancellationException = r02.m();
            this.a(object3, (Throwable)cancellationException);
            object = h.i.K((Throwable)cancellationException);
        } else {
            object = throwable != null ? h.i.K(throwable) : this.f(object3);
        }
        d3.e(object);
        a.a(f2, object4);
        try {
            i2.K();
            object2 = h.h.a;
        }
        catch (Throwable throwable3) {
            object2 = h.i.K(throwable3);
        }
        this.g(null, h.d.a((Object)object2));
        return;
        catch (Throwable throwable4) {
            a.a(f2, object4);
            throw throwable4;
        }
    }
}

