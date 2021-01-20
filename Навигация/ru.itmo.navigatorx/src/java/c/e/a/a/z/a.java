/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 *  com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$c
 */
package c.e.a.a.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.a.z.i;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class a
extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ i b;
    public final /* synthetic */ ExtendedFloatingActionButton.c c;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, i i2) {
        this.b = i2;
        this.c = null;
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
        this.b.c();
    }

    public void onAnimationEnd(Animator animator) {
        this.b.b();
        if (!this.a) {
            this.b.e(null);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.b.onAnimationStart(animator);
        this.a = false;
    }
}

