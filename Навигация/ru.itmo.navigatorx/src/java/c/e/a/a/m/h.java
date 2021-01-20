/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  f.h.l.l
 *  java.lang.Object
 */
package c.e.a.a.m;

import android.view.View;
import f.h.l.l;

public class h {
    public final View a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f = true;
    public boolean g = true;

    public h(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        l.G((View)view, (int)(this.d - (view.getTop() - this.b)));
        View view2 = this.a;
        view2.offsetLeftAndRight(this.e - (view2.getLeft() - this.c));
    }
}

