/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  c.e.a.a.v.o
 *  com.google.android.material.internal.CheckableImageButton
 *  java.lang.Object
 */
package c.e.a.a.v;

import android.view.View;
import android.widget.Button;
import c.e.a.a.v.d;
import c.e.a.a.v.o;
import com.google.android.material.internal.CheckableImageButton;

public class p
implements View.OnClickListener {
    public final /* synthetic */ o e;

    public p(o o2) {
        this.e = o2;
    }

    public void onClick(View view) {
        o o2 = this.e;
        o2.D0.setEnabled(o2.s0.p());
        this.e.B0.toggle();
        o o3 = this.e;
        o3.H0(o3.B0);
        this.e.E0();
    }
}

