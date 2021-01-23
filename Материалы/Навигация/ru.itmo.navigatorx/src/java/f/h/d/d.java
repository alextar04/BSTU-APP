/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 *  f.h.l.l
 *  f.n.g
 *  f.n.g$b
 *  f.n.m
 *  f.n.x
 */
package f.h.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import f.h.l.d;
import f.h.l.l;
import f.n.g;
import f.n.m;
import f.n.o;
import f.n.x;

public class d
extends Activity
implements m,
d.a {
    public o e = new o(this);

    @Override
    public boolean d(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view != null && l.d((View)view, (KeyEvent)keyEvent)) {
            return true;
        }
        return f.h.l.d.a(this, view, (Window.Callback)this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view != null && l.d((View)view, (KeyEvent)keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @SuppressLint(value={"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d((Activity)this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.e.f(g.b.g);
        super.onSaveInstanceState(bundle);
    }
}

