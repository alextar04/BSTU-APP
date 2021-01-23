/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.bottomappbar.BottomAppBar
 */
package c.e.a.a.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

public class c
extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public c(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.v((BottomAppBar)this.a);
        this.a.S = null;
    }

    public void onAnimationStart(Animator animator) {
        BottomAppBar bottomAppBar = this.a;
        bottomAppBar.W = 1 + bottomAppBar.W;
    }
}

