/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 *  f.b.o.i.o
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.b.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import f.b.o.a;
import f.b.o.i.o;

public class e
extends ActionMode {
    public final Context a;
    public final a b;

    public e(Context context, a a2) {
        this.a = context;
        this.b = a2;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.d();
    }

    public Menu getMenu() {
        return new o(this.a, (f.h.g.a.a)this.b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.e;
    }

    public CharSequence getTitle() {
        return this.b.h();
    }

    public boolean getTitleOptionalHint() {
        return this.b.f;
    }

    public void invalidate() {
        this.b.i();
    }

    public boolean isTitleOptional() {
        return this.b.j();
    }

    public void setCustomView(View view) {
        this.b.k(view);
    }

    public void setSubtitle(int n2) {
        this.b.l(n2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.m(charSequence);
    }

    public void setTag(Object object) {
        this.b.e = object;
    }

    public void setTitle(int n2) {
        this.b.n(n2);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    public void setTitleOptionalHint(boolean bl) {
        this.b.p(bl);
    }
}

