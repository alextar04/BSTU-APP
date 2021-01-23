/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.google.android.material.bottomappbar.BottomAppBar
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 */
package c.e.a.a.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class e
extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public e(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        this.a.c0.onAnimationStart(animator);
        FloatingActionButton floatingActionButton = this.a.B();
        if (floatingActionButton != null) {
            floatingActionButton.setTranslationX(BottomAppBar.y((BottomAppBar)this.a));
        }
    }
}

