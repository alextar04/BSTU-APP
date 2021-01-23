/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.ActionProvider
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewDebug
 *  android.view.ViewDebug$CapturedViewProperty
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 */
package f.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import f.b.o.i.g;
import f.b.o.i.r;
import f.h.g.a.b;
import f.h.l.b;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class i
implements b {
    public f.h.l.b A;
    public MenuItem.OnActionExpandListener B;
    public boolean C = false;
    public ContextMenu.ContextMenuInfo D;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public int i = 4096;
    public char j;
    public int k = 4096;
    public Drawable l;
    public int m = 0;
    public g n;
    public r o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public ColorStateList s = null;
    public PorterDuff.Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public int y = 0;
    public View z;

    public i(g g2, int n2, int n3, int n4, int n5, CharSequence charSequence, int n6) {
        this.n = g2;
        this.a = n3;
        this.b = n2;
        this.c = n4;
        this.d = n5;
        this.e = charSequence;
        this.y = n6;
    }

    public static void c(StringBuilder stringBuilder, int n2, int n3, String string) {
        if ((n2 & n3) == n3) {
            stringBuilder.append(string);
        }
    }

    @Override
    public b a(f.h.l.b b2) {
        f.h.l.b b3 = this.A;
        if (b3 != null) {
            b3.a = null;
        }
        this.z = null;
        this.A = b2;
        this.n.q(true);
        f.h.l.b b4 = this.A;
        if (b4 != null) {
            b4.d(new b.a(){});
        }
        return this;
    }

    @Override
    public f.h.l.b b() {
        return this.A;
    }

    @Override
    public boolean collapseActionView() {
        if ((8 & this.y) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) {
            return false;
        }
        return this.n.d(this);
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.w && (this.u || this.v)) {
            drawable = drawable.mutate();
            if (this.u) {
                drawable.setTintList(this.s);
            }
            if (this.v) {
                drawable.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable;
    }

    public char e() {
        if (this.n.n()) {
            return this.j;
        }
        return this.h;
    }

    @Override
    public boolean expandActionView() {
        if (!this.f()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand((MenuItem)this)) {
            return false;
        }
        return this.n.f(this);
    }

    public boolean f() {
        int n2 = 8 & this.y;
        boolean bl = false;
        if (n2 != 0) {
            f.h.l.b b2;
            if (this.z == null && (b2 = this.A) != null) {
                this.z = b2.b(this);
            }
            View view = this.z;
            bl = false;
            if (view != null) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean g() {
        return (32 & this.x) == 32;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override
    public View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        f.h.l.b b2 = this.A;
        if (b2 != null) {
            View view2;
            this.z = view2 = b2.b(this);
            return view2;
        }
        return null;
    }

    @Override
    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override
    public CharSequence getContentDescription() {
        return this.q;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return this.d(drawable);
        }
        int n2 = this.m;
        if (n2 != 0) {
            Drawable drawable2 = f.b.l.a.a.b(this.n.a, n2);
            this.m = 0;
            this.l = drawable2;
            return this.d(drawable2);
        }
        return null;
    }

    @Override
    public ColorStateList getIconTintList() {
        return this.s;
    }

    @Override
    public PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    @Override
    public int getNumericModifiers() {
        return this.i;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            return charSequence;
        }
        return this.e;
    }

    @Override
    public CharSequence getTooltipText() {
        return this.r;
    }

    public boolean h() {
        return (4 & this.x) != 0;
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public b i(View view) {
        int n2;
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (n2 = this.a) > 0) {
            view.setId(n2);
        }
        this.n.p();
        return this;
    }

    @Override
    public boolean isActionViewExpanded() {
        return this.C;
    }

    public boolean isCheckable() {
        return (1 & this.x) == 1;
    }

    public boolean isChecked() {
        return (2 & this.x) == 2;
    }

    public boolean isEnabled() {
        return (16 & this.x) != 0;
    }

    public boolean isVisible() {
        f.h.l.b b2 = this.A;
        if (b2 != null && b2.c()) {
            return (8 & this.x) == 0 && this.A.a();
        }
        return (8 & this.x) == 0;
    }

    public void j(boolean bl) {
        int n2;
        int n3 = this.x;
        int n4 = n3 & -3;
        int n5 = bl ? 2 : 0;
        this.x = n2 = n5 | n4;
        if (n3 != n2) {
            this.n.q(false);
        }
    }

    public void k(boolean bl) {
        int n2 = bl ? 32 | this.x : -33 & this.x;
        this.x = n2;
    }

    public boolean l(boolean bl) {
        int n2;
        int n3 = this.x;
        int n4 = n3 & -9;
        int n5 = bl ? 0 : 8;
        this.x = n2 = n5 | n4;
        boolean bl2 = false;
        if (n3 != n2) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean m() {
        return this.n.o() && this.e() != '\u0000';
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override
    public MenuItem setActionView(int n2) {
        Context context = this.n.a;
        this.i(LayoutInflater.from((Context)context).inflate(n2, (ViewGroup)new LinearLayout(context), false));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.j == c2) {
            return this;
        }
        this.j = Character.toLowerCase((char)c2);
        this.n.q(false);
        return this;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        if (this.j == c2 && this.k == n2) {
            return this;
        }
        this.j = Character.toLowerCase((char)c2);
        this.k = KeyEvent.normalizeMetaState((int)n2);
        this.n.q(false);
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        int n2;
        int n3 = this.x;
        this.x = n2 = bl | n3 & -2;
        if (n3 != n2) {
            this.n.q(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        if ((4 & this.x) != 0) {
            g g2 = this.n;
            if (g2 != null) {
                int n2 = this.getGroupId();
                int n3 = g2.f.size();
                g2.z();
                for (int i2 = 0; i2 < n3; ++i2) {
                    i i3 = (i)g2.f.get(i2);
                    if (i3.b != n2 || !i3.h() || !i3.isCheckable()) continue;
                    boolean bl2 = i3 == this;
                    i3.j(bl2);
                }
                g2.y();
                return this;
            }
            throw null;
        }
        this.j(bl);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    @Override
    public b setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        int n2 = bl ? 16 | this.x : -17 & this.x;
        this.x = n2;
        this.n.q(false);
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.l = null;
        this.m = n2;
        this.w = true;
        this.n.q(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.u = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.t = mode;
        this.v = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.n.q(false);
        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char c2, int n2) {
        if (this.h == c2 && this.i == n2) {
            return this;
        }
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState((int)n2);
        this.n.q(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase((char)c3);
        this.n.q(false);
        return this;
    }

    @Override
    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState((int)n2);
        this.j = Character.toLowerCase((char)c3);
        this.k = KeyEvent.normalizeMetaState((int)n3);
        this.n.q(false);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
        int n3 = n2 & 3;
        if (n3 != 0 && n3 != 1 && n3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = n2;
        this.n.p();
    }

    @Override
    public MenuItem setShowAsActionFlags(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    public MenuItem setTitle(int n2) {
        this.setTitle(this.n.a.getString(n2));
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.q(false);
        r r2 = this.o;
        if (r2 != null) {
            r2.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.q(false);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    @Override
    public b setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        if (this.l(bl)) {
            g g2 = this.n;
            g2.h = true;
            g2.q(true);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

}

