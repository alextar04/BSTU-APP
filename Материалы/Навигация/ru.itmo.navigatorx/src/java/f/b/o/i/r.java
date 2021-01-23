/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  f.b.o.i.g
 *  f.b.o.i.i
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.b.o.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import f.b.o.i.g;
import f.b.o.i.i;

public class r
extends g
implements SubMenu {
    public g A;
    public i B;

    public r(Context context, g g2, i i2) {
        super(context);
        this.A = g2;
        this.B = i2;
    }

    public boolean d(i i2) {
        return this.A.d(i2);
    }

    public boolean e(g g2, MenuItem menuItem) {
        return super.e(g2, menuItem) || this.A.e(g2, menuItem);
        {
        }
    }

    public boolean f(i i2) {
        return this.A.f(i2);
    }

    public MenuItem getItem() {
        return this.B;
    }

    public String j() {
        i i2 = this.B;
        int n2 = i2 != null ? i2.a : 0;
        if (n2 == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:menu:actionviewstates");
        stringBuilder.append(":");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public g k() {
        return this.A.k();
    }

    public boolean m() {
        return this.A.m();
    }

    public boolean n() {
        return this.A.n();
    }

    public boolean o() {
        return this.A.o();
    }

    public void setGroupDividerEnabled(boolean bl) {
        this.A.setGroupDividerEnabled(bl);
    }

    public SubMenu setHeaderIcon(int n2) {
        this.x(0, null, n2, null, null);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.x(0, null, 0, drawable, null);
        return this;
    }

    public SubMenu setHeaderTitle(int n2) {
        this.x(n2, null, 0, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.x(0, charSequence, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.x(0, null, 0, null, view);
        return this;
    }

    public SubMenu setIcon(int n2) {
        this.B.setIcon(n2);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.B.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean bl) {
        this.A.setQwertyMode(bl);
    }
}

