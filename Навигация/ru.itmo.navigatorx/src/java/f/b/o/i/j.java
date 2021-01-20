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
 *  android.view.ActionProvider$VisibilityListener
 *  android.view.CollapsibleActionView
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.widget.FrameLayout
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package f.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import f.b.o.i.g;
import f.b.o.i.i;
import f.h.l.b;
import java.lang.reflect.Method;

public class j
extends f.b.o.i.c
implements MenuItem {
    public final f.h.g.a.b d;
    public Method e;

    public j(Context context, f.h.g.a.b b2) {
        super(context);
        if (b2 != null) {
            this.d = b2;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        f.h.l.b b2 = this.d.b();
        if (b2 instanceof a) {
            return ((a)b2).b;
        }
        return null;
    }

    public View getActionView() {
        View view = this.d.getActionView();
        if (view instanceof c) {
            view = (View)((c)view).e;
        }
        return view;
    }

    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    public int getGroupId() {
        return this.d.getGroupId();
    }

    public Drawable getIcon() {
        return this.d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.d.getIntent();
    }

    public int getItemId() {
        return this.d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    public int getOrder() {
        return this.d.getOrder();
    }

    public SubMenu getSubMenu() {
        return this.d(this.d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    public boolean isChecked() {
        return this.d.isChecked();
    }

    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    public boolean isVisible() {
        return this.d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ActionProvider.VisibilityListener visibilityListener = new ActionProvider.VisibilityListener(this, this.a, actionProvider){
            public b.a d;

            @Override
            public boolean a() {
                return this.b.isVisible();
            }

            @Override
            public View b(MenuItem menuItem) {
                return this.b.onCreateActionView(menuItem);
            }

            @Override
            public boolean c() {
                return this.b.overridesItemVisibility();
            }

            @Override
            public void d(b.a a2) {
                this.d = a2;
                this.b.setVisibilityListener((ActionProvider.VisibilityListener)this);
            }

            public void onActionProviderVisibilityChanged(boolean bl) {
                b.a a2 = this.d;
                if (a2 != null) {
                    g g2 = (a2).i.this.n;
                    g2.h = true;
                    g2.q(true);
                }
            }
        };
        f.h.g.a.b b2 = this.d;
        if (actionProvider == null) {
            visibilityListener = null;
        }
        b2.a((f.h.l.b)visibilityListener);
        return this;
    }

    public MenuItem setActionView(int n2) {
        this.d.setActionView(n2);
        View view = this.d.getActionView();
        if (view instanceof CollapsibleActionView) {
            this.d.setActionView((View)new c(view));
        }
        return this;
    }

    public MenuItem setActionView(View object) {
        if (object instanceof CollapsibleActionView) {
            object = new c((View)object);
        }
        this.d.setActionView((View)object);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        this.d.setAlphabeticShortcut(c2, n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        this.d.setCheckable(bl);
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        this.d.setChecked(bl);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        this.d.setEnabled(bl);
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.d.setIcon(n2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int n2) {
        this.d.setNumericShortcut(c2, n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        f.h.g.a.b b2 = this.d;
        MenuItem.OnActionExpandListener onActionExpandListener2 = onActionExpandListener != null ? new MenuItem.OnActionExpandListener(onActionExpandListener){
            public final MenuItem.OnActionExpandListener a;
            {
                this.a = onActionExpandListener;
            }

            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return this.a.onMenuItemActionCollapse(j.this.c(menuItem));
            }

            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return this.a.onMenuItemActionExpand(j.this.c(menuItem));
            }
        } : null;
        b2.setOnActionExpandListener(onActionExpandListener2);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        f.h.g.a.b b2 = this.d;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener2 = onMenuItemClickListener != null ? new MenuItem.OnMenuItemClickListener(onMenuItemClickListener){
            public final MenuItem.OnMenuItemClickListener a;
            {
                this.a = onMenuItemClickListener;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.onMenuItemClick(j.this.c(menuItem));
            }
        } : null;
        b2.setOnMenuItemClickListener(onMenuItemClickListener2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.d.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.d.setShortcut(c2, c3, n2, n3);
        return this;
    }

    public void setShowAsAction(int n2) {
        this.d.setShowAsAction(n2);
    }

    public MenuItem setShowAsActionFlags(int n2) {
        this.d.setShowAsActionFlags(n2);
        return this;
    }

    public MenuItem setTitle(int n2) {
        this.d.setTitle(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        return this.d.setVisible(bl);
    }

    public class a
    extends f.h.l.b {
        public final ActionProvider b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.b = actionProvider;
        }
    }

    public static class c
    extends FrameLayout
    implements f.b.o.b {
        public final CollapsibleActionView e;

        public c(View view) {
            super(view.getContext());
            this.e = (CollapsibleActionView)view;
            this.addView(view);
        }

        @Override
        public void c() {
            this.e.onActionViewExpanded();
        }

        @Override
        public void f() {
            this.e.onActionViewCollapsed();
        }
    }

}

