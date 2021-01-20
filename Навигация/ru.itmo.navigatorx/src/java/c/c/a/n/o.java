/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.fragment.app.Fragment
 *  c.c.a.i
 *  c.c.a.n.a
 *  c.c.a.n.o$a
 *  f.l.d.r
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Set
 */
package c.c.a.n;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import c.c.a.b;
import c.c.a.i;
import c.c.a.n.l;
import c.c.a.n.m;
import c.c.a.n.o;
import f.l.d.r;
import java.util.HashSet;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public class o
extends Fragment {
    public final c.c.a.n.a Z;
    public final m a0;
    public final Set<o> b0;
    public o c0;
    public i d0;
    public Fragment e0;

    public o() {
        c.c.a.n.a a2 = new c.c.a.n.a();
        this.a0 = new /* Unavailable Anonymous Inner Class!! */;
        this.b0 = new HashSet();
        this.Z = a2;
    }

    public void J(Context context) {
        Fragment fragment;
        super.J(context);
        o o2 = this;
        while ((fragment = o2.y) != null) {
            o2 = fragment;
        }
        r r2 = o2.v;
        if (r2 == null) {
            if (Log.isLoggable((String)"SupportRMFragment", (int)5)) {
                Log.w((String)"SupportRMFragment", (String)"Unable to register fragment with root, ancestor detached");
            }
            return;
        }
        try {
            this.x0(this.o(), r2);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            if (Log.isLoggable((String)"SupportRMFragment", (int)5)) {
                Log.w((String)"SupportRMFragment", (String)"Unable to register fragment with root", (Throwable)illegalStateException);
            }
            return;
        }
    }

    public void Q() {
        this.H = true;
        this.Z.c();
        this.y0();
    }

    public void S() {
        this.H = true;
        this.e0 = null;
        this.y0();
    }

    public void c0() {
        this.H = true;
        this.Z.d();
    }

    public void d0() {
        this.H = true;
        this.Z.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        stringBuilder.append((Object)this.w0());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final Fragment w0() {
        Fragment fragment = this.y;
        if (fragment != null) {
            return fragment;
        }
        return this.e0;
    }

    public final void x0(Context context, r r2) {
        this.y0();
        l l2 = b.b((Context)context).j;
        if (l2 != null) {
            o o2;
            this.c0 = o2 = l2.d(r2, null, l.e(context));
            if (!this.equals((Object)o2)) {
                this.c0.b0.add((Object)this);
            }
            return;
        }
        throw null;
    }

    public final void y0() {
        o o2 = this.c0;
        if (o2 != null) {
            o2.b0.remove((Object)this);
            this.c0 = null;
        }
    }
}

