/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 */
package f.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import f.r.i;

public class k
extends AnimatorListenerAdapter {
    public final /* synthetic */ i a;

    public k(i i2) {
        this.a = i2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.n();
        animator.removeListener((Animator.AnimatorListener)this);
    }
}

