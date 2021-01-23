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

public class c
extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ e.f c;
    public final /* synthetic */ e d;

    public c(e e2, boolean bl, e.f f2) {
        this.d = e2;
        this.b = bl;
        this.c = f2;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e e2 = this.d;
        e2.p = 0;
        e2.k = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = e2.t;
            int n2 = this.b ? 8 : 4;
            floatingActionButton.b(n2, this.b);
            e.f f2 = this.c;
            if (f2 != null) {
                b b2 = (b)f2;
                b2.a.a(b2.b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.d.t.b(0, this.b);
        e e2 = this.d;
        e2.p = 1;
        e2.k = animator;
        this.a = false;
    }
}

