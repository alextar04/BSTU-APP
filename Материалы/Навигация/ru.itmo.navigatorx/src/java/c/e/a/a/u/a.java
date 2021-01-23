/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package c.e.a.a.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.a.u.c;

public final class a
extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;

    public a(c c2) {
        this.a = c2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.a.a();
    }
}

