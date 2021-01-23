/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.drawable.Drawable
 *  com.google.android.material.transformation.FabTransformationBehavior
 */
package c.e.a.a.k0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import c.e.a.a.u.c;
import com.google.android.material.transformation.FabTransformationBehavior;

public class b
extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;
    public final /* synthetic */ Drawable b;

    public b(FabTransformationBehavior fabTransformationBehavior, c c2, Drawable drawable) {
        this.a = c2;
        this.b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(this.b);
    }
}

