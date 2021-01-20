/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  c.e.a.a.z.b
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$a
 */
package c.e.a.a.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.a.z.b;
import c.e.a.a.z.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class d
extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ e.f b;
    public final /* synthetic */ e c;

    public d(e e2, boolean bl, e.f f2) {
        this.c = e2;
        this.a = bl;
        this.b = f2;
    }

    public void onAnimationEnd(Animator animator) {
        e e2 = this.c;
        e2.p = 0;
        e2.k = null;
        e.f f2 = this.b;
        if (f2 != null) {
            b b2 = (b)f2;
            b2.a.b(b2.b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.t.b(0, this.a);
        e e2 = this.c;
        e2.p = 2;
        e2.k = animator;
    }
}

