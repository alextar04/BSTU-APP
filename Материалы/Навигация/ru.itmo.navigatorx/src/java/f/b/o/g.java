/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 *  f.b.o.g$a
 *  f.h.l.q
 *  f.h.l.r
 *  f.h.l.s
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package f.b.o;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import f.b.o.g;
import f.h.l.q;
import f.h.l.r;
import f.h.l.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class g {
    public final ArrayList<q> a = new ArrayList();
    public long b = -1L;
    public Interpolator c;
    public r d;
    public boolean e;
    public final s f = new a(this);

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((q)iterator.next()).b();
        }
        this.e = false;
    }

    public void b() {
        if (this.e) {
            return;
        }
        for (q q2 : this.a) {
            View view;
            Interpolator interpolator;
            View view2;
            long l2 = this.b;
            if (l2 >= 0L) {
                q2.c(l2);
            }
            if ((interpolator = this.c) != null && (view = (View)q2.a.get()) != null) {
                view.animate().setInterpolator((TimeInterpolator)interpolator);
            }
            if (this.d != null) {
                q2.d((r)this.f);
            }
            if ((view2 = (View)q2.a.get()) == null) continue;
            view2.animate().start();
        }
        this.e = true;
    }
}

