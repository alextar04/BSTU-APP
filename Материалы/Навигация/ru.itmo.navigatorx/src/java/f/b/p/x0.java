/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window$Callback
 *  androidx.appcompat.widget.Toolbar
 *  f.b.o.i.a
 *  f.b.p.y0
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.b.p;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import f.b.o.i.a;
import f.b.p.y0;

public class x0
implements View.OnClickListener {
    public final a e;
    public final /* synthetic */ y0 f;

    public x0(y0 y02) {
        a a2;
        this.f = y02;
        this.e = a2 = new a(this.f.a.getContext(), 0, 16908332, 0, this.f.i);
    }

    public void onClick(View view) {
        y0 y02 = this.f;
        Window.Callback callback = y02.l;
        if (callback != null && y02.m) {
            callback.onMenuItemSelected(0, (MenuItem)this.e);
        }
    }
}

