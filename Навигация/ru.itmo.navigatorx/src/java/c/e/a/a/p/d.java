/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.widget.FrameLayout
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 */
package c.e.a.a.p;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import c.e.a.a.p.c;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import f.b.k.o;

public class d
extends o {
    public void B0() {
        Dialog dialog = this.j0;
        if (dialog instanceof c) {
            c c2 = (c)dialog;
            if (c2.g == null) {
                c2.d();
            }
        }
        this.w0(false, false);
    }

    @Override
    public Dialog y0(Bundle bundle) {
        return new c(this.o(), this.x0());
    }
}

