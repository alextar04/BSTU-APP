/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.behavior.SwipeDismissBehavior
 *  com.google.android.material.behavior.SwipeDismissBehavior$b
 *  f.h.l.l
 *  f.h.l.v.d
 *  f.h.l.v.d$a
 *  java.lang.Object
 */
package c.e.a.a.n;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f.h.l.l;
import f.h.l.v.d;

public class a
implements d {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    public boolean a(View view, d.a a2) {
        block5 : {
            boolean bl;
            block7 : {
                block6 : {
                    if (!this.a.B(view)) break block5;
                    boolean bl2 = l.n((View)view) == 1;
                    if (this.a.e == 0 && bl2) break block6;
                    int n2 = this.a.e;
                    bl = false;
                    if (n2 != 1) break block7;
                    bl = false;
                    if (bl2) break block7;
                }
                bl = true;
            }
            int n3 = view.getWidth();
            if (bl) {
                n3 = -n3;
            }
            view.offsetLeftAndRight(n3);
            view.setAlpha(0.0f);
            SwipeDismissBehavior.b b2 = this.a.b;
            if (b2 != null) {
                b2.a(view);
            }
            return true;
        }
        return false;
    }
}

