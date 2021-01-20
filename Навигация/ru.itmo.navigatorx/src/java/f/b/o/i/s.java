/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  f.b.o.i.o
 *  f.h.g.a.c
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package f.b.o.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import f.b.o.i.c;
import f.b.o.i.o;
import f.h.g.a.a;

public class s
extends o
implements SubMenu {
    public final f.h.g.a.c e;

    public s(Context context, f.h.g.a.c c2) {
        super(context, (a)c2);
        this.e = c2;
    }

    public void clearHeader() {
        this.e.clearHeader();
    }

    public MenuItem getItem() {
        return ((c)((Object)this)).c(this.e.getItem());
    }

    public SubMenu setHeaderIcon(int n2) {
        this.e.setHeaderIcon(n2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int n2) {
        this.e.setHeaderTitle(n2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int n2) {
        this.e.setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }
}

