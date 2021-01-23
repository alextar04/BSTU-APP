/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Bundle
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.Window$Callback
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package f.b.k;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import f.b.k.f;
import f.b.k.g;
import f.b.k.h;
import f.b.o.a;
import f.h.l.d;

public class n
extends Dialog
implements f {
    public g e;
    public final d.a f;

    public n(Context context, int n2) {
        int n3;
        if (n2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(f.b.a.dialogTheme, typedValue, true);
            n3 = typedValue.resourceId;
        } else {
            n3 = n2;
        }
        super(context, n3);
        this.f = new d.a(){

            @Override
            public boolean d(KeyEvent keyEvent) {
                return n.this.b(keyEvent);
            }
        };
        g g2 = this.a();
        if (n2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(f.b.a.dialogTheme, typedValue, true);
            n2 = typedValue.resourceId;
        }
        ((h)g2).R = n2;
        g2.h(null);
    }

    public g a() {
        if (this.e == null) {
            this.e = g.e(this, this);
        }
        return this.e;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().c(view, layoutParams);
    }

    public boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean c(int n2) {
        return this.a().k(n2);
    }

    public void dismiss() {
        super.dismiss();
        this.a().i();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        return d.a(this.f, view, (Window.Callback)this, keyEvent);
    }

    @Override
    public void f(f.b.o.a a2) {
    }

    public <T extends View> T findViewById(int n2) {
        h h2 = (h)this.a();
        h2.z();
        return (T)h2.i.findViewById(n2);
    }

    @Override
    public void h(f.b.o.a a2) {
    }

    @Override
    public f.b.o.a i(a.a a2) {
        return null;
    }

    public void invalidateOptionsMenu() {
        this.a().g();
    }

    public void onCreate(Bundle bundle) {
        this.a().f();
        super.onCreate(bundle);
        this.a().h(bundle);
    }

    public void onStop() {
        super.onStop();
        h h2 = (h)this.a();
        h2.O = false;
        h2.F();
        f.b.k.a a2 = h2.l;
        if (a2 != null) {
            a2.h(false);
        }
    }

    public void setContentView(int n2) {
        this.a().l(n2);
    }

    public void setContentView(View view) {
        this.a().m(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.a().n(view, layoutParams);
    }

    public void setTitle(int n2) {
        super.setTitle(n2);
        this.a().o(this.getContext().getString(n2));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a().o(charSequence);
    }

}

