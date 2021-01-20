/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.view.View
 */
package f.b.p;

import android.annotation.SuppressLint;
import android.view.View;
import f.b.o.i.p;
import f.b.p.g0;
import f.b.p.v;

public class u
extends g0 {
    public final /* synthetic */ v.d n;
    public final /* synthetic */ v o;

    public u(v v2, View view, v.d d2) {
        this.o = v2;
        this.n = d2;
        super(view);
    }

    @Override
    public p b() {
        return this.n;
    }

    @SuppressLint(value={"SyntheticAccessor"})
    @Override
    public boolean c() {
        if (!this.o.getInternalPopup().b()) {
            this.o.b();
        }
        return true;
    }
}

