/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.util.Log
 *  c.c.a.i
 *  c.c.a.n.a
 *  c.c.a.n.k$a
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Set
 */
package c.c.a.n;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.util.Log;
import c.c.a.b;
import c.c.a.i;
import c.c.a.n.k;
import c.c.a.n.l;
import c.c.a.n.m;
import java.util.HashSet;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
@Deprecated
public class k
extends Fragment {
    public final c.c.a.n.a e;
    public final m f;
    public final Set<k> g;
    public i h;
    public k i;
    public Fragment j;

    public k() {
        c.c.a.n.a a2 = new c.c.a.n.a();
        this.f = new /* Unavailable Anonymous Inner Class!! */;
        this.g = new HashSet();
        this.e = a2;
    }

    public final void a(Activity activity) {
        this.b();
        l l2 = b.b((Context)activity).j;
        if (l2 != null) {
            k k2;
            this.i = k2 = l2.c(activity.getFragmentManager(), null, l.e((Context)activity));
            if (!this.equals((Object)k2)) {
                this.i.g.add((Object)this);
            }
            return;
        }
        throw null;
    }

    public final void b() {
        k k2 = this.i;
        if (k2 != null) {
            k2.g.remove((Object)this);
            this.i = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.a(activity);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            if (Log.isLoggable((String)"RMFragment", (int)5)) {
                Log.w((String)"RMFragment", (String)"Unable to register fragment with root", (Throwable)illegalStateException);
            }
            return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.e.c();
        this.b();
    }

    public void onDetach() {
        super.onDetach();
        this.b();
    }

    public void onStart() {
        super.onStart();
        this.e.d();
    }

    public void onStop() {
        super.onStop();
        this.e.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{parent=");
        Fragment fragment = this.getParentFragment();
        if (fragment == null) {
            fragment = this.j;
        }
        stringBuilder.append((Object)fragment);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

