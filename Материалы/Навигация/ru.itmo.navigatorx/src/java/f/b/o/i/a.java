/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.ActionProvider
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package f.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import f.h.g.a.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements b {
    public final int a;
    public final int b;
    public final int c;
    public CharSequence d;
    public CharSequence e;
    public Intent f;
    public char g;
    public int h = 4096;
    public char i;
    public int j = 4096;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;
    public ColorStateList o = null;
    public PorterDuff.Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    public a(Context context, int n2, int n3, int n4, CharSequence charSequence) {
        this.l = context;
        this.a = n3;
        this.b = n2;
        this.c = n4;
        this.d = charSequence;
    }

    @Override
    public b a(f.h.l.b b2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public f.h.l.b b() {
        return null;
    }

    public final void c() {
        if (this.k != null && (this.q || this.r)) {
            Drawable drawable;
            Drawable drawable2;
            this.k = drawable = this.k;
            this.k = drawable2 = drawable.mutate();
            if (this.q) {
                drawable2.setTintList(this.o);
            }
            if (this.r) {
                this.k.setTintMode(this.p);
            }
        }
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override
    public View getActionView() {
        return null;
    }

    @Override
    public int getAlphabeticModifiers() {
        return this.j;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override
    public CharSequence getContentDescription() {
        return this.m;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.k;
    }

    @Override
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    public Intent getIntent() {
        return this.f;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public int getNumericModifiers() {
        return this.h;
    }

    public char getNumericShortcut() {
        return this.g;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence;
        }
        return this.d;
    }

    @Override
    public CharSequence getTooltipText() {
        return this.n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (1 & this.s) != 0;
    }

    public boolean isChecked() {
        return (2 & this.s) != 0;
    }

    public boolean isEnabled() {
        return (16 & this.s) != 0;
    }

    public boolean isVisible() {
        return (8 & this.s) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MenuItem setActionView(int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase((char)c2);
        return this;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        this.i = Character.toLowerCase((char)c2);
        this.j = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        this.s = bl | -2 & this.s;
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        int n2 = -3 & this.s;
        int n3 = bl ? 2 : 0;
        this.s = n3 | n2;
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override
    public b setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        int n2 = -17 & this.s;
        int n3 = bl ? 16 : 0;
        this.s = n3 | n2;
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.k = f.h.e.a.c(this.l, n2);
        this.c();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        this.c();
        return this;
    }

    @Override
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        this.c();
        return this;
    }

    @Override
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        this.c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char c2, int n2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase((char)c3);
        return this;
    }

    @Override
    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState((int)n2);
        this.i = Character.toLowerCase((char)c3);
        this.j = KeyEvent.normalizeMetaState((int)n3);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
    }

    @Override
    public MenuItem setShowAsActionFlags(int n2) {
        return this;
    }

    public MenuItem setTitle(int n2) {
        this.d = this.l.getResources().getString(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override
    public b setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        int n2 = this.s;
        int n3 = 8;
        int n4 = n2 & n3;
        if (bl) {
            n3 = 0;
        }
        this.s = n4 | n3;
        return this;
    }
}

