/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  c.e.a.a.i0.a
 *  com.google.android.material.textfield.TextInputLayout
 */
package c.e.a.a.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.e.a.a.i0.a;
import c.e.a.a.i0.m;
import com.google.android.material.textfield.TextInputLayout;

public class c
extends AnimatorListenerAdapter {
    public final /* synthetic */ a a;

    public c(a a2) {
        this.a = a2;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.setEndIconVisible(false);
    }
}

