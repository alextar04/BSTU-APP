/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  java.lang.Object
 *  java.util.ArrayList
 */
package c.e.a.a.a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class g {
    public final ArrayList<b> a = new ArrayList();
    public b b = null;
    public ValueAnimator c = null;
    public final Animator.AnimatorListener d = new AnimatorListenerAdapter(){

        public void onAnimationEnd(Animator animator) {
            g g2 = g.this;
            if (g2.c == animator) {
                g2.c = null;
            }
        }
    };

    public void a(int[] arrn, ValueAnimator valueAnimator) {
        b b2 = new b(arrn, valueAnimator);
        valueAnimator.addListener(this.d);
        this.a.add((Object)b2);
    }

    public static class b {
        public final int[] a;
        public final ValueAnimator b;

        public b(int[] arrn, ValueAnimator valueAnimator) {
            this.a = arrn;
            this.b = valueAnimator;
        }
    }

}

