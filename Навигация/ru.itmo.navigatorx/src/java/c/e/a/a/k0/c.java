/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.transformation.FabTransformationBehavior
 */
package c.e.a.a.k0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.a.u.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class c
extends AnimatorListenerAdapter {
    public final /* synthetic */ c.e.a.a.u.c a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.e.a.a.u.c c2) {
        this.a = c2;
    }

    public void onAnimationEnd(Animator animator) {
        c.e e2 = this.a.getRevealInfo();
        e2.c = Float.MAX_VALUE;
        this.a.setRevealInfo(e2);
    }
}

