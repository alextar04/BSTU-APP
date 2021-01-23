/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  f.b.o.i.j
 *  f.b.o.i.s
 *  f.h.g.a.c
 *  java.lang.Object
 */
package f.b.o.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import f.b.o.i.j;
import f.b.o.i.s;
import f.e.h;
import f.h.g.a.b;

public abstract class c {
    public final Context a;
    public h<b, MenuItem> b;
    public h<f.h.g.a.c, SubMenu> c;

    public c(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof b) {
            b b2 = (b)menuItem;
            if (this.b == null) {
                this.b = new h();
            }
            if ((menuItem = (MenuItem)this.b.getOrDefault((Object)menuItem, null)) == null) {
                menuItem = new j(this.a, b2);
                this.b.put(b2, menuItem);
            }
        }
        return menuItem;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof f.h.g.a.c) {
            SubMenu subMenu2;
            f.h.g.a.c c2 = (f.h.g.a.c)subMenu;
            if (this.c == null) {
                this.c = new h();
            }
            if ((subMenu2 = this.c.get((Object)c2)) == null) {
                subMenu2 = new s(this.a, c2);
                this.c.put(c2, subMenu2);
            }
            return subMenu2;
        }
        return subMenu;
    }
}

