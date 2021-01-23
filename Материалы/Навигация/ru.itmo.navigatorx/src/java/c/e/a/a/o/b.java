/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.bottomappbar.BottomAppBar
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$a
 */
package c.e.a.a.o;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class b
extends FloatingActionButton.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ BottomAppBar b;

    public b(BottomAppBar bottomAppBar, int n2) {
        this.b = bottomAppBar;
        this.a = n2;
    }

    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(BottomAppBar.w((BottomAppBar)this.b, (int)this.a));
        floatingActionButton.n(new FloatingActionButton.a(){

            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.v((BottomAppBar)b.this.b);
            }
        }, true);
    }

}

