/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  c.e.a.a.i0.h
 *  com.google.android.material.internal.CheckableImageButton
 */
package c.e.a.a.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import c.e.a.a.i0.h;
import c.e.a.a.i0.m;
import com.google.android.material.internal.CheckableImageButton;

public class l
extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public l(h h2) {
        this.a = h2;
    }

    public void onAnimationEnd(Animator animator) {
        h h2 = this.a;
        h2.c.setChecked(h2.j);
        this.a.p.start();
    }
}

