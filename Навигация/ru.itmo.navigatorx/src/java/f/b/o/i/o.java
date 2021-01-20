/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package f.b.o.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import f.b.o.i.c;
import f.e.h;
import f.h.g.a.a;
import f.h.g.a.b;

public class o
extends c
implements Menu {
    public final a d;

    public o(Context context, a a2) {
        super(context);
        if (a2 != null) {
            this.d = a2;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int n2) {
        return this.c(this.d.add(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.c(this.d.add(n2, n3, n4, n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.c(this.d.add(n2, n3, n4, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return this.c(this.d.add(charSequence));
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] arrintent, Intent intent, int n5, MenuItem[] arrmenuItem) {
        MenuItem[] arrmenuItem2 = arrmenuItem != null ? new MenuItem[arrmenuItem.length] : null;
        int n6 = this.d.addIntentOptions(n2, n3, n4, componentName, arrintent, intent, n5, arrmenuItem2);
        if (arrmenuItem2 != null) {
            int n7 = arrmenuItem2.length;
            for (int i2 = 0; i2 < n7; ++i2) {
                arrmenuItem[i2] = this.c(arrmenuItem2[i2]);
            }
        }
        return n6;
    }

    public SubMenu addSubMenu(int n2) {
        return this.d(this.d.addSubMenu(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.d(this.d.addSubMenu(n2, n3, n4, n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        return this.d(this.d.addSubMenu(n2, n3, n4, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.d(this.d.addSubMenu(charSequence));
    }

    public void clear() {
        h<f.h.g.a.c, SubMenu> h2;
        h<b, MenuItem> h3 = this.b;
        if (h3 != null) {
            h3.clear();
        }
        if ((h2 = this.c) != null) {
            h2.clear();
        }
        this.d.clear();
    }

    public void close() {
        this.d.close();
    }

    public MenuItem findItem(int n2) {
        return this.c(this.d.findItem(n2));
    }

    public MenuItem getItem(int n2) {
        return this.c(this.d.getItem(n2));
    }

    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        return this.d.isShortcutKey(n2, keyEvent);
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return this.d.performIdentifierAction(n2, n3);
    }

    public boolean performShortcut(int n2, KeyEvent keyEvent, int n3) {
        return this.d.performShortcut(n2, keyEvent, n3);
    }

    public void removeGroup(int n2) {
        if (this.b != null) {
            int n3 = 0;
            do {
                h<b, MenuItem> h2 = this.b;
                if (n3 >= h2.g) break;
                if (h2.h(n3).getGroupId() == n2) {
                    this.b.j(n3);
                    --n3;
                }
                ++n3;
            } while (true);
        }
        this.d.removeGroup(n2);
    }

    public void removeItem(int n2) {
        if (this.b != null) {
            int n3 = 0;
            do {
                h<b, MenuItem> h2 = this.b;
                if (n3 >= h2.g) break;
                if (h2.h(n3).getItemId() == n2) {
                    this.b.j(n3);
                    break;
                }
                ++n3;
            } while (true);
        }
        this.d.removeItem(n2);
    }

    public void setGroupCheckable(int n2, boolean bl, boolean bl2) {
        this.d.setGroupCheckable(n2, bl, bl2);
    }

    public void setGroupEnabled(int n2, boolean bl) {
        this.d.setGroupEnabled(n2, bl);
    }

    public void setGroupVisible(int n2, boolean bl) {
        this.d.setGroupVisible(n2, bl);
    }

    public void setQwertyMode(boolean bl) {
        this.d.setQwertyMode(bl);
    }

    public int size() {
        return this.d.size();
    }
}

