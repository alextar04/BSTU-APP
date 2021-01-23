/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.j;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.a.b.d;
import c.a.a.n;
import h.m.b.f;
import h.m.b.j;

public abstract class e
extends n {
    public ImageView b;
    public TextView c;
    public View d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public String i;
    public boolean j;
    public final b.a.a.a.a.j.b k;

    public e(View view, b.a.a.a.a.j.b b2, f f2) {
        super(view);
        this.k = b2;
        View view2 = view.findViewById(2131230933);
        j.d((Object)view2, "view.findViewById(R.id.marker_pointer)");
        this.b = (ImageView)view2;
        View view3 = view.findViewById(2131230934);
        j.d((Object)view3, "view.findViewById(R.id.marker_text)");
        this.c = (TextView)view3;
        View view4 = view.findViewById(2131230932);
        j.d((Object)view4, "view.findViewById(R.id.marker_hitbox)");
        this.d = view4;
    }

    public abstract int a(b.a.a.a.a.j.c var1);

    public abstract String b(b.a.a.a.a.j.c var1);

    public final void c() {
        View view = this.a;
        view.clearAnimation();
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().setDuration((long)this.a.getResources().getInteger(2131296258)).alpha(1.0f).start();
        this.h = true;
    }

}

