/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 *  android.view.KeyEvent$DispatcherState
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  android.widget.ListAdapter
 *  java.lang.Object
 */
package f.b.o.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import f.b.k.d;
import f.b.o.i.e;
import f.b.o.i.g;
import f.b.o.i.i;
import f.b.o.i.m;

public class h
implements DialogInterface.OnKeyListener,
DialogInterface.OnClickListener,
DialogInterface.OnDismissListener,
m.a {
    public g e;
    public d f;
    public e g;

    public h(g g2) {
        this.e = g2;
    }

    @Override
    public void a(g g2, boolean bl) {
        d d2;
        if ((bl || g2 == this.e) && (d2 = this.f) != null) {
            d2.dismiss();
        }
    }

    @Override
    public boolean b(g g2) {
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.e.r((this.g.b()).b(n2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e e2 = this.g;
        g g2 = this.e;
        m.a a2 = e2.l;
        if (a2 != null) {
            a2.a(g2, true);
        }
    }

    public boolean onKey(DialogInterface dialogInterface, int n2, KeyEvent keyEvent) {
        if (n2 == 82 || n2 == 4) {
            Window window;
            KeyEvent.DispatcherState dispatcherState;
            View view;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                View view2;
                KeyEvent.DispatcherState dispatcherState2;
                Window window2 = this.f.getWindow();
                if (window2 != null && (view2 = window2.getDecorView()) != null && (dispatcherState2 = view2.getKeyDispatcherState()) != null) {
                    dispatcherState2.startTracking(keyEvent, (Object)this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f.getWindow()) != null && (view = window.getDecorView()) != null && (dispatcherState = view.getKeyDispatcherState()) != null && dispatcherState.isTracking(keyEvent)) {
                this.e.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.e.performShortcut(n2, keyEvent, 0);
    }
}

