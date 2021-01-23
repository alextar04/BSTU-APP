/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  c.e.a.a.f0.g
 *  com.google.android.material.appbar.AppBarLayout
 *  java.lang.Float
 *  java.lang.Object
 */
package c.e.a.a.m;

import android.animation.ValueAnimator;
import c.e.a.a.f0.g;
import com.google.android.material.appbar.AppBarLayout;

public class a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public a(AppBarLayout appBarLayout, g g2) {
        this.a = g2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.p(((Float)valueAnimator.getAnimatedValue()).floatValue());
    }
}

