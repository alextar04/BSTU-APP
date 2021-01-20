/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.Window
 */
package f.b.k;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import f.b.k.n;
import f.l.d.c;

public class o
extends c {
    @Override
    public void A0(Dialog dialog, int n2) {
        if (dialog instanceof n) {
            n n3 = (n)dialog;
            if (n2 != 1 && n2 != 2) {
                if (n2 != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            n3.c(1);
            return;
        }
        super.A0(dialog, n2);
    }

    @Override
    public Dialog y0(Bundle bundle) {
        return new n(this.o(), this.x0());
    }
}

