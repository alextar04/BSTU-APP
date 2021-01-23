/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.widget.ActionBarContextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package f.b.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import f.b.o.a;
import f.b.o.f;
import f.b.o.i.g;
import f.b.p.c;
import java.lang.ref.WeakReference;

public class d
extends a
implements g.a {
    public Context g;
    public ActionBarContextView h;
    public a.a i;
    public WeakReference<View> j;
    public boolean k;
    public g l;

    public d(Context context, ActionBarContextView actionBarContextView, a.a a2, boolean bl) {
        this.g = context;
        this.h = actionBarContextView;
        this.i = a2;
        g g2 = new g(actionBarContextView.getContext());
        g2.l = 1;
        this.l = g2;
        g2.e = this;
    }

    @Override
    public boolean a(g g2, MenuItem menuItem) {
        return this.i.b(this, menuItem);
    }

    @Override
    public void b(g g2) {
        this.i();
        c c2 = this.h.h;
        if (c2 != null) {
            c2.n();
        }
    }

    @Override
    public void c() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.h.sendAccessibilityEvent(32);
        this.i.d(this);
    }

    @Override
    public View d() {
        WeakReference<View> weakReference = this.j;
        if (weakReference != null) {
            return (View)weakReference.get();
        }
        return null;
    }

    @Override
    public Menu e() {
        return this.l;
    }

    @Override
    public MenuInflater f() {
        return new f(this.h.getContext());
    }

    @Override
    public CharSequence g() {
        return this.h.getSubtitle();
    }

    @Override
    public CharSequence h() {
        return this.h.getTitle();
    }

    @Override
    public void i() {
        this.i.a(this, this.l);
    }

    @Override
    public boolean j() {
        return this.h.v;
    }

    @Override
    public void k(View view) {
        this.h.setCustomView(view);
        WeakReference weakReference = view != null ? new WeakReference((Object)view) : null;
        this.j = weakReference;
    }

    @Override
    public void l(int n2) {
        String string = this.g.getString(n2);
        this.h.setSubtitle((CharSequence)string);
    }

    @Override
    public void m(CharSequence charSequence) {
        this.h.setSubtitle(charSequence);
    }

    @Override
    public void n(int n2) {
        String string = this.g.getString(n2);
        this.h.setTitle((CharSequence)string);
    }

    @Override
    public void o(CharSequence charSequence) {
        this.h.setTitle(charSequence);
    }

    @Override
    public void p(boolean bl) {
        this.f = bl;
        this.h.setTitleOptional(bl);
    }
}

